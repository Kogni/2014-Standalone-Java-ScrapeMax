package Dropshippers;

import Control.Controller;
import Itemtypes.Object_DropshipItemtype;

public class Object_Dropshipper_1on1 extends Object_Dropshipper {

	
	public Object_Dropshipper_1on1( Controller Class_Controller ) {
		super( "1on1dropship", "https://www.1on1dropship.co.uk/default.asp", Class_Controller );
		//System.out.println( this.getClass().toString()+" this.DropshipperName="+this.DropshipperName );
		ItemTypes();
		SearchTypes();
		
	}
	
	private void ItemTypes() {
		int X = -1;
		
		//Anal Toys
		X++;
		Itemtypes[X] = new Object_DropshipItemtype( "Anal Toys".toLowerCase(), "Home".toLowerCase(), "https://www.1on1dropship.co.uk/modules/ranges.asp?catid=5", "Anale Leker" );
		
		X++;
		Itemtypes[X] = new Object_DropshipItemtype( "Toys For Her".toLowerCase(), "Home".toLowerCase(), "https://www.1on1dropship.co.uk/modules/ranges.asp?catid=4", "Sexleker for Dame" );
		
		X++;
		Itemtypes[X] = new Object_DropshipItemtype( "Toys For Him".toLowerCase(), "Home".toLowerCase(), "https://www.1on1dropship.co.uk/modules/ranges.asp?catid=3", "Sexleker for Herre" );
		
		X++;
		Itemtypes[X] = new Object_DropshipItemtype( "Vibrators".toLowerCase(), "Home".toLowerCase(), "https://www.1on1dropship.co.uk/modules/ranges.asp?catid=1", "Vibrator" );
		
	}
	
	private void SearchTypes() {
		SearchTypes[0] = "Category";
		SearchTypes[1] = "Full crawl";
	}

}
