package URLs;

import java.net.URL;
import java.util.Date;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Control.Controller;
import Searching.Object_SearchJob;

public class Thread_URLFinder_1on1 extends Thread_URLFinder {

	public Thread_URLFinder_1on1(Controller class_Controller, Object_SearchJob hentetJobb) {
		super(class_Controller, hentetJobb);
	}
	
	
	@Override
	public void SplitLine1( String Pagecontent ) throws Exception {
		Pagecontent = Pagecontent.toLowerCase();

		Jobb.TargetOffer.Get_Adresse().URLs_Started = true;
		//StringTokenizer token = new StringTokenizer(Pagecontent);
		Date Naa = new Date();
		//System.out.println( Naa.getHours()+":"+Naa.getMinutes()+":"+Naa.getSeconds()+" "+this.getClass().toString()+" SplitLine1" );
		int count = 0;
		String Frase = Pagecontent;

			Frase = Frase.replaceAll( "href=\"javascript:void(0);\"", "");

			boolean FantProd = false;
			while ( ( Frase.indexOf("/modules/") > -1 ) || ( Frase.indexOf("view.asp?prodcode=") > -1 ) ) {
				Class_Controller.SetCurrentAction( "Searching for links in URL "+this.Jobb.Get_Adresse().toString() );
				int Progress = ( Frase.length() * 100 ) / Pagecontent.length();
				//Class_Controller.SetCurrentAction( "Searching for links in URL, "+Progress+"% complete for "+this.Jobb.Get_Adresse().toString() );
				//System.out.println( "Frase.length()="+Frase.length() );
				int Loc1 = Math.max( 0, Frase.indexOf("/modules/") );
				int Loc2 = Math.max( 0, Frase.indexOf("view.asp?prodcode=") );
				int Loc3 = Loc2+1;
				if ( Loc1 > 0 ) { 
					Loc3 = Loc1;
				}
				if ( Loc2 > 0 ) { 
					//Loc2 = 99;
					Loc3 = Math.min( Loc3, Loc2);
				}
				String Addresse1 = Frase.substring( Loc3 );
				//System.out.println("Loc1="+Loc1+" Loc2="+Loc2+" Loc3="+Loc3 );
				String Addresse2 = Addresse1.substring(0, Math.min( Addresse1.length(), 100) );
				//System.out.println( "Addresse2="+Addresse2 );
				//System.out.println("AddresseURL vs view.asp?prodcode=="+Addresse2.indexOf("view.asp?prodcode=") );
				if ( Addresse2.indexOf("view.asp?prodcode=") > -1 ) {
					FantProd = true;
				}

				Addresse2 = Addresse2.replaceAll( "href='", "");
				//if ( ( AddresseURL.indexOf("manufacturers") == -1 ) && ( AddresseURL.indexOf("ranges.asp?catid=") == -1 ) && ( AddresseURL.indexOf("default") == -1 ) ) {
				if ( FantProd == true ) {
					//System.out.println( "AddresseURL B="+AddresseURL );
				}
				if ( Addresse2.indexOf("'") > -1 ) {
					Addresse2 = Addresse2.substring( 0, Addresse2.indexOf("'") );
				}
				if ( Addresse2.indexOf("\"") > -1 ) {
					Addresse2 = Addresse2.substring( 0, Addresse2.indexOf("\"") );
				}
				String Adresse3 = Addresse2; 
				if ( Adresse3.indexOf(".gif") > -1 ) {
					Adresse3 = "";
				}
				if ( Adresse3.indexOf(".jpg") > -1 ) {
					Adresse3 = "";
				}

				if ( Adresse3.equals( "" ) == false ) {

					String AddresseURLA = "https://www.1on1dropship.co.uk/";
					if ( ( FantProd == true ) && ( Adresse3.indexOf("modules") == -1 ) ) {
						AddresseURLA = AddresseURLA+"modules/";
					}
					AddresseURLA = AddresseURLA+Adresse3;
					
					String AddresseURLB = "https://www.1on1dropship.co.uk";
					if ( ( FantProd == true ) && ( Adresse3.indexOf("modules") == -1 ) ) {
						AddresseURLB = AddresseURLB+"/modules";
					}
					AddresseURLB = AddresseURLB+Adresse3;
					
					if ( AddresseURLA.indexOf("https://www.1on1dropship.co.uk//") > -1 ) {
						AddresseURLA = "";
					}
					if ( ProperUrl( AddresseURLA ) == true ) {

						count++;
						Object_URL nyURL = new Object_URL( AddresseURLA, FigureRelatedValue( AddresseURLA ), Class_Controller, Jobb.TargetOffer.Get_Adresse(), Jobb.TargetOffer.Get_Adresse().Layer+1 );
						Object_URL IntelligentParent = this.IntelligentParent( new URL( AddresseURLA ) ) ;
						if ( IntelligentParent != null ) {
							nyURL.ParentURL = IntelligentParent;
							nyURL.IsImagePage = true;
						}
						
						Jobb.LinksOut ++;
						//System.out.println( this.getClass().toString()+" SplitLine1 A fant ny link out:"+AddresseURLA+" count="+Jobb.LinksOut );
						this.Class_Controller.SaveNewURL( nyURL );
					} else if ( ProperUrl( AddresseURLB ) == true ) {

						count++;
						Object_URL nyURL = new Object_URL( AddresseURLB, FigureRelatedValue( AddresseURLB ), Class_Controller, Jobb.TargetOffer.Get_Adresse(), Jobb.TargetOffer.Get_Adresse().Layer+1 );
						Object_URL IntelligentParent = this.IntelligentParent( new URL( AddresseURLB ) ) ;
						if ( IsImagePage(AddresseURLB) == true ) {
							nyURL.IsImagePage = true;
							if ( IntelligentParent != null ) {
								nyURL.ParentURL = IntelligentParent;
								//System.out.println( this.getClass().toString()+" SplitLine1 Fant extra bilder. Forelder="+IntelligentParent.Adresse.toString() );
							} else {
								String Adresse = AddresseURLB;
								int Fra = Adresse.toString().indexOf( "prodcode=" )+"prodcode=".length();
								int Til = Adresse.toString().indexOf( "&imgnum" );
								if ( Til == -1 ) {
									Til = Adresse.toString().length();
								}
								String ProductCode = Adresse.toString().substring( Fra, Til );
								System.out.println( this.getClass().toString()+" SplitLine1 B ProductCode="+ProductCode );
								String ParentURL = "https://www.1on1dropship.co.uk/modules/view.asp?prodcode="+ProductCode;
								IntelligentParent = new Object_URL( ParentURL, FigureRelatedValue( ParentURL ), Class_Controller, Jobb.TargetOffer.Get_Adresse(), Jobb.TargetOffer.Get_Adresse().Layer+1 );
								Class_Controller.SaveNewURL( IntelligentParent );
								nyURL.ParentURL = IntelligentParent;
							}
						}
						Class_Controller.SaveNewURL( nyURL );
						Jobb.LinksOut ++;
						//System.out.println( this.getClass().toString()+" SplitLine1 B fant ny link out:"+AddresseURLA+" count="+Jobb.LinksOut );
						this.Class_Controller.SaveNewURL( nyURL );
					}
					
				}
				Frase = Frase.substring( Loc3 );
				try {
					Frase = Frase.replaceAll( Addresse2, "");
				} catch ( Exception e ) {
					System.err.println( "Klarte ikke stusse Frase: "+Frase+" skal få fjernet "+Addresse2+" ("+Frase.indexOf( Addresse2 )+")" );
				}  
				try {
					Frase = Frase.substring( Frase.indexOf( Addresse2 )+Addresse2.length() );
				} catch ( Exception e ) {
					System.err.println( "Klarte ikke stusse Frase: "+Frase+" skal få fjernet "+Addresse2+" ("+Frase.indexOf( Addresse2 )+")" );
				} 
			}
			Frase = "";

		//}
		Naa = new Date();
		//System.out.println( Naa.getHours()+":"+Naa.getMinutes()+":"+Naa.getSeconds()+" "+this.getClass().toString()+" SplitLine1 ferdig" );
		Jobb.TargetOffer.Get_Adresse().URLs_Finished = true;
		Class_Controller.Save_SearchJob(Jobb);
	}

}
