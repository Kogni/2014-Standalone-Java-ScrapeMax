package Dropshippers;

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

import Control.Controller;

public class Panel_Settings_Dropshippers extends JPanel implements ActionListener {
	
	Controller Class_Controller;
	
	JPanel						TotalPanel;
		JPanel						ToolPanel;
			JPanel						StaticPanel;
				JToolBar					MenuBar;
					JComboBox					Dropshippers;
	
	MouseListener mouseListener;

	public Panel_Settings_Dropshippers( Controller class_Controller ) {
		Class_Controller = class_Controller;
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
		StaticPanel.setPreferredSize( new Dimension( 400, 30 ) );
		StaticPanel.setMaximumSize( new Dimension( 400, 50 ) );
		StaticPanel.setMinimumSize( new Dimension( 400, 20 ) );
		ToolPanel.add ( this.StaticPanel );
		
		MenuBar = new JToolBar();
		MenuBar.add( new JLabel("Dropshipper: ") );
		Dropshippers = new JComboBox();
		Object_Dropshipper[] Alltypes = this.Class_Controller.Get_Dropshippers();
		Dropshippers.addItem( "" );
		if ( Alltypes != null ) {
			for (int i = 0; i < Alltypes.length; i++ ) {
				if ( Alltypes[i] != null ) {
					Dropshippers.addItem( Alltypes[i].DropshipperName );
				}
			}
		}
		Dropshippers.addActionListener( this );
		MenuBar.add(Dropshippers);
		StaticPanel.add(MenuBar);

		this.add ( this.TotalPanel, c );
		
		setVisible ( true );
	}
	
	@Override
	public void actionPerformed( ActionEvent arg0 ) {
		
		if ( arg0.getSource().toString().equals( Dropshippers.toString() ) ) {
			try {
				Class_Controller.Set_Dropshipper( Dropshippers.getSelectedItem().toString() );
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
