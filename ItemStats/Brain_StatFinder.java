package ItemStats;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Control.TextHandler;

public class Brain_StatFinder {

	public String Define_Adjectives( String AllTexts ) {
		//ordene skal brukes i det automatisk produktnavnet
		TextHandler Parser = new TextHandler();
		//adjektiver
		String Adjectives = "";
		
		//form
		if ( Parser.InneholderSeparertOrd( "mini", AllTexts ) > -1) { Adjectives = Adjectives + "mini, "; }
		if ( Parser.InneholderSeparertOrd( "slim", AllTexts ) > -1 ) { Adjectives = Adjectives + "tynn, "; }
		if ( Parser.InneholderSeparertOrd( "miniature", AllTexts ) > -1) { Adjectives = Adjectives + "miniatyr, "; }
		if ( Parser.InneholderSeparertOrd( "round", AllTexts ) > -1 ) { Adjectives = Adjectives + "rund, "; }
		if ( Parser.InneholderSeparertOrd( "3d", AllTexts ) > -1 ) { Adjectives = Adjectives + "3D, "; }
		if ( Parser.InneholderSeparertOrd( "egg shaped", AllTexts ) > -1 ) { Adjectives = Adjectives + "eggformet, "; }
		if ( Parser.InneholderSeparertOrd( "curly", AllTexts ) > -1 ) { Adjectives = Adjectives + "kr&oslashllete, "; }
		
		//farger
		if ( Parser.InneholderSeparertOrd( "red", AllTexts ) > -1) { Adjectives = Adjectives + "r&oslashdt, "; }
		if ( Parser.InneholderSeparertOrd( "orange", AllTexts ) > -1) { Adjectives = Adjectives + "oransje, "; }
		if ( Parser.InneholderSeparertOrd( "yellow", AllTexts ) > -1) { Adjectives = Adjectives + "gult, "; }
		if ( Parser.InneholderSeparertOrd( "green", AllTexts ) > -1) { Adjectives = Adjectives + "gr&oslashnn, "; }
		if ( Parser.InneholderSeparertOrd( "aquamarine", AllTexts ) > -1) { Adjectives = Adjectives + "turkis, "; }
		if ( Parser.InneholderSeparertOrd( "turquoise", AllTexts ) > -1) { Adjectives = Adjectives + "turkis, "; }
		if ( Parser.InneholderSeparertOrd( "blue", AllTexts ) > -1) { Adjectives = Adjectives + "bl&aringtt, "; }
		if ( Parser.InneholderSeparertOrd( "purple", AllTexts ) > -1) { Adjectives = Adjectives + "lilla, "; }
		if ( Parser.InneholderSeparertOrd( "pink", AllTexts ) > -1) { Adjectives = Adjectives + "rosa, "; }
		
		if ( Parser.InneholderSeparertOrd( "transparent", AllTexts ) > -1) { Adjectives = Adjectives + "Transparent "; }//for mye gal bruk
		if ( Parser.InneholderSeparertOrd( "white", AllTexts ) > -1) { Adjectives = Adjectives + "hvitt, "; }
		if ( Parser.InneholderSeparertOrd( "grey", AllTexts ) > -1) { Adjectives = Adjectives + "gr&aringtt, "; }
		if ( Parser.InneholderSeparertOrd( "gray", AllTexts ) > -1) { Adjectives = Adjectives + "gr&aringtt, "; }
		if ( Parser.InneholderSeparertOrd( "black", AllTexts ) > -1) { Adjectives = Adjectives + "Svart "; }
		
		if ( Parser.InneholderSeparertOrd( "beige", AllTexts ) > -1) { Adjectives = Adjectives + "beige, "; }
		if ( Parser.InneholderSeparertOrd( "brown", AllTexts ) > -1) { Adjectives = Adjectives + "brunt, "; }
		
		if ( Parser.InneholderSeparertOrd( "golden", AllTexts ) > -1) { Adjectives = Adjectives + "gyldent, "; }
		if ( Parser.InneholderSeparertOrd( "silvery", AllTexts ) > -1) { Adjectives = Adjectives + "s&oslashlvfarget"; }
		
		//annet utseende
		if ( Parser.InneholderSeparertOrd( "shimmering", AllTexts ) > -1 ) { Adjectives = Adjectives + "glitrende, "; }
		if ( Parser.InneholderSeparertOrd( "dark", AllTexts ) > -1 ) { Adjectives = Adjectives + "m&oslashrk, "; }
		if ( Parser.InneholderSeparertOrd( "beautiful", AllTexts ) > -1 ) { Adjectives = Adjectives + "vakkert, "; }
		if ( Parser.InneholderSeparertOrd( "cartoon", AllTexts ) > -1 ) { Adjectives = Adjectives + "cartoonish, "; }
		
		//kvalitet
		if ( Parser.InneholderSeparertOrd( "fantastic", AllTexts ) > -1 ) { Adjectives = Adjectives + "fantastisk, "; }
		if ( Parser.InneholderSeparertOrd( "super", AllTexts ) > -1 ) { Adjectives = Adjectives + "supert, "; }
		if ( Parser.InneholderSeparertOrd( "great", AllTexts ) > -1 ) { Adjectives = Adjectives + "flott, "; }
		//if ( Parser.InneholderSeparertOrd( "real", AllTexts ) > -1 ) { Adjectives = Adjectives + "Ekte "; }  //for mye gal bruk
		if ( Parser.InneholderSeparertOrd( "antique", AllTexts ) > -1) { Adjectives = Adjectives + "antikk, "; }
		
		if ( Parser.InneholderSeparertOrd( "liquorice", AllTexts ) > -1 ) { Adjectives = Adjectives + "lakris "; }
		if ( Parser.InneholderSeparertOrd( "soft", AllTexts ) > -1 ) { Adjectives = Adjectives + "mykt, "; }
		if ( Parser.InneholderSeparertOrd( "hallow", AllTexts ) > -1 ) { Adjectives = Adjectives + "hult, "; }
		
		//egenskaper

		
		return Adjectives;
	}
	
