package Interfaces;

import Searching.Object_SearchJob;
import URLs.Object_URL;

public interface Interface_Searching {
	
	void RunThreads_Searching() throws Exception;
	
	void Save_NewURL_Search( Object_URL nyURL, Object_SearchJob New ) throws Exception;
	
	//void Save_NewURL_Search_Auction( Object_URL nyURL, Object_SearchJob New ) throws Exception;
	
	//void Save_NewURL_Search_Resultpage( Object_URL nyURL, Object_SearchJob New ) throws Exception;
	
	Object_SearchJob SearchFor_Search_URL( Object_SearchJob object_SearchJob) throws Exception;
	
	//Object_SearchJob SearchFor_Search_Auction_URL( Object_SearchJob object_SearchJob) throws Exception;
	
	//Object_SearchJob SearchFor_Search_Resultpage_URL( Object_SearchJob object_SearchJob) throws Exception;
	
	void RunThreads_Search() throws Exception;
	
	//void RunThreads_Search_Resultpages() throws Exception;
	
	//void RunThreads_Search_Auctions() throws Exception;
	
	void Process_Search( Object_SearchJob HentetJobb ) throws Exception;
	
	//void Process_Search_Auctions( Object_SearchJob HentetJobb );
	
	//void Process_Search_Resultpages( Object_SearchJob HentetJobb ) throws Exception;
	
	void UpdateURLGUI_Hashmap() throws Exception;
	
	void Save_SearchJob_Search(Object_SearchJob test) throws Exception;
}
