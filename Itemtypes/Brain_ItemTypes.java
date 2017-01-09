package Itemtypes;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;

import Control.Controller;
import Dropshippers.Object_Dropshipper;
import Interfaces.Interface_Itemtypes;
import Offers.Object_Product_Offer;
import Searching.Object_SearchJob;

public class Brain_ItemTypes implements Interface_Itemtypes {
	
	Controller Class_Controller;
	
	String ItemtypeSettingsFilnavn = "ItemtypeSettings.snu";
	
	Object_DropshipItemtype[]	ItemtypeList;
	//Object_DropshipItemtype		Selected_itemtype;
	
	boolean Pause = false;
	
	String			Password;
	String 			UserShop;

	public Brain_ItemTypes( Controller Class_Controller ) {
		this.Class_Controller = Class_Controller;
		
	}
	
	private void Itemtypes_Startup( Object_Dropshipper[] Dropshippers ) throws Exception {
		//System.out.println( this.getClass().toString()+" Itemtypes_Startup" );
		ItemtypeList = new Object_DropshipItemtype[200];
		
		for ( int X = 0 ; X < Dropshippers.length ; X++ ) {
			if ( Dropshippers[X] != null ) {
				Object_DropshipItemtype[] DroppshippersItemtypes = Dropshippers[X].Get_Itemtypes();
				for ( int Y = 0 ; Y < DroppshippersItemtypes.length ; Y++ ) {
					if ( DroppshippersItemtypes[Y] != null ) {
						Insert_New_Itemtype( DroppshippersItemtypes[Y].Dropship_Category, DroppshippersItemtypes[Y].Dropship_ParentCategory, DroppshippersItemtypes[Y].Dropship_HomePage, DroppshippersItemtypes[Y].Norsk_Subject, false );
					}
				}
			}
		}
		
		LoadItemTypeSettings();
	}
	
	public void Itemtypes_Startup( Object_Dropshipper Dropshipper ) throws Exception {
		//System.out.println( this.getClass().toString()+" Itemtypes_Startup" );
		if ( Dropshipper == null ) {
			return;
		}
		ItemtypeList = new Object_DropshipItemtype[200];
		
		Object_DropshipItemtype[] DroppshippersItemtypes = Dropshipper.Get_Itemtypes();
		for ( int Y = 0 ; Y < DroppshippersItemtypes.length ; Y++ ) {
			if ( DroppshippersItemtypes[Y] != null ) {
				Insert_New_Itemtype( DroppshippersItemtypes[Y].Dropship_Category, DroppshippersItemtypes[Y].Dropship_ParentCategory, DroppshippersItemtypes[Y].Dropship_HomePage, DroppshippersItemtypes[Y].Norsk_Subject, false );
			}
		}
		
		LoadItemTypeSettings();
	}
	
	public void Insert_New_Itemtype( String Category, String ParentCategory, String Homepage, String Subject, boolean Enabled ) {
		//System.out.println( this.getClass().toString()+" Insert_New_Itemtype A Category="+Category+" ParentCategory="+ParentCategory+" Homepage="+Homepage );
		//boolean Add = true;
		for ( int X = 0 ; X < ItemtypeList.length ; X++ ) {
			if ( ItemtypeList[X] == null ) {
				//System.out.println( this.getClass().toString()+" Insert_New_Itemtype B Adder item typen i tom slot #"+X );
				ItemtypeList[X] = new Object_DropshipItemtype( Category, ParentCategory, Homepage, Subject );
				ItemtypeList[X].Enabled = Enabled;
				//System.out.println( this.getClass().toString()+" Insert_New_Itemtype C Adder item typen: Category="+Category+" X="+X );
				return;
			} else {
				if ( ItemtypeList[X].Dropship_ParentCategory.equalsIgnoreCase(ParentCategory) == true ) {
					if ( ItemtypeList[X].Dropship_Category.equalsIgnoreCase(Category) == true ) {
						return;
					}
				}
			}
		}
	}
	
