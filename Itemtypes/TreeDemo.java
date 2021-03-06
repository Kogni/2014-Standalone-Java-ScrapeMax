package Itemtypes;
/**
 * This application that requires the following additional files:
 *   TreeDemoHelp.html
 *    arnold.html
 *    bloch.html
 *    chan.html
 *    jls.html
 *    swingtutorial.html
 *    tutorial.html
 *    tutorialcont.html
 *    vm.html
 */
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.UIManager;

import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeSelectionModel;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;

import Control.Controller;

import java.net.URL;
import java.io.IOException;
import java.awt.Dimension;
import java.awt.GridLayout;

public class TreeDemo extends JPanel implements TreeSelectionListener {
	
	public Controller					Class_Controller;
	
    private JEditorPane htmlPane;
    private JTree tree;
    private URL helpURL;
    private static boolean DEBUG = false;

    private static boolean playWithLineStyle = false;
    private static String lineStyle = "Horizontal";
    
    private static boolean useSystemLookAndFeel = false;

    public TreeDemo( Controller Class_Controller ) {
        super(new GridLayout(1,0));

        this.Class_Controller = Class_Controller;
        
        DefaultMutableTreeNode top = new DefaultMutableTreeNode("Home");
        createNodes(top);

        tree = new JTree(top);
        tree.getSelectionModel().setSelectionMode (TreeSelectionModel.SINGLE_TREE_SELECTION);

        tree.addTreeSelectionListener(this);

        if (playWithLineStyle) {
            System.out.println("line style = " + lineStyle);
            tree.putClientProperty("JTree.lineStyle", lineStyle);
        }

        JScrollPane treeView = new JScrollPane(tree);

        htmlPane = new JEditorPane();
        htmlPane.setEditable(false);
        initHelp();
        JScrollPane htmlView = new JScrollPane(htmlPane);

        JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
        splitPane.setTopComponent(treeView);
        splitPane.setBottomComponent(htmlView);

        Dimension minimumSize = new Dimension(100, 50);
        htmlView.setMinimumSize(minimumSize);
        treeView.setMinimumSize(minimumSize);
        splitPane.setDividerLocation(100); 
        splitPane.setPreferredSize(new Dimension(500, 300));

        add(splitPane);
    }

    /** Required by TreeSelectionListener interface. */
    public void valueChanged(TreeSelectionEvent e) {
        DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();

        if (node == null) return;

        Object nodeInfo = node.getUserObject();
        if (node.isLeaf()) {
            BookInfo book = (BookInfo)nodeInfo;
            displayURL(book.bookURL);
            if (DEBUG) {
                System.out.print(book.bookURL + ":  \n    ");
            }
        } else {
            displayURL(helpURL); 
        }
        if (DEBUG) {
            System.out.println(nodeInfo.toString());
        }
    }

    private class BookInfo {
        public String bookName;
        public URL bookURL;

        public BookInfo(String book, String filename) {
            bookName = book;
            bookURL = getClass().getResource(filename);
        }

        public String toString() {
            return bookName;
        }
    }

    private void initHelp() {
        String s = "TreeDemoHelp.html";
        helpURL = getClass().getResource(s);

        displayURL(helpURL);
    }

    private void displayURL(URL url) {
        try {
            if (url != null) {
                htmlPane.setPage(url);
            } else { //null url
            	htmlPane.setText("File Not Found");
            }
        } catch (IOException e) {
           // System.err.println("Attempted to read a bad URL: " + url);
        }
    }

