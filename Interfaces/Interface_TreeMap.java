package Interfaces;

import java.util.Map;

import Searching.Object_SearchJob;

public interface Interface_TreeMap {

	Map<Object,Object_SearchJob> Get_SynchedKart();
	
	void SaveObject( Object KeyValue, Object_SearchJob Content ) throws Exception;
	
	void SaveObject( String KeyValue, Object_SearchJob Content ) throws Exception;
	
	void SaveObject( int KeyValue, Object_SearchJob Content ) throws Exception;
	
	Object_SearchJob SearchFor( Object SearchValue ) throws Exception;
	
	Object_SearchJob SearchFor(String string) throws Exception;
	
	Object_SearchJob SearchFor(int relationValue) throws Exception;
	
	void RemoveFromTreeMap( Object SearchValue ) throws Exception;
	
	void Save( Object KeyValue, Object_SearchJob Content ) throws Exception;
	
	void SendContents() throws Exception;
}
