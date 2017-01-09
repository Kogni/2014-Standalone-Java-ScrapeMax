package URLs;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import Control.Controller;
import Searching.Object_SearchJob;

public class Panel_URLs extends JPanel implements ActionListener{

	Controller			Class_Controller;

	JScrollPane			URL_ScrollPanel	= new JScrollPane();
	JButton				Update_Button;
	JLabel				Label_URLCount;
	public int			URLCount;
	int					URLCount_Products;
	int					URLCount_Products_Saved;
	int					URLCount_NonProducts;
	int					URLCount_NonProducts_Accepted;
	int					URLCount_DownloadsWaiting;
	int					URLCount_IdentifyWaiting;
	int					URLCount_URLFindWaiting;

	JTable				URL_Table		= new JTable();
	DefaultTableModel	URL_TableModel;
	Vector				URL_CollumnNames;
	Vector				URL_TableContent;

	public Panel_URLs( Controller Class_Controller ) {

		this.Class_Controller = Class_Controller;
		this.URL_TableContent = new Vector();
		this.URL_CollumnNames = new Vector();
		this.URL_TableModel = new DefaultTableModel();
	}

	public void Startup() {
		//System.out.println( this.getClass().toString()+" Startup" );

		Update_Button = new JButton( "Update" );
		this.add( Update_Button );
		Update_Button.addActionListener( this );

		Label_URLCount = new JLabel( "URLs listed: " + URLCount );
		Label_URLCount.setMinimumSize( new Dimension( 700, 20 ) );
		Label_URLCount.setMaximumSize( new Dimension( 900, 40 ) );
		this.add( Label_URLCount );

		//this.URL_CollumnNames.addElement ( "Task ID" );
		this.URL_CollumnNames.addElement( "URL" );
		this.URL_CollumnNames.addElement( "Layer" );
		//this.URL_CollumnNames.addElement ( "Linked Relation" );
		this.URL_CollumnNames.addElement( "Is product?" );
		this.URL_CollumnNames.addElement( "Downloaded?" );
		this.URL_CollumnNames.addElement( "Identified?" );
		this.URL_CollumnNames.addElement( "URLs checked?" );
		//this.URL_CollumnNames.addElement ( "Self Relation" );
		this.URL_CollumnNames.addElement( "Category" );
		this.URL_CollumnNames.addElement( "Parent Cat." );
		this.URL_CollumnNames.addElement( "Accepted?" );
		this.URL_CollumnNames.addElement( "Saved offer?" );
		this.URL_CollumnNames.addElement( "Links out" );

		this.URL_TableModel.setDataVector( this.URL_TableContent, this.URL_CollumnNames );

		this.URL_Table = new JTable( this.URL_TableModel );
		//this.URL_Table.setPreferredSize ( new Dimension ( 2000, 550 ) );

		TableColumn column;
		int X = 0;
		/*column = this.URL_Table.getColumnModel ( ).getColumn ( X ); //searchjob ID
		column.setMaxWidth( 400 );
		column.setMinWidth( 10 ); 
		X++;*/
		column = this.URL_Table.getColumnModel().getColumn( X ); //url
		column.setMaxWidth( 500 );
		column.setMinWidth( 100 );
		X++;
		column = this.URL_Table.getColumnModel().getColumn( X ); //layer
		column.setMaxWidth( 60 );
		column.setMinWidth( 30 );
		X++;
		/*column = this.URL_Table.getColumnModel ( ).getColumn ( X ); //linked relation
		column.setMaxWidth( 60 );
		column.setMinWidth( 30 );  
		X++;*/
		column = this.URL_Table.getColumnModel().getColumn( X ); //is product
		column.setMaxWidth( 60 );
		column.setMinWidth( 30 );
		X++;
		column = this.URL_Table.getColumnModel().getColumn( X ); //downloaded
		column.setMaxWidth( 60 );
		column.setMinWidth( 30 );
		X++;
		column = this.URL_Table.getColumnModel().getColumn( X ); //identified
		column.setMaxWidth( 60 );
		column.setMinWidth( 30 );
		X++;
		column = this.URL_Table.getColumnModel().getColumn( X ); //urls
		column.setMaxWidth( 60 );
		column.setMinWidth( 30 );
		X++;
		/*column = this.URL_Table.getColumnModel ( ).getColumn ( X ); //self relation
		column.setMaxWidth( 60 );
		column.setMinWidth( 30 );  
		X++;*/
		column = this.URL_Table.getColumnModel().getColumn( X ); //category
		column.setMaxWidth( 120 );
		column.setMinWidth( 60 );
		X++;
		column = this.URL_Table.getColumnModel().getColumn( X ); //category
		column.setMaxWidth( 120 );
		column.setMinWidth( 60 );
		X++;
		column = this.URL_Table.getColumnModel().getColumn( X ); //accept
		column.setMaxWidth( 60 );
		column.setMinWidth( 30 );
		X++;
		column = this.URL_Table.getColumnModel().getColumn( X ); //accept
		column.setMaxWidth( 60 );
		column.setMinWidth( 30 );
		X++;
		column = this.URL_Table.getColumnModel().getColumn( X ); //links out
		column.setMaxWidth( 60 );
		column.setMinWidth( 30 );

		this.URL_ScrollPanel = new JScrollPane( this.URL_Table );
		this.URL_ScrollPanel.setPreferredSize( new Dimension( 950, 400 ) );
		this.add( this.URL_ScrollPanel );

	}

