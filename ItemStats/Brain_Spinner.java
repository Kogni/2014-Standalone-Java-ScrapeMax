package ItemStats;

import java.util.Date;

import Control.Controller;
import Itemtypes.Brain_ProductIdentifier;
import Itemtypes.Brain_ProductIdentifier_Libida;
import Itemtypes.Object_Itemtype_Spinning;
import Offers.Object_Product_Offer;

public class Brain_Spinner{

	Brain_StatFinder				BSF;
	private Object_Product_Offer	OPO;

	public Brain_Spinner( Object_Product_Offer Offer ) {
		this.Set_OPO( Offer );
		BSF = new Brain_StatFinder();
	}

	private void GenerateSEO() throws Exception {
		//Genererer SEO-URL for produkt

		//1. Lager generell beskrivelse
		String Beskrivelse =
				Get_OPO().Subject + ", " + Get_OPO().Adjectives + ", " + Get_OPO().Beskrivelse_Bekledningsstil + ", " + Get_OPO().Beskrivelse_BrukerGruppe + ", " + Get_OPO().Beskrivelse_BruksOmraade + ", " + Get_OPO().Beskrivelse_BruksAnledning + ", " + Get_OPO().Beskrivelse_Stats + ", "
						+ Get_OPO().Beskrivelse_Tema + ", " + Get_OPO().Beskrivelse_Produsent + ", " + Get_OPO().Beskrivelse_Opprinnelse + ", " + Get_OPO().Beskrivelse_Egenskaper + ", " + Get_OPO().Beskrivelse_Standard + ", " + Get_OPO().Beskrivelse_BestandDeler;
		if ( Get_OPO().Class_Controller.Get_Settings_UserShop().equals( "Pinkie" ) ) {
			Get_OPO().Upload_SEOlink = Beskrivelse + ", " + Get_OPO().DynamiskHovedkategori + ", " + Get_OPO().DynamiskSubkategori + ", " + Get_OPO().Model;
		}
		else {
			Get_OPO().Upload_SEOlink = Beskrivelse + ", " + Get_OPO().DynamiskHovedkategori + ", " + Get_OPO().DynamiskSubkategori + ", " + Get_OPO().Upload_Model;
		}
		String Del2 = Get_OPO().Upload_SEOlink;

		//2. Legger til detaljer
		String Del1 = "";
		while ( Del2.indexOf( "," ) > -1 ) {
			String Frase = Del2.substring( 0, Del2.indexOf( "," ) );
			if ( Del1.indexOf( Frase ) == -1 ) { //sjekker at detaljen ikke dupliseres
				Del1 = Del1 + Frase + ", ";
			}
			Del2 = Del2.substring( (Del2.indexOf( "," ) + 2) );
		}

		//3. Kombinerer beskrivelse med detaljer
		Del1 = Del1 + Del2;
		Get_OPO().Upload_SEOlink = Del1;
		/*eksempel:
		 * Del2 = "modell, warhammer, space marine, "
		 * Del1 = "miniatyr, marine, games workshop";
		 * String OPO.Upload_SEOlink = "modell, warhammer, space marine, miniatyr, marine, games workshop"
		 */

		//4. Fjerner eventuelle symboler som ikke funker i URL
		Get_OPO().Upload_SEOlink = Get_OPO().Upload_SEOlink.replaceAll( ",", "" );
		Get_OPO().Upload_SEOlink = Get_OPO().Upload_SEOlink.replaceAll( " ", "-" );
		Get_OPO().Upload_SEOlink = Get_OPO().Upload_SEOlink.replaceAll( "null", "" );
		Get_OPO().Upload_SEOlink = Get_OPO().Upload_SEOlink.replaceAll( "\"", "-" );
		Get_OPO().Upload_SEOlink = Get_OPO().Upload_SEOlink.replaceAll( "\\\\", "-" );
		Get_OPO().Upload_SEOlink = Get_OPO().Upload_SEOlink.replaceAll( "/", "-" );
		Get_OPO().Upload_SEOlink = Get_OPO().Upload_SEOlink.replaceAll( "%", "" );
		Get_OPO().Upload_SEOlink = Get_OPO().Upload_SEOlink.replaceAll( ":", "-" );
		Get_OPO().Upload_SEOlink = Get_OPO().Upload_SEOlink.replaceAll( "\\?", "-" );
		Get_OPO().Upload_SEOlink = Get_OPO().Upload_SEOlink.replaceAll( "=", "-" );

		//5. Bytter ut æøå som kan skape problemer
		Get_OPO().Upload_SEOlink = Get_OPO().Upload_SEOlink.replaceAll( "&aring", "aa" );
		Get_OPO().Upload_SEOlink = Get_OPO().Upload_SEOlink.replaceAll( "&oslash", "oe" );
		Get_OPO().Upload_SEOlink = Get_OPO().Upload_SEOlink.replaceAll( "&aelig", "ae" );

		//6. Rydder opp URL
		Get_OPO().Upload_SEOlink = Get_OPO().Upload_SEOlink.replaceAll( "&", "-" );
		while ( Get_OPO().Upload_SEOlink.indexOf( "--" ) > -1 ) {
			Get_OPO().Upload_SEOlink = Get_OPO().Upload_SEOlink.replaceAll( "--", "-" );
		}
		if ( Get_OPO().Upload_SEOlink.substring( 0, 1 ).equals( "-" ) ) {
			Get_OPO().Upload_SEOlink = Get_OPO().Upload_SEOlink.substring( 1 );
		}

	}

