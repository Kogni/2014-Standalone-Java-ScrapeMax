package Searching;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import Control.Controller;
import Interfaces.Interface_Searching;
import URLs.Object_TreeMap;
import URLs.Object_TreeMap_String;
import URLs.Object_TreeMap_int;
import URLs.Object_URL;

public class Brain_Downloads implements Interface_Searching {
	
	Controller Class_Controller;
	
	//String	PermanentSaveFile = "URLs checked.txt";
	
	//String[] SearchTypes;
	String	Selected_Searchtype;
	
	//ConcurrentHashMap AllSearchJobs_hashmap = new ConcurrentHashMap();
	
	Object_TreeMap[]		Tree_Search;
	//Object_TreeMap[]		Tree_Search_Auctions;
	//Object_TreeMap[]		Tree_Search_Resultpages;
	
	Thread_DownloadPage[]	SearchThreads_Auctions;
	Thread_DownloadPage[]	SearchThreads_Resultpages;
	
	boolean					Saving = false;
	boolean					Listing = false;
	
	public int						Layer					= 10;
	public int						LayerCount				= 0;
	public int						LayerCount_Working		= 0;
	public int 						LayerCount_Download		= 0;
	public int 						LayerCount_Identify		= 0;
	public int 						LayerCount_URL			= 0;
	public int						LayerCount_Current		= 0;
	
	public Brain_Downloads( Controller Class_Controller, String Source ) throws Exception {
		//System.out.println( this.getClass().toString()+" constructor "+this+" Source="+Source );
		this.Class_Controller = Class_Controller;
		
		Tree_Search = new Object_TreeMap[2];
		Tree_Search[0] = new Object_TreeMap_String(Class_Controller);
		Tree_Search[0].SaveObject( "", null );
		Tree_Search[1] = new Object_TreeMap_int(Class_Controller);
		Tree_Search[1].SaveObject( 0, null );
		
		/*Tree_Search_Auctions = new Object_TreeMap[2];
		Tree_Search_Auctions[0] = new Object_TreeMap_String(Class_Controller);
		Tree_Search_Auctions[0].SaveObject( "", null );
		Tree_Search_Auctions[1] = new Object_TreeMap_int(Class_Controller);
		Tree_Search_Auctions[1].SaveObject( 0, null );
		
		Tree_Search_Resultpages = new Object_TreeMap[2];
		Tree_Search_Resultpages[0] = new Object_TreeMap_String(Class_Controller);
		Tree_Search_Resultpages[0].SaveObject( "", null );
		Tree_Search_Resultpages[1] = new Object_TreeMap_int(Class_Controller);
		Tree_Search_Resultpages[1].SaveObject( 0, null );*/
		
		SearchThreads_Auctions = new Thread_DownloadPage[4];
		SearchThreads_Resultpages = new Thread_DownloadPage[3];
		
		/*SearchTypes = new String[2];
		SearchTypes[0] = "Category";
		SearchTypes[1] = "Full crawl";
		SearchTypes[2] = "Full crawl";*/
		
	}

	public void RunThreads_Searching() throws Exception {
		//System.out.println( this.getClass().toString()+" RunThreads" );
		RunThreads_Search();
		//RunThreads_Search_Resultpages();
		//RunThreads_Search_Auctions();
	}
	
	// searching
	
