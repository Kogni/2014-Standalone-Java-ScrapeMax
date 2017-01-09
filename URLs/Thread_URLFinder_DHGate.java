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


public class Thread_URLFinder_DHGate extends Thread_URLFinder {
	
	public Thread_URLFinder_DHGate(Controller class_Controller, Object_SearchJob hentetJobb) {
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
				String Addresse = m.group(1);
				String AddresseURL = Addresse;
				AddresseURL = AddresseURL.replaceAll( "href=\"", "");
				if ( ProperUrl( AddresseURL ) == true ) {
					count++;
					Jobb.LinksOut ++;
					Object_URL nyURL = new Object_URL( AddresseURL, FigureRelatedValue( AddresseURL ), Class_Controller, Jobb.TargetOffer.Get_Adresse(), Jobb.TargetOffer.Get_Adresse().Layer+1 );
					this.Class_Controller.SaveNewURL( nyURL );
				} else if ( ProperUrl( "http://www.dhgate/"+AddresseURL ) == true ) {
					count++;
					Jobb.LinksOut ++;
					Object_URL nyURL = new Object_URL( "http://www.dhgate/"+AddresseURL, FigureRelatedValue( AddresseURL ), Class_Controller, Jobb.TargetOffer.Get_Adresse(), Jobb.TargetOffer.Get_Adresse().Layer+1 );
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
