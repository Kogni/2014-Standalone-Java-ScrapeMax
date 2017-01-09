package Searching;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToolBar;

import Control.Controller;

public class Panel_Settings_SearchSettings extends JPanel implements ActionListener, KeyListener {
	
	Controller Class_Controller;
	
	JPanel						TotalPanel;
		JPanel						ToolPanel;
		JLabel						Forklaring;
			JPanel						StaticPanel;
				JToolBar					MenuBar;
					JComboBox					Searchtypes;
					JLabel						SearchtypeSetting_Forklaring;
					JTextField					TargetStore;
					JButton						SetTarget;
	
	MouseListener mouseListener;

	public Panel_Settings_SearchSettings(Controller Class_Controller) {
		this.Class_Controller = Class_Controller;
	}

	public void Startup() {
		setSize ( 1000, 660 );

		//pane.setLayout ( new GridLayout ( 1, 1 ) );
		this.setLayout ( new BoxLayout ( this, BoxLayout.PAGE_AXIS ));
		GridBagConstraints c = new GridBagConstraints ( );
		
		TotalPanel = new JPanel ( );
		TotalPanel.setLayout ( new BoxLayout ( this.TotalPanel, BoxLayout.PAGE_AXIS ) );
		TotalPanel.setBackground ( new Color ( ( 210 ), ( 225 ), ( 240 ) ) );
		
		ToolPanel = new JPanel ( );
		ToolPanel.setLayout ( new BoxLayout ( this.ToolPanel, BoxLayout.LINE_AXIS ) );
		ToolPanel.setPreferredSize( new Dimension( 1000, 30 ) );
		ToolPanel.setMaximumSize( new Dimension( 1000, 50 ) );
		ToolPanel.setMinimumSize( new Dimension( 1000, 20 ) );
		TotalPanel.add ( this.ToolPanel );
		
		StaticPanel = new JPanel ( );
		StaticPanel.setLayout ( new BoxLayout ( this.StaticPanel, BoxLayout.PAGE_AXIS ) );
		StaticPanel.setPreferredSize( new Dimension( 1000, 30 ) );
		StaticPanel.setMaximumSize( new Dimension( 1000, 50 ) );
		StaticPanel.setMinimumSize( new Dimension( 1000, 20 ) );
		ToolPanel.add ( this.StaticPanel );
		
		Forklaring = new JLabel("Search type settings control how the program will browse the dropshippingsite in search for products.");
		Forklaring.setMinimumSize( new Dimension( 1000, 20 ) );
		Forklaring.setMaximumSize( new Dimension( 1000, 50 ) );
		StaticPanel.add( Forklaring );
		
		MenuBar = new JToolBar();
		MenuBar.add( new JLabel("Search type: ") );
		Searchtypes = new JComboBox();
		Searchtypes.setMinimumSize( new Dimension( 80, 50 ) );
		Searchtypes.setMaximumSize( new Dimension( 120, 50 ) );
		String[] Alltypes = this.Class_Controller.Get_Searchtypes();
		Searchtypes.addItem( "" );
		if ( Alltypes != null ) {
			for (int i = 0; i < Alltypes.length; i++ ) {
				if ( Alltypes[i] != null ) {
					Searchtypes.addItem( Alltypes[i] );
				}
			}
		}
		Searchtypes.addActionListener( this );
		MenuBar.add(Searchtypes);
		
		SearchtypeSetting_Forklaring = new JLabel("");
		SearchtypeSetting_Forklaring.setMinimumSize( new Dimension( 700, 20 ) );
		SearchtypeSetting_Forklaring.setMaximumSize( new Dimension( 850, 50 ) );
		MenuBar.add( SearchtypeSetting_Forklaring );
		
		StaticPanel.add(MenuBar);

		this.add ( this.TotalPanel, c );
		
		setVisible ( true );
	}
	
	@Override
	public void actionPerformed( ActionEvent arg0 ) {
		System.out.println( this.getClass().toString()+" actionPerformed "+Searchtypes.getSelectedItem().toString() );
		if ( arg0.getSource().toString().equals( Searchtypes.toString() ) ) {
			try {
				Class_Controller.Set_Setting_Searchtype( Searchtypes.getSelectedItem().toString() );
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if ( Searchtypes.getSelectedItem().toString().equals("Full crawl") ) {
			SearchtypeSetting_Forklaring.setText( "Scraper will accept any product deemed to fit your chosen item types, regardless of their location on the dropshipper site." );
		} else if ( Searchtypes.getSelectedItem().toString().equals("Category") ) {
			SearchtypeSetting_Forklaring.setText( "Scraper will only accept products which are located in a category that fits one of your chosen item types." );
		} else if ( Searchtypes.getSelectedItem().toString().equals("Store scan") ) {
			SearchtypeSetting_Forklaring.setText( "Scraper will only accept products which are located in the specified store" );
			
			MenuBar.add( new JLabel("Store ID: ") );
			TargetStore = new JTextField();
			TargetStore.setMinimumSize( new Dimension( 80, 20 ) );
			TargetStore.setMaximumSize( new Dimension( 120, 20 ) );
			TargetStore.addActionListener( this );
			TargetStore.addKeyListener(this);
			MenuBar.add( TargetStore );
			
		}
		
	}
	
	public void AddSearchTypes() {
		MenuBar.removeAll();
		MenuBar.add( new JLabel("Search type: ") );
		Searchtypes = new JComboBox();
		Searchtypes.setMinimumSize( new Dimension( 50, 50 ) );
		Searchtypes.setMaximumSize( new Dimension( 100, 50 ) );
		String[] Alltypes = this.Class_Controller.Get_Searchtypes();
		Searchtypes.addItem( "" );
		if ( Alltypes != null ) {
			for (int i = 0; i < Alltypes.length; i++ ) {
				if ( Alltypes[i] != null ) {
					Searchtypes.addItem( Alltypes[i] );
				}
			}
		}
		Searchtypes.addActionListener( this );
		MenuBar.add(Searchtypes);
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		//System.out.println( this.getClass().toString()+" keyPressed "+Searchtypes.getSelectedItem().toString() );
		//this.Class_Controller.Set_TargetSeller( TargetStore.getText() );
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		//System.out.println( this.getClass().toString()+" keyReleased "+Searchtypes.getSelectedItem().toString() );
		//this.Class_Controller.Set_TargetSeller( TargetStore.getText() );
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		/*System.out.println( this.getClass().toString()+" keyTyped "+Searchtypes.getSelectedItem().toString() );
		try {
			this.Class_Controller.Set_TargetSeller( TargetStore.getText() );
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}

}
