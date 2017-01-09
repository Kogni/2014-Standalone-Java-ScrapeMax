package Itemtypes;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Control.TextHandler;
import ItemStats.ItemStats_Stater;
import ItemStats.ItemStats_Tema;
import ItemStats.Object_ItemStats_Stat;
import ItemStats.Object_ItemStats_Tema;

public class Brain_ProductIdentifier {
	
	public String FindSubjects( String ImageMetaHead, String Category, String ParentCategory, String URL ) {
		//System.out.println( this.getClass().toString()+" FindSubjects ImageMetaHead="+ImageMetaHead+" Category="+Category+" ParentCategory="+ParentCategory+" URL="+URL );
		//ImageText+" "+Meta+" "+Head, Category, ParentCategory, TargetURL.Get_Adresse().toString()
		TextHandler Parser = new TextHandler();
		String Subject = "";
		
		//parentcategory
		if ( Parser.InneholderSeparertOrd( "beads", ParentCategory ) > -1) { Subject = "Perler"; }
		if ( Parser.InneholderSeparertOrd( "shoes", ParentCategory ) > -1) {  Subject = "Sko"; }
		//if ( Parser.InneholderSeparertOrd( "jewelry", ParentCategory ) > -1) {  Subject = "Smykker";   } ubrukelig ukonkret som subjekt
		if ( Parser.InneholderSeparertOrd( "handbag", ParentCategory ) > -1) {  Subject = "Veske";   }
		if ( Parser.InneholderSeparertOrd( "power supply units", ParentCategory ) > -1) {  Subject = "Str&oslashmforsyning";   }
		//URL
		//if ( Parser.InneholderSeparertOrd( "adapter", URL ) > -1) {  Subject = "Adapter";  }for ukonkret
		//if ( Parser.InneholderSeparertOrd( "alarm", URL ) > -1) {  Subject = "Alarm";  }for ukonkret
		if ( Parser.InneholderSeparertOrd( "bag", URL ) > -1) {  Subject = "Bagg";   }  
		if ( Parser.InneholderSeparertOrd( "messenger bag", URL ) > -1) {  Subject = "Bagg";   }
		//if ( Parser.InneholderSeparertOrd( "battery", URL ) > -1) {   Subject = "Batteri";   }  for ukonkret
		//if ( Parser.InneholderSeparertOrd( "batteries", URL ) > -1) {   Subject = "Batteri";   } for ukonkret
		//if ( Parser.InneholderSeparertOrd( "cable", URL ) > -1) {  Subject = "Kabel";  } for ukonkret
		//if ( Parser.InneholderSeparertOrd( "case", URL ) > -1) {   Subject = "Deksel";   }   for ukonkret
		//if ( Parser.InneholderSeparertOrd( "cover", URL ) > -1) {  Subject = "Deksel";   }   for ukonkret
		//if ( Parser.InneholderSeparertOrd( "screen guard", URL ) > -1) {   Subject = "Deksel";   }  for ukonkret
		//if ( Parser.InneholderSeparertOrd( "screen protector", URL ) > -1) {   Subject = "Deksel";   }  for ukonkret
		//if ( Parser.InneholderSeparertOrd( "skin", URL ) > -1) {  Subject = "Deksel";  }for ukonkret
		//if ( Parser.InneholderSeparertOrd( "charger", URL ) > -1) {  Subject = "Lader";  } //for ukonkret
		if ( Parser.InneholderSeparertOrd( "decoration", URL ) > -1 ) {  Subject = "Dekorasjon";  }
		//if ( Parser.InneholderSeparertOrd( "figure", URL ) > -1) {   Subject = "Modell";   }   for ukonkret
		//if ( Parser.InneholderSeparertOrd( "model", URL ) > -1) {   Subject = "Modell";   } for ukonkret
		if ( Parser.InneholderSeparertOrd( "ring", URL ) > -1) {  Subject = "Ring";   }  
		//if ( Parser.InneholderSeparertOrd( "cell phone", URL ) > -1) {   Subject = "Mobiltelefon";  } for ukonkret  
		//if ( Parser.InneholderSeparertOrd( "mobile phones", URL ) > -1) {  Subject = "Mobiltelefon";   } for ukonkret
		if ( Parser.InneholderSeparertOrd( "charm", URL ) > -1) {   Subject = "Anheng";   }  
		if ( Parser.InneholderSeparertOrd( "pendant", URL ) > -1) {  Subject = "Anheng";   }
		if ( Parser.InneholderSeparertOrd( "memory stick", URL ) > -1) {  Subject = "Minnepinne";   }  
		if ( Parser.InneholderSeparertOrd( "flash drive", URL ) > -1) {  Subject = "Minnepinne";   }
		if ( Parser.InneholderSeparertOrd( "necklace", URL ) > -1) {  Subject = "Halskjede";   }  
		if ( Parser.InneholderSeparertOrd( "smartphone", URL ) > -1) {  Subject = "Smarttelefon";  }
		if ( Parser.InneholderSeparertOrd( "scarf", URL ) > -1) { Subject = "Skjerf";  }
		if ( Parser.InneholderSeparertOrd( "spy cam", URL ) > -1) { Subject = "Spionkamera";  }
		//if ( Parser.InneholderSeparertOrd( "swimwear", URL ) > -1) {  Subject = "Badet&oslashy";   } for ukonkret
		//if ( Parser.InneholderSeparertOrd( "beachwear", URL ) > -1) {  Subject = "Badet&oslashy";   } for ukonkret
		//if ( Parser.InneholderSeparertOrd( "bathing suit", URL ) > -1) {  Subject = "Badet&oslashy";   } for ukonkret
		if ( Parser.InneholderSeparertOrd( "glove", URL ) > -1) {  Subject = "Hanske";   }  
		if ( Parser.InneholderSeparertOrd( "handske", URL ) > -1) {  Subject = "Hanske";   }
		if ( Parser.InneholderSeparertOrd( "earmuff", URL ) > -1) { Subject = "&oslashrevarmer";  }
		if ( Parser.InneholderSeparertOrd( "wallets", URL ) > -1) {  Subject = "Lommebok";   }  
		if ( Parser.InneholderSeparertOrd( "wallet", URL ) > -1) {  Subject = "Lommebok";   }
		if ( Parser.InneholderSeparertOrd( "upholstery", URL ) > -1) {  Subject = "Trekk";   }  
		if ( Parser.InneholderSeparertOrd( "upholsteries", URL ) > -1) {  Subject = "Trekk";   }
		if ( Parser.InneholderSeparertOrd( "pullover", URL ) > -1) {  Subject = "Genser";   }  
		if ( Parser.InneholderSeparertOrd( "sweater", URL ) > -1) {  Subject = "Genser";   }
		//if ( Parser.InneholderSeparertOrd( "jewelry", URL ) > -1) {  Subject = "Smykker";   }  //for usopesifisert
		if ( Parser.InneholderSeparertOrd( "jewelry set", URL ) > -1) {  Subject = "Smykkesett";   }  
		//if ( Parser.InneholderSeparertOrd( "lingerie", URL ) > -1) {  Subject = "Undert&oslashy";   }  for ukonkret
		//if ( Parser.InneholderSeparertOrd( "underwear", URL ) > -1) {  Subject = "Undert&oslashy";  }for ukonkret
		if ( Parser.InneholderSeparertOrd( "3d glasses", URL ) > -1) {  Subject = "3D-briller";  }
		if ( Parser.InneholderSeparertOrd( "anklets", URL ) > -1) {  Subject = "Anklet";  }
		if ( Parser.InneholderSeparertOrd( "barrette", URL ) > -1) { Subject = "Spenne";  }
		if ( Parser.InneholderSeparertOrd( "bikini", URL ) > -1) {  Subject = "Bikini";  }
		if ( Parser.InneholderSeparertOrd( "boot", URL ) > -1) {  Subject = "Boots";  }
		if ( Parser.InneholderSeparertOrd( "bracelet", URL ) > -1) {  Subject = "Armb&aringnd";  }
		if ( Parser.InneholderSeparertOrd( "brooche", URL ) > -1) { Subject = "Brosje"; }
		if ( Parser.InneholderSeparertOrd( "carpet", URL ) > -1) { Subject = "Teppe"; }
		if ( Parser.InneholderSeparertOrd( "nail powder", URL ) > -1) { Subject = "Acrylic Powder";  }
		if ( Parser.InneholderSeparertOrd( "nail stamping", URL ) > -1) { Subject = "Neglestempling";  }
		if ( Parser.InneholderSeparertOrd( "nail sticker", URL ) > -1) { Subject = "Neglestickers";  }
		if ( Parser.InneholderSeparertOrd( "navel ring", URL ) > -1) { Subject = "Piercing";  }
		if ( Parser.InneholderSeparertOrd( "belly button ring", URL ) > -1) { Subject = "Piercing";  }
		if ( Parser.InneholderSeparertOrd( "tiara", URL ) > -1) {  Subject = "Tiara";  }
		if ( Parser.InneholderSeparertOrd( "toys", URL ) > -1) {  Subject = "Leke";  }
		if ( Parser.InneholderSeparertOrd( "usb cable", URL ) > -1) {  Subject = "USB-kabel";  }
		if ( Parser.InneholderSeparertOrd( "usb hub", URL ) > -1) {  Subject = "USB-Hub";  }
		//if ( Parser.InneholderSeparertOrd( "watch", URL ) > -1) {  Subject = "Klokke";  } for ukonkret
		if ( Parser.InneholderSeparertOrd( "seat cover", URL ) > -1) { Subject = "Setetrekk";  }
		if ( Parser.InneholderSeparertOrd( "eyelash", URL ) > -1) { Subject = "&oslashyevipp";  }
		if ( Parser.InneholderSeparertOrd( "mitten", URL ) > -1) { Subject = "Votter";  }
		if ( Parser.InneholderSeparertOrd( "beads", URL ) > -1) {   Subject = "Perler";   }
		if ( Parser.InneholderSeparertOrd( "shoe", URL ) > -1) {  Subject = "Sko";   }
		if ( Parser.InneholderSeparertOrd( "sneaker", URL ) > -1) { Subject = "Sneakers";  }
		if ( Parser.InneholderSeparertOrd( "flip flops", URL ) > -1) {  Subject = "Sandaler";   }
		if ( Parser.InneholderSeparertOrd( "sandal", URL ) > -1) {  Subject = "Sandaler";   }
		if ( Parser.InneholderSeparertOrd( "hat", URL ) > -1) { Subject = "Hatt";  }
		//if ( Parser.InneholderSeparertOrd( "make-up", URL ) > -1) { Subject = "Sminke";  } for ukonkret
		if ( Parser.InneholderSeparertOrd( "nail form", URL ) > -1) { Subject = "Negleform";  }
		if ( Parser.InneholderSeparertOrd( "nail gel", URL ) > -1) { Subject = "Acrylic liquid";  }
		if ( Parser.InneholderSeparertOrd( "nail polish", URL ) > -1) { Subject = "Neglelakk";  }
		if ( Parser.InneholderSeparertOrd( "outerwear", URL ) > -1) { Subject = "Yttert&oslashy";  }
		if ( Parser.InneholderSeparertOrd( "shawl", URL ) > -1) { Subject = "Sjal";  }
		if ( Parser.InneholderSeparertOrd( "skullies & beanies", URL ) > -1) { Subject = "Lue";  }
		if ( Parser.InneholderSeparertOrd( "beanie", URL ) > -1) { Subject = "Lue";  }
		if ( Parser.InneholderSeparertOrd( "skirt", URL ) > -1) { Subject = "Skj&oslashrt";  }
		if ( Parser.InneholderSeparertOrd( "wristwatches", URL ) > -1) { Subject = "Armb&aringndsur";  }
		if ( Parser.InneholderSeparertOrd( "wristwatch", URL ) > -1) { Subject = "Armb&aringndsur";  }
		if ( Parser.InneholderSeparertOrd( "apparel", URL ) > -1) { Subject = "Bekledning";  }
		if ( Parser.InneholderSeparertOrd( "ball gown", URL ) > -1) { Subject = "Ballkjole";  }
		if ( Parser.InneholderSeparertOrd( "belly ring", URL ) > -1) { Subject = "Navelpiercing";  }
		if ( Parser.InneholderSeparertOrd( "bell button", URL ) > -1) { Subject = "Navel";  }
		if ( Parser.InneholderSeparertOrd( "body jewelry", URL ) > -1) { Subject = "Kroppssmykke";  }
		if ( Parser.InneholderSeparertOrd( "bra ", URL ) > -1) { Subject = "BH ";  }
		if ( Parser.InneholderSeparertOrd( "clothing", URL ) > -1) { Subject = "Kl&aeligr";  }
		if ( Parser.InneholderSeparertOrd( "curler", URL ) > -1) { Subject = "Kr&oslashlltang";  }
		if ( Parser.InneholderSeparertOrd( "evening dresses", URL ) > -1) { Subject = "Aftenkjole";  }
		if ( Parser.InneholderSeparertOrd( "findings", URL ) > -1) { Subject = "Anheng";  }
		if ( Parser.InneholderSeparertOrd( "gown", URL ) > -1) { Subject = "Kjole";  }
		//if ( Parser.InneholderSeparertOrd( "hairwear", URL ) > -1) { Subject = "H&aringrpynt";  } for ukonkret
		if ( Parser.InneholderSeparertOrd( "headwear", URL ) > -1) { Subject = "Hodeplagg";  }
		if ( Parser.InneholderSeparertOrd( "jeans", URL ) > -1) { Subject = "Bukse";  }
		if ( Parser.InneholderSeparertOrd( "choker", URL ) > -1) {  Subject = "Choker";  }
		if ( Parser.InneholderSeparertOrd( "cooling", URL ) > -1) {  Subject = "Kj&oslashling";  }
		if ( Parser.InneholderSeparertOrd( "costume", URL ) > -1) { Subject = "Kostyme"; }
		if ( Parser.InneholderSeparertOrd( "display", URL ) > -1 ) {  Subject = "Display ";  }
		if ( Parser.InneholderSeparertOrd( "dolls", URL ) > -1) {  Subject = "Dukke";  }
		if ( Parser.InneholderSeparertOrd( "dress", URL ) > -1) { Subject = "Kjole"; }
		if ( Parser.InneholderSeparertOrd( "earring", URL ) > -1) { Subject = "&oslashredobber"; }
		if ( Parser.InneholderSeparertOrd( "glasses", URL ) > -1) { Subject = "Briller";  }
		if ( Parser.InneholderSeparertOrd( "gift box", URL ) > -1) {  Subject = "Gaveeske";  }
		if ( Parser.InneholderSeparertOrd( "hairpin", URL ) > -1) { Subject = "H&aringrn&aringl"; }
		if ( Parser.InneholderSeparertOrd( "hairband", URL ) > -1) { Subject = "H&aringrstrikk"; }
		if ( Parser.InneholderSeparertOrd( "hair stick", URL ) > -1) { Subject = "H&aringrpinne";  }
		if ( Parser.InneholderSeparertOrd( "hair jewelry", URL ) > -1) {  Subject = "H&aringrsmykke";  }
		if ( Parser.InneholderSeparertOrd( "handbag", URL ) > -1) { Subject = "Veske"; }
		if ( Parser.InneholderSeparertOrd( "headband", URL ) > -1) { Subject = "H&aringrb&aringnd"; }
		if ( Parser.InneholderSeparertOrd( "iphone", URL ) > -1 ) {  Subject = "iPhone";  }
		//if ( Parser.InneholderSeparertOrd( "lingerie", URL ) > -1) {  Subject = "Undert&oslashy";  } for ukonkret
		if ( Parser.InneholderSeparertOrd( "gadget", URL ) > -1) {  Subject = "Gadget";  }
		if ( Parser.InneholderSeparertOrd( "earphone", URL ) > -1) { Subject = "&oslashreklokker"; }
		if ( Parser.InneholderSeparertOrd( "headphone", URL ) > -1) { Subject = "Headset"; }
		if ( Parser.InneholderSeparertOrd( "helicopter", URL ) > -1) {  Subject = "Helikopter";  }
		if ( Parser.InneholderSeparertOrd( "light", URL ) > -1) {  Subject = "Lys";  }
		if ( Parser.InneholderSeparertOrd( "memory card", URL ) > -1) { Subject = "Minnekort";  }
		if ( Parser.InneholderSeparertOrd( "needle", URL ) > -1) { Subject = "N&aringl";  }
		//if ( Parser.InneholderSeparertOrd( "phone", URL ) > -1) {  Subject = "Telefon";  } for ukonkret
		if ( Parser.InneholderSeparertOrd( "stamping", URL ) > -1) { Subject = "Stempelsett";  } 
		if ( Parser.InneholderSeparertOrd( "sticker", URL ) > -1) { Subject = "Klistremerke";  }
		if ( Parser.InneholderSeparertOrd( "support", URL ) > -1) { Subject = "St&oslashtte";  }
		if ( Parser.InneholderSeparertOrd( "coat", URL ) > -1) { Subject = "K&aringpe";  }
		if ( Parser.InneholderSeparertOrd( "button", URL ) > -1) { Subject = "Knapp";  }
		//if ( Parser.InneholderSeparertOrd( "accessories", URL ) > -1) { Subject = "Accessorier";  } for ukonkret
		//if ( Parser.InneholderSeparertOrd( "accessory", URL ) > -1) { Subject = "Tilbeh&oslashr";  } for ukonklret
		if ( Parser.InneholderSeparertOrd( "emblems", URL ) > -1) { Subject = "Emblemer";  }
		if ( Parser.InneholderSeparertOrd( "glue", URL ) > -1) { Subject = "Lim";  }
		if ( Parser.InneholderSeparertOrd( "mats", URL ) > -1) { Subject = "Matte";  }
		if ( Parser.InneholderSeparertOrd( "petals", URL ) > -1) { Subject = "Kronblader";  }
		if ( Parser.InneholderSeparertOrd( "roller", URL ) > -1) { Subject = "Ruller";  }
		if ( Parser.InneholderSeparertOrd( "barbell", URL ) > -1) { Subject = "Piercing";  }
		if ( Parser.InneholderSeparertOrd( "belt", URL ) > -1) { Subject = "Belte";  }
		if ( Parser.InneholderSeparertOrd( "piercing", URL ) > -1) { Subject = "Piercing";  }
		if ( Parser.InneholderSeparertOrd( "belly-stud", URL ) > -1) { Subject = "Piercing";  }
		if ( Parser.InneholderSeparertOrd( "hair-stick", URL ) > -1) { Subject = "H&aringrpinne";  }
		if ( Parser.InneholderSeparertOrd( "hair-comb", URL ) > -1) { Subject = "H&aringrkam";  }
		if ( Parser.InneholderSeparertOrd( "hair-pin", URL ) > -1) { Subject = "H&aringrpinne";  }
		if ( Parser.InneholderSeparertOrd( "handbag", URL ) > -1) { Subject = "H&aringndveske";  }
		if ( Parser.InneholderSeparertOrd( "t shirt", URL ) > -1) { Subject = "T-Skjorte";  }
		
		//ImageMetaHead
		if ( Parser.InneholderSeparertOrd( "ring", ImageMetaHead ) > -1) {  Subject = "Ring";   }
		if ( Parser.InneholderSeparertOrd( "necklace", ImageMetaHead ) > -1) {  Subject = "Halskjede";   }
		//if ( Parser.InneholderSeparertOrd( "screen protector", ImageMetaHead ) > -1) {   Subject = "Deksel";   }for ukonkret
		if ( Parser.InneholderSeparertOrd( "mouse", ImageMetaHead ) > -1) {   Subject = "Datamus";   }
		if ( Parser.InneholderSeparertOrd( "phone cover", ImageMetaHead ) > -1) {  Subject = "Telefondeksel";   }
		if ( Parser.InneholderSeparertOrd( "remote control", ImageMetaHead ) > -1) { Subject = "Fjernstyrer";  }
		if ( Parser.InneholderSeparertOrd( "cable", ImageMetaHead ) > -1) { Subject = "Kabel";  }
		if ( Parser.InneholderSeparertOrd( "adapter", ImageMetaHead ) > -1) { Subject = "Adapter";  }
		if ( Parser.InneholderSeparertOrd( "bracelet", ImageMetaHead ) > -1) { Subject = "Armb&aringnd";  }
		if ( Parser.InneholderSeparertOrd( "bikini", ImageMetaHead ) > -1) { Subject = "Bikini";  }
		if ( Parser.InneholderSeparertOrd( "wristwatches", ImageMetaHead ) > -1) { Subject = "Armb&aringndsur";  }
		if ( Parser.InneholderSeparertOrd( "necklace", ImageMetaHead ) > -1) { Subject = "Halskjede";  }
		if ( Parser.InneholderSeparertOrd( "jewelry findings", ImageMetaHead ) > -1) { Subject = "Anheng";  }
		if ( Parser.InneholderSeparertOrd( "earrings", ImageMetaHead ) > -1) {  Subject = "&oslashredobber";   }
		if ( Parser.InneholderSeparertOrd( "belly ring", ImageMetaHead ) > -1) {  Subject = "Piercing";   }
		//if ( Parser.InneholderSeparertOrd( "watch", ImageMetaHead ) > -1) {  Subject = "Klokke";   } for ukonkret
		if ( Parser.InneholderSeparertOrd( "crown", ImageMetaHead ) > -1) {  Subject = "Tiara";   }
		if ( Parser.InneholderSeparertOrd( "alarm clock", ImageMetaHead ) > -1) {  Subject = "Vekkerklokke";   }
		if ( Parser.InneholderSeparertOrd( "engagement ring", ImageMetaHead ) > -1) {  Subject = "Forlovelsesringer";   }
		if ( Parser.InneholderSeparertOrd( "keychain", ImageMetaHead ) > -1) {  Subject = "N&oslashkkelring";   }
		if ( Parser.InneholderSeparertOrd( "pendant", ImageMetaHead ) > -1) {  Subject = "Anheng";   }
		if ( Parser.InneholderSeparertOrd( "gift bag", ImageMetaHead ) > -1) {  Subject = "Gavepose";   }
		if ( Parser.InneholderSeparertOrd( "bangle", ImageMetaHead ) > -1) {  Subject = "Bangle";   }
		//if ( Parser.InneholderSeparertOrd( "underwear", ImageMetaHead ) > -1) {  Subject = "Undert&oslashy";   } for ukonkret
		if ( Parser.InneholderSeparertOrd( "belt", ImageMetaHead ) > -1) {  Subject = "Belte";   }
		if ( Parser.InneholderSeparertOrd( "scarf", ImageMetaHead ) > -1) {  Subject = "Skjerf";   }
		if ( Parser.InneholderSeparertOrd( "tank top", ImageMetaHead ) > -1) {  Subject = "Topp";   }
		if ( Parser.InneholderSeparertOrd( "uv gel", ImageMetaHead ) > -1) {  Subject = "Acrylic Liquid";   }
		if ( Parser.InneholderSeparertOrd( "nail sticker", ImageMetaHead ) > -1) {  Subject = "Neglestickers";   }
		//if ( Parser.InneholderSeparertOrd( "makeup", ImageMetaHead ) > -1) {  Subject = "Sminke";   } for ukonkret
		if ( Parser.InneholderSeparertOrd( "eyeshadow", ImageMetaHead ) > -1) {  Subject = "&oslashyenskygge";   }
		if ( Parser.InneholderSeparertOrd( "eyelashes", ImageMetaHead ) > -1) {  Subject = "&oslashyevipper";   }
		if ( Parser.InneholderSeparertOrd( "micro sd", ImageMetaHead ) > -1) {  Subject = "Minnekort";   }
		if ( Parser.InneholderSeparertOrd( "sandal", ImageMetaHead ) > -1) {  Subject = "Sandaler";   }
		if ( Parser.InneholderSeparertOrd( "usb hub", ImageMetaHead ) > -1) {  Subject = "USB hub";   }
		if ( Parser.InneholderSeparertOrd( "hair band", ImageMetaHead ) > -1) {  Subject = "H&aringrb&aringnd";   }
		if ( Parser.InneholderSeparertOrd( "brooch", ImageMetaHead ) > -1) {  Subject = "Brosje";   }
		//if ( Parser.InneholderSeparertOrd( "corrugator", ImageMetaHead ) > -1) {  Subject = "Korrugator";   } for ukonkret
		if ( Parser.InneholderSeparertOrd( "hdd case", ImageMetaHead ) > -1) {  Subject = "HDD Deksel";   }
		if ( Parser.InneholderSeparertOrd( "nail tips", ImageMetaHead ) > -1) {  Subject = "Falske Negler";   }
		if ( Parser.InneholderSeparertOrd( "brushes set", ImageMetaHead ) > -1) {  Subject = "Penselsett";   }
		if ( Parser.InneholderSeparertOrd( "hard drive case", ImageMetaHead ) > -1) {  Subject = "Harddiskbagg";   }
		if ( Parser.InneholderSeparertOrd( "eyeliner", ImageMetaHead ) > -1) {  Subject = "Eyeliner";   }
		if ( Parser.InneholderSeparertOrd( "barrette", ImageMetaHead ) > -1) {  Subject = "H&aringrklype";   }
		if ( Parser.InneholderSeparertOrd( "hdd enclosure", ImageMetaHead ) > -1) {  Subject = "HDD Deksel";   }
		if ( Parser.InneholderSeparertOrd( "makeup brush", ImageMetaHead ) > -1) {  Subject = "Makeupb&oslashrster";   }
		if ( Parser.InneholderSeparertOrd( "alcohol tester", ImageMetaHead ) > -1) {  Subject = "Alkoholtester";   }
		if ( Parser.InneholderSeparertOrd( "beach dress", ImageMetaHead ) > -1) {  Subject = "Kjole";   }
		if ( Parser.InneholderSeparertOrd( "keyboard", ImageMetaHead ) > -1) {  Subject = "Tastatur";   }
		if ( Parser.InneholderSeparertOrd( "mini keyboard", ImageMetaHead ) > -1) {  Subject = "Minitastatur";   }
		//if ( Parser.InneholderSeparertOrd( "protective case", ImageMetaHead ) > -1) {  Subject = "Deksel";   } for ukonkret
		//if ( Parser.InneholderSeparertOrd( "waterproof bag", ImageMetaHead ) > -1) {  Subject = "Deksel";   }for ukonkret
		//if ( Parser.InneholderSeparertOrd( "silicone case", ImageMetaHead ) > -1) {  Subject = "Deksel";   }for ukonkret
		//if ( Parser.InneholderSeparertOrd( "charger", ImageMetaHead ) > -1) {  Subject = "Lader";   } for ukonkret
		if ( Parser.InneholderSeparertOrd( "nail glitter powder", ImageMetaHead ) > -1) {  Subject = "Glitterpulver";   }
		if ( Parser.InneholderSeparertOrd( "nail foils", ImageMetaHead ) > -1) {  Subject = "Neglestickers";   }
		if ( Parser.InneholderSeparertOrd( "make up bag", ImageMetaHead ) > -1) {  Subject = "Toalettveske";   }
		if ( Parser.InneholderSeparertOrd( "camera battery", ImageMetaHead ) > -1) {  Subject = "Kamerabatteri";   }
		if ( Parser.InneholderSeparertOrd( "modem", ImageMetaHead ) > -1) {  Subject = "Modem";   }
		if ( Parser.InneholderSeparertOrd( "hard drive", ImageMetaHead ) > -1) {  Subject = "Harddisk";   }
		if ( Parser.InneholderSeparertOrd( "mascara", ImageMetaHead ) > -1) {  Subject = "Mascara";   }
		if ( Parser.InneholderSeparertOrd( "tattoo kit", ImageMetaHead ) > -1) {  Subject = "Tatoveringssett";   }
		if ( Parser.InneholderSeparertOrd( "power supply", ImageMetaHead ) > -1) {  Subject = "Str&oslashmforsyning";   }
		if ( Parser.InneholderSeparertOrd( "light bulb", ImageMetaHead ) > -1) {  Subject = "Lysp&aeligre";   }
		if ( Parser.InneholderSeparertOrd( "photo frame", ImageMetaHead ) > -1) {  Subject = "Fotoramme";   }
		if ( Parser.InneholderSeparertOrd( "mannequin", ImageMetaHead ) > -1) {  Subject = "Utstillingsdukke";   }
		if ( Parser.InneholderSeparertOrd( "led bulb", ImageMetaHead ) > -1) {  Subject = "LEDp&aeligre";   }
		if ( Parser.InneholderSeparertOrd( "loudspeaker", ImageMetaHead ) > -1) {  Subject = "H&oslashytaler";   }
		if ( Parser.InneholderSeparertOrd( "multi tool knife", ImageMetaHead ) > -1) {  Subject = "Lommekniv";   }
		if ( Parser.InneholderSeparertOrd( "fabrics", ImageMetaHead ) > -1) {  Subject = "Tekstiler";   }
		if ( Parser.InneholderSeparertOrd( "drinking dispense", ImageMetaHead ) > -1) {  Subject = "Drikkedispenser";   }
		if ( Parser.InneholderSeparertOrd( "travel mug", ImageMetaHead ) > -1) {  Subject = "Drikkebeger";   }
		//if ( Parser.InneholderSeparertOrd( "sponge", ImageMetaHead ) > -1) {  Subject = "Svamp";   } for ukonkret
		if ( Parser.InneholderSeparertOrd( "lantern", ImageMetaHead ) > -1) {  Subject = "Lanterne";   }
		if ( Parser.InneholderSeparertOrd( "bedding set", ImageMetaHead ) > -1) {  Subject = "Sengesett";   }
		if ( Parser.InneholderSeparertOrd( "storage bag", ImageMetaHead ) > -1) {  Subject = "Lagringsbagg";   }
		if ( Parser.InneholderSeparertOrd( "hammock", ImageMetaHead ) > -1) {  Subject = "Hengek&oslashye";   }
		if ( Parser.InneholderSeparertOrd( "thermometer", ImageMetaHead ) > -1) {  Subject = "Termometer";   }
		if ( Parser.InneholderSeparertOrd( "dog bed", ImageMetaHead ) > -1) {  Subject = "Hundeseng";   }
		if ( Parser.InneholderSeparertOrd( "repeller", ImageMetaHead ) > -1) {  Subject = "Frast&oslashter";   }
		if ( Parser.InneholderSeparertOrd( "chair cover", ImageMetaHead ) > -1) {  Subject = "Stoltrekk";   }
		if ( Parser.InneholderSeparertOrd( "fishing hook", ImageMetaHead ) > -1) {  Subject = "Fiskekroker";   }
		if ( Parser.InneholderSeparertOrd( "folding knife", ImageMetaHead ) > -1) {  Subject = "Lommekniv";   }
		if ( Parser.InneholderSeparertOrd( "golf club", ImageMetaHead ) > -1) {  Subject = "Golfk&oslashlle";   }
		if ( Parser.InneholderSeparertOrd( "trail camera", ImageMetaHead ) > -1) {  Subject = "Jaktkamera";   }
		if ( Parser.InneholderSeparertOrd( "pillow case", ImageMetaHead ) > -1) {  Subject = "Putetrekk";   }
		if ( Parser.InneholderSeparertOrd( "flash light", ImageMetaHead ) > -1) {  Subject = "Lommelykt";   }
		if ( Parser.InneholderSeparertOrd( "silencer", ImageMetaHead ) > -1) {  Subject = "Lyddemper";   }
		if ( Parser.InneholderSeparertOrd( "rc helicopter", ImageMetaHead ) > -1) {  Subject = "Fjernstyrt Helikopter";   }
		if ( Parser.InneholderSeparertOrd( "neck warmer", ImageMetaHead ) > -1) {  Subject = "Nakkevarmer";   }
		if ( Parser.InneholderSeparertOrd( "audio bug", ImageMetaHead ) > -1) {  Subject = "Bug(Lydopptaker)";   }
		//if ( Parser.InneholderSeparertOrd( "balloon", ImageMetaHead ) > -1) {  Subject = "Ballong";   } for ukonkret
		if ( Parser.InneholderSeparertOrd( "spy camera", ImageMetaHead ) > -1) {  Subject = "Spionkamera";   }
		if ( Parser.InneholderSeparertOrd( "pocket knife", ImageMetaHead ) > -1) {  Subject = "Lommekniv";   }
		if ( Parser.InneholderSeparertOrd( "dog goggles", ImageMetaHead ) > -1) {  Subject = "Hundebriller";   }
		if ( Parser.InneholderSeparertOrd( "spot light", ImageMetaHead ) > -1) {  Subject = "Spot Light";   }
		if ( Parser.InneholderSeparertOrd( "fishing lure", ImageMetaHead ) > -1) {  Subject = "Fiskeagn";   }
		if ( Parser.InneholderSeparertOrd( "bicycle computer", ImageMetaHead ) > -1) {  Subject = "Sykkelcomputer";   }
		if ( Parser.InneholderSeparertOrd( "evening dress", ImageMetaHead ) > -1) {  Subject = "Selskapskjole";   }
		if ( Parser.InneholderSeparertOrd( "detector", ImageMetaHead ) > -1) {  Subject = "Detektor";   }
		if ( Parser.InneholderSeparertOrd( "toothbrush holder", ImageMetaHead ) > -1) {  Subject = "Tannb&oslashrsteholder";   }
		if ( Parser.InneholderSeparertOrd( "led string", ImageMetaHead ) > -1) {  Subject = "LED Lysslynge";   }
		if ( Parser.InneholderSeparertOrd( "laser pointer", ImageMetaHead ) > -1) {  Subject = "Laserpeker";   }
		if ( Parser.InneholderSeparertOrd( "led collar", ImageMetaHead ) > -1) {  Subject = "LED Halsb&aringnd";   }
		if ( Parser.InneholderSeparertOrd( "books", ImageMetaHead ) > -1) {  Subject = "Bok";   }
		if ( Parser.InneholderSeparertOrd( "leggings", ImageMetaHead ) > -1) {  Subject = "Leggings";   }
		if ( URL.indexOf( "1on1" ) > -1 ) {
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
		}
		if ( Parser.InneholderSeparertOrd( "wallet", ImageMetaHead ) > -1) {  Subject = "Lommebok";   }
		if ( Parser.InneholderSeparertOrd( "coin purse", ImageMetaHead ) > -1) {  Subject = "Pengepung";   }
		if ( Parser.InneholderSeparertOrd( "wig", ImageMetaHead ) > -1) {  Subject = "Parykk";   }

		//Category
		if ( Parser.InneholderSeparertOrd( "pumps", Category ) > -1) {  Subject = "Sko, Pumps";  }
		if ( Parser.InneholderSeparertOrd( "flats", Category ) > -1) {  Subject = "Sko, Flats";  }
		if ( Parser.InneholderSeparertOrd( "rhinestone", Category ) > -1) { Subject = "Rhinestones"; }
		if ( Parser.InneholderSeparertOrd( "jewelry set", Category ) > -1) {  Subject = "Smykkesett";   }
		if ( Parser.InneholderSeparertOrd( "ring", Category ) > -1) {  Subject = "Ring";   }
		if ( Parser.InneholderSeparertOrd( "mice", Category ) > -1) {  Subject = "Datamus";   }
		//if ( Parser.InneholderSeparertOrd( "cover", Category ) > -1) {  Subject = "Deksel";   } //proccet feil
		//if ( Parser.InneholderSeparertOrd( "adapter", Category ) > -1) {  Subject = "Adapter";   }for ukonkret
		//if ( Parser.InneholderSeparertOrd( "batteries", Category ) > -1) {  Subject = "Batteri";   }for ukonkret
		if ( Parser.InneholderSeparertOrd( "flash drives", Category ) > -1) {  Subject = "Minnepinne";   }
		if ( Parser.InneholderSeparertOrd( "brooches", Category ) > -1) {  Subject = "Brosje";   }
		if ( Parser.InneholderSeparertOrd( "data cables", Category ) > -1) {  Subject = "Datakabel";   }
		if ( Parser.InneholderSeparertOrd( "earrings", Category ) > -1) {  Subject = "&oslashredobber";   }
		if ( Parser.InneholderSeparertOrd( "boots", Category ) > -1) {  Subject = "Boots";   }
		if ( Parser.InneholderSeparertOrd( "charms", Category ) > -1) {  Subject = "Anheng";   }
		if ( Parser.InneholderSeparertOrd( "bracelet", Category ) > -1) { Subject = "Armb&aringnd";  }
		if ( Parser.InneholderSeparertOrd( "cord", Category ) > -1) { Subject = "Tr&aringd";  }
		if ( Parser.InneholderSeparertOrd( "beads", Category ) > -1) { Subject = "Perler";  }
		if ( Parser.InneholderSeparertOrd( "sunglasses", Category ) > -1) { Subject = "Solbriller";  }
		if ( Parser.InneholderSeparertOrd( "wristwatches", Category ) > -1) { Subject = "Armb&aringndsur";  }
		if ( Parser.InneholderSeparertOrd( "alarm clock", Category ) > -1) { Subject = "Vekkerklokke";  }
		if ( Parser.InneholderSeparertOrd( "pendant", Category ) > -1) { Subject = "Anheng";  }
		if ( Parser.InneholderSeparertOrd( "packaging bag", Category ) > -1) { Subject = "Innpakning";  }
		if ( Parser.InneholderSeparertOrd( "boxer", Category ) > -1) { Subject = "Boxer";  }
		if ( Parser.InneholderSeparertOrd( "belt", Category ) > -1) { Subject = "Belte";  }
		if ( Parser.InneholderSeparertOrd( "scarves", Category ) > -1) { Subject = "Skjerf";  }
		if ( Parser.InneholderSeparertOrd( "tank top", Category ) > -1) {  Subject = "Topp";   }
		if ( Parser.InneholderSeparertOrd( "nail gel", Category ) > -1) {  Subject = "Acrylic Liquid";   }
		if ( Parser.InneholderSeparertOrd( "bra", Category ) > -1) { Subject = "BH";  }
		if ( Parser.InneholderSeparertOrd( "eye shadow", Category ) > -1) {  Subject = "&oslashyenskygge";   }
		if ( Parser.InneholderSeparertOrd( "eyelashes", Category ) > -1) {  Subject = "&oslashyevipper";   }
		if ( Parser.InneholderSeparertOrd( "memory card", Category ) > -1) {  Subject = "Minnekort";   }
		if ( Parser.InneholderSeparertOrd( "laptop skins", Category ) > -1) {  Subject = "Laptopdeksel";   }
		if ( Parser.InneholderSeparertOrd( "usb hub", Category ) > -1) {  Subject = "USB hub";   }
		if ( Parser.InneholderSeparertOrd( "jewelryset", Category ) > -1) {  Subject = "Smykkesett";   }
		if ( Parser.InneholderSeparertOrd( "printing paper", Category ) > -1) {  Subject = "Printerpapir";   }
		if ( Parser.InneholderSeparertOrd( "crepe paper", Category ) > -1) {  Subject = "Krepp papir";   }
		if ( Parser.InneholderSeparertOrd( "paper", Category ) > -1) {  Subject = "Papir";   }
		if ( Parser.InneholderSeparertOrd( "hdd enclosure", Category ) > -1) {  Subject = "HDD Deksel";   }
		//if ( Parser.InneholderSeparertOrd( "phone bags", Category ) > -1) {  Subject = "Deksel";   }
		//if ( Parser.InneholderSeparertOrd( "case & skins", Category ) > -1) {  Subject = "Deksel";   }
		if ( Parser.InneholderSeparertOrd( "gadgets", Category ) > -1) {  Subject = "Gadget";   }
		if ( Parser.InneholderSeparertOrd( "laptop bags & cases", Category ) > -1) {  Subject = "Laptopdeksel";   }
		if ( Parser.InneholderSeparertOrd( "tablet pc", Category ) > -1) {  Subject = "Tablet-PC";   }
		if ( Parser.InneholderSeparertOrd( "tattoo needle", Category ) > -1) {  Subject = "Tatoveringsn&aringler";   }
		if ( Parser.InneholderSeparertOrd( "led bulb", Category ) > -1) {  Subject = "LEDp&aeligrer";   }
		if ( Parser.InneholderSeparertOrd( "tuner", Category ) > -1) {  Subject = "Tuner";   }
		if ( Parser.InneholderSeparertOrd( "games for nds", Category ) > -1) {  Subject = "NDS Spill";   }
		if ( Parser.InneholderSeparertOrd( "electric guitars", Category ) > -1) {  Subject = "Elektrisk Gitar";   }
		if ( Parser.InneholderSeparertOrd( "portable game players", Category ) > -1) {  Subject = "H&aringndholdt Spillkonsoll";   }
		if ( Parser.InneholderSeparertOrd( "games for xbox 360", Category ) > -1) {  Subject = "Xbox 360 Spill";   }
		if ( Parser.InneholderSeparertOrd( "game controller", Category ) > -1) {  Subject = "Spillkontroll";   }
		if ( Parser.InneholderSeparertOrd( "solar panels", Category ) > -1) {  Subject = "Solpanel";   }
		if ( Parser.InneholderSeparertOrd( "electronic cigarette", Category ) > -1) {  Subject = "Elektronisk Sigarett";   }
		if ( Parser.InneholderSeparertOrd( "headset", Category ) > -1) {  Subject = "Headset";   }
		if ( Parser.InneholderSeparertOrd( "nail art sticker", Category ) > -1) {  Subject = "Neglestickers";   }
		if ( Parser.InneholderSeparertOrd( "capo", Category ) > -1) {  Subject = "Capo";   }
		if ( Parser.InneholderSeparertOrd( "ph meter", Category ) > -1) {  Subject = "PH-tester";   }
		if ( Parser.InneholderSeparertOrd( "weighing scale", Category ) > -1) {  Subject = "Kj&oslashkkenvekt";   }
		if ( Parser.InneholderSeparertOrd( "laser lightings", Category ) > -1) {  Subject = "Laserlys";   }
		if ( Parser.InneholderSeparertOrd( "pillow", Category ) > -1) {  Subject = "Pute";   }
		if ( Parser.InneholderSeparertOrd( "dog tag", Category ) > -1) {  Subject = "IDbrikker";   }
		if ( Parser.InneholderSeparertOrd( "bathroom sink faucets", Category ) > -1) {  Subject = "Servant";   }
		if ( Parser.InneholderSeparertOrd( "led lighting", Category ) > -1) {  Subject = "LEDlys";   }
		if ( Parser.InneholderSeparertOrd( "fridge magnets", Category ) > -1) {  Subject = "Kj&oslashleskapsmagneter";   }
		if ( Parser.InneholderSeparertOrd( "polisher", Category ) > -1) {  Subject = "Slipemaskin";   }
		if ( Parser.InneholderSeparertOrd( "wall stickers", Category ) > -1) {  Subject = "Wall Stickers";   }
		if ( Parser.InneholderSeparertOrd( "alarm system", Category ) > -1) {  Subject = "Alarm";   }
		if ( Parser.InneholderSeparertOrd( "party mask", Category ) > -1) {  Subject = "Karnevalsmaske";   }
		if ( Parser.InneholderSeparertOrd( "drinking straws", Category ) > -1) {  Subject = "Suger&oslashr";   }
		if ( Parser.InneholderSeparertOrd( "umbrella", Category ) > -1) {  Subject = "Paraply";   }
		if ( Parser.InneholderSeparertOrd( "napkin ring", Category ) > -1) {  Subject = "Serviettring";   }
		if ( Parser.InneholderSeparertOrd( "chainsaws", Category ) > -1) {  Subject = "Motorsager";   }
		if ( Parser.InneholderSeparertOrd( "handles & pulls", Category ) > -1) {  Subject = "D&oslashrh&aringndtak";   }
		if ( Parser.InneholderSeparertOrd( "vase", Category ) > -1) {  Subject = "Vase";   }
		if ( Parser.InneholderSeparertOrd( "shelves", Category ) > -1) {  Subject = "Hylle";   }
		if ( Parser.InneholderSeparertOrd( "wall clock", Category ) > -1) {  Subject = "Veggklokke";   }
		if ( Parser.InneholderSeparertOrd( "prom dress", Category ) > -1) {  Subject = "Ballkjole";   }
		if ( Parser.InneholderSeparertOrd( "wedding dress", Category ) > -1) {  Subject = "Brudekjole";   }
		if ( Parser.InneholderSeparertOrd( "baking mould", Category ) > -1) {  Subject = "Bakeform";   }
		if ( Parser.InneholderSeparertOrd( "handlebar", Category ) > -1) {  Subject = "H&aringndtaksstang";   }
		if ( Parser.InneholderSeparertOrd( "toys", Category ) > -1) {  Subject = "Leke";   }
		if ( Parser.InneholderSeparertOrd( "stuffed & plus animals", Category ) > -1) {  Subject = "Bamse";   }
		//if ( Parser.InneholderSeparertOrd( "radio control vehicles", Category ) > -1) {  Subject = "Fjernstyrt Kj&oslashret&oslashy";   }
		if ( Parser.InneholderSeparertOrd( "camera", Category ) > -1) {  Subject = "Kamera";   }
		if ( Parser.InneholderSeparertOrd( "baby toy", Category ) > -1) {  Subject = "Babyleke";   }
		if ( Parser.InneholderSeparertOrd( "spy clock camera", Category ) > -1) {  Subject = "Spionkamera";   }
		if ( Parser.InneholderSeparertOrd( "mother of the bride dresses", Category ) > -1) {  Subject = "Brudemorskjole";   }
		if ( Parser.InneholderSeparertOrd( "baking tools", Category ) > -1) {  Subject = "Bakeutstyr";   }
		if ( Parser.InneholderSeparertOrd( "spy camera detector", Category ) > -1) {  Subject = "Anti Spion-utstyr";   }
		if ( Parser.InneholderSeparertOrd( "solar energy toy", Category ) > -1) {  Subject = "Soldrevet Leke";   }
		if ( Parser.InneholderSeparertOrd( "spy pen", Category ) > -1) {  Subject = "Spionpenn";   }
		if ( Parser.InneholderSeparertOrd( "electronic fence", Category ) > -1) {  Subject = "Elektronisk Gjerde";   }
		if ( Parser.InneholderSeparertOrd( "shoulder bags", Category ) > -1) {  Subject = "Skulderveske";   }
		if ( Parser.InneholderSeparertOrd( "high heel", Category ) > -1) {  Subject = "H&oslashyh&aeliglte Sko";   }
		if ( Parser.InneholderSeparertOrd( "running shoes", Category ) > -1) {  Subject = "Joggesko";   }
		if ( Parser.InneholderSeparertOrd( "pointed toe pumps", Category ) > -1) {  Subject = "Selskapssko";   }
		if ( Parser.InneholderSeparertOrd( "evening bags", Category ) > -1) {  Subject = "Selskapsveske";   }
		if ( Parser.InneholderSeparertOrd( "power supply", Category ) > -1) {  Subject = "Str&oslashmforsyning";   }
		if ( Parser.InneholderSeparertOrd( "baseball caps", Category ) > -1) {  Subject = "Caps";   }
		if ( Parser.InneholderSeparertOrd( "bikinis set", Category ) > -1) {  Subject = "Bikini";   }
		if ( Parser.InneholderSeparertOrd( "laptop adapter", Category ) > -1) {  Subject = "Laptopadapter";   }
		if ( Parser.InneholderSeparertOrd( "laptop batteries", Category ) > -1) {  Subject = "Laptopbatteri";   }
		if ( Parser.InneholderSeparertOrd( "t-shirts", Category ) > -1) {  Subject = "T-shirt";   }
		if ( Parser.InneholderSeparertOrd( "laptop bags &amp; cases", Category ) > -1) {  Subject = "Laptopveske";   }
		if ( Parser.InneholderSeparertOrd( "laptop cooling pads", Category ) > -1) {  Subject = "Laptopkj&oslashling";   }
		if ( Parser.InneholderSeparertOrd( "sandals", Category ) > -1) {  Subject = "Sandaler";   }
		if ( Parser.InneholderSeparertOrd( "anklets", Category ) > -1) {  Subject = "Anklet";   }
		if ( Parser.InneholderSeparertOrd( "cases &amp; displays", Category ) > -1) {  Subject = "Produktdisplay";   }
		//if ( Parser.InneholderSeparertOrd( "wire", Category ) > -1) {  Subject = "Vaier";   } for ukonkret
		if ( Parser.InneholderSeparertOrd( "totes", Category ) > -1) {  Subject = "Veske";   }
		if ( Parser.InneholderSeparertOrd( "earphones &amp; headphones", Category ) > -1) {  Subject = "&oslashreklokker";   }
		if ( Parser.InneholderSeparertOrd( "nail glitter", Category ) > -1) {  Subject = "Glitter";   }
		if ( Parser.InneholderSeparertOrd( "dildos", Category ) > -1) {  Subject = "Dildo";   }
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
		if ( Parser.InneholderSeparertOrd( "sexy lingerie", Category ) > -1) {  Subject = "Sexy Undert&oslashy";   }
		if ( Parser.InneholderSeparertOrd( "gay", Category ) > -1) {  Subject = "Gay";   }
		if ( Parser.InneholderSeparertOrd( "condoms", Category ) > -1) {  Subject = "Kondomer";   }
		if ( Parser.InneholderSeparertOrd( "aroma", Category ) > -1) {  Subject = "Aroma";   }
		if ( URL.indexOf( "1on1" ) > -1 ) {
			if ( Parser.InneholderSeparertOrd( "anime", Category ) > -1) {  Subject = "Fetisj";   }
			if ( Parser.InneholderSeparertOrd( "double enders", Category ) > -1) {  Subject = "Dobbeldildo";   }
		}
		if ( Parser.InneholderSeparertOrd( "strap ons", Category ) > -1) {  Subject = "Strap-On";   }
		if ( Parser.InneholderSeparertOrd( "finger fun", Category ) > -1) {  Subject = "Fingermoro";   }
		if ( Parser.InneholderSeparertOrd( "costume", Category ) > -1) {  Subject = "Kostyme";   }
		if ( Parser.InneholderSeparertOrd( "earring", Category ) > -1) {  Subject = "&oslashredobber";   }
		if ( Parser.InneholderSeparertOrd( "top & base coat", Category ) > -1) {  Subject = "Neglecoating";   }
		if ( Parser.InneholderSeparertOrd( "slippers", Category ) > -1) {  Subject = "T&oslashfler";   }
		if ( Parser.InneholderSeparertOrd( "mules &amp; clogs", Category ) > -1) {  Subject = "Innesandaler";   }
		if ( Parser.InneholderSeparertOrd( "pumps", Category ) > -1) {  Subject = "Pumps";   }
		if ( Parser.InneholderSeparertOrd( "skateboarding shoes", Category ) > -1) {  Subject = "Skateboardsko";   }
		if ( Parser.InneholderSeparertOrd( "usb gadgets", Category ) > -1) {  Subject = "USB-gadget";   }
		if ( Parser.InneholderSeparertOrd( "cushion", Category ) > -1) {  Subject = "Pute";   }
		if ( Parser.InneholderSeparertOrd( "men&#39;s shoes", Category ) > -1) {  Subject = "Herresko";   }
		if ( Parser.InneholderSeparertOrd( "drawing toys", Category ) > -1) {  Subject = "Tegneleke";   }
		if ( Parser.InneholderSeparertOrd( "pants & capri", Category ) > -1) {  Subject = "Bukse";   }
		if ( Parser.InneholderSeparertOrd( "stuffed animals &amp; plush", Category ) > -1) {  Subject = "Bamse";   }
		if ( Parser.InneholderSeparertOrd( "stuffed & plush animals", Category ) > -1) {  Subject = "Bamse";   }
		if ( Parser.InneholderSeparertOrd( "shoes", Category ) > -1) {  Subject = "Sko";   }
		if ( Parser.InneholderSeparertOrd( "socks", Category ) > -1) {  Subject = "Sokker";   }
		if ( Parser.InneholderSeparertOrd( "blouses & shirts", Category ) > -1) {  Subject = "Bluse";   }
		if ( Parser.InneholderSeparertOrd( "lipstick", Category ) > -1) {  Subject = "Lebestift";   }
		if ( Parser.InneholderSeparertOrd( "lip gloss", Category ) > -1) {  Subject = "Lip Gloss";   }
		if ( Parser.InneholderSeparertOrd( "hoodies & sweatshirts", Category ) > -1) {  Subject = "Hettegenser";   }
		if ( Parser.InneholderSeparertOrd( "action & toy figures", Category ) > -1) {  Subject = "Actionfigur";   }
		if ( Parser.InneholderSeparertOrd( "balloons", Category ) > -1) {  Subject = "Ballong";   }
		if ( Parser.InneholderSeparertOrd( "playdough", Category ) > -1) {  Subject = "Modelleringsmasse";   }
		if ( Parser.InneholderSeparertOrd( "blocks", Category ) > -1) {  Subject = "Byggeklosser";   }
		if ( Parser.InneholderSeparertOrd( "electronic pets", Category ) > -1) {  Subject = "Elektroniske Kj&aeligledyr";   }
		if ( Parser.InneholderSeparertOrd( "gags & practical jokes", Category ) > -1) {  Subject = "Rampeleke";   }
		if ( Parser.InneholderSeparertOrd( "learning machines", Category ) > -1) {  Subject = "L&aeligremaskin";   }
		if ( Parser.InneholderSeparertOrd( "rc motorcycles", Category ) > -1) {  Subject = "Fjernstyrt Motorsykkel";   }
		if ( Parser.InneholderSeparertOrd( "rc cars", Category ) > -1) {  Subject = "Fjernstyrt Bil";   }
		if ( Parser.InneholderSeparertOrd( "rc trains", Category ) > -1) {  Subject = "Fjernstyrt Tog";   }
		if ( Parser.InneholderSeparertOrd( "rc boats", Category ) > -1) {  Subject = "Fjernstyrt B&aringt";   }
		if ( Parser.InneholderSeparertOrd( "puzzles", Category ) > -1) {  Subject = "Puslespill";   }
		if ( Parser.InneholderSeparertOrd( "diecasts & toy vehicles", Category ) > -1) {  Subject = "Lekekj&oslashret&oslashy";   }
		if ( Parser.InneholderSeparertOrd( "light-up toys", Category ) > -1) {  Subject = "Lysende Leke";   }
		if ( Parser.InneholderSeparertOrd( "bath toy", Category ) > -1) {  Subject = "Badeleke";   }
		if ( Parser.InneholderSeparertOrd( "puppets", Category ) > -1) {  Subject = "H&aringnddukke";   }
		if ( Parser.InneholderSeparertOrd( "remote control toys", Category ) > -1) {  Subject = "Fjernstyrt Leke";   }
		if ( Parser.InneholderSeparertOrd( "child toy", Category ) > -1) {  Subject = "Leke";   }
		if ( Parser.InneholderSeparertOrd( "crafts", Category ) > -1) {  Subject = "Hobbyting";   }
		if ( Parser.InneholderSeparertOrd( "phone bags & cases", Category ) > -1) {  Subject = "Mobildeksel";   }
		if ( Parser.InneholderSeparertOrd( "model building kits", Category ) > -1) {  Subject = "Modellfigur";   }
		if ( Parser.InneholderSeparertOrd( "dolls", Category ) > -1) {  Subject = "Dukke";   }

		//komplekse regler
		if ( Subject.equals("Batteri") ) {
			if ( Parser.InneholderSeparertOrd( "laptop accessories", ParentCategory ) > -1) {
				Subject = "Laptopbatteri";
			}
		}
		if ( Subject.equals("Deksel") ) {
			if ( Parser.InneholderSeparertOrd( "wallets &amp; holders", ParentCategory ) > -1) {
				Subject = "Kortetui";
			}
		}
		if ( Subject.equals("Tr&aringd") ) {
			if ( Parser.InneholderSeparertOrd( "jewelry findings", ParentCategory ) > -1) {
				Subject = "Smykketråd";
			}
		}
		if ( Subject.equals("Kj&oslashling") ) {
			if ( Parser.InneholderSeparertOrd( "laptop accessories", ParentCategory ) > -1) {
				Subject = "Laptopkj&oslashling";
			}
		}
		if ( Subject.equals("Sko") ) {
			if ( Parser.InneholderSeparertOrd( "winter", ImageMetaHead ) > -1) {
				Subject = "Vintersko";
			}
		}
		if ( Subject.equals("Sko") ) {
			if ( Parser.InneholderSeparertOrd( "platform", ImageMetaHead ) > -1) {
				Subject = "Platformsko";
			}
		}
		
		if ( Parser.InneholderSeparertOrd( "swimwear", ParentCategory ) > -1) { 
			if ( Parser.InneholderSeparertOrd( "one pieces", Category ) > -1) {  
				Subject = "Badedrakt";
			}
		}
		if ( Parser.InneholderSeparertOrd( "nail art", ParentCategory ) > -1) { 
			if ( Parser.InneholderSeparertOrd( "stickers &amp; decals", Category ) > -1) {  
				Subject = "Minidecals";
			}
		}
		if ( Parser.InneholderSeparertOrd( "Modellfigur", Subject ) > -1) { 
			//System.out.println( this.getClass().toString()+" FindSubjects A Subject="+Subject );
			if ( Parser.InneholderSeparertOrd( "miniature", ImageMetaHead ) > -1) { 
				Subject = "Miniatyrfigur"; 
			}
			
			if ( Parser.InneholderSeparertOrd( "building block", ImageMetaHead ) > -1) {  
				Subject = "Byggeklosser";
			} else if ( Parser.InneholderSeparertOrd( "building bricks", ImageMetaHead ) > -1) {  
				Subject = "Byggeklosser";
			} else if ( Parser.InneholderSeparertOrd( "model kit", ImageMetaHead ) > -1) {  
				Subject = "Modellsett";
			} else if ( Parser.InneholderSeparertOrd( "dollhouse", ImageMetaHead ) > -1) {  
				Subject = "Dukkehus";
			} else if ( Parser.InneholderSeparertOrd( "car", ImageMetaHead ) > -1) {  
				Subject = "Lekebil";
			} else if ( Parser.InneholderSeparertOrd( "puzzle", ImageMetaHead ) > -1) {  
				Subject = "Puslespill";
			} else if ( Parser.InneholderSeparertOrd( "paper model", ImageMetaHead ) > -1) {  
				Subject = "Papirmodell";
			} else if ( Parser.InneholderSeparertOrd( "diy", ImageMetaHead ) > -1) {  
				Subject = "Byggesett";
			} else if ( Parser.InneholderSeparertOrd( "paper", ImageMetaHead ) > -1) {  
				Subject = "Papirmodell";
			} else if ( Parser.InneholderSeparertOrd( "playdough", ImageMetaHead ) > -1) {  
				Subject = "Modelleringsmasse";   
			} else if ( Parser.InneholderSeparertOrd( "play dough", ImageMetaHead ) > -1) {  
				Subject = "Modelleringsmasse";   
			} else if ( Parser.InneholderSeparertOrd( "play doh", ImageMetaHead ) > -1) {  
				Subject = "Modelleringsmasse";   
			} else if ( Parser.InneholderSeparertOrd( "clay", ImageMetaHead ) > -1) {  
				Subject = "Modelleringsmasse";   
			}
			
			if ( Parser.InneholderSeparertOrd( "legoland", ImageMetaHead ) > -1) {  
				Subject = "Legomodell";
			} else if ( Parser.InneholderSeparertOrd( "lego", ImageMetaHead ) > -1) {  
				Subject = "Legomodell";
			} else if ( Parser.InneholderSeparertOrd( "legao", ImageMetaHead ) > -1) {  
				Subject = "Legomodell";
			} else if ( Parser.InneholderSeparertOrd( "sluban", ImageMetaHead ) > -1) {  
				Subject = "Legomodell";
			} else if ( Parser.InneholderSeparertOrd( "luban", ImageMetaHead ) > -1) {  
				Subject = "Legomodell";
			}
			
			Pattern Regex2 = Pattern.compile( "((\\d+)mm)" );
			Matcher m2 = Regex2.matcher( Subject );
			m2 = Regex2.matcher( Subject );
			while ( m2.find() ) {
				if ( Subject.equals( "Miniatyrfigur" ) == false ) {
					Subject = "Miniatyrfigur";
				}
			}
			
			Pattern Regex3 = Pattern.compile( "(1:(\\d+))" );
			Matcher m3 = Regex3.matcher( Subject );
			m3 = Regex3.matcher( Subject );
			while ( m3.find() ) {
				if ( Integer.parseInt( m3.group(2) ) > 10 ) {
					if ( Subject.equals( "Miniatyrfigur" ) == false ) {
						Subject = "Miniatyrfigur";
					}
				}
			}
			
			if ( Parser.InneholderSeparertOrd( "o scale", ImageMetaHead ) > -1) { 
				Subject = "Miniatyrfigur"; 
			}
			if ( Parser.InneholderSeparertOrd( "baby toys", ImageMetaHead ) > -1) { 
				Subject = "Babyleke"; 
			}

		} else {
			//System.out.println( this.getClass().toString()+" FindSubjects B Subject="+Subject );
		}
		if ( Parser.InneholderSeparertOrd( "warhammer", ImageMetaHead ) > -1) {  
			Subject = "Miniatyrfigur";
		}
		
		if ( Subject.equals("") ) {
			//System.out.println( this.getClass().toString()+" FindSubjects Category="+Category+" ParentCategory="+ParentCategory+" URL="+URL );
			//System.out.println( this.getClass().toString()+" FindSubjects Subject="+Subject );
		}
		//System.out.println( this.getClass().toString()+" FindSubjects C Subject="+Subject );
		return Subject;
	}
	public String Define_DynamiskHovedkategori( String ParentCategory, String Subject, String Stikkord, String URL, String Head ) {
		TextHandler Parser = new TextHandler();
		String DynamiskHovedkategori = "Div";
		
		//USIKKERT
		//subjekt
		if ( Parser.InneholderSeparertOrd( "lommebok", Subject ) > -1) {  DynamiskHovedkategori = "Lommeboker"; }
		if ( Parser.InneholderSeparertOrd( "ring", Subject ) > -1) {  DynamiskHovedkategori = "Smykker"; }
		if ( Parser.InneholderSeparertOrd( "anheng", Subject ) > -1) {  DynamiskHovedkategori = "Jewelcrafting"; }
		if ( Parser.InneholderSeparertOrd( "kabel", Subject ) > -1) {  DynamiskHovedkategori = "Kabler"; }
		if ( Parser.InneholderSeparertOrd( "deksel", Subject ) > -1) {  DynamiskHovedkategori = "Mobiltelefon"; }
		if ( Parser.InneholderSeparertOrd( "klokke", Subject ) > -1) {  DynamiskHovedkategori = "Klokker"; }
		if ( Parser.InneholderSeparertOrd( "briller", Subject ) > -1) {  DynamiskHovedkategori = "Briller"; }
		if ( Parser.InneholderSeparertOrd( "perler", Subject ) > -1) {  DynamiskHovedkategori = "Jewelcrafting"; }
		if ( Parser.InneholderSeparertOrd( "undert&oslashy", Subject ) > -1) {  DynamiskHovedkategori = "Undert&oslashy";  }
		if ( Parser.InneholderSeparertOrd( "anheng", Subject ) > -1) {  DynamiskHovedkategori = "Jewelcrafting"; }
		
		//SIKKERT
		//subjekt
		HashMap Sikkert_Subjekt_Hovedkategori = new HashMap();
		Sikkert_Subjekt_Hovedkategori.put( "armb&aringnd", "Smykker");
		Sikkert_Subjekt_Hovedkategori.put( "halskjede", "Smykker");
		Sikkert_Subjekt_Hovedkategori.put( "smykkesett", "Smykker");
		Sikkert_Subjekt_Hovedkategori.put( "&oslashredobber", "Smykker");
		Sikkert_Subjekt_Hovedkategori.put( "ring", "Smykker");
		Sikkert_Subjekt_Hovedkategori.put( "anheng", "Smykker");
		Sikkert_Subjekt_Hovedkategori.put( "bangle", "Smykker");
		Sikkert_Subjekt_Hovedkategori.put( "perler", "Jewelcrafting");
		//Sikkert_Subjekt_Hovedkategori.put( "smykker", "Smykker");
		Sikkert_Subjekt_Hovedkategori.put( "bikini", "Badet&oslashy");
		Sikkert_Subjekt_Hovedkategori.put( "armb&aringndsur", "Klokker");
		Sikkert_Subjekt_Hovedkategori.put( "brosje", "Smykker");
		//Sikkert_Subjekt_Hovedkategori.put( "lys", "Lys");
		//Sikkert_Subjekt_Hovedkategori.put( "klokke", "Klokker");
		Sikkert_Subjekt_Hovedkategori.put( "minnepinne", "PC");
		Sikkert_Subjekt_Hovedkategori.put( "usb hub", "PC");
		//Sikkert_Subjekt_Hovedkategori.put( "lader", "PC");
		//Sikkert_Subjekt_Hovedkategori.put( "adapter", "PC");
		Sikkert_Subjekt_Hovedkategori.put( "datamus", "PC");
		//Sikkert_Subjekt_Hovedkategori.put( "badet&oslashy", "Badet&oslashy");
		Sikkert_Subjekt_Hovedkategori.put( "bagg", "Lugasje");
		//Sikkert_Subjekt_Hovedkategori.put( "kabel", "PC");
		Sikkert_Subjekt_Hovedkategori.put( "sko", "Sko");
		//Sikkert_Subjekt_Hovedkategori.put( "telefon", "Telefoner");
		Sikkert_Subjekt_Hovedkategori.put( "boots", "Sko");
		Sikkert_Subjekt_Hovedkategori.put( "sandaler", "Sko");
		Sikkert_Subjekt_Hovedkategori.put( "belte", "Kl&aeligr");
		Sikkert_Subjekt_Hovedkategori.put( "veske", "Vesker");
		Sikkert_Subjekt_Hovedkategori.put( "rhinestones", "Do It Yourself");
		Sikkert_Subjekt_Hovedkategori.put( "bukse", "Kl&aeligr");
		Sikkert_Subjekt_Hovedkategori.put( "lommebok", "Lugasje");
		//Sikkert_Subjekt_Hovedkategori.put( "sminke", "Sminke");
		Sikkert_Subjekt_Hovedkategori.put( "hdd Deksel", "PC");
		//Sikkert_Subjekt_Hovedkategori.put( "undert&oslashy", "Undert&oslashy");
		Sikkert_Subjekt_Hovedkategori.put( "bh", "Undert&oslashy");
		Sikkert_Subjekt_Hovedkategori.put( "hanske", "Kl&aeligr");
		Sikkert_Subjekt_Hovedkategori.put( "&oslashyenskygge", "Sminke");
		Sikkert_Subjekt_Hovedkategori.put( "acrylic liquid", "Negledesign");
		Sikkert_Subjekt_Hovedkategori.put( "bok", "Lesestoff");
		Sikkert_Subjekt_Hovedkategori.put( "boots", "Sko");
		Sikkert_Subjekt_Hovedkategori.put( "klistremerke", "Do It Yourself");
		Sikkert_Subjekt_Hovedkategori.put( "fotoramme", "Hjemmet");
		Sikkert_Subjekt_Hovedkategori.put( "solbriller", "Briller");
		Sikkert_Subjekt_Hovedkategori.put( "gadget", "Gadgets");
		Sikkert_Subjekt_Hovedkategori.put( "kjole", "Kjoler");
		Sikkert_Subjekt_Hovedkategori.put( "bikini", "Badet&oslashy");
		Sikkert_Subjekt_Hovedkategori.put( "&oslashyevipper", "Sminke");
		Sikkert_Subjekt_Hovedkategori.put( "forlovelsesringer", "Smykker");
		Sikkert_Subjekt_Hovedkategori.put( "headset", "PC");
		//Sikkert_Subjekt_Hovedkategori.put( "kabel", "PC");
		//Sikkert_Subjekt_Hovedkategori.put( "adapter", "Elektronikk");
		Sikkert_Subjekt_Hovedkategori.put( "skj&oslashrt", "Kl&aeligr");
		Sikkert_Subjekt_Hovedkategori.put( "skjerf", "Kl&aeligr");
		Sikkert_Subjekt_Hovedkategori.put( "smykkesett", "Smykker");
		Sikkert_Subjekt_Hovedkategori.put( "sneakers", "Sko");
		Sikkert_Subjekt_Hovedkategori.put( "joggesko", "Sko");
		Sikkert_Subjekt_Hovedkategori.put( "h&oslashyh&aeliglte sko", "Sko");
		Sikkert_Subjekt_Hovedkategori.put( "selskapssko", "Sko");
		Sikkert_Subjekt_Hovedkategori.put( "skulderveske", "Vesker");
		Sikkert_Subjekt_Hovedkategori.put( "laptopbatteri", "PC");
		Sikkert_Subjekt_Hovedkategori.put( "kortetui", "Lugasje");
		Sikkert_Subjekt_Hovedkategori.put( "selskapsveske", "Lugasje");
		Sikkert_Subjekt_Hovedkategori.put( "anklet", "Smykker");
		Sikkert_Subjekt_Hovedkategori.put( "tastatur", "PC");
		Sikkert_Subjekt_Hovedkategori.put( "laptopkj&oslashling", "PC");
		Sikkert_Subjekt_Hovedkategori.put( "minnekort", "PC");
		Sikkert_Subjekt_Hovedkategori.put( "hdd deksel", "PC");
		Sikkert_Subjekt_Hovedkategori.put( "sko, pumps", "Sko");
		Sikkert_Subjekt_Hovedkategori.put( "sko, flats", "Sko");
		Sikkert_Subjekt_Hovedkategori.put( "tiara", "H&aringrpynt");
		Sikkert_Subjekt_Hovedkategori.put( "h&aringrb&aringnd", "H&aringrpynt");
		Sikkert_Subjekt_Hovedkategori.put( "hatt", "Hodeplagg");
		Sikkert_Subjekt_Hovedkategori.put( "caps", "Hodeplagg");
		Sikkert_Subjekt_Hovedkategori.put( "laptopadapter", "PC");
		Sikkert_Subjekt_Hovedkategori.put( "piercing", "Smykker");
		Sikkert_Subjekt_Hovedkategori.put( "hengek&oslashye", "Hage");
		Sikkert_Subjekt_Hovedkategori.put( "h&aringrklype", "H&aringrpynt");
		Sikkert_Subjekt_Hovedkategori.put( "t-shirt", "Kl&aeligr");
		Sikkert_Subjekt_Hovedkategori.put( "laptopveske", "PC");
		Sikkert_Subjekt_Hovedkategori.put( "topp", "Kl&aeligr");
		Sikkert_Subjekt_Hovedkategori.put( "h&oslashytaler", "PC");
		Sikkert_Subjekt_Hovedkategori.put( "h&aringndveske", "Vesker");
		Sikkert_Subjekt_Hovedkategori.put( "boxer", "Undert&oslashy");
		Sikkert_Subjekt_Hovedkategori.put( "h&aringrkam", "H&aringrpynt");
		Sikkert_Subjekt_Hovedkategori.put( "leggings", "Kl&aeligr");
		Sikkert_Subjekt_Hovedkategori.put( "&oslashreklokker", "Lydutstyr");
		Sikkert_Subjekt_Hovedkategori.put( "makeupb&oslashrster", "Sminke");
		Sikkert_Subjekt_Hovedkategori.put( "penselsett", "Do It Yourself");
		Sikkert_Subjekt_Hovedkategori.put( "mascara", "Sminke");
		Sikkert_Subjekt_Hovedkategori.put("vibrator", "Sexleker");
		Sikkert_Subjekt_Hovedkategori.put("analkuler", "Sexleker");
		Sikkert_Subjekt_Hovedkategori.put("analplugg", "Sexleker");
		Sikkert_Subjekt_Hovedkategori.put("analdildo", "Sexleker");
		Sikkert_Subjekt_Hovedkategori.put("analkrem", "Sexleker");
		Sikkert_Subjekt_Hovedkategori.put("anale leker", "Sexleker");
		Sikkert_Subjekt_Hovedkategori.put("g-punktvibrator", "Sexleker");
		Sikkert_Subjekt_Hovedkategori.put("vibratorsett", "Sexleker");
		Sikkert_Subjekt_Hovedkategori.put("glidemiddel", "Sexleker");
		Sikkert_Subjekt_Hovedkategori.put("moro for utdrikningslag", "Sexleker");
		if ( URL.indexOf( "1on1" ) > -1 ) {
			Sikkert_Subjekt_Hovedkategori.put("krem\\spray", "Sexleker");
			Sikkert_Subjekt_Hovedkategori.put("spill", "Sexleker");
			Sikkert_Subjekt_Hovedkategori.put("pisk", "Sexleker");
			Sikkert_Subjekt_Hovedkategori.put("bok", "Sexleker");
			Sikkert_Subjekt_Hovedkategori.put("massageutstyr", "Sexleker");
			Sikkert_Subjekt_Hovedkategori.put("kule", "Sexleker");
			Sikkert_Subjekt_Hovedkategori.put("egg", "Sexleker");
			Sikkert_Subjekt_Hovedkategori.put("flytende sjokolade", "Sexleker");
		}
		Sikkert_Subjekt_Hovedkategori.put("klitorisstimulator", "Sexleker");
		Sikkert_Subjekt_Hovedkategori.put("masturbator", "Sexleker");
		Sikkert_Subjekt_Hovedkategori.put("dildo", "Sexleker");
		Sikkert_Subjekt_Hovedkategori.put("bondageleker", "Sexleker");
		Sikkert_Subjekt_Hovedkategori.put("leker for kvinner", "Sexleker");
		Sikkert_Subjekt_Hovedkategori.put("afrodisiak", "Sexleker");
		Sikkert_Subjekt_Hovedkategori.put("sexy undert&oslashy", "Sexleker");
		Sikkert_Subjekt_Hovedkategori.put("penisringer", "Sexleker");
		Sikkert_Subjekt_Hovedkategori.put("penispumpe", "Sexleker");
		Sikkert_Subjekt_Hovedkategori.put("gay", "Sexleker");
		Sikkert_Subjekt_Hovedkategori.put("kondomer", "Sexleker");
		Sikkert_Subjekt_Hovedkategori.put("t&oslashfler", "Sko");
		Sikkert_Subjekt_Hovedkategori.put("innesandaler", "Sko");
		Sikkert_Subjekt_Hovedkategori.put("pumps", "Sko");
		Sikkert_Subjekt_Hovedkategori.put("vintersko", "Sko");
		Sikkert_Subjekt_Hovedkategori.put("platformsko", "Sko");
		Sikkert_Subjekt_Hovedkategori.put("leke", "Leker");
		Sikkert_Subjekt_Hovedkategori.put("modellfigur", "Modellfigurer");
		Sikkert_Subjekt_Hovedkategori.put("miniatyrfigur", "Modellfigurer");
		Sikkert_Subjekt_Hovedkategori.put("babyleke", "Leker");
		Sikkert_Subjekt_Hovedkategori.put("bamse", "Leker");
		Sikkert_Subjekt_Hovedkategori.put("h&aringnddukke", "Leker");
		Sikkert_Subjekt_Hovedkategori.put("actionfigur", "Leker");
		Sikkert_Subjekt_Hovedkategori.put("puslespill", "Leker");
		Sikkert_Subjekt_Hovedkategori.put("modelleringsmasse", "Leker");
		Sikkert_Subjekt_Hovedkategori.put("k&aringpe", "Kl&aeligr");
		Sikkert_Subjekt_Hovedkategori.put("l&aeligremaskin", "Leker");
		Sikkert_Subjekt_Hovedkategori.put("badeleke", "Leker");
		Sikkert_Subjekt_Hovedkategori.put("fjernstyrt helikopter", "Leker");
		Sikkert_Subjekt_Hovedkategori.put("fjernstyrt tog", "Leker");
		Sikkert_Subjekt_Hovedkategori.put("fjernstyrt leke", "Leker");
		Sikkert_Subjekt_Hovedkategori.put("fjernstyrt bil", "Leker");
		Sikkert_Subjekt_Hovedkategori.put("fjernstyrt motorsykkel", "Leker");
		Sikkert_Subjekt_Hovedkategori.put("fjernstyrt b&aringt", "Leker");
		Sikkert_Subjekt_Hovedkategori.put("rampeleke", "Leker");
		Sikkert_Subjekt_Hovedkategori.put("dukke", "Leker");
		Sikkert_Subjekt_Hovedkategori.put("lekekj&oslashret&oslashy", "Leker");
		Sikkert_Subjekt_Hovedkategori.put("hettegenser", "Kl&aeligr");
		Sikkert_Subjekt_Hovedkategori.put("byggeklosser", "Leker");
		Sikkert_Subjekt_Hovedkategori.put("lys", "Belysning");
		Sikkert_Subjekt_Hovedkategori.put("tegneleke", "Leker");
		Sikkert_Subjekt_Hovedkategori.put("dekorasjon", "Dekorasjon");
		Sikkert_Subjekt_Hovedkategori.put("elektroniske kj&aeligledyr", "Leker");
		Sikkert_Subjekt_Hovedkategori.put("modellsett", "Modellfigurer");
		Sikkert_Subjekt_Hovedkategori.put("?", "Diverse");
		Sikkert_Subjekt_Hovedkategori.put("n&oslashkkelring", "Hjemmet");
		Sikkert_Subjekt_Hovedkategori.put("str&oslashmforsyning", "Elektrisk");
		Sikkert_Subjekt_Hovedkategori.put("kj&oslashleskapsmagneter", "Diverse");
		Sikkert_Subjekt_Hovedkategori.put("adapter", "Elektrisk");
		Sikkert_Subjekt_Hovedkategori.put("byggesett", "Leker");
		Sikkert_Subjekt_Hovedkategori.put("papirmodell", "Modellfigurer");
		Sikkert_Subjekt_Hovedkategori.put("lekebil", "Leker");
		Sikkert_Subjekt_Hovedkategori.put("kl&aeligr", "Kl&aeligr");
		Sikkert_Subjekt_Hovedkategori.put("lysende leke", "Leker");
		Sikkert_Subjekt_Hovedkategori.put("n&aringl", "Diverse");
		Sikkert_Subjekt_Hovedkategori.put("karnevalsmaske", "Diverse");
		Sikkert_Subjekt_Hovedkategori.put("helikopter", "Diverse");
		Sikkert_Subjekt_Hovedkategori.put("legomodell", "Leker");
		Sikkert_Subjekt_Hovedkategori.put("tannb&oslashrsteholder", "Diverse");
		Sikkert_Subjekt_Hovedkategori.put("kamera", "Kameraer");
		Sikkert_Subjekt_Hovedkategori.put("paraply", "Hjemmet");
		Sikkert_Subjekt_Hovedkategori.put("fjernstyrer", "Leker");
		Sikkert_Subjekt_Hovedkategori.put("hobbyting", "Hobby");
		Sikkert_Subjekt_Hovedkategori.put("pute", "Hjemmet");
		Sikkert_Subjekt_Hovedkategori.put("pengepung", "Lugasje");
		Sikkert_Subjekt_Hovedkategori.put("sokker", "Kl&aeligr");
		Sikkert_Subjekt_Hovedkategori.put("kostyme", "Kl&aeligr");
		Sikkert_Subjekt_Hovedkategori.put("lim", "Hobby");
		Sikkert_Subjekt_Hovedkategori.put("vekkerklokke", "Hjemmet");
		Sikkert_Subjekt_Hovedkategori.put("termometer", "Hjemmet");
		Sikkert_Subjekt_Hovedkategori.put("sengesett", "Hjemmet");
		Sikkert_Subjekt_Hovedkategori.put("wall stickers", "Hjemmet");
		Sikkert_Subjekt_Hovedkategori.put("yttert&oslashy", "Kl&aeligr");
		Sikkert_Subjekt_Hovedkategori.put("usb-gadget", "PC");
		Sikkert_Subjekt_Hovedkategori.put("fiskekroker", "Hobby");
		Sikkert_Subjekt_Hovedkategori.put("matte", "Hjemmet");
		Sikkert_Subjekt_Hovedkategori.put("lanterne", "Belysning");
		Sikkert_Subjekt_Hovedkategori.put("dukkehus", "Leker");
		Sikkert_Subjekt_Hovedkategori.put("iphone", "Mobiltelefoner");
		Sikkert_Subjekt_Hovedkategori.put("veggklokke", "Klokker");
		Sikkert_Subjekt_Hovedkategori.put("kronblader", "Diverse");
		Sikkert_Subjekt_Hovedkategori.put("alkoholtester", "Diverse");
		Sikkert_Subjekt_Hovedkategori.put("genser", "Kl&aeligr");
		Sikkert_Subjekt_Hovedkategori.put("kabel", "Diverse");
		Sikkert_Subjekt_Hovedkategori.put("tablet-pc", "PC");
		Sikkert_Subjekt_Hovedkategori.put("papir", "Hobby");
		Sikkert_Subjekt_Hovedkategori.put("lysp&aeligre", "Belysning");
		Sikkert_Subjekt_Hovedkategori.put("tekstiler", "Hobby");
		Sikkert_Subjekt_Hovedkategori.put("suger&oslashr", "Diverse");
		Sikkert_Subjekt_Hovedkategori.put("spill", "Hobby");
		Sikkert_Subjekt_Hovedkategori.put("hylle", "Hjemmet");
		Sikkert_Subjekt_Hovedkategori.put("lagringsbagg", "Lugasje");
		Sikkert_Subjekt_Hovedkategori.put("display", "Diverse");
		Sikkert_Subjekt_Hovedkategori.put("toalettveske", "Lugasje");
		Sikkert_Subjekt_Hovedkategori.put("lommelykt", "Belysning");
		Sikkert_Subjekt_Hovedkategori.put("teppe", "Hjemmet");
		Sikkert_Subjekt_Hovedkategori.put("ledlys", "Belysning");
		Sikkert_Subjekt_Hovedkategori.put("&oslashrevarmer", "Kl&aeligr");
		Sikkert_Subjekt_Hovedkategori.put("bluse", "Kl&aeligr");
		Sikkert_Subjekt_Hovedkategori.put("briller", "Briller");
		Sikkert_Subjekt_Hovedkategori.put("votter", "Kl&aeligr");
		Sikkert_Subjekt_Hovedkategori.put("fiskeagn", "Hobby");
		
		if ( Sikkert_Subjekt_Hovedkategori.get( Subject.toLowerCase() ) != null ) {
			DynamiskHovedkategori = (String) Sikkert_Subjekt_Hovedkategori.get( Subject.toLowerCase() );
		}
		//stikkord
		if ( Parser.InneholderSeparertOrd( "negledesign", Stikkord ) > -1) {  DynamiskHovedkategori = "Negledesign"; }
		if ( Parser.InneholderSeparertOrd( "laptop", Stikkord ) > -1) {  DynamiskHovedkategori = "PC"; }
		
		//sære regler
		if ( Parser.InneholderSeparertOrd( "telefon", Subject ) > -1 ) {
			if ( Parser.InneholderSeparertOrd( "deksel", Subject ) > -1) {  
				DynamiskHovedkategori = "Mobiltelefon";
			}
		}
		if ( Parser.InneholderSeparertOrd( "Mobildeksel", Subject ) > -1) {  
			DynamiskHovedkategori = "Mobiltelefon";
		}
		if ( Parser.InneholderSeparertOrd( "barn", Stikkord ) > -1 ) {
			if ( Parser.InneholderSeparertOrd( "figur", Subject ) > -1) {  
				DynamiskHovedkategori = "leker";
			}
		}
		if ( Parser.InneholderSeparertOrd( "puzzle", Stikkord ) > -1) {  
			if ( Parser.InneholderSeparertOrd( "Modellfigur", Subject ) > -1) {  
				DynamiskHovedkategori = "Puslespill";
			}
		}
		
		if ( Parser.InneholderSeparertOrd( "lego", Stikkord ) > -1) {  
			DynamiskHovedkategori = "Leker";
		}
		
		if ( Parser.InneholderSeparertOrd( "yakuchinone", Head ) > -1) {
			DynamiskHovedkategori = "Leker";
		}
		
		if ( Parser.InneholderSeparertOrd( "leker", DynamiskHovedkategori ) > -1) {  
			if ( Parser.InneholderSeparertOrd( "miniature", Stikkord ) > -1) { 
				DynamiskHovedkategori = "Modellfigurer"; 
			}
			Pattern Regex2 = Pattern.compile( "((\\d+)mm)" );
			Matcher m2 = Regex2.matcher( Stikkord );
			m2 = Regex2.matcher( Stikkord );
			while ( m2.find() ) {
				String MatchFunnet = m2.group(1);
				if ( Integer.parseInt( m2.group(2) ) < 150 ) {
					DynamiskHovedkategori = "Modellfigurer";
					Subject = "Miniatyrfigur";
				} else {
					//Subject = "Modellfigur";
				}
			}
			
			Pattern Regex3 = Pattern.compile( "(1:(\\d+))\\D" );
			Matcher m3 = Regex3.matcher( Stikkord );
			m3 = Regex3.matcher( Stikkord );
			while ( m3.find() ) {
				String MatchFunnet = m3.group(1);
				if ( Integer.parseInt( m3.group(2) ) > 10 ) {
					DynamiskHovedkategori = "Modellfigurer";
					Subject = "Miniatyrfigur";
				} else {
					//Subject = "Modellfigur";
				}
			}
			Pattern Regex33 = Pattern.compile( "(1/(\\d+))\\D" );
			Matcher m33 = Regex33.matcher( Stikkord );
			m33 = Regex33.matcher( Stikkord );
			while ( m33.find() ) {
				String MatchFunnet = m33.group(1);
				if ( Integer.parseInt( m33.group(2) ) > 10 ) {
					DynamiskHovedkategori = "Modellfigurer";
					Subject = "Miniatyrfigur";
				} else {
					//Subject = "Modellfigur";
				}
			}
			
			Pattern Regex32 = Pattern.compile( "(1\\\\(\\d+))\\D" );
			Matcher m32 = Regex32.matcher( Stikkord );
			m32 = Regex32.matcher( Stikkord );
			while ( m32.find() ) {
				String MatchFunnet = m32.group(1);
				if ( Integer.parseInt( m32.group(2) ) > 10 ) {
					DynamiskHovedkategori = "Modellfigurer";
					Subject = "Miniatyrfigur";
				} else {
					//Subject = "Modellfigur";
				}
			}
		}
		
		if ( ( Parser.InneholderSeparertOrd( "Modellfigur", Subject ) > -1 )
				) {
			//brukergruppe som kvalifisering
			if ( Parser.InneholderSeparertOrd( "barn", Stikkord ) > -1) {  
				DynamiskHovedkategori = "Leker";
			} else if ( Parser.InneholderSeparertOrd( "gutt", Stikkord ) > -1) {  
				DynamiskHovedkategori = "Leker";
			} else if ( Parser.InneholderSeparertOrd( "jente", Stikkord ) > -1) {  
				DynamiskHovedkategori = "Leker";
			} else if ( Parser.InneholderSeparertOrd( "baby", Stikkord ) > -1) {  
				DynamiskHovedkategori = "Leker";
			} else {
				//System.out.println( this.getClass().toString()+" DynamiskSubkategori Stikkord="+Stikkord );
			}

			//materialer som kvalifisering
			if ( Parser.InneholderSeparertOrd( "treverk", Head ) > -1) {  
				DynamiskHovedkategori = "Leker";
			}
			
			//egenskaper som kvalifisering
			if ( Parser.InneholderSeparertOrd( "mini", Stikkord ) > -1) {  
				DynamiskHovedkategori = "Leker";
			}
			
		}
		
		ItemStats_Tema TemaDatabase = new ItemStats_Tema();
		Object_ItemStats_Tema[] TemaListe = new Object_ItemStats_Tema[ TemaDatabase.HentListe_Objekter().length ];
		TemaListe = TemaDatabase.HentListe_Objekter();
		for ( int X = 0 ; X <  TemaListe.length ; X++ ) {
			if ( TemaListe[X] != null ) {
				if ( TemaListe[X].Egennavn_Norsk != null ) {
					if ( Parser.InneholderSeparertOrd( TemaListe[X].Egennavn_Norsk, Stikkord ) > -1) {
						if ( TemaListe[X].Hovedkategori != null ) {
							DynamiskHovedkategori = TemaListe[X].Hovedkategori;
						}
					}
				} else {
					if ( TemaListe[X].Egennavn_Engelsk != null ) {
						if ( Parser.InneholderSeparertOrd( TemaListe[X].Egennavn_Engelsk, Head ) > -1) {
							if ( TemaListe[X].Hovedkategori != null ) {
								DynamiskHovedkategori = TemaListe[X].Hovedkategori;
							}
						}
					}
				}
				if ( TemaListe[X].Egennavn_Norsk != null ) {
					if ( Parser.InneholderSeparertOrd( TemaListe[X].Egennavn_Norsk, Subject ) > -1) {
						if ( TemaListe[X].Hovedkategori != null ) {
							DynamiskHovedkategori = TemaListe[X].Hovedkategori;
						}
					}
				}
			}
		}
		
		if ( DynamiskHovedkategori == null ) {
			DynamiskHovedkategori = "Div";
		}
		
		if ( ( DynamiskHovedkategori.equals("Div") ) && ( Subject.equals("") == false ) ) {
			System.out.println( this.getClass().toString()+" Define_DynamiskHovedkategori ParentCategory="+ParentCategory+" Subject="+Subject+" Stikkord="+Stikkord );
			System.out.println( this.getClass().toString()+" Define_DynamiskHovedkategori DynamiskHovedkategori="+DynamiskHovedkategori+" hashmap="+Sikkert_Subjekt_Hovedkategori.get( Subject.toLowerCase() ) );
		}
		return DynamiskHovedkategori;
	}
	