	public void Save_NewURL_Search( Object_URL nyURL, Object_SearchJob test2 ) throws Exception {
		//System.out.println( this.getClass().toString()+" Save_NewURL_Search A adresse="+nyURL.Get_Adresse().toString() );
		//System.out.println( this.getClass().toString()+" Save_NewURL_Search_Auction isproduct="+Class_Controller.isProductPage( adresse ) );
		Object_SearchJob Test;
		if ( test2 == null ) {
			//System.out.println( this.getClass().toString()+" Save_NewURL_Search B1 Tester URL. Adresse="+nyURL.Get_Adresse().toString() );
			Test = new Object_SearchJob( nyURL, Class_Controller, Class_Controller.Get_SelectedSearchtype( this.getClass().toString()+" Save_NewURL_Search_Auction" ), this.getClass().toString()+" Save_NewURL_Search_Auction Tester URL" );
		} else {
			//System.out.println( this.getClass().toString()+" Save_NewURL_Search B2 Tester URL. Adresse="+nyURL.Get_Adresse().toString() );
			Test = test2;
		}
		//System.out.println( this.getClass().toString()+" Save_NewURL_Search C adresse="+nyURL.Get_Adresse().toString() );
		int relationValue = nyURL.RelationValue_Linked;
		if ( Tree_Search[0].SearchFor( nyURL.Get_Adresse().toString() ) == null ) {
			//System.out.println( this.getClass().toString()+" Save_NewURL_Search D1 URL ikke lagret. adresse="+nyURL.Get_Adresse().toString() );
			//Class_Controller.Save_SearchJob( Test );
			Tree_Search[0] = Class_Controller.ExpandTreeMap_String( (Object_TreeMap_String) Tree_Search[0], nyURL.Get_Adresse().toString(), Test );
			while ( Tree_Search[1].SearchFor( relationValue ) != null ) {
				relationValue --;
			}
			Tree_Search[1] = Class_Controller.ExpandTreeMap_int( (Object_TreeMap_int) Tree_Search[1], relationValue, Test );
			//System.out.println( this.getClass().toString()+" Save_NewURL_Search D Lagrer ny adresse="+nyURL.Get_Adresse().toString() );
			Class_Controller.SetCurrentAction( "Saved new URL" );
			Class_Controller.Add_Page_Locate( nyURL, 1 );
		} else {
			//System.out.println( this.getClass().toString()+" Save_NewURL_Search D2 URL allerede lagret. adresse="+nyURL.Get_Adresse().toString() );
		}
		
	}

	/*public void Save_NewURL_Search_Auction( Object_URL nyURL, Object_SearchJob test2 ) throws Exception {
		//System.out.println( this.getClass().toString()+" Save_NewURL_Search_Auction adresse="+adresse );
		//System.out.println( this.getClass().toString()+" Save_NewURL_Search_Auction isproduct="+Class_Controller.isProductPage( adresse ) );
		if ( Class_Controller.isProductPage( nyURL.Get_Adresse().toString() ) == false ) {
			return;
		}
		Object_SearchJob Test;
		if ( test2 == null ) {
			//System.out.println( this.getClass().toString()+" Save_NewURL_Search_Auction Tester URL. Adresse="+adresse );
			Test = new Object_SearchJob( nyURL, Class_Controller, Class_Controller.Get_SelectedSearchtype( this.getClass().toString()+" Save_NewURL_Search_Auction" ), this.getClass().toString()+" Save_NewURL_Search_Auction Tester URL" );
		} else {
			Test = test2;
		}
		int relationValue = nyURL.RelationValue_Linked;
		if ( Tree_Search_Auctions[0].SearchFor( nyURL.Get_Adresse().toString() ) == null ) {
			//Class_Controller.Save_SearchJob( Test );
			Tree_Search_Auctions[0] = Class_Controller.ExpandTreeMap_String( (Object_TreeMap_String) Tree_Search_Auctions[0], nyURL.Get_Adresse().toString(), Test );
			while ( Tree_Search_Auctions[1].SearchFor( relationValue ) != null ) {
				relationValue --;
			}
			Tree_Search_Auctions[1] = Class_Controller.ExpandTreeMap_int( (Object_TreeMap_int) Tree_Search_Auctions[1], relationValue, Test );
			Class_Controller.SetCurrentAction( "Saved new URL" );
			Class_Controller.Add_Page_Locate( nyURL, 1 );
		}
		
	}

	public void Save_NewURL_Search_Resultpage( Object_URL nyURL, Object_SearchJob test2 ) throws Exception {
		//System.out.println( this.getClass().toString()+" Save_NewURL_Search_Resultpage adresse="+adresse );
		//System.out.println( this.getClass().toString()+" Save_NewURL_Search_Resultpage isproduct="+Class_Controller.isProductPage( adresse ) );
		if ( Class_Controller.isProductPage( nyURL.Get_Adresse().toString() ) == true ) {
			return;
		}
		Object_SearchJob Test;
		if ( test2 == null ) {
			//System.out.println( this.getClass().toString()+" Save_NewURL_Search_Resultpage Tester URL. Adresse="+adresse );
			Test = new Object_SearchJob( nyURL, Class_Controller, Class_Controller.Get_SelectedSearchtype( this.getClass().toString()+" Save_NewURL_Search_Resultpage" ), this.getClass().toString()+" Save_NewURL_Search_Resultpage Tester URL" );
		} else {
			Test = test2;
		}
		int relationValue = nyURL.RelationValue_Linked;
		if ( Tree_Search_Resultpages[0].SearchFor( nyURL.Get_Adresse().toString() ) == null ) {
			//Class_Controller.Save_SearchJob( Test );
			Tree_Search_Resultpages[0] = Class_Controller.ExpandTreeMap_String( (Object_TreeMap_String) Tree_Search_Resultpages[0], nyURL.Get_Adresse().toString(), Test );
			while ( Tree_Search_Resultpages[1].SearchFor( relationValue ) != null ) {
				relationValue --;
			}
			Tree_Search_Resultpages[1] = Class_Controller.ExpandTreeMap_int( (Object_TreeMap_int) Tree_Search_Resultpages[1], relationValue, Test );
			Class_Controller.SetCurrentAction( "Saved new URL" );
			Class_Controller.Add_Page_Locate( nyURL, 0 );
		}
		
	}*/
	