	public void LoadItemTypeSettings() throws Exception {
		//System.out.println( this.getClass().toString()+" LoadItemTypeSettings" );
		try {
			
			File filen = new File ( ItemtypeSettingsFilnavn );
			if ( !filen.exists() ) {
				return;
			}
			FileInputStream fstream = new FileInputStream ( filen );
			DataInputStream in = new DataInputStream ( fstream );
			int Teller = 0;
			Pause = true;
			String Innlest = in.readLine ( );
			while ( Innlest != null  ) {
				//System.out.println( "Innlest A="+Innlest );
				
				boolean Found = false;
				Teller = -1;
				while ( Found == false ) {
					try {
						Teller ++;
						if ( ItemtypeList != null ) {
							if ( ItemtypeList[Teller] != null ) {
								//System.out.println( this.getClass().toString()+" LoadItemTypes sammenligner "+ItemtypeList[Teller].Category+" vs "+Innlest );
								if ( ItemtypeList[Teller].Dropship_Category.toLowerCase().equals( Innlest.toLowerCase() ) ) {
									Found = true;
									ItemtypeList[Teller].Enabled = true;
									
									//aktiver i både GUI og brain
									//System.out.println( this.getClass().toString()+" LoadItemTypes skal aktivere item type "+ItemtypeList[Teller].Category );
									Class_Controller.ActivateItemType( ItemtypeList[Teller].Dropship_Category, true );
		
								} else {
									
								}
							} else {
								//System.out.println( this.getClass().toString()+" LoadItemTypes ikke flere item types å sammenligne mot, item typen finnes ikke lenger: "+Innlest );
								//ikke flere item types å sammenligne mot, item typen finnes ikke lenger
								Found = true;
								Insert_New_Itemtype( Innlest, "", "", "", true );
							}
						}
					} catch ( Exception e ) {
						Found = true;
						System.err.println( this.getClass().toString()+" LoadItemTypes" );
						Class_Controller.ReportError(e, this.getClass().toString()+" LoadItemTypeSettings" );
					}
				}
				Innlest = in.readLine ( );
				//System.out.println( "Innlest B="+Innlest );
			}
			Pause = false;
			in.close ( );
			//Class_Controller.AddProgressMessage( "Loaded item type settings" );
			//System.out.println( this.getClass().toString()+" LoadItemTypes 2 Pause="+Pause );
		} catch ( NullPointerException e ) {
			Class_Controller.ReportError(e, this.getClass().toString()+" LoadItemTypeSettings" );
			Class_Controller.ReportError(e, this.getClass().toString()+" LoadItemTypeSettings" );
		} catch ( Exception e ) {
			System.err.println( this.getClass().toString()+" LoadItemTypes finner ikke settingsfilen" );
			Class_Controller.ReportError(e, this.getClass().toString()+" LoadItemTypeSettings" );
		}
	}
	
	public void SaveSettings ( ) throws Exception {
		if ( Pause == true ) {
			return;
		}
		//System.out.println( this.getClass().toString()+" SaveSettings" );
		try {
			PrintStream utfil;
			File slettfil2 = new File ( ItemtypeSettingsFilnavn );
			slettfil2.delete ( );//tømmer fila
			FileOutputStream appendFilen = new FileOutputStream ( ItemtypeSettingsFilnavn, true );
			utfil = new PrintStream ( appendFilen );
			for ( int A = 0 ; A < ItemtypeList.length ; A++ ) {
				if ( ItemtypeList[A] != null ) {
					if ( ItemtypeList[A].Enabled == true ) {
						utfil.println ( ItemtypeList[A].Dropship_Category );
					}
				}
			}
			utfil.close ( );
		} catch ( Exception T ) {
			Class_Controller.ReportError(T, this.getClass().toString()+" SaveSettings" );
		}
	}

	/*public Object_DropshipItemtype Get_SelectedItemtype() {
		return Selected_itemtype;
	}*/

