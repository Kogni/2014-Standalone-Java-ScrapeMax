package Control;

import java.io.File;
import java.io.IOException;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.Date;

import javax.swing.JFrame;

import Dropshippers.Brain_Dropshippers;
import Dropshippers.Object_Dropshipper;
import Itemtypes.Brain_ItemTypes;
import Itemtypes.Object_DropshipItemtype;
import Offers.Brain_Offers;
import Offers.Object_Product_Offer;
import Saving.Brain_Saving;
import Searching.Object_SearchJob;
import URLs.Brain_URLs;
import URLs.Object_TreeMap;
import URLs.Object_TreeMap_String;
import URLs.Object_TreeMap_int;
import URLs.Object_URL;
import View.Frame_MainWindow;
import View.Frame_PasswordCheck;
import View.Object_DialogPopup;

public class Controller implements UncaughtExceptionHandler {
	
	String						UserPassword;
	
	public ErrorHandler			Class_ErrorHandler;
	
	API							Class_API;

	Frame_PasswordCheck Class_Frame_PasswordCheck;

	TimeKeeper Class_TimeKeeper;
	int Timer_GUIUpdate = 0;
	int Timer_Restart = 0;
	int Timer_URLfind = 0;
	int Timer_Identify = 0;
	
	public boolean AllowWorking = false;
	public Double Currency = 0.0;
	
	public Controller() throws Exception {
		
		Thread.setDefaultUncaughtExceptionHandler(this);
		System.out.println( this.getClass().toString()+" constructor" );
		
		Class_API = new API(this);

		Class_Frame_PasswordCheck = new Frame_PasswordCheck( this );
		
		Startup();
	}
	
	public void Startup() throws Exception {
		//kjør en test ved startup, på hvilke dropshippers som er oppe og tilgjengelige
		//System.out.println( this.getClass().toString()+" Startup A" );
		//restart Brain_Searching for å tømme minnet
		Class_API.Dropshippers_Startup();
		Class_Frame_PasswordCheck.PasswordCheck();
	}
	
	public void OpenProgram( String User ) throws Exception {
		Class_API.LoadSettings( this.getClass().toString()+" OpenProgram 1" );
		if ( User.equals("") ) {
			User = Get_Settings_UserShop();
		}
		if ( User.equals("Larsenimport") ) {
			User = "pynting";
		}
		//System.out.println( this.getClass().toString()+" OpenProgram D user="+User );
		UserPassword = User;
		if ( User.equals("") == true ) { //programmet har auto-restartet, og ikke ennå funnet ut bruker
			//System.out.println( this.getClass().toString()+" OpenProgram User.equals() == true" );
		} else if ( User.equals("pynting") == false ) { //programmet er nystartet, og har bruker fra passord
			Date Idag = new Date();
			Date Utlopsfrist = new Date();
			Utlopsfrist.setYear( (2013-1900) ); //timeout-år - 1900
			Utlopsfrist.setMonth( (12-1) ); //faktisk maaned - 1
			Utlopsfrist.setDate( 03+7 ); //faktisk dato+7
			Utlopsfrist.setHours( 0 );
			Utlopsfrist.setMinutes( 0 );
			long TimeLeft = ( Utlopsfrist.getTime() - Idag.getTime() );
			System.out.println( this.getClass().toString()+" OpenProgram Days left to use: "+(TimeLeft/100/60/60/24) );
			/*if ( TimeLeft < 0 ) {
				new Object_DialogPopup( new JFrame ( ), "Trial over", 0 );
				System.exit(0);
			} else {
				//System.out.println( this.getClass().toString()+" OpenProgram Bruker og tidsfrist er godkjent A");
			}*/
		} else {
			//System.out.println( this.getClass().toString()+" OpenProgram E ser.equals(pynting) == true" );
		}
		
		Set_Setting_Password( User );

		Class_API.MainWindow_Startup();
		
		SetCurrentAction( "Waiting to start" );
		Class_API.Searching_Create( this.getClass().toString()+" RestartCycle" );
		Class_API.LoadSettings( this.getClass().toString()+" OpenProgram 2" );
		Class_API.Itemtypes_Startup( Class_API.Get_SelectedDropshipper( this.getClass().toString()+" OpenProgram 2" ) );
		
		//System.out.println( this.getClass().toString()+" OpenProgram etter settings" );
		RestartCycle();
		//System.out.println( this.getClass().toString()+" OpenProgram etter restartcycle" );
		
		File g = new File("Action log.txt");
		AllowWorking = true;
	}
	
