package URLs;

import java.io.Serializable;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

import Searching.Object_SearchJob;

import Control.Controller;

public class Object_TreeMap implements Serializable {
	
	private static final long serialVersionUID = 4018402984990626872L;
	Controller Class_Controller;
	TreeMap Kart_Base;

	boolean	Listing = false;
	
	public Object_TreeMap( Controller Class_Controller ) throws Exception {
		this.Class_Controller = Class_Controller;
		Kart_Base = new TreeMap(Collections.reverseOrder());

	}
	
	public Map<Object,Object_SearchJob> Get_SynchedKart() {
		Map<Object,Object_SearchJob> SynchedKart2 = Collections.synchronizedMap( Kart_Base );
		return SynchedKart2;
	}
	
	//----
	
	public void SaveObject( Object KeyValue, Object_SearchJob Content ) throws Exception {
		//System.out.println( this.getClass().toString()+" SaveObject A KeyValue="+KeyValue+" Content="+Content );
		Object_SearchJob Check = SearchFor( KeyValue );
		if ( Check == null ) {
			//System.out.println( this.getClass().toString()+" SaveObject B1 KeyValue="+KeyValue+" Content="+Content );
			Save( KeyValue, Content );
		} else {
			//System.out.println( this.getClass().toString()+" SaveObject B2 Already saved: KeyValue="+KeyValue+" Content="+Content );
		}
	}

	public void SaveObject( String KeyValue, Object_SearchJob Content ) throws Exception {
		System.out.println( this.getClass().toString()+" SaveObject" );
		a+a;
	}
	
	public void SaveObject( int KeyValue, Object_SearchJob Content ) throws Exception {
		System.out.println( this.getClass().toString()+" SaveObject" );
		a+a;
	}
	
	//----
	
	public Object_SearchJob SearchFor( Object SearchValue ) throws Exception {
		//System.out.println( this.getClass().toString()+" SearchFor SearchValue="+SearchValue );
		try {
			return (Object_SearchJob) Kart_Base.get( SearchValue );
		} catch ( Exception e ) {
			return null;
		}
	}

	public Object_SearchJob SearchFor(String string) throws Exception {
		//System.out.println( this.getClass().toString()+" SearchFor" );
		a+a;
		return null;
	}

	public Object_SearchJob SearchFor(int relationValue) throws Exception {
		//System.out.println( this.getClass().toString()+" SearchFor SearchValue="+relationValue );
		try {
			return (Object_SearchJob) Kart_Base.get( relationValue );
		} catch ( Exception e ) {
			return null;
		}
	}
	
	//----

	public void RemoveFromTreeMap( Object SearchValue ) throws Exception {
		//System.out.println( this.getClass().toString()+" RemoveFromTreeMap" );
		Kart_Base.remove( SearchValue );
	}
	
	public void Save( Object KeyValue, Object_SearchJob Content ) throws Exception {
		//System.out.println( this.getClass().toString()+" "+this.toString()+" Save "+KeyValue+" Content="+Content );
		Kart_Base.put( KeyValue, Content );
	}

	public void SendContents() throws Exception {
		System.out.println( this.getClass().toString()+" SendContents" );
		if ( Listing == true ) {
			return;
		}
		Listing = true;
		int URLtellerB = 0;
		try { 
			NavigableSet<Object> keys = new TreeSet<Object>(this.Kart_Base.keySet());
			for(Iterator<Object> it = keys.descendingIterator(); it.hasNext();) {
				int key = (Integer) it.next();
				Object_SearchJob HentetSide = (Object_SearchJob) Kart_Base.get(key);
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

	public Object_SearchJob[] Get_ContentArray() throws Exception {
		int URLtellerB = 0;
		try { 
			NavigableSet<Object> keys2 = new TreeSet<Object>(this.Kart_Base.keySet());
			for(Iterator<Object> it = keys2.descendingIterator(); it.hasNext();) {
				int key = (Integer) it.next();
				Object_SearchJob HentetSide = (Object_SearchJob) Kart_Base.get(key);
				//System.out.println( this.getClass().toString()+" Get_ContentArray A HentetSide="+HentetSide );
		    	if ( HentetSide != null ) {
			    	//System.out.println( this.getClass().toString()+" Get_ContentArray B HentetSide="+HentetSide.Get_Adresse().toString() );
			    	URLtellerB++;

		    	}
			} 
			Object_SearchJob[] Array = new Object_SearchJob[URLtellerB];
			NavigableSet<Object> keys = new TreeSet<Object>(this.Kart_Base.keySet());
			//System.out.println( this.getClass().toString()+" Get_ContentArray C URLtellerB="+URLtellerB );
			URLtellerB = 0;
			for(Iterator<Object> it = keys.descendingIterator(); it.hasNext();) {
				int key = (Integer) it.next();
				Object_SearchJob HentetSide = (Object_SearchJob) Kart_Base.get(key);
				//System.out.println( this.getClass().toString()+" Get_ContentArray D HentetSide="+HentetSide );
		    	if ( HentetSide != null ) {
		    		URLtellerB++;
		    		Array[URLtellerB] = HentetSide;
		    		//System.out.println( this.getClass().toString()+" Get_ContentArray E URLtellerB="+URLtellerB );

		    	}
			}
			return Array;
		} catch ( Exception T ) {
			Class_Controller.ReportError( T, this.getClass().toString()+" SendContents" );
			System.out.println( this.getClass().toString()+" SendContents error" );
		}
		return null;
	}


}