	String Define_BestandDeler( String AllTexts ) {
		//brukes i produktbeskrivelsesteksten
		TextHandler Parser = new TextHandler();
		String Materialer = "";
		//materialer
		//metaller
		if ( Parser.InneholderSeparertOrd( "metal", AllTexts ) > -1) { Materialer = Materialer + "metall, "; }
		if ( Parser.InneholderSeparertOrd( "iron", AllTexts ) > -1) { Materialer = Materialer + "jern, "; }
		if ( Parser.InneholderSeparertOrd( "steel", AllTexts ) > -1) { Materialer = Materialer + "st&aringl, "; }
		
		if ( Parser.InneholderSeparertOrd( "925", AllTexts ) > -1) { Materialer = Materialer + "925 s&oslashlv, ";
		} else if ( Parser.InneholderSeparertOrd( "silver plated", AllTexts ) > -1) { Materialer = Materialer + "s&oslashlvbelagt, "; 
		} else if ( Parser.InneholderSeparertOrd( "silver", AllTexts ) > -1) { Materialer = Materialer + "s&oslashlv, "; 
		} else if ( Parser.InneholderSeparertOrd( "sterling", AllTexts ) > -1) { Materialer = Materialer + "s&oslashlv, "; 
		}
		if ( Parser.InneholderSeparertOrd( "titanium", AllTexts ) > -1) { Materialer = Materialer + "titanium, "; }
		if ( Parser.InneholderSeparertOrd( "gold plated", AllTexts ) > -1) {  Materialer = Materialer + "gullbelagt, "; }
		if ( Parser.InneholderSeparertOrd( "white gold", AllTexts ) > -1) {  Materialer = Materialer + "hvitt gull, ";   }
		if ( Parser.InneholderSeparertOrd( "rose gold", AllTexts ) > -1) {  Materialer = Materialer + "rosegull, ";   }
		if ( Parser.InneholderSeparertOrd( "gold plated", AllTexts ) == -1) { 
			if ( Parser.InneholderSeparertOrd( "white gold", AllTexts ) == -1) {
				if ( Parser.InneholderSeparertOrd( "rose gold", AllTexts ) == -1) { 
					if ( Parser.InneholderSeparertOrd( "gold", AllTexts ) > -1) { 
						Materialer = Materialer + "gull, "; 
					}
					if ( Parser.InneholderSeparertOrd( "18k", AllTexts ) > -1) { 
						Materialer = Materialer + "18k gull, "; 
					}
					if ( Parser.InneholderSeparertOrd( "23k", AllTexts ) > -1) { 
						Materialer = Materialer + "23k gull, "; 
					}
					if ( Parser.InneholderSeparertOrd( "18kgp", AllTexts ) > -1) { 
						Materialer = Materialer + "18k gullbelagt, "; 
					}
				}
			}
		}
		if ( Parser.InneholderSeparertOrd( "bronze", AllTexts ) > -1) { Materialer = Materialer + "bronse, "; }
		if ( Parser.InneholderSeparertOrd( "rgp", AllTexts ) > -1) { Materialer = Materialer + "gullbelagt, "; }
		if ( Parser.InneholderSeparertOrd( "copper", AllTexts ) > -1) { Materialer = Materialer + "kobber, "; }
		if ( Parser.InneholderSeparertOrd( "zinc", AllTexts ) > -1) { Materialer = Materialer + "zink, "; }
		if ( Parser.InneholderSeparertOrd( "platinum", AllTexts ) > -1) { Materialer = Materialer + "platinum, "; }
		if ( Parser.InneholderSeparertOrd( "brass", AllTexts ) > -1) { Materialer = Materialer + "messing, "; }
		if ( Parser.InneholderSeparertOrd( "aluminium", AllTexts ) > -1) { Materialer = Materialer + "aluminium, "; }
		if ( Parser.InneholderSeparertOrd( "rhodium", AllTexts ) > -1) { Materialer = Materialer + "rhodium, "; }
		if ( Parser.InneholderSeparertOrd( "tungsten", AllTexts ) > -1) { Materialer = Materialer + "wolfram, "; }
		//geologisk
		if ( Parser.InneholderSeparertOrd( "crystal", AllTexts ) > -1) { Materialer = Materialer + "krystall, "; }
		if ( Parser.InneholderSeparertOrd( "zircon", AllTexts ) > -1) { Materialer = Materialer + "zircon, "; }//naturlig
		if ( Parser.InneholderSeparertOrd( "clay", AllTexts ) > -1) { Materialer = Materialer + "kjeramikk, "; }
		if ( Parser.InneholderSeparertOrd( "diamond", AllTexts ) > -1) { Materialer = Materialer + "diamant, "; }
		if ( Parser.InneholderSeparertOrd( "cat's eye", AllTexts ) > -1) { Materialer = Materialer + "katt&oslashye, "; }
		if ( Parser.InneholderSeparertOrd( "opal", AllTexts ) > -1) { Materialer = Materialer + "opal, "; }
		if ( Parser.InneholderSeparertOrd( "sapphire", AllTexts ) > -1) { Materialer = Materialer + "safir, "; }
		if ( Parser.InneholderSeparertOrd( "amethyst", AllTexts ) > -1) { Materialer = Materialer + "ametyst, "; }
		if ( Parser.InneholderSeparertOrd( "glass", AllTexts ) > -1) { Materialer = Materialer + "glass, "; }
		if ( Parser.InneholderSeparertOrd( "stone", AllTexts ) > -1) { Materialer = Materialer + "stein, "; }
		if ( Parser.InneholderSeparertOrd( "agate", AllTexts ) > -1) { Materialer = Materialer + "agat, "; }
		if ( Parser.InneholderSeparertOrd( "ruby", AllTexts ) > -1) { Materialer = Materialer + "rubin, "; }
		if ( Parser.InneholderSeparertOrd( "chalcedony", AllTexts ) > -1) { Materialer = Materialer + "kalsedon, "; }
		if ( Parser.InneholderSeparertOrd( "quartz", AllTexts ) > -1) { Materialer = Materialer + "kvarts, "; }
		if ( Parser.InneholderSeparertOrd( "jade", AllTexts ) > -1) { Materialer = Materialer + "jade, "; }
		//biologisk
		if ( Parser.InneholderSeparertOrd( "leather", AllTexts ) > -1) { Materialer = Materialer + "l&aeligr, "; }
		if ( Parser.InneholderSeparertOrd( "pearl", AllTexts ) > -1) { Materialer = Materialer + "perler, "; }
		if ( Parser.InneholderSeparertOrd( "coral", AllTexts ) > -1) { Materialer = Materialer + "korall, "; }
		if ( Parser.InneholderSeparertOrd( "feather", AllTexts ) > -1) { Materialer = Materialer + "fj&aeligr, "; }
		if ( Parser.InneholderSeparertOrd( "shell", AllTexts ) > -1) { Materialer = Materialer + "skjell, "; }
		if ( Parser.InneholderSeparertOrd( "amber", AllTexts ) > -1) { Materialer = Materialer + "rav, "; }
		if ( Parser.InneholderSeparertOrd( "cotton", AllTexts ) > -1) { Materialer = Materialer + "bomull, "; }
		if ( Parser.InneholderSeparertOrd( "suede", AllTexts ) > -1) { Materialer = Materialer + "suede l&aeligr, "; }
		if ( Parser.InneholderSeparertOrd( "denim", AllTexts ) > -1) { Materialer = Materialer + "denim, "; }
		if ( Parser.InneholderSeparertOrd( "wooden", AllTexts ) > -1) { Materialer = Materialer + "treverk, "; 
		} else if ( Parser.InneholderSeparertOrd( "wood", AllTexts ) > -1) { Materialer = Materialer + "treverk, ";
		} else if ( Parser.InneholderSeparertOrd( "bamboo", AllTexts ) > -1) { Materialer = Materialer + "treverk, "; 
		} else if ( Parser.InneholderSeparertOrd( "woodcraft", AllTexts ) > -1) { Materialer = Materialer + "treverk, "; }
		if ( Parser.InneholderSeparertOrd( "paper", AllTexts ) > -1) { Materialer = Materialer + "papir, "; }
		if ( Parser.InneholderSeparertOrd( "wool", AllTexts ) > -1) { Materialer = Materialer + "ull, "; 
		} else if ( Parser.InneholderSeparertOrd( "woolen", AllTexts ) > -1) { Materialer = Materialer + "ull, "; }
		//syntetisk
		if ( Parser.InneholderSeparertOrd( "rubber", AllTexts ) > -1) { Materialer = Materialer + "gummi, "; }
		if ( Parser.InneholderSeparertOrd( "pvc", AllTexts ) > -1) { Materialer = Materialer + "PVC, "; }
		if ( Parser.InneholderSeparertOrd( "rhinestone", AllTexts ) > -1) { Materialer = Materialer + "rhinestones, "; }
		if ( Parser.InneholderSeparertOrd( "plush", AllTexts ) > -1) { Materialer = Materialer + "plush, "; }
		if ( Parser.InneholderSeparertOrd( "zirconia", AllTexts ) > -1) { Materialer = Materialer + "zirconia, "; } //syntetisk
		if ( Parser.InneholderSeparertOrd( "acrylic", AllTexts ) > -1) { Materialer = Materialer + "akryl, "; }
		if ( Parser.InneholderSeparertOrd( "velvet", AllTexts ) > -1) { Materialer = Materialer + "fl&oslashyel, "; }
		if ( Parser.InneholderSeparertOrd( "spandex", AllTexts ) > -1) { Materialer = Materialer + "spandex, "; }
		if ( Parser.InneholderSeparertOrd( "chiffon", AllTexts ) > -1) { Materialer = Materialer + "chiffon, "; }
		if ( Parser.InneholderSeparertOrd( "nylon", AllTexts ) > -1) { Materialer = Materialer + "nylon, "; }
		if ( Parser.InneholderSeparertOrd( "satin", AllTexts ) > -1) { Materialer = Materialer + "sateng, "; }
		if ( Parser.InneholderSeparertOrd( "silicone", AllTexts ) > -1) { Materialer = Materialer + "silikon, "; }
		if ( Parser.InneholderSeparertOrd( "polyester", AllTexts ) > -1) { Materialer = Materialer + "polyester, "; }
		if ( Parser.InneholderSeparertOrd( "latex", AllTexts ) > -1) { Materialer = Materialer + "latex, "; }
		if ( Parser.InneholderSeparertOrd( "resin", AllTexts ) > -1) { Materialer = Materialer + "resin, "; }
		if ( Parser.InneholderSeparertOrd( "polymer", AllTexts ) > -1) { Materialer = Materialer + "polymer, "; }
		if ( Parser.InneholderSeparertOrd( "abs plastic", AllTexts ) > -1) { Materialer = Materialer + "ABS-plast, "; 
		} else if ( Parser.InneholderSeparertOrd( "plastic", AllTexts ) > -1) { Materialer = Materialer + "plast, "; }
		
		return Materialer;
	}
	
