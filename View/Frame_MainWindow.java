package View;

import java.awt.Container;
import java.awt.GridBagConstraints;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import Control.Controller;
import Interfaces.Interface_MainWindow;
import Searching.Object_SearchJob;
import URLs.Object_URL;
import URLs.Panel_Sitemap;
import URLs.Panel_URLs;

public class Frame_MainWindow extends JFrame implements Interface_MainWindow {
	
	Controller Class_Controller;

	JPanel						TotalPanel;
	JTabbedPane		TabHolder;
		Panel_Overview			Tab_Panel_Startup;
		//Panel_Settings		Tab_Panel_Settings;
		Pane_AllSettings		Tab_Pane_AllSettings;
		Panel_URLs				Tab_Panel_URLs;
		Panel_Sitemap			Tab_Panel_Sitemap;
		
		public Frame_MainWindow( Controller Class_Controller ) {
			this.Class_Controller = Class_Controller;
		}
		
		public void MainWindow_Startup() throws Exception {
			//System.out.println( this.getClass().toString()+" Startup" );
			
			setTitle("Scrape and Upload" );  
			setSize ( 1000, 600 );
			//setBackground ( new Color ( ( 255 ), ( 0 ), ( 0 ) ) );
			
			Container pane = getContentPane ( );
			pane.setLayout ( new BoxLayout ( pane, BoxLayout.PAGE_AXIS ));
			GridBagConstraints c = new GridBagConstraints ( );
			
			TotalPanel = new JPanel ( );
			TotalPanel.setLayout ( new BoxLayout ( this.TotalPanel, BoxLayout.PAGE_AXIS ) );
			//TotalPanel.setBackground ( new Color ( ( 255 ), ( 0 ), ( 0 ) ) );
			
			TabHolder = new JTabbedPane();
			//TabHolder.setBackground ( new Color ( ( 255 ), ( 0 ), ( 0 ) ) );
			TotalPanel.add( TabHolder );
			
			Tab_Panel_Startup = new Panel_Overview( Class_Controller );
			Tab_Panel_Startup.Startup();
			TabHolder.add( "Overview", Tab_Panel_Startup );
			
			/*Tab_Panel_Settings = new Panel_Settings( Class_Controller );
			Tab_Panel_Settings.Startup();
			TabHolder.add( "Settings", Tab_Panel_Settings );*/
			
			Tab_Pane_AllSettings = new Pane_AllSettings( Class_Controller );
			Tab_Pane_AllSettings.Startup();
			TabHolder.add( "Settings", Tab_Pane_AllSettings );
			
			Tab_Panel_URLs = new Panel_URLs( Class_Controller );
			Tab_Panel_URLs.Startup();
			TabHolder.add( "URLs", Tab_Panel_URLs );
			
			Tab_Panel_Sitemap = new Panel_Sitemap( Class_Controller );
			Tab_Panel_Sitemap.Startup();
			TabHolder.add( "Sitemap", Tab_Panel_Sitemap );
			
			pane.add ( this.TotalPanel, c );
			
			this.setVisible(true);
		}

		public void UpdateURLGUI(Object_SearchJob hentetSide) throws Exception {
			Tab_Panel_URLs.AddUrl( hentetSide );
		}

		public void Set_URLsFound( int i ) throws Exception {
			Tab_Panel_URLs.CleanTable();
			Tab_Panel_URLs.URLCount = i;
		}

		public void AddProgressMessage(String string) throws Exception {
			if ( Tab_Panel_Startup != null ) {
				this.Tab_Panel_Startup.AddProgressMessage( string );
			}
		}

		public void AddItemypes() {
			//Tab_Panel_Settings.AddItemypes();
			Tab_Pane_AllSettings.AddItemypes();
		}

		public void SetCurrentAction( String actionText ) {
			if ( Tab_Panel_Startup != null ) {
				Tab_Panel_Startup.SetCurrentAction( actionText );
			}
		}

		public void MainWindow_ActivateItemType(String label, boolean selected) {
			//System.out.println( this.getClass().toString()+" ActivateItemType "+label );
			/*if ( Tab_Panel_Settings != null ) {
				Tab_Panel_Settings.ActivateItemType( label, selected);
			}*/
			if ( Tab_Pane_AllSettings != null ) {
				Tab_Pane_AllSettings.ActivateItemType( label, selected);
			}
		}

		public int Get_TotalURLS() {
			if ( Tab_Panel_URLs != null ) {
				return Tab_Panel_URLs.URLCount;
			}
			return 0;
		}

		public boolean Panel_URL_Exists() {
			return Tab_Panel_URLs != null;
		}

		public void AddSearchTypes() {
			//Tab_Panel_Settings.AddSearchTypes();
			//System.out.println( this.getClass().toString()+" AddSearchTypes A Tab_Pane_AllSettings="+Tab_Pane_AllSettings );
			Tab_Pane_AllSettings.AddSearchTypes();
			//System.out.println( this.getClass().toString()+" AddSearchTypes B" );
		}

		public void Add_Page_Locate(Object_URL nyURL, int i) throws Exception {
			//Tab_Panel_Sitemap.Add_Pages( nyURL.Get_Adresse().toString(), 0 );
			this.Tab_Panel_Sitemap.Add_Page_Locate( nyURL );
		}

}
