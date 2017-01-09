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

public class Object_TreeMap_int  extends Object_TreeMap implements Serializable, Interface_TreeMap {
	
	private static final long serialVersionUID = 4018402984990626872L;
	public TreeMap<Object,Object_SearchJob> Kart_int;

	boolean	Listing = false;
	
	public Object_TreeMap_int(Controller Class_Controller) throws Exception {
		super(Class_Controller);
		Kart_int = new TreeMap(Collections.reverseOrder());

	}
	
	@Override
	public Map Get_SynchedKart() {
		Map<Object,Object_SearchJob> SynchedKart2 = Collections.synchronizedMap( Kart_int );
		return SynchedKart2;
	}

	@Override
	public Object_SearchJob SearchFor( int SearchValue ) throws Exception {
		//System.out.println( this.getClass().toString()+" SearchFor SearchValue="+SearchValue );
		try {
			return (Object_SearchJob) Kart_int.get( SearchValue );
		} catch ( Exception e ) {
			return null;
		}
	}
	
	@Override
	public void SaveObject( int KeyValue, Object_SearchJob Content ) throws Exception {
		//System.out.println( this.getClass().toString()+" SaveObject A KeyValue="+KeyValue+" Content="+Content );
		Object Check = SearchFor( KeyValue );
		if ( Check == null ) {
			//System.out.println( this.getClass().toString()+" SaveObject B KeyValue="+KeyValue+" Content="+Content );
			Save( KeyValue, Content );
		}
	}
	
	@Override
	public void Save( Object KeyValue, Object_SearchJob Content ) throws Exception {
		//System.out.println( this.getClass().toString()+" "+this.toString()+" Save "+KeyValue+" Content="+Content );
		Kart_int.put( KeyValue, Content );
	}
	
	@Override
	public void SendContents() throws Exception {
		//System.out.println( this.getClass().toString()+" SendContents" );
		if ( Listing == true ) {
			return;
		}
		Listing = true;
		int URLtellerB = 0;

		try { 

			NavigableSet<Object> keys = new TreeSet<Object>(this.Kart_int.keySet());
			for(Iterator<Object> it = keys.descendingIterator(); it.hasNext();) {
				int key = (Integer) it.next();
				Object_SearchJob HentetSide = Kart_int.get(key);
		    	if ( HentetSide != null ) {
			    	URLtellerB++;
			    	//System.out.println( this.getClass().toString()+" SendContents C2 HentetSide="+HentetSide.Get_Adresse().toString() );
			    	Class_Controller.UpdateURLGUI( HentetSide );
		    	}
			} 
		} catch ( Exception T ) {
			Class_Controller.ReportError( T, this.getClass().toString()+" SendContents B" );
			System.out.println( this.getClass().toString()+" SendContents error" );
		}
		//System.out.println( this.getClass().toString()+" SendContents URLteller="+URLtellerB );
		Listing = false;
	}

}