	String Define_Standard( String AllTexts ) {
		//brukes i produktbeskrivelsesteksten
		TextHandler Parser = new TextHandler();
		String Standard = "";
		if ( Parser.InneholderSeparertOrd( "touch screen", AllTexts ) > -1) { Standard = Standard + "touch screen, "; }
		if ( Parser.InneholderSeparertOrd( "led", AllTexts ) > -1) { Standard = Standard + "LED, "; }
		if ( Parser.InneholderSeparertOrd( "gps", AllTexts ) > -1) { Standard = Standard + "gps, "; }
		if ( Parser.InneholderSeparertOrd( "wifi", AllTexts ) > -1) { Standard = Standard + "wifi, "; }
		if ( Parser.InneholderSeparertOrd( "android", AllTexts ) > -1) { Standard = Standard + "android, "; }
		if ( Parser.InneholderSeparertOrd( "dual core", AllTexts ) > -1) { Standard = Standard + "dual core, "; }
		if ( Parser.InneholderSeparertOrd( "quad core", AllTexts ) > -1) { Standard = Standard + "quad core, "; }
		if ( Parser.InneholderSeparertOrd( "1080p", AllTexts ) > -1) { Standard = Standard + "1080p, "; }
		if ( Parser.InneholderSeparertOrd( "firewire", AllTexts ) > -1) { Standard = Standard + "firewire, "; }
		if ( Parser.InneholderSeparertOrd( "retina screen", AllTexts ) > -1) { Standard = Standard + "retina screen, "; }
		if ( Parser.InneholderSeparertOrd( "dual camera", AllTexts ) > -1) { Standard = Standard + "2 kameraer, "; 
		} else if ( Parser.InneholderSeparertOrd( "camera", AllTexts ) > -1) { Standard = Standard + "kamera, "; }
		if ( Parser.InneholderSeparertOrd( "1280*800 ", AllTexts ) > -1) { Standard = Standard + "1280*800, "; }
		if ( Parser.InneholderSeparertOrd( "gsm", AllTexts ) > -1) { Standard = Standard + "GSM, "; }
		if ( Parser.InneholderSeparertOrd( "lcd", AllTexts ) > -1) { Standard = Standard + "LCD, "; }
		if ( Parser.InneholderSeparertOrd( "motion detector", AllTexts ) > -1) { Standard = Standard + "bevegelsesdetektor, "; }
		if ( Parser.InneholderSeparertOrd( "wireless", AllTexts ) > -1) { Standard = Standard + "tr&aringdl&oslashs, "; }
		if ( Parser.InneholderSeparertOrd( "usb 3.0", AllTexts ) == -1) {  
			if ( Parser.InneholderSeparertOrd( "usb", AllTexts ) > -1) { 
				Standard = Standard + "USB, "; 
			} 
		}
		if ( Parser.InneholderSeparertOrd( "velcro", AllTexts ) > -1) { Standard = Standard + "borrel&arings, "; }
		if ( Parser.InneholderSeparertOrd( "handmade", AllTexts ) > -1) { Standard = Standard + "h&aringndlaget, "; }
		if ( Parser.InneholderSeparertOrd( "limited edition", AllTexts ) > -1) { Standard = Standard + "limited edition, "; }
		
		/*if ( Standard.equals("") == false ) {
			Standard = Standard;
		}*/
		return Standard;
	}
	
