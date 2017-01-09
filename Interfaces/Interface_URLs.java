package Interfaces;

import java.io.File;

import Searching.Object_SearchJob;
import URLs.Object_URL;

public interface Interface_URLs {
	
	void RunThreads_URLfind();
	
	void Process_URLs( Object_SearchJob HentetJobb );
	
	void Save_SearchJob_URL( Object_SearchJob jobb ) throws Exception;
	
	void Save_SearchJob_URL_Resultpage( Object_SearchJob jobb ) throws Exception;
	
	void Save_SearchJob_URL_Auction( Object_SearchJob jobb ) throws Exception;
	
	void SaveURLToDisk( Object_URL Adresse ) throws Exception;

	void LoadURLs_new() throws Exception;
}
