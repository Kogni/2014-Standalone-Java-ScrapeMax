package Offers;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;

import Control.Controller;
import Searching.Object_SearchJob;

public class Thread_Identify_1on1 extends Thread_Identify{

	public Thread_Identify_1on1( Controller Class_Controller, Object_SearchJob hentetJobb ) {
		super( Class_Controller, hentetJobb );
	}

	@Override
	public void FinnFrontbilde( String Buffer ) throws Exception {
		//slått av for å bruke extra-bilde som frontbilde
		Date Start = new Date();
		String Temp = Buffer;
		//FRA
		if ( Temp.indexOf( "viewprodleft" ) > -1 ) {
			Temp = Temp.substring( Temp.indexOf( "viewprodleft" ) + "viewprodleft".length() );
		}
		if ( Temp.indexOf( "<div class='viewprodimagebox'>" ) > -1 ) {
			Temp = Temp.substring( Temp.indexOf( "<div class='viewprodimagebox'>" ) + "<div class='viewprodimagebox'>".length() );
		}
		//TIL
		if ( Temp.indexOf( "viewpagetextlinks" ) > -1 ) {
			Temp = Temp.substring( 0, Temp.indexOf( "viewpagetextlinks" ) );
		}
		if ( Temp.indexOf( "Manufacturer".toLowerCase() ) > -1 ) {
			Temp = Temp.substring( 0, Temp.indexOf( "Manufacturer".toLowerCase() ) );
		}
		if ( Temp.indexOf( "background=" ) > -1 ) {
			Temp = Temp.substring( 0, Temp.indexOf( "background=" ) );
		}
		if ( Temp.indexOf( "Enlarge Image=".toLowerCase() ) > -1 ) {
			Temp = Temp.substring( 0, Temp.indexOf( "Enlarge Image=".toLowerCase() ) );
		}
		//INNSKRENK FORAN
		//System.out.println( this.getClass().toString()+" FinnFrontbilde A Temp="+Temp);
		if ( Temp.indexOf( "<img" ) > -1 ) {
			Temp = Temp.substring( Temp.indexOf( "<img" ) + "<img".length() );
		}
		if ( Temp.indexOf( "src = \"" ) > -1 ) {
			Temp = Temp.substring( Temp.indexOf( "src = \"" ) + "src = \"".length() );
		}
		if ( Temp.indexOf( "src=\"" ) > -1 ) {
			Temp = Temp.substring( Temp.indexOf( "src=\"" ) + "src=\"".length() );
		}
		if ( Temp.indexOf( "src" ) > -1 ) {
			Temp = Temp.substring( Temp.indexOf( "src" ) + "src".length() );
		}
		if ( (Temp.indexOf( " = \"" ) > -1) && (Temp.indexOf( " = \"" ) < 10) ) {
			Temp = Temp.substring( Temp.indexOf( " = \"" ) + " = \"".length() );
		}
		if ( (Temp.indexOf( "='" ) > -1) && (Temp.indexOf( "='" ) < 10) ) {
			Temp = Temp.substring( Temp.indexOf( "='" ) + "='".length() );
		}
		if ( (Temp.indexOf( "'/" ) > -1) && (Temp.indexOf( "'/" ) < 10) ) {
			Temp = Temp.substring( Temp.indexOf( "'/" ) + "'/".length() );
		}
		if ( (Temp.indexOf( "=" ) > -1) && (Temp.indexOf( "=" ) < 10) ) {
			Temp = Temp.substring( Temp.indexOf( "=" ) + "=".length() );
		}
		//INNSKRENK BAK
		//System.out.println( this.getClass().toString()+" FinnFrontbilde B Temp="+Temp);
		if ( Temp.indexOf( "border" ) > -1 ) {
			Temp = Temp.substring( 0, Temp.indexOf( "border" ) );
		}
		if ( Temp.indexOf( "\";" ) > -1 ) {
			Temp = Temp.substring( 0, Temp.indexOf( "\";" ) );
		}
		if ( Temp.indexOf( "'" ) > -1 ) {
			Temp = Temp.substring( 0, Temp.indexOf( "'" ) );
		}
		if ( Temp.indexOf( "\"" ) > 5 ) {
			Temp = Temp.substring( 0, Temp.indexOf( "\"" ) );
		}
		//EDIT URL
		//System.out.println( this.getClass().toString()+" FinnFrontbilde C Temp="+Temp);
		if ( (Temp.indexOf( "1on1dropship.co.uk" ) == -1) && (Temp.indexOf( "1on1wholesale.co.uk" ) == -1) ) {
			Temp = "https://www.1on1dropship.co.uk" + Temp;
		}
		try {
			Jobb.TargetOffer.Set_FrontBilde( new URL( Temp ) );
		}
		catch ( MalformedURLException T ) {
			ForkastURL( Buffer, "bad front picture" );
			return;
		}
		catch ( Exception T ) {
			this.Class_Controller.ReportError( T, this.getClass().toString() + " FinnFrontbilde" );
			ForkastURL( Buffer, "bad front picture" );
			return;
		}
		if ( Jobb.TargetOffer.Get_Image() == null ) {
			System.out.println( "Forkaster URL pga ikke frontbilde: " + Jobb.Get_Adresse().toString() );
			ForkastURL( Buffer, "no front picture" );
			return;
		}
		Date Slutt = new Date();
		int Tid = (int) (Slutt.getTime() - Start.getTime());
		if ( Tid > 0 ) {
			//System.out.println( this.getClass().toString()+" FinnFrontbilde Arbeidstid="+Tid );
		}
	}

