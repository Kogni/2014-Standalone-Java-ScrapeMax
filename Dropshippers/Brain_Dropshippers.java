package Dropshippers;

import java.util.Date;

import Control.Controller;
import Interfaces.Interface_Dropshippers;

public class Brain_Dropshippers implements Interface_Dropshippers{

	Controller				Class_Controller;

	Object_Dropshipper[]	AllDropshippers;
	Object_Dropshipper		SelectedDropshipper;

	public Brain_Dropshippers( Controller Class_Controller ) throws Exception {
		this.Class_Controller = Class_Controller;
		AllDropshippers = new Object_Dropshipper[10];
		Insert_New_Dropshipper( "FocalPrice" );
		Insert_New_Dropshipper( "AliExpress" );
		Insert_New_Dropshipper( "1on1 Dropship" );
		Insert_New_Dropshipper( "DHGate" );
		Insert_New_Dropshipper( "Tmart" );
	}

	public void Insert_New_Dropshipper( String Name ) throws Exception {
		for ( int X = 0; X < 10; X++ ) {
			if ( AllDropshippers[X] == null ) {
				if ( Name.equals( "FocalPrice" ) ) {
					AllDropshippers[X] = new Object_Dropshipper_FocalPrice( Class_Controller );
				}
				else if ( Name.equals( "AliExpress" ) ) {
					AllDropshippers[X] = new Object_Dropshipper_AliExpress( Class_Controller );
				}
				else if ( Name.equals( "DHGate" ) ) {
					AllDropshippers[X] = new Object_Dropshipper_DHGate( Class_Controller );
				}
				else if ( Name.equals( "1on1 Dropship" ) ) {
					AllDropshippers[X] = new Object_Dropshipper_1on1( Class_Controller );
				}
				else if ( Name.equals( "Tmart" ) ) {
					AllDropshippers[X] = new Object_Dropshipper_Tmart( Class_Controller );
				}
				else {
					System.out.println( this.getClass().toString() + " Insert_New_Dropshipper Fant ikke etterspurt dropshipper: " + Name );
				}
				return;
			}
		}
	}

	public Object_Dropshipper Get_SelectedDropshipper( String Source ) {
		return SelectedDropshipper;
	}

	public Object_Dropshipper[] Get_Dropshippers_Object() {
		return AllDropshippers;
	}

	public void Set_SelectedDropshipper( String selectedDropshipper ) {
		for ( int X = 0; X < 10; X++ ) {
			if ( AllDropshippers[X] != null ) {
				if ( AllDropshippers[X].DropshipperName.equals( selectedDropshipper ) ) {
					this.SelectedDropshipper = AllDropshippers[X];
				}
			}
		}
	}

