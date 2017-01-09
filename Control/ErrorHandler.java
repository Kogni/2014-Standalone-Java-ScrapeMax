package Control;

import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Date;
import javax.swing.JFrame;

import View.Object_DialogPopup;

public class ErrorHandler {

	Controller	Class_Controller;

	public ErrorHandler ( Controller Class_CommunicatorT ) {

		this.Class_Controller = Class_CommunicatorT;
	}
	
	public void WriteThrowableToScreen (Throwable T){
		System.out.println("- " + new Throwable().fillInStackTrace().getStackTrace()[0]+") <- " + new Throwable().fillInStackTrace().getStackTrace()[1]+")");
		Date today = new Date ( );
		int ErrorID = 0;
		try {
			ErrorID = LocateErrorID_Throwable ( T );
		} catch ( Exception e2 ) {
			WriteExceptionToScreen ( e2 );
		}
		
		try {

			System.err.println ( "Skriver i error log" );
			PrintStream Skrivingsobjekt;
			FileOutputStream Loggfil = new FileOutputStream ( "Errorlog.RP2", true );
			Skrivingsobjekt = new PrintStream ( Loggfil );
			Skrivingsobjekt.println ( "-- Throwable start --" );
			Skrivingsobjekt.println ( "Time: " + today );
			Skrivingsobjekt.println ( "Error ID: " + ErrorID );
			Skrivingsobjekt.println (" ");
			Skrivingsobjekt.println ( "Throwable: " + T );
			Skrivingsobjekt.println ( "Throwable message: " + T.getMessage ( ) );
			Skrivingsobjekt.println ( "Throwable cause: " + T.getCause ( ) );
			Skrivingsobjekt.println ( "Throwable class: " + T.getClass ( ) );
			Skrivingsobjekt.println (" ");
			if ( T.getStackTrace ( ) != null ){
				Skrivingsobjekt.println ( "Throwable origin: ");
				Skrivingsobjekt.println ( "Class: " + T.getStackTrace ( )[0].getClassName ( ) );
				Skrivingsobjekt.println ( "Method: " + T.getStackTrace ( )[0].getMethodName ( ) );
				Skrivingsobjekt.println ( "Line: " + T.getStackTrace ( )[0].getLineNumber ( ) );
			}
			for ( int y = 1 ; y < T.getStackTrace().length ; y++ ) {
				Skrivingsobjekt.println (" ");
				Skrivingsobjekt.println ( "Origin stack "+y+": ");
				Skrivingsobjekt.println ( "Class: " + T.getStackTrace ( )[y].getClassName ( ) );
				Skrivingsobjekt.println ( "Method: " + T.getStackTrace ( )[y].getMethodName ( ) );
				Skrivingsobjekt.println ( "Line: " + T.getStackTrace ( )[y].getLineNumber ( ) );
			}
			Skrivingsobjekt.println ( "-- Throwable end --" );
			Skrivingsobjekt.close ( );

			Object_DialogPopup ErrorDialog = new Object_DialogPopup ( new JFrame ( ), "Error", ErrorID );

		} catch ( Exception e2 ) {
			System.err.println ( "Kunne ikke skrive til fil " + "Errorlog.RP2" );
			e2.printStackTrace ( );
			//WriteExceptionToScreen ( e );
		}
	}