	/*public void Set_Itemtype( String Selected ) {
		for ( int X = 0 ; X < Itemtype.length ; X++ ) {
			if ( Itemtype[X] != null ) {
				if ( Itemtype[X].Category.equals( Selected )) {
					Selected_itemtype = Itemtype[X];
				}
			}
		}
	}*/

	public int CheckRelationValue_Job(Object_SearchJob jobb) throws Exception {
		//System.out.println( this.getClass().toString()+" CheckRelationValue_Job A "+jobb.TargetOffer.Get_Adresse().Get_Adresse().toString() );

		if ( jobb == null ) {
			System.out.println( this.getClass().toString()+" CheckRelationValue_Job jobb="+jobb );
			return 0;
		}
		if ( jobb.TargetOffer == null ) {
			System.out.println( this.getClass().toString()+" CheckRelationValue_Job jobb.TargetOffer="+jobb.TargetOffer );
			return 0;
		}
		//System.out.println( this.getClass().toString()+" CheckRelationValue_Job B "+jobb.TargetOffer.Get_Adresse().Get_Adresse().toString() );
		int Value = 0;
		if ( this.Class_Controller.Get_SelectedSearchtype( this.getClass().toString()+" CheckRelationValue_Job" ).equals("Full crawl") == true ) {
			Value = CheckRelationValue_Job_FullCrawl( jobb );
		} else if ( this.Class_Controller.Get_SelectedSearchtype( this.getClass().toString()+" CheckRelationValue_Job" ).equals("Category") == true ) {
			Value = CheckRelationValue_Job_Category( jobb );
		} else if ( this.Class_Controller.Get_SelectedSearchtype( this.getClass().toString()+" CheckRelationValue_Job" ).equals("Shop scan") == true ) {
			Value = CheckRelationValue_Job_Shop( jobb );
		}
		if ( jobb.TargetOffer.Get_Adresse().Get_AcceptedCategory() == true ) {
			Value = Value + 30000; //random, utslagsgivende tall
		}
		if ( jobb.TargetOffer.Get_Adresse().OfferSaved == true ) {
			Value = Value + 30000; //random, utslagsgivende tall
		}
		
		//System.out.println( this.getClass().toString()+" CheckRelationValue_Job C "+jobb.TargetOffer.Get_Adresse().Get_Adresse().toString()+" Value="+Value );
		return Value;
	}

	public int CheckRelationValue_Job_Category( Object_SearchJob jobb ) {
		int HighestValue = 0;
		
		for ( int X = 0 ; X < ItemtypeList.length ; X++ ) {
			if ( ItemtypeList[X] != null ) {
				if ( ItemtypeList[X].Enabled == true ) {
					int CurrentValue = 0;

					if ( jobb.TargetOffer.Category != null ) {
						jobb.TargetOffer.Category = jobb.TargetOffer.Category.replaceAll( "&amp;", "&");
						if ( jobb.TargetOffer.Category.indexOf( ItemtypeList[X].Dropship_Category.toLowerCase() ) > -1 ) { //100% riktig std
							CurrentValue = CurrentValue + 10000;
						}
					}
					if ( jobb.TargetOffer.Crumbs != null ) {
						if ( jobb.TargetOffer.Crumbs.indexOf( ItemtypeList[X].Dropship_Category.toLowerCase() ) > -1 ) { //befinner seg i en subkategori av valgt kategori
							CurrentValue = CurrentValue + 10000;
						}
					}
					if ( jobb.TargetOffer.ParentCategory != null ) {
						if ( jobb.TargetOffer.ParentCategory.indexOf( ItemtypeList[X].Dropship_ParentCategory.toLowerCase() ) > -1 ) { //befinner seg i beslektet kategori
							CurrentValue = CurrentValue + 3000;
						}
					}
					if ( jobb.TargetOffer.Crumbs != null ) {
						if ( jobb.TargetOffer.Crumbs.indexOf( ItemtypeList[X].Dropship_ParentCategory.toLowerCase() ) > -1 ) { //befinner seg i en subkategori innen beslektet kategori
							CurrentValue = CurrentValue + 2500;
						}
					}
					
					if ( CurrentValue > HighestValue ) {
						HighestValue = CurrentValue;
					}
					
				}
			}
		}

		//System.out.println( this.getClass().toString()+" CheckRelationValue_Job_Category C "+jobb.TargetOffer.Get_Adresse().Get_Adresse().toString()+" Value="+Value );
		//System.out.println( this.getClass().toString()+" CheckRelationValue_Job_Category C Category="+jobb.TargetOffer.Category+" ParentCategory="+jobb.TargetOffer.ParentCategory+" crumbs="+jobb.TargetOffer.Crumbs );
		return HighestValue;
	}
	
