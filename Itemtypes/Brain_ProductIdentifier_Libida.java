package Itemtypes;

import java.util.HashMap;

import Control.TextHandler;

public class Brain_ProductIdentifier_Libida extends Brain_ProductIdentifier {
	
	@Override
	public String FindSubjects( String ImageMetaHead, String Category, String ParentCategory, String URL ) {
		TextHandler Parser = new TextHandler();
		//System.out.println( this.getClass().toString()+" FindSubjects ImageMetaHead="+ImageMetaHead+" Category="+Category+" ParentCategory="+ParentCategory+" URL="+URL );
		//ImageText+" "+Meta+" "+Head, Category, ParentCategory, TargetURL.Get_Adresse().toString()
		String Subject = "";
		if ( ImageMetaHead.indexOf( "business owners" ) > -1 ) {
			ImageMetaHead = ImageMetaHead.substring( ImageMetaHead.indexOf( "business owners." )+"business owners.".length() );
		}
		if ( ImageMetaHead.indexOf( "dropship sex toys uk" ) > -1 ) {
			ImageMetaHead = ImageMetaHead.substring( 0, ImageMetaHead.indexOf( "dropship sex toys uk" ) );
		}
		
		//parentcategory

		//URL
	
		//ImageMetaHead
		if ( Parser.InneholderSeparertOrd( "sex gel", ImageMetaHead ) > -1) {  Subject = "Glidemiddel";   }
		if ( Parser.InneholderSeparertOrd( "body chocolate", ImageMetaHead ) > -1) {  Subject = "Flytende Sjokolade";   }
		if ( Parser.InneholderSeparertOrd( "massage", ImageMetaHead ) > -1) {  Subject = "Massageutstyr";   }
		if ( Parser.InneholderSeparertOrd( "couples kit", ImageMetaHead ) > -1) {  Subject = "Sett for Par";   }
		if ( Parser.InneholderSeparertOrd( "suction handle", ImageMetaHead ) > -1) {  Subject = "Håndtak med Sugekopper";   }
		if ( Parser.InneholderSeparertOrd( "ring", ImageMetaHead ) > -1) {  Subject = "Penisringer";   }
		if ( Parser.InneholderSeparertOrd( "penis enhancer", ImageMetaHead ) > -1) {  Subject = "Penisforst&oslashrrer";   }
		if ( Parser.InneholderSeparertOrd( "scented", ImageMetaHead ) > -1) {  Subject = "Aroma";   }
		if ( Parser.InneholderSeparertOrd( "cuffs", ImageMetaHead ) > -1) {  Subject = "H&aringndjern";   }
		if ( Parser.InneholderSeparertOrd( "clamps", ImageMetaHead ) > -1) {  Subject = "Klyper";   }
		if ( Parser.InneholderSeparertOrd( "rope", ImageMetaHead ) > -1) {  Subject = "Tau";   }
		if ( Parser.InneholderSeparertOrd( "whip", ImageMetaHead ) > -1) {  Subject = "Pisk";   }
		if ( Parser.InneholderSeparertOrd( "foot pump", ImageMetaHead ) > -1) {  Subject = "Fotpumpe";   }
		if ( Parser.InneholderSeparertOrd( "butt plug", ImageMetaHead ) > -1) {  Subject = "Analplugg";   }
		if ( Parser.InneholderSeparertOrd( "buttplug", ImageMetaHead ) > -1) {  Subject = "Analplugg";   }
		if ( Parser.InneholderSeparertOrd( "doll", ImageMetaHead ) > -1) {  Subject = "Sexdukke";   }
		if ( Parser.InneholderSeparertOrd( "balls", ImageMetaHead ) > -1) {  Subject = "Egg";   }
		if ( Parser.InneholderSeparertOrd( "bullet", ImageMetaHead ) > -1) {  Subject = "Kule";   }
		if ( Parser.InneholderSeparertOrd( "vibrator", ImageMetaHead ) > -1) {  Subject = "Vibrator";   }
		if ( Parser.InneholderSeparertOrd( "lube", ImageMetaHead ) > -1) {  Subject = "Glidemiddel";   }
		if ( Parser.InneholderSeparertOrd( "bride to be", ImageMetaHead ) > -1) {  Subject = "Moro For Utdrikningslag";   }
		if ( Parser.InneholderSeparertOrd( "lubricant", ImageMetaHead ) > -1) {  Subject = "Glidemiddel";   }
		if ( Parser.InneholderSeparertOrd( "booster", ImageMetaHead ) > -1) {  Subject = "Afrodisiak";   }
		if ( Parser.InneholderSeparertOrd( "book", ImageMetaHead ) > -1) {  Subject = "Bok";   }
		//Category
		if ( Parser.InneholderSeparertOrd( "eggs & rings", Category ) > -1) {  Subject = "Eggs & Rings";   }
		if ( Parser.InneholderSeparertOrd( "couples", Category ) > -1) {  Subject = "Parleker";   }
		if ( Parser.InneholderSeparertOrd( "valentine`s day", Category ) > -1) {  Subject = "Valentine's day";   }
		if ( Parser.InneholderSeparertOrd( "halloween", Category ) > -1) {  Subject = "halloween";   }
		if ( Parser.InneholderSeparertOrd( "sleeves & rings", Category ) > -1) {  Subject = "Ringer";   }
		if ( Parser.InneholderSeparertOrd( "costumes", Category ) > -1) {  Subject = "Kostyme";   }
		if ( Parser.InneholderSeparertOrd( "gifts and novelties", Category ) > -1) {  Subject = "Gaveidè";   }
		if ( Parser.InneholderSeparertOrd( "gifts", Category ) > -1) {  Subject = "Gaveidè";   }
		if ( Parser.InneholderSeparertOrd( "playtime", Category ) > -1) {  Subject = "Leket&oslashy";   }
		if ( Parser.InneholderSeparertOrd( "accessories", Category ) > -1) {  Subject = "Tilbeh&oslashr";   }
		if ( Parser.InneholderSeparertOrd( "whips", Category ) > -1) {  Subject = "Pisk";   }
		if ( Parser.InneholderSeparertOrd( "eat me", Category ) > -1) {  Subject = "Spiselig";   }
		if ( Parser.InneholderSeparertOrd( "clothing for him", Category ) > -1) {  Subject = "Kl&aeligr for Ham";   }
		if ( Parser.InneholderSeparertOrd( "books", ImageMetaHead ) > -1) {  Subject = "Bok";   }
		if ( Parser.InneholderSeparertOrd( "movies", ImageMetaHead ) > -1) {  Subject = "Film";   }
		if ( Parser.InneholderSeparertOrd( "dildos", Category ) > -1) {  Subject = "Dildo";   }
		if ( Parser.InneholderSeparertOrd( "nipple play", Category ) > -1) {  Subject = "Nipple Play";   }
		if ( Parser.InneholderSeparertOrd( "penis pumps", Category ) > -1) {  Subject = "Penispumpe";   }
		if ( Parser.InneholderSeparertOrd( "remote control", Category ) > -1) {  Subject = "Fjernstyrer";   }
		if ( Parser.InneholderSeparertOrd( "masturbators", Category ) > -1) {  Subject = "Masturbator";   }
		if ( Parser.InneholderSeparertOrd( "butt plugs", Category ) > -1) {  Subject = "Analplugg";   }
		if ( Parser.InneholderSeparertOrd( "glass plugs", Category ) > -1) {  Subject = "Analplugg";   }
		if ( Parser.InneholderSeparertOrd( "anal beads", Category ) > -1) {  Subject = "Analkuler";   }
		if ( Parser.InneholderSeparertOrd( "anal sundries", Category ) > -1) {  Subject = "Analkrem";   }
		if ( Parser.InneholderSeparertOrd( "anal dildos", Category ) > -1) {  Subject = "Analdildo";   }
		if ( Parser.InneholderSeparertOrd( "anal toys", Category ) > -1) {  Subject = "Anale Leker";   }
		if ( Parser.InneholderSeparertOrd( "clit teasers", Category ) > -1) {  Subject = "Klitorisstimulator";   }
		if ( Parser.InneholderSeparertOrd( "vibrator kits", Category ) > -1) {  Subject = "Vibratorsett";   }
		if ( Parser.InneholderSeparertOrd( "vibrators", Category ) > -1) {  Subject = "Vibrator";   }
		if ( Parser.InneholderSeparertOrd( "g spot", Category ) > -1) {  Subject = "G-punktvibrator";   }
		if ( Parser.InneholderSeparertOrd( "hen and stag", Category ) > -1) {  Subject = "Moro For Utdrikningslag";   }
		if ( Parser.InneholderSeparertOrd( "lubricants", Category ) > -1) {  Subject = "Glidemiddel";   }
		if ( Parser.InneholderSeparertOrd( "creams and sprays", Category ) > -1) {  Subject = "Krem\\Spray";   }
		if ( Parser.InneholderSeparertOrd( "games", Category ) > -1) {  Subject = "Spill";   }
		if ( Parser.InneholderSeparertOrd( "sex dolls", Category ) > -1) {  Subject = "Sexdukke";   }
		if ( Parser.InneholderSeparertOrd( "restraints", Category ) > -1) {  Subject = "Bondageleker";   }
		//if ( Parser.InneholderSeparertOrd( "vibrator", ImageMetaHead ) > -1) {  Subject = "Vibrator";   }
		if ( Parser.InneholderSeparertOrd( "toys for her", Category ) > -1) {  Subject = "Leker for Kvinner";   }
		if ( Parser.InneholderSeparertOrd( "bras and knickers", Category ) > -1) {  Subject = "Sexy Undert&oslashy";   }
		if ( Parser.InneholderSeparertOrd( "sexy lingerie", Category ) > -1) {  Subject = "Sexy Undert&oslashy";   }
		if ( Parser.InneholderSeparertOrd( "gay", Category ) > -1) {  Subject = "Gay";   }
		if ( Parser.InneholderSeparertOrd( "condoms", Category ) > -1) {  Subject = "Kondomer";   }
		if ( Parser.InneholderSeparertOrd( "aroma", Category ) > -1) {  Subject = "Aroma";   }
		if ( Parser.InneholderSeparertOrd( "anime", Category ) > -1) {  Subject = "Fetisj";   }
		if ( Parser.InneholderSeparertOrd( "fetish", Category ) > -1) {  Subject = "Fetisj";   }
		if ( Parser.InneholderSeparertOrd( "double enders", Category ) > -1) {  Subject = "Dobbeldildo";   }
		if ( Parser.InneholderSeparertOrd( "strap ons", Category ) > -1) {  Subject = "Strap-On";   }
		if ( Parser.InneholderSeparertOrd( "finger fun", Category ) > -1) {  Subject = "Fingermoro";   }

		if ( Subject.equals("") ) {
			//System.out.println( this.getClass().toString()+" FindSubjects ImageMetaHead="+ImageMetaHead+" Category="+Category+" ParentCategory="+ParentCategory+" URL="+URL );
			//System.out.println( this.getClass().toString()+" FindSubjects Subject="+Subject );
		}
		return Subject;
	}
	