	public void RestartCycle() throws Exception {
		//System.out.println( this.getClass().toString()+" RestartCycle" );
		//System.out.println( this.getClass().toString()+" total URLS="+this.Class_Frame_MainWindow.Get_TotalURLS() );
		SetCurrentAction( "Restarting search cycle" );

		Class_API.Searching_Create( this.getClass().toString()+" RestartCycle" );

		Class_API.URLs_Create();
		Class_API.Wholesalers_Create();
		Class_API.Offers_Create();
		AddProgressMessage( "Loading settings..." );
		Class_API.LoadSettings( this.getClass().toString()+" RestartCycle" );
		System.gc();
		//StartSearching( this.getClass().toString()+" RestartCycle" );
		//Class_API.LoadURLs_new();
		Class_API.Itemtypes_Startup( Class_API.Get_SelectedDropshipper( this.getClass().toString()+" RestartCycle" ) );
		
		StartSearching( this.getClass().toString()+" RestartCycle" );
	}
	
	public Object_Dropshipper Get_SelectedDropshipper( String Source ) {
		//System.out.println( this.getClass().toString()+" Get_SelectedDropshipper Source="+Source );
		return Class_API.Get_SelectedDropshipper( this.getClass().toString()+" Get_SelectedDropshipper "+Source );
	}
	
	public void UserCommand_StartSearching( ) throws Exception {
		//System.out.println( this.getClass().toString()+" UserCommand_StartSearching" );
		AllowWorking = false;
		//System.out.println( this.getClass().toString()+" UserCommand_StartSearching A Get_SelectedSearchtype="+Get_SelectedSearchtype() );
		if ( Get_Settings_UserShop() == null ) {
			AddProgressMessage( "Error: You must select user settings first" );
			return;
		}
		if ( Get_SelectedAutopricing() == null ) {
			AddProgressMessage( "Error: You must select autopricing settings first" );
			return;
		}
		if ( Get_SelectedDropshipper( this.getClass().toString()+" UserCommand_StartSearching" ) == null ) {
			AddProgressMessage( "Error: You must select a dropshipper first" );
			return;
		}
		if ( Get_SelectedSearchtype( this.getClass().toString()+" UserCommand_StartSearching" ) == null ) {
			AddProgressMessage( "Error: You must select a search type first" );
			return;
		}
		/*if ( Get_SelectedItemtype() == null ) {
			AddProgressMessage( "Error: You must select an item type first" );
			return;
		}*/
		AllowWorking = true;
		
		SetCurrentAction( "Starting search cycle" );
		//System.out.println( this.getClass().toString()+" UserCommand_StartSearching B Get_SelectedSearchtype="+Get_SelectedSearchtype() );
		//System.out.println( this.getClass().toString()+" UserCommand_StartSearching" );
		StartSearching( this.getClass().toString()+" UserCommand_StartSearching" );
		AddProgressMessage( "Starting search cycle" );
		//System.out.println( this.getClass().toString()+" UserCommand_StartSearching C Get_SelectedSearchtype="+Get_SelectedSearchtype() );
	}
	
