package Wholesalers;

import java.net.MalformedURLException;
import java.net.URL;

public class Object_Wholesaler {
	
	int WholesalerID;
	URL WholesalerShopURL;

	public Object_Wholesaler( int WholesalerID, String GenericStorePath ) {
		this.WholesalerID = WholesalerID;
		try {
			WholesalerShopURL = new URL(GenericStorePath+""+WholesalerID);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

}