	public int CheckRelationValue_Job_FullCrawl( Object_SearchJob jobb ) {
		int HighestValue = 0;
		
		for ( int X = 0 ; X < ItemtypeList.length ; X++ ) {
			if ( ItemtypeList[X] != null ) {
				if ( ItemtypeList[X].Enabled == true ) {
					
					int CurrentValue = 0;
		
					if ( jobb.TargetOffer.Category != null ) {
						if ( jobb.TargetOffer.Category.indexOf( ItemtypeList[X].Dropship_Category.toLowerCase() ) > -1 ) { //100% riktig std
							CurrentValue = CurrentValue + 10000;
						}
					}
					if ( jobb.TargetOffer.Crumbs != null ) {
						if ( jobb.TargetOffer.Crumbs.indexOf( ItemtypeList[X].Dropship_Category.toLowerCase() ) > -1 ) { //befinner seg i en subkategori av valgt kategori
							CurrentValue = CurrentValue + 10000;
						}
					}
					if ( jobb.TargetOffer.Head != null ) {
						if ( jobb.TargetOffer.Head.indexOf( ItemtypeList[X].Dropship_Category.toLowerCase() ) > -1 ) {
							CurrentValue = CurrentValue + 5000;
						}
					}
					if ( jobb.TargetOffer.ImageText != null ) {
						if ( jobb.TargetOffer.ImageText.indexOf( ItemtypeList[X].Dropship_Category.toLowerCase() ) > -1 ) {
							CurrentValue = CurrentValue + 5000;
						}
					}
					if ( jobb.TargetOffer.Meta != null ) {
						if ( jobb.TargetOffer.Meta.indexOf( ItemtypeList[X].Dropship_Category.toLowerCase() ) > -1 ) {
							CurrentValue = CurrentValue + 5000;
						}
					}
					if ( jobb.TargetOffer.ParentCategory != null ) {
						if ( jobb.TargetOffer.ParentCategory.indexOf( ItemtypeList[X].Dropship_ParentCategory.toLowerCase() ) > -1 ) { //befinner seg i beslektet kategori
							CurrentValue = CurrentValue + 3000;
						}
					}
					if ( jobb.TargetOffer.Crumbs != null ) {
						if ( jobb.TargetOffer.Crumbs.indexOf( ItemtypeList[X].Dropship_ParentCategory.toLowerCase() ) > -1 ) { //befinner seg i en subkategori innen beslektet kategori
							CurrentValue = CurrentValue + 2500;
						}
					}
					if ( jobb.TargetOffer.Head != null ) {
						if ( jobb.TargetOffer.Head.indexOf( ItemtypeList[X].Dropship_ParentCategory.toLowerCase() ) > -1 ) {
							CurrentValue = CurrentValue + 2000;
						}
					}
					if ( jobb.TargetOffer.ImageText != null ) {
						if ( jobb.TargetOffer.ImageText.indexOf( ItemtypeList[X].Dropship_ParentCategory.toLowerCase() ) > -1 ) {
							CurrentValue = CurrentValue + 2000;
						}
					}
					if ( jobb.TargetOffer.Meta != null ) {
						if ( jobb.TargetOffer.Meta.indexOf( ItemtypeList[X].Dropship_ParentCategory.toLowerCase() ) > -1 ) {
							CurrentValue = CurrentValue + 2000;
						}
					}
					if ( jobb.TargetOffer.Description != null ) {
						if ( jobb.TargetOffer.Description.indexOf( ItemtypeList[X].Dropship_Category.toLowerCase() ) > -1 ) {
							CurrentValue = CurrentValue + 1500;
						}
					}
					if ( jobb.TargetOffer.Description != null ) {
						if ( jobb.TargetOffer.Description.indexOf( ItemtypeList[X].Dropship_ParentCategory.toLowerCase() ) > -1 ) {
							CurrentValue = CurrentValue + 1000;
						}
					}
					
					if ( CurrentValue > HighestValue ) {
						HighestValue = CurrentValue;
					}
		
				}
			}
		}
		
		return HighestValue;
	}
	
