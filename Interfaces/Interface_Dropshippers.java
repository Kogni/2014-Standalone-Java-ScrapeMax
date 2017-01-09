package Interfaces;

import java.util.Date;

import Dropshippers.Object_Dropshipper;

public interface Interface_Dropshippers {
	
	void Dropshippers_Startup( );

	void Insert_New_Dropshipper( String Name ) throws Exception;
	
	Object_Dropshipper Get_SelectedDropshipper( String Source );
	
	Object_Dropshipper[] Get_Dropshippers_Object();
	
	void Set_SelectedDropshipper( String selectedDropshipper ) throws Exception;
	
	boolean isProductPage( String adresse );
	
	void Set_DropshipperDowntime(String dropshipper, Date date);
	
	Date Get_DropshipperDowntime(String get_Domain_Lang);
}
