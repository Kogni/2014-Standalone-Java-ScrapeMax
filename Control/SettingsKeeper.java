package Control;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class SettingsKeeper {
	
	Controller Class_Controller;
	
	boolean Working = true;
	boolean Loaded = false;

	public SettingsKeeper( Controller Class_Controller ) {
		this.Class_Controller = Class_Controller;
	}

	public void LoadSettings( String Source ) {
		//System.out.println( this.getClass().toString()+" LoadSettings A "+Source );
		Working = true;
		try {
			//System.out.println( this.getClass().toString()+" LoadSettings B" );
			
			File filen = new File ( "UserSettings.snu" );
			if ( !filen.exists() ) {
				Working = false;
				//System.out.println( this.getClass().toString()+" LoadSettings Bx1 no settings file" );
				if ( Source.equals( "class Control.Controller OpenProgram 1" ) == false) {
					Loaded = true;
				}
				return;
			}
			FileInputStream fstream = new FileInputStream ( filen );
			DataInputStream in = new DataInputStream ( fstream );
			int Teller = 0;
			//System.out.println( this.getClass().toString()+" LoadSettings B2" );
			//String Innlest = in.readLine ( );
			//while ( Innlest != null  ) {
				//System.out.println( "Innlest B="+Innlest );
				//Innlest = in.readLine ( );
				//String UserSettings = in.readLine ( );
				Class_Controller.Set_Setting_UserShop( in.readLine ( ) );
				if ( Source.equals( "class Control.Controller OpenProgram 1" ) == false) {
					String SaveType = in.readLine ( );
					//System.out.println( this.getClass().toString()+" LoadSettings B3 SaveType->"+SaveType );
					Class_Controller.Set_Setting_SaveType( SaveType );
					String Autopricing = in.readLine ( );
					//System.out.println( this.getClass().toString()+" LoadSettings B4 Autoprocing->"+Autopricing );
					Class_Controller.Set_Setting_AutoPricing( Autopricing );
					String Dropshipper = in.readLine ( );
					//System.out.println( this.getClass().toString()+" LoadSettings B5 Dropshipper->"+Dropshipper );
					Class_Controller.Set_Dropshipper( Dropshipper );
					String Searchtype = in.readLine ( );
					//System.out.println( this.getClass().toString()+" LoadSettings B6 Searchtype->"+Searchtype );
					Class_Controller.Set_Setting_Searchtype( Searchtype );
					//Class_Controller.Set_TargetSeller( in.readLine ( ) );
					//System.out.println( this.getClass().toString()+" LoadSettings B7" );
					Loaded = true;
				}

			//}
			in.close ( );
				
		} catch ( NullPointerException e ) {
			//System.out.println( this.getClass().toString()+" LoadSettings C" );
		} catch ( Exception e ) {
			//System.out.println( this.getClass().toString()+" LoadSettings D" );
		}
		Working = false;
		
		//System.out.println( this.getClass().toString()+" LoadSettings Bx2 done loading" );
		//System.out.println( this.getClass().toString()+" LoadSettings finished. Working="+Working );
	}
	
	public void SaveSettings ( ) throws Exception {
		//System.out.println( this.getClass().toString()+" SaveSettings Working="+Working+" Loaded="+Loaded );
		if ( Working == true ) {
			return;
		}
		if ( Loaded == false ) {
			return;
		}
		Working = true;
		try {
			//System.out.println( this.getClass().toString()+" SaveSettings Saving settings" );
			/*if ( slettfil2.exists() ) {
			System.err.println( this.getClass().toString()+" SaveSettings klarte ikke slette settingsfil, filen blir ikke tømt!" );
			Working = false;
			return;
		}*/
			PrintStream utfil;
			File slettfil2 = new File ( "UserSettings.snu" );
			slettfil2.delete ( );//tømmer fila
			
			FileOutputStream appendFilen = new FileOutputStream ( "UserSettings.snu", false );
			utfil = new PrintStream ( appendFilen );
			utfil.println ( Class_Controller.Get_Settings_UserShop() );
			utfil.println ( Class_Controller.Get_SelectedSavetype() );
			utfil.println ( Class_Controller.Get_SelectedAutopricing() );
			utfil.println ( Class_Controller.Get_SelectedDropshipper( this.getClass().toString()+" SaveSettings Working" ).DropshipperName );
			utfil.println ( Class_Controller.Get_SelectedSearchtype( this.getClass().toString()+" SaveSettings" ) );
			//utfil.println ( Class_Controller.Get_SelectedStore() );

			utfil.close ( );
		} catch ( Exception T ) {
			
		}
		Working = false;
	}
}
