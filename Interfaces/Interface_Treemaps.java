package Interfaces;

import Searching.Object_SearchJob;
import URLs.Object_TreeMap_String;
import URLs.Object_TreeMap_int;

public interface Interface_Treemaps {

	Object_TreeMap_String ExpandTreeMap_String( Object_TreeMap_String OldTreeMap, String NewKey, Object_SearchJob NewContent ) throws Exception;
	
	Object_TreeMap_int ExpandTreeMap_int( Object_TreeMap_int OldTreeMap, int NewKey, Object_SearchJob NewContent ) throws Exception;
}