	String Define_Egenskaper( String AllTexts ) {
		//Ordene skal brukes i produktbeskrivelsesteksten
		TextHandler Parser = new TextHandler();
		String Egenskaper = "";
		if ( Parser.InneholderSeparertOrd( "two in one", AllTexts ) > -1) { Egenskaper = Egenskaper + "2-i-1, "; }
		if ( Parser.InneholderSeparertOrd( "glitter", AllTexts ) > -1) { Egenskaper = Egenskaper + "glitter, "; }
		if ( Parser.InneholderSeparertOrd( "key-lock", AllTexts ) > -1) { Egenskaper = Egenskaper + "n&oslashkkell&arings, "; }
		if ( Parser.InneholderSeparertOrd( "high heel", AllTexts ) > -1) { Egenskaper = Egenskaper + "h&oslashye h&aeligler, "; }
		if ( Parser.InneholderSeparertOrd( "fringe", AllTexts ) > -1) { Egenskaper = Egenskaper + "dusker, "; }
		if ( Parser.InneholderSeparertOrd( "platform", AllTexts ) > -1) { Egenskaper = Egenskaper + "platform, "; }
		if ( Parser.InneholderSeparertOrd( "light", AllTexts ) > -1) { Egenskaper = Egenskaper + "lys, "; }
		if ( Parser.InneholderSeparertOrd( "solar powered", AllTexts ) > -1) { Egenskaper = Egenskaper + "lysdrevet, "; 
		} else if ( Parser.InneholderSeparertOrd( "solar power", AllTexts ) > -1) { Egenskaper = Egenskaper + "lysdrevet, "; }
		if ( Parser.InneholderSeparertOrd( "rc", AllTexts ) > -1) { Egenskaper = Egenskaper + "fjernstyrt, "; }
		if ( Parser.InneholderSeparertOrd( "adjustable", AllTexts ) > -1 ) { Egenskaper = Egenskaper + "justerbart, "; }
		if ( Parser.InneholderSeparertOrd( "scented", AllTexts ) > -1 ) { Egenskaper = Egenskaper + "duftende "; }
		if ( Parser.InneholderSeparertOrd( "vibrating", AllTexts ) > -1 ) { Egenskaper = Egenskaper + "vibrerende "; }
		if ( Parser.InneholderSeparertOrd( "magnetic", AllTexts ) > -1 ) { Egenskaper = Egenskaper + "magnetisk "; }
		if ( Parser.InneholderSeparertOrd( "nickel free", AllTexts ) > -1) { 
			Egenskaper = Egenskaper + "nikkelfri, "; 
		} else if ( Parser.InneholderSeparertOrd( "no nickel", AllTexts ) > -1) { Egenskaper = Egenskaper + "nikkelfri, "; }
		if ( Parser.InneholderSeparertOrd( "lead free", AllTexts ) > -1) { 
			Egenskaper = Egenskaper + "blyfri, "; 
		} else if ( Parser.InneholderSeparertOrd( "no lead", AllTexts ) > -1) { Egenskaper = Egenskaper + "blyfri, "; }
		if ( Parser.InneholderSeparertOrd( "engraved", AllTexts ) > -1) { Egenskaper = Egenskaper + "gravert, "; }
		if ( Parser.InneholderSeparertOrd( "polished", AllTexts ) > -1) { Egenskaper = Egenskaper + "polert, "; }
		if ( Parser.InneholderSeparertOrd( "waterproof", AllTexts ) > -1) { Egenskaper = Egenskaper + "vanntett, "; }
		if ( Parser.InneholderSeparertOrd( "elastic", AllTexts ) > -1) { Egenskaper = Egenskaper + "elastisk, "; }
		if ( Parser.InneholderSeparertOrd( "glowing", AllTexts ) > -1) { Egenskaper = Egenskaper + "lysende, "; }
		if ( Parser.InneholderSeparertOrd( "strapless", AllTexts ) > -1) { Egenskaper = Egenskaper + "stroppel&oslashs, "; }
		if ( Parser.InneholderSeparertOrd( "warm", AllTexts ) > -1) { Egenskaper = Egenskaper + "varm, "; }
		if ( Parser.InneholderSeparertOrd( "elastic", AllTexts ) > -1) { Egenskaper = Egenskaper + "elastisk, "; }
		if ( Parser.InneholderSeparertOrd( "slip resistant", AllTexts ) > -1) { Egenskaper = Egenskaper + "sklisikker, "; }
		if ( Parser.InneholderSeparertOrd( "removable", AllTexts ) > -1) { Egenskaper = Egenskaper + "flyttbar, "; }
		if ( Parser.InneholderSeparertOrd( "electric", AllTexts ) > -1) { Egenskaper = Egenskaper + "elektrisk, "; }
		if ( Parser.InneholderSeparertOrd( "electronic", AllTexts ) > -1) { Egenskaper = Egenskaper + "elektronisk, "; }
		if ( Parser.InneholderSeparertOrd( "zipper", AllTexts ) > -1) { Egenskaper = Egenskaper + "glidel&arings, "; }
		
		/*if ( Egenskaper.equals("") == false ) {
			Egenskaper = "med "+Egenskaper;
		}*/
		return Egenskaper;
	}
	
	String Define_Opprinnelse( String AllTexts ) {
		//brukes i produktbeskrivelsesteksten
		TextHandler Parser = new TextHandler();
		ItemStats_Stater StatsDatabase = new ItemStats_Stater();
		String Opprinnelse = "";
		
		Object_ItemStats_Stat[] StatListe = new Object_ItemStats_Stat[100];
		StatListe = StatsDatabase.HentStatListe_Objekter();
		for ( int X = 0 ; X <  StatListe.length ; X++ ) {
			if ( StatListe[X] != null ) {
				if ( Parser.InneholderSeparertOrd( StatListe[X].Egennavn_Engelsk, AllTexts ) > -1) { 
					Opprinnelse = Opprinnelse + StatListe[X].Egennavn_Norsk+" "; 
				} else if ( Parser.InneholderSeparertOrd( StatListe[X].Adjektiv_Engelsk, AllTexts ) > -1) { 
					if ( Parser.InneholderSeparertOrd( "swedish erotica", AllTexts ) == -1) { 
						Opprinnelse = Opprinnelse + StatListe[X].Egennavn_Norsk+" "; 
					}
				}
			}
		}
		
		/*if ( Opprinnelse.equals("") == false ) {
			Opprinnelse = "fra "+Opprinnelse;
		}*/
		return Opprinnelse;
	}
	
	String Define_Produsent( String AllTexts ) {
		//brukes i produktbeskrivelsesteksten
		TextHandler Parser = new TextHandler();
		String Produsent = "";
		if ( Parser.InneholderSeparertOrd( "swarovski", AllTexts ) > -1) { Produsent = Produsent + "Swarovski, "; }
		if ( Parser.InneholderSeparertOrd( "fimo", AllTexts ) > -1) { Produsent = Produsent + "Fimo, "; }
		if ( Parser.InneholderSeparertOrd( "italina rigant", AllTexts ) > -1) { Produsent = Produsent + "Italina Rigant, "; }
		if ( Parser.InneholderSeparertOrd( "dingya", AllTexts ) > -1) { Produsent = Produsent + "Dingya, "; }
		if ( Parser.InneholderSeparertOrd( "stellux", AllTexts ) > -1) { Produsent = Produsent + "Stellux, "; }
		if ( Parser.InneholderSeparertOrd( "hasbro", AllTexts ) > -1) { Produsent = Produsent + "Hasbro, "; }
		if ( Parser.InneholderSeparertOrd( "chanel", AllTexts ) > -1) { Produsent = Produsent + "Chanel, "; }
		if ( Parser.InneholderSeparertOrd( "plasticine", AllTexts ) > -1) { Produsent = Produsent + "Plasticine, "; }
		if ( Parser.InneholderSeparertOrd( "forge world", AllTexts ) > -1) { Produsent = Produsent + "Forge World, "; }
		if ( Parser.InneholderSeparertOrd( "games workshop", AllTexts ) > -1) { Produsent = Produsent + "Games Workshop, "; }
		if ( Parser.InneholderSeparertOrd( "hobby boss", AllTexts ) > -1) { Produsent = Produsent + "Hobby Boss, "; 
		} else if ( Parser.InneholderSeparertOrd( "hobbyboss", AllTexts ) > -1) { Produsent = Produsent + "Hobby Boss, "; }
		if ( Parser.InneholderSeparertOrd( "trumpeter", AllTexts ) > -1) { Produsent = Produsent + "Trumpeter, "; }
		if ( Parser.InneholderSeparertOrd( "griffon model", AllTexts ) > -1) { Produsent = Produsent + "Griffon Model, "; 
		} else if ( Parser.InneholderSeparertOrd( "griffonmodel", AllTexts ) > -1) { Produsent = Produsent + "Griffon Model, "; }
		if ( Parser.InneholderSeparertOrd( "bronco", AllTexts ) > -1) { Produsent = Produsent + "Bronco, "; }
		if ( Parser.InneholderSeparertOrd( "tamiya", AllTexts ) > -1) { Produsent = Produsent + "Tamiya, "; }
		if ( Parser.InneholderSeparertOrd( "kitty hawk", AllTexts ) > -1) { Produsent = Produsent + "Kitty Hawk, "; }
		if ( Parser.InneholderSeparertOrd( "evolution miniatures", AllTexts ) > -1) { Produsent = Produsent + "Evolution Miniatures, "; }
		if ( Parser.InneholderSeparertOrd( "meng", AllTexts ) > -1) { Produsent = Produsent + "Meng, "; }
		if ( Parser.InneholderSeparertOrd( "scania", AllTexts ) > -1) { Produsent = Produsent + "Scania, "; }
		if ( Parser.InneholderSeparertOrd( "afv club", AllTexts ) > -1) { Produsent = Produsent + "AFV Club, "; }
		if ( Parser.InneholderSeparertOrd( "caesar miniatures", AllTexts ) > -1) { Produsent = Produsent + "Caesar Miniatures, "; }
		if ( Parser.InneholderSeparertOrd( "play doh", AllTexts ) > -1) { Produsent = Produsent + "Play Doh, "; }
		if ( Parser.InneholderSeparertOrd( "etmodel", AllTexts ) > -1) { Produsent = Produsent + "E.T. model, "; }
		if ( Parser.InneholderSeparertOrd( "zvezda", AllTexts ) > -1) { Produsent = Produsent + "Zvezda, "; }
		if ( Parser.InneholderSeparertOrd( "fisher price", AllTexts ) > -1) { Produsent = Produsent + "Fisher Price, "; }
		if ( Parser.InneholderSeparertOrd( "yakuchinone", AllTexts ) > -1) { Produsent = Produsent + "Yakuchinone, "; }
		
		/*if ( Produsent.equals("") == false ) {
			Produsent = "av "+Produsent;
		}*/
		return Produsent;
	}
	
