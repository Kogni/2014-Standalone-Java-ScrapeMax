package Wholesalers;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import URLs.Object_URL;

import Control.Controller;

public class Brain_Wholesalers {

	Controller Class_Controller;
	
	Object_Wholesaler[] AllWholesalers;
	
	String WholesalersFilename = "Wholesalers.txt";
	File WholesalersFile = new File ( WholesalersFilename );
	
	public Brain_Wholesalers(Controller Class_Controller) throws IOException {
		
		//System.out.println( this.getClass().toString()+" Startup" );
		AllWholesalers = new Object_Wholesaler[99];
		this.Class_Controller = Class_Controller;
		//LoadWholesalers();
	}
	
	public void LoadWholesalers() throws IOException {
		//System.out.println( this.getClass().toString()+" LoadWholesalers A" );
		try {
			//System.out.println( this.getClass().toString()+" LoadWholesalers B" );
			FileInputStream fstream2 = new FileInputStream ( WholesalersFilename );
			DataInputStream in2 = new DataInputStream ( fstream2 );
			while ( in2.available() > 0 ) {
				//System.out.println( this.getClass().toString()+" LoadWholesalers C" );
				String Linje = in2.readLine();
				String WholesalerID = "";
				String WholesalerURL = "";
				int IndexProducer = Linje.indexOf(",");
				try { //blir error her hvis det er en tom linje i filen
					//System.out.println( this.getClass().toString()+" LoadWholesalers D "+Linje );
					//producer = 0 -> #
					WholesalerID = Linje.substring(0, IndexProducer);
					
					//product = producer# -> #details
					Linje = Linje.substring((IndexProducer+2));
					WholesalerURL = Linje;
					
					InsertNewWholesaler( Integer.parseInt(WholesalerID.toLowerCase()), WholesalerURL );
				} catch ( Exception T) {
					CastErrors( T );
				}
			}
		} catch ( Exception T) {
			CastErrors( T );
		}
		
	}
	
	private void InsertNewWholesaler( int WholesalerID, String WholesalerURL ) throws Exception {
		//System.out.println( this.getClass().toString()+" InsertNewWholesaler ID="+WholesalerID+" URL="+WholesalerURL );
		WholesalerURL = WholesalerURL.toLowerCase();

		//legger inn item
		for ( int x = 0; x < AllWholesalers.length ; x++ ) {
			if ( AllWholesalers[x] == null ) {
				AllWholesalers[x] = new Object_Wholesaler( WholesalerID, WholesalerURL );

				SaveToFile(  );
				Object_URL nyURL = new Object_URL( WholesalerURL, 99999, Class_Controller, null,1 );

				if ( 
						nyURL.Get_Domain_Lang().equalsIgnoreCase( 
								Class_Controller.Get_SelectedDropshipper( 
										this.getClass().toString()
								).DropshipperName 
						) == false ) {
					return;
				}
				
				Class_Controller.SaveNewURL( nyURL ); 
				return;
			} else if ( AllWholesalers[x].WholesalerID == WholesalerID ) {
				if ( AllWholesalers[x].WholesalerShopURL.equals( WholesalerURL )) {
					return;
				} else {
					
				}
			}
		}
		
		//System.out.println( "Brain_Produkter ERROR: Ikke plass til flere produkter i array!" );
		return;
	}
	
	private void SaveToFile( ) {
		//System.out.println( this.getClass().toString()+" SaveToFile" );

		try {
			boolean success = WholesalersFile.delete();
			if ( success == false ) {
				return;
			}
			System.out.println( "delete file success? "+success );
			/*String ProductsFilename2 = "Products2.txt";
			File ProductsFile2 = new File ( ProductsFilename2 );*/
			WholesalersFile.createNewFile();
			
			PrintStream utfil;
			FileOutputStream appendFilen = new FileOutputStream ( WholesalersFilename, true );
			utfil = new PrintStream ( appendFilen );

			for ( int A = 0 ; A < AllWholesalers.length ; A++ ) {
				if ( AllWholesalers[A] != null ) {
					//utfil.println( Produktliste[A].OfficialName+"#"+Produktliste[A].Producer+"#"+Produktliste[A].DetailsToString() );
					utfil.println( AllWholesalers[A].WholesalerID+"#"+AllWholesalers[A].WholesalerShopURL );
				}
			}

			utfil.close ( );
			utfil = null;
	        System.gc();

			//this.Class_Controller.AddProgressMessage( "New product saved to searchlist file." );
		} catch ( IOException T ) {
			CastErrors( T );
			if ( T.getMessage ( ).equals("Access is denied")) {
				SaveToFile(  );
			} else {
				CastErrors( T );
			}
		} catch ( Exception T ) {
			CastErrors( T );
		}
	}
	
	private void CastErrors( Exception T ) {
		System.err.println("Thread_LinkFinder");
		System.err.println ( "Throwable message: " + T.getMessage ( ) );
		System.err.println ( "Throwable cause: " + T.getCause ( ) );
		System.err.println ( "Throwable class: " + T.getClass ( ) );
		
		System.err.println ( "Origin stack "+1+": ");
		System.err.println ( "Class: " + T.getStackTrace ( )[0].getClassName ( ) );
		System.err.println ( "Method: " + T.getStackTrace ( )[0].getMethodName ( ) );
		System.err.println ( "Line: " + T.getStackTrace ( )[0].getLineNumber ( ) );
		
		System.err.println ( "Origin stack "+1+": ");
		System.err.println ( "Class: " + T.getStackTrace ( )[1].getClassName ( ) );
		System.err.println ( "Method: " + T.getStackTrace ( )[1].getMethodName ( ) );
		System.err.println ( "Line: " + T.getStackTrace ( )[1].getLineNumber ( ) );
		
		System.err.println ( "Origin stack "+2+": ");
		System.err.println ( "Class: " + T.getStackTrace ( )[2].getClassName ( ) );
		System.err.println ( "Method: " + T.getStackTrace ( )[2].getMethodName ( ) );
		System.err.println ( "Line: " + T.getStackTrace ( )[2].getLineNumber ( ) );
		
		/*for ( int y = 2 ; y < T.getStackTrace().length ; y++ ) {
			System.err.println (" ");
			System.err.println ( "Origin stack "+y+": ");
			System.err.println ( "Class: " + T.getStackTrace ( )[y].getClassName ( ) );
			System.err.println ( "Method: " + T.getStackTrace ( )[y].getMethodName ( ) );
			System.err.println ( "Line: " + T.getStackTrace ( )[y].getLineNumber ( ) );
		}*/
	}

	public boolean IsAcceptedSeller( String seller ) {
		//System.out.println( this.getClass().toString()+" IsAcceptedSeller" );
		for ( int x = 0; x < AllWholesalers.length ; x++ ) {
			if ( AllWholesalers[x] != null ) {
				if ( seller.contains( AllWholesalers[x].WholesalerID+"" ) ) {
					return true;
				}
			}
		}
		return false;
	}
}
