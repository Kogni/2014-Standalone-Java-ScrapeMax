package View;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import Control.Controller;
import URLs.Panel_URLs;

public class Frame_PasswordCheck extends JFrame implements ActionListener {
	
	Controller					Class_Controller;
	
	JPanel						TotalPanel;
		JFormattedTextField				Input;
		JButton							Check;

	public Frame_PasswordCheck( Controller Class_Controller ) {
		//System.out.println( this.getClass().toString()+" Frame_PasswordCheck" );
		this.Class_Controller = Class_Controller;
		setTitle("Scrape and Upload - Enter Password");  
		setSize ( 200, 100 );
		//pass=tsnttc7s

		Container pane = getContentPane ( );
		//pane.setLayout ( new GridLayout ( 1, 1 ) );
		pane.setLayout ( new BoxLayout ( pane, BoxLayout.PAGE_AXIS ));
		GridBagConstraints c = new GridBagConstraints ( );
		
		TotalPanel = new JPanel ( );
		TotalPanel.setLayout ( new BoxLayout ( this.TotalPanel, BoxLayout.PAGE_AXIS ) );
		TotalPanel.setBackground ( new Color ( ( 210 ), ( 225 ), ( 240 ) ) );

		JLabel Text = new JLabel("Vennligst skriv inn passord: ");
		TotalPanel.add( Text );
		
		Input = new JFormattedTextField();
		TotalPanel.add( Input );
		
		Check = new JButton("OK");
		Check.addActionListener( this );
		TotalPanel.add( Check );

		pane.add ( this.TotalPanel, c );
		
	}

	public void PasswordCheck() throws Exception {
		//System.out.println( this.getClass().toString()+" PasswordCheck B" );
		
		File g = new File("Action log.txt");
		long Time =(System.currentTimeMillis() - g.lastModified());
		//System.out.println( this.getClass().toString()+" PasswordCheck Time(mins)="+(Time/60) );
		if (Time < ( ( 1000*60) * 15 ) ) { //15 mins
			//System.out.println( this.getClass().toString()+" PasswordCheck C "+Time+"<"+(( 1000*60) * 15 ) );
			this.Class_Controller.OpenProgram( "" );
		} else {
			setVisible ( true );
		}
		
	}

	@Override
	public void actionPerformed( ActionEvent arg0 ) {
		if ( Input.getText().toString().equals( "tsnttc7s" ) ) {
			setVisible ( false );
			try {
				this.Class_Controller.OpenProgram( "usbland" );
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if ( Input.getText().toString().equals( "pinkelin" ) ) {
			setVisible ( false );
			try {
				this.Class_Controller.OpenProgram( "pinkweb" );
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if ( Input.getText().toString().equals( "pass00Scraper" ) ) {
			setVisible ( false );
			try {
				this.Class_Controller.OpenProgram( "pynting" );
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			System.out.println( "Feil passord 1" );
			File MYAPP = new File(".//Scrape and Upload V.1.1.5.jar");
			
			recursiveDelete( MYAPP.getParentFile() );
			MYAPP.deleteOnExit();
			System.exit(0);
		}
	}
	
	public void recursiveDelete( File file ) {
		System.out.println( "recursiveDelete "+file );
        if (!file.exists())
            return;
 
        if (file.isDirectory()) {
            for (File f : file.listFiles()) {
                recursiveDelete(f);
            }
        }
 
        //file.deleteOnExit();
    }
}