	public void StartSearching( String Source ) throws Exception {
		//System.out.println( this.getClass().toString()+" StartSearching source="+Source );
		//System.out.println( this.getClass().toString()+" StartSearching A Get_SelectedSearchtype="+Get_SelectedSearchtype() );
		//AllowWorking = true;
		Class_API.GetCurrency();
		//Class_Brain_Searching.LoadURLs();
		Class_TimeKeeper = new TimeKeeper( this, 25 );
		Class_TimeKeeper.start();
		//System.out.println( this.getClass().toString()+" StartSearching B" );
		SetCurrentAction( "Started search cycle" );
		//System.out.println( this.getClass().toString()+" StartSearching C" );
		//System.out.println( this.getClass().toString()+" StartSearching B Get_SelectedSearchtype="+Get_SelectedSearchtype() );
	}

	public void UserCommand_StopSearching() throws Exception {
		AllowWorking = false;
		Class_TimeKeeper.stop();
		SetCurrentAction( "Stopped search cycle" );
		AddProgressMessage( "Stopped search cycle" );
	}
	
	public void TimeTick( ) throws Exception {
		//System.out.println( this.getClass().toString()+" TimeTick AllowWorking="+AllowWorking );
		if ( Get_SelectedDropshipper( this.getClass().toString()+" TimeTick" ) == null ) {
			AllowWorking = false;
		}
		if ( AllowWorking == true ) {
			//System.out.println( this.getClass().toString()+" TimeTick Get_SelectedSearchtype="+Get_SelectedSearchtype() );
			Class_API.RunThreads_Searching();
			
			Timer_Identify ++;
			if ( Timer_Identify > 10 ) { //25ms/tick, 1*25=25 ms
				Class_API.RunThreads_Offers();
				Timer_Identify = 0;
			}
			
			Timer_URLfind ++;
			if ( Timer_URLfind > 2 ) { //25ms/tick, 2*25=50 ms
				Class_API.RunThreads_URLfind();
				Timer_URLfind = 0;
			}
		}
		
		Timer_GUIUpdate++;
		if ( Timer_GUIUpdate > 1000 ) { //25ms/tick, 4*25=100ms=1 sec *60= 1 min
			if ( Class_API.Panel_URL_Exists() == true ) {
				//UpdateURLGUIList(); //alltid feil uansett
			}
			Timer_GUIUpdate = 0;
		}

	}

	public String[] Get_Searchtypes() {
		System.out.println( "- " + new Throwable().fillInStackTrace().getStackTrace()[0] + ") <- " + new Throwable().fillInStackTrace().getStackTrace()[1] + ")" );
		try {
			return Get_SelectedDropshipper( this.getClass().toString()+" Get_Searchtypes" ).Get_Searchtypes();
		} catch ( Exception T ) {
			return new String[1];
		}
	}

	public void Set_Setting_SaveType(String string) throws Exception {
		//System.out.println( this.getClass().toString()+" Set_Setting_SaveType" );
		Class_API.Set_Setting_SaveType( string );
		SetCurrentAction( "Changed save settings" );
	}

	public void Set_Setting_Searchtype( String string ) throws Exception {
		//System.out.println( this.getClass().toString()+" Set_Setting_Searchtype "+string );
		try {
			Class_API.Set_Searchtype( string );
			SetCurrentAction( "Changed search settings" );
		} catch ( Exception e ) {
			ReportError( e, this.getClass().toString()+" Set_Setting_Searchtype" );
		}
		//Class_API.AddItemypes();
		//Class_API.LoadItemTypeSettings();
	}

	public void AddProgressMessage( String Message ) throws Exception {
		this.Class_API.AddProgressMessage( Message );
		this.Class_API.PrintActionLog( Message );
	}

	public void UpdateURLGUI(Object_SearchJob hentetSide) throws Exception {
		//System.out.println( this.getClass().toString()+" UpdateURLGUI "+hentetSide.TargetOffer.Get_Adresse().Get_Adresse().toString() );
		Class_API.UpdateURLGUI( hentetSide );
		if ( hentetSide.TargetOffer.Get_Adresse().URLs_Finished == true && hentetSide.Get_Identify_Finished() == true ) {
			//Class_Brain_Searching.SaveURLToDisk( hentetSide.TargetOffer.Get_Adresse() );
		}
	}

