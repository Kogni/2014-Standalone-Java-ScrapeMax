package Offers;

import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import Control.Controller;
import Interfaces.Interface_Offers;
import Searching.Object_SearchJob;
import URLs.Object_TreeMap;
import URLs.Object_TreeMap_String;
import URLs.Object_TreeMap_int;

public class Brain_Offers implements Interface_Offers {
	
	Controller Class_Controller;

	Object_TreeMap[]		Tree_Identify;
	
	Thread_Identify[]		IdentifyThreads;
	
	int Layer = 0;
	
	public Brain_Offers( Controller Class_Controller ) throws Exception {
		//System.out.println( this.getClass().toString()+" constructor" );
		this.Class_Controller = Class_Controller;

		Tree_Identify = new Object_TreeMap[2];
		Tree_Identify[0] = new Object_TreeMap_String(Class_Controller);
		Tree_Identify[0].SaveObject( "", null );
		Tree_Identify[1] = new Object_TreeMap_int(Class_Controller);
		Tree_Identify[1].SaveObject( 0, null );
		
		IdentifyThreads = new Thread_Identify[2];
		
	}
	
	public void RunThreads_Offers() throws Exception {
		//System.out.println( this.getClass().toString()+" RunThreads" );
		RunThreads_Identify();

	}
	
	public void RunThreads_Identify() {
		//ser etter produkter som er downloadet men ikke itdentifisert
		int Teller = 0;
		try {
			Class_Controller.Reset_LayerCount_Identify();
			Tree_Identify[1] = Class_Controller.Get_TreeMap()[1];
			for ( Map.Entry < Object,Object_SearchJob > e : Tree_Identify[1].Get_SynchedKart().entrySet() ) {
				Object_SearchJob HentetJobb = (Object_SearchJob) e.getValue();
				//teller antall searchjobs som eksisterer
				Teller ++;
				if ( HentetJobb != null ) {
					if ( (this.Class_Controller.Get_Layer() - HentetJobb.TargetOffer.Get_Adresse().Layer) >= 0 ) {
						//Sjekker at valgte searchjob er i riktig site map layer
						if ( HentetJobb.TargetOffer.Get_Adresse().Download_Finished == true ) {
							if ( HentetJobb.Get_Identify_Finished() == false ) {
								//fant en searchjob som venter på identifisering, sier ifra til GUI
								this.Class_Controller.Increase_LayerCount_Identify();
								if ( HentetJobb.Get_Identify_Started() == false ) {
									if ( HentetJobb.TargetOffer.Get_Adresse().IsImagePage == true ) {
										//Fant en web page som inneholder bilder tilhørende et produkt på en annen web page. Finner tilhørende produkt
										Object_SearchJob Forelderjobb = Class_Controller.Get_Page_ObjectURL( HentetJobb.TargetOffer.Get_Adresse().ParentURL.ParentURL.Get_Adresse().toString() );
										if ( Forelderjobb != null ) {
											if ( Class_Controller.isProductPage( HentetJobb.TargetOffer.Get_Adresse().ParentURL.ParentURL.Get_Adresse().toString() ) == true ) {
												//fant tilhørende produkt. Utfører identifisering av bildet
												Process_Identify( HentetJobb );
												return;
											}
										}
									} else {
										//utfører normal identifisering av produkt
										Process_Identify( HentetJobb );
										return;
									}
								}
							}
				    	}
					}
				}
		    }
		} catch ( Exception T ) {
		}
		//starter alle threads
		for ( int X = 0 ; X < IdentifyThreads.length ; X++ ) {
			if ( IdentifyThreads[X] != null ) {
				try {
					IdentifyThreads[X].start();
				} catch ( Exception T ) {
				}
			}
		}
	}
	
	public void Process_Identify( Object_SearchJob HentetJobb ) throws Exception {
		//System.out.println( this.getClass().toString()+" Process_Identify_Auctions IdentifyThreads_Auctions.length="+IdentifyThreads_Auctions.length );
		//System.out.println( this.getClass().toString()+" Process_Identify_Auctions HentetJobb="+HentetJobb+" adresse="+HentetJobb.Get_Adresse()+" IdentifyThreads_Auctions.length="+IdentifyThreads_Auctions.length );
		Class_Controller.SetCurrentAction( "Starting identification" );
		for ( int X = 0 ; X < IdentifyThreads.length ; X++ ) {
			//System.out.println( this.getClass().toString()+" Process_Identify_Auctions thread#"+X );
			//System.out.println( this.getClass().toString()+" Process_Identify_Auctions thread#"+X+" thread="+IdentifyThreads_Auctions[X] );
			
			if ( IdentifyThreads[X] == null ) {
				//System.out.println( this.getClass().toString()+" Process_Identify_Auctions Starter thread #"+X);
				StartThread_IdentifyAuction( X, HentetJobb );
				return;
				
			} 
			//System.out.println( this.getClass().toString()+" Process_Identify_Auctions thread#"+X+" thread="+IdentifyThreads_Auctions[X]+" status="+IdentifyThreads_Auctions[X].Status );
			//System.out.println( this.getClass().toString()+" Process_Identify_Auctions thread#"+X+" thread="+IdentifyThreads_Auctions[X]+" status="+IdentifyThreads_Auctions[X].Status +" Identify_Finished="+IdentifyThreads_Resultpages[X].Jobb.Identify_Finished );
			//System.out.println( this.getClass().toString()+" Process_Identify_Auctions thread#"+X+" status="+IdentifyThreads_Auctions[X].Status+" Identify_Finished="+IdentifyThreads_Resultpages[X].Jobb.Identify_Finished );
			if ( IdentifyThreads[X].Jobb.Get_Identify_Finished() == true ) {
				StartThread_IdentifyAuction( X, HentetJobb );
				return;
			} 
			if ( IdentifyThreads[X].Status.equalsIgnoreCase("L") ) {
				IdentifyThreads[X].Jobb.Set_Identify_Finished( true, "Status L" );
			} 
			if ( IdentifyThreads[X].Status == null ) {
				try {
					IdentifyThreads[X].start();
				} catch ( Exception T ) {
					
				}
			} else {
				//System.out.println( this.getClass().toString()+" Process_Identify_Auctions thread#"+X+" opptatt, status="+IdentifyThreads_Auctions[X].Status+" Identify_Started="+IdentifyThreads_Auctions[X].Jobb.Identify_Started );
			}
		}
	}

