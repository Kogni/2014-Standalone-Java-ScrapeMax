package Offers;

import java.io.Serializable;
import java.net.URL;

import Control.Controller;
import Dropshippers.Object_Dropshipper;
import ItemStats.Brain_Spinner;
import URLs.Object_URL;

public class Object_Product_Offer implements Serializable{

	private static final long	serialVersionUID			= -7065856136335116748L;

	public Controller			Class_Controller;
	public Brain_Spinner		Class_Brain_Spinner;

	public Object_URL			TargetURL;

	public String				ImageText					= "";
	public String				ImageRack					= "";

	public String				ProductStats				= "";
	public String				Description;
	public String				Model;
	public String				Meta;
	public String				Head;
	public String				Category;
	public String				ParentCategory;
	public double				Price;
	public String				Seller;

	private boolean				AcceptedProduct				= true;

	public String				DynamiskHovedkategori		= "Div";
	public String				DynamiskSubkategori			= "Div";
	public String				Crumbs						= "";
	public String				OptionsText					= "";
	public String				Antall						= "1";

	//for generering av produktbeskrivelse
	public String				Subject;
	public String				Subject_Primary;										//<---- fix
	public String				Subject_Secondary;										//<---- fix
	public String				Adjectives					= "";
	public String				Beskrivelse_Farger			= "";						//<----- fix!
	public String				Beskrivelse_Bekledningsstil	= "";
	public String				Beskrivelse_BrukerGruppe	= "";
	public String				Beskrivelse_BruksOmraade	= "";
	public String				Beskrivelse_BruksAnledning	= "";
	public String				Beskrivelse_Stats			= "";
	public String				Beskrivelse_Tema			= "";
	public String				Beskrivelse_Produsent		= "";
	public String				Beskrivelse_Varemerke		= "";						//<---- fix!
	public String				Beskrivelse_Opprinnelse		= "";
	public String				Beskrivelse_Egenskaper		= "";
	public String				Beskrivelse_Standard		= "";
	public String				Beskrivelse_BestandDeler	= "";

	public String				Upload_Produktnavn			= "";
	public String				Upload_Description			= "";
	public String				Upload_MetaDesc				= "";
	public String				Upload_MetaKey				= "";
	public String				Upload_Model				= "";
	public String				Upload_SKU					= "";
	public String				Upload_UPC					= "";
	public String				Upload_Location				= "";
	public double				Upload_Price				= 0;
	public String				Upload_Quantity				= "0";
	public String				Upload_MinQuant				= "0";
	public String				Upload_Substract			= "";
	public String				Upload_RequiresShipping		= "";
	public String				Upload_SEOlink				= "";
	public String				Upload_Image				= "";
	public String				Upload_Length				= "";
	public String				Upload_Height				= "";
	public String				Upload_Width				= "";
	public String				Upload_Weigth				= "";
	public String				Upload_Status				= "";
	public String				Upload_SortOrder			= "";
	public String				Upload_Manufacturer			= "";
	public String				Upload_Category				= "";
	public String				Upload_SubCategory			= "";
	public String				Upload_Download				= "";

	public int					ImageCount;
	public int					SavedImages;

	public Object_Product_Offer( Controller Class_Controller, Object_URL TargetURL ) {
		//System.out.println( this.getClass().toString()+" created. Selected_Itemtype="+Selected_Itemtype.Category );
		this.Class_Controller = Class_Controller;
		this.TargetURL = TargetURL;
		Class_Brain_Spinner = new Brain_Spinner( this );
		//System.out.println( this.getClass().toString()+" constructor. ProductIdentifier="+ProductIdentifier+" "+Class_Controller.Get_Settings_User() );
	}

	public void Set_SelfRelationValue( int value ) {
		TargetURL.Set_SelfRelationValue( value );
	}

	public void Set_FrontBilde( URL url ) {
		Upload_Image = url.toString();
	}

	public void Set_ObjectID( String temp_ObjectID ) {
		Model = temp_ObjectID;
		Upload_Model = TargetURL.Get_Domain_Forkortet() + "-" + Model + " auto";
		//System.out.println( this.getClass().toString()+" Set_ObjectID. Upload_Model="+Upload_Model );
	}

	public void ReplaceURL( Object_URL New ) {
		TargetURL = New;
	}

	public String Get_Name() {
		return Upload_Produktnavn;
	}

	public String Get_Description() {
		return Upload_Description;
	}

	public String Get_MetaDescription() {
		return Upload_MetaDesc;
	}

	public String Get_MetaKeywords() {
		return Upload_MetaKey;
	}

	public String Get_Model() {
		return Upload_Model;
	}

