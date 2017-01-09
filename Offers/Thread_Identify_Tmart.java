package Offers;

import java.net.MalformedURLException;
import java.net.URL;

import Control.Controller;
import Searching.Object_SearchJob;

public class Thread_Identify_Tmart extends Thread_Identify{

	public Thread_Identify_Tmart( Controller Class_Controller, Object_SearchJob hentetJobb ) {
		super( Class_Controller, hentetJobb );
	}

	@Override
	public void FinnFrontbilde( String Buffer ) throws Exception {
		//System.out.println( this.getClass().toString()+" FinnFrontbilde "+this.Jobb.Get_Adresse().toString() );
		if ( Buffer.indexOf( "<!-- pic start -->" ) > -1 ) {
			String Temp = Buffer.substring( Buffer.indexOf( "<!-- pic start -->" ) + "<!-- pic start -->".length() );
			Temp = Temp.substring( 0, Temp.indexOf( "<!-- pic end -->" ) );
			Temp = Temp.substring( Temp.indexOf( "jqimg=\"" ) + "jqimg=\"".length() );
			Temp = Temp.substring( 0, Temp.indexOf( "\" /></div>" ) );
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
		}
		else {
			//System.out.println( "Forkaster URL pga ikke frontbilde: "+Jobb.Get_Adresse().toString()+" "+Buffer.indexOf( "<!-- pic start -->" ) );
			ForkastURL( Buffer, "no front picture" );
			return;
		}
	}

	@Override
	public void FinnObjectID( String Buffer ) throws Exception {
		//System.out.println( this.getClass().toString()+" FinnObjectID "+this.Jobb.Get_Adresse().toString() );
		if ( Buffer.indexOf( "<em id=\"sku\">".toLowerCase() ) > -1 ) {

			String Temp_ObjectID = Buffer.substring( Buffer.indexOf( "<em id=\"sku\">".toLowerCase() ) + "<em id=\"sku\">".length() );
			Temp_ObjectID = Temp_ObjectID.substring( 0, Temp_ObjectID.indexOf( "</em>" ) );
			Jobb.TargetOffer.Set_ObjectID( Temp_ObjectID );
		}
		else {
			//System.out.println( "Forkaster URL pga ingen object ID: "+Jobb.Get_Adresse().toString()+" "+Buffer.indexOf( "objectId".toLowerCase() ) );
			ForkastURL( Buffer, "no object ID" );
			return;
		}
	}

	@Override
	public void FinnBilder( String Buffer ) throws Exception {
		//System.out.println( this.getClass().toString()+" FinnBilder "+this.Jobb.Get_Adresse().toString() );
		boolean found = false;
		String EditedBuffer = Buffer;

		while ( EditedBuffer.indexOf( ".jpg" ) > -1 ) {
			String Bilde = EditedBuffer.substring( Math.max( 0, (EditedBuffer.indexOf( ".jpg" ) - 100) ), (EditedBuffer.indexOf( ".jpg" ) + ".jpg".length()) );
			//System.out.println( "FinnBilder "+Jobb.Get_Adresse().toString()+"-> Bilde A="+ Bilde );
			if ( Bilde.lastIndexOf( "http" ) > -1 ) {
				Bilde = Bilde.substring( Bilde.lastIndexOf( "http" ) );

				//System.out.println( "FinnBilder "+Jobb.Get_Adresse().toString()+"-> Bilde B="+ Bilde );
				if ( Bilde.length() > 100 ) {
					//} else {
					//} else if ( Bilde.indexOf( "860x666" ) > -1 ) {
				}
				else if ( Bilde.indexOf( "550x426" ) > -1 ) {
					//Jobb.TargetOffer.ImageText = Jobb.TargetOffer.ImageText + "<img src=\""+Bilde+" alt=\"IMAGEALTTEXT\">";
					Jobb.TargetOffer.ImageText = Jobb.TargetOffer.ImageText + "<img alt='ALTIMAGETEXT' src='" + Bilde + "' >";

					found = true;
				}
			}
			try {
				EditedBuffer = EditedBuffer.replaceAll( Bilde, "" );
				if ( EditedBuffer.indexOf( Bilde ) > -1 ) {
					EditedBuffer = EditedBuffer.substring( EditedBuffer.indexOf( Bilde ) + Bilde.length() );
				}
				//System.out.println( "FinnBilder "+Jobb.Get_Adresse().toString()+" fjernet bilde: "+ Bilde );
			}
			catch ( Exception T ) {
				System.err.println( "FinnBilder error " + Bilde );
				break;
			}
		}

		if ( !found ) {
			//System.out.println( "Forkaster URL pga ingen bilder: "+Jobb.Get_Adresse().toString() );
			ForkastURL( Buffer, "ingen bilder" );
			return;
		}
	}

