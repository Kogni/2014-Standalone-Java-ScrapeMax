package Saving;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.URL;
import java.util.Date;

import Control.Controller;
import Interfaces.Interface_Saving;
import Offers.Object_Product_Offer;
import URLs.Object_URL;

public class Brain_Saving implements Interface_Saving{

	Controller		Class_Controller;

	private boolean	SaveAsCSV;

	public String	AutoPricing	= "Original price and currency";

	public Brain_Saving( Controller Class_Controller ) {
		this.Class_Controller = Class_Controller;
	}

	public void Print_RejectedLink( Object_URL object_URL, String reason ) throws Exception {
		//System.out.println( this.getClass().toString()+" Print_RejectedLink A" );
		try {
			//System.out.println( this.getClass().toString()+" Print_RejectedLink B1" );
			Date Idag = new Date();
			String Logname = "Rejected links log.txt";
			File ProductsFile = new File( Logname );

			if ( !ProductsFile.exists() ) {
				ProductsFile.createNewFile();
			}

			PrintStream utfil;
			FileOutputStream appendFilen = new FileOutputStream( ProductsFile, true );
			utfil = new PrintStream( appendFilen );

			utfil.println( (1900 + Idag.getYear()) + "/" + (1 + Idag.getMonth()) + "/" + Idag.getDate() + " " + Idag.getHours() + "." + Idag.getMinutes() + ":" + Idag.getSeconds() );
			utfil.println( "Reason for rejection: " + reason );
			utfil.println( "Product URL= " + object_URL.Get_Adresse().toString() );

			utfil.println( " " );

			utfil.close();
			utfil = null;

		}
		catch ( Exception T ) {
			//System.out.println( this.getClass().toString()+" Print_RejectedLink B2" );
			Class_Controller.AddProgressMessage( "Could not save action B: " + T.getMessage() + " " + T.getCause() + " " + T.getClass() );
			Class_Controller.ReportError( T, this.getClass().toString() + " PrintErrorLog" );
		}
	}

	public void PrintRejectedOffer( Object_Product_Offer Offer, String reason ) throws Exception {
		System.out.println( this.getClass().toString() + " Forkaster URL pga " + reason + ": " + Offer.Get_Adresse().Get_Adresse().toString() );
		try {
			Date Idag = new Date();
			//String Logname = "Rejected offers log.txt";
			String Logname = "Rejected offers log - " + reason + ".txt";
			File ProductsFile = new File( Logname );

			if ( !ProductsFile.exists() ) {
				ProductsFile.createNewFile();
			}

			PrintStream utfil;
			FileOutputStream appendFilen = new FileOutputStream( ProductsFile, true );
			utfil = new PrintStream( appendFilen );

			utfil.println( (1900 + Idag.getYear()) + "/" + (1 + Idag.getMonth()) + "/" + Idag.getDate() + " " + Idag.getHours() + "." + Idag.getMinutes() + ":" + Idag.getSeconds() );
			utfil.println( "Reason for rejection: " + reason );
			utfil.println( "Product URL= " + Offer.Get_Adresse().Get_Adresse().toString() );
			utfil.println( "ImageText= " + Offer.ImageText );
			utfil.println( "ProductStats= " + Offer.ProductStats );
			utfil.println( "Description= " + Offer.Description );
			utfil.println( "Model= " + Offer.Model );
			utfil.println( "Meta= " + Offer.Meta );
			utfil.println( "Head= " + Offer.Head );
			utfil.println( "Category= " + Offer.Category );
			utfil.println( "ParentCategory= " + Offer.ParentCategory );
			utfil.println( "Price= " + Offer.Price );
			utfil.println( "Seller= " + Offer.Seller );
			utfil.println( "Antall= " + Offer.Antall );
			utfil.println( "Crumbs= " + Offer.Crumbs );

			utfil.println( " " );

			utfil.close();
			utfil = null;
			System.out.println( this.getClass().toString() + " saved rejected offer to file:" + Logname );

		}
		catch ( Exception T ) {
			Class_Controller.AddProgressMessage( "Could not save action B: " + T.getMessage() + " " + T.getCause() + " " + T.getClass() );
			Class_Controller.ReportError( T, this.getClass().toString() + " PrintErrorLog" );
		}
	}

