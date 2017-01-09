package Interfaces;

import Searching.Object_SearchJob;

public interface Interface_MainWindow {
	
	void MainWindow_Startup() throws Exception;

	void UpdateURLGUI(Object_SearchJob hentetSide) throws Exception;
	
	void Set_URLsFound( int i ) throws Exception;
	
	void AddProgressMessage(String string) throws Exception;
	
	void AddItemypes();
	
	void SetCurrentAction( String actionText );
	
	void MainWindow_ActivateItemType(String label, boolean selected);
	
	int Get_TotalURLS();
}