	String Define_Tema( String AllTexts, String Beskrivelse ) {
		//brukes i produktbeskrivelsesteksten
		//System.out.println( this.getClass().toString()+" Define_Tema AllTexts="+AllTexts+" Beskrivelse="+Beskrivelse );
		TextHandler Parser = new TextHandler();
		ItemStats_Tema TemaDatabase = new ItemStats_Tema();
		String Tema = "";
		
		Object_ItemStats_Tema[] TemaListe = new Object_ItemStats_Tema[100];
		TemaListe = TemaDatabase.HentListe_Objekter();
		for ( int X = 0 ; X <  TemaListe.length ; X++ ) {
			if ( TemaListe[X] != null ) {
				if ( Parser.InneholderSeparertOrd( TemaListe[X].Egennavn_Engelsk, AllTexts ) > -1) { 
					if ( TemaListe[X].Egennavn_Norsk != null ) {
						if ( ( Beskrivelse.indexOf( TemaListe[X].Egennavn_Norsk ) == -1 ) ) {
						} else if ( ( AllTexts.indexOf( "aircraft carrier" ) > -1 ) && ( TemaListe[X].Egennavn_Engelsk.equals( "fly" ) == true ) ) {
						} else if ( ( AllTexts.indexOf( "air bus" ) > -1 ) && ( TemaListe[X].Egennavn_Engelsk.equals( "bus" ) == true ) ) {
						} else if ( ( AllTexts.indexOf( "caesar miniatures" ) > -1 ) && ( TemaListe[X].Egennavn_Engelsk.equals( "Caesar" ) == true ) ) {
						} else if ( ( AllTexts.indexOf( "sand table model" ) > -1 ) && ( TemaListe[X].Egennavn_Engelsk.equals( "sand table" ) == true ) ) {
						} else if ( ( AllTexts.indexOf( "sand table" ) > -1 ) && ( TemaListe[X].Egennavn_Engelsk.equals( "sand" ) == true ) ) {
						} else if ( ( AllTexts.indexOf( "marine corps" ) > -1 ) && ( TemaListe[X].Egennavn_Engelsk.equals( "marine" ) == true ) ) {
						} else if ( ( AllTexts.indexOf( "fire engine" ) > -1 ) && ( TemaListe[X].Egennavn_Engelsk.equals( "engine" ) == true ) ) {
						} else if ( ( AllTexts.indexOf( "grey knight" ) > -1 ) && ( TemaListe[X].Egennavn_Engelsk.equals( "knight" ) == true ) ) {
						} else if ( ( AllTexts.indexOf( "blast shield" ) > -1 ) && ( TemaListe[X].Egennavn_Engelsk.equals( "shield" ) == true ) ) {
						} else if ( ( AllTexts.indexOf( "gun shield" ) > -1 ) && ( TemaListe[X].Egennavn_Engelsk.equals( "shield" ) == true ) ) {
						} else if ( ( AllTexts.indexOf( "shield base" ) > -1 ) && ( TemaListe[X].Egennavn_Engelsk.equals( "shield" ) == true ) ) {
						} else if ( ( AllTexts.indexOf( "soldier model" ) > -1 ) && ( TemaListe[X].Egennavn_Engelsk.equals( "soldier" ) == true ) ) {
						} else if ( ( AllTexts.indexOf( "train scale" ) > -1 ) && ( TemaListe[X].Egennavn_Engelsk.equals( "train" ) == true ) ) {
						} else if ( ( AllTexts.indexOf( "aircraft carrier" ) > -1 ) && ( TemaListe[X].Egennavn_Engelsk.equals( "train" ) == true ) ) {
						} else if ( ( AllTexts.indexOf( "aircraft carrier" ) > -1 ) && ( TemaListe[X].Egennavn_Engelsk.equals( "aircraft" ) == true ) ) {
						} else if ( ( AllTexts.indexOf( "dragon 6381" ) > -1 ) && ( TemaListe[X].Egennavn_Engelsk.equals( "dragon" ) == true ) ) {
						} else if ( ( AllTexts.indexOf( "dragon kit" ) > -1 ) && ( TemaListe[X].Egennavn_Engelsk.equals( "dragon" ) == true ) ) {
						} else if ( ( AllTexts.indexOf( "racks" ) > -1 ) && ( TemaListe[X].Egennavn_Engelsk.equals( "dragon" ) == true ) ) {
						} else if ( ( AllTexts.indexOf( "dragon momoko" ) > -1 ) && ( TemaListe[X].Egennavn_Engelsk.equals( "dragon" ) == true ) ) {
						} else if ( ( AllTexts.indexOf( "blood angel" ) > -1 ) && ( TemaListe[X].Egennavn_Engelsk.equals( "angel" ) == true ) ) {
						} else if ( ( AllTexts.indexOf( "night train" ) > -1 ) && ( TemaListe[X].Egennavn_Engelsk.equals( "train" ) == true ) ) {
						} else if ( ( AllTexts.indexOf( "tank destroyer" ) > -1 ) && ( TemaListe[X].Egennavn_Engelsk.equals( "destroyer" ) == true ) ) {
						} else if ( ( AllTexts.indexOf( "model tree" ) > -1 ) && ( TemaListe[X].Egennavn_Engelsk.equals( "tree" ) == true ) ) {
						} else if ( ( AllTexts.indexOf( "scale tree" ) > -1 ) && ( TemaListe[X].Egennavn_Engelsk.equals( "tree" ) == true ) ) {
						} else if ( ( AllTexts.indexOf( "chaos space marine" ) > -1 ) && ( TemaListe[X].Egennavn_Engelsk.equals( "chaos" ) == true ) ) {
						} else if ( ( AllTexts.indexOf( "chaos space marine" ) > -1 ) && ( TemaListe[X].Egennavn_Engelsk.equals( "space marine" ) == true ) ) {
						} else if ( ( AllTexts.indexOf( "space marine" ) > -1 ) && ( TemaListe[X].Egennavn_Engelsk.equals( "marine" ) == true ) ) {
						} else if ( ( AllTexts.indexOf( "sea king" ) > -1 ) && ( TemaListe[X].Egennavn_Engelsk.equals( "king" ) == true ) ) {
						} else if ( ( AllTexts.indexOf( "orc" ) > -1 ) && ( TemaListe[X].Egennavn_Engelsk.equals( "ork" ) == true ) ) {
						} else if ( ( AllTexts.indexOf( "ork" ) > -1 ) && ( TemaListe[X].Egennavn_Engelsk.equals( "orc" ) == true ) ) {
						} else if ( ( AllTexts.indexOf( "cross fire" ) > -1 ) && ( TemaListe[X].Egennavn_Engelsk.equals( "cross" ) == true ) ) {
						} else if ( ( AllTexts.indexOf( "trumpeter" ) > -1 ) && ( TemaListe[X].Egennavn_Engelsk.equals( "upgrade set" ) == true ) ) {
						} else if ( ( AllTexts.indexOf( "sun shark" ) > -1 ) && ( TemaListe[X].Egennavn_Engelsk.equals( "shark" ) == true ) ) {
						} else if ( ( AllTexts.indexOf( "kids toy" ) > -1 ) && ( TemaListe[X].Egennavn_Engelsk.equals( "toy" ) == true ) ) {
						} else if ( ( AllTexts.indexOf( "roller coaster" ) > -1 ) && ( TemaListe[X].Egennavn_Engelsk.equals( "roller" ) == true ) ) {
						} else if ( ( AllTexts.indexOf( "children toy" ) > -1 ) && ( TemaListe[X].Egennavn_Engelsk.equals( "toy" ) == true ) ) {
						} else if ( ( AllTexts.indexOf( "children toy" ) > -1 ) && ( TemaListe[X].Egennavn_Engelsk.equals( "children" ) == true ) ) {
						} else if ( ( AllTexts.indexOf( "children toy" ) > -1 ) && ( TemaListe[X].Egennavn_Engelsk.equals( "kids" ) == true ) ) {
						} else if ( ( AllTexts.indexOf( "grey knight" ) > -1 ) && ( TemaListe[X].Egennavn_Engelsk.equals( "grey" ) == true ) ) {
						} else if ( ( AllTexts.indexOf( "egg shaped" ) > -1 ) && ( TemaListe[X].Egennavn_Engelsk.equals( "egg" ) == true ) ) {
						} else if ( ( AllTexts.indexOf( "daemon prince" ) > -1 ) && ( TemaListe[X].Egennavn_Engelsk.equals( "prince" ) == true ) ) {
						} else if ( ( AllTexts.indexOf( "champion of khorne" ) > -1 ) && ( TemaListe[X].Egennavn_Engelsk.equals( "champion" ) == true ) ) {
						} else if ( ( AllTexts.indexOf( "champions of chaos" ) > -1 ) && ( TemaListe[X].Egennavn_Engelsk.equals( "champion" ) == true ) ) {
						} else if ( ( AllTexts.indexOf( "champion of khorne" ) > -1 ) && ( TemaListe[X].Egennavn_Engelsk.equals( "khorne" ) == true ) ) {
						} else if ( ( AllTexts.indexOf( "champions of chaos" ) > -1 ) && ( TemaListe[X].Egennavn_Engelsk.equals( "chaos" ) == true ) ) {
						} else if ( ( AllTexts.indexOf( "marauder champion" ) > -1 ) && ( TemaListe[X].Egennavn_Engelsk.equals( "champion" ) == true ) ) {
						} else if ( ( AllTexts.indexOf( "great brass scorpion" ) > -1 ) && ( TemaListe[X].Egennavn_Engelsk.equals( "scorpion" ) == true ) ) {
						} else if ( ( AllTexts.indexOf( "airplane model" ) > -1 ) && ( TemaListe[X].Egennavn_Engelsk.equals( "fly" ) == true ) ) {
						} else if ( ( AllTexts.indexOf( "warp lightning cannon" ) > -1 ) && ( TemaListe[X].Egennavn_Engelsk.equals( "cannon" ) == true ) ) {
						} else if ( ( AllTexts.indexOf( "greater daemon of khorne" ) > -1 ) && ( TemaListe[X].Egennavn_Engelsk.equals( "daemon" ) == true ) ) {
						} else if ( ( AllTexts.indexOf( "greater daemon of khorne" ) > -1 ) && ( TemaListe[X].Egennavn_Engelsk.equals( "khorne" ) == true ) ) {
						} else if ( ( AllTexts.indexOf( "exalted hero of chaos" ) > -1 ) && ( TemaListe[X].Egennavn_Engelsk.equals( "chaos" ) == true ) ) {
						} else if ( ( AllTexts.indexOf( "griffon model" ) > -1 ) && ( TemaListe[X].Egennavn_Engelsk.equals( "dragon" ) == true ) ) {
						//2-ordskriterier
						} else if ( ( AllTexts.indexOf( "warhammer" ) > -1 ) && ( TemaListe[X].Egennavn_Engelsk.equals( "hq" ) == true ) ) {
							Tema = Tema + "HQ, WH40k, "; 
						} else if ( ( AllTexts.indexOf( "warhammer" ) > -1 ) && ( TemaListe[X].Egennavn_Engelsk.equals( "body" ) == true ) ) {
							Tema = Tema + "bitz, "; 
						} else if ( ( AllTexts.indexOf( "baby" ) > -1 ) && ( TemaListe[X].Egennavn_Engelsk.equals( "block" ) == true ) ) {
							Tema = Tema + "babyleke, klosser, "; 
						} else if ( ( AllTexts.indexOf( "tower" ) > -1 ) && ( TemaListe[X].Egennavn_Engelsk.equals( "baby" ) == true ) ) {
							Tema = Tema + "babyleke, "; 
						} else if ( ( AllTexts.indexOf( "train" ) > -1 ) && ( TemaListe[X].Egennavn_Engelsk.equals( "thomas" ) == true ) ) {
							Tema = Tema + "Thomastoget, "; 
						} else {
							if ( Tema.indexOf( TemaListe[X].Egennavn_Norsk+", " ) == -1 ) {
								Tema = Tema + TemaListe[X].Egennavn_Norsk+", "; 
								if ( TemaListe[X].Generalisering != null ) {
									if ( Tema.indexOf( TemaListe[X].Generalisering+", " ) == -1 ) {
										Tema = Tema + TemaListe[X].Generalisering+", "; 
									}
								}
							}
						}
					}
				}
			}
		}
		
		/*if ( Tema.equals("") == false ) {
			Tema = "med "+Tema;
		}*/
		return Tema;
	}
	