	@Override
	public void FinnDescription( String Buffer ) throws Exception {
		//System.out.println( this.getClass().toString()+" FinnDescription "+this.Jobb.Get_Adresse().toString() );
		if ( Buffer.indexOf( "<div class=\"description_m\">".toLowerCase() ) > -1 ) {
			//System.out.println( "Forkaster URL pga ingen description#1: "+Jobb.Get_Adresse().toString()+" "+Buffer.indexOf( "<div class=\"description_m\">".toLowerCase() ) );
			Jobb.TargetOffer.Description = Buffer.substring( Buffer.indexOf( "<div class=\"description_m\">" ) );
			Jobb.TargetOffer.Description = Jobb.TargetOffer.Description.substring( 0, Jobb.TargetOffer.Description.indexOf( "<div class=\"description_m hide\">" ) );
			Jobb.TargetOffer.Description = Jobb.TargetOffer.Description.substring( Jobb.TargetOffer.Description.indexOf( "<div class=\"description_m\">" ) + "<div class=\"description_m\">".length() );
			//        <ul><li>transflash memory card offers all of the benefits of a standard sd card.<li>converts the microsd memory card into a full-size sd card to be used with the growing number of sd compatible devices, eg. pda's phones and cameras available in the market.<li>in a much smaller size, it can be plugged into the adaptor and used in other sd-enabled devices.</li></ul>        <div class="mb10" id="productdetail">            <div class="productexplain_title mb10">                <span class="f14">package details</span>            </div>            <span id="productweight">weight:                <label>2.14</label>                g</span>            <br />            <span id="productsize">size:                <label>3.1*2.2*0.2</label>                cm</span><br />        </div>        <div class="mb10" id="productpack">            <div class="productexplain_title mb10">                <span class="f14">package includes</span>            </div>            <div id="productpackcontent">1 ã— micro transflash tf to sd card adaptor converter</div>        </div>    </div>                        
			//System.out.println( this.getClass().toString()+" FinnDescription "+Jobb.Get_Adresse().toString()+" Description A="+Jobb.TargetOffer.Description );
		}
		else if ( Buffer.indexOf( "<!-- pic start -->".toLowerCase() ) > -1 ) {
			Jobb.TargetOffer.Description = Jobb.TargetOffer.Description + Buffer.substring( Buffer.indexOf( "<!-- pic start -->" ) );
			Jobb.TargetOffer.Description = Jobb.TargetOffer.Description.substring( 0, Jobb.TargetOffer.Description.indexOf( "<!-- pic end -->" ) );
			Jobb.TargetOffer.Description = Jobb.TargetOffer.Description.toLowerCase();
			System.out.println( this.getClass().toString() + " FinnDescription " + Jobb.Get_Adresse().toString() + " Description B=" + Jobb.TargetOffer.Description );
		}
		else {
			ForkastURL( Buffer, "no description#1" );
			return;
		}

	}