	@Override
	public void FinnObjectID( String Buffer ) throws Exception {
		Date Start = new Date();
		String Temp_ObjectID = null;
		Temp_ObjectID = Jobb.Get_Adresse().toString();
		Temp_ObjectID = Temp_ObjectID.substring( Temp_ObjectID.indexOf( "=" ) + "=".length() );

		Jobb.TargetOffer.Set_ObjectID( Temp_ObjectID );
		if ( Temp_ObjectID == null ) {
			//System.out.println( "Forkaster URL pga ingen object ID: " + Jobb.Get_Adresse().toString() + " " + Buffer.indexOf( "objectId".toLowerCase() ) );
			ForkastURL( Buffer, "no object ID" );
			return;
		}
		Date Slutt = new Date();
		int Tid = (int) (Slutt.getTime() - Start.getTime());
		if ( Tid > 0 ) {
			//System.out.println( this.getClass().toString()+" FinnObjectID Arbeidstid="+Tid );
		}
	}

	@Override
	public void FinnBilder( String Buffer ) throws Exception {
		//System.out.println( this.getClass().toString()+" FinnBilder "+Jobb.Get_Adresse().toString() );
		Date Start = new Date();
		boolean found = false;
		String EditedBuffer = Buffer;

		//modules/images/alt-images/n8703-lelo_dare_me_pleasure_set-1.jpg" name="viewimg">
		//modules/images/alt-images/n8564-crystal_premium_glass_plug_medium_purple-1.jpg" name="viewimg">
		//modules/images/alt-images/hi_resolution/n8325-doc_johnson_platinum_the_lil_guy-1.jpg" name="viewimg">
		//1on1dropship-banner= images/new/dop.jpg
		///modules/images/N6744-Black_Level_PVC_Zip_Trousers.jpg

		Jobb.TargetOffer.ImageCount = 0;
		Jobb.TargetOffer.SavedImages = 0;
		//String Frontbilde = "";
		while ( (EditedBuffer.indexOf( ".jpg" ) > -1) || (EditedBuffer.indexOf( ".gif" ) > -1) ) {
			String Bilde = "";
			if ( EditedBuffer.indexOf( ".jpg" ) > -1 ) {
				Bilde = EditedBuffer.substring( Math.max( 0, (EditedBuffer.indexOf( ".jpg" ) - 100) ), (EditedBuffer.indexOf( ".jpg" ) + ".jpg".length()) );
			}
			if ( EditedBuffer.indexOf( ".gif" ) > -1 ) {
				Bilde = EditedBuffer.substring( Math.max( 0, (EditedBuffer.indexOf( ".gif" ) - 100) ), (EditedBuffer.indexOf( ".gif" ) + ".gif".length()) );
			}
			String Bilde2 = "";
			//System.out.println( this.getClass().toString()+" FinnBilder A "+Jobb.Get_Adresse().toString()+"-> Bilde A="+ Bilde );
			//src="/modules/images/alt-images/zoom/
			//src="/modules/images/alt-images/zoom/
			if ( Bilde.lastIndexOf( "/modules/images/alt-images/zoom/" ) > -1 ) { //thumbnail
				//ikke lagre thumbnails
				//                              /modules/images/alt-images/zoom/n8492-sex_and_mischief_feather_tickler_purple-1.gif
				///                              modules/images/alt-images/zoom/n8972-oui_fifi_rechargeable_vibrator-1.gif
				//https://www.1on1dropship.co.uk/modules/images/alt-images/hi_resolution/n8972-oui_fifi_rechargeable_vibrator-1.jpg
				//Bilde2 = Bilde.substring( Bilde.lastIndexOf("/modules/images/alt-images/zoom/") );
				//Bilde2 = Bilde2.substring( 0, (Bilde2.lastIndexOf(".gif")+".gif".length()) );
				//Bilde2 = "https://www.1on1dropship.co.uk/modules/images/alt-images/zoom/"+Bilde2;
				Bilde2 = Bilde.substring( Bilde.lastIndexOf( "/modules/images/alt-images/zoom/" ) + "/modules/images/alt-images/zoom/".length() );
				//n8972-oui_fifi_rechargeable_vibrator-1.gif
				Bilde2 = Bilde2.substring( 0, Bilde2.lastIndexOf( ".gif" ) );
				//n8972-oui_fifi_rechargeable_vibrator-1
				Bilde2 = "https://www.1on1dropship.co.uk/modules/images/alt-images/hi_resolution/" + Bilde2 + ".jpg";
				//System.out.println( this.getClass().toString()+" FinnBilder B Bilde2="+Bilde2);

			}
			else if ( Bilde.lastIndexOf( "/modules/images/alt-images/" ) > -1 ) { //thumbnail
				Bilde2 = Bilde.substring( Bilde.lastIndexOf( "/modules/images/alt-images/" ) + "/modules/images/alt-images/".length() );
				Bilde2 = Bilde2.substring( 0, (Bilde2.lastIndexOf( ".jpg" ) + ".jpg".length()) );
				Bilde2 = "https://www.1on1dropship.co.uk/modules/images/alt-images/hi_resolution/" + Bilde2;

			}
			else if ( Bilde.lastIndexOf( "/modules/images/alt-images/hi_resolution/" ) > -1 ) { //stor versjon
				Bilde2 = Bilde.substring( Bilde.lastIndexOf( "/modules/images/alt-images/hi_resolution/" ) + "/modules/images/alt-images/hi_resolution/".length() );
				Bilde2 = Bilde2.substring( 0, (Bilde2.lastIndexOf( ".jpg" ) + ".jpg".length()) );
				Bilde2 = "https://www.1on1dropship.co.uk/modules/images/alt-images/hi_resolution/" + Bilde2;
				//System.out.println( this.getClass().toString()+" FinnBilder C Bilde2="+Bilde2);

			}
			else if ( Bilde.lastIndexOf( "/modules/images/thumbs/" ) > -1 ) { //thumbnail
				Bilde2 = Bilde.substring( Bilde.lastIndexOf( "/modules/images/thumbs/" ) );
				Bilde2 = Bilde2.substring( 0, (Bilde2.lastIndexOf( ".gif" ) + ".gif".length()) );
				Bilde2 = "https://www.1on1dropship.co.uk/modules/images/thumbs/" + Bilde2;
				//System.out.println( this.getClass().toString()+" FinnBilder C2 Bilde2="+Bilde2);

			}
			else if ( Bilde.lastIndexOf( "src='/modules/images/" ) > -1 ) { //thumbnail
				Bilde2 = Bilde.substring( Bilde.lastIndexOf( "src='/modules/images/" ) );
				Bilde2 = Bilde2.substring( 0, (Bilde2.lastIndexOf( ".gif" ) + ".gif".length()) );
				Bilde2 = "https://www.1on1dropship.co.uk/modules/images/" + Bilde2;

			}
			else if ( Bilde.lastIndexOf( "src='/images/" ) > -1 ) { //skrot
				//System.out.println( this.getClass().toString()+" FinnBilder C");
			}
			else if ( Bilde.lastIndexOf( "src=\"/images/" ) > -1 ) { //skrot src=\"/images/
				//System.out.println( this.getClass().toString()+" FinnBilder D");
			}
			else if ( Bilde.lastIndexOf( "background=\"/images/" ) > -1 ) { //skrot
			}
			else if ( Bilde.lastIndexOf( "background='/images/" ) > -1 ) { //skrot
			}
			else if ( Bilde.lastIndexOf( "src='/customer_info/" ) > -1 ) { //skrot
			}
			else if ( Bilde.lastIndexOf( "url(/images/" ) > -1 ) { //skrot
			}
			else if ( Bilde.lastIndexOf( "src=\"images/" ) > -1 ) { //skrot
			}
			else if ( Bilde.lastIndexOf( "background-image:url(" ) > -1 ) { //skrot
			}
			else if ( Bilde.lastIndexOf( "http://www.1on1wholesale.co.uk/modules/images/manufacturerlogos/" ) > -1 ) { //skrot
				//System.out.println( this.getClass().toString()+" FinnBilder E");
				/*} else if ( Bilde.lastIndexOf("src=\"/") > -1 ) {
					Bilde2 = Bilde.substring( Bilde.lastIndexOf("src=\"/")+"src=\"/".length() );
					Bilde2 = Bilde2.substring( 0, (Bilde2.lastIndexOf(".jpg")+".jpg".length()) );
					Bilde2 = "https://www.1on1dropship.co.uk/"+Bilde2;
					Bilde2 = Bilde2.replaceAll("uk//", "uk/");
				} else if ( Bilde.lastIndexOf("src = \"/") > -1 ) {
					Bilde2 = Bilde.substring( Bilde.lastIndexOf("src = \"/")+"src = \"/".length() );
					Bilde2 = Bilde2.substring( 0, (Bilde2.lastIndexOf(".jpg")+".jpg".length()) );
					Bilde2 = "https://www.1on1dropship.co.uk/"+Bilde2;
					Bilde2 = Bilde2.replaceAll("uk//", "uk/");
				} else if ( Bilde.lastIndexOf("src='/") > -1 ) {
					Bilde2 = Bilde.substring( Bilde.lastIndexOf("src='/")+"src='/".length() );
					Bilde2 = Bilde2.substring( 0, (Bilde2.lastIndexOf(".jpg")+".jpg".length()) );
					Bilde2 = "https://www.1on1dropship.co.uk/"+Bilde2;
					Bilde2 = Bilde2.replaceAll("uk//", "uk/");
				} else if ( Bilde.lastIndexOf("= \"/") > -1 ) {
					Bilde2 = Bilde.substring( Bilde.lastIndexOf("= \"/")+"= \"/".length() );
					Bilde2 = Bilde2.substring( 0, (Bilde2.lastIndexOf(".jpg")+".jpg".length()) );
					Bilde2 = "https://www.1on1dropship.co.uk/"+Bilde2;
					Bilde2 = Bilde2.replaceAll("uk//", "uk/");
				} else if ( Bilde.lastIndexOf("background") > -1 ) {*/
			}
			else {
				System.out.println( this.getClass().toString() + " FinnBilder F: " + Bilde );
				if ( Jobb.TargetOffer.Get_Adresse().Get_Adresse().toString().indexOf( "prodcode" ) > -1 ) {
					System.out.println( this.getClass().toString() + " FinnBilder G klarte ikke snitte ut bilde. " + Jobb.Get_Adresse().toString() + "-> Bilde B=" + Bilde );
				}
			}
			//https://www.1on1dropship.co.uk/modules/images/alt-images/hi_resolution//modules/images/alt-images/zoom/n7065-cici_pleasure_wig-1.jpg
			//https://www.1on1dropship.co.uk/modules/images/alt-images/hi_resolution/n7065-cici_pleasure_wig-1.jpg
			if ( Bilde2.indexOf( "//" ) == 10 ) {
				Bilde2 = Bilde2.replaceAll( "//", "/" );
			}
			if ( Bilde2.indexOf( ".jpg" ) == -1 ) {
			}
			else if ( Bilde2.indexOf( "new/dop.jpg" ) > -1 ) {
			}
			else if ( Bilde2.indexOf( "/wholesalebanner.jpg" ) > -1 ) {
			}
			else if ( Bilde2.indexOf( "/meetclaire3.jpg" ) > -1 ) {
			}
			else if ( Bilde2.indexOf( "/bottomcurve.jpg" ) > -1 ) {
			}
			else if ( Bilde2.indexOf( "/footer.jpg" ) > -1 ) {
			}
			else if ( Bilde2.length() > 150 ) {
				System.out.println( this.getClass().toString() + " FinnBilder H forkastet bilde A1. " + Jobb.Get_Adresse().toString() + "-> Bilde=" + Bilde2 );
			}
			else if ( Bilde2.lastIndexOf( " " ) > -1 ) {
				System.out.println( this.getClass().toString() + " FinnBilder I forkastet bilde A2. " + Jobb.Get_Adresse().toString() + "-> Bilde=" + Bilde2 );
			}
			else {
				//System.out.println( this.getClass().toString()+" FinnBilder la til nytt bilde A. "+Jobb.Get_Adresse().toString()+"-> Bilde="+ Bilde2 );
				Jobb.TargetOffer.ImageCount++;
				Jobb.TargetOffer.ImageText = Jobb.TargetOffer.ImageText + "<img alt='ALTIMAGETEXT' src='" + Bilde2 + "' >";
				Jobb.TargetOffer.ImageRack = Jobb.TargetOffer.ImageRack + "~" + Bilde2;

				found = true;

				/*if ( Frontbilde.equals( "" ) && Jobb.TargetOffer.Get_Image().equals( "" ) ) {
					//Setter hovedbilde
					
					try {
						Frontbilde = Bilde2;
						
						Jobb.TargetOffer.Set_FrontBilde( new URL( Frontbilde ) );
					} catch ( MalformedURLException T ) {
						/*ForkastURL( Buffer, "bad front picture" );
						return;
					} catch ( Exception T ) {
						/*this.Class_Controller.ReportError( T, this.getClass().toString()+" FinnFrontbilde" );
						ForkastURL( Buffer, "bad front picture" );
						return;
					}
				}*/
			}
			//System.out.println( this.getClass().toString()+" FinnBilder "+Jobb.Get_Adresse().toString()+"-> Bilde B="+ Bilde );
			try {
				//System.out.println( this.getClass().toString()+" FinnBilder G "+Jobb.Get_Adresse().toString()+" replacer string" );
				if ( EditedBuffer.indexOf( Bilde ) > -1 ) {
					EditedBuffer = EditedBuffer.replaceAll( Bilde, "" );
					if ( EditedBuffer.indexOf( Bilde ) > -1 ) {
						//System.out.println( this.getClass().toString()+" FinnBilder H "+Jobb.Get_Adresse().toString()+" replace failed A" );
					}
				}
				if ( EditedBuffer.indexOf( Bilde ) > -1 ) {
					EditedBuffer = EditedBuffer.substring( EditedBuffer.indexOf( Bilde ) + Bilde.length() );
					if ( EditedBuffer.indexOf( Bilde ) > -1 ) {
						System.out.println( this.getClass().toString() + " FinnBilder J " + Jobb.Get_Adresse().toString() + " replace failed B" );
					}
				}
			}
			catch ( Exception T ) {
				//System.out.println( this.getClass().toString()+" FinnBilder J "+Jobb.Get_Adresse().toString()+" replace failed C" );
				break;
			}
		}

		/*if(!found){
			if ( this.Class_Controller.isProductPage( Jobb.Get_Adresse().toString() ) == true ) {
				System.out.println( "Forkaster URL pga ingen bilder: "+Jobb.Get_Adresse().toString() );
			}
			ForkastURL( Buffer, "ingen bilder" );
			return;
		}*/
		Date Slutt = new Date();
		int Tid = (int) (Slutt.getTime() - Start.getTime());
		if ( Tid > 0 ) {
			//System.out.println( this.getClass().toString()+" FinnBilder Arbeidstid="+Tid+" Buffer size="+Buffer.length() );
		}
	}

