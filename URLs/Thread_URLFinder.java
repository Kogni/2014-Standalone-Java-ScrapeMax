package URLs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.SocketException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;

import Control.Controller;
import Offers.Object_Product_Offer;
import Searching.Object_SearchJob;

public class Thread_URLFinder extends Thread {
	
	Controller Class_Controller;
	public Object_SearchJob Jobb;

	public Thread_URLFinder(Controller class_Controller, Object_SearchJob hentetJobb) {
		Date Naa = new Date();
		//System.out.println( Naa.getHours()+":"+Naa.getMinutes()+":"+Naa.getSeconds()+" "+this.getClass().toString()+" constructor" );
		this.Jobb = hentetJobb;
		this.Class_Controller = class_Controller;
	}
	
	public void run() {
		if ( Jobb.TargetOffer.Get_Adresse().URLs_Started == true ) {
			return;
		}
		try {
			SplitLine1( Jobb.Get_CompleteContent() );
			this.Class_Controller.SearchJobProgressed(Jobb, this.getClass().toString() );
		} catch ( Exception e ) {
			try {
				Class_Controller.ReportError( e, this.getClass().toString()+" run" );
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	
	public void SplitLine1( String Pagecontent ) throws Exception {
		
	}
	
	public boolean ProperUrl( String Address ) {
		String HTTPCheck = Address;
		HTTPCheck = HTTPCheck.replace("http", "");
		if ( HTTPCheck.indexOf("http") > -1 ) {
			return false;
		}
		if ( HTTPCheck.indexOf("@") > -1 ) {
			return false;
		}
		try {
			URL Test = new URL( Address );
			
			HttpURLConnection connection = (HttpURLConnection) Test.openConnection();
			connection.setReadTimeout( 1500 );
            URLConnection conn =  Test.openConnection();

            conn.setRequestProperty("User-Agent", "Mozilla/5.0 (X11; U; Linux x86_64; en-GB; rv:1.8.1.6) Gecko/20070723 Iceweasel/2.0.0.6 (Debian-2.0.0.6-0etch1)");
            
            BufferedReader in = new BufferedReader( new InputStreamReader(conn.getInputStream()) );
            return true;
		} catch ( ConnectException T ) { //time-out
			return true;
		} catch ( SocketException T ) { //serverproblem
			return true;
		} catch (Exception e) {
			//Class_Controller.ReportError( e );
		}
		return false;
	}
	
	public int FigureRelatedValue( String AddresseURL ) throws Exception {
		if ( AddresseURL.length() < Class_Controller.Get_SelectedDropshipper( this.getClass().toString()+" FigureRelatedValue" ).DropshipperName.length() ) {
			return -999999;
		}
		int RelationValue = Jobb.Get_SelfRelationValue()+Class_Controller.CheckRelationValue_URL( AddresseURL );
		Object_URL URL = new Object_URL( AddresseURL, RelationValue, Class_Controller, Jobb.TargetOffer.Get_Adresse(), Jobb.TargetOffer.Get_Adresse().Layer+1 );
		Object_SearchJob Test = new Object_SearchJob( URL, Class_Controller, Jobb.Searchtype, this.getClass().toString()+" FigureRelatedValue" );
		int LinkedRelationValue = Test.Get_LinkedRelationValue();
		if ( ( Class_Controller.isProductPage(AddresseURL) == true ) && ( Class_Controller.isProductPage(Jobb.Get_Adresse().toString()) == true ) ) {
			return Test.Get_LinkedRelationValue();
		} else if ( ( Class_Controller.isProductPage(AddresseURL) == false ) && ( Class_Controller.isProductPage(Jobb.Get_Adresse().toString()) == true ) ) {
			return Test.Get_LinkedRelationValue()-( Class_Controller.isProductPage(AddresseURL)? 1 : 0 * 100000 );
		} else if ( ( Class_Controller.isProductPage(AddresseURL) == true ) && ( Class_Controller.isProductPage(Jobb.Get_Adresse().toString()) == false ) ) {
			return Test.Get_LinkedRelationValue()+( Class_Controller.isProductPage(AddresseURL)? 1 : 0 * 100000 );
		} else {
			return Test.Get_LinkedRelationValue();
		}
	}
	
	public boolean IsImagePage( String Adresse ) {
		return ( Adresse.toString().indexOf( "viewimage_adv2.asp?prodcode=" ) > -1 );
	}
	
	public Object_URL IntelligentParent( URL Adresse ) throws Exception {
		//https://www.1on1dropship.co.uk/modules/viewimage_adv2.asp?prodcode=N8820&imgnum=1
		//https://www.1on1dropship.co.uk/modules/view.asp?prodcode=N8820
		if ( IsImagePage( Adresse.toString() ) ) { //dette er en side dedikert til extra-bilder for et produkt
			int Fra = Adresse.toString().indexOf( "prodcode=" )+"prodcode=".length();
			int Til = Adresse.toString().indexOf( "&imgnum" );
			if ( Til == -1 ) {
				Til = Adresse.toString().length();
			}
			String ProductCode = Adresse.toString().substring( Fra, Til );
			Object_SearchJob Found = Class_Controller.Get_Page_ObjectURL( "https://www.1on1dropship.co.uk/modules/view.asp?prodcode="+ProductCode );
			if ( Found != null ) {
				Date Naa = new Date();
				//System.out.println( Naa.getHours()+":"+Naa.getMinutes()+":"+Naa.getSeconds()+" "+this.getClass().toString()+" IntelligentParent Parent="+Found.TargetOffer.Get_Adresse().Get_Adresse().toString()+" "+Found.TargetOffer.ImageText.length() );
				return Found.TargetOffer.Get_Adresse(); //returner produktsiden som hører til
			} else {
				return null;
			}
			//String adresse, int RelationValue, Controller Class_Controller, Object_URL ParentURL, int Layer
			//return new Object_URL( "https://www.1on1dropship.co.uk/modules/view.asp?prodcode="+ProductCode, RelationValue, Class_Controller,  );
		}
		return null;
	}

}