	public String Get_SKU() {
		return Upload_SKU;
	}

	public String Get_UPC() {
		return Upload_UPC;
	}

	public String Get_Location() {
		return Upload_Location;
	}

	public String Get_Price() {
		return Upload_Price + "";
	}

	public String Get_Quantity() {
		return Upload_Quantity;
	}

	public String Get_MinQuantity() {
		return Upload_MinQuant;
	}

	public String Get_SubstractStock() {
		return Upload_Substract;
	}

	public String Get_RequiresShipping() {
		return Upload_RequiresShipping;
	}

	public String Get_SEOKeywords() {
		return Upload_SEOlink;
	}

	public String Get_Image() {
		return Upload_Image;
	}

	public String Get_Length() {
		return Upload_Length;
	}

	public String Get_Height() {
		return Upload_Height;
	}

	public String Get_Width() {
		return Upload_Width;
	}

	public String Get_Weight() {
		return Upload_Weigth;
	}

	public String Get_ProductStatus() {
		return Upload_Status;
	}

	public String Get_SortOrder() {
		return Upload_SortOrder;
	}

	public String Get_Manufacturer() {
		return Upload_Manufacturer;
	}

	public String Get_Category() {
		return Upload_Category;
	}

	public String Get_SubCategory() {
		return Upload_SubCategory;
	}

	public String Get_Download() {
		return Upload_Download;
	}

	public String Get_Attribute() {
		// TODO Auto-generated method stub
		return null;
	}

	public String Get_Options() {
		// TODO Auto-generated method stub
		return null;
	}

	public String Get_DiscountPrice() {
		// TODO Auto-generated method stub
		return null;
	}

	public String Get_SpecialPrice() {
		// TODO Auto-generated method stub
		return null;
	}

	public String Get_AdditionalImage() {
		// TODO Auto-generated method stub
		return null;
	}

	public String Get_Points() {
		// TODO Auto-generated method stub
		return null;
	}

	public String Get_RewardPoints() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object_URL Get_Adresse() {
		return TargetURL;
	}

	public int Get_LinkedRelationValue() {
		return TargetURL.RelationValue_Linked;
	}

	public int Get_SelfRelationValue() {
		return TargetURL.RelationValue_Self;
	}

	public String Get_Dropshipsite() {
		Object_Dropshipper[] Dropshippers = Class_Controller.Get_Dropshippers();
		//System.out.println( this.getClass().toString()+" Get_Dropshipsite "+TargetURL.Get_Adresse().toString() );
		for ( int X = 0; X < Dropshippers.length; X++ ) {
			if ( Dropshippers[X] != null ) {
				if ( TargetURL.Get_Adresse().toString().indexOf( Dropshippers[X].DropshipperName.toLowerCase() ) > -1 ) {
					return Dropshippers[X].DropshipperName.toLowerCase();
				}
			}
		}
		return null;
	}

	public void AutoPrice( String autoPricing ) {
		if ( autoPricing.equals( "Original price and currency" ) ) {
			Upload_Price = Price;
		}
		else if ( autoPricing.equals( "Original price, NOK currency" ) ) {
			Upload_Price = Price * Class_Controller.Currency;
		}
		else if ( autoPricing.equals( "2x original price, NOK currency" ) ) {
			Upload_Price = Price * 2.0 * Class_Controller.Currency;
		}
		else if ( autoPricing.equals( "2.5x original price, NOK currency" ) ) {
			Upload_Price = Price * 2.5 * Class_Controller.Currency;
		}
		else if ( autoPricing.equals( "3x original price, NOK currency" ) ) {
			Upload_Price = Price * 3.0 * Class_Controller.Currency;
		}
	}

	public void Set_AcceptedProduct( boolean Accepted, String Reason ) throws Exception {
		this.AcceptedProduct = Accepted;
		if ( Class_Controller.isProductPage( Get_Adresse().Get_Adresse().toString() ) == true ) {
			//System.out.println( this.getClass().toString()+" Set_AcceptedProduct "+TargetURL.Get_Adresse().toString()+" Accepted="+Accepted+" Reason="+Reason );
			if ( Accepted == false ) {
				//System.out.println( this.getClass().toString() + " Forkaster URL pga " + Reason + ": " + this.Get_Adresse().Get_Adresse().toString() );
				this.Class_Controller.Print_RejectedOffer( this, Reason );
			}
		}
	}

	public boolean Get_AcceptedProduct() {
		return AcceptedProduct;
	}

	public void Set_Antall( String substring, String Source ) {
		Antall = substring;
	}

	public String Get_Antall() {
		return Antall;
	}

}
