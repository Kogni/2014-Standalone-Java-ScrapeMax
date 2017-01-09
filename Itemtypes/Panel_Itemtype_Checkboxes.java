package Itemtypes;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.tree.DefaultMutableTreeNode;

import Control.Controller;

public class Panel_Itemtype_Checkboxes extends JPanel implements ActionListener {

	Controller Class_Controller;
	
	String Settingsfil = "SearchSettings.OE";
	String Itemtypefil = "Itemtypes.OE";
	
	JPanel						TotalPanel;

		JPanel						ItemTypePanelVertical;
			JScrollPane					ItemTypeScrollPanel	= new JScrollPane ( );
			JPanel[]					ItemTypePanelHorizont 	= new JPanel[1999];
			int							ItemTypesTeller		= 0;
			JCheckBox[]					ItemTypes 			= new JCheckBox[1999];
			
			GridBagConstraints firstCol;
	
	MouseListener mouseListener;

	public Panel_Itemtype_Checkboxes ( Controller Class_Controller ) {
		this.Class_Controller = Class_Controller;
	}

	public void Startup ( ) {

		//System.out.println ( "Class Vindu_Menu started" );
		
		setSize ( 1200, 660 );

		//pane.setLayout ( new GridLayout ( 1, 1 ) );
		this.setLayout ( new BoxLayout ( this, BoxLayout.PAGE_AXIS ));
		GridBagConstraints c = new GridBagConstraints ( );
		
		TotalPanel = new JPanel ( );
		TotalPanel.setLayout ( new BoxLayout ( this.TotalPanel, BoxLayout.PAGE_AXIS ) );
		TotalPanel.setBackground ( new Color ( ( 210 ), ( 225 ), ( 240 ) ) );
		
		int X;
		X = 0;
		
		/*firstCol = new GridBagConstraints();
	     firstCol.weightx = 1.0;
	     firstCol.anchor = GridBagConstraints.WEST;
	     firstCol.insets = new Insets(5, 20, 5, 5);
	     ItemTypePanelVertical = new JPanel(new GridBagLayout());*/
		
		ItemTypePanelVertical = new JPanel();
		ItemTypePanelVertical.setLayout ( new BoxLayout ( this.ItemTypePanelVertical, BoxLayout.PAGE_AXIS ) );
		
		ItemTypeScrollPanel = new JScrollPane ( this.ItemTypePanelVertical );
		ItemTypeScrollPanel.setPreferredSize( new Dimension( 260, 440 ) );
		ItemTypeScrollPanel.setBackground ( new Color ( ( 255 ), ( 0 ), ( 0 ) ) );
		
		TotalPanel.add ( this.ItemTypeScrollPanel );
		
		for ( int y = 0 ; y < this.ItemTypes.length ; y++ ) {
			if ( this.ItemTypes[y] != null ) {
				ItemTypes[y].addActionListener ( this );
				ItemTypes[y].setActionCommand ( ItemTypes[y].getLabel() );
				ItemTypes[y].setAlignmentX( ItemTypes[y].LEFT_ALIGNMENT);
				ItemTypes[y].setAlignmentX(1);
				ItemTypes[y].setMinimumSize( new Dimension( 200, 20 ) );
				ItemTypes[y].setMaximumSize( new Dimension( 200, 20 ) );
				ItemTypePanelHorizont[y] = new JPanel ( );
				ItemTypePanelHorizont[y].setLayout ( new BoxLayout ( this.ItemTypePanelHorizont[y], BoxLayout.PAGE_AXIS ) );
				ItemTypePanelHorizont[y].setMinimumSize( new Dimension( 200, 20 ) );
				ItemTypePanelHorizont[y].setMaximumSize( new Dimension( 200, 20 ) );
				ItemTypePanelHorizont[y].add ( this.ItemTypes[y] );
				ItemTypePanelVertical.add ( this.ItemTypePanelHorizont[y] );
			}
		}

		//pane.add ( this.MenuBar, c );
		this.add ( this.TotalPanel, c );
		
		setVisible ( true );
		//LoadItemtypes();
		//LoadSettings();
		Add_SubCategories ( "home", 0 );
		AddListeners();

	}
	
	private void AddListeners() {
		
	}
	
	public void mousePressed( MouseEvent e) {
    }


