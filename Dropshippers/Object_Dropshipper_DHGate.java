package Dropshippers;

import Control.Controller;
import Itemtypes.Object_DropshipItemtype;
import Searching.Object_SearchJob;

public class Object_Dropshipper_DHGate extends Object_Dropshipper {

	public Object_Dropshipper_DHGate( Controller Class_Controller ) {
		super( "DHGate", "http://www.dhgate.com/", Class_Controller );
		
		ItemTypes();
		SearchTypes();
		
	}
	
	private void ItemTypes() {
		int X = -1;
		
		X++;
		Itemtypes[X] = new Object_DropshipItemtype( "Apparel".toLowerCase(), "Home".toLowerCase(), "http://www.dhgate.com/wholesale/apparel/c014.html", "Kl&aeligrr" );
		
		X++;
		Itemtypes[X] = new Object_DropshipItemtype( "Automobiles & Motorcycles".toLowerCase(), "Home".toLowerCase(), "http://www.dhgate.com/wholesale/automobiles-motorcycles/c112.html", "Utstyr for Bil\\Motorsykkel" );
		
		X++;
		Itemtypes[X] = new Object_DropshipItemtype( "Baby, Kids & Maternity".toLowerCase(), "Home".toLowerCase(), "http://www.dhgate.com/wholesale/baby-kids-maternity/c111.html", "Barneutstyr" );
		
		X++;
		Itemtypes[X] = new Object_DropshipItemtype( "Bags, Luggages & Accessories".toLowerCase(), "Home".toLowerCase(), "http://www.dhgate.com/wholesale/bags-luggages-accessories/c107.html", "Lugasje" );
		
		X++;
		Itemtypes[X] = new Object_DropshipItemtype( "Bags, Shoes & Accs".toLowerCase(), "Home".toLowerCase(), "http://www.dhgate.com/wholesale/bags-shoes-accs/c003.html", "Veske\\Sko" );
		
		X++;
		Itemtypes[X] = new Object_DropshipItemtype( "Business & Industrial".toLowerCase(), "Home".toLowerCase(), "http://www.dhgate.com/wholesale/business-industrial/c011.html", "Kontorutstyr" );
		
		X++;
		Itemtypes[X] = new Object_DropshipItemtype( "Cameras & Photo".toLowerCase(), "Home".toLowerCase(), "http://www.dhgate.com/wholesale/cameras-photo/c106.html", "Kamerautstyr" );
		
		X++;
		Itemtypes[X] = new Object_DropshipItemtype( "Cell Phones & Accessories".toLowerCase(), "Home".toLowerCase(), "http://www.dhgate.com/wholesale/cell-phones-accessories/c105.html", "Mobilutstyr" );
		
		X++;
		Itemtypes[X] = new Object_DropshipItemtype( "Computers & Networking".toLowerCase(), "Home".toLowerCase(), "http://www.dhgate.com/wholesale+computers.html", "PC-Utstyr" );
		
		X++;
		Itemtypes[X] = new Object_DropshipItemtype( "Electronic Components".toLowerCase(), "Home".toLowerCase(), "http://www.dhgate.com/wholesale/electronic-components/c118.html", "Elektronisk Komponent" );
		
		X++;
		Itemtypes[X] = new Object_DropshipItemtype( "Electronics".toLowerCase(), "Home".toLowerCase(), "http://www.dhgate.com/wholesale/electronics/c103.html", "Elektronisk Duppeditt" );
		
		X++;
		Itemtypes[X] = new Object_DropshipItemtype( "Everything Else".toLowerCase(), "Home".toLowerCase(), "http://www.dhgate.com/wholesale/everything-else/c099.html", "Diverse" );
		
		X++;
		Itemtypes[X] = new Object_DropshipItemtype( "Fashion Accessories".toLowerCase(), "Home".toLowerCase(), "http://www.dhgate.com/wholesale/fashion-accessories/c109.html", "Accessory" );
		
		X++;
		Itemtypes[X] = new Object_DropshipItemtype( "Games & Accessories".toLowerCase(), "Home".toLowerCase(), "http://www.dhgate.com/wholesale/games-accessories/c108.html", "Leke" );
		
		X++;
		Itemtypes[X] = new Object_DropshipItemtype( "Health & Beauty".toLowerCase(), "Home".toLowerCase(), "http://www.dhgate.com/wholesale/health-beauty/c018.html", "Skj&oslashnnhetsprodukt" );
		
		X++;
		Itemtypes[X] = new Object_DropshipItemtype( "Home & Garden".toLowerCase(), "Home".toLowerCase(), "http://www.dhgate.com/wholesale/home-garden/c019.html", "Stueartikkel" );
		
		X++;
		Itemtypes[X] = new Object_DropshipItemtype( "Jewelry".toLowerCase(), "Home".toLowerCase(), "http://www.dhgate.com/wholesale/jewelry/c100.html", "Smykke" );
		
		X++;
		Itemtypes[X] = new Object_DropshipItemtype( "Lights & Lighting".toLowerCase(), "Home".toLowerCase(), "http://www.dhgate.com/wholesale/lights-lighting/c117.html", "Lys" );
		
		X++;
		Itemtypes[X] = new Object_DropshipItemtype( "Measurement & Analysis Instruments".toLowerCase(), "Home".toLowerCase(), "http://www.dhgate.com/wholesale/measurement-analysis-instruments/c041.html", "M&aringleinstrument" );
		
		X++;
		Itemtypes[X] = new Object_DropshipItemtype( "Musical Instruments".toLowerCase(), "Home".toLowerCase(), "http://www.dhgate.com/wholesale/musical-instruments/c113.html", "Musikkinstrument" );
		
		X++;
		Itemtypes[X] = new Object_DropshipItemtype( "Security & Surveillance".toLowerCase(), "Home".toLowerCase(), "http://www.dhgate.com/wholesale/security-surveillance/c007.html", "Sikkerhetsutstyr" );
		
		X++;
		Itemtypes[X] = new Object_DropshipItemtype( "Shoes & Accessories".toLowerCase(), "Home".toLowerCase(), "http://www.dhgate.com/wholesale/shoes-accessories/c110.html", "Sko" );
		
		X++;
		Itemtypes[X] = new Object_DropshipItemtype( "Sports & Outdoors".toLowerCase(), "Home".toLowerCase(), "http://www.dhgate.com/wholesale/sports-outdoors/c024.html", "Utend&oslashrsutstyr" );
		
		X++;
		Itemtypes[X] = new Object_DropshipItemtype( "Toys & Gifts".toLowerCase(), "Home".toLowerCase(), "http://www.dhgate.com/wholesale/toys-gifts/c102.html", "Leke" );
		
		X++;
		Itemtypes[X] = new Object_DropshipItemtype( "Watches".toLowerCase(), "Home".toLowerCase(), "http://www.dhgate.com/wholesale/watches/c101.html", "Klokke" );
		
		X++;
		Itemtypes[X] = new Object_DropshipItemtype( "Wedding & Events".toLowerCase(), "Home".toLowerCase(), "http://www.dhgate.com/wholesale/wedding-events/c002.html", "Fest-ting" );
	}
	
	private void SearchTypes() {
		SearchTypes[0] = "Category";
		SearchTypes[1] = "Full crawl";
	}

}
