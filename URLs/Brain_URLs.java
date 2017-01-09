package URLs;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;
import java.util.Map;

import Control.Controller;
import Interfaces.Interface_URLs;
import Searching.Object_SearchJob;

public class Brain_URLs implements Interface_URLs {
	
	Controller Class_Controller;

	Object_TreeMap[]		Tree_URLFind;
	
	Thread_URLFinder[]		URLThreads;
	
	public boolean					Loading = true;
	
	//String SearchType;
	Thread_URLsLoader Loader;
	
	int Layer = 0;
	
	public Brain_URLs( Controller Class_Controller ) throws Exception {
		//System.out.println( this.getClass().toString()+" constructor" );
		this.Class_Controller = Class_Controller;
		
		Tree_URLFind = new Object_TreeMap[2];
		Tree_URLFind[0] = new Object_TreeMap_String(Class_Controller);
		//Tree_URLFind[0].SaveObject( "", null );
		Tree_URLFind[1] = new Object_TreeMap_int(Class_Controller);
		//Tree_URLFind[1].SaveObject( 0, null );
		
		URLThreads = new Thread_URLFinder[10];
	}
	
	public void LoadURLs_new() throws Exception {
		//Laster inn lagrede URLr
		try {
			//marker innlasting for å stoppe andre prosesser
			Loading = true;
			if ( Loader != null ) {
				//Innlasting er igang fra før. Stopp og begynn på nytt
				Loader.stop();
			}
			String SearchType =  Class_Controller.Get_SelectedSearchtype( this.getClass().toString()+" LoadURL" );
			String Dropshipper = "";
			try {
				Dropshipper = Class_Controller.Get_SelectedDropshipper( this.getClass().toString()+" LoadURLs_new" ).DropshipperName;
			} catch ( Exception T ) {
			}
			//start innlasting
			Loader = new Thread_URLsLoader( Class_Controller, SearchType, Dropshipper );
			Loader.start();
			//marker for å starte andre prosesser
			Loading = false;
		} catch ( Exception T ) {
			Class_Controller.ReportError(T, this.getClass().toString()+" LoadURLs_new B" );
		}
	}
	
	public void RunThreads_URLfind() {
		
		try {
			Class_Controller.Reset_LayerCount_URL();
			//System.out.println( this.getClass().toString()+" RunThreads_URLfind" );
			Tree_URLFind[1] = Class_Controller.Get_TreeMap()[1];
			for ( Map.Entry < Object,Object_SearchJob > e : Tree_URLFind[1].Get_SynchedKart().entrySet() ) {
				Object_SearchJob HentetJobb = (Object_SearchJob) e.getValue();
				//System.out.println( this.getClass().toString()+" RunThreads A HentetJobb="+HentetJobb+" layer ready="+( (Layer - HentetJobb.TargetOffer.Get_Adresse().Layer) > 0 ) );
				if ( HentetJobb != null ) {
					if ( (this.Class_Controller.Get_Layer() - HentetJobb.TargetOffer.Get_Adresse().Layer) >= 0 ) {
						//System.out.println( this.getClass().toString()+" RunThreads B AcceptedCategory="+HentetJobb.TargetOffer.Get_Adresse().Get_AcceptedCategory() );
						if ( HentetJobb.TargetOffer.Get_Adresse().Get_AcceptedCategory() != false ) {
							//System.out.println( this.getClass().toString()+" RunThreads C Download_Finished="+HentetJobb.TargetOffer.Get_Adresse().Download_Finished );
					    	if ( HentetJobb.TargetOffer.Get_Adresse().Download_Finished == true ) {
					    		//System.out.println( this.getClass().toString()+" RunThreads D URLs_Started="+HentetJobb.TargetOffer.Get_Adresse().URLs_Started );
					    		if ( HentetJobb.TargetOffer.Get_Adresse().URLs_Started == false ) {
					    			this.Class_Controller.Increase_LayerCount_URL();
					    			//System.out.println( this.getClass().toString()+" RunThreads E Get_Identify_Finished()="+HentetJobb.Get_Identify_Finished() );
							    	if ( HentetJobb.Get_Identify_Finished() == true ) {
							    		//System.out.println( this.getClass().toString()+" RunThreads F" );
							    		Date Nu = new Date();
							    		Date Da = this.Class_Controller.Get_DropshipperDowntime( HentetJobb.TargetOffer.Get_Adresse().Get_Domain_Lang() );
							    		if ( Da == null ) {
							    			Process_URLs( HentetJobb );
							    			return;
							    		} else {
							    			if ( Nu.getTime() - Da.getTime() > 100*60 ) {
							    				Process_URLs( HentetJobb );
							    				return;
							    			} else {
							    				Class_Controller.SetCurrentAction( "Temp-banned from server" );
							    			}
							    		}
							    	}
					    			//Process_URLs( HentetJobb );
					    		}
					    	}
						}
					}
				}
		    }
		} catch ( Exception T ) {
			
		}
	}
	
