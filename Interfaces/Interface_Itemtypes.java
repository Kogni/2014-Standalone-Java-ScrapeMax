package Interfaces;

import Dropshippers.Object_Dropshipper;
import Itemtypes.Object_DropshipItemtype;
import Offers.Object_Product_Offer;
import Searching.Object_SearchJob;

public interface Interface_Itemtypes {

	void Itemtypes_Startup( Object_Dropshipper Dropshipper ) throws Exception;
	
	void LoadItemTypeSettings() throws Exception;
	
	void SaveSettings ( ) throws Exception;
	
	void Insert_New_Itemtype( String Category, String ParentCategory, String Homepage, String Subject, boolean Enabled );
	
	int CheckRelationValue_Job(Object_SearchJob jobb) throws Exception;
	
	int CheckRelationValue_Job_Category( Object_SearchJob jobb ) ;
	
	int CheckRelationValue_Job_FullCrawl( Object_SearchJob jobb );
	
	int CheckRelationValue_URL( String Adresse );
	
	boolean ItemTypeAccepted( Object_Product_Offer Produkt, String category, String parentCategory, String crumbs );
	
	boolean TestItemtype( String category, String parentCategory, String crumbs, Object_DropshipItemtype itemtype, String Source );
	
	boolean Itemtypes_ActivateItemType( String label, boolean selected ) throws Exception;
	
	boolean Get_ItemtypeSelectionStatus( String category );
}