	@Override
	public String Define_DynamiskHovedkategori( String ParentCategory, String Subject, String Stikkord, String URL, String Head ) {
		
		String DynamiskHovedkategori = "Diverse";
		
		//USIKKERT
		//ParentCategory

		//subjekt

		
		//SIKKERT
		//ParentCategory
		HashMap Sikkert_Hovedkategori_Hovedkategori = new HashMap();

		if ( ( ParentCategory != null ) && ( Sikkert_Hovedkategori_Hovedkategori.get( ParentCategory.toLowerCase() ) != null ) ) {
			DynamiskHovedkategori = (String) Sikkert_Hovedkategori_Hovedkategori.get( ParentCategory.toLowerCase() );
		}
		//subjekt
		HashMap Sikkert_Subjekt_Hovedkategori = new HashMap();
		Sikkert_Subjekt_Hovedkategori.put("vibrator", "Vibratorer");
		Sikkert_Subjekt_Hovedkategori.put("analkuler", "Analt");
		Sikkert_Subjekt_Hovedkategori.put("analplugg", "Analt");
		Sikkert_Subjekt_Hovedkategori.put("analdildo", "Analt");
		Sikkert_Subjekt_Hovedkategori.put("analkrem", "Analt");
		Sikkert_Subjekt_Hovedkategori.put("anale leker", "Analt");
		Sikkert_Subjekt_Hovedkategori.put("g-punktvibrator", "Vibratorer");
		Sikkert_Subjekt_Hovedkategori.put("vibratorsett", "Vibratorer");
		Sikkert_Subjekt_Hovedkategori.put("glidemiddel", "Tilbeh&oslashr");
		Sikkert_Subjekt_Hovedkategori.put("moro for utdrikningslag", "Spill og moro");
		Sikkert_Subjekt_Hovedkategori.put("krem\\spray", "Tilbeh&oslashr");
		Sikkert_Subjekt_Hovedkategori.put("spill", "Spill og moro");
		Sikkert_Subjekt_Hovedkategori.put("klitorisstimulator", "For henne");
		Sikkert_Subjekt_Hovedkategori.put("masturbator", "For han");
		Sikkert_Subjekt_Hovedkategori.put("dildo", "Dildo");
		Sikkert_Subjekt_Hovedkategori.put("pisk", "Bondage");
		Sikkert_Subjekt_Hovedkategori.put("bondageleker", "Bondage");
		Sikkert_Subjekt_Hovedkategori.put("bok", "Filmer og b&oslashker");
		Sikkert_Subjekt_Hovedkategori.put("leker for kvinner", "For henne");
		Sikkert_Subjekt_Hovedkategori.put("afrodisiak", "Tilbeh&oslashr");
		Sikkert_Subjekt_Hovedkategori.put("massageutstyr", "Massageutstyr");
		Sikkert_Subjekt_Hovedkategori.put("sexy undert&oslashy", "Sexy Undert&oslashy");
		Sikkert_Subjekt_Hovedkategori.put("penisringer", "For han");
		Sikkert_Subjekt_Hovedkategori.put("penispumpe", "For han");
		Sikkert_Subjekt_Hovedkategori.put("kule", "For henne");
		Sikkert_Subjekt_Hovedkategori.put("gay", "Gay");
		Sikkert_Subjekt_Hovedkategori.put("egg", "For henne");
		Sikkert_Subjekt_Hovedkategori.put("flytende sjokolade", "Spill og moro");
		Sikkert_Subjekt_Hovedkategori.put("kondomer", "Tilbeh&oslashr");
		Sikkert_Subjekt_Hovedkategori.put("?", "Usortert");

		if ( Sikkert_Subjekt_Hovedkategori.get( Subject.toLowerCase() ) != null ) {
			DynamiskHovedkategori = (String) Sikkert_Subjekt_Hovedkategori.get( Subject.toLowerCase() );
		}
		//stikkord

		//sære regler
	
		if ( DynamiskHovedkategori == null ) {
			DynamiskHovedkategori = "Diverse";
		}
		if ( ( DynamiskHovedkategori.equals("Diverse") ) && ( Subject.equals("") == false ) ) {
			//System.out.println( this.getClass().toString()+" Define_DynamiskHovedkategori ParentCategory="+ParentCategory+" Subject="+Subject+" Stikkord="+Stikkord );
			//System.out.println( this.getClass().toString()+" Define_DynamiskHovedkategori DynamiskHovedkategori="+DynamiskHovedkategori+" hashmap="+Sikkert_Subjekt_Hovedkategori.get( Subject.toLowerCase() ) );
		}
		return DynamiskHovedkategori;
	}
	
