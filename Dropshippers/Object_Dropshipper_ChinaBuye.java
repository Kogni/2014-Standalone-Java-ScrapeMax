package Dropshippers;

import Control.Controller;
import Itemtypes.Object_DropshipItemtype;

public class Object_Dropshipper_ChinaBuye extends Object_Dropshipper {

	
	public Object_Dropshipper_ChinaBuye( Controller Class_Controller ) {
		super( "ChinaBuye", "http://www.chinabuye.com/", Class_Controller );
		System.out.println( this.getClass().toString()+" constructor" );
		
		ItemTypes();
		SearchTypes();
		
	}
	
	private void ItemTypes() {
		System.out.println( this.getClass().toString()+" ItemTypes "); 
		int X = -1;
		
		X++;
		Itemtypes[X] = new Object_DropshipItemtype( "Computer".toLowerCase(), "Home".toLowerCase(), "http://www.chinabuye.com/computer-accessories", "PC-Utstyr" );
		X++;
		Itemtypes[X] = new Object_DropshipItemtype( "Cell Phone".toLowerCase(), "Home".toLowerCase(), "http://www.chinabuye.com/cell-phone-accessories", "Mobiltelefon" );


	}
	
	private void SearchTypes() {
		SearchTypes[0] = "Category";
		SearchTypes[1] = "Full crawl";
	}

}