	@Override
	public void FinnDescription( String Buffer ) throws Exception {
		Date Start = new Date();

		Jobb.TargetOffer.Description = Buffer;
		if ( Jobb.TargetOffer.Description.indexOf( "<h3>Product Details</h3>".toLowerCase() ) > -1 ) {
			Jobb.TargetOffer.Description = Jobb.TargetOffer.Description.substring( Jobb.TargetOffer.Description.indexOf( "<h3>Product Details</h3>".toLowerCase() ) + "<h3>Product Details</h3>".length() );
			Jobb.TargetOffer.Description = Jobb.TargetOffer.Description.substring( 0, Jobb.TargetOffer.Description.indexOf( "</div>" ) );
			Jobb.TargetOffer.Description = Jobb.TargetOffer.Description.substring( Jobb.TargetOffer.Description.indexOf( "<div align=\"justify\" class=descript>" ) + "<div align=\"justify\" class=descript>".length() );
		}
		if ( Jobb.TargetOffer.Description.indexOf( "SBodyText".toLowerCase() ) > -1 ) {
			Jobb.TargetOffer.Description = Jobb.TargetOffer.Description.substring( Jobb.TargetOffer.Description.indexOf( "SBodyText\">".toLowerCase() ) + "SBodyText\">".length() );
		}
		if ( Jobb.TargetOffer.Description.indexOf( "/table>".toLowerCase() ) > -1 ) {
			Jobb.TargetOffer.Description = Jobb.TargetOffer.Description.substring( 0, Jobb.TargetOffer.Description.indexOf( "</table>" ) );
		}
		if ( Jobb.TargetOffer.Description == null ) {
			if ( this.Class_Controller.isProductPage( Jobb.Get_Adresse().toString() ) == true ) {
				System.out.println( "Forkaster URL pga ingen description#1: " + Jobb.Get_Adresse().toString() + " " + Buffer.indexOf( "<div class=\"description_m\">".toLowerCase() ) );
			}
			ForkastURL( Buffer, "no description" );
			return;
		}
		Date Slutt = new Date();
		int Tid = (int) (Slutt.getTime() - Start.getTime());
		if ( Tid > 0 ) {
			//System.out.println( this.getClass().toString()+" FinnDescription Arbeidstid="+Tid );
		}

	}