	public void PrintOffer( Object_Product_Offer Offer ) throws Exception {
		//System.out.println( this.getClass().toString()+" PrintOffer SaveAsCSV="+SaveAsCSV+" "+this );
		if ( Offer.Get_AcceptedProduct() == false ) {
			//Class_Controller.AddProgressMessage( "NOT ALLOWED TO SAVE OFFER: "+Offer.Get_Name()+" ("+Offer.Get_Category()+" "+Offer.Get_SubCategory()+")" );
			return;
		}
		if ( Offer.Get_Name().equals( "" ) ) {
			System.out.println( this.getClass().toString() + " PrintOffer intet navn. completecontent=" + Offer.Get_Adresse().Get_CompleteContent().length() );
			return;
		}
		/*if ( Offer.SavedImages < Offer.ImageCount ) {
			return;
		}*/
		Offer.AutoPrice( AutoPricing );
		Offer.Get_Adresse().OfferSaved = true;
		if ( (SaveAsCSV == false) ) {
			//if ( ( Offer.Get_Adresse().Get_Domain_Forkortet().equals("FP") == true ) || ( SaveAsCSV == false ) ) { testing
			PrintToFolder( Offer );
		}
		else {
			PrintToCSV( Offer );
		}
		Class_Controller.SaveURLToDisk( Offer.Get_Adresse() );
	}

