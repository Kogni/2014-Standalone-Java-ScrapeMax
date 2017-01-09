package Offers;

import java.net.MalformedURLException;
import java.net.URL;

import Control.Controller;
import Searching.Object_SearchJob;

public class Thread_Identify_DHGate extends Thread_Identify{

	public Thread_Identify_DHGate( Controller Class_Controller, Object_SearchJob hentetJobb ) {
		super( Class_Controller, hentetJobb );
	}

	@Override
	public void FinnFrontbilde( String Buffer ) throws Exception {
		String Temp = null;
		//<meta property="og:image" content="http://www.dhresource.com/albu_238576162_00-1.0x0/7-inch-allwinner-a10-android-4-0-3-arm-cortex.jpg"/>
		//             y="og:image" content="http://www.dhresource.com/albu_329017117_00-1.0x0/2013-beach-actual-images-evening-dress-sweetheart.jpg"/>
		if ( Buffer.indexOf( "<meta property=\"og:image" ) > -1 ) {
			Temp = Buffer.substring( Buffer.indexOf( "<meta property=\"og:image" ) + "<meta property=\"og:image".length() );
			//System.out.println( this.getClass().toString()+" FinnFrontbilde A Temp="+Temp );
			//" content="http://www.dhresource.com/albu_238576162_00-1.0x0/7-inch-allwinner-a10-android-4-0-3-arm-cortex.jpg"/>
			if ( Temp.indexOf( "\"/>" ) > -1 ) {
				Temp = Temp.substring( 0, Temp.indexOf( "\"/>" ) );
			}
			//System.out.println( this.getClass().toString()+" FinnFrontbilde B Temp="+Temp );
			//" content="http://www.dhresource.com/albu_238576162_00-1.0x0/7-inch-allwinner-a10-android-4-0-3-arm-cortex.jpg
			Temp = Temp.substring( Temp.indexOf( "http" ) );
			//System.out.println( this.getClass().toString()+" FinnFrontbilde C Temp="+Temp );
		}
		try {
			Jobb.TargetOffer.Set_FrontBilde( new URL( Temp ) );
		}
		catch ( MalformedURLException T ) {
			if ( Class_Controller.isProductPage( Jobb.TargetOffer.Get_Adresse().Get_Adresse().toString() ) == true ) {
				//System.out.println( "Forkaster URL pga ikke frontbilde A: " + Jobb.Get_Adresse().toString() );
			}
			ForkastURL( Buffer, "bad front picture" );
			return;
		}
		catch ( Exception T ) {
			if ( Class_Controller.isProductPage( Jobb.TargetOffer.Get_Adresse().Get_Adresse().toString() ) == true ) {
				System.out.println( "Forkaster URL pga ikke frontbilde B: " + Jobb.Get_Adresse().toString() );
			}
			ForkastURL( Buffer, "bad front picture" );
			return;
		}
	}

	@Override
	public void FinnObjectID( String Buffer ) throws Exception {
		String Temp_ObjectID = null;
		if ( Buffer.indexOf( "var _itemcode = '".toLowerCase() ) > -1 ) {
			Temp_ObjectID = Buffer.substring( Buffer.indexOf( "var _itemcode = '".toLowerCase() ) + "var _itemcode = '".length() );
			Temp_ObjectID = Temp_ObjectID.substring( 0, Temp_ObjectID.indexOf( "';" ) );
		}
		Jobb.TargetOffer.Set_ObjectID( Temp_ObjectID );
		if ( Temp_ObjectID == null ) {
			if ( Class_Controller.isProductPage( Jobb.TargetOffer.Get_Adresse().Get_Adresse().toString() ) == true ) {
				//System.out.println( "Forkaster URL pga ingen object ID: " + Jobb.Get_Adresse().toString() + " " + Buffer.indexOf( "objectId".toLowerCase() ) );
			}
			ForkastURL( Buffer, "no object ID" );
			return;
		}
	}

