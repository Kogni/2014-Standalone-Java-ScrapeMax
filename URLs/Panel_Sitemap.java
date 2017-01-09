package URLs;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import Control.Controller;
import Itemtypes.Object_DropshipItemtype;
import Searching.Object_SearchJob;

public class Panel_Sitemap extends JPanel implements ActionListener {
	
	Controller Class_Controller;
	
	JPanel						TotalPanel;
	JButton						Update_Button;

	JPanel						SitemapPanelVertical;
		JScrollPane					SitemapScrollPanel	= new JScrollPane ( );
		JPanel[]					SitemapPanelHorizont 	= new JPanel[99999];
		JLabel						Label_URLCount;
		int							URLTeller		= 0;
		JLabel[]					Pages 			= new JLabel[99999];
		
		GridBagConstraints firstCol;

		MouseListener mouseListener;
	
	public Panel_Sitemap( Controller Class_Controller ) {
		
		this.Class_Controller = Class_Controller;

	}
	
	public void Startup ( ) throws Exception {

		//System.out.println ( "Class Vindu_Menu started" );
		
		/*Update_Button = new JButton("Update");
		this.add( Update_Button );
		Update_Button.addActionListener( this );*/
		
		Label_URLCount = new JLabel("URLs listed: "+URLTeller);
		Label_URLCount.setMinimumSize( new Dimension( 700, 20 ) );
		Label_URLCount.setMaximumSize( new Dimension( 900, 40 ) );
		this.add( Label_URLCount );
		
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
	     SitemapPanelVertical = new JPanel(new GridBagLayout());*/
		
		SitemapPanelVertical = new JPanel();
		SitemapPanelVertical.setLayout ( new BoxLayout ( this.SitemapPanelVertical, BoxLayout.PAGE_AXIS ) );
		
		SitemapScrollPanel = new JScrollPane ( this.SitemapPanelVertical );
		SitemapScrollPanel.setPreferredSize( new Dimension( 260, 440 ) );
		SitemapScrollPanel.setBackground ( new Color ( ( 255 ), ( 0 ), ( 0 ) ) );
		
		TotalPanel.add ( this.SitemapScrollPanel );
		
		for ( int y = 0 ; y < this.Pages.length ; y++ ) {
			if ( this.Pages[y] != null ) {
				Pages[y].setAlignmentX( Pages[y].LEFT_ALIGNMENT);
				Pages[y].setAlignmentX(1);
				Pages[y].setMinimumSize( new Dimension( 200, 20 ) );
				Pages[y].setMaximumSize( new Dimension( 200, 20 ) );
				SitemapPanelHorizont[y] = new JPanel ( );
				SitemapPanelHorizont[y].setLayout ( new BoxLayout ( this.SitemapPanelHorizont[y], BoxLayout.PAGE_AXIS ) );
				SitemapPanelHorizont[y].setMinimumSize( new Dimension( 200, 20 ) );
				SitemapPanelHorizont[y].setMaximumSize( new Dimension( 200, 20 ) );
				SitemapPanelHorizont[y].add ( this.Pages[y] );
				SitemapPanelVertical.add ( this.SitemapPanelHorizont[y] );
			}
		}

		//pane.add ( this.MenuBar, c );
		this.add ( this.TotalPanel, c );
		
		setVisible ( true );
		//LoadPages();
		//LoadSettings();
		AddListeners();

	}

	private void AddListeners() {
		// TODO Auto-generated method stub
		
	}
	
	public void Add_Page_Locate( Object_URL Node ) throws Exception { //kan ikke bruke array som metode for opplisting, for da blir rekkefølge gal?
		//System.out.println( this.getClass().toString()+" Add_Page_Locate A Node="+Node.Adresse.toString() );
		if ( Node == null ) {
			return;
		}
		for ( int C = 0 ; C < Pages.length ; C++ ) {
			//System.out.println( this.getClass().toString()+" Add_Page_Locate B Node="+Node.Adresse.toString()+" versus node#"+C );
			if ( Pages[C] != null  ) {
				//System.out.println( this.getClass().toString()+" Add_Page_Locate C Node="+Node.Adresse.toString()+" versus node#"+C );
				if ( Pages[C].getToolTipText() != null  ) {
					//System.out.println( this.getClass().toString()+" Add_Page_Locate D Node="+Node.Adresse.toString()+" versus "+Pages[C].getToolTipText() );
					if ( Pages[C].getToolTipText().equalsIgnoreCase( Node.Adresse.toString() ) ) {
						//System.out.println( this.getClass().toString()+" Add_Page_Locate "+Node.Adresse.toString()+" er allerede addet" );
						return;
					}
				}
			}
		}
		//System.out.println( this.getClass().toString()+" Add_Page_Locate E Node="+Node.Adresse.toString() );
		if ( Node.ParentURL != null ) { //add stems
			Add_Page_Locate( Node.ParentURL );
		}
		//System.out.println( this.getClass().toString()+" Add_Page_Locate F Node="+Node.Adresse.toString() );
		Add_Page_Insert( Node, FigureIndents( Node ) ); //add leaf
	}
	
	private int FigureIndents( Object_URL Node ) {
		if ( Node.ParentURL != null ) {
			return FigureIndents( Node.ParentURL )+1; //dette er et blad, og skal indentes fra stem
		} else { //dette er roten, og skal ikke indentes ytterligere
			return 0;
		}
	}
	