	public void PrintToCSV( Object_Product_Offer Offer ) throws Exception {
		try {
			Date Idag = new Date();
			/*String ProductsFilename = (1900+Idag.getYear())+"-"+(1+Idag.getMonth())+"-"+Idag.getDate()+" "+(Idag.getHours())+".CSV";
			File ProductsFile = new File ( ProductsFilename );

			if ( !ProductsFile.exists() ) {
				ProductsFile.createNewFile();
			} else {
				double bytes = ProductsFile.length();
				double kilobytes = (bytes / 1024);
				double megabytes = (kilobytes / 1024);
				if ( megabytes > 6 ) {
					ProductsFilename = (1900+Idag.getYear())+"-"+(1+Idag.getMonth())+"-"+Idag.getDate()+" "+(Idag.getHours())+":"+(Idag.getMinutes()/15)+".CSV";
				}
			}*/

			//String ProductsFilename = (1900+Idag.getYear())+"-"+(1+Idag.getMonth())+"-"+Idag.getDate()+" "+(Idag.getHours())+" "+1+" "+Class_Controller.Get_Settings_UserShop()+".CSV";
			String ProductsFilename = (1900 + Idag.getYear()) + "-" + (1 + Idag.getMonth()) + "-" + Idag.getDate() + " " + 1 + " " + Class_Controller.Get_Settings_UserShop() + ".CSV";
			File ProductsFile = new File( ProductsFilename );
			if ( !ProductsFile.exists() ) {
				ProductsFile.createNewFile();
			}
			double bytes = ProductsFile.length();
			double kilobytes = (bytes / 1024);
			double megabytes = (kilobytes / 1024);
			int Teller = 1;
			while ( megabytes > 6 ) {
				Teller++;
				//ProductsFilename = (1900+Idag.getYear())+"-"+(1+Idag.getMonth())+"-"+Idag.getDate()+" "+(Idag.getHours())+" "+Teller+" "+Class_Controller.Get_Settings_UserShop()+".CSV";
				ProductsFilename = (1900 + Idag.getYear()) + "-" + (1 + Idag.getMonth()) + "-" + Idag.getDate() + " " + Teller + " " + Class_Controller.Get_Settings_UserShop() + ".CSV";
				ProductsFile = new File( ProductsFilename );
				if ( !ProductsFile.exists() ) {
					ProductsFile.createNewFile();
				}
				bytes = ProductsFile.length();
				kilobytes = (bytes / 1024);
				megabytes = (kilobytes / 1024);
			}

			PrintStream utfil;
			FileOutputStream appendFilen = new FileOutputStream( ProductsFile, true );
			utfil = new PrintStream( appendFilen );

			String Bildetekst = Offer.ImageRack;
			utfil.println( Offer.Get_Name() + "~" + Offer.Get_Description() + "~" + Offer.Get_MetaDescription() + "~" + Offer.Get_MetaKeywords() + "~" + Offer.Get_Model() + "~" + Offer.Get_SKU() + "~~~" + Offer.Get_Price() + "~0~0~" + Offer.Get_SubstractStock() + "~" + Offer.Get_RequiresShipping()
					+ "~" + Offer.Get_SEOKeywords() + "~" + Offer.Get_Image() + "~~~~~~" + Offer.Get_SortOrder() + "~" + Offer.Get_Manufacturer() + "~" + Offer.Get_Category() + "~" + Offer.Get_SubCategory() + "~~" + Offer.Get_Attribute() + "~" + Offer.Get_Options() + "~~~"
					+ Offer.Get_AdditionalImage() + "~" + Offer.Get_Points() + "~" + Offer.Get_RewardPoints() + Bildetekst );
			//System.out.println( Offer.Get_Name() );
			//System.out.println( "Offer.ImageRack="+Offer.ImageRack );
			//System.out.println( "Offer.ImageText="+Offer.ImageText );
			//System.out.println( Offer.Get_Name()+"~"+Offer.Get_Description()+"~"+Offer.Get_MetaDescription()+"~"+Offer.Get_MetaKeywords()+"~"+Offer.Get_Model()+"~"+Offer.Get_SKU()+"~"+Offer.Get_UPC()+"~"+Offer.Get_Location()+"~"+Offer.Get_Price()+"~"+Offer.Get_Quantity()+"~"+Offer.Get_MinQuantity()+"~"+Offer.Get_SubstractStock()+"~"+Offer.Get_RequiresShipping()+"~"+Offer.Get_SEOKeywords()+"~"+Offer.Get_Image()+"~"+Offer.Get_Length()+"~"+Offer.Get_Height()+"~"+Offer.Get_Width()+"~"+Offer.Get_Weight()+"~"+Offer.Get_ProductStatus()+"~"+Offer.Get_SortOrder()+"~"+Offer.Get_Manufacturer()+"~"+Offer.Get_Category()+"~"+Offer.Get_SubCategory()+"~"+Offer.Get_Download()+"~"+Offer.Get_Attribute()+"~"+Offer.Get_Options()+"~"+Offer.Get_DiscountPrice()+"~"+Offer.Get_SpecialPrice()+"~"+Offer.Get_AdditionalImage()+"~"+Offer.Get_Points()+"~"+Offer.Get_RewardPoints() );
			//System.out.println( this.getClass().toString()+" "+Offer.Get_Name()+" Get_Description="+Offer.Get_Description() );
			//System.out.println( this.getClass().toString()+" "+Offer.Get_Name()+" Get_Image()="+Offer.Get_Image() );
			//System.out.println( this.getClass().toString()+" "+Offer.Get_Name()+" Oppr. kategori="+Offer.Category+" parent.cat="+Offer.ParentCategory );
			//System.out.println( this.getClass().toString()+" "+Offer.Get_Name()+" Price="+Offer.Price+" salgspris="+Offer.Get_Price() );

			utfil.close();
			utfil = null;
			System.gc();

			//this.Class_Controller.AddProgressMessage( "New product saved to searchlist file." );
			this.Class_Controller.AddProgressMessage( "Saved offer: " + Offer.Get_Name() + " (" + Offer.Get_Category() + " " + Offer.Get_SubCategory() + ")" );
			//linkToCheck.CleanForMemory();
		}
		catch ( IOException T ) {
			Class_Controller.AddProgressMessage( "Could not save offer A: " + T.getMessage() + " " + T.getCause() + " " + T.getClass() );
			Class_Controller.ReportError( T, this.getClass().toString() + " PrintToCSV" );
			if ( T.getMessage().equals( "Access is denied" ) ) {
				PrintOffer( Offer );
			}
			else {
				Class_Controller.ReportError( T, this.getClass().toString() + " PrintToCSV" );
			}
		}
		catch ( Exception T ) {
			Class_Controller.AddProgressMessage( "Could not save offer B: " + T.getMessage() + " " + T.getCause() + " " + T.getClass() );
			Class_Controller.ReportError( T, this.getClass().toString() + " PrintToCSV" );
		}
	}

