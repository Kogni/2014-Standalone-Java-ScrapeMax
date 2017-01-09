package URLs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.SocketException;
import java.net.URL;
import java.net.URLConnection;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Searching.Object_SearchJob;


import Control.Controller;


public class Thread_URLFinder_AliExpress extends Thread_URLFinder {
	
	public Thread_URLFinder_AliExpress(Controller class_Controller, Object_SearchJob hentetJobb) {
		super(class_Controller, hentetJobb);

	}
	
	@Override
	public void SplitLine1( String Pagecontent ) throws Exception {

		Jobb.TargetOffer.Get_Adresse().URLs_Started = true;
		StringTokenizer token = new StringTokenizer(Pagecontent);
		//System.out.println( "Thread_URLFinder_FP SplitLine1 started. tokens="+token.countTokens()+" fra "+this.URLsource );
		int count = 0;
		String Frase = "";
		while ( token.hasMoreTokens() ){
			Frase = token.nextToken(); //<- Henter 1 og 1 string fra pagecontent
			Frase = Frase.replaceAll( "href=\"javascript:void(0);\"", "");
			//System.out.println("Tokens left: "+token.countTokens());
			
			Pattern Regex = Pattern.compile( "(href=\".+html)" );
			Matcher m = Regex.matcher( Frase );
			m = Regex.matcher( Frase );
			while ( m.find() ) {
				Class_Controller.SetCurrentAction( "Searching for links in URL "+this.Jobb.Get_Adresse().toString() );
				String Addresse = m.group(1);
				String AddresseURL = Addresse;
				if ( AddresseURL.indexOf("http://www.aliexpress.com") == -1 ) {
					AddresseURL = "";
				}
				if ( AddresseURL.indexOf("http://www.aliexpress.com/help") > -1 ) {
					AddresseURL = "";
				}
				if ( Class_Controller.Get_SelectedSearchtype( this.getClass().toString()+" SplitLine1" ).equals("Shop scan") == true ) {
					if ( AddresseURL.indexOf("http://www.aliexpress.com/store/") == -1 ) {
						AddresseURL = "";
					}
				}
				if ( AddresseURL.indexOf("http://www.aliexpress.com/store/feedback") > -1 ) {
					AddresseURL = "";
				}
				if ( AddresseURL.indexOf("message.aliexpress") > -1 ) {
					AddresseURL = "";
				}
				if ( AddresseURL.indexOf("http://www.aliexpress.com/promotion") > -1 ) {
					AddresseURL = "";
				}
				if ( AddresseURL.indexOf("http://www.aliexpress.com/wholesale") > -1 ) {
					AddresseURL = "";
				}
				if ( AddresseURL.indexOf("http://www.aliexpress.com/price") > -1 ) {
					AddresseURL = "";
				}
				if ( AddresseURL.indexOf(">") > -1 ) {
					AddresseURL = AddresseURL.substring( 0, AddresseURL.indexOf(">") );
				}
				AddresseURL = AddresseURL.replaceAll( "href=\"", "");
				//System.out.println( "AddresseURL="+AddresseURL );
				if ( ProperUrl( AddresseURL ) == true ) {
					count++;
					Jobb.LinksOut ++;
					Object_URL nyURL = new Object_URL( AddresseURL, FigureRelatedValue( AddresseURL ), Class_Controller, Jobb.TargetOffer.Get_Adresse(), Jobb.TargetOffer.Get_Adresse().Layer+1 );
					this.Class_Controller.SaveNewURL( nyURL );
				} else if ( ProperUrl( "http://www.aliexpress.com/"+AddresseURL ) == true ) {
					count++;
					Jobb.LinksOut ++;
					Object_URL nyURL = new Object_URL( "http://www.aliexpress.com/"+AddresseURL, FigureRelatedValue( AddresseURL ), Class_Controller, Jobb.TargetOffer.Get_Adresse(), Jobb.TargetOffer.Get_Adresse().Layer+1 );
					this.Class_Controller.SaveNewURL( nyURL );
				}
				
				try {
					Frase = Frase.replaceAll( Addresse, "");
				} catch ( Exception e ) {
					Class_Controller.ReportError( e, this.getClass().toString()+" SplitLine1" );
				}   
			}

		}
		Jobb.TargetOffer.Get_Adresse().URLs_Finished = true;
		Class_Controller.Save_SearchJob(Jobb);
	}
}