	public void Finalize() throws Exception {
		//Klargjøring av produktdata før export
		Controller Class_Controller = Get_OPO().Class_Controller;

		String Settings = Class_Controller.Get_Settings_UserShop();
		Brain_ProductIdentifier ProductIdentifier;
		if ( Settings.equals( "Libida" ) ) {
			ProductIdentifier = new Brain_ProductIdentifier_Libida();
		}
		else if ( Settings.equals( "Larsenimport" ) ) {
			ProductIdentifier = new Brain_ProductIdentifier();
		}
		else if ( Settings.equals( "Pinkie" ) ) {
			ProductIdentifier = new Brain_ProductIdentifier();
		}
		else {

			ProductIdentifier = null;
		}

		if ( ProductIdentifier != null ) {
			//identifiserer språklige markører
			String TempSubject = ProductIdentifier.FindSubjects( Get_OPO().Upload_Image + " " + Get_OPO().Meta + " " + Get_OPO().Head, Get_OPO().Category, Get_OPO().ParentCategory, Get_OPO().TargetURL.Get_Adresse().toString() );
			if ( TempSubject.equals( "" ) == false ) {
				Get_OPO().Subject = TempSubject;
			}
			else if ( Get_OPO().Subject == null ) {
				Get_OPO().Subject = "?";
			}
			String ImageWords = Get_OPO().Upload_Image.replaceAll( "/", " " );
			String UsefulURL = Get_OPO().TargetURL.SimplifyURL( Get_OPO().TargetURL.Get_Adresse().toString() );
			Get_OPO().Beskrivelse_Bekledningsstil = BSF.Define_Bekledningsstil( Get_OPO().ProductStats + " " + ImageWords + " " + " " + Get_OPO().Head + " " + Get_OPO().Category + " " + Get_OPO().ParentCategory + " " + UsefulURL );
			Get_OPO().Beskrivelse_BrukerGruppe = BSF.Define_BrukerGruppe( Get_OPO().ProductStats + " " + ImageWords + " " + " " + Get_OPO().Head + " " + Get_OPO().Category + " " + Get_OPO().ParentCategory + " " + UsefulURL );
			Get_OPO().Beskrivelse_BruksOmraade = BSF.Define_BruksOmraade( Get_OPO().ProductStats + " " + ImageWords + " " + " " + Get_OPO().Head + " " + Get_OPO().Category + " " + Get_OPO().ParentCategory + " " + UsefulURL );
			Get_OPO().Beskrivelse_BruksAnledning = BSF.Define_BruksAnledning( Get_OPO().ProductStats + " " + ImageWords + " " + " " + Get_OPO().Head + " " + Get_OPO().Category + " " + Get_OPO().ParentCategory + " " + UsefulURL );
			Get_OPO().Beskrivelse_Stats = BSF.Define_Stats( Get_OPO().ProductStats + " " + ImageWords + " " + " " + Get_OPO().Head + " " + Get_OPO().Category + " " + Get_OPO().ParentCategory );
			Get_OPO().Beskrivelse_Produsent = BSF.Define_Produsent( Get_OPO().ProductStats + " " + ImageWords + " " + " " + Get_OPO().Head + " " + Get_OPO().Category + " " + Get_OPO().ParentCategory + " " + UsefulURL );
			Get_OPO().Beskrivelse_Opprinnelse = BSF.Define_Opprinnelse( Get_OPO().ProductStats + " " + ImageWords + " " + " " + Get_OPO().Head + " " + Get_OPO().Category + " " + Get_OPO().ParentCategory + " " + UsefulURL );
			Get_OPO().Beskrivelse_Egenskaper = BSF.Define_Egenskaper( Get_OPO().ProductStats + " " + ImageWords + " " + " " + Get_OPO().Head + " " + Get_OPO().Category + " " + Get_OPO().ParentCategory + " " + UsefulURL );
			Get_OPO().Beskrivelse_Standard = BSF.Define_Standard( Get_OPO().ProductStats + " " + ImageWords + " " + " " + Get_OPO().Head + " " + Get_OPO().Category + " " + Get_OPO().ParentCategory + " " + UsefulURL );
			Get_OPO().Beskrivelse_BestandDeler = BSF.Define_BestandDeler( Get_OPO().ProductStats + " " + ImageWords + " " + " " + Get_OPO().Head + " " + Get_OPO().Category + " " + Get_OPO().ParentCategory + " " + UsefulURL );
			String BeskrivelseFoerTema =
					Get_OPO().Beskrivelse_Bekledningsstil + Get_OPO().Adjectives + " " + Get_OPO().Subject + ", " + Get_OPO().Beskrivelse_BrukerGruppe + Get_OPO().Beskrivelse_BruksOmraade + Get_OPO().Beskrivelse_BruksAnledning + Get_OPO().Beskrivelse_Stats + Get_OPO().Beskrivelse_Egenskaper
							+ Get_OPO().Beskrivelse_Standard + Get_OPO().Beskrivelse_Produsent + Get_OPO().Beskrivelse_Opprinnelse + Get_OPO().Beskrivelse_Tema + "(" + Get_OPO().Beskrivelse_BestandDeler + ")";
			Get_OPO().Beskrivelse_Tema = BSF.Define_Tema( Get_OPO().ProductStats + " " + ImageWords + " " + " " + Get_OPO().Head + " " + UsefulURL, BeskrivelseFoerTema );
			Get_OPO().Adjectives = BSF.Define_Adjectives( Get_OPO().ProductStats + " " + ImageWords + " " + Get_OPO().Head + " " + Get_OPO().Category + " " + Get_OPO().ParentCategory + " " + UsefulURL );

			String Beskrivelse =
					Get_OPO().Beskrivelse_Bekledningsstil + Get_OPO().Adjectives + " " + Get_OPO().Subject + ", " + Get_OPO().Beskrivelse_BrukerGruppe + Get_OPO().Beskrivelse_BruksOmraade + Get_OPO().Beskrivelse_BruksAnledning + Get_OPO().Beskrivelse_Stats + Get_OPO().Beskrivelse_Egenskaper
							+ Get_OPO().Beskrivelse_Standard + Get_OPO().Beskrivelse_Produsent + Get_OPO().Beskrivelse_Opprinnelse + Get_OPO().Beskrivelse_Tema + "(" + Get_OPO().Beskrivelse_BestandDeler + ")";

			//Sjekker at ingen ord gjentas
			String Del2 = Beskrivelse;
			String Del1 = "";
			while ( Del2.indexOf( "," ) > -1 ) {
				String Frase = Del2.substring( 0, Del2.indexOf( "," ) );
				if ( Del1.indexOf( Frase ) == -1 ) {
					Del1 = Del1 + Frase + ", ";
				}
				Del2 = Del2.substring( (Del2.indexOf( "," ) + 2) );
			}
			Del1 = Del1 + Del2;
			Beskrivelse = Del1;

			//vurderer produkttype
			Get_OPO().DynamiskHovedkategori = ProductIdentifier.Define_DynamiskHovedkategori( Get_OPO().ParentCategory, Get_OPO().Subject, Beskrivelse, Get_OPO().TargetURL.Get_Adresse().toString(), Get_OPO().Head );
			Get_OPO().DynamiskSubkategori = ProductIdentifier.Define_DynamiskSubkategori( Get_OPO().Category, Get_OPO().Subject, Beskrivelse, Get_OPO().Head, Get_OPO().TargetURL.Get_Adresse().toString(), Get_OPO().Beskrivelse_BestandDeler );

			//Dobbeltsjekker subjektet
			Get_OPO().Subject = ProductIdentifier.RenameSubject( Get_OPO().Subject, Get_OPO().DynamiskHovedkategori, Get_OPO().DynamiskSubkategori, Beskrivelse );

		}
		else {
			Get_OPO().DynamiskHovedkategori = Get_OPO().ParentCategory;
			Get_OPO().DynamiskSubkategori = Get_OPO().Category;
		}
		if ( Class_Controller.Get_Settings_UserShop().equals( "Pinkie" ) ) {
			Get_OPO().DynamiskHovedkategori = "Importert";
		}
		/*produktnavn-varemerke-bruksområde-stats-standard-adjektiver?
		 * eks:
		 * Warriors of Chaos - Games Workshop - Warhammer - Chaos - 28mm
		 */

		//Lager beskrivende produktnavn, som brukes som overskrift
		SpinText_Topic();
		String Del2 = Get_OPO().Upload_Produktnavn;
		String Del1 = "";
		while ( Del2.indexOf( "," ) > -1 ) {
			String Frase = Del2.substring( 0, Del2.indexOf( "," ) );
			if ( Del1.indexOf( Frase ) == -1 ) {
				Del1 = Del1 + Frase + ", ";
			}
			Del2 = Del2.substring( (Del2.indexOf( "," ) + 2) );
		}
		Del1 = Del1 + Del2;
		try {
			Get_OPO().Upload_Produktnavn = Get_OPO().Antall + "x " + Del1;
		}
		catch ( Exception e ) {
			this.OPO.Class_Controller.ReportError( e, this.getClass().toString() + " Finalize failed at antall" );
		}
		//Lager undertekst til bilder i produktbeskrivelse, for forbedret SEO
		String Undertekst = Get_OPO().Upload_Produktnavn;
		Undertekst = Undertekst.replaceAll( ", ", " " );
		Get_OPO().ImageText = Get_OPO().ImageText.replaceAll( "ALTIMAGETEXT", Get_OPO().Subject );

		//sensurerer upassende fraser
		Get_OPO().Head = Get_OPO().Head.replaceAll( " from reliable ", " " );
		Get_OPO().Head = Get_OPO().Head.replaceAll( " suppliers ", " " );
		Get_OPO().Head = Get_OPO().Head.replaceAll( " buy ", " " );
		Get_OPO().Head = Get_OPO().Head.replaceAll( "wholesale", "" );

		Date Idag = new Date();

		if ( Class_Controller.Get_Settings_UserShop().equals( "Larsenimport" ) ) {
			//skreddersydde produktbeskrivelser
			SpinText_LarsenImport();
		}
		else if ( Class_Controller.Get_Settings_UserShop().equals( "Pinkie" ) ) {
			//kun bilder med bildetekst
			Get_OPO().Upload_Description = Get_OPO().Upload_Description + "<br>" + Get_OPO().ImageText;
		}
		else {
			//mer beskrivende informasjon
			Get_OPO().Upload_Description = Get_OPO().Upload_Description + "<br><strong>Valgmuligheter</strong>: " + Get_OPO().OptionsText;
			Get_OPO().Upload_Description = Get_OPO().Upload_Description + "<br><strong>Antall</strong>: " + Get_OPO().Antall;
			Get_OPO().Upload_Description = Get_OPO().Upload_Description + "<br><strong>Annonsetekst</strong>: " + Get_OPO().Description;
			Get_OPO().Upload_Description = Get_OPO().Upload_Description.replaceAll( "china", " " );
			Get_OPO().Upload_Description = Get_OPO().Upload_Description.replaceAll( Get_OPO().TargetURL.Get_Domain_Lang(), " " );
			Get_OPO().Upload_Description = Get_OPO().Upload_Description + "<br>" + Get_OPO().ImageText;
		}
		//noterer dato for generering, mtp programoppdateringer
		Get_OPO().Upload_Description = Get_OPO().Upload_Description + "<br>" + Idag.getDate() + "." + (Idag.getMonth() + 1) + "." + (Idag.getYear() + 1900) + " " + Idag.getHours() + ":" + Idag.getMinutes() + "<br>";
		Get_OPO().Upload_Description = Get_OPO().Upload_Description + "</p></p></div>";
		Get_OPO().Upload_Description = Get_OPO().Upload_Description.replaceAll( "  ", " " );

		//fyller ut øvrige nødvendige dataer
		Get_OPO().Upload_MetaDesc = Get_OPO().TargetURL.Get_Adresse().toString();
		Get_OPO().Upload_MetaKey = Get_OPO().Upload_Produktnavn;
		Get_OPO().Upload_SKU = Get_OPO().TargetURL.Get_Domain_Forkortet() + "-" + Get_OPO().Seller;
		Get_OPO().Upload_UPC = Get_OPO().TargetURL.Get_Adresse().toString();
		Get_OPO().Upload_Location = Get_OPO().TargetURL.Get_Adresse().toString();
		Get_OPO().Upload_Price = Get_OPO().Price;
		Get_OPO().Upload_Quantity = "0";
		Get_OPO().Upload_MinQuant = "0";
		Get_OPO().Upload_Substract = "false";
		Get_OPO().Upload_RequiresShipping = "true";
		Get_OPO().Upload_Length = "";
		Get_OPO().Upload_Height = "";
		Get_OPO().Upload_Width = "";
		Get_OPO().Upload_Weigth = "";
		Get_OPO().Upload_Status = "true";
		Get_OPO().Upload_SortOrder = "1";
		Get_OPO().Upload_Manufacturer = "";
		Get_OPO().Upload_Category = Get_OPO().DynamiskHovedkategori;
		Get_OPO().Upload_SubCategory = Get_OPO().DynamiskSubkategori;
		Get_OPO().Upload_Download = "";
		GenerateSEO();
	}

