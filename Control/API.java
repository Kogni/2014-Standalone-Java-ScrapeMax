package Control;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import javax.swing.JFrame;

import Dropshippers.Brain_Dropshippers;
import Dropshippers.Object_Dropshipper;
import Interfaces.Interface_Currency;
import Interfaces.Interface_Dropshippers;
import Interfaces.Interface_Itemtypes;
import Interfaces.Interface_MainWindow;
import Interfaces.Interface_Offers;
import Interfaces.Interface_Saving;
import Interfaces.Interface_Searching;
import Interfaces.Interface_Treemaps;
import Interfaces.Interface_URLs;
import Itemtypes.Brain_ItemTypes;
import Itemtypes.Object_DropshipItemtype;
import Offers.Brain_Offers;
import Offers.Object_Product_Offer;
import Saving.Brain_Saving;
import Searching.Brain_Downloads;
import Searching.Object_SearchJob;
import URLs.Brain_Treemaps;
import URLs.Brain_URLs;
import URLs.Object_TreeMap;
import URLs.Object_TreeMap_String;
import URLs.Object_TreeMap_int;
import URLs.Object_URL;
import View.Frame_MainWindow;
import View.Frame_PasswordCheck;
import Wholesalers.Brain_Wholesalers;

public class API implements Interface_Currency, Interface_Treemaps, Interface_Dropshippers, Interface_Itemtypes, Interface_Offers, Interface_Saving, 
	Interface_Searching, Interface_URLs, Interface_MainWindow {
	
	Controller Class_Controller;
	
	Brain_Currency Class_Brain_Currency;
	Brain_Treemaps Class_Brain_Treemaps;
	Brain_Saving Class_Brain_Saving;
	Brain_Dropshippers Class_Brain_Dropshippers;
	Brain_Downloads Class_Brain_Searching;
	Brain_ItemTypes Class_Brain_ItemTypes;
	Brain_Offers Class_Brain_Offers;
	Brain_URLs Class_Brain_URLs;
	Brain_Wholesalers Class_Brain_Wholesalers;
	
	Frame_PasswordCheck Class_Frame_PasswordCheck;
	Frame_MainWindow Class_Frame_MainWindow;
	
	SettingsKeeper	Class_SettingsKeeper;
	
	public API( Controller controller ) throws Exception {
		//System.out.println( this.getClass().toString()+" constructor" );
		this.Class_Controller = controller;
		
		Class_Brain_Treemaps = new Brain_Treemaps( Class_Controller );
		Class_Brain_Dropshippers = new Brain_Dropshippers( Class_Controller );
		Class_Brain_Currency = new Brain_Currency(Class_Controller);
		Class_Brain_Saving = new Brain_Saving( Class_Controller );
		Class_Brain_ItemTypes = new Brain_ItemTypes( Class_Controller );
		Class_Brain_Offers = new Brain_Offers( Class_Controller );
		Class_Brain_URLs = new Brain_URLs( Class_Controller );
		Class_Brain_Wholesalers = new Brain_Wholesalers( Class_Controller );
		
		Class_SettingsKeeper = new SettingsKeeper( Class_Controller );
		
		Class_Frame_MainWindow = new Frame_MainWindow( Class_Controller );
		Class_Frame_MainWindow.setDefaultCloseOperation ( JFrame.EXIT_ON_CLOSE );
	}

	//Class_Brain_Currency
	@Override
	public void Currency_Startup() throws Exception {
		Class_Brain_Currency.Currency_Startup();
	}
	
	@Override
	public void HentInfo(StringBuffer buffer) {
	}
	
	public void GetCurrency() throws Exception {
		Class_Brain_Currency.GetCurrency();
	}
	
	//Class_Brain_Treemaps
	@Override
	public Object_TreeMap_String ExpandTreeMap_String( Object_TreeMap_String OldTreeMap, String NewKey, Object_SearchJob NewContent) throws Exception {
		return Class_Brain_Treemaps.ExpandTreeMap_String( OldTreeMap, NewKey, NewContent );
	}

	@Override
	public Object_TreeMap_int ExpandTreeMap_int(Object_TreeMap_int OldTreeMap, int NewKey, Object_SearchJob NewContent) throws Exception {
		return Class_Brain_Treemaps.ExpandTreeMap_int( OldTreeMap, NewKey, NewContent );
	}

	//Class_Brain_Dropshippers
	@Override
	public void Dropshippers_Startup() {
		Class_Brain_Dropshippers.Dropshippers_Startup();
	}

	@Override
	public void Insert_New_Dropshipper(String Name) throws Exception {
		Class_Brain_Dropshippers.Insert_New_Dropshipper( Name );
	}

	@Override
	public Object_Dropshipper Get_SelectedDropshipper( String Source ) {
		return Class_Brain_Dropshippers.Get_SelectedDropshipper( Source );
	}

	@Override
	public Object_Dropshipper[] Get_Dropshippers_Object() {
		return Class_Brain_Dropshippers.Get_Dropshippers_Object();
	}

	@Override
	public boolean isProductPage(String adresse) {
		return Class_Brain_Dropshippers.isProductPage( adresse);
	}
	
	public void Set_SelectedDropshipper( String selectedDropshipper ) throws Exception {
		Class_Brain_Dropshippers.Set_SelectedDropshipper( selectedDropshipper );
		Class_SettingsKeeper.SaveSettings();
	}

	@Override
	public void Set_DropshipperDowntime(String dropshipper, Date date) {
		Class_Brain_Dropshippers.Set_DropshipperDowntime(dropshipper, date);
	}

	@Override
	public Date Get_DropshipperDowntime(String get_Domain_Lang) {
		return Class_Brain_Dropshippers.Get_DropshipperDowntime( get_Domain_Lang);
	}
	
	/*public void Set_TargetSeller(String text) throws Exception {
		Class_Brain_Dropshippers.Set_TargetSeller( text);
		Class_SettingsKeeper.SaveSettings();
	}*/
	
	public boolean IsAcceptedSeller(String seller) {
		//System.out.println( this.getClass().toString()+" IsAcceptedSeller seller="+seller+" A" );
		//if ( Class_Brain_Dropshippers.IsAcceptedSeller(seller) == true ) {
			//System.out.println( this.getClass().toString()+" IsAcceptedSeller seller="+seller+" B" );
			return Class_Brain_Wholesalers.IsAcceptedSeller( seller);
		//}
		//System.out.println( this.getClass().toString()+" IsAcceptedSeller seller="+seller+" C" );
		//return false;
	}
	
	/*public String Get_SelectedStore() {
		return Class_Brain_Wholesalers.Get_SelectedStore();
	}*/
	
	//Class_Brain_ItemTypes

	@Override
	public void Itemtypes_Startup(Object_Dropshipper Dropshipper) throws Exception {
		Class_Brain_ItemTypes.Itemtypes_Startup( Dropshipper);
	}

	@Override
	public void LoadItemTypeSettings() throws Exception {
		Class_Brain_ItemTypes.LoadItemTypeSettings();
	}

	@Override
	public void SaveSettings() throws Exception {
		Class_Brain_ItemTypes.SaveSettings();
	}

	@Override
	public void Insert_New_Itemtype(String Category, String ParentCategory, String Homepage, String Subject, boolean Enabled) {
		Class_Brain_ItemTypes.Insert_New_Itemtype( Category, ParentCategory, Homepage, Subject, Enabled);
	}

	@Override
	public int CheckRelationValue_Job(Object_SearchJob jobb) throws Exception {
		return Class_Brain_ItemTypes.CheckRelationValue_Job( jobb);
	}

	@Override
	public int CheckRelationValue_Job_Category(Object_SearchJob jobb) {
		return Class_Brain_ItemTypes.CheckRelationValue_Job_Category( jobb);
	}

	@Override
	public int CheckRelationValue_Job_FullCrawl(Object_SearchJob jobb) {
		return Class_Brain_ItemTypes.CheckRelationValue_Job_FullCrawl(jobb);
	}

	@Override
	public int CheckRelationValue_URL(String Adresse) {
		return Class_Brain_ItemTypes.CheckRelationValue_URL( Adresse);
	}

	@Override
	public boolean ItemTypeAccepted( Object_Product_Offer Produkt, String category, String parentCategory, String crumbs ) {
		return Class_Brain_ItemTypes.ItemTypeAccepted( Produkt, category, parentCategory, crumbs);
	}

	@Override
	public boolean TestItemtype(String category, String parentCategory, String crumbs, Object_DropshipItemtype itemtype, String Source ) {
		return Class_Brain_ItemTypes.TestItemtype( category, parentCategory, crumbs, itemtype, Source);
	}

	@Override
	public boolean Itemtypes_ActivateItemType(String label, boolean selected) throws Exception {
		return Class_Brain_ItemTypes.Itemtypes_ActivateItemType(label, selected);
	}

	@Override
	public boolean Get_ItemtypeSelectionStatus(String category) {
		return Class_Brain_ItemTypes.Get_ItemtypeSelectionStatus(category);
	}
	
	public boolean Itemtypes_Exists() {
		return Class_Brain_ItemTypes != null;
	}
	
	public void Set_Setting_Password(String user) throws Exception {
		Class_Brain_ItemTypes.Set_Setting_Password(user);
		Class_SettingsKeeper.SaveSettings();
	}
	
	public String Get_Settings_Password() {
		return Class_Brain_ItemTypes.Get_Settings_Password();
	}
	
	public void Set_Setting_UserShop(String user) throws Exception {
		Class_Brain_ItemTypes.Set_Setting_UserShop(user);
		Class_SettingsKeeper.SaveSettings();
	}
	
	public String Get_Settings_UserShop() {
		return Class_Brain_ItemTypes.Get_Settings_UserShop();
	}

	//Class_Brain_Offers
	
	public void Offers_Create() throws Exception {
		Class_Brain_Offers = new Brain_Offers( Class_Controller );
	}
	
	@Override
	public void RunThreads_Offers() throws Exception {
		Class_Brain_Offers.RunThreads_Offers();
	}

	/*@Override
	public void RunThreads_Identify_Resultpages() {
		Class_Brain_Offers.RunThreads_Identify_Resultpages();
	}

	@Override
	public void Process_Identify_Resultpages(Object_SearchJob HentetJobb) throws Exception {
		Class_Brain_Offers.Process_Identify_Resultpages(HentetJobb);
	}

	@Override
	public void RunThreads_Identify_Auctions() {
		Class_Brain_Offers.RunThreads_Identify_Auctions();
	}

	@Override
	public void Process_Identify_Auctions(Object_SearchJob HentetJobb) throws Exception {
		Class_Brain_Offers.Process_Identify_Auctions( HentetJobb);
	}

	@Override
	public void Save_DownloadedPage_Resultpage(Object_SearchJob jobb) throws Exception {
		Class_Brain_Offers.Save_DownloadedPage_Resultpage( jobb);
	}

	@Override
	public void Save_DownloadedPage_Auction(Object_SearchJob jobb) throws Exception {
		Class_Brain_Offers.Save_DownloadedPage_Auction( jobb);
	}*/
	
	@Override
	public void Save_SearchJob_Offers(Object_SearchJob test) throws Exception {
		Class_Brain_Offers.Save_SearchJob_Offers(test);
	}
	
	@Override
	public void RunThreads_Identify() {
		Class_Brain_Offers.RunThreads_Identify();
	}

	@Override
	public void Process_Identify(Object_SearchJob HentetJobb) throws Exception {
		Class_Brain_Offers.Process_Identify( HentetJobb);
	}

	@Override
	public void Save_DownloadedPage(Object_SearchJob jobb) throws Exception {
		Class_Brain_Offers.Save_DownloadedPage( jobb);
	}
	
	//Class_Brain_Saving

	@Override
	public void PrintOffer(Object_Product_Offer Offer) throws Exception {
		Class_Brain_Saving.PrintOffer(Offer);
	}

	@Override
	public void PrintToCSV(Object_Product_Offer Offer) throws Exception {
		Class_Brain_Saving.PrintToCSV(Offer);
	}

	@Override
	public void PrintToFolder(Object_Product_Offer Offer) throws Exception {
		Class_Brain_Saving.PrintToFolder( Offer);
	}

	@Override
	public void saveImage2(String imageUrl, String destinationFile) throws Exception {
		Class_Brain_Saving.saveImage2( imageUrl, destinationFile);
	}

	@Override
	public void Set_Setting_SaveType(String type) throws Exception {
		Class_Brain_Saving.Set_Setting_SaveType(type);
		Class_SettingsKeeper.SaveSettings();
	}

	@Override
	public void PrintActionLog(String Message) throws Exception {
		Class_Brain_Saving.PrintActionLog(Message);
	}

	@Override
	public void PrintErrorLog(Exception t2, String source) throws Exception {
		Class_Brain_Saving.PrintErrorLog(t2, source);
	}
	
	public void Set_AutoPricing(String setting) throws Exception {
		Class_Brain_Saving.Set_AutoPricing( setting);
		Class_SettingsKeeper.SaveSettings();
	}
	
	public boolean Get_SelectedSavetype() {
		return Class_Brain_Saving.Get_SelectedSavetype();
	}
	
	public String Get_SelectedAutopricing() {
		return Class_Brain_Saving.Get_SelectedAutopricing();
	}

	//Class_Brain_Searching
	
	public int Get_Layer() {
		return Class_Brain_Searching.Layer;
	}
	
	public void Increase_LayerCount_Download() {
		Class_Brain_Searching.LayerCount_Download ++;
	}
	
	public void Increase_LayerCount_URL() {
		Class_Brain_Searching.LayerCount_URL ++;
	}
	
	public void Increase_LayerCount_Identify() {
		Class_Brain_Searching.LayerCount_Identify ++;
	}
	
	public void Reset_LayerCount_URL() {
		Class_Brain_Searching.LayerCount_URL = 0;
	}
	
	public void Reset_LayerCount_Download() {
		Class_Brain_Searching.LayerCount_Download = 0;
	}
	
	public void Reset_LayerCount_Identify() {
		Class_Brain_Searching.LayerCount_Identify = 0;
	}
	
	public int Get_LayerCount() {
		return Class_Brain_Searching.LayerCount;
	}

	public int Get_LayerCount_Working() {
		return Class_Brain_Searching.LayerCount_Working;
	}
	
	public Object_SearchJob Get_Page_ObjectURL(String string) throws Exception {
		return Class_Brain_Searching.Get_Page_ObjectURL(string);
	}
	
	public void Searching_Create( String Source ) throws Exception {
		Class_Brain_Searching = new Brain_Downloads( Class_Controller, Source );
	}
	
	public boolean Searching_Exists() {
		return Class_Brain_Searching != null;
	}
	
	public void Save_SearchJob_Search(Object_SearchJob test) throws Exception {
		Class_Brain_Searching.Save_SearchJob_Search( test);
	}

	/*@Override
	public void Save_NewURL_Search_Auction( Object_URL adresse, Object_SearchJob New) throws Exception {
		Class_Brain_Searching.Save_NewURL_Search_Auction( adresse, New );
	}

	@Override
	public void Save_NewURL_Search_Resultpage( Object_URL adresse, Object_SearchJob New) throws Exception {
		Class_Brain_Searching.Save_NewURL_Search_Resultpage( adresse, New );
	}

	@Override
	public Object_SearchJob SearchFor_Search_Auction_URL( Object_SearchJob object_SearchJob) throws Exception {
		return Class_Brain_Searching.SearchFor_Search_Auction_URL( object_SearchJob);
	}

	@Override
	public Object_SearchJob SearchFor_Search_Resultpage_URL( Object_SearchJob object_SearchJob) throws Exception {
		return Class_Brain_Searching.SearchFor_Search_Resultpage_URL( object_SearchJob);
	}*/
	
	@Override
	public void RunThreads_Searching() throws Exception {
		Class_Brain_Searching.RunThreads_Searching();
	}

	/*@Override
	public void RunThreads_Search_Resultpages() throws Exception {
		Class_Brain_Searching.RunThreads_Search_Resultpages();
	}

	@Override
	public void RunThreads_Search_Auctions() throws Exception {
		Class_Brain_Searching.RunThreads_Search_Auctions();
	}

	@Override
	public void Process_Search_Auctions(Object_SearchJob HentetJobb) {
		Class_Brain_Searching.Process_Search_Auctions(HentetJobb);
	}

	@Override
	public void Process_Search_Resultpages(Object_SearchJob HentetJobb) throws Exception {
		Class_Brain_Searching.Process_Search_Resultpages( HentetJobb);
	}*/
	
	@Override
	public void UpdateURLGUI_Hashmap() throws Exception {
		Class_Brain_Searching.UpdateURLGUI_Hashmap();
	}
	
	public void Set_Searchtype(String string) throws Exception {
		//System.out.println( this.getClass().toString()+" Set_Searchtype Selected_Searchtype="+string );
		Class_Brain_Searching.Set_Searchtype( string);
		Class_SettingsKeeper.SaveSettings();
	}
	
	public String Get_SelectedSearchtype( String Source ) {
		//System.out.println( this.getClass().toString()+" Get_SelectedSearchtype Class_Brain_Searching="+Class_Brain_Searching );
		return Class_Brain_Searching.Get_SelectedSearchtype( Source );
	}
	
	public Object_SearchJob[] Get_All_Pages() throws Exception {
		if ( Class_Brain_Searching != null ) {
			return Class_Brain_Searching.Get_All_Pages();
		} else {
			return null;
		}
	}
	
	@Override
	public void Save_NewURL_Search(Object_URL nyURL, Object_SearchJob New) throws Exception {
		Class_Brain_Searching.Save_NewURL_Search( nyURL,  New);
	}

	@Override
	public Object_SearchJob SearchFor_Search_URL( Object_SearchJob object_SearchJob) throws Exception {
		return Class_Brain_Searching.SearchFor_Search_URL(  object_SearchJob);
	}

	@Override
	public void RunThreads_Search() throws Exception {
		Class_Brain_Searching.RunThreads_Search();
	}

	@Override
	public void Process_Search(Object_SearchJob HentetJobb) throws Exception {
		Class_Brain_Searching.Process_Search( HentetJobb);
	}
	
	public Object_TreeMap[] Get_TreeMap() {
		return Class_Brain_Searching.Get_TreeMap();
	}
	
	//Class_Brain_URLs
	
	public void URLs_Create() throws Exception {
		Class_Brain_URLs = new Brain_URLs( Class_Controller );
	}

	@Override
	public void LoadURLs_new() throws Exception {
		Class_Brain_URLs.LoadURLs_new();
	}
	
	@Override
	public void Save_SearchJob_URL(Object_SearchJob jobb) throws Exception {
		Class_Brain_URLs.Save_SearchJob_URL( jobb);
	}
	
	@Override
	public void Save_SearchJob_URL_Resultpage(Object_SearchJob jobb) throws Exception {
		Class_Brain_URLs.Save_SearchJob_URL_Resultpage( jobb);
	}

	@Override
	public void Save_SearchJob_URL_Auction(Object_SearchJob jobb) throws Exception {
		Class_Brain_URLs.Save_SearchJob_URL_Auction( jobb);
	}

	@Override
	public void RunThreads_URLfind() {
		Class_Brain_URLs.RunThreads_URLfind();
	}

	@Override
	public void Process_URLs(Object_SearchJob HentetJobb) {
		Class_Brain_URLs.Process_URLs( HentetJobb);
	}

	@Override
	public void SaveURLToDisk(Object_URL Adresse) throws Exception {
		Class_Brain_URLs.SaveURLToDisk( Adresse);
	}
	
	public boolean Loading_URLS() {
		return Class_Brain_URLs.Loading;
	}
	
	public boolean IsUrlSavedToDisk(String adresse) {
		return Class_Brain_URLs.IsUrlSavedToDisk(adresse);
	}

	//Class_Frame_MainWindow
	
	@Override
	public void UpdateURLGUI(Object_SearchJob hentetSide) throws Exception {
		Class_Frame_MainWindow.UpdateURLGUI(hentetSide);
	}

	@Override
	public void Set_URLsFound(int i) throws Exception {
		Class_Frame_MainWindow.Set_URLsFound( i);
	}

	@Override
	public void AddProgressMessage(String string) throws Exception {
		Class_Frame_MainWindow.AddProgressMessage( string);
	}

	@Override
	public void AddItemypes() {
		Class_Frame_MainWindow.AddItemypes();
	}

	@Override
	public void SetCurrentAction(String actionText) {
		Class_Frame_MainWindow.SetCurrentAction(actionText);
	}

	@Override
	public int Get_TotalURLS() {
		return Class_Frame_MainWindow.Get_TotalURLS();
	}

	public boolean MainWindow_Exists() {
		return Class_Frame_MainWindow != null;
	}

	@Override
	public void MainWindow_Startup() throws Exception {
		Class_Frame_MainWindow.MainWindow_Startup();
	}

	@Override
	public void MainWindow_ActivateItemType(String label, boolean selected) {
		Class_Frame_MainWindow.MainWindow_ActivateItemType(label, selected);
	}

	public boolean Panel_URL_Exists() {
		return Class_Frame_MainWindow.Panel_URL_Exists();
	}

	public void AddSearchTypes() {
		//System.out.println( this.getClass().toString()+" AddSearchTypes A" );
		Class_Frame_MainWindow.AddSearchTypes();
		//System.out.println( this.getClass().toString()+" AddSearchTypes B" );
	}
	
	void Add_Page_Locate(Object_URL nyURL, int i) throws Exception {
		Class_Frame_MainWindow.Add_Page_Locate( nyURL, i);
	}

	//Class_SettingsKeeper
	public void LoadSettings( String Source ) {
		//System.out.println( this.getClass().toString()+" LoadSettings "+Source );
		Class_SettingsKeeper.LoadSettings( Source );
	}

	public void Print_RejectedOffer( Object_Product_Offer object_Product_Offer, String reason ) throws Exception {
		Class_Brain_Saving.PrintRejectedOffer( object_Product_Offer, reason);
	}

	public void Print_RejectedLink( Object_URL object_URL, String reason ) throws Exception {
		Class_Brain_Saving.Print_RejectedLink( object_URL, reason);
	}

	//------------
	public void Wholesalers_Create() throws IOException {
		Class_Brain_Wholesalers.LoadWholesalers();
	}

}