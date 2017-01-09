package Off;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToolBar;

import Control.Controller;
import Itemtypes.Object_Itemtype;

public class Panel_Settings_SaveSettings extends JPanel implements ActionListener {

	Controller Class_Controller;
	
	JPanel						TotalPanel_Save;
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
					

	
	MouseListener mouseListener;

	public Panel_Settings_SaveSettings( Controller Class_Controller ) {
		
		this.Class_Controller = Class_Controller;
		
	}

	public void Startup() {
		setSize ( 1000, 560 );

		//pane.setLayout ( new GridLayout ( 1, 1 ) );
		this.setLayout ( new BoxLayout ( this, BoxLayout.PAGE_AXIS ));
		GridBagConstraints c = new GridBagConstraints ( );
		
		TotalPanel_Save = new JPanel ( );
		TotalPanel_Save.setLayout ( new BoxLayout ( this.TotalPanel_Save, BoxLayout.PAGE_AXIS ) );
		TotalPanel_Save.setMinimumSize( new Dimension( 1000, 00 ) );
		TotalPanel_Save.setPreferredSize( new Dimension( 1000, 100 ) );
		TotalPanel_Save.setMaximumSize( new Dimension( 1000, 600 ) );
		TotalPanel_Save.setBackground ( new Color ( ( 210 ), ( 225 ), ( 240 ) ) );
		
		ToolPanel = new JPanel ( );
		ToolPanel.setLayout ( new BoxLayout ( this.ToolPanel, BoxLayout.PAGE_AXIS ) );
		ToolPanel.setMinimumSize( new Dimension( 1000, 00 ) );
		ToolPanel.setPreferredSize( new Dimension( 1000, 100 ) );
		ToolPanel.setMaximumSize( new Dimension( 1000, 600 ) );
		TotalPanel_Save.add ( this.ToolPanel );
		
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
		Combo_UserShop.addItem( "Larsenimport" );
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
		ToolPanel.add ( this.Panel_Collumn_SaveType );
		
		MenuBar_SaveType = new JToolBar();
		//MenuBar_SaveType.add( new JLabel("How do you want to save the datas?") );
		Combo_SaveTypes = new JComboBox();
		Combo_SaveTypes.setMinimumSize( new Dimension( 200, 20 ) );
		Combo_SaveTypes.setMaximumSize( new Dimension( 300, 40 ) );
		Combo_SaveTypes.addItem( "" );
		Combo_SaveTypes.addItem( "CSV-file" );
		Combo_SaveTypes.addItem( "Local folders" );
		Combo_SaveTypes.addActionListener( this );
		//MenuBar_SaveType.add(Combo_SaveTypes);
		
		Forklaring_SaveTypes = new JLabel("");
		Forklaring_SaveTypes.setMinimumSize( new Dimension( 700, 20 ) );
		Forklaring_SaveTypes.setMaximumSize( new Dimension( 900, 40 ) );
		//MenuBar_SaveType.add( Forklaring_SaveTypes );
		
		//Panel_Collumn_SaveType.add(MenuBar_SaveType);
		
		//price
		Panel_Collumn_Price = new JPanel ( );
		Panel_Collumn_Price.setLayout ( new BoxLayout ( this.Panel_Collumn_Price, BoxLayout.PAGE_AXIS ) );
		Panel_Collumn_Price.setMinimumSize( new Dimension( 1000, 00 ) );
		Panel_Collumn_Price.setPreferredSize( new Dimension( 1000, 20 ) );
		Panel_Collumn_Price.setMaximumSize( new Dimension( 1000, 40 ) );
		//ToolPanel.add ( this.Panel_Collumn_Price );
		
		Menubar_Price = new JToolBar();
		//Menubar_Price.add( new JLabel("Auto pricing: ") );
		Combo_Price = new JComboBox();
		Combo_Price.setMinimumSize( new Dimension( 200, 20 ) );
		Combo_Price.setMaximumSize( new Dimension( 300, 40 ) );
		Combo_Price.addItem( "Original price and currency" );
		Combo_Price.addItem( "Original price, NOK currency" );
		Combo_Price.addItem( "2x original price, NOK currency" );
		Combo_Price.addItem( "3x original price, NOK currency" );
		Combo_Price.addActionListener( this );
		//Menubar_Price.add(Combo_Price);
		
		Forklaring_Price = new JLabel("");
		Forklaring_Price.setMinimumSize( new Dimension( 700, 20 ) );
		Forklaring_Price.setMaximumSize( new Dimension( 900, 40 ) );
		//Menubar_Price.add( Forklaring_Price );
		
		//Panel_Collumn_Price.add(Menubar_Price);
		
		//


		this.add ( this.TotalPanel_Save, c );
		
		setVisible ( true );

	}

	@Override
	public void actionPerformed( ActionEvent arg0 ) {
		
		//savetypes
		if ( arg0.getSource().toString().equals( Combo_SaveTypes.toString() ) ) {
			try {
				Class_Controller.Set_Setting_SaveType( Combo_SaveTypes.getSelectedItem().toString() );
			} catch (Exception e) {
			}
			
			ToolPanel.add ( this.Panel_Collumn_Price );
			Menubar_Price.add( new JLabel("Auto pricing: ") );
			Menubar_Price.add(Combo_Price);
			Menubar_Price.add( Forklaring_Price );
			Panel_Collumn_Price.add(Menubar_Price);
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
		//user settings
		if ( arg0.getSource().toString().equals( Combo_UserShop.toString() ) ) {
			try {
				Class_Controller.Get_Settings_UserShop( Combo_UserShop.getSelectedItem().toString() );
			} catch (Exception e) {
			}
			
			ToolPanel.add ( this.Panel_Collumn_SaveType );
			MenuBar_SaveType.add( new JLabel("How do you want to save the datas?") );
			MenuBar_SaveType.add(Combo_SaveTypes);
			MenuBar_SaveType.add( Forklaring_SaveTypes );
			Panel_Collumn_SaveType.add(MenuBar_SaveType);
		}
		if ( Combo_UserShop.getSelectedItem().toString().equals("USBland") ) {
			Forklaring_UserShop.setText( "No special " );
		} else if ( Combo_UserShop.getSelectedItem().toString().equals("Libida") ) {
			Forklaring_UserShop.setText( "Products are auto-categorized to fit Libidas shop categories." );
		} else if ( Combo_UserShop.getSelectedItem().toString().equals("Larsenimport") ) {
			Forklaring_UserShop.setText( "Products are auto-categorized to fit a general store." );
		}
		
	}

}