	@Override
	public void FinnKeywords( String Buffer ) {
		Date Start = new Date();
		if ( Buffer.indexOf( "<meta name=\"description\" content=\"" ) > -1 ) {
			Jobb.TargetOffer.Meta = Buffer.substring( Buffer.indexOf( "<meta name=\"description\" content=\"" ) + "<meta name=\"description\" content=\"".length() );
			Jobb.TargetOffer.Meta = Jobb.TargetOffer.Meta.substring( 0, 300 );
			if ( Jobb.TargetOffer.Meta.indexOf( "\" />" ) > -1 ) {
				Jobb.TargetOffer.Meta = Jobb.TargetOffer.Meta.substring( 0, Jobb.TargetOffer.Meta.indexOf( "\" />" ) );
				Jobb.TargetOffer.Meta = Jobb.TargetOffer.Meta.toLowerCase();
			}
			else {
				//System.out.println( this.getClass().toString()+" FinnKeywords fant ikke keywords: "+Jobb.TargetOffer.Meta );
				//System.out.println( this.getClass().toString()+" FinnKeywords adresse="+Jobb.TargetOffer.Get_Adresse().Get_Adresse().toString() );
			}
		}

		Date Slutt = new Date();
		int Tid = (int) (Slutt.getTime() - Start.getTime());
		if ( Tid > 0 ) {
			//System.out.println( this.getClass().toString()+" FinnKeywords Arbeidstid="+Tid );
		}

	}