	public void Process_URLs( Object_SearchJob HentetJobb ) {
		//System.out.println( this.getClass().toString()+" Process_URLs HentetJobb="+HentetJobb+" adresse="+HentetJobb.Get_Adresse()+" URLs_Started="+HentetJobb.TargetOffer.Get_Adresse().URLs_Started );
		Class_Controller.SetCurrentAction( "Looking for new URLs" );
		for ( int X = 0 ; X < URLThreads.length ; X++ ) {
			if ( URLThreads[X] == null ) {
				Start_URL_Process( X, HentetJobb);
				return;
			} else {
				try {
					URLThreads[X].start();
				} catch ( Exception T ) {
					
				}
				if ( URLThreads[X].Jobb.TargetOffer.Get_Adresse().URLs_Started == false ) {
					return;
				}
				if ( URLThreads[X].Jobb.TargetOffer.Get_Adresse().URLs_Finished == true ) {
					Start_URL_Process( X, HentetJobb);
					return;
				} else {
					//System.out.println( this.getClass().toString()+" Process_Identify_Resultpages B thread#"+X+" started="+URLThreads[X].Jobb.URLs_Started+" finished="+URLThreads[X].Jobb.URLs_Finished+" url="+URLThreads[X].Jobb.Get_Adresse().toString() );
					//let videre etter ledige slots
				}
			}
		}
	}
	
	private void Start_URL_Process( int X, Object_SearchJob HentetJobb) {
		//System.out.println( this.getClass().toString()+" Start_URL_Process HentetJobb="+HentetJobb+" adresse="+HentetJobb.Get_Adresse()+" X="+X+" URLs_Started="+HentetJobb.TargetOffer.Get_Adresse().URLs_Started );
		if ( HentetJobb.TargetOffer.Get_Dropshipsite().equals("focalprice") == true ) {
			URLThreads[X] = new Thread_URLFinder_Focalprice( Class_Controller, HentetJobb );
			URLThreads[X].start();
			return;
		} else if ( HentetJobb.TargetOffer.Get_Dropshipsite().equals("aliexpress") == true ) {
			URLThreads[X] = new Thread_URLFinder_AliExpress( Class_Controller, HentetJobb );
			URLThreads[X].start();
			return;
		} else if ( HentetJobb.TargetOffer.Get_Dropshipsite().equals("dhgate") == true ) {
			URLThreads[X] = new Thread_URLFinder_DHGate( Class_Controller, HentetJobb );
			URLThreads[X].start();
			return;
		} else if ( HentetJobb.TargetOffer.Get_Dropshipsite().equals("1on1dropship") == true ) {
			URLThreads[X] = new Thread_URLFinder_1on1( Class_Controller, HentetJobb );
			URLThreads[X].start();
			return;
		} else if ( HentetJobb.TargetOffer.Get_Dropshipsite().equals("tmart") == true ) {
			URLThreads[X] = new Thread_URLFinder_Tmart( Class_Controller, HentetJobb );
			URLThreads[X].start();
			return;
		} else {
			//System.out.println( this.getClass().toString()+" Process_Identify_Resultpages Finner ikke riktig dropshipper: "+HentetJobb.TargetOffer.Get_Dropshipsite() );
		}
	}
	
	public void Save_SearchJob_URL( Object_SearchJob jobb ) throws Exception {
		//Noterer at URL er funnet
		if ( Tree_URLFind[0].SearchFor( jobb.Get_Adresse().toString() ) == null ) {
			//lagrer til liste over URL'er besøkt
			Tree_URLFind[0] = Class_Controller.ExpandTreeMap_String( (Object_TreeMap_String) Tree_URLFind[0], jobb.Get_Adresse().toString(), jobb );
			//vurderer prioritering
			int Value = jobb.Get_LinkedRelationValue();
			while ( Tree_URLFind[1].SearchFor( Value ) != null ){
				Value --;
			}
			//Lagrer til liste over URL'er som skal sjekkes
			Tree_URLFind[1] = Class_Controller.ExpandTreeMap_int( (Object_TreeMap_int) Tree_URLFind[1], Value, jobb );
		}
	}