	@Override
	public void FinnKeywords( String Buffer ) {
		//System.out.println( this.getClass().toString()+" FinnKeywords "+this.Jobb.Get_Adresse().toString() );
		try {
			Jobb.TargetOffer.Meta = Buffer.substring( Buffer.indexOf( "<meta name=\"description\" content=\"" ) + "<meta name=\"description\" content=\"".length() );
			Jobb.TargetOffer.Meta = Jobb.TargetOffer.Meta.substring( 0, Jobb.TargetOffer.Meta.indexOf( "\" />" ) );
			Jobb.TargetOffer.Meta = Jobb.TargetOffer.Meta.toLowerCase();
		}
		catch ( Exception e ) {
			try {
				this.Class_Controller.ReportError( e, this.getClass().toString() + " FinnKeywords failed" );
			}
			catch ( Exception e1 ) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	@Override
	public void FinnTittel( String Buffer ) {
		//System.out.println( this.getClass().toString()+" FinnTittel "+this.Jobb.Get_Adresse().toString() );
		Jobb.TargetOffer.Head = Buffer.substring( 0, Buffer.indexOf( "</head>" ) );
		Jobb.TargetOffer.Head = Jobb.TargetOffer.Head.substring( Jobb.TargetOffer.Head.indexOf( "<head>" ) );
		Jobb.TargetOffer.Head = Jobb.TargetOffer.Head.substring( 0, Jobb.TargetOffer.Head.indexOf( "</title>" ) );
		Jobb.TargetOffer.Head = Jobb.TargetOffer.Head.substring( Jobb.TargetOffer.Head.indexOf( "<title>" ) + "<title>".length() );
		Jobb.TargetOffer.Head = Jobb.TargetOffer.Head.toLowerCase();
	}

	@Override
	public void FinnItemType( String Buffer ) throws Exception {
		//System.out.println( this.getClass().toString()+" FinnItemType "+this.Jobb.Get_Adresse().toString() );
		//CRUMBS
		if ( Buffer.indexOf( "id=\"categoryname".toLowerCase() ) > -1 ) {
			Jobb.TargetOffer.Crumbs = Buffer.substring( Buffer.indexOf( "id=\"categoryname".toLowerCase() ) + "id=\"categoryname".length() );
		}
		else if ( Buffer.indexOf( "breadcrumbs" ) > -1 ) {
			Jobb.TargetOffer.Crumbs = Buffer.substring( Buffer.indexOf( "breadcrumbs".toLowerCase() ) + "breadcrumbs".length() );
		}
		else {
			System.out.println( this.getClass().toString() + " FinnItemType " + Jobb.Get_Adresse().toString() + " finner ikke Crumbs: " + Jobb.TargetOffer.Crumbs );
		}

		//bearbeide crumbs
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
		if ( Jobb.TargetOffer.Crumbs.indexOf( "<script" ) > -1 ) {
			Jobb.TargetOffer.Crumbs = Jobb.TargetOffer.Crumbs.substring( 0, Jobb.TargetOffer.Crumbs.indexOf( "<script" ) );
		}
		if ( Jobb.TargetOffer.Crumbs.indexOf( "home" ) > -1 ) {
			Jobb.TargetOffer.Crumbs = Jobb.TargetOffer.Crumbs.substring( Jobb.TargetOffer.Crumbs.indexOf( "home" ) );
		}
		if ( Jobb.TargetOffer.Crumbs.indexOf( "</h3> " ) > -1 ) {
			Jobb.TargetOffer.Crumbs = Jobb.TargetOffer.Crumbs.substring( 0, Jobb.TargetOffer.Crumbs.indexOf( "</h3> " ) );
		}
		if ( Jobb.TargetOffer.Crumbs.lastIndexOf( "</a>" ) > -1 ) {
			Jobb.TargetOffer.Crumbs = Jobb.TargetOffer.Crumbs.substring( 0, Jobb.TargetOffer.Crumbs.lastIndexOf( "</a>" ) );
		}
		//System.out.println( this.getClass().toString()+" FinnItemType "+Jobb.Get_Adresse().toString()+" Crumbs A2: "+Jobb.TargetOffer.Crumbs );

		//System.out.println( this.getClass().toString()+" FinnItemType "+Jobb.Get_Adresse().toString()+" Crumbs end="+Jobb.TargetOffer.Crumbs );

		//CATEGORY
		Jobb.TargetOffer.Category = Jobb.TargetOffer.Crumbs;
		if ( Jobb.TargetOffer.Category.indexOf( "</div>" ) > -1 ) {
			Jobb.TargetOffer.Category = Jobb.TargetOffer.Category.substring( 0, Jobb.TargetOffer.Category.indexOf( "</div>" ) );
		}
		if ( Jobb.TargetOffer.Category.indexOf( "html\">" ) > -1 ) {
			Jobb.TargetOffer.Category = Jobb.TargetOffer.Category.substring( Jobb.TargetOffer.Category.lastIndexOf( "html\">" ) + "html\">".length() );
			//System.out.println( this.getClass().toString()+" FinnItemType "+Jobb.Get_Adresse().toString()+" Category A="+Jobb.TargetOffer.Category );
		}
		else if ( Jobb.TargetOffer.Category.indexOf( "source=cj\">" ) > -1 ) {
			Jobb.TargetOffer.Category = Jobb.TargetOffer.Category.substring( Jobb.TargetOffer.Category.lastIndexOf( "source=cj\">" ) + "source=cj\">".length() );
		}
		else {
			//home/?status=", url: "link", title: "title" }, pinterest: { apiurl: "http://pinterest.com/pin/create/button/?url", url: "url", title: "title" }, google: { apiurl: "https://plus.google.com/share?url", url: "url" }, email: { apiurl: "https://mail.google.com/mail/?ui=1&view=cm&fs=1&tf=1&su=", url: "url", title: "title" } }); share.setDetail({ url: localUrl }); </script> <div class="focal_share"> <a href="javascript:void(0)" onclick="share.doShare('email');" class="e">email</a> <a href="javascript:void(0)" onclick="share.doShare('google');" class="g">google+</a> <a href="javascript:void(0)" onclick="share.doShare('pinterest');" class="p">Pinit</a> <a href="javascript:void(0)" onclick="share.doShare('twitter');" class="t">twitter</a> <a href="javascript:void(0)" onclick="share.doShare('facebook');" class="f">facebook
			System.out.println( this.getClass().toString() + " FinnItemType Category B " + Jobb.Get_Adresse().toString() + " Category=" + Jobb.TargetOffer.Category );
		}
		//System.out.println( this.getClass().toString()+" FinnItemType "+Jobb.Get_Adresse().toString()+" Category end="+Jobb.TargetOffer.Category );

		//PARENTCATEGORY
		Jobb.TargetOffer.ParentCategory = Jobb.TargetOffer.Crumbs;
		if ( Jobb.TargetOffer.ParentCategory.indexOf( "</a>" ) > -1 ) {
			Jobb.TargetOffer.ParentCategory = Jobb.TargetOffer.ParentCategory.substring( 0, Jobb.TargetOffer.ParentCategory.lastIndexOf( "</a>" ) );
			if ( Jobb.TargetOffer.ParentCategory.indexOf( "html\">" ) > -1 ) {
				Jobb.TargetOffer.ParentCategory = Jobb.TargetOffer.ParentCategory.substring( Jobb.TargetOffer.ParentCategory.lastIndexOf( "html\">" ) + "html\">".length() );
			}
			//System.out.println( this.getClass().toString()+" FinnItemType "+Jobb.Get_Adresse().toString()+" ParentCategory A="+Jobb.TargetOffer.ParentCategory );
		}
		else if ( Jobb.TargetOffer.ParentCategory.indexOf( "html\">" ) > -1 ) {
			if ( Jobb.TargetOffer.ParentCategory.indexOf( "html\">" ) > -1 ) {
				Jobb.TargetOffer.ParentCategory = Jobb.TargetOffer.ParentCategory.substring( Jobb.TargetOffer.ParentCategory.lastIndexOf( "html\">" ) + "html\">".length() );
			}
		}
		else {
			//" href="http://www.focalprice.com/computers-networking/ca-005.html">computers &amp; networking
			System.out.println( this.getClass().toString() + " FinnItemType " + Jobb.Get_Adresse().toString() + " ParentCategory B=" + Jobb.TargetOffer.ParentCategory );
			Jobb.TargetOffer.ParentCategory = "home";
		}
		//System.out.println( this.getClass().toString()+" FinnItemType "+Jobb.Get_Adresse().toString()+" ParentCategory end="+Jobb.TargetOffer.ParentCategory );

		//FERDIG
		/*System.out.println( this.getClass().toString()+" FinnItemType 1 Crumbs="+Jobb.TargetOffer.Crumbs );
		System.out.println( this.getClass().toString()+" FinnItemType B Category="+Jobb.TargetOffer.Category );
		System.out.println( this.getClass().toString()+" FinnItemType 3 ParentCategory="+Jobb.TargetOffer.ParentCategory );*/

		//Rings
		if ( Jobb.TargetOffer.Category.equals( "TML 1.0 Transitional//EN".toLowerCase() ) ) {
			//System.out.println( "Forkaster URL pga ItemType2: " + Jobb.Get_Adresse().toString() + "->" + Jobb.TargetOffer.Category );
			ForkastURL( Buffer, "error at item type2" );
			return;
		}
		if ( Jobb.TargetOffer.Category.length() > 50 ) {
			System.out.println( "Forkaster URL pga for lang item type: " + Jobb.Get_Adresse().toString() + "->" + Jobb.TargetOffer.Category.length() );
			ForkastURL( Buffer, "For lang item type: " + Jobb.Get_Adresse().toString() + " " + Jobb.TargetOffer.Category.length() );
			return;
		}
		//System.out.println( "ItemType="+Jobb.TargetOffer.Category+" <-"+Jobb.Get_Adresse().toString() );
		if ( this.Class_Controller.Get_SelectedSearchtype( this.getClass().toString() + " FinnItemType" ).equals( "Category" ) == true ) {
			Jobb.TargetOffer.Get_Adresse().Set_AcceptedCategory( Jobb.ItemTypeAccepted( Jobb.TargetOffer, Jobb.TargetOffer.Category, Jobb.TargetOffer.ParentCategory, Jobb.TargetOffer.Crumbs ), this.getClass().toString() + " FinnItemType", Class_Controller, Jobb.TargetOffer.Category );
		}
		else {
			Jobb.TargetOffer.Get_Adresse().Set_AcceptedCategory( true, this.getClass().toString() + " FinnItemType", Class_Controller, Jobb.TargetOffer.Category );
		}
		if ( Jobb.TargetOffer.Get_Adresse().Get_AcceptedCategory() == false ) {
			//System.out.println( "Forkaster URL pga ItemType: "+Jobb.Get_Adresse().toString()+"->"+Jobb.TargetOffer.Category );
			ForkastURL( Buffer, "unwanted item type2" );
			return;
		}
		/*} else {
			System.out.println( "Forkaster URL pga ingen crumbs: "+Jobb.Get_Adresse().toString()+"->"+Buffer.indexOf( "Item Type".toLowerCase() ) );
			ForkastURL( Buffer, "no item type" );
			return;
		}*/
	}

	@Override
	public void FinnPris( String Buffer ) throws Exception {
		//System.out.println( this.getClass().toString()+" FinnPris "+this.Jobb.Get_Adresse().toString() );
		if ( Buffer.indexOf( "nowprice\">".toLowerCase() ) > -1 ) {
			//<span class="currency" itemprop="priceCurrency" content="USD">US $</span><span class="value" id="sku-price" itemprop="price">8.92</span>
			String TotalCosts_String = Buffer.substring( (Buffer.indexOf( "nowprice\">" ) + "nowprice\">".length()) );
			//8.92</span>
			TotalCosts_String = TotalCosts_String.substring( 0, TotalCosts_String.indexOf( "</span>" ) );
			if ( TotalCosts_String.indexOf( "<sup>" ) > -1 ) {
				TotalCosts_String = TotalCosts_String.replaceAll( "<sup>", "." );
			}
			if ( TotalCosts_String.indexOf( "</sup>" ) > -1 ) {
				TotalCosts_String = TotalCosts_String.replaceAll( "</sup>", "" );
			}
			//8.92
			try {
				double TotalCosts_doub = Double.parseDouble( TotalCosts_String );
				//System.out.println( this.getContextClassLoader().toString()+" FinnPris TotalCosts_String="+TotalCosts_String+" TotalCosts_doub="+TotalCosts_doub );
				Jobb.TargetOffer.Price = TotalCosts_doub;
			}
			catch ( Exception E ) {
				//System.out.println( this.getClass().toString() + " FinnPris klarte ikke finne pris: " + TotalCosts_String );
				ForkastURL( Buffer, "no price" );
				return;
			}

		}
		else {
			//System.out.println( "Forkaster URL pga fant ikke pris: "+Jobb.Get_Adresse().toString() );
			ForkastURL( Buffer, "no price" );
			return;
		}

	}

}
