package View;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class Object_DialogPopup extends JDialog implements ActionListener {

	private static final long	serialVersionUID	= 1L;
	JPanel						MessagePanel		= new JPanel ( );
	String						ErrorMessage;

	public Object_DialogPopup ( JFrame parent, String title, int ErrorID ) {

		super ( parent, title, true );
		if ( parent != null ) {
			Dimension parentSize = parent.getSize ( );
			Point p = parent.getLocation ( );
			setLocation ( p.x + parentSize.width / 4, p.y + parentSize.height / 4 );
		}

		this.MessagePanel.setLayout ( new GridLayout ( 0, 1 ) );
		GenerateErrorMessage ( ErrorID );

		getContentPane ( ).add ( this.MessagePanel );
		JPanel buttonPane = new JPanel ( );
		JButton button = new JButton ( "OK" );
		buttonPane.add ( button );
		button.addActionListener ( this );
		getContentPane ( ).add ( buttonPane, BorderLayout.SOUTH );
		setDefaultCloseOperation ( WindowConstants.DISPOSE_ON_CLOSE );
		pack ( );
		setVisible ( true );

	}

	private void GenerateErrorMessage ( int ID ) {

		if ( ID == 0 ) {
			this.MessagePanel.add ( new JLabel ( " " ) );
			this.MessagePanel.add ( new JLabel ( "You are using a trial version which is past it's date." ) );
			this.MessagePanel.add ( new JLabel ( " " ) );
			this.MessagePanel.add ( new JLabel ( "Contact me for an updated version." ) );
		}

	}

	public void actionPerformed ( ActionEvent e ) {

		setVisible ( false );
		dispose ( );

	}

}