	public void actionPerformed ( ActionEvent e ) {
		//System.out.println( "En checkbox ble trykket:"+e.getActionCommand());
		//SaveSettings();
		//ActivateItemType( name, activation );
		
		for ( int A = 0 ; A < ItemTypes.length ; A++ ) {
			if ( ItemTypes[A] != null ) {
				//System.out.println( A+" "+ItemTypes[A].getActionCommand() );
				//if ( ItemTypes[A].getActionCommand().equals( e.getActionCommand() ) ) {
				if ( ItemTypes[A].getActionCommand().equals( e.getActionCommand() ) ) {
					//System.out.println( ItemTypes[A].getLabel()+" trykket. getActionCommand="+ItemTypes[A].getActionCommand() );
					try {
						this.Class_Controller.ActivateItemType( ItemTypes[A].getActionCommand(), ItemTypes[A].isSelected() );
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
			} else {
				//System.out.println( A+" null" );
			}
		}
	}
	
	public void Add_SubCategories ( String ParentCategory, int Indent ) {
		//System.out.println( this.getClass().toString()+" Add_ParentCategory Category="+Category );
		Object_DropshipItemtype[] Itemtypes = Class_Controller.Get_Itemtypes_Objects();
		
		for ( int B = 0 ; B < Itemtypes.length ; B++ ) {
			if ( Itemtypes[B] != null ) {
				if ( Itemtypes[B].Dropship_ParentCategory != null ) {
					if ( Itemtypes[B].Dropship_ParentCategory.equalsIgnoreCase( ParentCategory ) ) {
						
						boolean Added = false;
						for ( int C = 0 ; C < ItemTypes.length ; C++ ) {
							if ( ItemTypes[C] != null  ) {
								if ( ItemTypes[C].equals( Itemtypes[B].Dropship_Category ) ) {
									Added = true;
								}
							}
						}
						if ( Added == false ) {
							//System.out.println( this.getClass().toString()+" Add_SubCategories B="+B+" ParentCategory="+ParentCategory+" Itemtypes[B].Category="+Itemtypes[B].Category+" Itemtypes[B].ParentCategory="+Itemtypes[B].ParentCategory+" Indent="+Indent );
							ItemTypesTeller++;
							String Label = " "+Itemtypes[B].Dropship_Category;
							for ( int X = 0 ; X < Indent ; X ++ )
								Label = "----"+Label;
							ItemTypes[ItemTypesTeller] = new JCheckBox ( Label );
							ItemTypes[ItemTypesTeller].addActionListener ( this );
							ItemTypes[ItemTypesTeller].setActionCommand ( Itemtypes[B].Dropship_Category );
							ItemTypes[ItemTypesTeller].setMinimumSize( new Dimension( 200, 20 ) );
							ItemTypes[ItemTypesTeller].setMaximumSize( new Dimension( 200, 20 ) );
							ItemTypePanelHorizont[ItemTypesTeller] = new JPanel ( );
							ItemTypePanelHorizont[ItemTypesTeller].setLayout ( new BoxLayout ( this.ItemTypePanelHorizont[ItemTypesTeller], BoxLayout.LINE_AXIS ) );
							ItemTypePanelHorizont[ItemTypesTeller].setMinimumSize( new Dimension( 200, 20 ) );
							ItemTypePanelHorizont[ItemTypesTeller].setMaximumSize( new Dimension( 200, 20 ) );
							ItemTypePanelHorizont[ItemTypesTeller].add ( this.ItemTypes[ItemTypesTeller] );
							ItemTypePanelVertical.add ( this.ItemTypePanelHorizont[ItemTypesTeller], firstCol );
							
							Add_SubCategories ( Itemtypes[B].Dropship_Category, (Indent+1) );
						}
						
					}
				}
			}
		}
		
	}
	
	public void AddItemType( String itemType ) {
		boolean Found = false;
		int Teller = 0;
		while ( Found == false ) {
			Teller ++;
			if ( ( ItemTypes[Teller] == null ) == false ) {
			} else {
				this.ItemTypes[Teller] = new JCheckBox ( itemType );
				ItemTypes[Teller].addActionListener ( this );
				ItemTypes[Teller].setActionCommand ( ItemTypes[Teller].getLabel() );
				ItemTypes[Teller].setAlignmentX( ItemTypes[Teller].RIGHT_ALIGNMENT);
				ItemTypes[Teller].setAlignmentX(1);
				ItemTypePanelHorizont[Teller] = new JPanel ( );
				ItemTypePanelHorizont[Teller].setLayout ( new BoxLayout ( this.ItemTypePanelHorizont[Teller], BoxLayout.LINE_AXIS ) );
				ItemTypePanelHorizont[Teller].add ( this.ItemTypes[Teller] );
				ItemTypePanelVertical.add ( this.ItemTypePanelHorizont[Teller] );
				
				Found = true;
			}
		}
	}

	public void ActivateItemType( String Name, boolean Activation ) {
		//System.out.println( this.getClass().toString()+" ActivateItemType "+Name );
		for ( int y = 0 ; y < this.ItemTypes.length ; y++ ) {
			if ( this.ItemTypes[y] != null ) {
				if ( ItemTypes[y].getActionCommand().toLowerCase().equals( Name.toLowerCase() )) {
					ItemTypes[y].setSelected( Activation );
					//System.out.println( this.getClass().toString()+" ActivateItemType "+Name+" er aktivert" );
					return;
				}
			}
		}
		return;
	}
}