	public void AddUrl( Object_SearchJob Page ) throws Exception {
		//System.out.println ( "AddUrl="+Page);
		try {
			URLCount++;

			try {
				Vector Temp = new Vector();

				//Temp.addElement ( Page.toString() );
				Temp.addElement( Page.Get_Adresse() );
				Temp.addElement( Page.TargetOffer.Get_Adresse().Layer );
				//Temp.addElement ( Page.Get_LinkedRelationValue() );
				Temp.addElement( Class_Controller.isProductPage( Page.Get_Adresse().toString() ) );
				if ( Class_Controller.isProductPage( Page.Get_Adresse().toString() ) == true ) {
					URLCount_Products++;
				}
				else {
					URLCount_NonProducts++;
				}
				if ( Page.TargetOffer.Get_Adresse().Download_Finished == true ) {
					Temp.addElement( "Done" );
				}
				else if ( Page.TargetOffer.Get_Adresse().Download_Started == true ) {
					Temp.addElement( "Downloading..." );
					URLCount_DownloadsWaiting++;
				}
				else {
					Temp.addElement( "Queued" );
					URLCount_DownloadsWaiting++;
				}
				if ( Page.Get_Identify_Finished() == true ) {
					Temp.addElement( "Done" );
				}
				else if ( Page.Get_Identify_Started() == true ) {
					Temp.addElement( "Identifying..." );
					URLCount_IdentifyWaiting++;
				}
				else {
					Temp.addElement( "Queued" );
					URLCount_IdentifyWaiting++;
					//System.out.println( this.getClass().toString()+" AddUrl Get_Identify_Finished="+Page.Get_Identify_Finished()+" Get_Identify_Started="+Page.Get_Identify_Started()+" status="+Page.Identification_Status+" Download_Finished="+Page.TargetOffer.Get_Adresse().Download_Finished+" Page.toString()="+Page.toString() );
				}
				if ( Page.TargetOffer.Get_Adresse().URLs_Finished == true ) {
					Temp.addElement( "Done" );
				}
				else if ( Page.TargetOffer.Get_Adresse().URLs_Started == true ) {
					Temp.addElement( "Checking..." );
					URLCount_URLFindWaiting++;
				}
				else {
					if ( Page.TargetOffer.Get_Adresse().Get_AcceptedCategory() == true ) {
						Temp.addElement( "Queued" );
						URLCount_URLFindWaiting++;
					}
					else {
						Temp.addElement( "Rejected" );
					}
				}
				if ( Class_Controller.isProductPage( Page.Get_Adresse().toString() ) == false ) {
					if ( Page.Get_Identify_Finished() == true ) {
						if ( Page.TargetOffer.Get_Adresse().Get_AcceptedCategory() != false ) {
							URLCount_NonProducts_Accepted++;
						}
						else {
							//System.out.println( this.getClass().toString()+" AddUrl Rejected URL="+Page.Get_Adresse()+" "+Page.TargetOffer.Category );
						}
					}
					else {
						URLCount_NonProducts_Accepted++;
					}
				}
				//Temp.addElement ( Page.Get_SelfRelationValue() );
				if ( Page.Get_ItemType() == null ) {
					Temp.addElement( "?" );
				}
				else {
					Temp.addElement( Page.TargetOffer.Category );
				}
				Temp.addElement( Page.TargetOffer.ParentCategory );
				if ( Class_Controller.isProductPage( Page.Get_Adresse().toString() ) == true ) {
					Temp.addElement( Page.TargetOffer.Get_AcceptedProduct() );
				}
				else {
					Temp.addElement( Page.TargetOffer.Get_Adresse().Get_AcceptedCategory() );
				}
				Temp.addElement( Page.TargetOffer.Get_Adresse().OfferSaved );
				if ( (Page.TargetOffer.Get_Adresse().OfferSaved == true) && (Class_Controller.isProductPage( Page.Get_Adresse().toString() ) == true) ) {
					URLCount_Products_Saved++;
				}
				Temp.addElement( Page.LinksOut );

				this.URL_TableContent.addElement( Temp );
				this.URL_TableModel.fireTableDataChanged();
			}
			catch ( Exception e ) {
				Class_Controller.ReportError( e, this.getClass().toString() + " AddUrl" );
			}
			int ProductsPrcnt = URLCount_Products_Saved * 100;
			if ( URLCount_Products > 0 ) {
				ProductsPrcnt = ProductsPrcnt / URLCount_Products;
			}
			else {
				ProductsPrcnt = 100;
			}
			int NonProductsPrcnt = URLCount_NonProducts_Accepted * 100;
			if ( URLCount_NonProducts > 0 ) {
				NonProductsPrcnt = NonProductsPrcnt / URLCount_NonProducts;
			}
			else {
				NonProductsPrcnt = 100;
			}
			int LayerProgress = -1;
			try {
				if ( (Class_Controller.Get_LayerCount() > 0) && (((Class_Controller.Get_LayerCount() * 3) - Class_Controller.Get_LayerCount_Working()) > 0) ) {
					LayerProgress = ((Class_Controller.Get_LayerCount() * 3) - Class_Controller.Get_LayerCount_Working()) * 100;
					LayerProgress = LayerProgress / (Class_Controller.Get_LayerCount() * 3);
					//System.out.println( this.getClass().toString()+" CleanTable Get_Layer="+Class_Controller.Get_Layer() );
					//System.out.println( this.getClass().toString()+" CleanTable Get_LayerCount="+Class_Controller.Get_LayerCount() );
					//System.out.println( this.getClass().toString()+" CleanTable Get_LayerCount_Working="+Class_Controller.Get_LayerCount_Working() );
				}
			}
			catch ( Exception e ) {

			}
			Label_URLCount.setText( "<html>URLs listed: " + URLCount + " <br> " + URLCount_Products + " Products, " + URLCount_Products_Saved + " Exported products (" + ProductsPrcnt + "%), <br>" + URLCount_NonProducts + " non-products, " + URLCount_NonProducts_Accepted + " accepted non-products("
					+ NonProductsPrcnt + "%) <br>" + URLCount_DownloadsWaiting + " downloads queued, " + URLCount_IdentifyWaiting + " identifications queued, " + URLCount_URLFindWaiting + " URL checks queued. <br>" + "Layer: " + Class_Controller.Get_Layer() + " Progress: "
					+ ((Class_Controller.Get_LayerCount() * 3) - Class_Controller.Get_LayerCount_Working()) + "/" + (Class_Controller.Get_LayerCount() * 3) + " (" + LayerProgress + "%)" + "</html>" );
		}
		catch ( Exception e ) {
			Class_Controller.ReportError( e, this.getClass().toString() + " AddUrl" );
		}
	}

	public void CleanTable() throws Exception {
		//System.out.println( this.getClass().toString()+" CleanTable URLCount="+URLCount );
		try {
			URL_TableContent.removeAllElements();
			URLCount = 0;
			URLCount_Products = 0;
			URLCount_Products_Saved = 0;
			URLCount_NonProducts = 0;
			URLCount_NonProducts_Accepted = 0;
			URLCount_DownloadsWaiting = 0;
			URLCount_IdentifyWaiting = 0;
			URLCount_URLFindWaiting = 0;
		}
		catch ( Exception e ) {
			Class_Controller.ReportError( e, this.getClass().toString() + " CleanTable" );
		}
	}

	@Override
	public void actionPerformed( ActionEvent arg0 ) {
		try {
			this.Class_Controller.UpdateURLGUIList();
		}
		catch ( Exception e ) {
			e.printStackTrace();
		}
	}

}
