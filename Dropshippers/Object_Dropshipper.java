package Dropshippers;

import java.util.Date;

import Control.Controller;
import Itemtypes.Object_DropshipItemtype;
import Searching.Object_SearchJob;
import URLs.Object_URL;

public class Object_Dropshipper {

	Controller Class_Controller;
	public String DropshipperName;
	String DropshipperSite;
	Date DowntimeTimer;
	
	Object_DropshipItemtype[]	Itemtypes;
	String[] 			SearchTypes;
	String				GenericStorePath;
	
	public Object_Dropshipper( String DropshipperName, String DropshipperSite, Controller Class_Controller ) {
		
		this.DropshipperName = DropshipperName;
		this.DropshipperSite = DropshipperSite;
		this.Class_Controller = Class_Controller;
		
		Itemtypes = new Object_DropshipItemtype[900];
		SearchTypes = new String[3];
	}

	public void Send_Start_URLs() throws Exception {
		if ( Class_Controller.Loading_URLS() == true ) {
			return;
		}
		int Value = 9999;
		String Adresse = DropshipperSite;
		Object_URL nyURL = new Object_URL( Adresse, Value, Class_Controller, null, 1 );
		Object_SearchJob Check;
		if ( Class_Controller.Get_SelectedSearchtype( this.getClass().toString()+" Send_Start_URLs" ).equals("Full crawl") ) {
			Check = Class_Controller.SearchHashmapForURL( new Object_SearchJob( nyURL, Class_Controller, Class_Controller.Get_SelectedSearchtype( this.getClass().toString()+" Send_Start_URLs" ), this.getClass().toString()+" Send_Start_URLs" ) );
			if ( Check == null ) {
				Class_Controller.SaveNewURL( nyURL );
				return;
			}
			for ( int X = 0 ; X < Itemtypes.length ; X++ ) {
				if ( Itemtypes[X] != null ) {
					
					if ( Class_Controller.Get_ItemtypeSelectionStatus( Itemtypes[X].Dropship_Category ) == true ) {
						Value = 99999;
					} else {
						Value = 0;
					}
					Adresse = Itemtypes[X].Dropship_HomePage;
					Check = Class_Controller.SearchHashmapForURL( new Object_SearchJob( nyURL, Class_Controller, Class_Controller.Get_SelectedSearchtype( this.getClass().toString()+" Send_Start_URLs" ), this.getClass().toString()+" Send_Start_URLs" ) );
					if ( Check == null ) {
						Class_Controller.SaveNewURL( nyURL );
						return;
					}
				}
			}
		} else if ( Class_Controller.Get_SelectedSearchtype( this.getClass().toString()+" Send_Start_URLs" ).equals("Category") ) {
			for ( int X = 0 ; X < Itemtypes.length ; X++ ) {
				if ( Itemtypes[X] != null ) {
					if ( Class_Controller.Get_ItemtypeSelectionStatus( Itemtypes[X].Dropship_Category ) == true ) {
						Value = 99999;
						Adresse = Itemtypes[X].Dropship_HomePage;
						nyURL = new Object_URL( Adresse, Value, Class_Controller, null, 1 );
						Check = Class_Controller.SearchHashmapForURL( new Object_SearchJob( nyURL, Class_Controller, Class_Controller.Get_SelectedSearchtype( this.getClass().toString()+" Send_Start_URLs" ), this.getClass().toString()+" Send_Start_URLs" ) );
						if ( Check == null ) {
							Class_Controller.SaveNewURL( nyURL );
							return;
						}
					}
				}
			}
		} else if ( Class_Controller.Get_SelectedSearchtype( this.getClass().toString()+" Send_Start_URLs" ).equals("Store scan") ) {
			if ( GenericStorePath == null ) {
				return;
			} else {
				nyURL = new Object_URL( Adresse, Value, Class_Controller, null, 1 );
				Value = 99999;
				Check = Class_Controller.SearchHashmapForURL( new Object_SearchJob( nyURL, Class_Controller, Class_Controller.Get_SelectedSearchtype( this.getClass().toString()+" Send_Start_URLs" ), this.getClass().toString()+" Send_Start_URLs" ) );
				if ( Check == null ) {
					Class_Controller.SaveNewURL( nyURL );
					return;
				}
			}
		}

	}

	public Object_DropshipItemtype[] Get_Itemtypes() {
		return Itemtypes;
	}

	public String[] Get_Itemtypes_String() {
		String[] Strings = new String[ Itemtypes.length ];
		try {
			for ( int X = 0 ; X< Itemtypes.length ; X++ ) {
				if ( Itemtypes[X] != null ) {
					Strings[X] = Itemtypes[X].Dropship_Category;
				}
			}
		} catch ( Exception T ) {
			
		}
		return Strings;
	}

	public String[] Get_Searchtypes() {
		return SearchTypes;
	}
}