    private void createNodes( DefaultMutableTreeNode top ) {
        DefaultMutableTreeNode category = null;
        DefaultMutableTreeNode book = null;

        category = new DefaultMutableTreeNode("Books for Java Programmers");
        top.add(category);
        
        Add_ParentCategory ( top, "Home" );

        //original Tutorial
        book = new DefaultMutableTreeNode(new BookInfo ("The Java Tutorial: A Short Course on the Basics", "tutorial.html"));
        category.add(book);

        //Tutorial Continued
        book = new DefaultMutableTreeNode(new BookInfo ("The Java Tutorial Continued: The Rest of the JDK",
            "tutorialcont.html"));
        category.add(book);

        //JFC Swing Tutorial
        book = new DefaultMutableTreeNode(new BookInfo
            ("The JFC Swing Tutorial: A Guide to Constructing GUIs",
            "swingtutorial.html"));
        category.add(book);

        //Bloch
        book = new DefaultMutableTreeNode(new BookInfo
            ("Effective Java Programming Language Guide",
	     "bloch.html"));
        category.add(book);

        //Arnold/Gosling
        book = new DefaultMutableTreeNode(new BookInfo
            ("The Java Programming Language", "arnold.html"));
        category.add(book);

        //Chan
        book = new DefaultMutableTreeNode(new BookInfo
            ("The Java Developers Almanac",
             "chan.html"));
        category.add(book);

        category = new DefaultMutableTreeNode("Books for Java Implementers");
        top.add(category);

        //VM
        book = new DefaultMutableTreeNode(new BookInfo
            ("The Java Virtual Machine Specification",
             "vm.html"));
        category.add(book);

        //Language Spec
        book = new DefaultMutableTreeNode(new BookInfo
            ("The Java Language Specification",
             "jls.html"));
        category.add(book);
    }
        
	public void Add_ParentCategory ( DefaultMutableTreeNode TreeNode, String Category ) {
		
		System.out.println( this.getClass().toString()+" Add_ParentCategory Category="+Category );
		
		DefaultMutableTreeNode category = new DefaultMutableTreeNode("Books for Java Programmers 2");
		TreeNode.add(category);
		Add_Node( TreeNode, "Books for Java Programmers 3" );
		
		for ( int X = 0 ; X < 3 ; X++ ) {
			DefaultMutableTreeNode category2 = new DefaultMutableTreeNode("Books for Java Programmers X="+X);
			TreeNode.add(category2);
		}
		
		Object_DropshipItemtype[] Itemtypes = Class_Controller.Get_Itemtypes_Objects();
		System.out.println( this.getClass().toString()+" Add_ParentCategory Itemtypes.length="+Itemtypes.length );
		for ( int Y = 0 ; Y < Itemtypes.length ; Y++ ) {
			DefaultMutableTreeNode category2 = new DefaultMutableTreeNode("Books for Java Programmers Y="+Y);
			TreeNode.add(category2);
		}
		for ( int B = 0 ; B < Itemtypes.length ; B++ ) {
			if ( Itemtypes[B] != null ) {
				if ( Itemtypes[B].Dropship_ParentCategory != null ) {
					
					TreeNode.add(category);
					DefaultMutableTreeNode category2 = new DefaultMutableTreeNode("Books for Java Programmers "+B);
					TreeNode.add(category2);
					Add_Node( TreeNode, "Books for Java Programmers "+B );
					Add_Node( TreeNode, "Books for Java Programmers X" );

					if ( Itemtypes[B].Dropship_ParentCategory.equalsIgnoreCase( Category ) ) {
						//System.out.println( this.getClass().toString()+" Add_ParentCategory B="+B+" Itemtypes[B].ParentCategory="+Itemtypes[B].ParentCategory );
						DefaultMutableTreeNode NewNode = new DefaultMutableTreeNode ( Itemtypes[B].Dropship_Category );
						//System.out.println( this.getClass().toString()+" Add_ParentCategory B="+B+" TreeNode="+TreeNode+" NewNode="+NewNode );

						TreeNode.add ( NewNode );
						//Add_ItemType ( NewNode, Itemtypes[B].ParentCategory, Itemtypes[B].Category );
					}
				}
			}
		}
		
	}
	
	public void Add_Node( DefaultMutableTreeNode ParentNode, String Content ) {
		DefaultMutableTreeNode category = new DefaultMutableTreeNode( Content );
		ParentNode.add(category);
	}
	/*
    private static void createAndShowGUI() {
        if (useSystemLookAndFeel) {
            try {
                UIManager.setLookAndFeel(
                    UIManager.getSystemLookAndFeelClassName());
            } catch (Exception e) {
                System.err.println("Couldn't use system look and feel.");
            }
        }

        //Create and set up the window.
        JFrame frame = new JFrame("TreeDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Add content to the window.
        frame.add( new TreeDemo( Class_Controller ) );

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        //Schedule a job for the event dispatch thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }*/
}