	private void SpinText_Topic() {
		Get_OPO().Upload_Produktnavn = Get_OPO().Subject;
		Object_Itemtype_Spinning ITI = new Object_Itemtype_Spinning( Get_OPO().Subject );
		if ( Get_OPO().DynamiskHovedkategori.equalsIgnoreCase( "Smykker" ) ) {
			if ( Get_OPO().Beskrivelse_BrukerGruppe.equalsIgnoreCase( "" ) == false ) {
				Get_OPO().Upload_Produktnavn = Get_OPO().Upload_Produktnavn + ", for " + Get_OPO().Beskrivelse_BrukerGruppe;
			}
			if ( Get_OPO().Beskrivelse_Tema.equalsIgnoreCase( "" ) == false ) {
				Get_OPO().Upload_Produktnavn = Get_OPO().Upload_Produktnavn + ", med " + Get_OPO().Beskrivelse_Tema;
			}
			if ( Get_OPO().Beskrivelse_Produsent.equalsIgnoreCase( "" ) == false ) {
				Get_OPO().Upload_Produktnavn = Get_OPO().Upload_Produktnavn + ", av " + Get_OPO().Beskrivelse_Produsent;
			}
			if ( Get_OPO().Beskrivelse_BruksAnledning.equalsIgnoreCase( "" ) == false ) {
				Get_OPO().Upload_Produktnavn = Get_OPO().Upload_Produktnavn + ", til " + Get_OPO().Beskrivelse_BruksAnledning;
			}
			if ( Get_OPO().Beskrivelse_Bekledningsstil.equalsIgnoreCase( "" ) == false ) {
				Get_OPO().Upload_Produktnavn = Get_OPO().Upload_Produktnavn + ", " + Get_OPO().Beskrivelse_Bekledningsstil;
			}
			if ( Get_OPO().Beskrivelse_Opprinnelse.equalsIgnoreCase( "" ) == false ) {
				Get_OPO().Upload_Produktnavn = Get_OPO().Upload_Produktnavn + ", fra " + Get_OPO().Beskrivelse_Opprinnelse;
			}

		}
		else {
			if ( Get_OPO().Beskrivelse_BrukerGruppe.equalsIgnoreCase( "" ) == false ) {
				Get_OPO().Upload_Produktnavn = Get_OPO().Upload_Produktnavn + ", for " + Get_OPO().Beskrivelse_BrukerGruppe;
			}
			if ( Get_OPO().Beskrivelse_Tema.equalsIgnoreCase( "" ) == false ) {
				Get_OPO().Upload_Produktnavn = Get_OPO().Upload_Produktnavn + ", med " + Get_OPO().Beskrivelse_Tema;
			}
			if ( Get_OPO().Beskrivelse_Produsent.equalsIgnoreCase( "" ) == false ) {
				Get_OPO().Upload_Produktnavn = Get_OPO().Upload_Produktnavn + ", av " + Get_OPO().Beskrivelse_Produsent;
			}
			if ( Get_OPO().Beskrivelse_BruksAnledning.equalsIgnoreCase( "" ) == false ) {
				Get_OPO().Upload_Produktnavn = Get_OPO().Upload_Produktnavn + ", til " + Get_OPO().Beskrivelse_BruksAnledning;
			}
			if ( Get_OPO().Beskrivelse_Bekledningsstil.equalsIgnoreCase( "" ) == false ) {
				Get_OPO().Upload_Produktnavn = Get_OPO().Upload_Produktnavn + ", " + Get_OPO().Beskrivelse_Bekledningsstil;
			}
			if ( Get_OPO().Beskrivelse_Opprinnelse.equalsIgnoreCase( "" ) == false ) {
				Get_OPO().Upload_Produktnavn = Get_OPO().Upload_Produktnavn + ", fra " + Get_OPO().Beskrivelse_Opprinnelse;
			}

			if ( Get_OPO().Adjectives.equalsIgnoreCase( "" ) == false ) {
				Get_OPO().Upload_Produktnavn = Get_OPO().Upload_Produktnavn + ", " + Get_OPO().Adjectives;
			}
			if ( Get_OPO().Beskrivelse_BruksOmraade.equalsIgnoreCase( "" ) == false ) {
				Get_OPO().Upload_Produktnavn = Get_OPO().Upload_Produktnavn + ", til " + Get_OPO().Beskrivelse_BruksOmraade;
			}
			if ( Get_OPO().Beskrivelse_Stats.equalsIgnoreCase( "" ) == false ) {
				Get_OPO().Upload_Produktnavn = Get_OPO().Upload_Produktnavn + ", type " + Get_OPO().Beskrivelse_Stats;
			}
			if ( Get_OPO().Beskrivelse_Egenskaper.equalsIgnoreCase( "" ) == false ) {
				Get_OPO().Upload_Produktnavn = Get_OPO().Upload_Produktnavn + ", med " + Get_OPO().Beskrivelse_Egenskaper;
			}
			if ( Get_OPO().Beskrivelse_Standard.equalsIgnoreCase( "" ) == false ) {
				Get_OPO().Upload_Produktnavn = Get_OPO().Upload_Produktnavn + ", " + Get_OPO().Beskrivelse_Standard;
			}

		}
		if ( Get_OPO().Beskrivelse_Tema.equalsIgnoreCase( "" ) == false ) {
			Get_OPO().Upload_Produktnavn = Get_OPO().Upload_Produktnavn + ", " + "(" + Get_OPO().Beskrivelse_BestandDeler + ")";
		}
	}