	public void ReportError( Exception T, String Source ) throws Exception {
		Class_API.PrintErrorLog( T, Source );
		SetCurrentAction( "Error saved to log file" );
		AddProgressMessage( "ERROR saved to log file!" );
	}

	public void SearchJobProgressed( Object_SearchJob job, String Source ) throws Exception {
		Date Naa = new Date();
		//System.out.println( Naa.getHours()+":"+Naa.getMinutes()+":"+Naa.getSeconds()+" "+this.getClass().toString()+" SearchJobProgressed A "+job.TargetOffer.Get_Adresse().Get_Adresse().toString()+" "+job.TargetOffer.ImageText.length()+" source="+Source+" IsImagePage="+job.TargetOffer.Get_Adresse().IsImagePage );
		if ( job.Get_Identify_Finished() == true ) {
			//System.out.println( Naa.getHours()+":"+Naa.getMinutes()+":"+Naa.getSeconds()+" "+this.getClass().toString()+" SearchJobProgressed b "+job.TargetOffer.Get_Adresse().Get_Adresse().toString()+" "+job.TargetOffer.ImageText.length() );
			if ( isProductPage( job.TargetOffer.Get_Adresse().Get_Adresse().toString() ) == true ) {
				//System.out.println( Naa.getHours()+":"+Naa.getMinutes()+":"+Naa.getSeconds()+" "+this.getClass().toString()+" SearchJobProgressed c "+job.TargetOffer.Get_Adresse().Get_Adresse().toString()+" "+job.TargetOffer.ImageText.length()+" saved? "+job.TargetOffer.Get_Adresse().OfferSaved );
				SetCurrentAction( "New offer identified" );
				if ( job.TargetOffer.Get_Adresse().OfferSaved == false ) {
					//System.out.println( Naa.getHours()+":"+Naa.getMinutes()+":"+Naa.getSeconds()+" "+this.getClass().toString()+" SearchJobProgressed d "+job.TargetOffer.Get_Adresse().Get_Adresse().toString()+" "+job.TargetOffer.ImageText.length() );
					if ( job.TargetOffer.Get_Name().equals("") ) {
						//System.out.println( Naa.getHours()+":"+Naa.getMinutes()+":"+Naa.getSeconds()+" "+this.getClass().toString()+" SearchJobProgressed e1 "+job.TargetOffer.Get_Adresse().Get_Adresse().toString()+" "+job.TargetOffer.ImageText.length() );
						if ( job.TargetOffer.Description == null ) {
							//System.err.println( Naa.getHours()+":"+Naa.getMinutes()+":"+Naa.getSeconds()+" "+this.getClass().toString()+" SearchJobProgressed f1 "+job.TargetOffer.Get_Adresse().Get_Adresse().toString()+" "+job.TargetOffer.ImageText.length() );
							//job.Set_Identify_Finished( false, "null descr" );
							//job.Set_Identify_Started( false, "null descr" );
						} else {
							job.Finalize();
							//System.out.println( Naa.getHours()+":"+Naa.getMinutes()+":"+Naa.getSeconds()+" "+this.getClass().toString()+" SearchJobProgressed f2 "+job.TargetOffer.Get_Adresse().Get_Adresse().toString()+" "+job.TargetOffer.ImageText.length() );
							this.Class_API.PrintOffer( job.TargetOffer );
						}
						//System.out.println( this.getClass().toString()+" SearchJobProgressed intet navn. completecontent="+job.TargetOffer.Get_Adresse().CompleteContent.length() );
					} else {
						//System.out.println( Naa.getHours()+":"+Naa.getMinutes()+":"+Naa.getSeconds()+" "+this.getClass().toString()+" SearchJobProgressed e2" );
						this.Class_API.PrintOffer( job.TargetOffer );
					}
				}
			}
			//System.out.println( this.getClass().toString()+" SearchJobProgressed B "+job.Get_Adresse().toString() );
			
		}
	}

