package Dropshippers;

import Control.Controller;
import Itemtypes.Object_DropshipItemtype;

public class Object_Dropshipper_CasJewellery extends Object_Dropshipper {

	
	public Object_Dropshipper_CasJewellery( Controller Class_Controller ) {
		super( "CasJewellery", "http://www.casjewellery.com/", Class_Controller );
		System.out.println( this.getClass().toString()+" constructor" );
		
		ItemTypes();
		SearchTypes();
		
	}
	
	private void ItemTypes() {
		System.out.println( this.getClass().toString()+" ItemTypes "); 
		int X = -1;
		



	}
	
	private void SearchTypes() {
		SearchTypes[0] = "Category";
		SearchTypes[1] = "Full crawl";
	}

}