	String Define_Stats( String AllTexts ) {
		//brukes i produktbeskrivelsesteksten
		TextHandler Parser = new TextHandler();
		String Stats = "";
		
		
		Pattern Regex1 = Pattern.compile( "((\\d+)gb)" );
		Matcher m1 = Regex1.matcher( AllTexts );
		m1 = Regex1.matcher( AllTexts );
		while ( m1.find() ) {
			String MatchFunnet = m1.group(1);
			if ( Stats.indexOf( MatchFunnet ) == -1 ) {
				Stats = Stats + MatchFunnet+", ";
			}
		}
		
		if ( Parser.InneholderSeparertOrd( "usb 3.0", AllTexts ) > -1) { Stats = Stats + "usb 3.0, "; }
		if ( Parser.InneholderSeparertOrd( "cloisonne", AllTexts ) > -1) { Stats = Stats + "cloisonne, "; }
		
		Pattern Regex2 = Pattern.compile( "((\\d{1,3})mm)" );
		Matcher m2 = Regex2.matcher( AllTexts );
		m2 = Regex2.matcher( AllTexts );
		while ( m2.find() ) {
			String MatchFunnet = m2.group(1);
			if ( Stats.indexOf( MatchFunnet ) == -1 ) {
				Stats = Stats + MatchFunnet+", ";
			}
		}
		
		Pattern Regex33 = Pattern.compile( "(1/(\\d{1,3}))\\D" );
		Matcher m33 = Regex33.matcher( AllTexts );
		m33 = Regex33.matcher( AllTexts );
		while ( m33.find() ) {
			String MatchFunnet = m33.group(1);
			if ( Stats.indexOf( MatchFunnet ) == -1 ) {
				Stats = Stats + MatchFunnet+", ";
			}
		}
		
		Pattern Regex32 = Pattern.compile( "(1\\\\(\\d{1,3}))\\D" );
		Matcher m32 = Regex32.matcher( AllTexts );
		m32 = Regex32.matcher( AllTexts );
		while ( m32.find() ) {
			String MatchFunnet = m32.group(1);
			if ( Stats.indexOf( MatchFunnet ) == -1 ) {
				Stats = Stats + MatchFunnet+", ";
			}
		}
		
		Pattern Regex3 = Pattern.compile( "(1:(\\d{1,3}))\\D" );
		Matcher m3 = Regex3.matcher( AllTexts );
		m3 = Regex3.matcher( AllTexts );
		while ( m3.find() ) {
			String MatchFunnet = m3.group(1);
			if ( Stats.indexOf( MatchFunnet ) == -1 ) {
				Stats = Stats + MatchFunnet+", ";
			}
		}
		
		Pattern Regex4 = Pattern.compile( "((\\d+)cm)" );
		Matcher m4 = Regex4.matcher( AllTexts );
		m4 = Regex4.matcher( AllTexts );
		while ( m4.find() ) {
			String MatchFunnet = m4.group(1);
			if ( Stats.indexOf( MatchFunnet ) == -1 ) {
				Stats = Stats + MatchFunnet+", ";
			}
		}
		
		Pattern Regex5 = Pattern.compile( "((\\d{1,3}) ml)" );
		Matcher m5 = Regex5.matcher( AllTexts );
		m5 = Regex5.matcher( AllTexts );
		while ( m5.find() ) {
			String MatchFunnet = m5.group(1);
			if ( Stats.indexOf( MatchFunnet ) == -1 ) {
				Stats = Stats + MatchFunnet+", ";
			}
		}
		Pattern Regex5b = Pattern.compile( "((\\d{1,3})ml)" );
		Matcher m5b = Regex5b.matcher( AllTexts );
		m5b = Regex5b.matcher( AllTexts );
		while ( m5b.find() ) {
			String MatchFunnet = m5b.group(1);
			if ( Stats.indexOf( MatchFunnet ) == -1 ) {
				Stats = Stats + MatchFunnet+", ";
			}
		}
		
		if ( Parser.InneholderSeparertOrd( "o scale", AllTexts ) > -1) { Stats = Stats + "o scale, "; }
		
		/*if ( Stats.equals("") == false ) {
			Stats = "type "+Stats;
		}*/
		return Stats;
	}
	