	public boolean isProductPage( String adresse ) {
		if ( adresse.indexOf( "focalprice" ) > -1 ) {
			if ( adresse.indexOf( "/buy/" ) > -1 ) {
				return false;
			}
			else if ( adresse.length() == "http://www.focalprice.com".length() ) {
				return false;
			}
			else if ( adresse.indexOf( "/ca-" ) > -1 ) {
				return false;
			}
			else {
				return true;
			}
		}
		else if ( adresse.indexOf( "aliexpress" ) > -1 ) {
			if ( adresse.indexOf( "/category/" ) > -1 ) {
				return false;
			}
			else if ( adresse.indexOf( "/products/" ) > -1 ) {
				return false;
			}
			else if ( adresse.indexOf( "/product-" ) > -1 ) {
				return true;
			}
			else if ( adresse.indexOf( "/product" ) > -1 ) {
				return true;
			}
			else if ( adresse.indexOf( "/item/" ) > -1 ) {
				return true;
			}
			else if ( adresse.indexOf( "/activities/" ) > -1 ) {
				return false;
			}
			else if ( adresse.indexOf( "/group/" ) > -1 ) {
				return false;
			}
			else if ( adresse.length() == "http://www.aliexpress.com".length() ) {
				return false;
			}
			else if ( adresse.indexOf( "/item-img/" ) > -1 ) {
				return false;
			}
			else if ( adresse.indexOf( "/item-" ) > -1 ) {
				return true;
			}
			else {
				return false;
			}
		}
		else if ( adresse.indexOf( "dhgate" ) > -1 ) {
			if ( adresse.length() == "http://www.dhgate.com/".length() ) {
				return false;
			}
			else if ( adresse.length() == "http://www.dhgate.com/protection.html".length() ) {
				return false;
			}
			else if ( adresse.indexOf( "/wholesale+" ) > -1 ) {
				return false;
			}
			else if ( adresse.indexOf( "/wholesale/" ) > -1 ) {
				return false;
			}
			else if ( adresse.indexOf( "/wholesale-" ) > -1 ) {
				return false;
			}
			else if ( adresse.indexOf( "/all-categories/" ) > -1 ) {
				return false;
			}
			else if ( adresse.indexOf( "/promotion/" ) > -1 ) {
				return false;
			}
			else if ( adresse.indexOf( "/vip-club/" ) > -1 ) {
				return false;
			}
			else if ( adresse.indexOf( "/!forums/" ) > -1 ) {
				return false;
			}
			else if ( adresse.indexOf( "/protection-" ) > -1 ) {
				return false;
			}
			else if ( adresse.indexOf( "/html/" ) > -1 ) {
				return false;
			}
			else if ( adresse.indexOf( "/äbout/" ) > -1 ) {
				return false;
			}
			else if ( adresse.indexOf( "/sitemap/" ) > -1 ) {
				return false;
			}
			else if ( adresse.indexOf( "/products/" ) > -1 ) {
				return false;
			}
			else if ( adresse.indexOf( "/ppc/" ) > -1 ) {
				return false;
			}
			else if ( adresse.indexOf( "/seller-feedback/" ) > -1 ) {
				return false;
			}
			else if ( adresse.indexOf( "/new-product/" ) > -1 ) {
				return false;
			}
			else if ( adresse.indexOf( "/hot-product/" ) > -1 ) {
				return false;
			}
			else if ( adresse.indexOf( "/price/" ) > -1 ) {
				return false;
			}
			else if ( adresse.indexOf( "/reviews/" ) > -1 ) {
				return false;
			}
			else if ( adresse.indexOf( "/free-shipping/" ) > -1 ) {
				return false;
			}
			else {
				return true;
			}
		}
		else if ( adresse.indexOf( "1on1dropship" ) > -1 ) {
			if ( adresse.indexOf( "?Prodcode" ) > -1 ) {
				return true;
			}
			else if ( adresse.indexOf( "catid" ) > -1 ) {
				return false;
			}
			else if ( adresse.indexOf( "viewimage" ) > -1 ) {
				return false;
			}
			else if ( adresse.indexOf( "view" ) > -1 ) {
				return true;
			}
			else {
				return false;
			}
		}
		else if ( adresse.indexOf( "tmart" ) > -1 ) {
			adresse = adresse.substring( "http://www.tmart.com/".length() );
			if ( adresse.indexOf( "/" ) > -1 ) {
				return false;
			}
			else {
				return true;
			}
		}
		else {
			System.err.println( this.getClass().toString() + " isProductPage Finner ikke dropshipper settings: " + adresse );
		}

		return true;
	}

	public void Set_DropshipperDowntime( String dropshipper, Date date ) {
		for ( int X = 0; X < 10; X++ ) {
			if ( AllDropshippers[X] != null ) {
				if ( AllDropshippers[X].DropshipperName.equalsIgnoreCase( dropshipper ) ) {
					AllDropshippers[X].DowntimeTimer = date;
				}
			}
		}
	}

	public Date Get_DropshipperDowntime( String get_Domain_Lang ) {
		for ( int X = 0; X < 10; X++ ) {
			if ( AllDropshippers[X] != null ) {
				if ( AllDropshippers[X].DropshipperName.equalsIgnoreCase( get_Domain_Lang ) ) {
					return AllDropshippers[X].DowntimeTimer;
				}
			}
		}
		return null;
	}

	@Override
	public void Dropshippers_Startup() {

	}

	public boolean IsAcceptedSeller( String seller ) {
		return seller.contains( SelectedDropshipper.GenericStorePath );
	}

}