	public Object_SearchJob SearchFor_Search_URL( Object_SearchJob object_SearchJob) throws Exception {
		return (Object_SearchJob) Tree_Search[0].SearchFor( object_SearchJob.Get_Adresse().toString() );
	}

	/*public Object_SearchJob SearchFor_Search_Auction_URL( Object_SearchJob object_SearchJob) throws Exception {
		return (Object_SearchJob) Tree_Search_Auctions[0].SearchFor( object_SearchJob.Get_Adresse().toString() );
	}

	public Object_SearchJob SearchFor_Search_Resultpage_URL( Object_SearchJob object_SearchJob) throws Exception {
		//System.out.println( this.getClass().toString()+" SearchFor_Search_Resultpage_URL Get_Adresse="+object_SearchJob.Get_Adresse().toString() );
		return (Object_SearchJob) Tree_Search_Resultpages[0].SearchFor( object_SearchJob.Get_Adresse().toString() );
	}*/
	
	public void RunThreads_Search() throws Exception {
		//System.out.println( this.getClass().toString()+" RunThreads_Search A");
		LayerCount_Download = 0;
		LayerCount = 0;
		LayerCount_Working = 0;
		LayerCount_Current = 0;
		try {
			for ( Map.Entry < Object,Object_SearchJob > e : Tree_Search[1].Get_SynchedKart().entrySet() ) {
			//for (Iterator<Object> iter = Tree_Search_Resultpages[1].navig.iterator();iter.hasNext();) {  
				//Object key = (Object) iter.next();
				Object_SearchJob HentetJobb = (Object_SearchJob) e.getValue();
				//Object_SearchJob HentetJobb = ((Object_SearchJob) Tree_Search_Resultpages[1].Kart.get(key) );
				
				//System.out.println( this.getClass().toString()+" RunThreads_Search B HentetJobb="+HentetJobb.toString());
				if ( HentetJobb != null ) {
					//System.out.println( this.getClass().toString()+" RunThreads_Search C HentetJobb="+HentetJobb.toString()+" Layer="+HentetJobb.TargetOffer.Get_Adresse().Layer+" <= "+Layer+"="+(Layer - HentetJobb.TargetOffer.Get_Adresse().Layer) );
					if ( (this.Class_Controller.Get_Layer() - HentetJobb.TargetOffer.Get_Adresse().Layer) >= 0 ) {
						
						LayerCount ++;
						if ( HentetJobb.TargetOffer.Get_Adresse().Download_Finished == true ) {
							if ( HentetJobb.TargetOffer.Get_Adresse().Identify_Finished == true ) {
								if ( HentetJobb.TargetOffer.Get_Adresse().URLs_Finished == true ) {
								} else {
									LayerCount_Working = LayerCount_Working +1;
								}
							} else {
								LayerCount_Working = LayerCount_Working +2;
							}
						} else {
							LayerCount_Working = LayerCount_Working +3;
						}
						if ( this.Class_Controller.Get_Layer() == HentetJobb.TargetOffer.Get_Adresse().Layer ) {
							LayerCount_Current ++;
						}
						//System.out.println( this.getClass().toString()+" RunThreads_Search D HentetJobb="+HentetJobb+" Download_Started="+HentetJobb.TargetOffer.Get_Adresse().Download_Started );
				    	if ( HentetJobb.TargetOffer.Get_Adresse().Download_Started == false ) {
				    		this.Class_Controller.Increase_LayerCount_Download();
				    		//System.out.println( this.getClass().toString()+" RunThreads_Search E HentetJobb="+HentetJobb+" Sjekker om server er klar" );
				    		Date Nu = new Date();
				    		Date Da = this.Class_Controller.Get_DropshipperDowntime( HentetJobb.TargetOffer.Get_Adresse().Get_Domain_Lang() );
				    		if ( Da == null ) {
				    			//System.out.println( this.getClass().toString()+" RunThreads_Search F1 HentetJobb="+HentetJobb+" Ber om download" );
				    			Process_Search( HentetJobb );
				    			return;
				    		} else {
				    			//System.out.println( this.getClass().toString()+" RunThreads_Search F2 HentetJobb="+HentetJobb+" Server har hatt downtime: "+Da );
				    			if ( Nu.getTime() - Da.getTime() > 100*60*4 ) {
				    				//System.out.println( this.getClass().toString()+" RunThreads_Search F2a HentetJobb="+HentetJobb+" Ber om download" );
				    				Process_Search( HentetJobb );
				    				return;
				    			} else {
				    				//System.out.println( this.getClass().toString()+" RunThreads_Search F2b HentetJobb="+HentetJobb+" Server ikke klar - "+ ((Nu.getTime() - Da.getTime())-(100*60*4)) );
				    				Class_Controller.SetCurrentAction( "Temp-banned from server" );
				    			}
				    		}
				    	} else {
				    		//System.out.println( this.getClass().toString()+" RunThreads_Search E HentetJobb="+HentetJobb+" download allerede startet" );
				    	}
					}
				}
		    }
		} catch ( Exception T ) {
			
		}

		if ( LayerCount > 0 ) {
			//System.out.println( this.getClass().toString()+" RunThreads_Search G LayerCount="+LayerCount );
			if ( LayerCount_Working == 0 ) {
				//System.out.println( this.getClass().toString()+" RunThreads_Search H1 LayerCount_Working="+LayerCount_Working );
				if ( (LayerCount_Download+LayerCount_Identify+LayerCount_URL) == 0 ) {
					if ( ( LayerCount_Current > 0 ) && ( LayerCount_Working == 0 ) ) {
						System.out.println( this.getClass().toString()+" RunThreads_Search G Layer="+Layer );
						System.out.println( this.getClass().toString()+" RunThreads_Search G LayerCount="+LayerCount );
						System.out.println( this.getClass().toString()+" RunThreads_Search G LayerCount_Current="+LayerCount_Current );
						System.out.println( this.getClass().toString()+" RunThreads_Search H1 LayerCount_Working="+LayerCount_Working );
						System.out.println( this.getClass().toString()+" RunThreads_Search I1 Escalating" );
						Layer ++;
						Class_Controller.AddProgressMessage( "Escalating search to layer "+Layer );
					}
				} /*else {
					System.out.println( this.getClass().toString()+" RunThreads_Search I2 LayerCount_Download="+LayerCount_Download );
					System.out.println( this.getClass().toString()+" RunThreads_Search I2 LayerCount_Identify="+LayerCount_Identify );
					System.out.println( this.getClass().toString()+" RunThreads_Search I2 LayerCount_URL="+LayerCount_URL );
				}*/
			} else {
				//System.out.println( this.getClass().toString()+" RunThreads_Search H2 LayerCount_Working="+LayerCount_Working );
			}
		}
		//System.out.println( this.getClass().toString()+" RunThreads_Search J Fant ingen URLr å hente ned" );
		for ( int X = 0 ; X < SearchThreads_Resultpages.length ; X++ ) {
			if ( SearchThreads_Resultpages[X] == null ) {
				Class_Controller.Get_SelectedDropshipper( this.getClass().toString()+" RunThreads_Search" ).Send_Start_URLs();
				return;
			} else if ( SearchThreads_Resultpages[X].Jobb.TargetOffer.Get_Adresse().Download_Finished == true ) {
				Class_Controller.Get_SelectedDropshipper( this.getClass().toString()+" RunThreads_Search" ).Send_Start_URLs();
				return;
			} else {
				try {
					SearchThreads_Resultpages[X].start();
				} catch ( Exception T ) {
					
				}
			}
		}
		//System.out.println( this.getClass().toString()+" RunThreads_Search_Resultpages D");
	}
	
	
	public void Process_Search( Object_SearchJob HentetJobb ) throws Exception {
		//System.out.println( this.getClass().toString()+" Process_Search HentetJobb="+HentetJobb+" adresse="+HentetJobb.Get_Adresse() );
		Class_Controller.SetCurrentAction( "Starting download of web page" );
		for ( int X = 0 ; X < SearchThreads_Resultpages.length ; X++ ) {
			//System.out.println( this.getClass().toString()+" Process_Search_Resultpages SearchThreads_Resultpages[X]="+SearchThreads_Resultpages[X] );
			if ( SearchThreads_Resultpages[X] == null ) {
				//System.out.println( this.getClass().toString()+" Process_Search_Resultpages A" );
				SearchThreads_Resultpages[X] = new Thread_DownloadPage( Class_Controller, HentetJobb );
				SearchThreads_Resultpages[X].start();
				return;
			} else if ( SearchThreads_Resultpages[X].Jobb.TargetOffer.Get_Adresse().Download_Finished == true ) {
				//System.out.println( this.getClass().toString()+" Process_Search_Resultpages B" );
				SearchThreads_Resultpages[X] = new Thread_DownloadPage( Class_Controller, HentetJobb );
				SearchThreads_Resultpages[X].start();

				return;
			} else if ( SearchThreads_Resultpages[X].Jobb.TargetOffer.Get_Adresse().Download_Started == false ) {
				//System.out.println( this.getClass().toString()+" Process_Search_Resultpages C" );
				SearchThreads_Resultpages[X] = new Thread_DownloadPage( Class_Controller, HentetJobb );
				SearchThreads_Resultpages[X].start();
				return;
			} else {
				//System.out.println( this.getClass().toString()+" Process_Search_Resultpages D" );
				//System.out.println( this.getClass().toString()+" Process_Search_Resultpages D Download_Finished="+SearchThreads_Resultpages[X].Jobb.Download_Finished+" Download_Started="+SearchThreads_Resultpages[X].Jobb.Download_Started );
				try {
					SearchThreads_Resultpages[X].start();
				} catch ( Exception T ) {
					
				}
			}
		}
		//System.out.println( this.getClass().toString()+" Process_Search_Resultpages Alle threads opptatt" );
	}

	
	public void UpdateURLGUI_Hashmap() throws Exception {
		//System.out.println( this.getClass().toString()+" UpdateURLGUI_Hashmap A" );

		Tree_Search[1].SendContents();
		//System.out.println( this.getClass().toString()+" UpdateURLGUI_Hashmap B "+Tree_Search_Auctions[1] );
		//Tree_Search_Auctions[1].SendContents();
		//System.out.println( this.getClass().toString()+" UpdateURLGUI_Hashmap C "+Tree_Search_Resultpages[1] );
		//Tree_Search_Resultpages[1].SendContents();
		//System.out.println( this.getClass().toString()+" UpdateURLGUI_Hashmap D" );

	}

