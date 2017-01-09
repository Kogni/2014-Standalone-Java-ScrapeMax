package Off;

import java.awt.Container;
import java.awt.GridBagConstraints;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import Control.Controller;
import Dropshippers.Panel_Settings_Dropshippers;
import Itemtypes.Panel_Settings_ItemTypes;
import Offers.Panel_Settings_Offers;
import Searching.Panel_Settings_SearchSettings;
import URLs.Panel_URLs;

public class Panel_Settings extends JPanel {
	Controller Class_Controller;

	JPanel						TotalPanel;
	//JTabbedPane		TabHolder;
		Panel_Settings_SaveSettings		Tab_Panel_Settings_SaveSettings;
		Panel_Settings_Dropshippers		Tab_Panel_Settings_Dropshippers;
		Panel_Settings_ItemTypes		Tab_Panel_Panel_Settings_ItemTypes;
		//Panel_Settings_Offers			Tab_Panel_Settings_Offers;
		
		Panel_Settings_SearchSettings	Tab_Panel_Panel_Settings_SearchSettings;
		
		public Panel_Settings( Controller Class_Controller ) {
			this.Class_Controller = Class_Controller;
			
			
		}

		public void Startup() {
			System.out.println( this.getClass().toString()+" Startup" );
			
			setSize ( 1000, 600 );
			//setBackground ( new Color ( ( 255 ), ( 0 ), ( 0 ) ) );
			
			TotalPanel = new JPanel ( );
			TotalPanel.setLayout ( new BoxLayout ( this.TotalPanel, BoxLayout.PAGE_AXIS ) );
			//TotalPanel.setBackground ( new Color ( ( 255 ), ( 0 ), ( 0 ) ) );
			
			//TabHolder = new JTabbedPane();
			//TabHolder.setBackground ( new Color ( ( 255 ), ( 0 ), ( 0 ) ) );
			//TotalPanel.add( TabHolder );
			
			Tab_Panel_Settings_Dropshippers = new Panel_Settings_Dropshippers( Class_Controller );
			Tab_Panel_Settings_Dropshippers.Startup();
			//TabHolder.add( "Dropshippers", Tab_Panel_Settings_Dropshippers );
			TotalPanel.add( "Dropshippers", Tab_Panel_Settings_Dropshippers );
			
			Tab_Panel_Panel_Settings_ItemTypes = new Panel_Settings_ItemTypes( Class_Controller );
			Tab_Panel_Panel_Settings_ItemTypes.Startup();
			//TabHolder.add( "Item types", Tab_Panel_Panel_Settings_ItemTypes );
			TotalPanel.add( "Item types", Tab_Panel_Panel_Settings_ItemTypes );
			
			/*Tab_Panel_Settings_Offers = new Panel_Settings_Offers( Class_Controller );
			Tab_Panel_Settings_Offers.Startup();
			TabHolder.add( "Offers", Tab_Panel_Settings_Offers );*/
			
			Tab_Panel_Settings_SaveSettings = new Panel_Settings_SaveSettings( Class_Controller );
			Tab_Panel_Settings_SaveSettings.Startup();
			//TabHolder.add( "Data saving", Tab_Panel_Settings_SaveSettings );
			TotalPanel.add( "Data saving", Tab_Panel_Settings_SaveSettings );
			
			Tab_Panel_Panel_Settings_SearchSettings = new Panel_Settings_SearchSettings( Class_Controller );
			Tab_Panel_Panel_Settings_SearchSettings.Startup();
			//TabHolder.add( "Searching", Tab_Panel_Panel_Settings_SearchSettings );
			TotalPanel.add( "Searching", Tab_Panel_Panel_Settings_SearchSettings );
			
			this.add ( this.TotalPanel );
			
			this.setVisible(true);
		}

		public void AddItemypes() {
			Tab_Panel_Panel_Settings_ItemTypes.AddItemypes();
		}

		public void ActivateItemType(String label, boolean selected) {
			//System.out.println( this.getClass().toString()+" ActivateItemType "+label );
			Tab_Panel_Panel_Settings_ItemTypes.ActivateItemType( label, selected );
		}

		public void AddSearchTypes() {
			Tab_Panel_Panel_Settings_SearchSettings.AddSearchTypes();
		}
}