	@Override
	public void FinnBilder( String Buffer ) throws Exception {

		boolean found = false;
		String EditedBuffer = Buffer;

		while ( EditedBuffer.indexOf( ".jpg" ) > -1 ) {
			String Bilde = EditedBuffer.substring( Math.max( 0, (EditedBuffer.indexOf( ".jpg" ) - 100) ), (EditedBuffer.indexOf( ".jpg" ) + ".jpg".length()) );
			//System.out.println( this.getClass().toString()+" FinnBilder "+Jobb.Get_Adresse().toString()+"-> Bilde A="+ Bilde );
			if ( Bilde.lastIndexOf( "http" ) > -1 ) {
				Bilde = Bilde.substring( Bilde.lastIndexOf( "http" ) );

				//System.out.println( this.getClass().toString()+" FinnBilder "+Jobb.Get_Adresse().toString()+"-> Bilde B="+ Bilde );
				/*if ( Bilde.length() > 100 ) {
				} else {*/
				//System.out.println( this.getClass().toString()+" FinnBilder setter bilder: "+Jobb.Get_Adresse().toString()+"+Bilde: "+ Bilde );
				//Jobb.TargetOffer.ImageText = Jobb.TargetOffer.ImageText + "<img src=\""+Bilde+" alt=\"IMAGEALTTEXT\">";
				Jobb.TargetOffer.ImageText = Jobb.TargetOffer.ImageText + "<img alt='ALTIMAGETEXT' src='" + Bilde + "' >";

				found = true;
				//}
			}
			try {
				EditedBuffer = EditedBuffer.replaceAll( Bilde, "" );
				if ( EditedBuffer.indexOf( Bilde ) > -1 ) {
					//System.out.println( this.getClass().toString()+" FinnBilder "+Jobb.Get_Adresse().toString()+" replace failed A" );
				}
				EditedBuffer = EditedBuffer.substring( EditedBuffer.indexOf( Bilde ) + Bilde.length() );
				if ( EditedBuffer.indexOf( Bilde ) > -1 ) {
					//System.out.println( this.getClass().toString()+" FinnBilder "+Jobb.Get_Adresse().toString()+" replace failed B" );
				}
			}
			catch ( Exception T ) {
				//System.err.println( "FinnBilder error "+ Bilde );
				break;
			}
		}

		if ( !found ) {
			if ( Class_Controller.isProductPage( Jobb.TargetOffer.Get_Adresse().Get_Adresse().toString() ) == true ) {
				//System.out.println( "Forkaster URL pga ingen bilder: "+Jobb.Get_Adresse().toString() );
			}
			ForkastURL( Buffer, "ingen bilder" );
			return;
		}
	}

	@Override
	public void FinnDescription( String Buffer ) throws Exception {

		Jobb.TargetOffer.Description = Buffer;
		if ( Jobb.TargetOffer.Description.indexOf( "<div id=\"itemDescription\" style=\"display:block;\">".toLowerCase() ) > -1 ) {
			Jobb.TargetOffer.Description = Jobb.TargetOffer.Description.substring( Jobb.TargetOffer.Description.indexOf( "<div id=\"itemDescription\" style=\"display:block;\">".toLowerCase() ) );
		}
		if ( Jobb.TargetOffer.Description.indexOf( "<div id=\"shippingAndPayment".toLowerCase() ) > -1 ) {
			Jobb.TargetOffer.Description = Jobb.TargetOffer.Description.substring( 0, Jobb.TargetOffer.Description.indexOf( "<div id=\"shippingAndPayment".toLowerCase() ) );
		}
		if ( Jobb.TargetOffer.Description.indexOf( "<div class=\"static-warp\">" ) > -1 ) {
			Jobb.TargetOffer.Description = Jobb.TargetOffer.Description.substring( 0, Jobb.TargetOffer.Description.indexOf( "<div class=\"static-warp\">" ) );
		}

		if ( Jobb.TargetOffer.Description == null ) {
			if ( this.Class_Controller.isProductPage( Jobb.Get_Adresse().toString() ) == true ) {
				System.out.println( "Forkaster URL pga ingen description#1: " + Jobb.Get_Adresse().toString() );
			}
			ForkastURL( Buffer, "no description" );
			return;
		}
	}

