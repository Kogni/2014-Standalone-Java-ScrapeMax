package URLs;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.io.Serializable;
import java.net.URL;

import Control.Controller;

public class Object_URL implements Serializable {

	private static final long serialVersionUID = -1237935560268737348L;
	URL	Adresse;
	public Object_URL ParentURL; //medfører at alle URL'er vil loades samtidig
	public int Layer;
	
	public File CompleteContentFile;
	public int RelationValue_Linked;
	public int RelationValue_Self;
	public String Category;
	private boolean AcceptedCategory;
	
	public boolean OfferSaved = false;
	public boolean Download_Started = false;
	public boolean Download_Finished = false;
	public boolean URLs_Started = false;
	public boolean URLs_Finished = false;
	public boolean Identify_Started = false;
	public boolean Identify_Finished = false;
	
	private boolean Pause;
	public boolean IsImagePage;

	public Object_URL( String adresse, int RelationValue, Controller Class_Controller, Object_URL ParentURL, int Layer ) throws Exception {
		//this.Class_Controller = Class_Controller;
		//System.out.println( this.getClass().toString()+" constructor adresse="+adresse );
		try {
			Adresse = new URL( adresse );
		} catch ( Exception e ) {
			Class_Controller.ReportError(e, this.getClass().toString()+" constructor" );
		}
		this.RelationValue_Linked = RelationValue;
		CompleteContentFile = new File( "URLs checked\\"+SimplifyURL(adresse)+".CCF" );
		this.ParentURL = ParentURL;
		this.Layer = Layer;
	}
	
	public String SimplifyURL( String URL ) {
		String Simple = URL;
		Simple = Simple.replaceAll("\"", "-");
		Simple = Simple.replaceAll("\\\\", "-");
		Simple = Simple.replaceAll("/", "-");
		Simple = Simple.replaceAll("%", "");
		Simple = Simple.replaceAll(":", "-");
		Simple = Simple.replaceAll("\\?", "-");
		Simple = Simple.replaceAll("=", "-");
		Simple = Simple.replaceAll("&", "-");
		
		return Simple;
	}

	public URL Get_Adresse() {
		return Adresse;
	}

	public void Set_SelfRelationValue(int value) {
		RelationValue_Self = value;
	}
	
	public String Get_Domain_Lang() {
		if ( Adresse.toString().indexOf("focalprice") > -1 ) {
			return "focalprice";
		}
		if ( Adresse.toString().indexOf("aliexpress") > -1 ) {
			return "aliexpress";
		}
		if ( Adresse.toString().indexOf("dhgate") > -1 ) {
			return "dhgate";
		}
		if ( Adresse.toString().indexOf("1on1dropship") > -1 ) {
			return "1on1dropship";
		}
		return null;
	}

	public String Get_Domain_Forkortet() {
		if ( Get_Domain_Lang().indexOf("focalprice") > -1 ) {
			return "FP";
		}
		if ( Get_Domain_Lang().indexOf("aliexpress") > -1 ) {
			return "AE";
		}
		if ( Adresse.toString().indexOf("dhgate") > -1 ) {
			return "DGH";
		}
		if ( Adresse.toString().indexOf("1on1dropship") > -1 ) {
			return "1on1";
		}
		return null;
	}

	public String Get_CompleteContent() throws Exception {
		try {
			
			if ( !CompleteContentFile.exists() ) {
				return "";
			}
			FileInputStream fstream = new FileInputStream ( CompleteContentFile );
			DataInputStream in = new DataInputStream ( fstream );
			int Teller = 0;
			Pause = true;
			String CompleteContent = "";
			String Innlest = in.readLine ( );
			while ( Innlest != null  ) {
				//System.out.println( "Innlest A="+Innlest );
				
				CompleteContent = CompleteContent + Innlest;
				Innlest = in.readLine ( );
				//System.out.println( "Innlest B="+Innlest );
			}
			Pause = false;
			in.close ( );
			//Class_Controller.AddProgressMessage( "Loaded item type settings" );
			//System.out.println( this.getClass().toString()+" LoadItemTypes 2 Pause="+Pause );
			return CompleteContent;
		} catch ( NullPointerException e ) {
			//Class_Controller.ReportError(e, this.getClass().toString()+" LoadItemTypeSettings" );
		} catch ( Exception e ) {
			System.err.println( this.getClass().toString()+" LoadItemTypes finner ikke settingsfilen" );
			//Class_Controller.ReportError(e, this.getClass().toString()+" LoadItemTypeSettings" );
		}
		return "";
	}

	public void Set_CompleteContent( String Content ) throws Exception {
		//System.out.println( this.getClass().toString()+" Set_CompleteContent Content="+Content.length() );
		//System.out.println( this.getClass().toString()+" Set_CompleteContent CompleteContentFile="+CompleteContentFile );
		if (!CompleteContentFile.getParentFile().exists())
			CompleteContentFile.getParentFile().mkdirs();
		try {
			PrintStream utfil;
			CompleteContentFile.delete ( );//tømmer fila
			FileOutputStream appendFilen = new FileOutputStream ( CompleteContentFile, true );
			utfil = new PrintStream ( appendFilen );
			utfil.println ( Content );
			utfil.close ( );
		} catch ( Exception T ) {
			System.err.println( this.getClass().toString()+" Set_CompleteContent CompleteContentFile="+CompleteContentFile );
			//Class_Controller.ReportError( T, this.getClass().toString()+" Set_CompleteContent" );
		}
	}

	public boolean Get_AcceptedCategory() throws Exception {
		return this.AcceptedCategory;
	}

	public void Set_AcceptedCategory( boolean itemTypeAccepted, String Reason, Controller class_Controller, String Category ) throws Exception {
		//System.out.println( this.getClass().toString()+" Set_AcceptedCategory Category="+Category );
		if ( itemTypeAccepted == false ) {
			class_Controller.Print_RejectedLink( this, Reason );
		}
		AcceptedCategory = itemTypeAccepted;
		this.Category = Category;
	}
}