	private int CheckRelationValue_Job_Shop(Object_SearchJob jobb) {
		int HighestValue = CheckRelationValue_Job_FullCrawl( jobb );
		if ( this.Class_Controller.Get_SelectedSearchtype( this.getClass().toString()+" CheckRelationValue_Job_Shop" ).equals("Store scan") == true ) {
			
			if ( Class_Controller.IsAcceptedSeller( jobb.TargetOffer.Seller ) == true ) {
				HighestValue = HighestValue + 30000; //random høyt, utslagsgivende tall
			}
		}
		return HighestValue;
	}

	public int CheckRelationValue_URL( String Adresse ) {
		int HighestValue = 0;
		
		for ( int X = 0 ; X < ItemtypeList.length ; X++ ) {
			if ( ItemtypeList[X] != null ) {
				if ( ItemtypeList[X].Enabled == true ) {
					
					int CurrentValue = 0;
		
					String Test = ItemtypeList[X].Dropship_Category.toLowerCase();
					Test = Test.replaceAll("&", "");
					Test = Test.replaceAll(" ", "-");
					Test = Test.replaceAll("--", "-");
					if ( Adresse.indexOf( Test ) > -1 ) {
						CurrentValue = CurrentValue + 5000;
					}
					Test = ItemtypeList[X].Dropship_Category.toLowerCase();
					Test = Test.replaceAll("&", "");
					Test = Test.replaceAll(" ", "");
					if ( Adresse.indexOf( Test ) > -1 ) {
						CurrentValue = CurrentValue + 5000;
					}
					if ( ItemtypeList[X].Dropship_ParentCategory.equals("Home") == false ) {
						Test = ItemtypeList[X].Dropship_ParentCategory.toLowerCase();
						Test = Test.replaceAll("&", "");
						Test = Test.replaceAll(" ", "");
						if ( Adresse.indexOf( Test ) > -1 ) {
							CurrentValue = CurrentValue + 5000;
						}
						Test = ItemtypeList[X].Dropship_ParentCategory.toLowerCase();
						Test = Test.replaceAll("&", "");
						Test = Test.replaceAll(" ", "-");
						Test = Test.replaceAll("--", "-");
						if ( Adresse.indexOf( Test ) > -1 ) {
							CurrentValue = CurrentValue + 5000;
						}
					}
					
					if ( CurrentValue > HighestValue ) {
						HighestValue = CurrentValue;
					}
				}
			}
		}
		//System.out.println( this.getClass().toString()+" CheckRelationValue_URL E "+Adresse+" Value="+Value );
		return HighestValue;
	}
	