	public void PrintToFolder( Object_Product_Offer Offer ) throws Exception {
		//System.out.println( this.getClass().toString()+" PrintToFolder " );
		String CategoryFolder = Offer.Get_Category();
		String SKU = Offer.Get_Model();
		try {

			//String TempData = Offer.Beskrivelser;
			String URLtemp;

			int Teller = 0;
			String ImageName;

			File ProductInfo = new File( CategoryFolder + "\\" + SKU + "\\" + SKU + ".txt" );
			try {

				if ( !ProductInfo.getParentFile().exists() )
					ProductInfo.getParentFile().mkdirs();

				if ( !ProductInfo.exists() ) {
					ProductInfo.createNewFile();
				}
				PrintStream utfil;
				FileOutputStream appendFilen = new FileOutputStream( ProductInfo, true );
				utfil = new PrintStream( appendFilen );
				utfil.println( "Produkt: " + Offer.Get_Name() + "\r\nDescription i HTML-kode: " + Offer.Get_Description() + "\r\nURL: " + Offer.Get_MetaDescription() + "\r\nSKU: " + Offer.Get_Model() + "\r\nInnpris uten frakt: " + Offer.Get_Price() + "\r\nAntall: " + Offer.Get_Quantity() );

				String TempData = Offer.ImageText;
				while ( TempData.indexOf( ".jpg" ) > -1 ) {
					//System.out.println( this.getClass().toString()+" PrintToFolder Prøver å lagre bilde" );
					URLtemp = TempData.substring( 0, TempData.indexOf( ".jpg" ) + ".jpg".length() );
					TempData = TempData.substring( TempData.indexOf( ".jpg" ) + 1 );

					if ( !new File( CategoryFolder ).exists() ) {
						File dir = new File( CategoryFolder );
						dir.mkdir();
					}
					if ( !new File( CategoryFolder + "\\" + SKU ).exists() ) {
						File dir = new File( CategoryFolder + "\\" + SKU );
						dir.mkdir();
					}

					URLtemp = URLtemp.substring( URLtemp.lastIndexOf( "http" ) );
					Teller++;
					ImageName = "Bilde nr " + Teller;

					//SaveImage1( URLtemp, CategoryFolder, SKU, ImageName );
					saveImage2( URLtemp, CategoryFolder + "\\" + SKU + "\\" + ImageName + ".jpg" );
				}
				Class_Controller.AddProgressMessage( "Saved offer: " + Offer.Get_Name() + " (" + Offer.Get_Category() + " " + Offer.Get_SubCategory() + ")" );

			}
			catch ( Exception T ) {
				Class_Controller.ReportError( T, this.getClass().toString() + " PrintToFolder" );
				System.err.println( this.getClass().toString() + " Error. ProductInfo=" + ProductInfo );
				System.err.println( this.getClass().toString() + " Error. Category=" + Offer.Category );
				System.err.println( this.getClass().toString() + " Error. Get_Model=" + Offer.Get_Model() );
			}
		}
		catch ( Exception T ) {
			Class_Controller.ReportError( T, this.getClass().toString() + " PrintToFolder" );
			System.err.println( this.getClass().toString() + " Error. CategoryFolder/SKU/SKU.txt=" + CategoryFolder + "\\" + SKU + "\\" + SKU + ".txt" );
		}

	}

