package Interfaces;

import Offers.Object_Product_Offer;

public interface Interface_Saving {

	void PrintOffer( Object_Product_Offer Offer ) throws Exception;
	
	void PrintToCSV( Object_Product_Offer Offer ) throws Exception;
	
	void PrintToFolder( Object_Product_Offer Offer ) throws Exception;
	
	void saveImage2(String imageUrl, String destinationFile) throws Exception;
	
	void Set_Setting_SaveType(String type) throws Exception;
	
	void PrintActionLog( String Message ) throws Exception;
	
	void PrintErrorLog( Exception t2, String source ) throws Exception;
}