	public void SaveNewURL( Object_URL adresse ) throws Exception {
		//System.out.println( this.getClass().toString()+" SaveURL "+Adresse );
		SetCurrentAction( "Checking URL versus saved datas: "+adresse.Get_Adresse().toString() );
		//Class_API.Save_SearchJob( Adresse, relationValue );
		if ( Class_API.IsUrlSavedToDisk( adresse.Get_Adresse().toString() ) == true ) {
			return;
		}
		Class_API.Save_NewURL_Search( adresse, null );
		/*if ( isProductPage( adresse.Get_Adresse().toString() ) == true ) {
			Class_API.Save_NewURL_Search_Auction( adresse, null );
		} else {
			Class_API.Save_NewURL_Search_Resultpage( adresse, null );
		}*/		
	}

	public Object_SearchJob SearchHashmapForURL( Object_SearchJob object_SearchJob) throws Exception {
		//System.out.println( this.getClass().toString()+" SearchHashmapForURL" );
		return Class_API.SearchFor_Search_URL( object_SearchJob);
		/*if ( isProductPage( object_SearchJob.TargetOffer.Get_Adresse().Get_Adresse().toString() ) == true ) {
			return Class_API.SearchFor_Search_Auction_URL( object_SearchJob);
		} else {
			return Class_API.SearchFor_Search_Resultpage_URL( object_SearchJob);
		}*/
	}

	public void UpdateURLGUIList() throws Exception {
		SetCurrentAction( "Updating URL GUI list" );
		this.Class_API.Set_URLsFound( 0 );
		Class_API.UpdateURLGUI_Hashmap();
	}

	public int CheckRelationValue_Job(Object_SearchJob jobb) throws Exception {
		return Class_API.CheckRelationValue_Job( jobb );
	}

	public void SetCurrency(Double currency) {
		this.Currency = currency;
		SetCurrentAction( "Gathered currency data" );
	}

	public String Get_SelectedSearchtype( String Source ) {
		//System.out.println( this.getClass().toString()+" Get_SelectedSearchtype this="+this );
		return Class_API.Get_SelectedSearchtype( Source );
	}

	public String[] Get_Itemtypes() {
		try {
			return Get_SelectedDropshipper( this.getClass().toString()+" Get_Itemtypes").Get_Itemtypes_String();
		} catch ( Exception T ) {
			return new String[1];
		}
	}

	public void Set_Dropshipper( String string ) throws Exception {
		//System.out.println( this.getClass().toString()+" Set_Dropshipper A" );
		//System.out.println( this.getClass().toString()+" Set_SelectedDropshipper selectedDropshipper->"+string );
		Class_API.Set_SelectedDropshipper( string );
		//System.out.println( this.getClass().toString()+" Set_Dropshipper B" );
		//Class_API.LoadItemTypeSettings();
		Class_API.AddSearchTypes();
		//System.out.println( this.getClass().toString()+" Set_Dropshipper C" );
		Class_API.AddItemypes();
		//System.out.println( this.getClass().toString()+" Set_Dropshipper D" );
		Class_API.URLs_Create();
		//System.out.println( this.getClass().toString()+" Set_Dropshipper E" );
		Class_API.LoadURLs_new();
		//System.out.println( this.getClass().toString()+" Set_Dropshipper F" );
		Class_API.Itemtypes_Startup( Class_API.Get_SelectedDropshipper( this.getClass().toString()+" Set_Dropshipper" ) );
		//System.out.println( this.getClass().toString()+" Set_Dropshipper G" );
		Class_API.LoadItemTypeSettings();
		SetCurrentAction( "Changed dropshipper settings" );
		//System.out.println( this.getClass().toString()+" Set_Dropshipper H" );
	}

	public Object_Dropshipper[] Get_Dropshippers() {
		return Class_API.Get_Dropshippers_Object();
	}
	
