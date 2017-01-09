package Dropshippers;

import Control.Controller;
import Itemtypes.Object_DropshipItemtype;

public class Object_Dropshipper_Tmart extends Object_Dropshipper {

	
	public Object_Dropshipper_Tmart( Controller Class_Controller ) {
		super( "Tmart", "https://www.tmart.com/", Class_Controller );
		//System.out.println( this.getClass().toString()+" constructor" );
		
		ItemTypes();
		SearchTypes();
		
	}
	
	private void ItemTypes() {
		//System.out.println( this.getClass().toString()+" ItemTypes "); 
		int X = -1;
		
		X++;
		Itemtypes[X] = new Object_DropshipItemtype( "Apple Accessories".toLowerCase(), "Home".toLowerCase(), "http://www.tmart.com/Apple-Accessories/", "Apple-utstyr" );
		X++;
		Itemtypes[X] = new Object_DropshipItemtype( "Cell Phones".toLowerCase(), "Home".toLowerCase(), "http://www.tmart.com/Cell-Phones/", "Mobilutstyr" );
		X++;
		Itemtypes[X] = new Object_DropshipItemtype( "Health & Beauty".toLowerCase(), "Home".toLowerCase(), "http://www.tmart.com/Health-Beauty/", "Skj&oslashnnhetsprodukt" );
		X++;
		Itemtypes[X] = new Object_DropshipItemtype( "Toys & Hobbies".toLowerCase(), "Home".toLowerCase(), "http://www.tmart.com/Toys-Hobbies/", "Leke" );
		X++;
		Itemtypes[X] = new Object_DropshipItemtype( "Apparel".toLowerCase(), "Home".toLowerCase(), "http://www.tmart.com/Apparel/", "Kl&aeligr" );

	}
	
	private void SearchTypes() {
		SearchTypes[0] = "Category";
		SearchTypes[1] = "Full crawl";
	}

}
