package URLs;

import java.io.Serializable;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

import Searching.Object_SearchJob;


import Control.Controller;
import Interfaces.Interface_TreeMap;

public class Object_TreeMap_String extends Object_TreeMap implements Serializable, Interface_TreeMap {

	private static final long serialVersionUID = 4018402984990626872L;
	public TreeMap<String,Object_SearchJob> Kart_String;

	boolean	Listing = false;
	
	public Object_TreeMap_String(Controller Class_Controller) throws Exception {
		super(Class_Controller);
		Kart_String = new TreeMap(Collections.reverseOrder());

	}
	
	@Override
	public Map Get_SynchedKart() {
		//SynchedKart_String = Collections.synchronizedMap( Kart_String );
		Map<String,Object_SearchJob> SynchedKart2 = Collections.synchronizedMap( Kart_String );
		return SynchedKart2;
	}

	@Override
	public Object_SearchJob SearchFor( String SearchValue ) throws Exception {
		//System.out.println( this.getClass().toString()+" "+this.toString()+" SearchFor SearchValue="+SearchValue );
		try {
			Object Result = Kart_String.get( SearchValue );
			//System.out.println( this.getClass().toString()+" "+this.toString()+" SearchFor SearchValue="+SearchValue+" Result="+Result );
			if ( Result != null ) {
				//System.out.println( this.getClass().toString()+" SearchFor SearchValue="+SearchValue+" Result="+Result+" "+this.toString() );
			}
			return (Object_SearchJob) Result;
		} catch ( Exception e ) {
			this.Class_Controller.ReportError(e, this.getClass().toString()+" SearchFor" );
			return null;
		}
	}
	
	public void SaveObject( String KeyValue, Object_SearchJob Content ) throws Exception {
		Object_SearchJob Check = SearchFor( KeyValue );
		//System.out.println( this.getClass().toString()+" "+this.toString()+" SaveObject A KeyValue="+KeyValue+" Content="+Content );
		if ( Check == null ) {
			if ( Content != null ) {
				//System.out.println( this.getClass().toString()+" SaveObject B KeyValue="+KeyValue+" Content="+Content.Get_Adresse().toString()+" "+this.toString() );
			}
			Save( KeyValue, Content );
		}
	}
	
	@Override
	public void Save( Object KeyValue, Object_SearchJob Content ) throws Exception {
		//System.out.println( this.getClass().toString()+" "+this.toString()+" Save "+KeyValue+" Content="+Content );
		Kart_String.put( (String) KeyValue, Content );
	}
	
	@Override
	public void SendContents() throws Exception {
		System.out.println( this.getClass().toString()+" SendContents" );
		if ( Listing == true ) {
			return;
		}
		Listing = true;
		int URLtellerB = 0;
		try { 

			NavigableSet<String> keys = new TreeSet<String>(this.Kart_String.keySet());
			for(Iterator<String> it = keys.descendingIterator(); it.hasNext();) {
				String key = it.next();
				Object_SearchJob HentetSide = Kart_String.get(key);
				
		    	if ( HentetSide != null ) {
			    	//System.out.println( this.getClass().toString()+" SendContents C HentetSide="+HentetSide.Get_Adresse().toString() );
			    	URLtellerB++;
			    	Class_Controller.UpdateURLGUI( HentetSide );
		    	}
			} 
		} catch ( Exception T ) {
			Class_Controller.ReportError( T, this.getClass().toString()+" SendContents" );
			System.out.println( this.getClass().toString()+" SendContents error" );
		}
		//System.out.println( this.getClass().toString()+" SendContents URLteller="+URLtellerB );
		Listing = false;
	}

}
