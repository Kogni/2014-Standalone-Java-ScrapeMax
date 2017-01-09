package Itemtypes;

public class Object_Itemtype_Spinning {

	public String Subjekt;
	public String Artikkel;
	public String Endelse;
	
	public Object_Itemtype_Spinning( String Subjekt ) {
		this.Subjekt = Subjekt;
		
		GenererInfo();
	}
	
	private void GenererInfo() {
		
		//smykker
		if ( Subjekt.equals( "Anheng" ) ) {
			Artikkel = "et";
			Endelse = "t";
		} else if ( Subjekt.equals( "&oslashredobber" ) ) {
			Artikkel = "et par";
			Endelse = "e";
		} else if ( Subjekt.equals( "Bangle" ) ) {
			Artikkel = "en";
			Endelse = "";
		} else if ( Subjekt.equals( "Halskjede" ) ) {
			Artikkel = "et";
			Endelse = "t";
		} else if ( Subjekt.equals( "Smykkesett" ) ) {
			Artikkel = "et";
			Endelse = "t";
		} else if ( Subjekt.equals( "Armb&aringnd" ) ) {
			Artikkel = "et";
			Endelse = "t";
		} else if ( Subjekt.equals( "Ring" ) ) {
			Artikkel = "en";
			Endelse = "";
		} else if ( Subjekt.equals( "Anklet" ) ) {
			Artikkel = "en";
			Endelse = "";
		} else if ( Subjekt.equals( "Brosje" ) ) {
			Artikkel = "en";
			Endelse = "";
		} else if ( Subjekt.equals( "Piercing" ) ) {
			Artikkel = "en";
			Endelse = "";
		} else if ( Subjekt.equals( "Tiara" ) ) {
			Artikkel = "en";
			Endelse = "";
		}
		//skotøy
		 else if ( Subjekt.equals( "Sko" ) ) {
			Artikkel = "et par";
			Endelse = "e";
		} else if ( Subjekt.equals( "Boots" ) ) {
			Artikkel = "et par";
			Endelse = "e";
		} else if ( Subjekt.equals( "Sneakers" ) ) {
			Artikkel = "et par";
			Endelse = "e";
		} else if ( Subjekt.equals( "Sandaler" ) ) {
			Artikkel = "et par";
			Endelse = "e";
		} else if ( Subjekt.equals( "Platformsko" ) ) {
			Artikkel = "et par";
			Endelse = "e";
		} else if ( Subjekt.equals( "Pumps" ) ) {
			Artikkel = "et par";
			Endelse = "e";
		}
		//lugasje
		 else if ( Subjekt.equals( "Bagg" ) ) {
			Artikkel = "en";
			Endelse = "";
		}
		//leker
		 else if ( Subjekt.equals( "Perler" ) ) {
			Artikkel = "et sett";
			Endelse = "e";
		} else if ( Subjekt.equals( "Leke" ) ) {
			Artikkel = "en";
			Endelse = "";
		}
		//klær
		 else if ( Subjekt.equals( "Kjole" ) ) {
			Artikkel = "en";
			Endelse = "";
		} else if ( Subjekt.equals( "Veske" ) ) {
			Artikkel = "en";
			Endelse = "";
		} else if ( Subjekt.equals( "Skjerf" ) ) {
			Artikkel = "et";
			Endelse = "t";
		} else if ( Subjekt.equals( "Hanske" ) ) {
			Artikkel = "en";
			Endelse = "";
		} else if ( Subjekt.equals( "&oslashrevarmer" ) ) {
			Artikkel = "en";
			Endelse = "";
		} else if ( Subjekt.equals( "Genser" ) ) {
			Artikkel = "en";
			Endelse = "";
		} else if ( Subjekt.equals( "Bikini" ) ) {
			Artikkel = "en";
			Endelse = "";
		} else if ( Subjekt.equals( "Hatt" ) ) {
			Artikkel = "en";
			Endelse = "";
		} else if ( Subjekt.equals( "Sjal" ) ) {
			Artikkel = "et";
			Endelse = "t";
		} else if ( Subjekt.equals( "Lue" ) ) {
			Artikkel = "en";
			Endelse = "";
		} else if ( Subjekt.equals( "Skj&oslashrt" ) ) {
			Artikkel = "et";
			Endelse = "t";
		}
		//negledesign
		else if ( Subjekt.equals( "Neglelakk" ) ) {
			Artikkel = "en";
			Endelse = "";
		}
	}
}
