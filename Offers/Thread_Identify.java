package Offers;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Control.Controller;
import Searching.Object_SearchJob;

public class Thread_Identify extends Thread{

	Controller				Class_Controller;
	public Object_SearchJob	Jobb;

	String					Status;

	public Thread_Identify( Controller Class_Controller, Object_SearchJob hentetJobb ) {
		//if ( Class_Controller.isProductPage( Jobb.TargetOffer.Get_Adresse().Get_Adresse().toString() ) == true ) {
		//System.out.println( this.getClass().toString()+" constructor" );
		//}
		Jobb = hentetJobb;
		this.Class_Controller = Class_Controller;
	}

	public void run() {
		//System.out.println( this.getClass().toString()+" run A" );
		if ( Jobb.Get_Identify_Started() == true ) {
			return;
		}
		//System.out.println( this.getClass().toString()+" run B" );
		try {
			Status = "1";
			//System.out.println( this.getClass().toString()+" run C" );
			Scan();
		}
		catch ( Exception e ) {
			try {
				Class_Controller.ReportError( e, this.getClass().toString() + " run" );
			}
			catch ( Exception e1 ) {
				e1.printStackTrace();
			}
		}
	}

	protected void Scan() throws Exception {
		//Samler dataer fra html til produktobjekt
		Jobb.Set_Identify_Started( true, "identifying" );
		Status = "2";
		Jobb.Identification_Status = Status;
		String Buffer = Jobb.Get_CompleteContent().toLowerCase();
		Buffer = Buffer.replaceAll( "\r", "" );
		Buffer = Buffer.replaceAll( "~", " ca" );
		Status = "3";
		Jobb.Identification_Status = Status;

		FinnAntall( Buffer );

		Status = "A";
		Jobb.Identification_Status = Status;
		FinnItemType( Buffer );
		Status = "B";
		Jobb.Identification_Status = Status;

		FinnPris( Buffer );
		Status = "C";
		Jobb.Identification_Status = Status;

		FinnObjectID( Buffer );
		Status = "D";
		Jobb.Identification_Status = Status;

		FinnFrontbilde( Buffer );
		Status = "E";
		Jobb.Identification_Status = Status;

		FinnBilder( Buffer );
		Status = "F";
		Jobb.Identification_Status = Status;

		FinnKeywords( Buffer );
		Status = "G";
		Jobb.Identification_Status = Status;

		FinnDescription( Buffer );
		Status = "H";
		Jobb.Identification_Status = Status;
		FinnOptions( Buffer );
		FinnAntall_Generisk( Buffer );

		FinnTittel( Buffer );
		Status = "I";
		Jobb.Identification_Status = Status;

		FinnSelger( Buffer );
		Status = "J";
		Jobb.Identification_Status = Status;

		//vurderer om produkttypen skal inkluderes
		if ( this.Class_Controller.Get_SelectedSearchtype( this.getClass().toString() + " FinnItemType" ).equals( "Category" ) == true ) {
			Jobb.TargetOffer.Get_Adresse().Set_AcceptedCategory( Jobb.ItemTypeAccepted( Jobb.TargetOffer, Jobb.TargetOffer.Category, Jobb.TargetOffer.ParentCategory, Jobb.TargetOffer.Crumbs ), "does not fit category", Class_Controller, Jobb.TargetOffer.Category );
		}
		else {
			Jobb.TargetOffer.Get_Adresse().Set_AcceptedCategory( true, "fits category", Class_Controller, Jobb.TargetOffer.Category );
		}
		if ( Jobb.TargetOffer.Get_AcceptedProduct() == true ) {
			Jobb.Finalize();
		}
		Status = "K";
		Jobb.Identification_Status = Status;

		FinnRelationValue();
		Status = "L";
		Jobb.Identification_Status = Status;
		Buffer = "";
		Jobb.Set_Identify_Finished( true, "identified" );

		if ( Jobb.TargetOffer.Get_Adresse().IsImagePage == true ) {
			//bildeinfo lagres til tilhørende produkt
			Object_SearchJob Forelderjobb = Class_Controller.Get_Page_ObjectURL( Jobb.TargetOffer.Get_Adresse().ParentURL.ParentURL.Get_Adresse().toString() );
			if ( Forelderjobb != null ) {
				if ( Class_Controller.isProductPage( Jobb.TargetOffer.Get_Adresse().ParentURL.ParentURL.Get_Adresse().toString() ) == true ) {
					Forelderjobb.TargetOffer.ImageText = Forelderjobb.TargetOffer.ImageText + " " + Jobb.TargetOffer.ImageText;
					Forelderjobb.TargetOffer.SavedImages++;
					Forelderjobb.TargetOffer.Get_Adresse().OfferSaved = false;
					this.Class_Controller.SearchJobProgressed( Forelderjobb, this.getClass().toString() );
				}
			}
		}
		this.Class_Controller.SearchJobProgressed( Jobb, this.getClass().toString() );
		Status = "M";
		Jobb.Identification_Status = Status;
	}

	public void FinnAntall( String buffer ) throws Exception {
	}

	public void FinnAntall_Generisk( String buffer ) {
		Pattern Regex2 = Pattern.compile( "((\\d+)pcs)" );
		Matcher m2 = Regex2.matcher( buffer );
		m2 = Regex2.matcher( buffer );
		while ( m2.find() ) {
			String MatchFunnet = m2.group( 1 );
			Jobb.TargetOffer.Set_Antall( m2.group( 2 ), this.getClass().toString() + " FinnAntall_Generisk" );
		}
	}

	public void FinnOptions( String buffer ) {
	}

	public void FinnSelger( String buffer ) throws Exception {
	}

	public void FinnRelationValue() throws Exception {
		//System.out.println( this.getClass().toString()+" FinnRelationValue Crumbs="+Jobb.TargetOffer.Crumbs );
		Jobb.Set_SelfRelationValue( Class_Controller.CheckRelationValue_Job( Jobb ) );
	}

	public void FinnTittel( String buffer ) {
	}

	public void FinnDescription( String buffer ) throws Exception {
	}

	public void FinnKeywords( String buffer ) {
	}

	public void FinnBilder( String buffer ) throws Exception {
	}

	public void FinnFrontbilde( String buffer ) throws Exception {
	}

	public void FinnObjectID( String buffer ) throws Exception {
	}

	public void FinnPris( String buffer ) throws Exception {
	}

	public void FinnItemType( String buffer ) throws Exception {
	}

	public void ForkastURL( String buffer, String Reason ) throws Exception {
		Jobb.TargetOffer.Set_AcceptedProduct( false, Reason );
	}

}