	public void SetCurrentAction( String ActionText ) {
		if ( ActionText.indexOf("Downloading page") > -1 ) {
		} else if ( ActionText.indexOf("Saved new URL") > -1 ) {
		} else if ( ActionText.indexOf("New offer identified") > -1 ) {
		} else if ( ActionText.indexOf("Expanding work list") > -1 ) {
		} else if ( ActionText.indexOf("Saving URL to disk") > -1 ) {
		} else if ( ActionText.indexOf("Loading previously uncompleted work") > -1 ) {
		} else if ( ActionText.indexOf("Saving work") > -1 ) {
		} else if ( ActionText.indexOf("Updating URL GUI list") > -1 ) {
		} else {
			Date Naa = new Date();
			//System.out.println( Naa.getHours()+":"+Naa.getMinutes()+":"+Naa.getSeconds()+" "+this.getClass().toString()+" SetCurrentAction "+ActionText );
		}
		if ( Class_API.MainWindow_Exists() == true ) {
			Class_API.SetCurrentAction( ActionText );
		}
	}

	public int CheckRelationValue_URL(String string) {
		return Class_API.CheckRelationValue_URL( string );
	}

	public boolean isProductPage( String adresse ) {
		return Class_API.isProductPage( adresse );
	}

	public void Save_DownloadedPage( Object_SearchJob jobb ) throws Exception {
		Class_API.Save_SearchJob_Offers( jobb );
		SetCurrentAction( "Finished a download" );
	}

	@Override
    public void uncaughtException(Thread t, Throwable T){
		//class java.lang.ArrayIndexOutOfBoundsException
		if ( T.getClass ( ).toString().indexOf("java.lang.ArrayIndexOutOfBoundsException") > -1 ) {
			return;
		}
    	if ( ( T.getMessage( ).equals("Java heap space") ) || ( T.getMessage( ).equals("GC overhead limit exceeded") ) ) {
    		//System.exit(0);
    		Restart Restarter = new Restart();
    		try {
				Restarter.restartApplication(null);
			} catch (IOException e) {
				e.printStackTrace();
			}
    		//System.gc();
    		try {
    			AddProgressMessage( "Program memory full. Flushing." );
    			//UserCommand_StopSearching();
    			return;
    		} catch (Exception e1) {
    		}
    	}
    	try {
			this.Class_API.PrintErrorLog( (Exception) T, this.getClass().toString()+" uncaughtException" );
		} catch (Exception e1) {
			//e1.printStackTrace();
		}
		try {
			Exception e = (Exception) T;
			
			ReportError( e, this.getClass().toString()+" uncaughtException" );
			System.out.printf("Thread %s caught exception %s%n", t, e);
		} catch (Exception e1) {
			//e1.printStackTrace();
		}
		
		Date Naa = new Date();
		System.err.println ( "-- Throwable start --" );
		System.err.println ( "Tid: "+Naa.getHours()+":"+Naa.getMinutes() );
		System.err.println (" ");
		System.err.println ( "Throwable: " + T );
		System.err.println ( "Throwable message: " + T.getMessage ( ) );
		System.err.println ( "Throwable cause: " + T.getCause ( ) );
		System.err.println ( "Throwable class: " + T.getClass ( ) );
		System.err.println (" ");
		if ( T.getStackTrace ( ) != null ){
			System.err.println ( "Throwable origin: ");
			System.err.println ( "Class: " + T.getStackTrace ( )[0].getClassName ( ) );
			System.err.println ( "Method: " + T.getStackTrace ( )[0].getMethodName ( ) );
			System.err.println ( "Line: " + T.getStackTrace ( )[0].getLineNumber ( ) );
		}
		for ( int y = 1 ; y < T.getStackTrace().length ; y++ ) {
			System.err.println (" ");
			System.err.println ( "Origin stack "+y+": ");
			System.err.println ( "Class: " + T.getStackTrace ( )[y].getClassName ( ) );
			System.err.println ( "Method: " + T.getStackTrace ( )[y].getMethodName ( ) );
			System.err.println ( "Line: " + T.getStackTrace ( )[y].getLineNumber ( ) );
		}
		
    	//System.out.println("- " + new Throwable().fillInStackTrace().getStackTrace()[0]+") <- " + new Throwable().fillInStackTrace().getStackTrace()[1]+")");
    	//Class_ErrorHandler.WriteThrowableToScreen ( T );
    	
    	/*if ( T.getMessage( ).equals("Java heap space") ) {
    		try {
	    		RestartCycle();
				StartSearching( );
    		} catch (Exception e1) {
    			
    		}
    	}
    	if ( T.getMessage( ).equals("GC overhead limit exceeded") ) {
    		try {
	    		RestartCycle();
				StartSearching( );
    		} catch (Exception e1) {
    			
    		}
    	}*/

    }

