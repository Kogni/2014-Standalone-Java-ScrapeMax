package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToolBar;

import Control.Controller;
import Dropshippers.Object_Dropshipper;
import Itemtypes.Panel_Itemtype_Checkboxes;

public class Pane_AllSettings extends JPanel implements ActionListener, KeyListener {
	
	Controller Class_Controller;
	
	JPanel						TotalPanel;
	JPanel						ToolPanel;
	
		JPanel						Panel_Collumn_UserShop;
			JToolBar					Menubar_UserShop;
				JComboBox					Combo_UserShop;
				JLabel						Forklaring_UserShop;	
				
		JPanel						Panel_Collumn_SaveType;
			JToolBar					MenuBar_SaveType;
				JComboBox					Combo_SaveTypes;
				JLabel						Forklaring_SaveTypes;
				
		JPanel						Panel_Collumn_Price;
			JToolBar					Menubar_Price;
				JComboBox					Combo_Price;
				JLabel						Forklaring_Price;	
				
		JPanel						Panel_Collumn_Dropshipper;
			JToolBar					Menubar_Dropshipper;
				JComboBox					Combo_Dropshipper;
				JLabel						Forklaring_Dropshipper;	
		
		JPanel						Panel_Collumn_Search;
			JToolBar					Menubar_Search;
				JComboBox					Combo_Search;
				JLabel						Forklaring_Search;
				//JTextField					TargetStore;
				JButton						SetTarget;

		JPanel						Panel_Collumn_Itemtype;
			Panel_Itemtype_Checkboxes	ItemTypeCheckBoxes;
		
	public Pane_AllSettings( Controller Class_Controller ) {
		
		this.Class_Controller = Class_Controller;
		
	}