	String Define_BruksAnledning( String AllTexts ) {
		//brukes i produktbeskrivelsesteksten
		TextHandler Parser = new TextHandler();
		String BruksAnledning = "";
		
		if ( Parser.InneholderSeparertOrd( "party", AllTexts ) > -1) { BruksAnledning = BruksAnledning + "fest, "; }
		if ( Parser.InneholderSeparertOrd( "winter", AllTexts ) > -1) { BruksAnledning = BruksAnledning + "vinter, "; }
		if ( Parser.InneholderSeparertOrd( "summer", AllTexts ) > -1) { BruksAnledning = BruksAnledning + "sommer, "; }
		if ( Parser.InneholderSeparertOrd( "beach", AllTexts ) > -1) { BruksAnledning = BruksAnledning + "strand, "; }
		
		/*if ( BruksAnledning.equals("") == false ) {
			BruksAnledning = "P&aring "+BruksAnledning;
		}*/
		return BruksAnledning;
	}
	
	String Define_BruksOmraade(String AllTexts) {
		//brukes i produktbeskrivelsesteksten
		TextHandler Parser = new TextHandler();
		String BruksOmraade = "";
		
		if ( Parser.InneholderSeparertOrd( "belly button", AllTexts ) > -1) { BruksOmraade = BruksOmraade + "navel, "; }
		if ( Parser.InneholderSeparertOrd( "eyebrow", AllTexts ) > -1) { BruksOmraade = BruksOmraade + "&oslashyenbryn, "; }
		if ( Parser.InneholderSeparertOrd( "laptop skins", AllTexts ) > -1) {  BruksOmraade = BruksOmraade + "laptop, ";   }
		if ( Parser.InneholderSeparertOrd( "ipad", AllTexts ) > -1) {  BruksOmraade = BruksOmraade + "iPad, ";   }
		if ( Parser.InneholderSeparertOrd( "fishing", AllTexts ) > -1) {  BruksOmraade = BruksOmraade + "fisking, ";   }
		if ( Parser.InneholderSeparertOrd( "hunting", AllTexts ) > -1) {  BruksOmraade = BruksOmraade + "jakt, ";   }
		if ( Parser.InneholderSeparertOrd( "security", AllTexts ) > -1) {  BruksOmraade = BruksOmraade + "sikkerhet, ";   }
		if ( Parser.InneholderSeparertOrd( "guitar", AllTexts ) > -1) {  BruksOmraade = BruksOmraade + "gitar, ";   }
		if ( Parser.InneholderSeparertOrd( "spy", AllTexts ) > -1) {  BruksOmraade = BruksOmraade + "spionasje, ";   }
		if ( Parser.InneholderSeparertOrd( "diy", AllTexts ) > -1) {  BruksOmraade = BruksOmraade + "DIY, ";   }
		if ( Parser.InneholderSeparertOrd( "scenery", AllTexts ) > -1) { BruksOmraade = BruksOmraade + "scenery, "; }
		if ( Parser.InneholderSeparertOrd( "tran layout", AllTexts ) > -1) { BruksOmraade = BruksOmraade + "modelltogbaner, "; 
		} else if ( Parser.InneholderSeparertOrd( "tran model", AllTexts ) > -1) { BruksOmraade = BruksOmraade + "modelltogbaner, "; 
		} else if ( Parser.InneholderSeparertOrd( "model train", AllTexts ) > -1) { BruksOmraade = BruksOmraade + "modelltogbaner, "; }
		if ( Parser.InneholderSeparertOrd( "educational", AllTexts ) > -1) { BruksOmraade = BruksOmraade + "l&aeligring, "; }
		if ( Parser.InneholderSeparertOrd( "iphone 5", AllTexts ) > -1) { 
			BruksOmraade = BruksOmraade + "iphone 5, "; 
		} else if ( Parser.InneholderSeparertOrd( "iphone 4", AllTexts ) > -1) { 
			BruksOmraade = BruksOmraade + "iphone 4, "; 
		} else if ( Parser.InneholderSeparertOrd( "iphone", AllTexts ) > -1) { 
			BruksOmraade = BruksOmraade + "iphone, "; 
		}
		if ( Parser.InneholderSeparertOrd( "assembling", AllTexts ) > -1) { BruksOmraade = BruksOmraade + "selvbygging, "; 
		} else if ( Parser.InneholderSeparertOrd( "assemble", AllTexts ) > -1) { BruksOmraade = BruksOmraade + "selvbygging, ";
		} else if ( Parser.InneholderSeparertOrd( "disassembly", AllTexts ) > -1) { BruksOmraade = BruksOmraade + "selvbygging, ";
		} else if ( Parser.InneholderSeparertOrd( "manual construction", AllTexts ) > -1) { BruksOmraade = BruksOmraade + "selvbygging, "; 
		} else if ( Parser.InneholderSeparertOrd( "assembly", AllTexts ) > -1) { BruksOmraade = BruksOmraade + "selvbygging, "; }
		if ( Parser.InneholderSeparertOrd( "warhammer", AllTexts ) > -1) { BruksOmraade = BruksOmraade + "Warhammer, "; }
		if ( Parser.InneholderSeparertOrd( "doll house", AllTexts ) > -1) { BruksOmraade = BruksOmraade + "dukkehus, "; }
		if ( Parser.InneholderSeparertOrd( "massage", AllTexts ) > -1) { BruksOmraade = BruksOmraade + "massasje, "; }
		if ( Parser.InneholderSeparertOrd( "gift", AllTexts ) > -1) { BruksOmraade = BruksOmraade + "gaveide, "; }
		if ( Parser.InneholderSeparertOrd( "decoration", AllTexts ) > -1) { BruksOmraade = BruksOmraade + "dekorering, "; }
		if ( Parser.InneholderSeparertOrd( "simulation", AllTexts ) > -1) { BruksOmraade = BruksOmraade + "simulering, "; }
		if ( Parser.InneholderSeparertOrd( "sports", AllTexts ) > -1) { BruksOmraade = BruksOmraade + "sport, "; }
		if ( Parser.InneholderSeparertOrd( "nail art", AllTexts ) > -1) { BruksOmraade = BruksOmraade + "negledesign, "; }
		
		/*if ( BruksOmraade.equals("") == false ) {
			BruksOmraade = "til "+BruksOmraade;
		}*/
		return BruksOmraade;
	}
	
