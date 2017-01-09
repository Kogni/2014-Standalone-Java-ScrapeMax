package URLs;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

import Control.Controller;
import Searching.Object_SearchJob;

public class Thread_URLsLoader extends Thread {
	
	Controller Class_Controller;
	
	String SearchType;
	String Dropshipper;

	public Thread_URLsLoader( Controller Class_Controller, String SearchType, String Dropshipper ) {
		System.out.println( this.getClass().toString()+" creation" );
		this.Class_Controller = Class_Controller;
		this.SearchType = SearchType;
		this.Dropshipper = Dropshipper;
	}

	public void run() {
		try {
			LoadURLs_new();
		} catch (Exception e) {
		}
	}
	
	public void LoadURLs_new() throws Exception {
		System.out.println( this.getClass().toString()+" LoadURLs_new" );
		this.Class_Controller.AddProgressMessage("Loading saved URLs for "+Dropshipper+"...");
		final File folder = new File("URLs checked");
		SearchType = Class_Controller.Get_SelectedSearchtype( this.getClass().toString()+" LoadURL" );
		listFilesForFolder(folder);
		//System.out.println( this.getClass().toString()+" LoadURLs_new finished" );
		this.Class_Controller.AddProgressMessage("Finished loading saved URLs for "+Dropshipper+".");
	}
	
	public void listFilesForFolder( File folder) throws Exception {
		//System.out.println( this.getClass().toString()+" listFilesForFolder folder="+folder.getName() );
		try {
		    for (final File fileEntry : folder.listFiles()) {
		    	//System.out.println( this.getClass().toString()+" listFilesForFolder folder="+fileEntry.getName() );
		        if (fileEntry.isDirectory()) {
		            listFilesForFolder(fileEntry);
		        } else {
		        	LoadURL( fileEntry );
		        }
		    }
		} catch ( NullPointerException e ) {
		} catch ( Exception e ) {
			Class_Controller.ReportError(e, this.getClass().toString()+" listFilesForFolder" );
		}
	}
	
	public void LoadURL( File fileEntry ) {
		//System.out.println( this.getClass().toString()+" LoadURL A" );
		if ( fileEntry.getName().indexOf("URLO") < 0 ) { //ikke en Object_URL
			return;
		}
		//System.out.println( this.getClass().toString()+" LoadURL B" );
		try {
			ObjectInputStream objectIn = null;
			Object_URL LestObjekt = null;
			boolean Stopp = false;
			FileInputStream Streamen = new FileInputStream ( fileEntry ); 
			objectIn = new ObjectInputStream ( new BufferedInputStream ( Streamen ) );
			int X = 0;
			
			while ( Stopp == false ) {
				X++;
				try {
					LestObjekt = ( Object_URL ) objectIn.readObject ( );
					/*if ( LestObjekt.OfferSaved == true ) {
						return; //ikke gidd å loade URL, siden jobben er ferdig
					}*/
					/*if ( LestObjekt.URLs_Finished == true ) {
						return; //ikke gidd å loade URL, siden jobben er ferdig
					}*/
					if ( LestObjekt.Get_Domain_Lang().equalsIgnoreCase( Dropshipper ) == false ) {
						/*if ( LestObjekt.Get_Domain_Lang().equalsIgnoreCase("aliexpress") ) {
							System.out.println( this.getClass().toString()+" LoadURL skipper URL: "+LestObjekt.Get_Adresse().toString() );
						}*/
						return;
					}
					//System.out.println( this.getClass().toString()+" LoadURL B leste: "+LestObjekt.Get_Adresse().toString() );
					//System.out.println( this.getClass().toString()+" LoadURLs A OfferSaved="+LestObjekt.OfferSaved );
					if ( LestObjekt.Download_Finished == false ) {
						LestObjekt.Download_Started = false;
					}
					if ( LestObjekt.Identify_Finished == false ) {
						LestObjekt.Identify_Started = false;
					}
					if ( LestObjekt.URLs_Finished == false ) {
						LestObjekt.URLs_Started = false;
					}
					
					Object_SearchJob Test = new Object_SearchJob( LestObjekt, Class_Controller, SearchType, this.getClass().toString()+" LoadURL" );
					Test.TargetOffer.ReplaceURL( LestObjekt );
					//System.out.println( this.getClass().toString()+" LoadURL C OfferSaved="+LestObjekt.OfferSaved );
					//System.out.println( this.getClass().toString()+" LoadURLs A" );
					//Test.Set_SelfRelationValue( LestObjekt.RelationValue_Self );
					//System.out.println( this.getClass().toString()+" LoadURLs B" );
					
					Class_Controller.Save_LoadedPage( Test );
					
				} catch ( Exception e ) {
					//this.Class_Controller.ReportError(e);
					Stopp = true;
				}
			}
			objectIn.close ( );
		} catch ( Exception e ) {
			//System.err.println ( "Klarte ikke hente fra " + this.PermanentSaveFile );
			//Class_Controller.ReportError( e );
		}
	}
}