	public void Save_SearchJob_Search( Object_SearchJob test ) throws Exception {
		//System.out.println( this.getClass().toString()+" Save_SearchJob_Search isproduct="+Class_Controller.isProductPage( test.Get_Adresse().toString() )+" url="+test.Get_Adresse().toString() );
		Save_NewURL_Search( test.TargetOffer.Get_Adresse(), test );
		/*if ( this.Class_Controller.isProductPage( test.Get_Adresse().toString() ) == true ) {
			Save_NewURL_Search_Auction( test.TargetOffer.Get_Adresse(), test );
		} else {
			Save_NewURL_Search_Resultpage( test.TargetOffer.Get_Adresse(), test );
		}*/
	}

	public void Set_Searchtype(String string) {
		//System.out.println( this.getClass().toString()+" Set_Searchtype Selected_Searchtype="+string );
		Selected_Searchtype = string;
	}

	public String Get_SelectedSearchtype( String Source ) {
		//System.out.println( this.getClass().toString()+" Get_SelectedSearchtype Selected_Searchtype="+Selected_Searchtype+" Source="+Source+" this="+this );
		return Selected_Searchtype;
	}

	public Object_SearchJob[] Get_All_Pages() throws Exception {
		return Tree_Search[1].Get_ContentArray();
		//return CombineArray( Tree_Search_Resultpages[1].Get_ContentArray(), Tree_Search_Auctions[1].Get_ContentArray() );
	}
	
	private Object_SearchJob[] CombineArray( Object_SearchJob[] A, Object_SearchJob[] B ) {
		Object_SearchJob[] C = new Object_SearchJob[ A.length+B.length ];
		
		int C_Teller = 0;
		for ( int X = 0; X < A.length ; X ++ ) {
			C_Teller = X;
			C[C_Teller] = A[X];
		}
		for ( int X = 0; X < B.length ; X ++ ) {
			C_Teller++;
			C[C_Teller] = B[X];
		}
		
		return C;
	}

	public Object_TreeMap[] Get_TreeMap() {
		return Tree_Search;
	}

	public Object_SearchJob Get_Page_ObjectURL(String string) throws Exception {
		Object_SearchJob Found = Tree_Search[0].SearchFor( string );
		if ( Found != null ) {
			return Found;
		} else {
			return null;
		}
	}

}