	private void StartThread_IdentifyAuction( int X, Object_SearchJob HentetJobb ) throws Exception {
		//System.out.println( this.getClass().toString()+" StartThread_IdentifyAuction HentetJobb="+HentetJobb );
		if ( HentetJobb.TargetOffer.Get_Dropshipsite().equals("focalprice") == true ) {
			//System.out.println( this.getClass().toString()+" StartThread_IdentifyAuction Starter thread #"+X+" jobb="+HentetJobb.Get_Adresse().toString());
			IdentifyThreads[X] = new Thread_Identify_Focalprice( Class_Controller, HentetJobb );
			IdentifyThreads[X].start();
			return;
		} else if ( HentetJobb.TargetOffer.Get_Dropshipsite().equals("aliexpress") == true ) {
			//System.out.println( this.getClass().toString()+" StartThread_IdentifyAuction Starter thread #"+X+" jobb="+HentetJobb.Get_Adresse().toString());
			IdentifyThreads[X] = new Thread_Identify_AliExpress( Class_Controller, HentetJobb );
			IdentifyThreads[X].start();
			return;
		} else if ( HentetJobb.TargetOffer.Get_Dropshipsite().equals("dhgate") == true ) {
			//System.out.println( this.getClass().toString()+" StartThread_IdentifyAuction Starter thread #"+X+" jobb="+HentetJobb.Get_Adresse().toString());
			IdentifyThreads[X] = new Thread_Identify_DHGate( Class_Controller, HentetJobb );
			IdentifyThreads[X].start();
			return;
		} else if ( HentetJobb.TargetOffer.Get_Dropshipsite().equals("1on1dropship") == true ) {
			//System.out.println( this.getClass().toString()+" Process_Identify_Resultpages C4 Starter thread #"+X);
			IdentifyThreads[X] = new Thread_Identify_1on1( Class_Controller, HentetJobb );
			IdentifyThreads[X].start();
			return;
		} else if ( HentetJobb.TargetOffer.Get_Dropshipsite().equals("tmart") == true ) {
			//System.out.println( this.getClass().toString()+" Process_Identify_Resultpages C4 Starter thread #"+X);
			IdentifyThreads[X] = new Thread_Identify_Tmart( Class_Controller, HentetJobb );
			IdentifyThreads[X].start();
			return;
		} else {
			System.out.println( this.getClass().toString()+" Process_Identify_Auctions Finner ikke riktig dropshipper" );
		}
	}
	
	public void Save_DownloadedPage( Object_SearchJob jobb ) throws Exception {
		//System.out.println( this.getClass().toString()+" Save_DownloadedPage_Resultpage "+jobb.Get_Adresse().toString() );
		if ( Tree_Identify[0].SearchFor( jobb.Get_Adresse().toString() ) == null ) {
			Tree_Identify[0] = Class_Controller.ExpandTreeMap_String( (Object_TreeMap_String) Tree_Identify[0], jobb.Get_Adresse().toString(), jobb );
			int Value = jobb.Get_LinkedRelationValue();
			while ( Tree_Identify[1].SearchFor( Value ) != null ){
				Value --;
			}
			//System.out.println( this.getClass().toString()+" Save_DownloadedPage_Resultpage B" );
			Tree_Identify[1] = Class_Controller.ExpandTreeMap_int( (Object_TreeMap_int) Tree_Identify[1], Value, jobb );
		}

	}

	public void Save_SearchJob_Offers( Object_SearchJob test ) throws Exception {
		//System.out.println( this.getClass().toString()+" Save_SearchJob_Offers "+test.Get_Adresse().toString()+" isProductPage="+this.Class_Controller.isProductPage( test.Get_Adresse().toString() ) );
		Save_DownloadedPage( test );

	}
	
	private void Remove_Job_From_Queue( Object_SearchJob Done, Object Key ) throws Exception {
		//System.out.println( this.getClass().toString()+" Remove_Job_From_Queue Skal fjerne jobb: "+Done.Get_Adresse().toString()+" key="+Key );
		//System.out.println( this.getClass().toString()+" Remove_Job_From_Queue "+Tree_Identify_Resultpages[1].SearchFor( Integer.parseInt( Key.toString() ) ) );
		Tree_Identify[0].RemoveFromTreeMap( Done.Get_Adresse().toString() );
		Tree_Identify[1].RemoveFromTreeMap( Integer.parseInt( Key.toString() ) );

	}
}