	@Override
	public void FinnTittel( String Buffer ) {
		Date Start = new Date();
		try {
			Jobb.TargetOffer.Head = Buffer.substring( 0, Buffer.indexOf( "</head>" ) );
			Jobb.TargetOffer.Head = Jobb.TargetOffer.Head.substring( Jobb.TargetOffer.Head.indexOf( "<head>" ) );
			Jobb.TargetOffer.Head = Jobb.TargetOffer.Head.substring( 0, Jobb.TargetOffer.Head.indexOf( "</title>" ) );
			Jobb.TargetOffer.Head = Jobb.TargetOffer.Head.substring( Jobb.TargetOffer.Head.indexOf( "<title>" ) + "<title>".length() );
			Jobb.TargetOffer.Head = Jobb.TargetOffer.Head.toLowerCase();
		}
		catch ( Exception T ) {
			System.out.println( this.getClass().toString() + " FinnTittel no </head>: " + Jobb.TargetOffer.Get_Adresse().Get_Adresse().toString() );
		}
		Date Slutt = new Date();
		int Tid = (int) (Slutt.getTime() - Start.getTime());
		if ( Tid > 0 ) {
			//System.out.println( this.getClass().toString()+" FinnTittel Arbeidstid="+Tid );
		}
	}

	@Override
	public void FinnItemType( String Buffer ) throws Exception {
		Date Start = new Date();
		try {

			//CRUMBS
			if ( Buffer.indexOf( "<h3>Store /".toLowerCase() ) > -1 ) {
				Jobb.TargetOffer.Crumbs = Buffer.substring( Buffer.indexOf( "<h3>Store /".toLowerCase() ) + "<h3>Store /".length() );
				Jobb.TargetOffer.Crumbs = Jobb.TargetOffer.Crumbs.substring( 0, Jobb.TargetOffer.Crumbs.indexOf( "</h3>".toLowerCase() ) );
			}
			if ( Jobb.TargetOffer.Crumbs == null ) {
				//System.out.println( "Forkaster URL pga ingen crumbs: " + Jobb.Get_Adresse().toString() + "->" + Buffer.indexOf( "http://www.aliexpress.com/\">Home".toLowerCase() ) );
				ForkastURL( Buffer, "no crumbs found" );
				return;
			}

			//bearbeid crumbs
			while ( Jobb.TargetOffer.Crumbs.indexOf( "	" ) > -1 ) {
				Jobb.TargetOffer.Crumbs = Jobb.TargetOffer.Crumbs.replaceAll( "	", " " );
			}
			while ( Jobb.TargetOffer.Crumbs.indexOf( "  " ) > -1 ) {
				Jobb.TargetOffer.Crumbs = Jobb.TargetOffer.Crumbs.replaceAll( "  ", " " );
			}
			if ( Jobb.TargetOffer.Crumbs.indexOf( "</div>" ) > -1 ) {
				Jobb.TargetOffer.Crumbs = Jobb.TargetOffer.Crumbs.substring( 0, Jobb.TargetOffer.Crumbs.indexOf( "</div>" ) );
			}
			//System.out.println( this.getClass().toString()+" FinnItemType "+Jobb.Get_Adresse().toString()+" Crumbs A1: "+Jobb.TargetOffer.Crumbs );
			if ( Jobb.TargetOffer.Crumbs.toLowerCase().indexOf( "home" ) > -1 ) {
				Jobb.TargetOffer.Crumbs = Jobb.TargetOffer.Crumbs.substring( Jobb.TargetOffer.Crumbs.toLowerCase().indexOf( "home" ) );
			}
			if ( Jobb.TargetOffer.Crumbs.indexOf( "</h1>" ) > -1 ) {
				Jobb.TargetOffer.Crumbs = Jobb.TargetOffer.Crumbs.substring( 0, Jobb.TargetOffer.Crumbs.indexOf( "</h1>" ) );
			}
			if ( Jobb.TargetOffer.Crumbs.indexOf( "</h2>" ) > -1 ) {
				Jobb.TargetOffer.Crumbs = Jobb.TargetOffer.Crumbs.substring( 0, Jobb.TargetOffer.Crumbs.indexOf( "</h2>" ) );
			}
			if ( Jobb.TargetOffer.Crumbs.lastIndexOf( "</span>" ) > -1 ) {
				Jobb.TargetOffer.Crumbs = Jobb.TargetOffer.Crumbs.substring( 0, Jobb.TargetOffer.Crumbs.lastIndexOf( "</span>" ) );
			}
			if ( Jobb.TargetOffer.Crumbs.lastIndexOf( "</b>" ) > -1 ) {
				Jobb.TargetOffer.Crumbs = Jobb.TargetOffer.Crumbs.substring( 0, Jobb.TargetOffer.Crumbs.lastIndexOf( "</b>" ) );
			}
			//System.out.println( this.getClass().toString()+" FinnItemType "+Jobb.Get_Adresse().toString()+" Crumbs A2: "+Jobb.TargetOffer.Crumbs );

			//CATEGORY
			Jobb.TargetOffer.Category = Jobb.TargetOffer.Crumbs;
			if ( Jobb.TargetOffer.Category.lastIndexOf( "<a href" ) > -1 ) {
				Jobb.TargetOffer.Category = Jobb.TargetOffer.Category.substring( Jobb.TargetOffer.Category.lastIndexOf( "<a href" ) + "<a href".length() );
			}
			if ( Jobb.TargetOffer.Category.lastIndexOf( "</a>" ) > -1 ) {
				Jobb.TargetOffer.Category = Jobb.TargetOffer.Category.substring( 0, Jobb.TargetOffer.Category.lastIndexOf( "</a>" ) );
			}
			if ( Jobb.TargetOffer.Category.lastIndexOf( ">" ) > -1 ) {
				Jobb.TargetOffer.Category = Jobb.TargetOffer.Category.substring( Jobb.TargetOffer.Category.lastIndexOf( ">" ) + ">".length() );
			}
			if ( Jobb.TargetOffer.Category.lastIndexOf( "<b>" ) > -1 ) {
				Jobb.TargetOffer.Category = Jobb.TargetOffer.Category.substring( Jobb.TargetOffer.Category.lastIndexOf( "<b>" ) + "<b>".length() );
			}
			if ( Jobb.TargetOffer.Category.lastIndexOf( "<h2>" ) > -1 ) {
				Jobb.TargetOffer.Category = Jobb.TargetOffer.Category.substring( Jobb.TargetOffer.Category.lastIndexOf( "<h2>" ) + "<h2>".length() );
			}
			if ( Jobb.TargetOffer.Category.lastIndexOf( "\" >" ) > -1 ) {
				Jobb.TargetOffer.Category = Jobb.TargetOffer.Category.substring( Jobb.TargetOffer.Category.lastIndexOf( "\" >" ) + "\" >".length() );
			}

			//System.out.println( this.getClass().toString()+" FinnItemType Category A="+Jobb.Get_Adresse().toString()+" Category="+Jobb.TargetOffer.Category );

			//PARENTCATEGORY
			Jobb.TargetOffer.ParentCategory = Jobb.TargetOffer.Crumbs;
			Jobb.TargetOffer.ParentCategory = Jobb.TargetOffer.ParentCategory = Jobb.TargetOffer.ParentCategory.substring( 0, Jobb.TargetOffer.ParentCategory.lastIndexOf( Jobb.TargetOffer.Category ) );
			if ( Jobb.TargetOffer.ParentCategory.lastIndexOf( "<a href" ) > -1 ) {
				Jobb.TargetOffer.ParentCategory = Jobb.TargetOffer.ParentCategory.substring( Jobb.TargetOffer.ParentCategory.lastIndexOf( "<a href" ) + "<a href".length() );
			}
			if ( Jobb.TargetOffer.ParentCategory.lastIndexOf( "</a>" ) > -1 ) {
				Jobb.TargetOffer.ParentCategory = Jobb.TargetOffer.ParentCategory.substring( 0, Jobb.TargetOffer.ParentCategory.lastIndexOf( "</a>" ) );
			}
			if ( Jobb.TargetOffer.ParentCategory.lastIndexOf( ">" ) > -1 ) {
				Jobb.TargetOffer.ParentCategory = Jobb.TargetOffer.ParentCategory.substring( Jobb.TargetOffer.ParentCategory.lastIndexOf( ">" ) + ">".length() );
			}
			if ( Jobb.TargetOffer.ParentCategory.lastIndexOf( "<span>" ) > -1 ) {
				Jobb.TargetOffer.ParentCategory = Jobb.TargetOffer.ParentCategory.substring( 0, Jobb.TargetOffer.ParentCategory.lastIndexOf( "<span>" ) );
			}
			if ( Jobb.TargetOffer.ParentCategory.lastIndexOf( "<b>" ) > -1 ) {
				Jobb.TargetOffer.ParentCategory = Jobb.TargetOffer.ParentCategory.substring( 0, Jobb.TargetOffer.ParentCategory.lastIndexOf( "<b>" ) );
			}
			if ( Jobb.TargetOffer.ParentCategory.lastIndexOf( "</a>" ) > -1 ) {
				Jobb.TargetOffer.ParentCategory = Jobb.TargetOffer.ParentCategory.substring( 0, Jobb.TargetOffer.ParentCategory.lastIndexOf( "</a>" ) );
			}
			if ( Jobb.TargetOffer.ParentCategory.lastIndexOf( "\"> " ) > -1 ) {
				Jobb.TargetOffer.ParentCategory = Jobb.TargetOffer.ParentCategory.substring( Jobb.TargetOffer.ParentCategory.lastIndexOf( "\"> " ) + "\"> ".length() );
			}
			if ( Jobb.TargetOffer.ParentCategory.lastIndexOf( "\">" ) > -1 ) {
				Jobb.TargetOffer.ParentCategory = Jobb.TargetOffer.ParentCategory.substring( Jobb.TargetOffer.ParentCategory.lastIndexOf( "\">" ) + "\">".length() );
			}
			if ( Jobb.TargetOffer.ParentCategory.lastIndexOf( "html" ) > -1 ) {
				Jobb.TargetOffer.ParentCategory = Jobb.TargetOffer.ParentCategory.substring( Jobb.TargetOffer.ParentCategory.lastIndexOf( "html" ) + "html".length() );
			}
			//System.out.println( this.getClass().toString()+" FinnItemType ParentCategory A="+Jobb.Get_Adresse().toString()+" ParentCategory="+Jobb.TargetOffer.ParentCategory );

			//FERDIG
			/*System.out.println( this.getClass().toString()+" FinnItemType 1 Crumbs="+Jobb.TargetOffer.Crumbs );
			System.out.println( this.getClass().toString()+" FinnItemType B Category="+Jobb.TargetOffer.Category );
			System.out.println( this.getClass().toString()+" FinnItemType 3 ParentCategory="+Jobb.TargetOffer.ParentCategory );*/

			//System.out.println( "ItemType="+Jobb.TargetOffer.Category+" <-"+Jobb.Get_Adresse().toString() );
			if ( this.Class_Controller.Get_SelectedSearchtype( this.getClass().toString() + " FinnItemType" ).equals( "Category" ) == true ) {
				Jobb.TargetOffer.Get_Adresse().Set_AcceptedCategory( Jobb.ItemTypeAccepted( Jobb.TargetOffer, Jobb.TargetOffer.Category, Jobb.TargetOffer.ParentCategory, Jobb.TargetOffer.Crumbs ), this.getClass().toString() + " FinnItemType", Class_Controller, Jobb.TargetOffer.Category );
			}
			else {
				Jobb.TargetOffer.Get_Adresse().Set_AcceptedCategory( true, this.getClass().toString() + " FinnItemType", Class_Controller, Jobb.TargetOffer.Category );
			}
			//System.out.println( this.getClass().toString()+" FinnItemType SelectedSearchtype="+this.Class_Controller.Get_SelectedSearchtype( this.getClass().toString()+" FinnItemType" )+" accepted? "+Jobb.TargetOffer.Get_Adresse().Get_AcceptedCategory() );
			if ( Jobb.TargetOffer.Get_Adresse().Get_AcceptedCategory() == false ) {
				System.out.println( "Forkaster URL pga uønsket ItemType A: " + Jobb.Get_Adresse().toString() + "->" + Jobb.TargetOffer.Category );
				ForkastURL( Buffer, "unwanted item type2" );
				return;
			}
		}
		catch ( Exception T ) {
			if ( this.Class_Controller.Get_SelectedSearchtype( this.getClass().toString() + " FinnItemType" ).equals( "Category" ) == true ) {
				Jobb.TargetOffer.Get_Adresse().Set_AcceptedCategory( false, this.getClass().toString() + " FinnItemType", Class_Controller, Jobb.TargetOffer.Category );
				System.out.println( "Forkaster URL pga ItemType B: " + Jobb.Get_Adresse().toString() + "->" + Jobb.TargetOffer.Category );
				ForkastURL( Buffer, "unwanted item type2" );
				return;
			}
			else {
				Jobb.TargetOffer.Get_Adresse().Set_AcceptedCategory( true, this.getClass().toString() + " FinnItemType", Class_Controller, Jobb.TargetOffer.Category );
			}
			this.Class_Controller.ReportError( T, this.getClass().toString() + " FinnItemType" );
		}
		Date Slutt = new Date();
		int Tid = (int) (Slutt.getTime() - Start.getTime());
		if ( Tid > 0 ) {
			//System.out.println( this.getClass().toString()+" FinnItemType Arbeidstid="+Tid );
		}
	}