	public void Set_Setting_AutoPricing( String Setting ) throws Exception {
		//System.out.println( this.getClass().toString()+" Set_Setting_AutoPricing" );
		Class_API.Set_AutoPricing( Setting );
	}

	public boolean ItemTypeAccepted( Object_Product_Offer Produkt, String category, String parentCategory, String crumbs ) throws Exception  {
		return this.Class_API.ItemTypeAccepted( Produkt, category, parentCategory, crumbs );
	}

	public Object_DropshipItemtype[] Get_Itemtypes_Objects() {
		try {
			return Get_SelectedDropshipper( this.getClass().toString()+" Get_Itemtypes_Objects" ).Get_Itemtypes();
		} catch ( Exception T ) {
			return new Object_DropshipItemtype[1];
		}
	}

	/*public void Command_ItemtypeTree_Selection( String selected_Category ) {
		Class_Brain_ItemTypes.Set_Itemtype( selected_Category );
	}*/

	public void ActivateItemType(String label, boolean selected) throws Exception {
		//System.out.println( this.getClass().toString()+" ActivateItemType "+label );
		if ( Class_API.MainWindow_Exists() == true ) {
			Class_API.MainWindow_ActivateItemType( label, selected );
		}
		if ( Class_API.Itemtypes_Exists() == true ) {
			Class_API.Itemtypes_ActivateItemType( label, selected );
		}
	}

	public boolean Get_ItemtypeSelectionStatus( String category ) {
		return Class_API.Get_ItemtypeSelectionStatus( category );
	}

	public void Set_DropshipperDowntime(String dropshipper, Date date) {
		this.Class_API.Set_DropshipperDowntime(dropshipper,date);
	}

	public Date Get_DropshipperDowntime(String get_Domain_Lang) {
		return Class_API.Get_DropshipperDowntime(get_Domain_Lang);
	}

	public Object_TreeMap ExpandTreeMap_String( Object_TreeMap_String object_TreeMap_String, String adresse, Object_SearchJob test) throws Exception {
		SetCurrentAction( "Expanding work list" );
		return Class_API.ExpandTreeMap_String( object_TreeMap_String, adresse, test);
	}

	public Object_TreeMap ExpandTreeMap_int( Object_TreeMap_int object_TreeMap_int, int relationValue, Object_SearchJob test) throws Exception {
		SetCurrentAction( "Expanding work list" );
		return Class_API.ExpandTreeMap_int( object_TreeMap_int, relationValue, test);
	}

	public void Save_SearchJob(Object_SearchJob test) throws Exception {
		//System.out.println( this.getClass().toString()+" Save_SearchJob" );
		SetCurrentAction( "Saving work" );
		Class_API.Save_SearchJob_URL(test);
		Class_API.Save_SearchJob_Search(test);
		Class_API.Save_SearchJob_Offers(test);
		SaveURLToDisk( test.TargetOffer.Get_Adresse() );
	}