	public void Save_SearchJob_URL_Resultpage( Object_SearchJob jobb ) throws Exception {
		//System.out.println( this.getClass().toString()+" Save_DownloadedPage_Resultpage" );
		
		if ( Tree_URLFind[0].SearchFor( jobb.Get_Adresse().toString() ) == null ) {
			//Tree_URLFind[0].SaveObject( jobb.Get_Adresse().toString(), jobb );
			Tree_URLFind[0] = Class_Controller.ExpandTreeMap_String( (Object_TreeMap_String) Tree_URLFind[0], jobb.Get_Adresse().toString(), jobb );
			int Value = jobb.Get_LinkedRelationValue();
			while ( Tree_URLFind[1].SearchFor( Value ) != null ){
				Value --;
			}
			//Tree_URLFind[1].SaveObject( Value, jobb );
			Tree_URLFind[1] = Class_Controller.ExpandTreeMap_int( (Object_TreeMap_int) Tree_URLFind[1], Value, jobb );
		}

	}

	public void Save_SearchJob_URL_Auction( Object_SearchJob jobb ) throws Exception {
		//System.out.println( this.getClass().toString()+" Save_DownloadedPage_Auction" );

		if ( Tree_URLFind[0].SearchFor( jobb.Get_Adresse().toString() ) == null ) {
			//Tree_URLFind[0].SaveObject( jobb.Get_Adresse().toString(), jobb );
			Tree_URLFind[0] = Class_Controller.ExpandTreeMap_String( (Object_TreeMap_String) Tree_URLFind[0], jobb.Get_Adresse().toString(), jobb );
			int Value = jobb.Get_LinkedRelationValue();
			while ( Tree_URLFind[1].SearchFor( Value ) != null ){
				Value --;
			}
			//Tree_URLFind[1].SaveObject( Value, jobb );
			Tree_URLFind[1] = Class_Controller.ExpandTreeMap_int( (Object_TreeMap_int) Tree_URLFind[1], Value, jobb );
		}
	}
	
	public void SaveURLToDisk( Object_URL Adresse ) throws Exception {
		//Lagrer URL med progresjonsinfo til disk
		try {
			File ProductInfo = new File ( "URLs checked\\"+Adresse.SimplifyURL(Adresse.Adresse.toString())+".URLO" );
			try {
				if (!ProductInfo.getParentFile().exists())
					ProductInfo.getParentFile().mkdirs();
				if ( !ProductInfo.exists() ) {
					ProductInfo.createNewFile();
				}	
				ObjectOutputStream Outstream = new ObjectOutputStream ( new BufferedOutputStream ( new FileOutputStream ( "URLs checked\\"+Adresse.SimplifyURL(Adresse.Adresse.toString())+".URLO" ) ) );
				//skriver ut objekt med kun nødvendig informasjon
				Outstream.writeObject ( Adresse );
				Outstream.close ( );
			} catch ( NotSerializableException T ) {
				Class_Controller.ReportError(T, this.getClass().toString()+" SaveURLToDisk C" );
			} catch ( FileNotFoundException T ) {
			} catch ( Exception T ) {
				Class_Controller.ReportError(T, this.getClass().toString()+" SaveURLToDisk A "+"URLs checked\\"+Adresse.SimplifyURL(Adresse.Adresse.toString())+".URLO" );
			}
		} catch ( Exception T ) {
			Class_Controller.ReportError(T, this.getClass().toString()+" SaveURLToDisk B" );
		}
	}

	public boolean IsUrlSavedToDisk(String adresse) {
		try {
			ObjectInputStream objectIn = null;
			FileInputStream Streamen = new FileInputStream ( "URLs checked\\"+adresse+".URLO" ); 
			objectIn = new ObjectInputStream ( new BufferedInputStream ( Streamen ) );
			objectIn.close ( );
			return true;
		} catch ( Exception e ) {
			return false;
		}
	}

}