	public void Startup() throws Exception {
		setSize ( 1000, 560 );

		//pane.setLayout ( new GridLayout ( 1, 1 ) );
		this.setLayout ( new BoxLayout ( this, BoxLayout.PAGE_AXIS ));
		GridBagConstraints c = new GridBagConstraints ( );
		
		TotalPanel = new JPanel ( );
		TotalPanel.setLayout ( new BoxLayout ( this.TotalPanel, BoxLayout.PAGE_AXIS ) );
		TotalPanel.setMinimumSize( new Dimension( 1000, 00 ) );
		TotalPanel.setPreferredSize( new Dimension( 1000, 100 ) );
		TotalPanel.setMaximumSize( new Dimension( 1000, 600 ) );
		TotalPanel.setBackground ( new Color ( ( 210 ), ( 225 ), ( 240 ) ) );
		
		ToolPanel = new JPanel ( );
		ToolPanel.setLayout ( new BoxLayout ( this.ToolPanel, BoxLayout.PAGE_AXIS ) );
		ToolPanel.setMinimumSize( new Dimension( 1000, 00 ) );
		ToolPanel.setPreferredSize( new Dimension( 1000, 100 ) );
		ToolPanel.setMaximumSize( new Dimension( 1000, 600 ) );
		TotalPanel.add ( this.ToolPanel );
		
		//usershop
		Panel_Collumn_UserShop = new JPanel ( );
		Panel_Collumn_UserShop.setLayout ( new BoxLayout ( this.Panel_Collumn_UserShop, BoxLayout.PAGE_AXIS ) );
		Panel_Collumn_UserShop.setMinimumSize( new Dimension( 1000, 00 ) );
		Panel_Collumn_UserShop.setPreferredSize( new Dimension( 1000, 20 ) );
		Panel_Collumn_UserShop.setMaximumSize( new Dimension( 1000, 40 ) );
		ToolPanel.add ( this.Panel_Collumn_UserShop );
		
		Menubar_UserShop = new JToolBar();
		Menubar_UserShop.add( new JLabel("Which store are you gathering for?") );
		Combo_UserShop = new JComboBox();
		Combo_UserShop.setMinimumSize( new Dimension( 200, 20 ) );
		Combo_UserShop.setMaximumSize( new Dimension( 300, 40 ) );
		Combo_UserShop.addItem( "USBland" );
		Combo_UserShop.addItem( "Libida" );
		if ( Class_Controller.Get_UserPassword().equals("pynting")) {
			Combo_UserShop.addItem( "Larsenimport" );
		}
		Combo_UserShop.addItem( "Pinkie" );
		Combo_UserShop.addItem( "Other" );
		Combo_UserShop.addActionListener( this );
		Menubar_UserShop.add(Combo_UserShop);
		
		Forklaring_UserShop = new JLabel("");
		Forklaring_UserShop.setMinimumSize( new Dimension( 700, 20 ) );
		Forklaring_UserShop.setMaximumSize( new Dimension( 900, 40 ) );
		Menubar_UserShop.add( Forklaring_UserShop );
		
		Panel_Collumn_UserShop.add(Menubar_UserShop);
		
		//save type
		Panel_Collumn_SaveType = new JPanel ( );
		Panel_Collumn_SaveType.setLayout ( new BoxLayout ( this.Panel_Collumn_SaveType, BoxLayout.PAGE_AXIS ) );
		Panel_Collumn_SaveType.setMinimumSize( new Dimension( 1000, 00 ) );
		Panel_Collumn_SaveType.setPreferredSize( new Dimension( 1000, 20 ) );
		Panel_Collumn_SaveType.setMaximumSize( new Dimension( 1000, 40 ) );
		
		MenuBar_SaveType = new JToolBar();
		Combo_SaveTypes = new JComboBox();
		Combo_SaveTypes.setMinimumSize( new Dimension( 200, 20 ) );
		Combo_SaveTypes.setMaximumSize( new Dimension( 300, 40 ) );
		Combo_SaveTypes.addItem( "" );
		Combo_SaveTypes.addItem( "CSV-file" );
		Combo_SaveTypes.addItem( "Local folders" );
		Combo_SaveTypes.addActionListener( this );
		
		Forklaring_SaveTypes = new JLabel("");
		Forklaring_SaveTypes.setMinimumSize( new Dimension( 700, 20 ) );
		Forklaring_SaveTypes.setMaximumSize( new Dimension( 900, 40 ) );
		
		//price
		Panel_Collumn_Price = new JPanel ( );
		Panel_Collumn_Price.setLayout ( new BoxLayout ( this.Panel_Collumn_Price, BoxLayout.PAGE_AXIS ) );
		Panel_Collumn_Price.setMinimumSize( new Dimension( 1000, 00 ) );
		Panel_Collumn_Price.setPreferredSize( new Dimension( 1000, 20 ) );
		Panel_Collumn_Price.setMaximumSize( new Dimension( 1000, 40 ) );
		
		Menubar_Price = new JToolBar();
		Combo_Price = new JComboBox();
		Combo_Price.setMinimumSize( new Dimension( 200, 20 ) );
		Combo_Price.setMaximumSize( new Dimension( 300, 40 ) );
		Combo_Price.addItem( "" );
		Combo_Price.addItem( "Original price and currency" );
		Combo_Price.addItem( "Original price, NOK currency" );
		Combo_Price.addItem( "2x original price, NOK currency" );
		Combo_Price.addItem( "2.5x original price, NOK currency" );
		Combo_Price.addItem( "3x original price, NOK currency" );
		Combo_Price.addActionListener( this );
		
		Forklaring_Price = new JLabel("");
		Forklaring_Price.setMinimumSize( new Dimension( 700, 20 ) );
		Forklaring_Price.setMaximumSize( new Dimension( 900, 40 ) );
		
		//dropshipper
		Panel_Collumn_Dropshipper = new JPanel ( );
		Panel_Collumn_Dropshipper.setLayout ( new BoxLayout ( this.Panel_Collumn_Dropshipper, BoxLayout.PAGE_AXIS ) );
		Panel_Collumn_Dropshipper.setMinimumSize( new Dimension( 1000, 00 ) );
		Panel_Collumn_Dropshipper.setPreferredSize( new Dimension( 1000, 20 ) );
		Panel_Collumn_Dropshipper.setMaximumSize( new Dimension( 1000, 40 ) );
		
		Menubar_Dropshipper = new JToolBar();
		Combo_Dropshipper = new JComboBox();
		Combo_Dropshipper.setMinimumSize( new Dimension( 200, 20 ) );
		Combo_Dropshipper.setMaximumSize( new Dimension( 300, 40 ) );
		Object_Dropshipper[] Alltypes = this.Class_Controller.Get_Dropshippers();
		Combo_Dropshipper.addItem( "" );
		if ( Alltypes != null ) {
			for (int i = 0; i < Alltypes.length; i++ ) {
				if ( Alltypes[i] != null ) {
					//System.out.println( this.getClass().toString()+" Startup Skal adde dropshipper: "+Alltypes[i].DropshipperName );
					if ( Alltypes[i].DropshipperName.equals("Tmart")) {
						if ( Class_Controller.Get_UserPassword().equals("pynting")) {
							Combo_Dropshipper.addItem( Alltypes[i].DropshipperName );
						} else {
							System.out.println( this.getClass().toString()+" Startup ikke pynting: "+ Class_Controller.Get_UserPassword() );
						}
					} else {
						Combo_Dropshipper.addItem( Alltypes[i].DropshipperName );
					}
				}
			}
		}
		Combo_Dropshipper.addActionListener( this );

		Forklaring_Dropshipper = new JLabel("");
		Forklaring_Dropshipper.setMinimumSize( new Dimension( 700, 20 ) );
		Forklaring_Dropshipper.setMaximumSize( new Dimension( 900, 40 ) );
		
		//searching
		Panel_Collumn_Search = new JPanel ( );
		Panel_Collumn_Search.setLayout ( new BoxLayout ( this.Panel_Collumn_Search, BoxLayout.PAGE_AXIS ) );
		Panel_Collumn_Search.setMinimumSize( new Dimension( 1000, 00 ) );
		Panel_Collumn_Search.setPreferredSize( new Dimension( 1000, 20 ) );
		Panel_Collumn_Search.setMaximumSize( new Dimension( 1000, 40 ) );
		
		Menubar_Search = new JToolBar();
		Combo_Search = new JComboBox();
		Combo_Search.setMinimumSize( new Dimension( 200, 20 ) );
		Combo_Search.setMaximumSize( new Dimension( 300, 40 ) );
		String[] AllSearches = this.Class_Controller.Get_Searchtypes();
		Combo_Search.addItem( "" );
		if ( AllSearches != null ) {
			for (int i = 0; i < AllSearches.length; i++ ) {
				if ( AllSearches[i] != null ) {
					Combo_Search.addItem( Alltypes[i] );
				}
			}
		}
		Combo_Search.addActionListener( this );

		Forklaring_Search = new JLabel("");
		Forklaring_Search.setMinimumSize( new Dimension( 700, 20 ) );
		Forklaring_Search.setMaximumSize( new Dimension( 900, 40 ) );
		
		//item types
		Panel_Collumn_Itemtype = new JPanel ( );
		Panel_Collumn_Itemtype.setLayout ( new BoxLayout ( this.Panel_Collumn_Itemtype, BoxLayout.PAGE_AXIS ) );
		Panel_Collumn_Itemtype.setMinimumSize( new Dimension( 1000, 0 ) );
		Panel_Collumn_Itemtype.setPreferredSize( new Dimension( 1000, 200 ) );
		Panel_Collumn_Itemtype.setMaximumSize( new Dimension( 1000, 400 ) );
		
		ItemTypeCheckBoxes = new Panel_Itemtype_Checkboxes( Class_Controller );
		ItemTypeCheckBoxes.setLayout ( new BoxLayout ( this.ItemTypeCheckBoxes, BoxLayout.PAGE_AXIS ) );
		ItemTypeCheckBoxes.setPreferredSize( new Dimension( 250, 200 ) );
		ItemTypeCheckBoxes.setMaximumSize( new Dimension( 300, 400 ) );
		ItemTypeCheckBoxes.setMinimumSize( new Dimension( 200, 100 ) );
		ItemTypeCheckBoxes.Startup();
		
		
		this.add ( this.TotalPanel, c );
		
		setVisible ( true );
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		//user settings
		if ( arg0.getSource().toString().equals( Combo_UserShop.toString() ) ) {
			try {
				Class_Controller.Set_Setting_UserShop( Combo_UserShop.getSelectedItem().toString() );
			} catch (Exception e) {
			}
			
			if ( Panel_Collumn_SaveType.getParent() != ToolPanel ) {
				ToolPanel.add ( this.Panel_Collumn_SaveType );
				MenuBar_SaveType.removeAll();
				MenuBar_SaveType.add( new JLabel("How do you want to save the datas?") );
				MenuBar_SaveType.add( Combo_SaveTypes);
				MenuBar_SaveType.add( Forklaring_SaveTypes );
				Panel_Collumn_SaveType.add(MenuBar_SaveType);
			}
		}
		if ( Combo_UserShop.getSelectedItem().toString().equals("USBland") ) {
			Forklaring_UserShop.setText( "Clean item descriptions. No information on the products' categories." );
		} else if ( Combo_UserShop.getSelectedItem().toString().equals("Libida") ) {
			Forklaring_UserShop.setText( "Clean item descriptions. Products are auto-categorized to fit Libidas shop categories." );
		} else if ( Combo_UserShop.getSelectedItem().toString().equals("Larsenimport") ) {
			Forklaring_UserShop.setText( "Original item descriptions+extra web page information. Products are auto-categorized for a general store." );
		} else if ( Combo_UserShop.getSelectedItem().toString().equals("Pinkie") ) {
			Forklaring_UserShop.setText( "Original item descriptions+extra web page information. All products are put in the 'importert'-category" );
		} else {
			Forklaring_UserShop.setText( "Clean item descriptions. Original product categories." );
		}
		
		//savetypes
		if ( arg0.getSource().toString().equals( Combo_SaveTypes.toString() ) ) {
			try {
				Class_Controller.Set_Setting_SaveType( Combo_SaveTypes.getSelectedItem().toString() );
			} catch (Exception e) {
			}
			
			if ( Panel_Collumn_Price.getParent() != ToolPanel ) {
				ToolPanel.add ( this.Panel_Collumn_Price );
				Menubar_Price.removeAll();
				Menubar_Price.add( new JLabel("Auto pricing: ") );
				Menubar_Price.add(Combo_Price);
				Menubar_Price.add( Forklaring_Price );
				Panel_Collumn_Price.add(Menubar_Price);
			}
		}
		if ( Combo_SaveTypes.getSelectedItem().toString().equals("CSV-file") ) {
			Forklaring_SaveTypes.setText( "Best suited for automatic importing. Products are saved to a CSV-file." );
		} else if ( Combo_SaveTypes.getSelectedItem().toString().equals("Local folders") ) {
			Forklaring_SaveTypes.setText( "Best suited for manual importing. The scraper will create a folder for the selected item category, and save each product in its own subfolder within." );
		}
		
		//pricing
		if ( arg0.getSource().toString().equals( Combo_Price.toString() ) ) {
			try {
				Class_Controller.Set_Setting_AutoPricing( Combo_Price.getSelectedItem().toString() );
			} catch (Exception e) {
			}
			
			if ( Panel_Collumn_Dropshipper.getParent() != ToolPanel ) {
				ToolPanel.add ( this.Panel_Collumn_Dropshipper );
				Menubar_Dropshipper.removeAll();
				Menubar_Dropshipper.add( new JLabel("Which dropshipper do you wish to search? ") );
				Menubar_Dropshipper.add( Combo_Dropshipper);
				Menubar_Dropshipper.add( Forklaring_Dropshipper );
				Panel_Collumn_Dropshipper.add( Menubar_Dropshipper);
			}
		}
		if ( Combo_Price.getSelectedItem().toString().equals("Original price and currency") ) {
			Forklaring_Price.setText( "Products are saved with the original, unmodified USD price" );
		} else if ( Combo_Price.getSelectedItem().toString().equals("Original price, NOK currency") ) {
			Forklaring_Price.setText( "Products are saved with the original price, but calculated to todays NOK currency" );
		} else if ( Combo_Price.getSelectedItem().toString().equals("2x original price, NOK currency") ) {
			Forklaring_Price.setText( "Product prices are calculated to todays NOK currency and then doubled" );
		} else if ( Combo_Price.getSelectedItem().toString().equals("3x original price, NOK currency") ) {
			Forklaring_Price.setText( "Product prices are calculated to todays NOK currency and then tripled" );
		}
		
		//dropshipper
		if ( arg0.getSource().toString().equals( Combo_Dropshipper.toString() ) ) {
			try {
				Class_Controller.Set_Dropshipper( Combo_Dropshipper.getSelectedItem().toString() );
			} catch (Exception e) {
			}
			if ( Panel_Collumn_Search.getParent() != ToolPanel ) {
				ToolPanel.add ( this.Panel_Collumn_Search );
				Menubar_Search.removeAll();
				Menubar_Search.add( new JLabel("How do you want the scraper to search? ") );
				Menubar_Search.add( Combo_Search );
				Menubar_Search.add( Forklaring_Search );
				Panel_Collumn_Search.add( Menubar_Search);
			} else {
				Menubar_Search.removeAll();
				Menubar_Search.add( new JLabel("How do you want the scraper to search? ") );
				Menubar_Search.add( Combo_Search );
				Menubar_Search.add( Forklaring_Search );
			}
			
		}
		
		//Search
		if ( arg0.getSource().toString().equals( Combo_Search.toString() ) ) {
			try {
				Class_Controller.Set_Setting_Searchtype( Combo_Search.getSelectedItem().toString() );
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			AddItemypes();
			if ( Panel_Collumn_Itemtype.getParent() != ToolPanel ) {
				Panel_Collumn_Itemtype.add( ItemTypeCheckBoxes );
				ToolPanel.add(Panel_Collumn_Itemtype);
			}
			try {
				Class_Controller.LoadItemTypeSettings();
			} catch (Exception e) {
			}
			
		}
		if ( Combo_Search.getSelectedItem().toString().equals("Full crawl") ) {
			Forklaring_Search.setText( "Scraper searches for only your chosen item types, but saves ALL products it comes across." );
		} else if ( Combo_Search.getSelectedItem().toString().equals("Category") ) {
			Forklaring_Search.setText( "Scraper will only save products which are located in a category that fits one of your chosen item types." );
		} else if ( Combo_Search.getSelectedItem().toString().equals("Store scan") ) {
			Forklaring_Search.setText( "Scraper will only save products which are located in the specified stores from your Wholesalers.txt file" );
			
			/*Menubar_Search.add( new JLabel("Store ID: ") );
			TargetStore = new JTextField();
			TargetStore.setMinimumSize( new Dimension( 80, 20 ) );
			TargetStore.setMaximumSize( new Dimension( 120, 20 ) );
			TargetStore.addActionListener( this );
			TargetStore.addKeyListener(this);
			Menubar_Search.add( TargetStore );*/
			
		}
		
	}

	public void AddItemypes() { //skal IKKE adde panel, men skal fylle innholdet i panelet
		//System.out.println( this.getClass().toString()+" AddItemypes" );
		boolean Add = false;
		if ( Panel_Collumn_Itemtype.getParent() == ToolPanel ) {
			Add = true;
			Panel_Collumn_Itemtype.remove( ItemTypeCheckBoxes );
			ToolPanel.remove(Panel_Collumn_Itemtype);
		}

			//System.out.println( this.getClass().toString()+" AddItemypes A" );
			ItemTypeCheckBoxes = new Panel_Itemtype_Checkboxes( Class_Controller );
			ItemTypeCheckBoxes.setLayout ( new BoxLayout ( this.ItemTypeCheckBoxes, BoxLayout.PAGE_AXIS ) );
			ItemTypeCheckBoxes.setPreferredSize( new Dimension( 250, 200 ) );
			ItemTypeCheckBoxes.setMaximumSize( new Dimension( 300, 400 ) );
			ItemTypeCheckBoxes.setMinimumSize( new Dimension( 200, 100 ) );
			ItemTypeCheckBoxes.Startup();
			if ( Add == true ) {
				Panel_Collumn_Itemtype.add( ItemTypeCheckBoxes );
				ToolPanel.add(Panel_Collumn_Itemtype);
			}
	}

	public void AddSearchTypes() {
		//System.out.println( this.getClass().toString()+" AddSearchTypes A" );
		Menubar_Search.removeAll();
		Menubar_Search.add( new JLabel("Search type: ") );
		Combo_Search = new JComboBox();
		Combo_Search.setMinimumSize( new Dimension( 50, 50 ) );
		Combo_Search.setMaximumSize( new Dimension( 100, 50 ) );
		//System.out.println( this.getClass().toString()+" AddSearchTypes B" );
		String[] Alltypes = this.Class_Controller.Get_Searchtypes();
		//System.out.println( this.getClass().toString()+" AddSearchTypes C" );
		Combo_Search.addItem( "" );
		if ( Alltypes != null ) {
			for (int i = 0; i < Alltypes.length; i++ ) {
				if ( Alltypes[i] != null ) {
					Combo_Search.addItem( Alltypes[i] );
				}
			}
		}
		Combo_Search.addActionListener( this );
		Menubar_Search.add(Combo_Search);
	}

	public void ActivateItemType(String label, boolean selected) {
		ItemTypeCheckBoxes.ActivateItemType(label, selected);
	}
	
	@Override
	public void keyTyped(KeyEvent arg0) {
		//System.out.println( this.getClass().toString()+" keyTyped "+Combo_Search.getSelectedItem().toString() );
		/*try {
			this.Class_Controller.Set_TargetSeller( TargetStore.getText() );
		} catch (Exception e) {
		}*/
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
