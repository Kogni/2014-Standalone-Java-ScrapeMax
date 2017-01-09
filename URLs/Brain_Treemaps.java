package URLs;

import java.util.TreeMap;

import Control.Controller;
import Interfaces.Interface_Treemaps;
import Searching.Object_SearchJob;

public class Brain_Treemaps implements Interface_Treemaps {
	
	Controller Class_Controller;
	
	public Brain_Treemaps( Controller Class_Controller ) throws Exception {
		//System.out.println( this.getClass().toString()+" constructor" );
		this.Class_Controller = Class_Controller;
	}

	public Object_TreeMap_String ExpandTreeMap_String( Object_TreeMap_String OldTreeMap, String NewKey, Object_SearchJob NewContent ) throws Exception {
		Object_TreeMap_String NewMap = new Object_TreeMap_String(Class_Controller);
		NewMap.Kart_String = (TreeMap<String, Object_SearchJob>) OldTreeMap.Kart_String.clone();
		NewMap.SaveObject( NewKey, NewContent );
		
		return NewMap;
	}
	
	public Object_TreeMap_int ExpandTreeMap_int( Object_TreeMap_int OldTreeMap, int NewKey, Object_SearchJob NewContent ) throws Exception {
		Object_TreeMap_int NewMap = new Object_TreeMap_int(Class_Controller);
		NewMap.Kart_int = (TreeMap<Object, Object_SearchJob>) OldTreeMap.Kart_int.clone();
		NewMap.SaveObject( NewKey, NewContent );
		//System.out.println( this.getClass().toString()+" ExpandTreeMap_int NewMap="+NewMap );
		return NewMap;
	}
	
}