	public String Define_DynamiskSubkategori( String Category, String Subject, String Stikkord, String Head, String URL, String Materialer ) {
		TextHandler Parser = new TextHandler();
		String DynamiskSubkategori = "Div";
		
		//USIKKERT
		//subjekt
		if ( Parser.InneholderSeparertOrd( "3d-briller", Subject ) > -1) {  DynamiskSubkategori = "3D-Briller"; }
		if ( Parser.InneholderSeparertOrd( "perler", Subject ) > -1) {  DynamiskSubkategori = "Perler"; }
		if ( Parser.InneholderSeparertOrd( "anheng", Subject ) > -1) {  DynamiskSubkategori = "Anheng"; }
		
		//stikkord
		if ( Parser.InneholderSeparertOrd( "1gb", Stikkord ) > -1) { DynamiskSubkategori = "1gb"; }
		if ( Parser.InneholderSeparertOrd( "4gb", Stikkord ) > -1) { DynamiskSubkategori = "4gb"; }
		if ( Parser.InneholderSeparertOrd( "8gb", Stikkord ) > -1) { DynamiskSubkategori = "8gb"; }
		if ( Parser.InneholderSeparertOrd( "16gb", Stikkord ) > -1) { DynamiskSubkategori = "16gb"; }
		if ( Parser.InneholderSeparertOrd( "32gb", Stikkord ) > -1) { DynamiskSubkategori = "32gb"; }
		if ( Parser.InneholderSeparertOrd( "64gb", Stikkord ) > -1) { DynamiskSubkategori = "64gb"; }
		
		//SIKKERT

		// SUBJECT
		HashMap Sikkert_Subjekt_Kategori = new HashMap();
		Sikkert_Subjekt_Kategori.put( "armb&aringnd", "Armb&aringnd");
		Sikkert_Subjekt_Kategori.put( "halskjede", "Halskjeder");
		Sikkert_Subjekt_Kategori.put( "smykkesett", "Smykkesett");
		Sikkert_Subjekt_Kategori.put( "&oslashredobber", "&oslashredobber");
		Sikkert_Subjekt_Kategori.put( "ring", "Ringer");
		Sikkert_Subjekt_Kategori.put( "anheng", "Anheng");
		Sikkert_Subjekt_Kategori.put( "perler", "Perler");
		Sikkert_Subjekt_Kategori.put( "bangle", "Bangles");
		Sikkert_Subjekt_Kategori.put( "bikini", "Bikinier");
		Sikkert_Subjekt_Kategori.put( "armb&aringndsur", "Armb&aringndsur");
		Sikkert_Subjekt_Kategori.put( "brosje", "Brosjer");
		Sikkert_Subjekt_Kategori.put( "n&oslashkkelring", "N&oslashkkelringer");
		Sikkert_Subjekt_Kategori.put( "deksel", "Deksler");
		Sikkert_Subjekt_Kategori.put( "hair jewelry", "H&aringrpynt");
		Sikkert_Subjekt_Kategori.put( "minnepinne", "Minnepinner");
		Sikkert_Subjekt_Kategori.put( "kj&oslashling", "Kj&oslashling");
		Sikkert_Subjekt_Kategori.put( "datamus", "Mus");
		Sikkert_Subjekt_Kategori.put( "usb hub", "USB hubs");
		Sikkert_Subjekt_Kategori.put( "kabel", "Kabler");
		Sikkert_Subjekt_Kategori.put( "adapter", "Adaptere");
		Sikkert_Subjekt_Kategori.put( "klistremerke", "Decals");
		Sikkert_Subjekt_Kategori.put( "accessorier", "Accessorier");
		Sikkert_Subjekt_Kategori.put( "boots", "Boots");
		Sikkert_Subjekt_Kategori.put( "piercing", "Piercing");
		Sikkert_Subjekt_Kategori.put( "belte", "Belter");
		Sikkert_Subjekt_Kategori.put( "sandaler", "Sandaler");
		Sikkert_Subjekt_Kategori.put( "skj&oslashrt", "Skj&oslashrt");
		Sikkert_Subjekt_Kategori.put( "forlovelsesringer", "Forlovelsesringer");
		Sikkert_Subjekt_Kategori.put( "skjerf", "Skjerf");
		Sikkert_Subjekt_Kategori.put( "neglestickers", "Stickers");
		Sikkert_Subjekt_Kategori.put( "rhinestones", "Rhinestones");
		Sikkert_Subjekt_Kategori.put( "headset", "Headsets");
		Sikkert_Subjekt_Kategori.put( "&oslashyenskygge", "&oslashyenskygge");
		Sikkert_Subjekt_Kategori.put( "acrylic liquid", "Acrylic Liquid");
		Sikkert_Subjekt_Kategori.put( "penselsett", "Pensler");
		Sikkert_Subjekt_Kategori.put( "bh", "BH");
		Sikkert_Subjekt_Kategori.put( "lommebok", "Lommeb&oslashker");
		Sikkert_Subjekt_Kategori.put( "hanske", "Hansker");
		Sikkert_Subjekt_Kategori.put( "solbriller", "Solbriller");
		Sikkert_Subjekt_Kategori.put( "bagg", "Bagger");
		Sikkert_Subjekt_Kategori.put( "batteri", "Batterier");
		Sikkert_Subjekt_Kategori.put( "penisringer", "Penisringer");
		Sikkert_Subjekt_Kategori.put( "&oslashtevipper", "Falske &oslashtevipper");
		Sikkert_Subjekt_Kategori.put( "forlovelsesringer", "Forlovelsesringer");
		Sikkert_Subjekt_Kategori.put( "perler", "Perler");
		Sikkert_Subjekt_Kategori.put( "tr&aringd", "Tr&aringd");
		Sikkert_Subjekt_Kategori.put( "joggesko", "Joggesko");
		Sikkert_Subjekt_Kategori.put( "h&oslashyh&aeliglte sko", "H&oslashye h&aeligler");
		Sikkert_Subjekt_Kategori.put( "selskapssko", "Selskapssko");
		Sikkert_Subjekt_Kategori.put( "skulderveske", "Skulderveske");
		Sikkert_Subjekt_Kategori.put( "laptopbatteri", "Laptop");
		Sikkert_Subjekt_Kategori.put( "kortetui", "Kortetuier");
		Sikkert_Subjekt_Kategori.put( "selskapsveske", "Selskapsveske");
		Sikkert_Subjekt_Kategori.put( "tastatur", "Mus og Tastatur");
		Sikkert_Subjekt_Kategori.put( "anklet", "Anklets");
		Sikkert_Subjekt_Kategori.put( "hdd deksel", "Diverse");
		Sikkert_Subjekt_Kategori.put( "sko, flats", "Flats");
		Sikkert_Subjekt_Kategori.put( "sko, pumps", "Pumps");
		Sikkert_Subjekt_Kategori.put( "tiara", "Tiaraer");
		Sikkert_Subjekt_Kategori.put( "h&aringrb&aringnd", "H&aringrb&aringnd");
		Sikkert_Subjekt_Kategori.put( "caps", "Caps");
		Sikkert_Subjekt_Kategori.put( "laptopadapter", "Laptop");
		Sikkert_Subjekt_Kategori.put( "hengek&oslashye", "Sittem&oslashbler");
		Sikkert_Subjekt_Kategori.put( "h&aringrklype", "H&aringrklyper");
		Sikkert_Subjekt_Kategori.put( "laptopveske", "Laptop");
		Sikkert_Subjekt_Kategori.put( "laptopkj&oslashling", "Laptop");
		Sikkert_Subjekt_Kategori.put( "t-shirt", "T-shirt");
		Sikkert_Subjekt_Kategori.put( "h&aringndveske", "H&aringndveske");
		Sikkert_Subjekt_Kategori.put( "laptopdeksel", "Laptop");
		Sikkert_Subjekt_Kategori.put( "boxer", "Boxere");
		Sikkert_Subjekt_Kategori.put( "topp", "Topper");
		Sikkert_Subjekt_Kategori.put( "h&aringrkam", "Kammer");
		Sikkert_Subjekt_Kategori.put( "leggings", "Leggings");
		Sikkert_Subjekt_Kategori.put( "&oslashreklokker", "&oslashreklokker");
		Sikkert_Subjekt_Kategori.put( "makeupb&oslashrster", "Makeupb&oslashrster");
		Sikkert_Subjekt_Kategori.put( "penselsett", "Pensler");
		Sikkert_Subjekt_Kategori.put( "falske negler", "Falske Negler");
		Sikkert_Subjekt_Kategori.put( "mascara", "Mascaraer");
		Sikkert_Subjekt_Kategori.put("vibrator", "Vibratorer");
		Sikkert_Subjekt_Kategori.put("analkuler", "Analt");
		Sikkert_Subjekt_Kategori.put("analplugg", "Analt");
		Sikkert_Subjekt_Kategori.put("analdildo", "Analt");
		Sikkert_Subjekt_Kategori.put("analkrem", "Analt");
		Sikkert_Subjekt_Kategori.put("anale leker", "Analt");
		Sikkert_Subjekt_Kategori.put("g-punktvibrator", "Vibratorer");
		Sikkert_Subjekt_Kategori.put("vibratorsett", "Vibratorer");
		Sikkert_Subjekt_Kategori.put("glidemiddel", "Tilbeh&oslashr");
		Sikkert_Subjekt_Kategori.put("moro for utdrikningslag", "Spill og moro");
		if ( URL.indexOf( "1on1" ) > -1 ) {
			Sikkert_Subjekt_Kategori.put("krem\\spray", "Tilbeh&oslashr");
			Sikkert_Subjekt_Kategori.put("spill", "Spill og moro");
			Sikkert_Subjekt_Kategori.put("kule", "For henne");
			Sikkert_Subjekt_Kategori.put("egg", "For henne");
			Sikkert_Subjekt_Kategori.put("flytende sjokolade", "Spill og moro");
		}
		Sikkert_Subjekt_Kategori.put("klitorisstimulator", "For henne");
		Sikkert_Subjekt_Kategori.put("masturbator", "For han");
		Sikkert_Subjekt_Kategori.put("dildo", "Dildo");
		Sikkert_Subjekt_Kategori.put("pisk", "Bondage");
		Sikkert_Subjekt_Kategori.put("bondageleker", "Bondage");
		Sikkert_Subjekt_Kategori.put("bok", "Filmer og b&oslashker");
		Sikkert_Subjekt_Kategori.put("leker for kvinner", "For henne");
		Sikkert_Subjekt_Kategori.put("afrodisiak", "Tilbeh&oslashr");
		Sikkert_Subjekt_Kategori.put("massageutstyr", "Massageutstyr");
		Sikkert_Subjekt_Kategori.put("sexy undert&oslashy", "Sexy Undert&oslashy");
		Sikkert_Subjekt_Kategori.put("penisringer", "For han");
		Sikkert_Subjekt_Kategori.put("penispumpe", "For han");
		Sikkert_Subjekt_Kategori.put("gay", "Gay");
		Sikkert_Subjekt_Kategori.put("kondomer", "Tilbeh&oslashr");
		Sikkert_Subjekt_Kategori.put("t&oslashfler", "T&oslashfler");
		Sikkert_Subjekt_Kategori.put("innesandaler", "Innesandaler");
		Sikkert_Subjekt_Kategori.put("pumps", "Pumps");
		Sikkert_Subjekt_Kategori.put("vintersko", "Vintersko");
		Sikkert_Subjekt_Kategori.put("platformsko", "Platformsko");
		Sikkert_Subjekt_Kategori.put("babyleke", "Babyleker");
		Sikkert_Subjekt_Kategori.put("modellfigur", "Modellfigurer");
		Sikkert_Subjekt_Kategori.put("ballong", "Ballonger");
		Sikkert_Subjekt_Kategori.put("bamse", "Bamser");
		Sikkert_Subjekt_Kategori.put("actionfigur", "Actionfigurer");
		Sikkert_Subjekt_Kategori.put("fjernstyrt helikopter", "Fjernstyrte Helikoptere");
		Sikkert_Subjekt_Kategori.put("tegneleke", "Tegneleker");
		Sikkert_Subjekt_Kategori.put("lekekj&oslashret&oslashy", "Lekekj&oslashret&oslashyer");
		Sikkert_Subjekt_Kategori.put("puslespill", "Puslespill");
		Sikkert_Subjekt_Kategori.put("rampeleke", "Rampeleker");
		Sikkert_Subjekt_Kategori.put("dukke", "Dukker");
		Sikkert_Subjekt_Kategori.put("fjernstyrt bil", "Fjernstyrte Biler");
		Sikkert_Subjekt_Kategori.put("fjernstyrt b&aringt", "Fjernstyrte B&aringter");
		Sikkert_Subjekt_Kategori.put("fjernstyrt leke", "Fjernstyrte Leker");
		Sikkert_Subjekt_Kategori.put("badeleke", "Badeleker");
		Sikkert_Subjekt_Kategori.put("lysende leke", "Lysende Leker");
		Sikkert_Subjekt_Kategori.put("miniatyrfigur", "Miniatyrfigurer");
		Sikkert_Subjekt_Kategori.put("k&aringpe", "K&aringper");
		Sikkert_Subjekt_Kategori.put("eyeliner", "Eyelinere");
		Sikkert_Subjekt_Kategori.put("h&aringnddukke", "H&aringnddukker");
		Sikkert_Subjekt_Kategori.put("modelleringsmasse", "Modelleringsmasse");
		Sikkert_Subjekt_Kategori.put("fjernstyrt tog", "Fjernstyrte Tog");
		Sikkert_Subjekt_Kategori.put("hatt", "Hatter");
		Sikkert_Subjekt_Kategori.put("l&aeligremaskin", "L&aeligremaskiner");
		Sikkert_Subjekt_Kategori.put("hettegenser", "Hettegensere");
		Sikkert_Subjekt_Kategori.put("kamera", "Kameraer");
		Sikkert_Subjekt_Kategori.put("spill", "Spill");
		Sikkert_Subjekt_Kategori.put("tannb&oslashrsteholder", "Tannb&oslashrsteholdere");
		Sikkert_Subjekt_Kategori.put("kostyme", "Kostymer");
		Sikkert_Subjekt_Kategori.put("vekkerklokke", "Vekkerklokker");
		Sikkert_Subjekt_Kategori.put("elektroniske kj&aeligledyr", "Elektroniske Kj&aeligledyr");
		Sikkert_Subjekt_Kategori.put("lys", "Lys");
		Sikkert_Subjekt_Kategori.put("kjole", "Kjoler");
		Sikkert_Subjekt_Kategori.put("sko", "Sko");
		Sikkert_Subjekt_Kategori.put("fotoramme", "Fotorammer");
		Sikkert_Subjekt_Kategori.put("byggeklosser", "Byggeklosser");
		Sikkert_Subjekt_Kategori.put("papirmodell", "Papirmodeller");
		Sikkert_Subjekt_Kategori.put("modellsett", "Modellsett");
		Sikkert_Subjekt_Kategori.put("?", "Diverse");
		Sikkert_Subjekt_Kategori.put("str&oslashmforsyning", "Str&oslashmforsyninger");
		Sikkert_Subjekt_Kategori.put("kj&oslashleskapsmagneter", "Kj&oslashleskapsmagneter");
		Sikkert_Subjekt_Kategori.put("mobildeksel", "Mobildeksler");
		Sikkert_Subjekt_Kategori.put("byggesett", "Byggesett");
		Sikkert_Subjekt_Kategori.put("lekebil", "Lekebiler");
		Sikkert_Subjekt_Kategori.put("helikopter", "Usortert");
		Sikkert_Subjekt_Kategori.put("n&aringl", "Usortert");
		Sikkert_Subjekt_Kategori.put("karnevalsmaske", "Karnevalsmasker");
		Sikkert_Subjekt_Kategori.put("kl&aeligr", "Usortert");
		Sikkert_Subjekt_Kategori.put("legomodell", "Lego");
		Sikkert_Subjekt_Kategori.put("paraply", "Paraplyer");
		Sikkert_Subjekt_Kategori.put("fjernstyrer", "Fjernstyrt, Usortert");
		Sikkert_Subjekt_Kategori.put("hobbyting", "Usortert");
		Sikkert_Subjekt_Kategori.put("pute", "Puter");
		Sikkert_Subjekt_Kategori.put("pengepung", "Pengepunger");
		Sikkert_Subjekt_Kategori.put("veske", "Usortert");
		Sikkert_Subjekt_Kategori.put("sokker", "Sokker");
		Sikkert_Subjekt_Kategori.put("dekorasjon", "Dekorasjon");
		Sikkert_Subjekt_Kategori.put("sengesett", "Usortert");
		Sikkert_Subjekt_Kategori.put("wall stickers", "Wall Stickers");
		Sikkert_Subjekt_Kategori.put("termometer", "Usortert");
		Sikkert_Subjekt_Kategori.put("lim", "Usortert");
		Sikkert_Subjekt_Kategori.put("yttert&oslashy", "Yttert&oslashy");
		Sikkert_Subjekt_Kategori.put("usb-gadget", "USB-gadgets");
		Sikkert_Subjekt_Kategori.put("bukse", "Bukser");
		Sikkert_Subjekt_Kategori.put("kj&oslashling", "Kj&oslashling");
		Sikkert_Subjekt_Kategori.put("matte", "Usortert");
		Sikkert_Subjekt_Kategori.put("lanterne", "Lanterner");
		Sikkert_Subjekt_Kategori.put("matte", "Usortert");
		Sikkert_Subjekt_Kategori.put("fiskekroker", "Fisking");
		Sikkert_Subjekt_Kategori.put("dukkehus", "Dukkehus");
		Sikkert_Subjekt_Kategori.put("gadget", "Usortert");
		Sikkert_Subjekt_Kategori.put("veggklokke", "Veggklokker");
		Sikkert_Subjekt_Kategori.put("kronblader", "Usortert");
		Sikkert_Subjekt_Kategori.put("alkoholtester", "Gadgets");
		Sikkert_Subjekt_Kategori.put("genser", "Gensere");
		Sikkert_Subjekt_Kategori.put("kabel", "Kabler");
		Sikkert_Subjekt_Kategori.put("lagringsbagg", "Usortert");
		Sikkert_Subjekt_Kategori.put("lommelykt", "Lommelykter");
		Sikkert_Subjekt_Kategori.put("fjernstyrt motorsykkel", "Fjernstyrte Motorsykler");
		Sikkert_Subjekt_Kategori.put("ledlys", "LEDlys");
		Sikkert_Subjekt_Kategori.put("&oslashrevarmer", "&oslashrevarmer");
		Sikkert_Subjekt_Kategori.put("suger&oslashr", "Usortert");
		Sikkert_Subjekt_Kategori.put("iphone", "iPhone");
		Sikkert_Subjekt_Kategori.put("papir", "Usortert");
		Sikkert_Subjekt_Kategori.put("fiskeagn", "Usortert");
		Sikkert_Subjekt_Kategori.put("ruller", "Usortert");
		Sikkert_Subjekt_Kategori.put("bluse", "Bluser");
		Sikkert_Subjekt_Kategori.put("briller", "Usortert");
		Sikkert_Subjekt_Kategori.put("hylle", "Usortert");
		Sikkert_Subjekt_Kategori.put("&oslashyevipper", "&oslashyevipper");
		Sikkert_Subjekt_Kategori.put("votter", "Yttert&oslashy");
		
		if ( Sikkert_Subjekt_Kategori.get( Subject.toLowerCase() ) != null ) {
			DynamiskSubkategori = (String) Sikkert_Subjekt_Kategori.get( Subject.toLowerCase() );
		}
		//stikkord
		if ( Parser.InneholderSeparertOrd( "iphone 4", Stikkord ) > -1) {  DynamiskSubkategori = "iPhone 4"; }
		if ( Parser.InneholderSeparertOrd( "iphone 5", Stikkord ) > -1) {  DynamiskSubkategori = "iPhone 5"; }
		if ( Parser.InneholderSeparertOrd( "usb", Stikkord ) > -1) {  DynamiskSubkategori = "Gadgets"; }
		//head
		if ( Parser.InneholderSeparertOrd( "sneakers", Head ) > -1) { DynamiskSubkategori = "Sneakers";  }

		//sære regler
		if ( Parser.InneholderSeparertOrd( "minnepinne", Subject ) > -1 ) {
			Pattern Regex1 = Pattern.compile( "((\\d+)gb)" );
			Matcher m1 = Regex1.matcher( Stikkord );
			m1 = Regex1.matcher( Stikkord );
			while ( m1.find() ) {
				String MatchFunnet = m1.group(1);
				DynamiskSubkategori = MatchFunnet;
			}
		}
		if ( Parser.InneholderSeparertOrd( "glasses", Subject ) > -1 ) {
			if ( Parser.InneholderSeparertOrd( "case", Category ) > -1) {  
				DynamiskSubkategori = "Etuier";
			}
		}
		if ( Parser.InneholderSeparertOrd( "armb&aringnd", Subject ) > -1 ) {
			if ( Parser.InneholderSeparertOrd( "klokke", Subject ) > -1) {  
				DynamiskSubkategori = "Armb&aringndsur";
			}
		}
		if ( Parser.InneholderSeparertOrd( "nail polish", Category ) > -1) {  
			Subject = "Neglelakk";
		}
		
		//leker og modellfiurer
		if ( Parser.InneholderSeparertOrd( "miniatyrmodell", Stikkord ) > -1) {  
			DynamiskSubkategori = "Miniatyrfigurer - Usortert";
			Subject = "Miniatyrfigur";
		}
		if ( ( Parser.InneholderSeparertOrd( "Leke", Subject ) > -1 ) ) {
			if ( Parser.InneholderSeparertOrd( "treverk", Materialer ) > -1) {  
				DynamiskSubkategori = "Treleker";
			} else if ( Parser.InneholderSeparertOrd( "miniatyr", Stikkord ) > -1) {  
				DynamiskSubkategori = "Miniatyrer";
			} else if ( Parser.InneholderSeparertOrd( "plush", Materialer ) > -1) {  
				DynamiskSubkategori = "Bamser";
			} else if ( Parser.InneholderSeparertOrd( "barn", Stikkord ) > -1) {  
				DynamiskSubkategori = "Barneleker";
			} else if ( Parser.InneholderSeparertOrd( "gutt", Stikkord ) > -1) {  
				DynamiskSubkategori = "Barneleker";
			} else if ( Parser.InneholderSeparertOrd( "jente", Stikkord ) > -1) {  
				DynamiskSubkategori = "Barneleker";
			} else if ( Parser.InneholderSeparertOrd( "baby", Stikkord ) > -1) {  
				DynamiskSubkategori = "Babyleker";
			} else {
				DynamiskSubkategori = "Usortert";
			}
		}
		
		if ( 
				( Parser.InneholderSeparertOrd( "Modellfigurer", DynamiskSubkategori ) > -1 ) || 
				( Parser.InneholderSeparertOrd( "Modellsett", DynamiskSubkategori ) > -1 ) || 
				( Parser.InneholderSeparertOrd( "Modellfigur", Subject ) > -1 )
				) {
			//brukergruppe som kvalifisering
			if ( Parser.InneholderSeparertOrd( "barn", Stikkord ) > -1) {  
				DynamiskSubkategori = "Barneleker";
			} else if ( Parser.InneholderSeparertOrd( "gutt", Stikkord ) > -1) {  
				DynamiskSubkategori = "Barneleker";
			} else if ( Parser.InneholderSeparertOrd( "jente", Stikkord ) > -1) {  
				DynamiskSubkategori = "Barneleker";
			} else if ( Parser.InneholderSeparertOrd( "baby", Stikkord ) > -1) {  
				DynamiskSubkategori = "Babyleker";
			} else {
				//System.out.println( this.getClass().toString()+" DynamiskSubkategori Stikkord="+Stikkord );
			}
			
			//bruksområde som kvalifisering
			if ( Parser.InneholderSeparertOrd( "DIY", Stikkord ) > -1) {  
				DynamiskSubkategori = "Byggesett";
			} else if ( Parser.InneholderSeparertOrd( "selvbygging", Stikkord ) > -1) {  
				DynamiskSubkategori = "Byggesett";
			}
			
			//materialer som kvalifisering
			if ( Parser.InneholderSeparertOrd( "resin kit", Materialer ) > -1) {  
				DynamiskSubkategori = "Miniatyrfigurer";
				Subject = "Miniatyrfigur";
			} else if ( Parser.InneholderSeparertOrd( "resin", Materialer ) > -1) {  
				DynamiskSubkategori = "Resinfigurer";
			} else if ( Parser.InneholderSeparertOrd( "treverk", Materialer ) > -1) {  
				DynamiskSubkategori = "Trefigurer";
			}
			
			//egenskaper som kvalifisering
			if ( Parser.InneholderSeparertOrd( "mini", Stikkord ) > -1) {  
				DynamiskSubkategori = "Sm&aringfigurer";
			}
			
			//stats som kvalifisering
			Pattern Regex2 = Pattern.compile( "((\\d+)mm)" );
			Matcher m2 = Regex2.matcher( Stikkord );
			m2 = Regex2.matcher( Stikkord );
			while ( m2.find() ) {
				String MatchFunnet = m2.group(1);
				if ( Integer.parseInt( m2.group(2) ) < 150 ) {
					DynamiskSubkategori = "Miniatyrfigurer - Usortert";
					Subject = "Miniatyrfigur";
				} else {
					//Subject = "Modellfigur";
				}
			}
			
			Pattern Regex3 = Pattern.compile( "(1:(\\d+))\\D" );
			Matcher m3 = Regex3.matcher( Stikkord );
			m3 = Regex3.matcher( Stikkord );
			while ( m3.find() ) {
				String MatchFunnet = m3.group(1);
				if ( Integer.parseInt( m3.group(2) ) > 10 ) {
					DynamiskSubkategori = "Miniatyrfigurer - Usortert";
					Subject = "Miniatyrfigur";
				} else {
					//Subject = "Modellfigur";
				}
			}
			Pattern Regex33 = Pattern.compile( "(1/(\\d+))\\D" );
			Matcher m33 = Regex33.matcher( Stikkord );
			m33 = Regex33.matcher( Stikkord );
			while ( m33.find() ) {
				String MatchFunnet = m33.group(1);
				if ( Integer.parseInt( m33.group(2) ) > 10 ) {
					DynamiskSubkategori = "Miniatyrfigurer - Usortert";
					Subject = "Miniatyrfigur";
				} else {
					//Subject = "Modellfigur";
				}
			}
			
			Pattern Regex32 = Pattern.compile( "(1\\\\(\\d+))\\D" );
			Matcher m32 = Regex32.matcher( Stikkord );
			m32 = Regex32.matcher( Stikkord );
			while ( m32.find() ) {
				String MatchFunnet = m32.group(1);
				if ( Integer.parseInt( m32.group(2) ) > 10 ) {
					DynamiskSubkategori = "Miniatyrfigurer - Usortert";
					Subject = "Miniatyrfigur";
				} else {
					//Subject = "Modellfigur";
				}
			}
			
			
		}
		//produsent som kvalifisering
		if ( 
				( Parser.InneholderSeparertOrd( "Trumpeter", Stikkord ) > -1) ||
				( Parser.InneholderSeparertOrd( "Kitty Hawk", Stikkord ) > -1) ||
				( Parser.InneholderSeparertOrd( "Forge World", Stikkord ) > -1) ||
				( Parser.InneholderSeparertOrd( "Hobby Boss", Stikkord ) > -1) ||
				( Parser.InneholderSeparertOrd( "Griffon Model", Stikkord ) > -1) ||
				( Parser.InneholderSeparertOrd( "Tamiya", Stikkord ) > -1) ||
				( Parser.InneholderSeparertOrd( "Evolution Miniatures", Stikkord ) > -1) ||
				( Parser.InneholderSeparertOrd( "Scania", Stikkord ) > -1) ||
				( Parser.InneholderSeparertOrd( "Meng", Stikkord ) > -1) ||
				( Parser.InneholderSeparertOrd( "AFV Club", Stikkord ) > -1) ||
				( Parser.InneholderSeparertOrd( "E.T. model", Stikkord ) > -1) ||
				( Parser.InneholderSeparertOrd( "Caesar Miniaturess", Stikkord ) > -1)
				){ 
			DynamiskSubkategori = "Miniatyrfigurer - Usortert"; 
			Subject = "Miniatyrfigur";
		}
		
		ItemStats_Tema TemaDatabase = new ItemStats_Tema();
		Object_ItemStats_Tema[] TemaListe = new Object_ItemStats_Tema[ TemaDatabase.HentListe_Objekter().length ];
		TemaListe = TemaDatabase.HentListe_Objekter();
		for ( int X = 0 ; X <  TemaListe.length ; X++ ) {
			if ( TemaListe[X] != null ) {
				if ( TemaListe[X].Egennavn_Norsk != null ) {
					if ( Parser.InneholderSeparertOrd( TemaListe[X].Egennavn_Norsk, Stikkord ) > -1) {
						if ( TemaListe[X].Subkategori != null ) {
							DynamiskSubkategori = TemaListe[X].Subkategori;
						}
					}
					if ( Parser.InneholderSeparertOrd( TemaListe[X].Egennavn_Norsk, Subject ) > -1) {
						if ( TemaListe[X].Subkategori != null ) {
							DynamiskSubkategori = TemaListe[X].Subkategori;
						}
					}
				}
			}
		}
		
		//særregler
		if ( 
				( Parser.InneholderSeparertOrd( "Miniatyrfigur", Subject ) > -1) ||
				( Parser.InneholderSeparertOrd( "Miniatyrfigurer", DynamiskSubkategori ) > -1) 
				) { 
			
			ItemStats_Stater StatsDatabase = new ItemStats_Stater();
			Object_ItemStats_Stat[] StatListe = new Object_ItemStats_Stat[100];
			StatListe = StatsDatabase.HentStatListe_Objekter();
			for ( int X = 0 ; X <  StatListe.length ; X++ ) {
				if ( StatListe[X] != null ) {
					if ( Parser.InneholderSeparertOrd( StatListe[X].Egennavn_Engelsk, Stikkord ) > -1) { 
						DynamiskSubkategori = "Miniatyrskala - " + StatListe[X].Egennavn_Norsk+" "; 
					} else if ( Parser.InneholderSeparertOrd( StatListe[X].Adjektiv_Engelsk, Stikkord ) > -1) { 
						DynamiskSubkategori = "Miniatyrskala - " + StatListe[X].Egennavn_Norsk+" "; 
					}
				}
			}
			
			for ( int X = 0 ; X <  TemaListe.length ; X++ ) {
				if ( TemaListe[X] != null ) {
					if ( TemaListe[X].Egennavn_Norsk != null ) {
						if ( Parser.InneholderSeparertOrd( TemaListe[X].Egennavn_Norsk, Stikkord ) > -1) {
							if ( TemaListe[X].Kategori_Miniatyrfigurer != null ) {
								if ( DynamiskSubkategori.indexOf("Miniatyrskala - WW2") > -1 ) {
									//ikke flytt fra WW2-kategorien
								} else if ( ( DynamiskSubkategori.indexOf("bitz") > -1 ) &&
										( TemaListe[X].Kategori_Miniatyrfigurer.indexOf("Warhammer") > -1 ) ) {
									//ikke flytt fra bitz-kategorien
								} else {
									DynamiskSubkategori = TemaListe[X].Kategori_Miniatyrfigurer;
								}
							}
						}//Head
					} else {
						if ( Parser.InneholderSeparertOrd( TemaListe[X].Egennavn_Engelsk, Head ) > -1) {
							if ( TemaListe[X].Kategori_Miniatyrfigurer != null ) {
								if ( DynamiskSubkategori.indexOf("Miniatyrskala - WW2") > -1 ) {
									//ikke flytt fra WW2-kategorien
								} else if ( ( DynamiskSubkategori.indexOf("bitz") > -1 ) &&
										( TemaListe[X].Kategori_Miniatyrfigurer.indexOf("Warhammer") > -1 ) ) {
									//ikke flytt fra bitz-kategorien
								} else if ( ( DynamiskSubkategori.indexOf("Warhammer ") > -1 ) &&
										( TemaListe[X].Kategori_Miniatyrfigurer.indexOf("Warhammer") > -1 ) ) {
									//ikke flytt fra spesifisert til uspesifisert warhammer-kategori
								} else {
									DynamiskSubkategori = TemaListe[X].Kategori_Miniatyrfigurer;
								}
							}
						}
					}
				}
			}
			//System.out.println( Subject+" "+DynamiskSubkategori+" "+Stikkord );
		}
		
		//absolutte regler
		if (
				( Parser.InneholderSeparertOrd( "Warhammer", Stikkord ) > -1) &&
				( Parser.InneholderSeparertOrd( "Warhammer", DynamiskSubkategori ) == -1) 
				) {  
			DynamiskSubkategori = "Warhammer";
		}
		if ( Parser.InneholderSeparertOrd( "Gundam", Stikkord ) > -1) {  
			DynamiskSubkategori = "Gundam";
		}
		if ( Parser.InneholderSeparertOrd( "Lego", Stikkord ) > -1) { 
			DynamiskSubkategori = "Lego"; 
		}

		if ( DynamiskSubkategori == null ) {
			DynamiskSubkategori = "Div";
		}
		if ( ( DynamiskSubkategori.equals("Div") ) && ( Subject.equals("") == false ) ) {
			System.out.println( this.getClass().toString()+" DynamiskSubkategori Category="+Category+" Subject="+Subject+" Stikkord="+Stikkord );
			System.out.println( this.getClass().toString()+" DynamiskSubkategori DynamiskSubkategori="+DynamiskSubkategori+" hashmap="+Sikkert_Subjekt_Kategori.get( Subject.toLowerCase() ) );
		}
		return DynamiskSubkategori;
	}
	public String RenameSubject( String Subject, String DynamiskHovedkategori, String DynamiskSubkategori, String Beskrivelse) {
		if ( DynamiskSubkategori.equals( "Miniatyrskala - Motorsykler" ) == true ) {
			if ( Subject.equals( "Modellfigur" ) == true ) {
				return "Miniatyrmodell av Motorsykkel";
			}
		}
		if ( DynamiskSubkategori.equals( "Miniatyrskala - Tanks" ) == true ) {
			if ( Subject.equals( "Modellfigur" ) == true ) {
				return "Miniatyrmodell av Tanks";
			}
		}
		if ( DynamiskSubkategori.equals( "Miniatyrskala - Fly" ) == true ) {
			if ( Subject.equals( "Modellfigur" ) == true ) {
				return "Miniatyrmodell av Fly";
			}
		}
		if ( DynamiskSubkategori.equals( "Miniatyrskala - Helikoptere" ) == true ) {
			if ( Subject.equals( "Modellfigur" ) == true ) {
				return "Miniatyrmodell av Helikopter";
			}
		}
		if ( DynamiskSubkategori.equals( "Warhammer 40k" ) == true ) {
			if ( Subject.equals( "Modellfigur" ) == true ) {
				return "Warhammer 40k Units";
			}
		}
		if ( DynamiskSubkategori.equals( "Warhammer Bitz" ) == true ) {
			if ( Subject.equals( "Miniatyrfigur" ) == true ) {
				return "Bitz";
			}
		}
		if ( DynamiskSubkategori.equals( "Miniatyrskala - Arkitektur" ) == true ) {
			if ( Beskrivelse.indexOf( "palass" ) > -1 ) {
				return "Miniatyrpalass";
			} else if ( Beskrivelse.indexOf( "slott" ) > -1 ) {
				return "Miniatyrslott";
			} else if ( Beskrivelse.indexOf( "villa" ) > -1 ) {
				return "Miniatyrvilla";
			} else if ( Beskrivelse.indexOf( "hus" ) > -1 ) {
				return "Miniatyrhus";
			} else if ( Beskrivelse.indexOf( "bro" ) > -1 ) {
				return "Miniatyrbro";
			}
		}
		return Subject;
	}
	

}
