package Off;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;

import Control.Controller;
import Itemtypes.Object_Itemtype;

public class Panel_ItemTypeTree extends JPanel implements TreeSelectionListener {

	private static final long		serialVersionUID		= 1L;

	public Controller					Class_Controller;

	public JPanel							TotalPanel;
	public JScrollPane						TreeScrollPane;

	public JTree							ItemTypeTree;
	public DefaultMutableTreeNode			TopNode;

	int								Kategori_Category_Nr;
	DefaultMutableTreeNode[]		Kategori_Category	= new DefaultMutableTreeNode[900];
	int								Kategori_ParentCategory_Nr;
	DefaultMutableTreeNode[]		Kategori_ParentCategory			= new DefaultMutableTreeNode[9000];
	private int						ItemType_Nr;
	DefaultMutableTreeNode[]		ItemTypeNode			= new DefaultMutableTreeNode[9000];

	public ItemTypeInNode					SelectedNodeClass;
	private DefaultMutableTreeNode			SelectedNodeObject;
	private String							SelectedNodeType;
	public String							Selected_Category;
	public String							Selected_ParentCategory;

	public boolean							Ready					= false;

	public Panel_ItemTypeTree ( Controller Class_Controller ) {
		super ( new GridLayout ( 1, 0 ) );
		this.Class_Controller = Class_Controller;
		System.out.println( this.getClass().toString()+" created" );

		for ( int A = 0 ; A < this.Kategori_Category.length ; A++ ) {
			this.Kategori_Category[A] = new DefaultMutableTreeNode ( );
		}
		for ( int A = 0 ; A < this.Kategori_ParentCategory.length ; A++ ) {
			this.Kategori_ParentCategory[A] = new DefaultMutableTreeNode ( );
		}
		for ( int A = 0 ; A < this.ItemTypeNode.length ; A++ ) {
			this.ItemTypeNode[A] = new DefaultMutableTreeNode ( );
		}
	}

	public void Startup ( ) {

		this.TopNode = new DefaultMutableTreeNode ( "Item types" );
		CreateTree ( );

		this.TotalPanel = new JPanel ( );

		this.ItemTypeTree = new JTree ( this.TopNode );
		this.ItemTypeTree.getSelectionModel ( ).setSelectionMode ( TreeSelectionModel.SINGLE_TREE_SELECTION );
		this.ItemTypeTree.addTreeSelectionListener ( this );

		this.TreeScrollPane = new JScrollPane ( this.ItemTypeTree );

		Dimension minimumSize = new Dimension ( 50, 50 );
		this.TreeScrollPane.setMinimumSize ( minimumSize );
		this.TotalPanel.setMinimumSize ( minimumSize );
		this.TreeScrollPane.setPreferredSize ( new Dimension ( 250, 200 ) );
		this.TotalPanel.setPreferredSize ( new Dimension ( 250, 200 ) );

		this.TotalPanel.add ( this.TreeScrollPane );
		add ( this.TotalPanel );
		this.Ready = true;
	}

	public void valueChanged ( TreeSelectionEvent e ) {
		
		this.SelectedNodeObject = ( DefaultMutableTreeNode ) this.ItemTypeTree.getLastSelectedPathComponent ( );
		this.SelectedNodeType = null;
		this.SelectedNodeClass = null;
		if ( this.SelectedNodeObject != null ){
			//System.out.println ( "Node: " + SelectedNodeObject+" Leaf="+SelectedNodeObject.isLeaf ( ));
			Object nodeInfo = this.SelectedNodeObject.getUserObject ( );
			System.out.println ( "SelectedNodeObject="+SelectedNodeObject+" nodeInfo="+nodeInfo );
			if ( this.SelectedNodeObject.isLeaf ( ) ) {
				this.SelectedNodeType = "Name";
				this.SelectedNodeClass = ( ItemTypeInNode ) nodeInfo;
				//ShowItemTypeInfo ( this.SelectedNodeClass.Name );
				this.Selected_Category = this.SelectedNodeClass.NodeContent.Category;
				this.Selected_ParentCategory = this.SelectedNodeClass.NodeContent.ParentCategory;
			} else {
				this.SelectedNodeType = null;
				this.Selected_Category = null;
				this.Selected_ParentCategory = null;

				for ( int A = 0 ; A < this.Kategori_Category.length ; A++ ) {
					if ( this.Kategori_Category[A].toString ( ) != null ) {
						if ( this.Kategori_Category[A].equals ( this.SelectedNodeObject ) ) {
							this.SelectedNodeType = "Category";
							this.Selected_Category = this.Kategori_Category[A].toString ( );
							this.Selected_ParentCategory = null;
						} else {
							if ( this.Kategori_Category[A].isNodeDescendant ( this.SelectedNodeObject ) ) {
								this.Selected_Category = this.Kategori_Category[A].toString ( );
							}
						}
					}
				}
				for ( int A = 0 ; A < this.Kategori_ParentCategory.length ; A++ ) {
					if ( this.Kategori_ParentCategory[A].toString ( ) == null ) {
					} else {
						if ( this.Kategori_ParentCategory[A].toString ( ).equals ( this.SelectedNodeObject.toString ( ) ) ) {
							this.SelectedNodeType = "ParentCategory";
							this.Selected_ParentCategory = this.Kategori_ParentCategory[A].toString ( );
						} else {
							if ( this.Kategori_ParentCategory[A].isNodeDescendant ( this.SelectedNodeObject ) ) {
								this.Selected_ParentCategory = this.Kategori_ParentCategory[A].toString ( );
							}
						}
					}
				}
			}
			this.Class_Controller.Command_ItemtypeTree_Selection ( Selected_Category );
		}
		
	}