	String Define_BrukerGruppe( String AllTexts ) {
		//brukes i produktbeskrivelsesteksten
		TextHandler Parser = new TextHandler();
		String BrukerGruppe = "";
		
		if ( Parser.InneholderSeparertOrd( "adult", AllTexts ) > -1) {  BrukerGruppe = BrukerGruppe + "voksne, ";   }
		
		if ( Parser.InneholderSeparertOrd( "kid", AllTexts ) > -1) { BrukerGruppe = BrukerGruppe + "barn, "; 
		} else if ( Parser.InneholderSeparertOrd( "child", AllTexts ) > -1) { BrukerGruppe = BrukerGruppe + "barn, ";
		} else if ( Parser.InneholderSeparertOrd( "children", AllTexts ) > -1) { BrukerGruppe = BrukerGruppe + "barn, "; 
		}
		
		if ( Parser.InneholderSeparertOrd( "male", AllTexts ) > -1) { BrukerGruppe = BrukerGruppe + "herre, "; 
		} else if ( Parser.InneholderSeparertOrd( "men", AllTexts ) > -1) { BrukerGruppe = BrukerGruppe + "herre, "; 
		} else if ( Parser.InneholderSeparertOrd( "men's", AllTexts ) > -1) { BrukerGruppe = BrukerGruppe + "herre, "; }
		
		if ( Parser.InneholderSeparertOrd( "boy", AllTexts ) > -1) { BrukerGruppe = BrukerGruppe + "gutt, "; 
		}
		
		if ( Parser.InneholderSeparertOrd( "girl", AllTexts ) > -1) { BrukerGruppe = BrukerGruppe + "jente, "; 
		}
		
		if ( Parser.InneholderSeparertOrd( "female", AllTexts ) > -1) { BrukerGruppe = BrukerGruppe + "dame, "; 
		} else if ( Parser.InneholderSeparertOrd( "woman", AllTexts ) > -1) { BrukerGruppe = BrukerGruppe + "dame, "; 
		} else if ( Parser.InneholderSeparertOrd( "women", AllTexts ) > -1) { BrukerGruppe = BrukerGruppe + "dame, "; 
		} else if ( Parser.InneholderSeparertOrd( "ladies", AllTexts ) > -1) { BrukerGruppe = BrukerGruppe + "dame, "; 
		}
		if ( Parser.InneholderSeparertOrd( "baby", AllTexts ) > -1) {  BrukerGruppe = BrukerGruppe + "baby, ";   
		} else if ( Parser.InneholderSeparertOrd( "toddler", AllTexts ) > -1) {  BrukerGruppe = BrukerGruppe + "baby, ";   
		} else if ( Parser.InneholderSeparertOrd( "infant", AllTexts ) > -1) {  BrukerGruppe = BrukerGruppe + "baby, ";   }
		
		if ( Parser.InneholderSeparertOrd( "dog", AllTexts ) > -1) {  BrukerGruppe = BrukerGruppe + "hund, ";   }
		
		if ( Parser.InneholderSeparertOrd( "cat", AllTexts ) > -1) {  BrukerGruppe = BrukerGruppe + "katt, ";   }
		
		/*if ( BrukerGruppe.equals("") == false ) {
			BrukerGruppe = "for "+BrukerGruppe;
		}*/
		return BrukerGruppe;
	}
	
	String Define_Bekledningsstil( String AllTexts ) {
		//brukes i produktbeskrivelsesteksten
		TextHandler Parser = new TextHandler();
		String Bekledningsstil = "";
		if ( Parser.InneholderSeparertOrd( "punk", AllTexts ) > -1) { Bekledningsstil = Bekledningsstil + "punk, "; }
		if ( Parser.InneholderSeparertOrd( "gothic", AllTexts ) > -1) { Bekledningsstil = Bekledningsstil + "goth, "; }
		if ( Parser.InneholderSeparertOrd( "stylish", AllTexts ) > -1 ) { Bekledningsstil = Bekledningsstil + "trendy "; }
		if ( Parser.InneholderSeparertOrd( "sexy", AllTexts ) > -1 ) { Bekledningsstil = Bekledningsstil + "sexy "; }
		if ( Parser.InneholderSeparertOrd( "shamballa", AllTexts ) > -1 ) { Bekledningsstil = Bekledningsstil + "shamballa "; }
		if ( Parser.InneholderSeparertOrd( "bohemia", AllTexts ) > -1 ) { Bekledningsstil = Bekledningsstil + "shamballa "; }
		if ( Parser.InneholderSeparertOrd( "vintage", AllTexts ) > -1 ) { Bekledningsstil = Bekledningsstil + "vintage "; }
		if ( Parser.InneholderSeparertOrd( "retro", AllTexts ) > -1 ) { Bekledningsstil = Bekledningsstil + "retro "; }
		if ( Parser.InneholderSeparertOrd( "romantic", AllTexts ) > -1 ) { Bekledningsstil = Bekledningsstil + "romantisk "; }
		if ( Parser.InneholderSeparertOrd( "elegant", AllTexts ) > -1) { Bekledningsstil = Bekledningsstil + "elegant, "; }
		if ( Parser.InneholderSeparertOrd( "luxury", AllTexts ) > -1) { Bekledningsstil = Bekledningsstil + "luksus, "; }
		if ( Parser.InneholderSeparertOrd( "fashion", AllTexts ) > -1) { Bekledningsstil = Bekledningsstil + "mote, "; }
		if ( Parser.InneholderSeparertOrd( "lace", AllTexts ) > -1) { Bekledningsstil = Bekledningsstil + "blonder, "; }
		if ( Parser.InneholderSeparertOrd( "fringe", AllTexts ) > -1) { Bekledningsstil = Bekledningsstil + "frynser, "; }
		if ( Parser.InneholderSeparertOrd( "princess", AllTexts ) > -1) { Bekledningsstil = Bekledningsstil + "prinsesse, "; }
		return Bekledningsstil;
	}
}