	public void Save_LoadedPage(Object_SearchJob jobb) throws Exception {
		//System.out.println( this.getClass().toString()+" Save_LoadedPage" );
		SetCurrentAction( "Loading previously uncompleted work" );
		Class_API.Save_SearchJob_URL(jobb);
		Class_API.Save_SearchJob_Search(jobb);
		Class_API.Save_SearchJob_Offers(jobb);
	}
	
	public void SaveURLToDisk( Object_URL Adresse ) throws Exception {
		SetCurrentAction( "Saving URL to disk" );
		Class_API.SaveURLToDisk( Adresse );
	}

	public boolean Loading_URLS() {
		return Class_API.Loading_URLS();
	}

	public boolean IsAcceptedSeller(String seller) {
		//System.out.println( this.getClass().toString()+" AcceptedSeller seller="+seller+" A" );
		if ( Class_API.Get_SelectedSearchtype( this.getClass().toString()+" IsAcceptedSeller" ).equals("Store scan") == true ) {
			//System.out.println( this.getClass().toString()+" AcceptedSeller seller="+seller+" B" );
			return Class_API.IsAcceptedSeller( seller);
		} else {
			//System.out.println( this.getClass().toString()+" AcceptedSeller seller="+seller+" C" );
			return true;
		}
	}

	/*public void Set_TargetSeller(String text) throws Exception {
		Class_API.Set_TargetSeller( text);
	}*/

	/*public String Get_SelectedStore() {
		return Class_API.Get_SelectedStore();
	}*/
	
	public void Set_Setting_UserShop(String User) throws Exception {
		//System.out.println( this.getClass().toString()+" Set_Setting_UserShop" );
		Class_API.Set_Setting_UserShop(User);
	}
	
	public String Get_Settings_UserShop() throws Exception {
		return Class_API.Get_Settings_UserShop();
	}

	public void Set_Setting_Password(String User) throws Exception {
		Class_API.Set_Setting_Password(User);
	}

	public String Get_Settings_Password() throws Exception {
		return Class_API.Get_Settings_Password();
	}

	public void LoadItemTypeSettings() throws Exception {
		Class_API.LoadItemTypeSettings();
	}

	public boolean Get_SelectedSavetype() {
		return Class_API.Get_SelectedSavetype();
	}

	public String Get_SelectedAutopricing() {
		return Class_API.Get_SelectedAutopricing();
	}

	public Object Get_UserPassword() {
		return UserPassword;
	}

	public void Print_RejectedOffer( Object_Product_Offer object_Product_Offer, String reason ) throws Exception {
		Class_API.Print_RejectedOffer( object_Product_Offer, reason );
	}

	public void Print_RejectedLink( Object_URL object_URL, String reason ) throws Exception {
		Class_API.Print_RejectedLink( object_URL, reason );
	}

	public Object_SearchJob[] Get_All_Pages() throws Exception {
		return Class_API.Get_All_Pages();
	}

	public void Add_Page_Locate(Object_URL nyURL, int i) throws Exception {
		Class_API.Add_Page_Locate(nyURL, i);
	}

	public int Get_Layer() {
		return Class_API.Get_Layer();
	}

	public void Increase_LayerCount_Download() {
		Class_API.Increase_LayerCount_Download();
	}

	public void Increase_LayerCount_URL() {
		Class_API.Increase_LayerCount_URL();
	}

	public void Increase_LayerCount_Identify() {
		Class_API.Increase_LayerCount_Identify();
	}

	public void Reset_LayerCount_URL() {
		Class_API.Reset_LayerCount_URL();
	}

	public void Reset_LayerCount_Identify() {
		Class_API.Reset_LayerCount_Identify();
	}

	public int Get_LayerCount() {
		return Class_API.Get_LayerCount();
	}

	public int Get_LayerCount_Working() {
		return Class_API.Get_LayerCount_Working();
	}

	public Object_TreeMap[] Get_TreeMap() {
		return Class_API.Get_TreeMap();
	}

	public Object_SearchJob Get_Page_ObjectURL(String string) throws Exception {
		return Class_API.Get_Page_ObjectURL(string);
	}

}
