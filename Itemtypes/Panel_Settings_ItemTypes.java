package Itemtypes;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.JTree;

import Control.Controller;

public class Panel_Settings_ItemTypes extends JPanel implements ActionListener {
	
	Controller Class_Controller;
	
	JPanel						TotalPanel;
		JPanel						ToolPanel;
			JPanel						StaticPanel;
				JToolBar					MenuBar;
					//JComboBox					Itemtypes;
					JLabel						Forklaring;
				//Panel_ItemTypeTree					ItemTypeTreePanel;
				Panel_Itemtype_Checkboxes			ItemTypeCheckBoxes;
	
	MouseListener mouseListener;
	boolean	Pause = true;

	public Panel_Settings_ItemTypes( Controller Class_Controller ) {
		this.Class_Controller = Class_Controller;
	}

	public void Startup() {
		setSize ( 1000, 560 );

		//pane.setLayout ( new GridLayout ( 1, 1 ) );
		this.setLayout ( new BoxLayout ( this, BoxLayout.PAGE_AXIS ));
		GridBagConstraints c = new GridBagConstraints ( );
		
		TotalPanel = new JPanel ( );
		TotalPanel.setLayout ( new BoxLayout ( this.TotalPanel, BoxLayout.PAGE_AXIS ) );
		TotalPanel.setBackground ( new Color ( ( 210 ), ( 225 ), ( 240 ) ) );
		
		ToolPanel = new JPanel ( );
		ToolPanel.setLayout ( new BoxLayout ( this.ToolPanel, BoxLayout.LINE_AXIS ) );
		ToolPanel.setPreferredSize( new Dimension( 1000, 240 ) );
		ToolPanel.setMaximumSize( new Dimension( 1000, 600 ) );
		ToolPanel.setMinimumSize( new Dimension( 1000, 90 ) );
		TotalPanel.add ( this.ToolPanel );
		
		//gamle item types
		
		StaticPanel = new JPanel ( );
		StaticPanel.setLayout ( new BoxLayout ( this.StaticPanel, BoxLayout.PAGE_AXIS ) );
		StaticPanel.setPreferredSize( ToolPanel.getPreferredSize() );
		StaticPanel.setMaximumSize( ToolPanel.getMaximumSize() );
		StaticPanel.setMinimumSize( ToolPanel.getMinimumSize() );
		ToolPanel.add ( this.StaticPanel );
		
		MenuBar = new JToolBar();
		MenuBar.add( new JLabel("Item type: ") );
		/*Itemtypes = new JComboBox();
		Itemtypes.setMinimumSize( new Dimension( 200, 20 ) );
		Itemtypes.setMaximumSize( new Dimension( 300, 50 ) );
		Itemtypes.addItem( "" );
		Itemtypes.addActionListener( this );
		MenuBar.add(Itemtypes);*/
		
		Forklaring = new JLabel("Scraper will save only items that fit this phrase");
		Forklaring.setMinimumSize( new Dimension( 700, 20 ) );
		Forklaring.setMaximumSize( new Dimension( 800, 50 ) );
		MenuBar.add( Forklaring );
		
		StaticPanel.add(MenuBar);
		
		//Nye item types
		
		/*ItemTypeTreePanel = new Panel_ItemTypeTree( Class_Controller );
		ItemTypeTreePanel.setLayout ( new BoxLayout ( this.ItemTypeTreePanel, BoxLayout.PAGE_AXIS ) );
		ItemTypeTreePanel.setPreferredSize( new Dimension( 250, 200 ) );
		ItemTypeTreePanel.setMaximumSize( new Dimension( 300, 400 ) );
		ItemTypeTreePanel.setMinimumSize( new Dimension( 200, 100 ) );
		ItemTypeTreePanel.Startup();
		StaticPanel.add( ItemTypeTreePanel );*/
		
		ItemTypeCheckBoxes = new Panel_Itemtype_Checkboxes( Class_Controller );
		ItemTypeCheckBoxes.setLayout ( new BoxLayout ( this.ItemTypeCheckBoxes, BoxLayout.PAGE_AXIS ) );
		ItemTypeCheckBoxes.setPreferredSize( new Dimension( 250, 200 ) );
		ItemTypeCheckBoxes.setMaximumSize( new Dimension( 300, 400 ) );
		ItemTypeCheckBoxes.setMinimumSize( new Dimension( 200, 100 ) );
		ItemTypeCheckBoxes.Startup();
		StaticPanel.add( ItemTypeCheckBoxes );

		this.add ( this.TotalPanel, c );
		
		setVisible ( true );
	}
	
	public void AddItemypes() {
		Pause = true;
		//ItemTypeTreePanel = new Panel_ItemTypeTree ( Class_Controller );
		/*StaticPanel.remove(ItemTypeTreePanel);
		ItemTypeTreePanel = new Panel_ItemTypeTree( Class_Controller );
		ItemTypeTreePanel.setLayout ( new BoxLayout ( this.ItemTypeTreePanel, BoxLayout.PAGE_AXIS ) );
		ItemTypeTreePanel.setPreferredSize( new Dimension( 250, 200 ) );
		ItemTypeTreePanel.setMaximumSize( new Dimension( 300, 400 ) );
		ItemTypeTreePanel.setMinimumSize( new Dimension( 200, 100 ) );
		ItemTypeTreePanel.Startup();
		StaticPanel.add( ItemTypeTreePanel );*/
		StaticPanel.remove(ItemTypeCheckBoxes);
		ItemTypeCheckBoxes = new Panel_Itemtype_Checkboxes( Class_Controller );
		ItemTypeCheckBoxes.setLayout ( new BoxLayout ( this.ItemTypeCheckBoxes, BoxLayout.PAGE_AXIS ) );
		ItemTypeCheckBoxes.setPreferredSize( new Dimension( 250, 200 ) );
		ItemTypeCheckBoxes.setMaximumSize( new Dimension( 300, 400 ) );
		ItemTypeCheckBoxes.setMinimumSize( new Dimension( 200, 100 ) );
		ItemTypeCheckBoxes.Startup();
		StaticPanel.add( ItemTypeCheckBoxes );
		
		//ItemTypeTreePanel.Startup();
		
		/*Itemtypes.removeAllItems();
		String[] Alltypes = this.Class_Controller.Get_Itemtypes();
		
		Itemtypes.addItem( "" );
		if ( Alltypes != null ) {
			for (int i = 0; i < Alltypes.length; i++ ) {
				if ( Alltypes[i] != null ) {
					Itemtypes.addItem( Alltypes[i] );
				}
			}
		}*/
		Pause = false;
	}
	
	@Override
	public void actionPerformed( ActionEvent arg0 ) {
		if ( Pause == true ) {
			return;
		}
		/*if ( arg0.getSource().toString().equals( Itemtypes.toString() ) ) {
			Class_Controller.Set_Itemtype( Itemtypes.getSelectedItem().toString() );
			Class_Controller.UpdateSettings_GUI();
		}*/
		
	}

	public void ActivateItemType(String label, boolean selected) {
		//System.out.println( this.getClass().toString()+" ActivateItemType "+label );
		ItemTypeCheckBoxes.ActivateItemType( label, selected);
	}
}
