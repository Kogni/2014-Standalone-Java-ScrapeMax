package Searching;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.SocketException;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;
import java.util.Date;

import Control.Controller;

public class Thread_DownloadPage extends Thread {
	
	Controller Class_Controller;
	Object_SearchJob Jobb;
	Date Idag = new Date();

	public Thread_DownloadPage( Controller Class_Controller, Object_SearchJob Jobb ) {
		Date Naa = new Date();
		if ( Class_Controller.isProductPage( Jobb.TargetOffer.Get_Adresse().Get_Adresse().toString() ) == true ) {
			//System.out.println( Naa.getHours()+":"+Naa.getMinutes()+":"+Naa.getSeconds()+" "+this.getClass().toString()+" constructor" );
		}
		this.Class_Controller = Class_Controller;
		this.Jobb = Jobb;
	}
	
	public void run() {
		//System.out.println( this.getClass().toString()+" run" );
		Idag = new Date();
		try {
			Scan();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void Scan() throws Exception {
		if ( Jobb.TargetOffer.Get_Adresse().Download_Started == true ) {
			return;
		}
		Jobb.TargetOffer.Get_Adresse().Download_Started = true;
		Class_Controller.SetCurrentAction( "Downloading page: "+Jobb.Get_Adresse().toString() );
		//System.out.println ( this+" Scanner url #A="+Jobb.Get_Adresse().toString()  );

		URL url = Jobb.Get_Adresse();
		String temp = url.toString().replaceAll(" ", "+");

		try {
			url = new URL( temp );
		} catch ( Exception T) {
			Class_Controller.ReportError(T, this.getClass().toString()+" Scan" );
		}

		try {
			StringBuffer DataImported = new StringBuffer();
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            URLConnection conn =  url.openConnection();
            conn.setRequestProperty("User-Agent", "Mozilla/5.0 (X11; U; Linux x86_64; en-GB; rv:1.8.1.6) Gecko/20070723 Iceweasel/2.0.0.6 (Debian-2.0.0.6-0etch1)");
            BufferedReader in = new BufferedReader( new InputStreamReader(conn.getInputStream()) );
            String str;
            //System.gc();
            while ((str = in.readLine()) != null) {
                    DataImported.append( str );
            }
            String Content;
            if ( DataImported != null ) {
            	Content = DataImported.toString();
                if ( Content != null ) {
                	Jobb.Set_CompleteContent( Content );
                	Jobb.TargetOffer.Get_Adresse().Download_Finished = true;
                    //Class_Controller.Save_DownloadedPage( Jobb );
                    Class_Controller.Save_SearchJob( Jobb );
                    return;
                }
            }
            Scan();
		} catch ( ConnectException T ) { //time-out
			Jobb.TargetOffer.Get_Adresse().Download_Started = false;
			Class_Controller.Set_DropshipperDowntime( Jobb.TargetOffer.Get_Adresse().Get_Domain_Lang(), new Date() );
			Jobb.TargetOffer.Get_Adresse().RelationValue_Linked --;
			Class_Controller.AddProgressMessage( "ERROR: Time-out mot "+temp+". Prøver igjen senere." );
			this.Class_Controller.SaveNewURL( Jobb.TargetOffer.Get_Adresse() );
		} catch ( SocketException T ) {
			Jobb.TargetOffer.Get_Adresse().Download_Started = false;
			Class_Controller.Set_DropshipperDowntime( Jobb.TargetOffer.Get_Adresse().Get_Domain_Lang(), new Date() );
			Jobb.TargetOffer.Get_Adresse().RelationValue_Linked --;
			Class_Controller.AddProgressMessage( "ERROR: Feil ved tilkobling mot "+temp+". Prøver igjen senere." );
			this.Class_Controller.SaveNewURL( Jobb.TargetOffer.Get_Adresse() );
		} catch ( UnknownHostException T ) {
			Jobb.TargetOffer.Get_Adresse().Download_Started = false;
			Jobb.TargetOffer.Get_Adresse().RelationValue_Linked --;
			this.Class_Controller.SaveNewURL( Jobb.TargetOffer.Get_Adresse() );
		} catch ( FileNotFoundException T ) {
			//Class_Controller.ReportError(T, this.getClass().toString()+" Scan" );
			Jobb.TargetOffer.Get_Adresse().Download_Finished = true;
		} catch ( IOException T ) {
			//Class_Controller.ReportError(T);
			Jobb.TargetOffer.Get_Adresse().Download_Finished = true;
		} catch ( IllegalArgumentException T ) {
			Class_Controller.ReportError(T, this.getClass().toString()+" Scan" );
			Jobb.TargetOffer.Get_Adresse().Download_Finished = true;
		} catch ( Exception T ) {
			Class_Controller.ReportError(T, this.getClass().toString()+" Scan" );
			Jobb.TargetOffer.Get_Adresse().Download_Finished = true;
		}

	}

}
