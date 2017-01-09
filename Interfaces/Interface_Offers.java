package Interfaces;

import Searching.Object_SearchJob;

public interface Interface_Offers {

	void RunThreads_Offers() throws Exception;
	
	void RunThreads_Identify();
	//void RunThreads_Identify_Resultpages();
	//void RunThreads_Identify_Auctions();
	
	void Process_Identify( Object_SearchJob HentetJobb ) throws Exception;
	//void Process_Identify_Resultpages( Object_SearchJob HentetJobb ) throws Exception;
	//void Process_Identify_Auctions( Object_SearchJob HentetJobb ) throws Exception;
	
	void Save_DownloadedPage( Object_SearchJob jobb ) throws Exception;
	//void Save_DownloadedPage_Resultpage( Object_SearchJob jobb ) throws Exception;
	//void Save_DownloadedPage_Auction( Object_SearchJob jobb ) throws Exception;
	
	void Save_SearchJob_Offers( Object_SearchJob test ) throws Exception;
}