	public boolean ItemTypeAccepted( Object_Product_Offer Produkt, String category, String parentCategory, String crumbs ) {
		boolean Inkludert = false;
		for ( int X = 0 ; X < ItemtypeList.length ; X++ ) {
			if ( ItemtypeList[X] != null ) {
				boolean Check = TestItemtype( category, parentCategory, crumbs, ItemtypeList[X], this.getClass().toString()+" ItemTypeAccepted" );
				if ( Check == true ) {
					Inkludert = true;
					if ( ItemtypeList[X].Enabled == true ) {
						Produkt.Subject = ItemtypeList[X].Norsk_Subject;
						//System.out.println( this.getClass().toString()+" ItemTypeAccepted Aksepterer produkt. Produkttype="+category+"<-"+parentCategory );
						return true;
					} else {
						//System.out.println( this.getClass().toString()+" ItemTypeAccepted vil ikke ha produkt. Produkttype="+category+"<-"+parentCategory+" enabled="+ItemtypeList[X].Enabled+" "+ItemtypeList[X].Category );
						//return false;
					}
				}
			}
		}
		if ( Inkludert == false ) {
			if ( category != null ) {
				if ( ( parentCategory != null ) && ( parentCategory.equals( "\" >product" ) ) ) {
				} else {
					//System.out.println( "->"+this.getClass().toString()+" ItemTypeAccepted rejecter produkt. Produkttype="+category+"<-"+parentCategory+" crumbs="+crumbs );
				}
			}
		}
		return false;
	}
	
	public boolean TestItemtype( String category, String parentCategory, String crumbs, Object_DropshipItemtype itemtype, String Source ) {
		crumbs = crumbs.replaceAll( "&amp;", "&" );
		if ( category == null ) {
			return false;
		}
		if ( parentCategory == null ) {
			return false;
		}
		
		if ( category.equalsIgnoreCase( itemtype.Dropship_Category ) ) {
			//System.out.println( this.getClass().toString()+" TestItemtype aksepterer item. valgt kategori="+itemtype.Category+" item kategori="+category );
			return true;
		}
		if ( crumbs.toLowerCase().indexOf( itemtype.Dropship_Category.toLowerCase() ) > -1 ) {
			//System.out.println( this.getClass().toString()+" TestItemtype aksepterer item. valgt kategori="+itemtype.Category+" item crumbs="+crumbs );
			return true;
		}
		if ( parentCategory.equalsIgnoreCase( itemtype.Dropship_Category ) ) {
			//System.out.println( this.getClass().toString()+" TestItemtype aksepterer item. valgt kategori="+itemtype.Category+" item par.kategori="+parentCategory );
			return true;
		}
		//System.out.println( this.getClass().toString()+" TestItemtype rejecter item. valgt kategori="+itemtype.Category+" item kategori="+category );
		return false;
	}

	public boolean Itemtypes_ActivateItemType( String label, boolean selected ) throws Exception {
		//System.out.println( this.getClass().toString()+" ActivateItemType label="+label );
		for ( int X = 0 ; X < ItemtypeList.length ; X++ ) {
			if ( ItemtypeList[X] != null ) {
				//System.out.println( this.getClass().toString()+" ActivateItemType sammenligner mot Itemtype[X].Category="+ItemtypeList[X].Category+" X="+X );
				if ( ItemtypeList[X].Dropship_Category.equalsIgnoreCase( label ) ) {
					ItemtypeList[X].Enabled = selected;
					SaveSettings();
					return true;
				}
			}
		}
		return false;
	}

	public boolean Get_ItemtypeSelectionStatus( String category ) {
		//System.out.println( this.getClass().toString()+" Get_ItemtypeSelectionStatus category="+category );
		try {
			for ( int X = 0 ; X < ItemtypeList.length ; X++ ) {
				if ( ItemtypeList[X] != null ) {
					if ( ItemtypeList[X].Dropship_Category.equalsIgnoreCase( category ) ) {
						//System.out.println( this.getClass().toString()+" Get_ItemtypeSelectionStatus fant kategorien. Enabled="+ItemtypeList[X].Enabled );
						return ItemtypeList[X].Enabled;
					}
				}
			}
		} catch ( Exception e ) {
			
		}
		//System.out.println( this.getClass().toString()+" Get_ItemtypeSelectionStatus Rejecting, fant ikke kategorien. category="+category );
		return false;
	}

	public void Set_Setting_Password(String user) {
		Password = user;
	}
	
	public String Get_Settings_Password() {
		return Password;
	}
	
	public void Set_Setting_UserShop(String user) {
		UserShop = user;
	}

	public String Get_Settings_UserShop() {
		return UserShop;
	}

}