	private void Add_Page_Insert( Object_URL Node, int Indent ) throws Exception {
		//System.out.println( this.getClass().toString()+" Add_Page_Insert A Node="+Node.Adresse.toString() );
		if ( Node == null ) {
			return;
		}
		if ( Node.Adresse == null ) {
			return;
		}
		for ( int C = 0 ; C < Pages.length ; C++ ) {
			if ( Pages[C] == null ) {
				try {
					//System.out.println( this.getClass().toString()+" Add_Page_Insert A" );
					//System.out.println( this.getClass().toString()+" Add_Page_Insert B Pages[C]="+Pages[C]+" Node="+Node );
					//System.out.println( this.getClass().toString()+" Add_Page_Insert B Node.Adresse="+Node.Adresse );
					URLTeller++;
					String Label = " "+Node.Get_Adresse().toString();
					for ( int X = 0 ; X < Indent ; X ++ )
						Label = "----"+Label;
					Pages[URLTeller] = new JLabel ( Label );
					//System.out.println( this.getClass().toString()+" Add_Page_Insert Pages[URLTeller]="+Pages[URLTeller]+" Label="+Label );
					Pages[URLTeller].setMinimumSize( new Dimension( 200, 20 ) );
					Pages[URLTeller].setMaximumSize( new Dimension( 800, 20 ) );
					Pages[URLTeller].setToolTipText( Node.Get_Adresse().toString() );
					SitemapPanelHorizont[URLTeller] = new JPanel ( );
					SitemapPanelHorizont[URLTeller].setLayout ( new BoxLayout ( this.SitemapPanelHorizont[URLTeller], BoxLayout.LINE_AXIS ) );
					SitemapPanelHorizont[URLTeller].setMinimumSize( new Dimension( 200, 20 ) );
					SitemapPanelHorizont[URLTeller].setMaximumSize( new Dimension( 800, 20 ) );
					SitemapPanelHorizont[URLTeller].add ( this.Pages[URLTeller] );
					SitemapPanelVertical.add ( this.SitemapPanelHorizont[URLTeller], firstCol );
					//System.out.println( this.getClass().toString()+" Add_Page_Insert C Node="+Node.Adresse.toString() );
					Label_URLCount.setText( "<html>URLs listed: "+URLTeller+" " );
					return;
				} catch ( Exception e ) {
					
				}
			} else if ( Pages[C].getToolTipText() == null ) {
				//System.out.println( this.getClass().toString()+" Add_Page_Insert B" );
				
			} else if ( Pages[C].getToolTipText().equalsIgnoreCase( Node.Adresse.toString() ) ) {
				//System.out.println( this.getClass().toString()+" Add_Page_Insert C" );
				return;
			} else {
				//System.out.println( this.getClass().toString()+" Add_Page_Insert D " );
			}
		}

	}

	/*public void Add_Pages( String ParentURL, int Indent ) throws Exception {
		System.out.println( this.getClass().toString()+" Add_Pages A ParentURL="+ParentURL );
		Object_SearchJob[] PageArray = Class_Controller.Get_All_Pages();
		if ( PageArray == null ) {
			return;
		}
		System.out.println( this.getClass().toString()+" Add_Pages B ParentURL="+ParentURL+" PageArray.length="+PageArray.length );
		for ( int B = 0 ; B < PageArray.length ; B++ ) {
			System.out.println( this.getClass().toString()+" Add_Pages C ParentURL="+ParentURL+" PageArray[B]="+PageArray[B] );
			if ( PageArray[B] != null ) {
				System.out.println( this.getClass().toString()+" Add_Pages D ParentURL="+ParentURL );
				if ( PageArray[B].TargetOffer.Get_Adresse().ParentURL != null ) {
					System.out.println( this.getClass().toString()+" Add_Pages E ParentURL="+ParentURL );
					if ( PageArray[B].TargetOffer.Get_Adresse().ParentURL.Adresse.toString().equalsIgnoreCase( ParentURL ) ) {
						
						System.out.println( this.getClass().toString()+" Add_Pages F ParentURL="+ParentURL );
						
						boolean Added = false;
						for ( int C = 0 ; C < Pages.length ; C++ ) {
							if ( Pages[C] != null  ) {
								if ( Pages[C].equals( PageArray[B].TargetOffer.Get_Adresse().ParentURL.Adresse.toString() ) ) {
									Added = true;
								}
							}
						}
						if ( Added == false ) {
							//System.out.println( this.getClass().toString()+" Add_SubCategories B="+B+" ParentCategory="+ParentCategory+" Pages[B].Category="+Pages[B].Category+" Pages[B].ParentCategory="+Pages[B].ParentCategory+" Indent="+Indent );
							URLTeller++;
							String Label = " "+PageArray[B].TargetOffer.Get_Adresse().Adresse.toString();
							for ( int X = 0 ; X < Indent ; X ++ )
								Label = "----"+Label;
							Pages[URLTeller] = new JLabel ( Label );
							Pages[URLTeller].setMinimumSize( new Dimension( 200, 20 ) );
							Pages[URLTeller].setMaximumSize( new Dimension( 200, 20 ) );
							SitemapPanelHorizont[URLTeller] = new JPanel ( );
							SitemapPanelHorizont[URLTeller].setLayout ( new BoxLayout ( this.SitemapPanelHorizont[URLTeller], BoxLayout.LINE_AXIS ) );
							SitemapPanelHorizont[URLTeller].setMinimumSize( new Dimension( 200, 20 ) );
							SitemapPanelHorizont[URLTeller].setMaximumSize( new Dimension( 200, 20 ) );
							SitemapPanelHorizont[URLTeller].add ( this.Pages[URLTeller] );
							SitemapPanelVertical.add ( this.SitemapPanelHorizont[URLTeller], firstCol );
							
							Add_Pages ( PageArray[B].TargetOffer.Get_Adresse().Adresse.toString(), (Indent+1) );
						}
						
					}
				}
			}
		}
	}*/

	@Override
	public void actionPerformed(ActionEvent arg0) {
		try {
			//Add_Pages ( "home", 0 );
			//Add_Page_Locate( Class_Controller., 0 );
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
