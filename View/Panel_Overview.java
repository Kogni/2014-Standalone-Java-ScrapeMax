package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JToolBar;
import javax.swing.text.BadLocationException;
import javax.swing.text.Element;

import Control.Controller;

public class Panel_Overview extends JPanel implements ActionListener {
	
	Controller Class_Controller;
	
	JPanel ActionPanel;
		JLabel CurrentAction;
	JPanel MessagePanel;
		JTextArea MessageText;

	JToolBar MenuBar;
		JButton  StartSearch;
		JButton  StopSearch;
	
	JLabel Currency;

	public Panel_Overview( Controller Class_Controller ) throws Exception {
		this.Class_Controller = Class_Controller;
		
		setSize ( 1000, 600 );
		//setBackground ( new Color ( ( 0 ), ( 255 ), ( 0 ) ) );
		
		this.setLayout ( new BoxLayout ( this, BoxLayout.PAGE_AXIS ));
		GridBagConstraints c = new GridBagConstraints ( );
		
		MenuBar = new JToolBar();
		
		StartSearch = new JButton ( "Start search" );
		StartSearch.getAccessibleContext().setAccessibleDescription( "Starts searching");
		StartSearch.setEnabled( true );
		MenuBar.add(StartSearch);
		
		StopSearch = new JButton ( "Stop search" );
		StopSearch.getAccessibleContext().setAccessibleDescription( "Stops searching.");
		StopSearch.setEnabled( false );
		MenuBar.add(StopSearch);
		
		this.add(MenuBar);
		
		CurrentAction = new JLabel("Waiting to start");
        CurrentAction.setMinimumSize( new Dimension( 1000, 20 ) );
        this.add( CurrentAction );

		MessagePanel = new JPanel ( );
		MessagePanel.setLayout ( new BoxLayout ( this.MessagePanel, BoxLayout.PAGE_AXIS ) );
		MessagePanel.setBackground ( new Color ( ( 255 ), ( 0 ), ( 0 ) ) );
		MessagePanel.setMinimumSize( new Dimension( 1000, 200 ) );
		this.add ( this.MessagePanel );

		MessageText = new JTextArea( 10, 1 );
		MessageText.setEditable( false);
		JScrollPane scrollPane = new JScrollPane(MessageText); 
		MessagePanel.add ( scrollPane );
		
		
	}

	public void Startup() {
		//System.out.println( this.getClass().toString()+" Startup" );
		StartSearch.addActionListener(this);
		StopSearch.addActionListener(this);
		setVisible ( true );
	}
	
	public void actionPerformed ( ActionEvent e ) {
		if ( e.getActionCommand().equals ( this.StartSearch.getText ( ) ) ) {
			try {
				Class_Controller.UserCommand_StartSearching(  );
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} else if ( e.getActionCommand ( ).equals ( this.StopSearch.getText ( ) ) ) {
			try {
				Class_Controller.UserCommand_StopSearching();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} else {
			System.out.println( e+" "+e.getSource() );
		}
		if ( Class_Controller.AllowWorking == true ) {
			StopSearch.setEnabled( true );
			StartSearch.setEnabled( false );
		} else if ( Class_Controller.AllowWorking == false ) {
			StartSearch.setEnabled( true );
			StopSearch.setEnabled( false );
		}
	}

	public void AddProgressMessage( String Message ) throws Exception {
		try {
			Date Idag = new Date();
			Message = Message.substring( 0, Math.min( 200, Message.length() ) );
			MessageText.append( Idag.getHours()+"."+Idag.getMinutes()+":"+Idag.getSeconds()+" "+Message+"\n" );
			if ( MessageText.getLineCount() > 29 ) {
				Element root = MessageText.getDocument().getDefaultRootElement();
				Element first = root.getElement(0);
				try {
					MessageText.getDocument().remove(first.getStartOffset(), first.getEndOffset());
				} catch (BadLocationException e) {
				}
	        }
			MessageText.selectAll();
	
			//System.out.println( "getLineCount()="+MessageText.getLineCount() );
			MessageText.setCaretPosition( MessageText.getDocument().getLength());
		} catch (Exception e) {
		}
	}

	public void SetCurrentAction( String ActionText ) {
		//System.out.println( CurrentAction );
		Date Idag = new Date();
		CurrentAction.setText( Idag.getHours()+"."+Idag.getMinutes()+":"+Idag.getSeconds()+" "+" "+ActionText );
	}
}