	private void SpinText_LarsenImport() {
		Get_OPO().Upload_Description = Get_OPO().Upload_Description + "<b><h1>Produktbeskrivelse</h1></b><br>";
		Get_OPO().Upload_Description = Get_OPO().Upload_Description + "Antall produkter per kj&oslashp: <b>" + Get_OPO().Antall + "</b><br><br>";
		Object_Itemtype_Spinning ITI = new Object_Itemtype_Spinning( Get_OPO().Subject );
		if ( Get_OPO().DynamiskHovedkategori.equalsIgnoreCase( "Smykker" ) ) {
			Get_OPO().Upload_Description = Get_OPO().Upload_Description + "Pen" + ITI.Endelse + " <b>" + ITI.Subjekt + "</b> for fest og hverdag!<br>";
			if ( Get_OPO().Beskrivelse_BestandDeler.equals( "" ) == false ) {
				Get_OPO().Upload_Description = Get_OPO().Upload_Description + "Laget av <b>" + Get_OPO().Beskrivelse_BestandDeler + "</b>";
			}
			if ( Get_OPO().Beskrivelse_Tema.equals( "" ) == false ) {
				Get_OPO().Upload_Description = Get_OPO().Upload_Description + " inspirert av <b>" + Get_OPO().Beskrivelse_Tema + "</b>";
			}
			Get_OPO().Upload_Description = Get_OPO().Upload_Description + ".<br>";

			if ( Get_OPO().Beskrivelse_Produsent.equals( "" ) == false ) {
				Get_OPO().Upload_Description = Get_OPO().Upload_Description + "Produsert av <b>" + Get_OPO().Beskrivelse_Produsent + "</b>.<br>";
			}
			if ( Get_OPO().Beskrivelse_Opprinnelse.equals( "" ) == false ) {
				Get_OPO().Upload_Description = Get_OPO().Upload_Description + "Produsert i <b>" + Get_OPO().Beskrivelse_Opprinnelse + "</b>.<br>";
			}

		}
		else if ( Get_OPO().DynamiskHovedkategori.equalsIgnoreCase( "Sko" ) ) {
			Get_OPO().Upload_Description = Get_OPO().Upload_Description + "Stilige og komfortable <b>" + ITI.Subjekt + "</b>";
			if ( Get_OPO().Beskrivelse_Produsent.equals( "" ) == false ) {
				Get_OPO().Upload_Description = Get_OPO().Upload_Description + ", produsert av <b>" + Get_OPO().Beskrivelse_Produsent + "</b><br>";
			}
			Get_OPO().Upload_Description = Get_OPO().Upload_Description + ".<br>";
			if ( (Get_OPO().Beskrivelse_BruksOmraade.equals( "" ) == false) || (Get_OPO().Beskrivelse_BruksAnledning.equals( "" ) == false) ) {
				Get_OPO().Upload_Description = Get_OPO().Upload_Description + "Passer fint for <b>" + Get_OPO().Beskrivelse_BruksOmraade + Get_OPO().Beskrivelse_BruksAnledning + "</b><br>";
			}

			if ( Get_OPO().Beskrivelse_Opprinnelse.equals( "" ) == false ) {
				Get_OPO().Upload_Description = Get_OPO().Upload_Description + "Produsert i <b>" + Get_OPO().Beskrivelse_Opprinnelse + "</b>.<br>";
			}

			if ( Get_OPO().Beskrivelse_BestandDeler.equals( "" ) == false ) {
				Get_OPO().Upload_Description = Get_OPO().Upload_Description + "Materialer: <b>" + Get_OPO().Beskrivelse_BestandDeler + "</b><br>";
			}

			if ( Get_OPO().Beskrivelse_Stats.equals( "" ) == false ) {
				Get_OPO().Upload_Description = Get_OPO().Upload_Description + "Stats: <b>" + Get_OPO().Beskrivelse_Stats + "</b><br>";
			}
			if ( Get_OPO().Beskrivelse_Egenskaper.equals( "" ) == false ) {
				Get_OPO().Upload_Description = Get_OPO().Upload_Description + "Egenskaper: <b>" + Get_OPO().Beskrivelse_Egenskaper + "</b><br>";
			}
			if ( Get_OPO().Beskrivelse_Standard.equals( "" ) == false ) {
				Get_OPO().Upload_Description = Get_OPO().Upload_Description + "Standard: <b>" + Get_OPO().Beskrivelse_Standard + "</b><br>";
			}
			if ( Get_OPO().Adjectives.equals( "" ) == false ) {
				Get_OPO().Upload_Description = Get_OPO().Upload_Description + "Beskrivelse: " + Get_OPO().Adjectives + "<br>";
			}

		}
		else if ( Get_OPO().DynamiskHovedkategori.equals( "Kl&aeligr" ) ) {
			Get_OPO().Upload_Description = Get_OPO().Upload_Description + "Komfortabel" + ITI.Endelse + " <b>" + ITI.Subjekt;
			if ( Get_OPO().Beskrivelse_BestandDeler.equals( "" ) == false ) {
				Get_OPO().Upload_Description = Get_OPO().Upload_Description + " laget av <b>" + Get_OPO().Beskrivelse_BestandDeler + "</b>,";
			}
			if ( Get_OPO().Beskrivelse_Opprinnelse.equals( "" ) == false ) {
				Get_OPO().Upload_Description = Get_OPO().Upload_Description + " produsert i <b>" + Get_OPO().Beskrivelse_Opprinnelse + "</b>";
			}
			Get_OPO().Upload_Description = Get_OPO().Upload_Description + ".<br>";

			if ( Get_OPO().Beskrivelse_Stats.equals( "" ) == false ) {
				Get_OPO().Upload_Description = Get_OPO().Upload_Description + "Stats: <b>" + Get_OPO().Beskrivelse_Stats + "</b><br>";
			}
			if ( Get_OPO().Beskrivelse_Tema.equals( "" ) == false ) {
				Get_OPO().Upload_Description = Get_OPO().Upload_Description + "Tema: <b>" + Get_OPO().Beskrivelse_Tema + "</b><br>";
			}
			if ( Get_OPO().Beskrivelse_Produsent.equals( "" ) == false ) {
				Get_OPO().Upload_Description = Get_OPO().Upload_Description + "Produsent: <b>" + Get_OPO().Beskrivelse_Produsent + "</b><br>";
			}
			if ( Get_OPO().Beskrivelse_Egenskaper.equals( "" ) == false ) {
				Get_OPO().Upload_Description = Get_OPO().Upload_Description + "Egenskaper: <b>" + Get_OPO().Beskrivelse_Egenskaper + "</b><br>";
			}
			if ( Get_OPO().Beskrivelse_Standard.equals( "" ) == false ) {
				Get_OPO().Upload_Description = Get_OPO().Upload_Description + "Standard: <b>" + Get_OPO().Beskrivelse_Standard + "</b><br>";
			}

			if ( Get_OPO().Adjectives.equals( "" ) == false ) {
				Get_OPO().Upload_Description = Get_OPO().Upload_Description + "Beskrivelse: " + Get_OPO().Adjectives + "<br>";
			}
		}
		else if ( Get_OPO().Subject.equalsIgnoreCase( "Modellfigur" ) ) {
			if ( Get_OPO().Beskrivelse_Produsent.equals( "" ) == false ) {
				Get_OPO().Upload_Description = Get_OPO().Upload_Description + "Produsent: <b>" + Get_OPO().Beskrivelse_Produsent + "</b><br>";
			}
			if ( Get_OPO().Beskrivelse_Opprinnelse.equals( "" ) == false ) {
				Get_OPO().Upload_Description = Get_OPO().Upload_Description + "Produsert i <b>" + Get_OPO().Beskrivelse_Opprinnelse + "</b><br>";
			}
			if ( Get_OPO().Beskrivelse_Stats.equals( "" ) == false ) {
				Get_OPO().Upload_Description = Get_OPO().Upload_Description + "Skala: <b>" + Get_OPO().Beskrivelse_Stats + "</b><br>";
			}
			if ( Get_OPO().Beskrivelse_BestandDeler.equals( "" ) == false ) {
				Get_OPO().Upload_Description = Get_OPO().Upload_Description + "Materiale: <b>" + Get_OPO().Beskrivelse_BestandDeler + "</b><br>";
			}
			if ( Get_OPO().Beskrivelse_Tema.equals( "" ) == false ) {
				Get_OPO().Upload_Description = Get_OPO().Upload_Description + "Tema: <b>" + Get_OPO().Beskrivelse_Tema + "</b><br>";
			}

			if ( Get_OPO().Beskrivelse_BrukerGruppe.equals( "" ) == false ) {
				Get_OPO().Upload_Description = Get_OPO().Upload_Description + "Brukergruppe: <b>" + Get_OPO().Beskrivelse_BrukerGruppe + "</b><br>";
			}
			if ( Get_OPO().Beskrivelse_BruksOmraade.equals( "" ) == false ) {
				Get_OPO().Upload_Description = Get_OPO().Upload_Description + "Bruksomr&aringde: <b>" + Get_OPO().Beskrivelse_BruksOmraade + "</b><br>";
			}
			if ( Get_OPO().Beskrivelse_BruksAnledning.equals( "" ) == false ) {
				Get_OPO().Upload_Description = Get_OPO().Upload_Description + "Bruksanledning: <b>" + Get_OPO().Beskrivelse_BruksAnledning + "</b><br>";
			}
			if ( Get_OPO().Beskrivelse_Egenskaper.equals( "" ) == false ) {
				Get_OPO().Upload_Description = Get_OPO().Upload_Description + "Egenskaper: <b>" + Get_OPO().Beskrivelse_Egenskaper + "</b><br>";
			}
			if ( Get_OPO().Beskrivelse_Standard.equals( "" ) == false ) {
				Get_OPO().Upload_Description = Get_OPO().Upload_Description + "Standard: <b>" + Get_OPO().Beskrivelse_Standard + "</b><br>";
			}
			if ( Get_OPO().Adjectives.equals( "" ) == false ) {
				Get_OPO().Upload_Description = Get_OPO().Upload_Description + "Beskrivelse: " + Get_OPO().Adjectives + "<br>";
			}
		}
		else if ( Get_OPO().Subject.equalsIgnoreCase( "Miniatyrfigur" ) ) {
			if ( Get_OPO().Beskrivelse_Produsent.equals( "" ) == false ) {
				Get_OPO().Upload_Description = Get_OPO().Upload_Description + "Produsent: <b>" + Get_OPO().Beskrivelse_Produsent + "</b><br>";
			}
			if ( Get_OPO().Beskrivelse_Opprinnelse.equals( "" ) == false ) {
				Get_OPO().Upload_Description = Get_OPO().Upload_Description + "Produsert i <b>" + Get_OPO().Beskrivelse_Opprinnelse + "</b><br>";
			}
			if ( Get_OPO().Beskrivelse_Stats.equals( "" ) == false ) {
				Get_OPO().Upload_Description = Get_OPO().Upload_Description + "Skala: <b>" + Get_OPO().Beskrivelse_Stats + "</b><br>";
			}
			if ( Get_OPO().Beskrivelse_BestandDeler.equals( "" ) == false ) {
				Get_OPO().Upload_Description = Get_OPO().Upload_Description + "Materiale: <b>" + Get_OPO().Beskrivelse_BestandDeler + "</b><br>";
			}
			if ( Get_OPO().Beskrivelse_Tema.equals( "" ) == false ) {
				Get_OPO().Upload_Description = Get_OPO().Upload_Description + "Tema: <b>" + Get_OPO().Beskrivelse_Tema + "</b><br>";
			}

			if ( Get_OPO().Beskrivelse_BrukerGruppe.equals( "" ) == false ) {
				Get_OPO().Upload_Description = Get_OPO().Upload_Description + "Brukergruppe: <b>" + Get_OPO().Beskrivelse_BrukerGruppe + "</b><br>";
			}
			if ( Get_OPO().Beskrivelse_BruksOmraade.equals( "" ) == false ) {
				Get_OPO().Upload_Description = Get_OPO().Upload_Description + "Bruksomr&aringde: <b>" + Get_OPO().Beskrivelse_BruksOmraade + "</b><br>";
			}
			if ( Get_OPO().Beskrivelse_BruksAnledning.equals( "" ) == false ) {
				Get_OPO().Upload_Description = Get_OPO().Upload_Description + "Bruksanledning: <b>" + Get_OPO().Beskrivelse_BruksAnledning + "</b><br>";
			}
			if ( Get_OPO().Beskrivelse_Egenskaper.equals( "" ) == false ) {
				Get_OPO().Upload_Description = Get_OPO().Upload_Description + "Egenskaper: <b>" + Get_OPO().Beskrivelse_Egenskaper + "</b><br>";
			}
			if ( Get_OPO().Beskrivelse_Standard.equals( "" ) == false ) {
				Get_OPO().Upload_Description = Get_OPO().Upload_Description + "Standard: <b>" + Get_OPO().Beskrivelse_Standard + "</b><br>";
			}
			if ( Get_OPO().Adjectives.equals( "" ) == false ) {
				Get_OPO().Upload_Description = Get_OPO().Upload_Description + "Beskrivelse: " + Get_OPO().Adjectives + "<br>";
			}
		}
		else {
			if ( Get_OPO().Beskrivelse_BrukerGruppe.equals( "" ) == false ) {
				Get_OPO().Upload_Description = Get_OPO().Upload_Description + "Brukergruppe: <b>" + Get_OPO().Beskrivelse_BrukerGruppe + "</b><br>";
			}
			if ( Get_OPO().Beskrivelse_BruksOmraade.equals( "" ) == false ) {
				Get_OPO().Upload_Description = Get_OPO().Upload_Description + "Bruksomr&aringde: <b>" + Get_OPO().Beskrivelse_BruksOmraade + "</b><br>";
			}
			if ( Get_OPO().Beskrivelse_BruksAnledning.equals( "" ) == false ) {
				Get_OPO().Upload_Description = Get_OPO().Upload_Description + "Bruksanledning: <b>" + Get_OPO().Beskrivelse_BruksAnledning + "</b><br>";
			}
			if ( Get_OPO().Beskrivelse_Stats.equals( "" ) == false ) {
				Get_OPO().Upload_Description = Get_OPO().Upload_Description + "Stats: <b>" + Get_OPO().Beskrivelse_Stats + "</b><br>";
			}
			if ( Get_OPO().Beskrivelse_Tema.equals( "" ) == false ) {
				Get_OPO().Upload_Description = Get_OPO().Upload_Description + "Tema: <b>" + Get_OPO().Beskrivelse_Tema + "</b><br>";
			}
			if ( Get_OPO().Beskrivelse_Produsent.equals( "" ) == false ) {
				Get_OPO().Upload_Description = Get_OPO().Upload_Description + "Produsent: <b>" + Get_OPO().Beskrivelse_Produsent + "</b><br>";
			}
			if ( Get_OPO().Beskrivelse_Opprinnelse.equals( "" ) == false ) {
				Get_OPO().Upload_Description = Get_OPO().Upload_Description + "Opprinnelse: <b>" + Get_OPO().Beskrivelse_Opprinnelse + "</b><br>";
			}
			if ( Get_OPO().Beskrivelse_Egenskaper.equals( "" ) == false ) {
				Get_OPO().Upload_Description = Get_OPO().Upload_Description + "Egenskaper: <b>" + Get_OPO().Beskrivelse_Egenskaper + "</b><br>";
			}
			if ( Get_OPO().Beskrivelse_Standard.equals( "" ) == false ) {
				Get_OPO().Upload_Description = Get_OPO().Upload_Description + "Standard: <b>" + Get_OPO().Beskrivelse_Standard + "</b><br>";
			}
			if ( Get_OPO().Beskrivelse_BestandDeler.equals( "" ) == false ) {
				Get_OPO().Upload_Description = Get_OPO().Upload_Description + "BestandDeler: <b>" + Get_OPO().Beskrivelse_BestandDeler + "</b><br>";
			}
			if ( Get_OPO().Adjectives.equals( "" ) == false ) {
				Get_OPO().Upload_Description = Get_OPO().Upload_Description + "Beskrivelse: " + Get_OPO().Adjectives + "<br>";
			}
		}
		//uansett produkttype
		Get_OPO().Upload_Description = Get_OPO().Upload_Description + "Beskrivelse fra leverand&oslashr: <br>";
		Get_OPO().Upload_Description = Get_OPO().Upload_Description + Get_OPO().Head + "<br>";
		Get_OPO().Upload_Description = Get_OPO().Upload_Description.replaceAll( "china", " " );
		Get_OPO().Upload_Description = Get_OPO().Upload_Description.replaceAll( Get_OPO().TargetURL.Get_Domain_Lang(), " " );
		Get_OPO().Upload_Description = Get_OPO().Upload_Description.replaceAll( ".com:", "" );
		Get_OPO().Upload_Description = Get_OPO().Upload_Description + Get_OPO().ImageText;
		Get_OPO().Upload_Description = Get_OPO().Upload_Description + "<br><a href=\"http://www.larsenimport.no/index.php?route=product/search&filter_name=" + Get_OPO().Subject + "\">Finn mer om " + Get_OPO().Subject + " hos Larsenimport.no</a>";
		Get_OPO().Upload_Description = Get_OPO().Upload_Description + "<br><a href=\"http://www.pynting.no/index.php?route=product/search&filter_name=" + Get_OPO().Subject + "\">Finn mer om " + Get_OPO().Subject + " hos Pynting.no</a>";
	}

	public Object_Product_Offer Get_OPO() {
		return OPO;
	}

	public void Set_OPO( Object_Product_Offer oPO ) {
		OPO = oPO;
	}

}