	public void saveImage2( String imageUrl, String destinationFile ) throws Exception {
		try {
			File dir = new File( destinationFile );
			if ( !dir.getParentFile().exists() )
				dir.getParentFile().mkdirs();

			if ( !dir.exists() ) {
				dir.createNewFile();
			}

			URL url = new URL( imageUrl );
			InputStream is = url.openStream();
			OutputStream os = new FileOutputStream( destinationFile );
			try {

				byte[] b = new byte[2048];
				int length;

				while ( (length = is.read( b )) != -1 ) {
					os.write( b, 0, length );
				}
			}
			catch ( IOException T ) {
				File ProductInfo = new File( destinationFile + ".txt" );
				try {

					if ( !ProductInfo.getParentFile().exists() )
						ProductInfo.getParentFile().mkdirs();

					if ( !ProductInfo.exists() ) {
						ProductInfo.createNewFile();
					}
					PrintStream utfil;
					FileOutputStream appendFilen = new FileOutputStream( ProductInfo, true );
					utfil = new PrintStream( appendFilen );
					utfil.println( "Bilde kunne ikke lagres: " + imageUrl );

				}
				catch ( Exception E ) {
				}
			}

			is.close();
			os.close();
		}
		catch ( IOException T ) {
			//Class_Controller.ReportError(T);
		}
	}

	public void Set_Setting_SaveType( String type ) {
		if ( type.equals( "CSV-file" ) ) {
			this.SaveAsCSV = true;
		}
		else if ( type.equals( "Local folders" ) ) {
			SaveAsCSV = false;
		}
		else {
			SaveAsCSV = Boolean.valueOf( type );
		}
		//System.out.println( this.getClass().toString()+" Set_Setting_SaveType SaveAsCSV="+SaveAsCSV+" type="+type+" "+this );
	}

	public void PrintActionLog( String Message ) throws Exception {
		try {
			Date Idag = new Date();
			String Logname = "Action log.txt";
			File ProductsFile = new File( Logname );

			if ( !ProductsFile.exists() ) {
				ProductsFile.createNewFile();
			}

			PrintStream utfil;
			FileOutputStream appendFilen = new FileOutputStream( ProductsFile, true );
			utfil = new PrintStream( appendFilen );

			utfil.println( (1900 + Idag.getYear()) + "/" + (1 + Idag.getMonth()) + "/" + Idag.getDate() + " " + Idag.getHours() + "." + Idag.getMinutes() + ":" + Idag.getSeconds() + " " + Message );
			//System.out.println( Offer.Get_Name()+"~"+Offer.Get_Description()+"~"+Offer.Get_MetaDescription()+"~"+Offer.Get_MetaKeywords()+"~"+Offer.Get_Model()+"~"+Offer.Get_SKU()+"~"+Offer.Get_UPC()+"~"+Offer.Get_Location()+"~"+Offer.Get_Price()+"~"+Offer.Get_Quantity()+"~"+Offer.Get_MinQuantity()+"~"+Offer.Get_SubstractStock()+"~"+Offer.Get_RequiresShipping()+"~"+Offer.Get_SEOKeywords()+"~"+Offer.Get_Image()+"~"+Offer.Get_Length()+"~"+Offer.Get_Height()+"~"+Offer.Get_Width()+"~"+Offer.Get_Weight()+"~"+Offer.Get_ProductStatus()+"~"+Offer.Get_SortOrder()+"~"+Offer.Get_Manufacturer()+"~"+Offer.Get_Category()+"~"+Offer.Get_SubCategory()+"~"+Offer.Get_Download()+"~"+Offer.Get_Attribute()+"~"+Offer.Get_Options()+"~"+Offer.Get_DiscountPrice()+"~"+Offer.Get_SpecialPrice()+"~"+Offer.Get_AdditionalImage()+"~"+Offer.Get_Points()+"~"+Offer.Get_RewardPoints() );

			utfil.close();
			utfil = null;

		}
		catch ( IOException T ) {
			Class_Controller.AddProgressMessage( "Could not save action A: " + T.getMessage() + " " + T.getCause() + " " + T.getClass() );
			Class_Controller.ReportError( T, this.getClass().toString() + " PrintActionLog" );
			if ( T.getMessage().equals( "Access is denied" ) ) {
				PrintActionLog( Message );
			}
			else {
				Class_Controller.ReportError( T, this.getClass().toString() + " PrintActionLog" );
			}
		}
		catch ( Exception T ) {
			Class_Controller.AddProgressMessage( "Could not save action B: " + T.getMessage() + " " + T.getCause() + " " + T.getClass() );
			Class_Controller.ReportError( T, this.getClass().toString() + " PrintActionLog" );
		}
	}

