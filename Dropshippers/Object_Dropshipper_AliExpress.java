package Dropshippers;

import Control.Controller;
import Itemtypes.Object_DropshipItemtype;

public class Object_Dropshipper_AliExpress extends Object_Dropshipper {

	
	public Object_Dropshipper_AliExpress( Controller Class_Controller ) {
		super( "AliExpress", "http://www.aliexpress.com", Class_Controller );
		//System.out.println( this.getClass().toString()+" constructor" );
		
		ItemTypes();
		SearchTypes();
		
		GenericStorePath = "http://www.aliexpress.com/store/";
	}
	
	private void ItemTypes() {
		//System.out.println( this.getClass().toString()+" ItemTypes" );
		int X = -1;
		
		//Computer
		X++;
		Itemtypes[X] = new Object_DropshipItemtype( "Computer & Networking".toLowerCase(), "Home".toLowerCase(), "http://www.aliexpress.com/category/7/computer-networking.html", "PC-Hardware" );
		
			X++;
			Itemtypes[X] = new Object_DropshipItemtype( "Laptop Accessories".toLowerCase(), "Computer & Networking".toLowerCase(), "http://www.aliexpress.com/category/100005063/laptop-accessories.html", "Laptop-Del" );
				X++;
				Itemtypes[X] = new Object_DropshipItemtype( "Laptop Cooling Pads".toLowerCase(), "Laptop Accessories".toLowerCase(), "http://www.aliexpress.com/category/721/laptop-cooling-pads.html", "Laptop-Kj&oslashling" );
				X++;
				Itemtypes[X] = new Object_DropshipItemtype( "Laptop Skins".toLowerCase(), "Laptop Accessories".toLowerCase(), "http://www.aliexpress.com/category/708031/laptop-skins.html", "Laptopdeksel" );
		
			X++;
			Itemtypes[X] = new Object_DropshipItemtype( "Storage Devices".toLowerCase(), "Computer & Networking".toLowerCase(), "http://www.aliexpress.com/category/200002321/storage-devices.html", "Lagringsenhet" );	
				X++;
				Itemtypes[X] = new Object_DropshipItemtype( "USB Flash Drives".toLowerCase(), "Storage Devices".toLowerCase(), "http://www.aliexpress.com/category/711005/usb-flash-drives.html", "Memory Stick" );
				
			X++;
			Itemtypes[X] = new Object_DropshipItemtype( "Computer Peripherals".toLowerCase(), "Computer & Networking".toLowerCase(), "http://www.aliexpress.com/category/200002342/computer-peripherals.html", "PC-Gadget" );
				X++;
				Itemtypes[X] = new Object_DropshipItemtype( "USB Gadgets".toLowerCase(), "Computer Peripherals".toLowerCase(), "http://www.aliexpress.com/category/7171/usb-gadgets.html", "USB-Gadget" );
				X++;
				Itemtypes[X] = new Object_DropshipItemtype( "USB Hubs".toLowerCase(), "Computer Peripherals".toLowerCase(), "http://www.aliexpress.com/category/708032/usb-hubs.html", "USB-Hub" );
				X++;
				Itemtypes[X] = new Object_DropshipItemtype( "Mouse & Keyboards".toLowerCase(), "Computer Peripherals".toLowerCase(), "http://www.aliexpress.com/category/100005085/mouse-keyboards.html", "Mus\\Tastatur" );
					X++;
					Itemtypes[X] = new Object_DropshipItemtype( "Mice".toLowerCase(), "Mouse & Keyboards".toLowerCase(), "http://www.aliexpress.com/category/70805/mice.html", "Datamus" );
		
			X++;
			Itemtypes[X] = new Object_DropshipItemtype( "Accessories & Parts".toLowerCase(), "Computer & Networking".toLowerCase(), "http://www.aliexpress.com/category/200002394/accessories-parts.html", "PC-Del" );
				X++;
				Itemtypes[X] = new Object_DropshipItemtype( "Digital Cables".toLowerCase(), "Accessories & Parts".toLowerCase(), "http://www.aliexpress.com/category/200003200/digital-cables.html", "Digitalkabel" );
					X++;
					Itemtypes[X] = new Object_DropshipItemtype( "Data Cable".toLowerCase(), "Digital Cables".toLowerCase(), "http://www.aliexpress.com/category/440599/data-cable.html", "Datakabel" );
		
		//telefon
		X++;
		Itemtypes[X] = new Object_DropshipItemtype( "Phones & Telecommunications".toLowerCase(), "Home".toLowerCase(), "http://www.aliexpress.com/category/509/phones-amp--telecommunications.html", "Telefonutstyr" );
			X++;
			Itemtypes[X] = new Object_DropshipItemtype( "Mobile Phone Accessories".toLowerCase(), "Phones & Telecommunications".toLowerCase(), "http://www.aliexpress.com/category/5090302/mobile-phone-accessories.html", "Mobilutstyr" );
				X++;
				Itemtypes[X] = new Object_DropshipItemtype( "Phone Bags & Cases".toLowerCase(), "Mobile Phone Accessories".toLowerCase(), "http://www.aliexpress.com/category/380230/phone-bags-cases.html", "Mobildeksel" );
		
		//sko
		X++;
		Itemtypes[X] = new Object_DropshipItemtype( "Shoes".toLowerCase(), "Home".toLowerCase(), "http://www.aliexpress.com/activities/shoes/index.html", "Sko" );
			X++;
			Itemtypes[X] = new Object_DropshipItemtype( "Women's Shoes".toLowerCase(), "Shoes".toLowerCase(), "http://www.aliexpress.com/category/100001606/women-shoes.html", "Damesko" );
				X++;
				Itemtypes[X] = new Object_DropshipItemtype( "Boots".toLowerCase(), "Women's Shoes".toLowerCase(), "http://www.aliexpress.com/category/100001607/boots.html", "Dameboots" );
				X++;
				Itemtypes[X] = new Object_DropshipItemtype( "Pumps".toLowerCase(), "Women's Shoes".toLowerCase(), "http://www.aliexpress.com/category/200002161/pumps.html", "Pumps" );
				X++;
				Itemtypes[X] = new Object_DropshipItemtype( "Sandals".toLowerCase(), "Women's Shoes".toLowerCase(), "http://www.aliexpress.com/category/100001611/sandals.html", "Damesandaler" );
				X++;
				Itemtypes[X] = new Object_DropshipItemtype( "Sneakers".toLowerCase(), "Women's Shoes".toLowerCase(), "http://www.aliexpress.com/category/200002164/sneakers.html", "Damesneakers" );
				X++;
				Itemtypes[X] = new Object_DropshipItemtype( "Slippers".toLowerCase(), "Women's Shoes".toLowerCase(), "http://www.aliexpress.com/category/100001610/slippers.html", "Damet&oslashfler" );
				X++;
				Itemtypes[X] = new Object_DropshipItemtype( "Mules & Clogs".toLowerCase(), "Women's Shoes".toLowerCase(), "http://www.aliexpress.com/category/100001612/mules-clogs.html", "Innesandaler for Dame" );
			X++;
			Itemtypes[X] = new Object_DropshipItemtype( "Women's Boots".toLowerCase(), "Shoes".toLowerCase(), "http://www.aliexpress.com/category/100001607/boots.html", "Dameboots" );
		
		//baggage
		X++;
		Itemtypes[X] = new Object_DropshipItemtype( "Luggage & Bags".toLowerCase(), "Home".toLowerCase(), "http://www.aliexpress.com/category/1524/luggage-bags.html", "Lugasje" );
			X++;
			Itemtypes[X] = new Object_DropshipItemtype( "Handbags".toLowerCase(), "Luggage & Bags".toLowerCase(), "http://www.aliexpress.com/category/200000742/handbags.html", "H&aringndveske" );
				X++;
				Itemtypes[X] = new Object_DropshipItemtype( "Clutches".toLowerCase(), "Handbags".toLowerCase(), "http://www.aliexpress.com/category/200000762/clutches.html", "Clutch-Veske" );
				X++;
				Itemtypes[X] = new Object_DropshipItemtype( "Evening Bags".toLowerCase(), "Handbags".toLowerCase(), "http://www.aliexpress.com/category/100002613/evening-bags.html", "Selskapsveske" );
				X++;
				Itemtypes[X] = new Object_DropshipItemtype( "Shoulder Bags".toLowerCase(), "Handbags".toLowerCase(), "http://www.aliexpress.com/category/200000764/shoulder-bags.html", "Skulderveske" );
				X++;
				Itemtypes[X] = new Object_DropshipItemtype( "Totes".toLowerCase(), "Handbags".toLowerCase(), "http://www.aliexpress.com/category/200000766/totes.html", "Pose\\Nett" );
				X++;
				Itemtypes[X] = new Object_DropshipItemtype( "Wristlets".toLowerCase(), "Handbags".toLowerCase(), "http://www.aliexpress.com/category/200000767/wristlets.html", "Wristlet-Veske" );
			X++;
			Itemtypes[X] = new Object_DropshipItemtype( "Wallets & Holders".toLowerCase(), "Luggage & Bags".toLowerCase(), "http://www.aliexpress.com/category/3803/wallets-holders.html", "Pengeoppbevaring" );
				X++;
				Itemtypes[X] = new Object_DropshipItemtype( "Wallets".toLowerCase(), "Wallets & Holders".toLowerCase(), "http://www.aliexpress.com/category/152405/wallets.html", "Lommebok" );
				X++;
				Itemtypes[X] = new Object_DropshipItemtype( "Coin Purses".toLowerCase(), "Wallets & Holders".toLowerCase(), "http://www.aliexpress.com/category/380310/coin-purses.html", "Pengepung" );
			X++;
			Itemtypes[X] = new Object_DropshipItemtype( "bag parts & accessories".toLowerCase(), "Luggage & Bags".toLowerCase(), "http://www.aliexpress.com/category/152409/bag-parts-accessories.html", "Bag-tilbeh&oslashr" );
			X++;
			Itemtypes[X] = new Object_DropshipItemtype( "messenger bags".toLowerCase(), "Luggage & Bags".toLowerCase(), "http://www.aliexpress.com/category/100002612/messenger-bags.html", "Sportsveske" );
			X++;
			Itemtypes[X] = new Object_DropshipItemtype( "leather bags".toLowerCase(), "Luggage & Bags".toLowerCase(), "http://www.aliexpress.com/wholesale/wholesale-leather-bags.html", "L&aeligrveske" );
			X++;
			Itemtypes[X] = new Object_DropshipItemtype( "special purpose bags".toLowerCase(), "Luggage & Bags".toLowerCase(), "http://www.aliexpress.com/category/3805/special-purpose-bags.html", "Spesialveske" );
				X++;
				Itemtypes[X] = new Object_DropshipItemtype( "Cosmetic Bags & Cases".toLowerCase(), "special purpose bags".toLowerCase(), "http://www.aliexpress.com/category/152407/cosmetic-bags-cases.html", "Toalettmappe" );
		
		X++;
		Itemtypes[X] = new Object_DropshipItemtype( "Beauty & Health".toLowerCase(), "Home".toLowerCase(), "http://www.aliexpress.com/category/66/beauty-amp--health.html", "Skj&oslashnnhetsprodukt" );
			//nail design
			X++;
			Itemtypes[X] = new Object_DropshipItemtype( "Nails & Tools".toLowerCase(), "Beauty & Health".toLowerCase(), "http://www.aliexpress.com/category/200002547/nails-tools.html", "Negleprodukt" );
				X++;
				Itemtypes[X] = new Object_DropshipItemtype( "Nail Art".toLowerCase(), "Nails & Tools".toLowerCase(), "http://www.aliexpress.com/category/200002550/nail-art.html", "Negledesign-produkt" );
				X++;
				Itemtypes[X] = new Object_DropshipItemtype( "Nail Tools".toLowerCase(), "Nails & Tools".toLowerCase(), "http://www.aliexpress.com/category/200002577/nail-tools.html", "Negleutstyr" );
				X++;
				Itemtypes[X] = new Object_DropshipItemtype( "Nail Polish".toLowerCase(), "Nails & Tools".toLowerCase(), "http://www.aliexpress.com/category/200002556/nail-polish.html", "Neglelakk" );
				X++;
				Itemtypes[X] = new Object_DropshipItemtype( "False Nails".toLowerCase(), "Nails & Tools".toLowerCase(), "http://www.aliexpress.com/category/200002549/false-nails.html", "Falske Negler" );
				X++;
				Itemtypes[X] = new Object_DropshipItemtype( "Nail Gel".toLowerCase(), "Nails & Tools".toLowerCase(), "http://www.aliexpress.com/category/200002555/nail-gel.html", "Negle-Gel" );
				X++;
				Itemtypes[X] = new Object_DropshipItemtype( "Acrylic Powders & Liquids".toLowerCase(), "Nails & Tools".toLowerCase(), "http://www.aliexpress.com/category/200002548/acrylic-powders-liquids.html", "Acrylic Liquid\\Powder" );
				
			//make-up
			X++;
			Itemtypes[X] = new Object_DropshipItemtype( "Makeup".toLowerCase(), "Beauty & Health".toLowerCase(), "http://www.aliexpress.com/category/660103/makeup.html", "Sminke" );
				X++;
				Itemtypes[X] = new Object_DropshipItemtype( "Makeup Tools".toLowerCase(), "Makeup".toLowerCase(), "http://www.aliexpress.com/category/200002536/makeup-tools.html", "Sminkeutstyr" );
					X++;
					Itemtypes[X] = new Object_DropshipItemtype( "Makeup Brushes & Tools".toLowerCase(), "Makeup Tools".toLowerCase(), "http://www.aliexpress.com/category/200002544/makeup-brushes-tools.html", "Sminkeb&oslashrste" );
		
		
		X++;
		Itemtypes[X] = new Object_DropshipItemtype( "Apparel & Accessories".toLowerCase(), "Home".toLowerCase(), "http://www.aliexpress.com/category/3/apparel-amp--accessories.html", "Kl&aeligr" );
			X++;
			Itemtypes[X] = new Object_DropshipItemtype( "Women".toLowerCase(), "Apparel & Accessories".toLowerCase(), "http://www.aliexpress.com/category/100003109/women.html", "Damekl&aeligr" );
				//badetøy
				X++;
				Itemtypes[X] = new Object_DropshipItemtype( "Swimwear".toLowerCase(), "Women".toLowerCase(), "http://www.aliexpress.com/category/200000784/swimwear.html", "Badet&oslashy for Dame" );
					X++;
					Itemtypes[X] = new Object_DropshipItemtype( "Bikinis Set".toLowerCase(), "Swimwear".toLowerCase(), "http://www.aliexpress.com/category/200000793/bikinis-set.html", "Badebikini" );
					X++;
					Itemtypes[X] = new Object_DropshipItemtype( "One Pieces".toLowerCase(), "Swimwear".toLowerCase(), "http://www.aliexpress.com/category/200000802/one-pieces.html", "Badedrakt" );
					
				X++;
				Itemtypes[X] = new Object_DropshipItemtype( "Accessories".toLowerCase(), "Women".toLowerCase(), "http://www.aliexpress.com/category/100003109/women.html", "Accessory" );
				//briller
					X++;
					Itemtypes[X] = new Object_DropshipItemtype( "Eyewear & Accessories".toLowerCase(), "Accessories".toLowerCase(), "http://www.aliexpress.com/category/200000724/accessories.html", "Damebriller" );
						X++;
						Itemtypes[X] = new Object_DropshipItemtype( "Sunglasses".toLowerCase(), "Eyewear & Accessories".toLowerCase(), "http://www.aliexpress.com/category/200000750/sunglasses.html", "Solbriller for dame" );
		
		//klokker
		X++;
		Itemtypes[X] = new Object_DropshipItemtype( "Watches".toLowerCase(), "Home".toLowerCase(), "http://www.aliexpress.com/category/1511/watches.html", "Klokke" );
			X++;
			Itemtypes[X] = new Object_DropshipItemtype( "Wristwatches".toLowerCase(), "Watches".toLowerCase(), "http://www.aliexpress.com/category/100002824/wristwatches.html", "Armb&aringndsur" );
		
		//smykker
		X++;
		Itemtypes[X] = new Object_DropshipItemtype( "Jewelry".toLowerCase(), "Home".toLowerCase(), "http://www.aliexpress.com/category/1509/jewelry.html", "Smykke" );
			X++;
			Itemtypes[X] = new Object_DropshipItemtype( "Jewelry Findings & Components".toLowerCase(), "Jewelry".toLowerCase(), "http://www.aliexpress.com/category/200002962/jewelry-findings-components.html", "Smykkekomponent" );
		
			X++;
			Itemtypes[X] = new Object_DropshipItemtype( "Necklaces & Pendants".toLowerCase(), "Jewelry".toLowerCase(), "http://www.aliexpress.com/category/200000109/necklaces-pendants.html", "Halskjede" );
				X++;
				Itemtypes[X] = new Object_DropshipItemtype( "Pendants".toLowerCase(), "Necklaces & Pendants".toLowerCase(), "http://www.aliexpress.com/category/200000156/pendants.html", "Smykkeanheng" );
				X++;
				Itemtypes[X] = new Object_DropshipItemtype( "Pendant Necklaces".toLowerCase(), "Necklaces & Pendants".toLowerCase(), "http://www.aliexpress.com/category/200000114/pendant-necklaces.html", "Halskjede med Anheng" );
				X++;
				Itemtypes[X] = new Object_DropshipItemtype( "Power Necklaces".toLowerCase(), "Necklaces & Pendants".toLowerCase(), "http://www.aliexpress.com/category/200003191/power-necklaces.html", "Kraftig Halskjede" );
				X++;
				Itemtypes[X] = new Object_DropshipItemtype( "Chain Necklaces".toLowerCase(), "Necklaces & Pendants".toLowerCase(), "http://www.aliexpress.com/category/200000110/chain-necklaces.html", "Halskjetting" );
				X++;
				Itemtypes[X] = new Object_DropshipItemtype( "Choker Necklaces".toLowerCase(), "Necklaces & Pendants".toLowerCase(), "http://www.aliexpress.com/category/200000111/choker-necklaces.html", "Choker" );
				X++;
				Itemtypes[X] = new Object_DropshipItemtype( "Torques".toLowerCase(), "Necklaces & Pendants".toLowerCase(), "http://www.aliexpress.com/category/200000116/torques.html", "Torque" );
		
			X++;
			Itemtypes[X] = new Object_DropshipItemtype( "Earrings".toLowerCase(), "Jewelry".toLowerCase(), "http://www.aliexpress.com/category/200000139/earrings.html", "&oslashredobber" );
				X++;
				Itemtypes[X] = new Object_DropshipItemtype( "Drop Earrings".toLowerCase(), "Earrings".toLowerCase(), "http://www.aliexpress.com/category/200000141/drop-earrings.html", "&oslashredobber" );
				X++;
				Itemtypes[X] = new Object_DropshipItemtype( "Stud Earrings".toLowerCase(), "Earrings".toLowerCase(), "http://www.aliexpress.com/category/200000144/stud-earrings.html", "&oslashredobber" );
				X++;
				Itemtypes[X] = new Object_DropshipItemtype( "Clip Earrings".toLowerCase(), "Earrings".toLowerCase(), "http://www.aliexpress.com/category/200000140/clip-earrings.html", "&oslashredobber" );
				X++;
				Itemtypes[X] = new Object_DropshipItemtype( "Earring Jackets".toLowerCase(), "Earrings".toLowerCase(), "http://www.aliexpress.com/category/200000142/earring-jackets.html?", "&oslashrepynt" );
				X++;
				Itemtypes[X] = new Object_DropshipItemtype( "Hoop Earrings".toLowerCase(), "Earrings".toLowerCase(), "http://www.aliexpress.com/category/200000143/hoop-earrings.html", "&oslashreringer" );
		
			X++;
			Itemtypes[X] = new Object_DropshipItemtype( "Rings".toLowerCase(), "Jewelry".toLowerCase(), "http://www.aliexpress.com/category/100006749/rings.html", "Ring" );
			X++;
			Itemtypes[X] = new Object_DropshipItemtype( "Bracelets & Bangles".toLowerCase(), "Jewelry".toLowerCase(), "http://www.aliexpress.com/category/200000097/bracelets-bangles.html", "Armb&aringnd\\Bangle" );
			X++;
			Itemtypes[X] = new Object_DropshipItemtype( "Hair Jewelry".toLowerCase(), "Jewelry".toLowerCase(), "http://www.aliexpress.com/category/100006745/hair-jewelry.html", "H&aringrpynt" );
			X++;
			Itemtypes[X] = new Object_DropshipItemtype( "Jewelry Sets".toLowerCase(), "Jewelry".toLowerCase(), "http://www.aliexpress.com/category/100006750/jewelry-sets.html", "Smykkesett" );
			X++;
			Itemtypes[X] = new Object_DropshipItemtype( "Brooches".toLowerCase(), "Jewelry".toLowerCase(), "http://www.aliexpress.com/category/100006748/brooches.html", "Brosje" );
			X++;
			Itemtypes[X] = new Object_DropshipItemtype( "Anklets".toLowerCase(), "Jewelry".toLowerCase(), "http://www.aliexpress.com/category/200000092/anklets.html", "Anklet" );
			X++;
			Itemtypes[X] = new Object_DropshipItemtype( "Body Jewelry".toLowerCase(), "Jewelry".toLowerCase(), "http://www.aliexpress.com/category/100006741/body-jewelry.html", "Kroppssmykke" );
		
		X++;
		Itemtypes[X] = new Object_DropshipItemtype( "Home & Garden".toLowerCase(), "Home".toLowerCase(), "http://www.aliexpress.com/category/15/home-amp--garden.html", "Stuepynt" );
			X++;
			Itemtypes[X] = new Object_DropshipItemtype( "Home Decor".toLowerCase(), "Home & Garden".toLowerCase(), "http://www.aliexpress.com/category/3710/home-decor.html", "Stuedekor" );
				X++;
				Itemtypes[X] = new Object_DropshipItemtype( "Crafts".toLowerCase(), "Home Decor".toLowerCase(), "http://www.aliexpress.com/category/200003336/crafts.html", "Hobbyutstyr" );
				X++;
				Itemtypes[X] = new Object_DropshipItemtype( "Wall stickers".toLowerCase(), "Home Decor".toLowerCase(), "http://www.aliexpress.com/category/200002937/wall-stickers.html", "Wall Stickers" );
				X++;
				Itemtypes[X] = new Object_DropshipItemtype( "Candles".toLowerCase(), "Home Decor".toLowerCase(), "http://www.aliexpress.com/category/150404/candles.html", "Stearinlys" );
				X++;
				Itemtypes[X] = new Object_DropshipItemtype( "Clocks".toLowerCase(), "Home Decor".toLowerCase(), "http://www.aliexpress.com/category/1528/clocks.html", "Veggur" );
				X++;
				Itemtypes[X] = new Object_DropshipItemtype( "Incense & Incense Burners".toLowerCase(), "Home Decor".toLowerCase(), "http://www.aliexpress.com/category/100002935/incense-incense-burners.html", "R&oslashkelse" );
				X++;
				Itemtypes[X] = new Object_DropshipItemtype( "Candle Holders".toLowerCase(), "Home Decor".toLowerCase(), "http://www.aliexpress.com/category/1706/candle-holders.html", "Lysholder" );
			X++;
			Itemtypes[X] = new Object_DropshipItemtype( "Festive & Party Supplies".toLowerCase(), "Home & Garden".toLowerCase(), "http://www.aliexpress.com/category/100002992/festive-amp--party-supplies.html", "Festdekorasjon" );
				X++;
				Itemtypes[X] = new Object_DropshipItemtype( " Decorative Flowers & Wreaths".toLowerCase(), "Festive & Party Supplies".toLowerCase(), "http://www.aliexpress.com/category/100002993/decorative-flowers-wreaths.html", "Falske Blomster" );
			X++;
			Itemtypes[X] = new Object_DropshipItemtype( "Garden Supplies".toLowerCase(), "Home & Garden".toLowerCase(), "http://www.aliexpress.com/premium/category/15.html", "Hageutstyr" );
				X++;
				Itemtypes[X] = new Object_DropshipItemtype( "Garden Landscaping & Decking".toLowerCase(), "Garden Supplies".toLowerCase(), "http://www.aliexpress.com/premium/category/100002412.html", "Hageplanter" );
					X++;
					Itemtypes[X] = new Object_DropshipItemtype( "Bonsai".toLowerCase(), "Garden Landscaping & Decking".toLowerCase(), "http://www.aliexpress.com/premium/category/121.html", "Potteplanter" );
				
		X++;
		Itemtypes[X] = new Object_DropshipItemtype( "Toys & Hobbies".toLowerCase(), "Home".toLowerCase(), "http://www.aliexpress.com/category/26/toys-amp-amp--hobbies.html", "Leke" );
			X++;
			Itemtypes[X] = new Object_DropshipItemtype( "Action & Toy Figures".toLowerCase(), "Toys & Hobbies".toLowerCase(), "http://www.aliexpress.com/category/2621/action-toy-figures.html", "Actionfigur" );
			X++;
			Itemtypes[X] = new Object_DropshipItemtype( "Dolls & Stuffed Toys".toLowerCase(), "Toys & Hobbies".toLowerCase(), "http://www.aliexpress.com/category/26/toys-amp--hobbies.html", "Dukke\\Bamse" );
			X++;
			Itemtypes[X] = new Object_DropshipItemtype( "Models & Building Toy".toLowerCase(), "Toys & Hobbies".toLowerCase(), "http://www.aliexpress.com/category/200002633/models-building-toy.html", "Modellfigur" );
			X++;
			Itemtypes[X] = new Object_DropshipItemtype( "Model Building Kits".toLowerCase(), "Models & Building Toy".toLowerCase(), "http://www.aliexpress.com/category/200002635/model-building-kits.html", "Modellfigur" );
			X++;
			Itemtypes[X] = new Object_DropshipItemtype( "Blocks".toLowerCase(), "Models & Building Toy".toLowerCase(), "http://www.aliexpress.com/category/2622/blocks.html", "Byggeklosser" );
			X++;
			Itemtypes[X] = new Object_DropshipItemtype( "Classic Toys".toLowerCase(), "Toys & Hobbies".toLowerCase(), "http://www.aliexpress.com/category/100001626/classic-toys.html", "Leke" );
				X++;
				Itemtypes[X] = new Object_DropshipItemtype( "Balloons".toLowerCase(), "Classic Toys".toLowerCase(), "http://www.aliexpress.com/category/100001668/balloons.html", "Ballong" );
		
	}
	
	private void SearchTypes() {
		//System.out.println( this.getClass().toString()+" SearchTypes" );
		SearchTypes[0] = "Category";
		SearchTypes[1] = "Full crawl";
		SearchTypes[2] = "Store scan";
	}

}
