package Dropshippers;

import Control.Controller;
import Itemtypes.Object_DropshipItemtype;

public class Object_Dropshipper_FocalPrice extends Object_Dropshipper {

	
	public Object_Dropshipper_FocalPrice( Controller Class_Controller ) {
		super( "FocalPrice", "http://www.focalprice.com", Class_Controller );
		//System.out.println( this.getClass().toString()+" constructor" );
		
		ItemTypes();
		SearchTypes();
		
	}
	
	private void ItemTypes() {
		int X = 0;
		
		Itemtypes[X] = new Object_DropshipItemtype( "Apparel & Accessories".toLowerCase(), "Home".toLowerCase(), "http://www.focalprice.com/apparel-accessories/ca-018.html", "Kl&aeligr" );
		X++;
			Itemtypes[X] = new Object_DropshipItemtype( "Jewelry".toLowerCase(), "Apparel & Accessories".toLowerCase(), "http://www.focalprice.com/jewelry/ca-018004.html", "Smykke" );
			X++;
		
				Itemtypes[X] = new Object_DropshipItemtype( "Necklaces".toLowerCase(), "Jewelry".toLowerCase(), "http://www.focalprice.com/necklaces/ca-018004001.html", "Halskjede" );
				X++;
				Itemtypes[X] = new Object_DropshipItemtype( "Rings".toLowerCase(), "Jewelry".toLowerCase(), "http://www.focalprice.com/rings/ca-018004002.html", "Ring" );
				X++;
				Itemtypes[X] = new Object_DropshipItemtype( "Earrings".toLowerCase(), "Jewelry".toLowerCase(), "http://www.focalprice.com/earrings/ca-018004003.html", "&oslashredobb" );
				X++;
				Itemtypes[X] = new Object_DropshipItemtype( "Bracelet".toLowerCase(), "Jewelry".toLowerCase(), "http://www.focalprice.com/bracelet/ca-018004004.html", "Armb&aringnd" );
				X++;
				Itemtypes[X] = new Object_DropshipItemtype( "Brooches".toLowerCase(), "Jewelry".toLowerCase(), "http://www.focalprice.com/brooches/ca-018004005.html", "Brosje" );
				X++;
				Itemtypes[X] = new Object_DropshipItemtype( "Jewelry Sets".toLowerCase(), "Jewelry".toLowerCase(), "http://www.focalprice.com/jewelry-sets/ca-018004006.html", "Smykkesett" );
				X++;
				Itemtypes[X] = new Object_DropshipItemtype( "Jewelry Accessories".toLowerCase(), "Jewelry".toLowerCase(), "http://www.focalprice.com/jewelry-accessories/ca-018004007.html", "Smykke-tilbeh&oslashr" );
				X++;
		
			Itemtypes[X] = new Object_DropshipItemtype( "Watches".toLowerCase(), "Apparel & Accessories".toLowerCase(), "http://www.focalprice.com/watches/ca-018005.html", "Klokke" );
			X++;
				Itemtypes[X] = new Object_DropshipItemtype( "Women's watches".toLowerCase(), "Watches".toLowerCase(), "http://www.focalprice.com/womens-wathces/ca-018005003.html", "Dameklokke" );
				X++;
		
			Itemtypes[X] = new Object_DropshipItemtype( "Glasses".toLowerCase(), "Apparel & Accessories".toLowerCase(), "http://www.focalprice.com/glasses/ca-018006.html", "Briller" );
			X++;
				Itemtypes[X] = new Object_DropshipItemtype( "Women's Sunglasses".toLowerCase(), "Glasses".toLowerCase(), "http://www.focalprice.com/womens-sunglasses/ca-018006006.html", "Solbriller for Dame" );
				X++;
		
			Itemtypes[X] = new Object_DropshipItemtype( "Fashion Bags".toLowerCase(), "Apparel & Accessories".toLowerCase(), "http://www.focalprice.com/fashion-bags/ca-018007.html", "Veske" );
			X++;
				Itemtypes[X] = new Object_DropshipItemtype( "Women's Bags".toLowerCase(), "Fashion Bags".toLowerCase(), "http://www.focalprice.com/womens-bags/ca-018007002.html", "Veske" );
				X++;
		
			Itemtypes[X] = new Object_DropshipItemtype( "Women's Apparel".toLowerCase(), "Apparel & Accessories".toLowerCase(), "http://www.focalprice.com/women-s-apparel/ca-018002.html", "Damekl&aeligr" );
			X++;
				Itemtypes[X] = new Object_DropshipItemtype( "Dresses".toLowerCase(), "Women's Apparel".toLowerCase(), "http://www.focalprice.com/dresses/ca-018002005.html", "Kjole" );
				X++;
				Itemtypes[X] = new Object_DropshipItemtype( "Underwear".toLowerCase(), "Women's Apparel".toLowerCase(), "http://www.focalprice.com/underwear/ca-018002011.html", "Dameundert&oslashy" );
				X++;
				Itemtypes[X] = new Object_DropshipItemtype( "Swimwear".toLowerCase(), "Women's Apparel".toLowerCase(), "http://www.focalprice.com/swimwear/ca-018002012.html", "Badet&oslashy for Dame" );
				X++;
		
		Itemtypes[X] = new Object_DropshipItemtype( "Apple Accessories".toLowerCase(), "Home".toLowerCase(), "http://www.focalprice.com/apple-accessories/ca-001.html", "Apple-Utstyr" );
		X++;
			Itemtypes[X] = new Object_DropshipItemtype( "iPhone 5".toLowerCase(), "Apple Accessories".toLowerCase(), "http://www.focalprice.com/iphone5/ca-001012.html", "iPhone 5-Utstyr" );
			X++;
			Itemtypes[X] = new Object_DropshipItemtype( "iPhone 4/4S".toLowerCase(), "Apple Accessories".toLowerCase(), "http://www.focalprice.com/iphone-4-4s/ca-001003.html", "iPhone \\4s5-Utstyr" );
			X++;
			Itemtypes[X] = new Object_DropshipItemtype( "iPad 2".toLowerCase(), "Apple Accessories".toLowerCase(), "http://www.focalprice.com/ipad-2/ca-001002.html", "iPad 2-Utstyr" );
			X++;
			Itemtypes[X] = new Object_DropshipItemtype( "iPad 4".toLowerCase(), "Apple Accessories".toLowerCase(), "http://www.focalprice.com/ipad-4/ca-001014.html", "iPad 4-Utstyr" );
			X++;
			Itemtypes[X] = new Object_DropshipItemtype( "iPad Mini".toLowerCase(), "Apple Accessories".toLowerCase(), "http://www.focalprice.com/ipad-mini/ca-001013.html", "iPad Mini-Utstyr" );
			X++;
			Itemtypes[X] = new Object_DropshipItemtype( "Gadgets".toLowerCase(), "Apple Accessories".toLowerCase(), "http://www.focalprice.com/iphone-ipod-ipad-gadgets/ca-001015.html", "Apple-Gadget" );
			X++;

		Itemtypes[X] = new Object_DropshipItemtype( "Cell Phones".toLowerCase(), "Home".toLowerCase(), "http://www.focalprice.com/usb-flash-drives/ca-005011.html", "Mobilutstyr" );
		X++;
			Itemtypes[X] = new Object_DropshipItemtype( "Cell Phone Accessories".toLowerCase(), "Cell Phones".toLowerCase(), "http://www.focalprice.com/cell-phone-accessories/ca-004004.html", "Mobilutstyr" );
			X++;
				Itemtypes[X] = new Object_DropshipItemtype( "Cases & Skins".toLowerCase(), "Cell Phone Accessories".toLowerCase(), "http://www.focalprice.com/cases-skins/ca-004004004.html", "Mobildeksel" );
				X++;
		
		Itemtypes[X] = new Object_DropshipItemtype( "Computers & Networking".toLowerCase(), "Home".toLowerCase(), "http://www.focalprice.com/computers-networking/ca-005.html", "PC-utstyr" );
		X++;
			Itemtypes[X] = new Object_DropshipItemtype( "Keyboards & Mouse&Input".toLowerCase(), "Computers & Networking".toLowerCase(), "http://www.focalprice.com/keyboards-mouse-input/ca-005003.html", "Mus\\Tastatur" );
			X++;
				Itemtypes[X] = new Object_DropshipItemtype( "Mouse".toLowerCase(), "Keyboards & Mouse&Input".toLowerCase(), "http://www.focalprice.com/mouse/ca-005003004.html", "Datamus" );
				X++;
			Itemtypes[X] = new Object_DropshipItemtype( "USB Flash Drives".toLowerCase(), "Computers & Networking".toLowerCase(), "http://www.focalprice.com/usb-flash-drives/ca-005011.html", "Memory Stick" );
			X++;
			Itemtypes[X] = new Object_DropshipItemtype( "Cables & Converters".toLowerCase(), "Computers & Networking".toLowerCase(), "http://www.focalprice.com/cables-converters/ca-005002.html", "Kabel" );
			X++;
			Itemtypes[X] = new Object_DropshipItemtype( "USB Gadgets".toLowerCase(), "Computers & Networking".toLowerCase(), "http://www.focalprice.com/usb-gadgets/ca-005010.html", "USB-Gadget" );
			X++;
	}
	
	private void SearchTypes() {
		SearchTypes[0] = "Category";
		SearchTypes[1] = "Full crawl";
	}

}