	public void PrintErrorLog( Exception t2, String source ) throws Exception {
		try {
			Date Idag = new Date();
			String Logname = "Error log.txt";
			File ProductsFile = new File( Logname );

			if ( !ProductsFile.exists() ) {
				ProductsFile.createNewFile();
			}

			PrintStream utfil;
			FileOutputStream appendFilen = new FileOutputStream( ProductsFile, true );
			utfil = new PrintStream( appendFilen );

			utfil.println( (1900 + Idag.getYear()) + "/" + (1 + Idag.getMonth()) + "/" + Idag.getDate() + " " + Idag.getHours() + "." + Idag.getMinutes() + ":" + Idag.getSeconds() + " " + t2 );
			utfil.println( "source=" + source );

			utfil.println( "Throwable message: " + t2.getMessage() );
			utfil.println( "Throwable cause: " + t2.getCause() );
			utfil.println( "Throwable class: " + t2.getClass() );

			for ( int y = 0; y < t2.getStackTrace().length; y++ ) {
				utfil.println( " " );
				utfil.println( "Origin stack " + y + ": " );
				utfil.println( "Class: " + t2.getStackTrace()[y].getClassName() );
				utfil.println( "Method: " + t2.getStackTrace()[y].getMethodName() );
				utfil.println( "Line: " + t2.getStackTrace()[y].getLineNumber() );
			}
			utfil.println( " " );

			utfil.close();
			utfil = null;

		}
		catch ( IOException T ) {
			Class_Controller.AddProgressMessage( "Could not save action A: " + T.getMessage() + " " + T.getCause() + " " + T.getClass() );
			Class_Controller.ReportError( T, this.getClass().toString() + " PrintErrorLog" );
			if ( T.getMessage().equals( "Access is denied" ) ) {
				PrintErrorLog( t2, this.getClass().toString() + " PrintErrorLog" );
			}
			else {
				Class_Controller.ReportError( T, this.getClass().toString() + " PrintErrorLog" );
			}
		}
		catch ( Exception T ) {
			Class_Controller.AddProgressMessage( "Could not save action B: " + T.getMessage() + " " + T.getCause() + " " + T.getClass() );
			Class_Controller.ReportError( T, this.getClass().toString() + " PrintErrorLog" );
		}
	}

	public void Set_AutoPricing( String setting ) {
		//System.out.println( this.getClass().toString()+" Set_AutoPricing setting="+setting );
		AutoPricing = setting;
	}

	public boolean Get_SelectedSavetype() {
		//System.out.println( this.getClass().toString()+" Get_SelectedSavetype SaveAsCSV="+SaveAsCSV );
		return SaveAsCSV;
	}

	public String Get_SelectedAutopricing() {
		//System.out.println( this.getClass().toString()+" Get_SelectedAutopricing AutoPricing="+AutoPricing );
		return AutoPricing;
	}

}