	@Override
	public String Define_DynamiskSubkategori( String Category, String Subject, String Stikkord, String Head, String URL, String Materialer ) {
		String DynamiskSubkategori = "Diverse";
		
		//USIKKERT
		//Category

		//subjekt
		
		//SIKKERT
		//subcategory
		/*HashMap Sikkert_Kategori_Kategori = new HashMap();
		Sikkert_Kategori_Kategori.put("strap ons", "Strap-ons");
		Sikkert_Kategori_Kategori.put("creams and sprays", "Kremer");
		Sikkert_Kategori_Kategori.put("lubricants", "Glidekremer");
		Sikkert_Kategori_Kategori.put("aromas", "Dufter");
		Sikkert_Kategori_Kategori.put("books", "B&oslashker");
		Sikkert_Kategori_Kategori.put("movies", "Filmer");
		Sikkert_Kategori_Kategori.put("rabbit vibrators", "Rabbit vibratorer");
		Sikkert_Kategori_Kategori.put("cock rings", "Penisringer");
		Sikkert_Kategori_Kategori.put("fetish", "Fetisjer");
		Sikkert_Kategori_Kategori.put("classic vibrators", "Klassiske vibratorer");
		Sikkert_Kategori_Kategori.put("whips", "Pisker");
		Sikkert_Kategori_Kategori.put("bullets and eggs", "Bullets og Egg");
		Sikkert_Kategori_Kategori.put("dildos", "Dildoer");
		Sikkert_Kategori_Kategori.put("sleeves & rings", "Penisringer");
		Sikkert_Kategori_Kategori.put("butt plugs galore", "Butt Plugs");
		Sikkert_Kategori_Kategori.put("finger fun", "Fingermoro");
		Sikkert_Kategori_Kategori.put("eggs & rings", "Egg og Ringer");
		Sikkert_Kategori_Kategori.put("clit teasers", "Klitorisstimulatorer");
		Sikkert_Kategori_Kategori.put("games", "Spill og Leker");
		Sikkert_Kategori_Kategori.put("butt plug", "Butt Plugs");

		if ( ( Category != null ) && ( Sikkert_Kategori_Kategori.get( Category.toLowerCase() ) != null ) ) {
			DynamiskSubkategori = (String) Sikkert_Kategori_Kategori.get( Category.toLowerCase() );
		}*/
		// SUBJECT
		HashMap Sikkert_Subjekt_Kategori = new HashMap();
		Sikkert_Subjekt_Kategori.put("analkuler", "Analkuler");
		Sikkert_Subjekt_Kategori.put("analplugg", "Analplugg");
		Sikkert_Subjekt_Kategori.put("analdildo", "Analdildo");
		Sikkert_Subjekt_Kategori.put("g-punktvibrator", "G-punktvibrator");
		Sikkert_Subjekt_Kategori.put("vibratorsett", "Vibratorsett");
		Sikkert_Subjekt_Kategori.put("glidemiddel", "Glidemiddel");
		Sikkert_Subjekt_Kategori.put("moro for utdrikningslag", "Utdrikningslag");
		Sikkert_Subjekt_Kategori.put("krem\\spray", "Kremer og spray");
		Sikkert_Subjekt_Kategori.put("spill", "Spill");
		Sikkert_Subjekt_Kategori.put("klitorisstimulator", "Klitorisstimulator");
		Sikkert_Subjekt_Kategori.put("masturbator", "Masturbators");
		Sikkert_Subjekt_Kategori.put("pisk", "Pisk");
		Sikkert_Subjekt_Kategori.put("bondageleker", "Bindeleker");
		Sikkert_Subjekt_Kategori.put("bok", "B&oslashker");
		Sikkert_Subjekt_Kategori.put("afrodisiak", "Afrodisiak");
		Sikkert_Subjekt_Kategori.put("penisringer", "Penisringer og stimulering");
		Sikkert_Subjekt_Kategori.put("penispumpe", "Penispumpe");
		Sikkert_Subjekt_Kategori.put("sexy undert&oslashy", "Sett");
		Sikkert_Subjekt_Kategori.put("kule", "Kuler og egg");
		Sikkert_Subjekt_Kategori.put("egg", "Kuler og egg");
		Sikkert_Subjekt_Kategori.put("flytende sjokolade", "Spiselig");
		Sikkert_Subjekt_Kategori.put("kondomer", "kondomer");
		Sikkert_Subjekt_Kategori.put("vibrator", "Vibratorer");
		Sikkert_Subjekt_Kategori.put("?", "Usortert");
		
		if ( Sikkert_Subjekt_Kategori.get( Subject.toLowerCase() ) != null ) {
			DynamiskSubkategori = (String) Sikkert_Subjekt_Kategori.get( Subject.toLowerCase() );
		}
		//stikkord

		//head

		//sære regler


		if ( DynamiskSubkategori == null ) {
			DynamiskSubkategori = "Diverse";
		}
		if ( ( DynamiskSubkategori.equals("Diverse") ) && ( Subject.equals("") == false ) ) {
			//System.out.println( this.getClass().toString()+" DynamiskSubkategori Category="+Category+" Subject="+Subject+" Stikkord="+Stikkord );
			//System.out.println( this.getClass().toString()+" DynamiskSubkategori DynamiskSubkategori="+DynamiskSubkategori+" hashmap="+Sikkert_Subjekt_Kategori.get( Subject.toLowerCase() ) );
		}
		return DynamiskSubkategori;
	}

}