	@Override
	public void FinnKeywords( String Buffer ) {

		Jobb.TargetOffer.Meta = Buffer.substring( Buffer.indexOf( "<meta name=\"description\" content=\"" ) + "<meta name=\"description\" content=\"".length() );
		Jobb.TargetOffer.Meta = Jobb.TargetOffer.Meta.substring( 0, Jobb.TargetOffer.Meta.indexOf( "\" />" ) );
		Jobb.TargetOffer.Meta = Jobb.TargetOffer.Meta.toLowerCase();
	}

	@Override
	public void FinnTittel( String Buffer ) {
		try {
			Jobb.TargetOffer.Head = Buffer.substring( 0, Buffer.indexOf( "</head>" ) );
			Jobb.TargetOffer.Head = Jobb.TargetOffer.Head.substring( Jobb.TargetOffer.Head.indexOf( "<head>" ) );
			Jobb.TargetOffer.Head = Jobb.TargetOffer.Head.substring( 0, Jobb.TargetOffer.Head.indexOf( "</title>" ) );
			Jobb.TargetOffer.Head = Jobb.TargetOffer.Head.substring( Jobb.TargetOffer.Head.indexOf( "<title>" ) + "<title>".length() );
			Jobb.TargetOffer.Head = Jobb.TargetOffer.Head.toLowerCase();
		}
		catch ( Exception e ) {
			try {
				this.Class_Controller.ReportError( e, this.getClass().toString() + " FinnTittel failed" );
			}
			catch ( Exception e1 ) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	@Override
	public void FinnItemType( String Buffer ) throws Exception {

		//>Home</a><span>&gt;</span><a href="http://www.dhgate.com/wholesale+computers.html#prod-bread">Computers & Networking</a><span>&gt;</span><a href="http://www.dhgate.com/wholesale/tablet-pc/c104012.html#prod-bread">Tablet PC</a><span>&gt;</span><strong>Product detail</strong></div>
		Jobb.TargetOffer.Crumbs = Buffer.substring( Buffer.indexOf( ">Home</a>".toLowerCase() ) + ">Home</a>".length() );
		if ( Jobb.TargetOffer.Crumbs.indexOf( "</strong></div>" ) > -1 ) {
			Jobb.TargetOffer.Crumbs = Jobb.TargetOffer.Crumbs.substring( 0, Jobb.TargetOffer.Crumbs.indexOf( "</strong></div>" ) );
		}
		if ( Jobb.TargetOffer.Crumbs.lastIndexOf( "</a>" ) > -1 ) {
			Jobb.TargetOffer.Crumbs = Jobb.TargetOffer.Crumbs.substring( 0, Jobb.TargetOffer.Crumbs.lastIndexOf( "</a>" ) );
		}
		/*if ( Jobb.TargetOffer.Crumbs.indexOf( "</span>" ) > -1 ) {
			Jobb.TargetOffer.Crumbs = Jobb.TargetOffer.Crumbs.substring( 0, Jobb.TargetOffer.Crumbs.indexOf( "</span>" ) );
		}
		if ( Jobb.TargetOffer.Crumbs.indexOf( "</a>" ) > -1 ) {
			Jobb.TargetOffer.Crumbs = Jobb.TargetOffer.Crumbs.substring( 0, Jobb.TargetOffer.Crumbs.indexOf( "</a>" ) );
		}*/
		if ( Class_Controller.isProductPage( Jobb.TargetOffer.Get_Adresse().Get_Adresse().toString() ) == true ) {
			//System.out.println( this.getClass().toString()+" FinnItemType Crumbs "+Jobb.Get_Adresse().toString()+" Crumbs="+Jobb.TargetOffer.Crumbs );
		}

		if ( Jobb.TargetOffer.Crumbs == null ) {
			if ( Class_Controller.isProductPage( Jobb.TargetOffer.Get_Adresse().Get_Adresse().toString() ) == true ) {
				//System.out.println( "Forkaster URL pga ingen crumbs: " + Jobb.Get_Adresse().toString() + "->" + Buffer.indexOf( "http://www.aliexpress.com/\">Home".toLowerCase() ) );
			}
			ForkastURL( Buffer, "no crumbs found" );
			return;
		}
		//System.out.println( this.getClass().toString()+" FinnItemType "+Jobb.Get_Adresse().toString()+" Crumbs="+Jobb.TargetOffer.Crumbs );

		Jobb.TargetOffer.Category = Jobb.TargetOffer.Crumbs;
		if ( Jobb.TargetOffer.Category.lastIndexOf( "<a href" ) > -1 ) {
			Jobb.TargetOffer.Category = Jobb.TargetOffer.Category.substring( Jobb.TargetOffer.Category.lastIndexOf( "<a href" ) + "<a href".length() );
		}
		if ( Jobb.TargetOffer.Category.lastIndexOf( "\">" ) > -1 ) {
			Jobb.TargetOffer.Category = Jobb.TargetOffer.Category.substring( Jobb.TargetOffer.Category.lastIndexOf( "\">" ) + "\">".length() );
		}
		if ( Class_Controller.isProductPage( Jobb.TargetOffer.Get_Adresse().Get_Adresse().toString() ) == true ) {
			//System.out.println( this.getClass().toString()+" FinnItemType Category "+Jobb.Get_Adresse().toString()+" Category="+Jobb.TargetOffer.Category );
		}

		Jobb.TargetOffer.ParentCategory = Jobb.TargetOffer.Crumbs;
		Jobb.TargetOffer.ParentCategory = Jobb.TargetOffer.ParentCategory = Jobb.TargetOffer.ParentCategory.substring( 0, Jobb.TargetOffer.ParentCategory.lastIndexOf( Jobb.TargetOffer.Category ) );
		if ( Jobb.TargetOffer.ParentCategory.lastIndexOf( "</a>" ) > -1 ) {
			Jobb.TargetOffer.ParentCategory = Jobb.TargetOffer.ParentCategory.substring( 0, Jobb.TargetOffer.ParentCategory.lastIndexOf( "</a>" ) );
		}
		if ( Jobb.TargetOffer.ParentCategory.lastIndexOf( "<a href" ) > -1 ) {
			Jobb.TargetOffer.ParentCategory = Jobb.TargetOffer.ParentCategory.substring( Jobb.TargetOffer.ParentCategory.lastIndexOf( "<a href" ) + "<a href".length() );
		}
		if ( Jobb.TargetOffer.ParentCategory.lastIndexOf( "\">" ) > -1 ) {
			Jobb.TargetOffer.ParentCategory = Jobb.TargetOffer.ParentCategory.substring( Jobb.TargetOffer.ParentCategory.lastIndexOf( "\">" ) + "\">".length() );
		}

		if ( Class_Controller.isProductPage( Jobb.TargetOffer.Get_Adresse().Get_Adresse().toString() ) == true ) {
			//System.out.println( this.getClass().toString()+" FinnItemType ParentCategory "+Jobb.Get_Adresse().toString()+" ParentCategory="+Jobb.TargetOffer.ParentCategory );
		}

		if ( this.Class_Controller.Get_SelectedSearchtype( this.getClass().toString() + " FinnItemType" ).equals( "Category" ) == true ) {
			Jobb.TargetOffer.Get_Adresse().Set_AcceptedCategory( Jobb.ItemTypeAccepted( Jobb.TargetOffer, Jobb.TargetOffer.Category, Jobb.TargetOffer.ParentCategory, Jobb.TargetOffer.Crumbs ), this.getClass().toString() + " FinnItemType", Class_Controller, Jobb.TargetOffer.Category );
		}
		else {
			Jobb.TargetOffer.Get_Adresse().Set_AcceptedCategory( true, this.getClass().toString() + " FinnItemType", Class_Controller, Jobb.TargetOffer.Category );
		}
		//System.out.println( this.getClass().toString()+" FinnItemType SelectedSearchtype="+Class_Controller.Get_SelectedSearchtype() );
		if ( Jobb.TargetOffer.Get_Adresse().Get_AcceptedCategory() == false ) {
			if ( Class_Controller.isProductPage( Jobb.TargetOffer.Get_Adresse().Get_Adresse().toString() ) == true ) {
				System.out.println( "Forkaster URL pga ItemType A: " + Jobb.Get_Adresse().toString() + "->" + Jobb.TargetOffer.Category );
			}
			ForkastURL( Buffer, "unwanted item type2" );
			return;
		}

	}

	@Override
	public void FinnPris( String Buffer ) throws Exception {

		//var _sItemPrice = '4.88 - 8.3';
		String TotalCosts_String = null;
		if ( Buffer.indexOf( "var _sItemPrice = '".toLowerCase() ) > -1 ) {
			//var _sItemPrice = '95.22 - 105.99';
			//<span class="currency" itemprop="priceCurrency" content="USD">US $</span><span class="value" id="sku-price" itemprop="price">8.92</span>
			TotalCosts_String = Buffer.substring( (Buffer.indexOf( "var _sItemPrice = '".toLowerCase() ) + "var _sItemPrice = '".length()) );
			TotalCosts_String = TotalCosts_String.substring( 0, 20 );
			//System.out.println( this.getClass().toString()+" FinnPris A TotalCosts_String="+TotalCosts_String );
			//95.22 - 105.99';
			if ( TotalCosts_String.indexOf( "';" ) > -1 ) {
				TotalCosts_String = TotalCosts_String.substring( 0, TotalCosts_String.indexOf( "';" ) );
			}
			//95.22 - 105.99
			if ( TotalCosts_String.indexOf( "- " ) > -1 ) {
				TotalCosts_String = TotalCosts_String.substring( (TotalCosts_String.indexOf( "- " ) + "- ".length()) );
			}
			//System.out.println( this.getClass().toString()+" FinnPris B TotalCosts_String="+TotalCosts_String );
			if ( TotalCosts_String.indexOf( " " ) > -1 ) {
				TotalCosts_String = TotalCosts_String.substring( (TotalCosts_String.lastIndexOf( " " ) + " ".length()) );
			}
			//System.out.println( this.getClass().toString()+" FinnPris C TotalCosts_String="+TotalCosts_String );
			//105.99
		}
		if ( Buffer.indexOf( "<strong class=\"unit-price\">".toLowerCase() ) > -1 ) {
			/*<strong class="unit-price">
			US  $334.4  / Piece
			</strong>*/
			TotalCosts_String = Buffer.substring( (Buffer.indexOf( "<strong class=\"unit-price\">".toLowerCase() ) + "<strong class=\"unit-price\">".length()) );
			TotalCosts_String = TotalCosts_String.substring( 0, 20 );
			if ( TotalCosts_String.indexOf( "</strong>" ) > -1 ) {
				TotalCosts_String = TotalCosts_String.substring( 0, TotalCosts_String.indexOf( "</strong>" ) );
			}
			if ( TotalCosts_String.indexOf( "$" ) > -1 ) {
				TotalCosts_String = TotalCosts_String.substring( TotalCosts_String.indexOf( "$" ) + 1 );
			}
			if ( TotalCosts_String.indexOf( " " ) > -1 ) {
				TotalCosts_String = TotalCosts_String.substring( 0, TotalCosts_String.indexOf( " " ) );
			}
		}
		try {
			double TotalCosts_doub = Double.parseDouble( TotalCosts_String );
			//System.out.println( this.getContextClassLoader().toString()+" FinnPris TotalCosts_String="+TotalCosts_String+" TotalCosts_doub="+TotalCosts_doub );
			Jobb.TargetOffer.Price = TotalCosts_doub;
		}
		catch ( Exception e ) {
			if ( Class_Controller.isProductPage( Jobb.TargetOffer.Get_Adresse().Get_Adresse().toString() ) == true ) {
				System.out.println( this.getClass().toString() + " FinnPris D klarte ikke sette pris. TotalCosts_String=" + TotalCosts_String );
			}
		}

		//http://www.dhgate.com/twelve-south-bookbook-real-leather-wallet/p-ff80808134d62a1a0134e48b1c5e0dbf.html
		if ( Jobb.TargetOffer.Price == 0.0 ) {
			if ( Class_Controller.isProductPage( Jobb.TargetOffer.Get_Adresse().Get_Adresse().toString() ) == true ) {
				//System.out.println( "Forkaster URL pga fant ikke pris: " + Jobb.Get_Adresse().toString() + " TotalCosts_String=" + TotalCosts_String );
			}
			ForkastURL( Buffer, "no price" );
			return;
		}

	}

}