	@Override
	public void FinnPris( String Buffer ) {

		boolean MinOrder15 = false;
		if ( Buffer.indexOf( "min order 15".toLowerCase() ) > -1 ) {
			MinOrder15 = true;
		}
		if ( Buffer.indexOf( "min-order-15".toLowerCase() ) > -1 ) {
			MinOrder15 = true;
		}
		boolean MinOrder10 = false;
		if ( Buffer.indexOf( "min order 10".toLowerCase() ) > -1 ) {
			MinOrder10 = true;
		}
		if ( Buffer.indexOf( "min-order-10".toLowerCase() ) > -1 ) {
			MinOrder10 = true;
		}

		Date Start = new Date();
		if ( Buffer.indexOf( "id=\"sku-price\" itemprop=\"price\">".toLowerCase() ) > -1 ) {
			String TotalCosts_String = Buffer.substring( (Buffer.indexOf( "id=\"sku-price\" itemprop=\"price\">" ) + "id=\"sku-price\" itemprop=\"price\">".length()) );
			TotalCosts_String = TotalCosts_String.substring( 0, TotalCosts_String.indexOf( "</span>" ) );
			double TotalCosts_doub = Double.parseDouble( TotalCosts_String );
			Jobb.TargetOffer.Price = TotalCosts_doub;
		}
		else if ( Buffer.indexOf( "<span itemprop=\"highPrice\">".toLowerCase() ) > -1 ) {
			String TotalCosts_String = Buffer.substring( Buffer.indexOf( "<span itemprop=\"highPrice\">".toLowerCase() ) );
			TotalCosts_String = TotalCosts_String.substring( "<span itemprop=\"highPrice\">".length() );
			TotalCosts_String = TotalCosts_String.substring( 0, TotalCosts_String.indexOf( "</span>" ) );
			double TotalCosts_doub = Double.parseDouble( TotalCosts_String );
			Jobb.TargetOffer.Price = TotalCosts_doub;
		}
		else if ( Buffer.indexOf( "sku-price\">".toLowerCase() ) > -1 ) {
			String TotalCosts_String = Buffer.substring( (Buffer.indexOf( "sku-price\">" ) + "sku-price\">".length()) );
			TotalCosts_String = TotalCosts_String.substring( 0, TotalCosts_String.indexOf( "</span>" ) );
			double TotalCosts_doub = Double.parseDouble( TotalCosts_String );
			Jobb.TargetOffer.Price = TotalCosts_doub;
		}

		if ( MinOrder10 == true ) {
			Jobb.TargetOffer.Price = Math.max( 10, Jobb.TargetOffer.Price );
		}
		if ( MinOrder15 == true ) {
			Jobb.TargetOffer.Price = Math.max( 15, Jobb.TargetOffer.Price );
		}
		try {
			if ( Jobb.TargetOffer.Price == 0.0 ) {
				//System.out.println( "Forkaster URL pga fant ikke pris: "+Jobb.Get_Adresse().toString() );
				//ForkastURL( Buffer, "no price" );
				return;
			}
			Date Slutt = new Date();
			int Tid = (int) (Slutt.getTime() - Start.getTime());
			if ( Tid > 0 ) {
				//System.out.println( this.getClass().toString()+" FinnPris Arbeidstid="+Tid );
			}
		}
		catch ( Exception t ) {

		}
	}

}