	public void WriteExceptionToScreen ( Exception e ) {
		System.out.println("- " + new Throwable().fillInStackTrace().getStackTrace()[0]+") <- " + new Throwable().fillInStackTrace().getStackTrace()[1]+")");

		Date today = new Date ( );
		//SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yy hh:mm:ss a");
		//String datenewformat = formatter.format(today);
		//System.out.println(datenewformat);
		int ErrorID = 0;
		try {
			ErrorID = LocateErrorID_Exception ( e );
		} catch ( Exception e2 ) {
			//WriteExceptionToScreen ( e );
		}
		
		try {

			System.err.println ( "Skriver i error log" );
			PrintStream Skrivingsobjekt;
			FileOutputStream Loggfil = new FileOutputStream ( "Errorlog.RP2", true );
			Skrivingsobjekt = new PrintStream ( Loggfil );
			Skrivingsobjekt.println ( "-- Exception start --" );
			Skrivingsobjekt.println ( "Time: " + today );
			Skrivingsobjekt.println ( "Error ID: " + ErrorID );
			Skrivingsobjekt.println (" ");
			Skrivingsobjekt.println ( "Exception: " + e );
			Skrivingsobjekt.println ( "Exception message: " + e.getMessage ( ) );
			Skrivingsobjekt.println ( "Exception cause: " + e.getCause ( ) );
			Skrivingsobjekt.println ( "Exception class: " + e.getClass ( ) );
			Skrivingsobjekt.println (" ");
			if ( e.getStackTrace ( ) != null ){
				Skrivingsobjekt.println ( "Exception origin: ");
				Skrivingsobjekt.println ( "Class: " + e.getStackTrace ( )[0].getClassName ( ) );
				Skrivingsobjekt.println ( "Method: " + e.getStackTrace ( )[0].getMethodName ( ) );
				Skrivingsobjekt.println ( "Line: " + e.getStackTrace ( )[0].getLineNumber ( ) );
			}
			for ( int y = 1 ; y < e.getStackTrace().length ; y++ ) {
				Skrivingsobjekt.println (" ");
				Skrivingsobjekt.println ( "Origin stack "+y+": ");
				Skrivingsobjekt.println ( "Class: " + e.getStackTrace ( )[y].getClassName ( ) );
				Skrivingsobjekt.println ( "Method: " + e.getStackTrace ( )[y].getMethodName ( ) );
				Skrivingsobjekt.println ( "Line: " + e.getStackTrace ( )[y].getLineNumber ( ) );
			}
			Skrivingsobjekt.println ( "-- Exception end --" );
			Skrivingsobjekt.close ( );

			Object_DialogPopup ErrorDialog = new Object_DialogPopup ( new JFrame ( ), "Error", ErrorID );

		} catch ( Exception e2 ) {
			System.err.println ( "Kunne ikke skrive til fil " + "Errorlog.RP2" );
			//WriteExceptionToScreen ( e );
		}

	}

	private int LocateErrorID_Exception ( Exception e ) {

		int ID = 0;
		//0 = unknown error
		//1 = Gear.RP2 missing
		//2 = TalentsFile.RP2 missing
		//3 = Gems.RP2 missing
		//4 = CharacterInfo.RP2 missing
		//5 = AbilitySettings.RP2 missing

		//if ( e.getMessage ( ) != null ){
			if ( e.getMessage ( ).toString ( ).equals ( "Gear.RP2 (The system cannot find the file specified)" ) ) {
				ID = 1;
			}
			if ( e.getMessage ( ).toString ( ).equals ( "TalentsFile.RP2 (The system cannot find the file specified)" ) ) {
				ID = 2;
			}
			if ( e.getMessage ( ).toString ( ).equals ( "Gems.RP2 (The system cannot find the file specified)" ) ) {
				ID = 3;
			}
			if ( e.getMessage ( ).toString ( ).equals ( "CharacterInfo.RP2 (The system cannot find the file specified)" ) ) {
				ID = 4;
			}
			if ( e.getMessage ( ).toString ( ).equals ( "AbilitySettings.RP2 (The system cannot find the file specified)" ) ) {
				ID = 5;
			}
		//}

		return ID;
	}
	
	private int LocateErrorID_Throwable ( Throwable T ) {

		int ID = 0;
		//0 = unknown error
		//1 = Gear.RP2 missing
		//2 = TalentsFile.RP2 missing
		//3 = Gems.RP2 missing
		//4 = CharacterInfo.RP2 missing

		

		return ID;
	}

}