	public class ItemTypeInNode {

		public Object_Itemtype	NodeContent;
		public String			Name;

		public ItemTypeInNode ( Object_Itemtype Spot ) {
			this.NodeContent = Spot;
			this.Name = Spot.Category;
		}

		@Override
		public String toString ( ) {
			return this.Name;
		}
	}

	private void CreateTree ( ) {
		System.out.println ( "--- panel drop spot setting up tree" );
		Add_ParentCategory ( this.TopNode, "home" );

		/*//fjerner tomme kategorier
		for ( int A = 1 ; A < this.Kategori_ParentCategory.length ; A++ ) {
			if ( this.Kategori_ParentCategory[A].toString ( ) != null ) {
				if ( this.Kategori_ParentCategory[A].getChildCount ( ) == 0 ) {
					this.Kategori_ParentCategory[A].removeFromParent ( );
				}
			}
		}
		for ( int A = 1 ; A < this.Kategori_Category.length ; A++ ) {
			if ( this.Kategori_Category[A].toString ( ) != null ) {
				if ( this.Kategori_Category[A].getChildCount ( ) == 0 ) {
					this.Kategori_Category[A].removeFromParent ( );
				}
			}
		}*/
	}

	public void Add_ParentCategory ( DefaultMutableTreeNode TreeNode, String Category ) {
		System.out.println( this.getClass().toString()+" Add_ParentCategory Category="+Category );
		Object_Itemtype[] Itemtypes = Class_Controller.Get_Itemtypes_Objects();
		
		for ( int B = 0 ; B < Itemtypes.length ; B++ ) {
			if ( Itemtypes[B] != null ) {
				if ( Itemtypes[B].ParentCategory != null ) {
					if ( Itemtypes[B].ParentCategory.equalsIgnoreCase( Category ) ) {
						
						boolean Added = false;
						for ( int C = 0 ; C < Kategori_ParentCategory_Nr ; C++ ) {
							if ( Kategori_ParentCategory[C] != null  ) {
								if ( Kategori_ParentCategory[C].equals( Itemtypes[B].Category ) ) {
									Added = true;
								}
							}
						}
						if ( Added == false ) {
							//System.out.println( this.getClass().toString()+" Add_ParentCategory B="+B+" Itemtypes[B].ParentCategory="+Itemtypes[B].Category );
							this.Kategori_ParentCategory_Nr++;
							this.Kategori_ParentCategory[this.Kategori_ParentCategory_Nr] = new DefaultMutableTreeNode ( Itemtypes[B].Category );
							TreeNode.add ( this.Kategori_ParentCategory[this.Kategori_ParentCategory_Nr] );
							Add_ParentCategory ( this.Kategori_ParentCategory[this.Kategori_ParentCategory_Nr], Itemtypes[B].Category );
						}
						
					}
				}
			}
		}
		
	}

	public void SelectItemType ( int ItemTypeID ) { //selecte en node utifra drop spot ID lagret i item som vises.
		
		if ( this.Ready == true ) {
			if ( ItemTypeID == 0 ) {
				this.ItemTypeTree.setSelectionRow ( 0 );
			} else {
				for ( int F = 1 ; F <= this.ItemType_Nr ; F++ ) { //finn noden som representerer drop spot med ønsket ID
					if ( this.ItemTypeNode[F] != null ) {
						DefaultMutableTreeNode ProcessedNode = this.ItemTypeNode[F];
						Object nodeInfo = ProcessedNode.getUserObject ( );
						ItemTypeInNode NodeClassObject = ( ItemTypeInNode ) nodeInfo;
						if ( NodeClassObject.NodeContent.HomePage.equals( ItemTypeID ) ) { //fant drop spot lagret på item
							TreeNode[] NodePath1 = ProcessedNode.getPath ( );
							TreePath NodePath2 = new TreePath ( NodePath1 );
							this.ItemTypeTree.setSelectionPath ( NodePath2 );
						}
					}
				}
			}
		}
		
	}
}
