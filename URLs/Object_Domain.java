package URLs;

import java.io.Serializable;
import java.net.URL;

import Control.Controller;

public class Object_Domain extends Object_URL implements Serializable {

	private static final long serialVersionUID = 9041791139132482417L;

	public Object_Domain( String adresse, int RelationValue, Controller Class_Controller, Object_URL ParentURL, int Layer ) throws Exception {
		super( adresse, RelationValue, Class_Controller, ParentURL, Layer );
	}


}
