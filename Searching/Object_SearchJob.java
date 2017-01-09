package Searching;

import java.io.Serializable;
import java.net.URL;

import Control.Controller;
import Offers.Object_Product;
import Offers.Object_Product_Offer;
import URLs.Object_URL;

public class Object_SearchJob extends Object_Product implements Serializable{

	private static final long	serialVersionUID	= 482813533456294247L;
	public String				Origin;
	Controller					Class_Controller;
	public Object_Product_Offer	TargetOffer;
	public String				Searchtype;

	public int					LinksOut;

	public String				Identification_Status;

	public Object_SearchJob( Object_URL Adresse, Controller Class_Controller, String selected_Searchtype, String Origin ) throws Exception {
		if ( Origin.equals( "class URLs.Thread_URLsLoader LoadURL" ) ) {
		}
		else if ( Origin.equals( "class Dropshippers.Object_Dropshipper_1on1 Send_Start_URLs" ) ) {
		}
		else if ( Origin.equals( "class URLs.Thread_URLFinder_1on1 FigureRelatedValue" ) ) {
		}
		else if ( Origin.equals( "class Searching.Brain_Searching Save_NewURL_Search_Resultpage Tester URL" ) ) {
		}
		else if ( Origin.equals( "class Searching.Brain_Searching Save_NewURL_Search_Auction Tester URL" ) ) {
		}
		else {
			//System.out.println( this.getClass().toString()+" created. Origin="+Origin );
		}
		this.Class_Controller = Class_Controller;
		TargetOffer = new Object_Product_Offer( Class_Controller, Adresse );
		this.Searchtype = selected_Searchtype;
		this.Origin = Origin;
	}

	public String Get_ItemType() {
		return TargetOffer.Category;
	}

	public URL Get_Adresse() {
		return TargetOffer.Get_Adresse().Get_Adresse();
	}

	public int Get_LinkedRelationValue() {
		return TargetOffer.Get_LinkedRelationValue();
	}

	public int Get_SelfRelationValue() {
		return TargetOffer.Get_SelfRelationValue();
	}

	public void Finalize() throws Exception {
		if ( TargetOffer.Class_Brain_Spinner.Get_OPO().Head == null ) {
			this.Class_Controller.ReportError( null, this.getClass().toString() + " Finalize, head=null!" );
			return;
		}
		TargetOffer.Class_Brain_Spinner.Finalize();
	}

	public void Set_SelfRelationValue( int value ) {
		TargetOffer.Set_SelfRelationValue( value );
	}

	public boolean ItemTypeAccepted( Object_Product_Offer Produkt, String category, String parentCategory, String crumbs ) throws Exception {
		//System.out.println( this.getClass().toString()+" ItemTypeAccepted. Class_Controller="+Class_Controller+" item category="+category+" item parentCategory="+parentCategory );
		return Class_Controller.ItemTypeAccepted( Produkt, category, parentCategory, crumbs );
	}

	public String Get_CompleteContent() throws Exception {
		return TargetOffer.Get_Adresse().Get_CompleteContent();
	}

	public void Set_CompleteContent( String string ) throws Exception {
		TargetOffer.Get_Adresse().Set_CompleteContent( string );
	}

	public boolean Get_Identify_Started() {
		return TargetOffer.Get_Adresse().Identify_Started;
	}

	public boolean Get_Identify_Finished() {
		return TargetOffer.Get_Adresse().Identify_Finished;
	}

	public void Set_Identify_Started( boolean b, String Reason ) {
		//System.out.println( this.getClass().toString()+" Set_Identify_Started. Value="+b+" Reason:"+Reason );
		TargetOffer.Get_Adresse().Identify_Started = b;
	}

	public void Set_Identify_Finished( boolean b, String Reason ) {
		//System.out.println( this.getClass().toString()+" Set_Identify_Finished. Value="+b+" Reason:"+Reason );
		TargetOffer.Get_Adresse().Identify_Finished = b;
	}

}
