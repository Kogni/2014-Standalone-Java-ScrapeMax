
package Offers;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import Control.Controller;
import Searching.Object_SearchJob;
public class Thread_Identify_AliExpress extends Thread_Identify {

    public Thread_Identify_AliExpress(Controller Class_Controller, Object_SearchJob hentetJobb) {
	super(Class_Controller, hentetJobb);
    }

    @Override
    public void FinnFrontbilde(String Buffer) throws Exception {
	Date Start = new Date();
	String EditedBuffer = Buffer;
	if (EditedBuffer.indexOf("magnifier") > -1) {
	    EditedBuffer = EditedBuffer.substring(EditedBuffer.indexOf("magnifier"));
	}
	/*if (EditedBuffer.indexOf("image\" content=\"") > -1) {
	    EditedBuffer = EditedBuffer.substring(EditedBuffer.indexOf("image\" content=\""));
	}*/
	if (EditedBuffer.indexOf("ui-image-viewer-thumb-wrap") > -1) {
	    EditedBuffer = EditedBuffer.substring(EditedBuffer.indexOf("ui-image-viewer-thumb-wrap"));
	}
	if (EditedBuffer.indexOf("ui-image-viewer-thumb-frame\" href=\"") > -1) {
	    EditedBuffer = EditedBuffer.substring(EditedBuffer.indexOf("ui-image-viewer-thumb-frame\" href=\""));
	}
	if (EditedBuffer.indexOf("href=\"") > -1) {
	    EditedBuffer = EditedBuffer.substring(EditedBuffer.indexOf("href=\"") + 6);
	}
	//ui-image-viewer-thumb-frame" href="
	try {
	    String Temp = EditedBuffer.substring(0, (EditedBuffer.indexOf(".jpg") + ".jpg".length()));
	    Jobb.TargetOffer.Set_FrontBilde(new URL(Temp));
	} catch (MalformedURLException T) {
	    System.out.println(this.getClass().toString() + " MalformedURLException FinnFrontbilde bad front picture="
		    + EditedBuffer.substring(0, Math.min(100, EditedBuffer.length())));
	    ForkastURL(Buffer, "bad front picture");
	    return;
	} catch (Exception T) {
	    System.out.println(this.getClass().toString() + " Exception FinnFrontbilde bad front picture="
		    + EditedBuffer.substring(0, Math.min(100, EditedBuffer.length())));
	    ForkastURL(Buffer, "bad front picture");
	    return;
	}
	Date Slutt = new Date();
	int Tid = (int) (Slutt.getTime() - Start.getTime());
	if (Tid > 0) {
	    //System.out.println( this.getClass().toString()+" FinnFrontbilde Arbeidstid="+Tid );
	}
    }

    @Override
    public void FinnObjectID(String Buffer) throws Exception {
	Date Start = new Date();
	String EditedBuffer = Buffer;
	if (EditedBuffer.indexOf("objectId") > -1) {
	    EditedBuffer = EditedBuffer.substring(EditedBuffer.indexOf("objectId"));
	}
	if (EditedBuffer.indexOf("meta content=") > -1) {
	    EditedBuffer = EditedBuffer.substring(EditedBuffer.indexOf("meta content="));
	}
	if (EditedBuffer.indexOf("<input type") > -1) {
	    EditedBuffer = EditedBuffer.substring(EditedBuffer.indexOf("<input type"));
	}
	if (EditedBuffer.indexOf("\" />") > -1) {
	    EditedBuffer = EditedBuffer.substring(EditedBuffer.indexOf("\" />"));
	}
	if (EditedBuffer.indexOf("value=\"") > -1) {
	    EditedBuffer = EditedBuffer.substring(EditedBuffer.indexOf("value=\""));
	}
	try {
	    Jobb.TargetOffer.Set_ObjectID(EditedBuffer);
	} catch (Exception e) {
	    System.out.println(this.getClass().toString() + " FinnObjectID =" + EditedBuffer.substring(0, 100));
	    ForkastURL(Buffer, "no object ID");
	    return;
	}
	Date Slutt = new Date();
	int Tid = (int) (Slutt.getTime() - Start.getTime());
	if (Tid > 0) {
	    //System.out.println( this.getClass().toString()+" FinnObjectID Arbeidstid="+Tid );
	}
    }

    @Override
    public void FinnBilder(String Buffer) throws Exception {
	//System.out.println( this.getClass().toString()+" FinnBilder "+Jobb.Get_Adresse().toString() );
	Date Start = new Date();
	boolean found = false;
	String EditedBuffer = Buffer;
	//FRA
	boolean FoundSpecifics = false;
	if (EditedBuffer.indexOf("product-info-main") > -1) {
	    EditedBuffer = EditedBuffer.substring(EditedBuffer.indexOf("product-info-main"));
	    FoundSpecifics = true;
	}
	//detail-extend-main">
	if (EditedBuffer.indexOf("product-desc") > -1) {
	    EditedBuffer = EditedBuffer.substring(EditedBuffer.indexOf("product-desc"));
	    FoundSpecifics = true;
	}
	if (EditedBuffer.indexOf("<h2>Item specifics</h2>") > -1) {
	    EditedBuffer = EditedBuffer.substring(EditedBuffer.indexOf("<h2>Item specifics</h2>"));
	    FoundSpecifics = true;
	}
	//custom-description
	if (EditedBuffer.indexOf("custom-description") > -1) {
	    EditedBuffer = EditedBuffer.substring(EditedBuffer.indexOf("custom-description") + "custom-description".length());
	    FoundSpecifics = true;
	}
	if (EditedBuffer.indexOf("detail-extend-main") > -1) {
	    EditedBuffer = EditedBuffer.substring(EditedBuffer.indexOf("detail-extend-main"));
	    FoundSpecifics = true;
	}
	//<div id="diigotb-imagepanel"
	//Product Description
	if (EditedBuffer.indexOf("product description") > -1) {
	    EditedBuffer = EditedBuffer.substring(EditedBuffer.indexOf("product description"));
	    FoundSpecifics = true;
	}
	if (EditedBuffer.indexOf("Product Description") > -1) {
	    EditedBuffer = EditedBuffer.substring(EditedBuffer.indexOf("Product Description"));
	    FoundSpecifics = true;
	}
	//<div id="custom-description" class="clearfix">
	if (FoundSpecifics == false) {
	    if (EditedBuffer.indexOf("<div id=\"custom-description\" class=\"clearfix\">") > -1) {
		EditedBuffer = EditedBuffer.substring(EditedBuffer.indexOf("<div id=\"custom-description\" class=\"clearfix\">"));
	    }
	    //<h2>Item specifics</h2>
	    if (EditedBuffer.indexOf("<h2 class=\"description\">Product Description</h2>") > -1) {
		EditedBuffer = EditedBuffer.substring(EditedBuffer.indexOf("<h2 class=\"description\">Product Description</h2>"));
	    }
	}
	//TIL
	//Packaging Details 
	if (EditedBuffer.indexOf("Packaging Details ") > -1) {
	    EditedBuffer = EditedBuffer.substring(0, EditedBuffer.indexOf("Packaging Details "));
	}
	if (EditedBuffer.indexOf("pnl-packaging") > -1) {
	    EditedBuffer = EditedBuffer.substring(0, EditedBuffer.indexOf("pnl-packaging"));
	}
	//UTEN
	while (EditedBuffer.indexOf(".jpg") > -1) {
	    String Bilde =
		    EditedBuffer.substring(Math.max(0, (EditedBuffer.indexOf(".jpg") - 150)),
			    (EditedBuffer.indexOf(".jpg") + ".jpg".length()));
	    if (Bilde.lastIndexOf("http") > -1) {
		String Bilde2 = Bilde.substring(Bilde.lastIndexOf("http"));
		if (Bilde2.length() > 150) {
		} else {
		    Jobb.TargetOffer.ImageText = Jobb.TargetOffer.ImageText + "<img alt='ALTIMAGETEXT' src='" + Bilde2 + "' >";
		    found = true;
		}
	    }
	    if (EditedBuffer.indexOf(Bilde) > -1) {
		EditedBuffer = EditedBuffer.substring(EditedBuffer.indexOf(Bilde) + Bilde.length());
	    }
	}
	if (!found) {
	    System.out.println(this.getClass().toString() + " FinnBilder ="
		    + EditedBuffer.substring(0, Math.min(100, EditedBuffer.length())));
	    ForkastURL(Buffer, "ingen bilder");
	    return;
	}
	Date Slutt = new Date();
	int Tid = (int) (Slutt.getTime() - Start.getTime());
	if (Tid > 0) {
	    //System.out.println( this.getClass().toString()+" FinnBilder Arbeidstid="+Tid+" Buffer size="+Buffer.length() );
	}
    }

    @Override
    public void FinnDescription(String Buffer) throws Exception {
	Date Start = new Date();
	String EditedBuffer = Buffer;
	Jobb.TargetOffer.Description = "";
	//FRA
	if (EditedBuffer.indexOf("<div id=\"switch-main\" style=\"margin-left: 240px;\">") > -1) {
	    EditedBuffer = EditedBuffer.substring(EditedBuffer.indexOf("<div id=\"switch-main\" style=\"margin-left: 240px;\">"));
	}
	//<div id="col-sub" class="col-sub" style="display: block; visibility: visible;">
	if (EditedBuffer.indexOf("<div id=\"col-sub\" class=\"col-sub\" style=\"display: block; visibility: visible;\">") > -1) {
	    EditedBuffer =
		    EditedBuffer.substring(EditedBuffer
			    .indexOf("<div id=\"col-sub\" class=\"col-sub\" style=\"display: block; visibility: visible;\">"));
	}
	//<div id="col-main" class="col-main">
	if (EditedBuffer.indexOf("<div id=\"col-main\" class=\"col-main\">") > -1) {
	    EditedBuffer = EditedBuffer.substring(EditedBuffer.indexOf("<div id=\"col-main\" class=\"col-main\">"));
	}
	//<div id="switch-bar" class="switch-bar" style="top: 0px;">
	if (EditedBuffer.indexOf("<div id=\"switch-bar\" class=\"switch-bar\" style=\"top: 0px;\">") > -1) {
	    EditedBuffer = EditedBuffer.substring(EditedBuffer.indexOf("<div id=\"switch-bar\" class=\"switch-bar\" style=\"top: 0px;\">"));
	}
	//<div id="tabbed-pane">
	if (EditedBuffer.indexOf("<div id=\"tabbed-pane\">") > -1) {
	    EditedBuffer = EditedBuffer.substring(EditedBuffer.indexOf("<div id=\"tabbed-pane\">"));
	}
	//<div id="pdt" class="tabbed-pane-panel clearfix" style="display: block;">
	if (EditedBuffer.indexOf("<div id=\"pdt\" class=\"tabbed-pane-panel clearfix\" style=\"display: block;\">") > -1) {
	    EditedBuffer =
		    EditedBuffer.substring(EditedBuffer
			    .indexOf("<div id=\"pdt\" class=\"tabbed-pane-panel clearfix\" style=\"display: block;\">"));
	}
	//<h2>Item specifics</h2>
	if (EditedBuffer.indexOf("<h2>Item specifics</h2>") > -1) {
	    EditedBuffer = EditedBuffer.substring(EditedBuffer.indexOf("<h2>Item specifics</h2>"));
	}
	if (EditedBuffer.indexOf("</div>") > -1) {
	    Jobb.TargetOffer.ProductStats = EditedBuffer.substring(0, EditedBuffer.indexOf("</div>"));
	}
	//TIL
	//<script type="text/javascript">
	if (EditedBuffer.indexOf("Packaging Details ".toLowerCase()) > -1) {
	    EditedBuffer = EditedBuffer.substring(0, EditedBuffer.indexOf("Packaging Details ".toLowerCase()));
	}
	//<table
	if (EditedBuffer.indexOf("<table") > -1) {
	    EditedBuffer = EditedBuffer.substring(0, EditedBuffer.indexOf("<table"));
	}
	//UTEN
	Jobb.TargetOffer.Description = EditedBuffer;
	//<dt>Price:</dt>
	if (EditedBuffer.indexOf("<dt>Price:</dt>".toLowerCase()) > -1) {
	    Jobb.TargetOffer.Description =
		    Jobb.TargetOffer.Description + " " + EditedBuffer.substring(EditedBuffer.indexOf("<dt>Price:</dt>".toLowerCase()));
	} else if (EditedBuffer.indexOf("<h2>Item specifics</h2>".toLowerCase()) > -1) {
	    Jobb.TargetOffer.Description =
		    Jobb.TargetOffer.Description + " "
			    + EditedBuffer.substring(EditedBuffer.indexOf("<h2>Item specifics</h2>".toLowerCase()));
	} else if (EditedBuffer.indexOf("<div class=\"description_m\">".toLowerCase()) > -1) {
	    Jobb.TargetOffer.Description =
		    Jobb.TargetOffer.Description + " " + EditedBuffer.substring(EditedBuffer.indexOf("<div class=\"description_m\">"));
	} else if (EditedBuffer.indexOf("Product Description>".toLowerCase()) > -1) {
	    Jobb.TargetOffer.Description =
		    Jobb.TargetOffer.Description + " " + EditedBuffer.substring(EditedBuffer.indexOf("Product Description".toLowerCase()));
	} else if (EditedBuffer.indexOf("custom-description".toLowerCase()) > -1) {
	    Jobb.TargetOffer.Description =
		    Jobb.TargetOffer.Description + " " + EditedBuffer.substring(EditedBuffer.indexOf("custom-description".toLowerCase()));
	} else if (EditedBuffer.indexOf("product-desc".toLowerCase()) > -1) {
	    Jobb.TargetOffer.Description =
		    Jobb.TargetOffer.Description + " " + EditedBuffer.substring(EditedBuffer.indexOf("product-desc".toLowerCase()));
	}
	if (Jobb.TargetOffer.Description.indexOf("<div id=\"pdt-pnl-packaging".toLowerCase()) > -1) {
	    Jobb.TargetOffer.Description =
		    Jobb.TargetOffer.Description.substring(0,
			    Jobb.TargetOffer.Description.indexOf("<div id=\"pdt-pnl-packaging".toLowerCase()));
	}
	if (EditedBuffer.indexOf("<!-- pic start -->".toLowerCase()) > -1) {
	    Jobb.TargetOffer.Description =
		    Jobb.TargetOffer.Description + EditedBuffer.substring(EditedBuffer.indexOf("<!-- pic start -->"));
	    Jobb.TargetOffer.Description =
		    Jobb.TargetOffer.Description.substring(0, Jobb.TargetOffer.Description.indexOf("<!-- pic end -->"));
	    //Jobb.TargetOffer.Description = Jobb.TargetOffer.Description.toLowerCase();
	}
	if (Jobb.TargetOffer.Description.indexOf("<div id=\"seller-promise-list\">".toLowerCase()) > -1) {
	    if (Jobb.TargetOffer.Description.indexOf("<div class=\"img-zoom-in\">".toLowerCase()) > -1) {
		String Del1 =
			Jobb.TargetOffer.Description.substring(0, Jobb.TargetOffer.Description.indexOf("<div id=\"seller-promise-list\">"));
		String Del2 = Jobb.TargetOffer.Description.substring(Jobb.TargetOffer.Description.indexOf("<div class=\"img-zoom-in\">"));
		Jobb.TargetOffer.Description = Del1 + Del2;
	    }
	}
	String Del1 = "";
	if (Jobb.TargetOffer.Description.indexOf("<input id".toLowerCase()) > -1) {
	    Del1 = Jobb.TargetOffer.Description.substring(0, Jobb.TargetOffer.Description.indexOf("<input id"));
	}
	String Del2 = "";
	if (Jobb.TargetOffer.Description.indexOf("<div id".toLowerCase()) > -1) {
	    Del2 = Jobb.TargetOffer.Description.substring(Jobb.TargetOffer.Description.indexOf("<div id"));
	}
	Jobb.TargetOffer.Description = Del1 + Del2;
	if (Jobb.TargetOffer.Description.indexOf("<script type".toLowerCase()) > -1) {
	    Del1 = "";
	    Del2 = "";
	    //if ( Jobb.TargetOffer.Description.indexOf( "</script>".toLowerCase() ) > -1 ){
	    Del1 = Jobb.TargetOffer.Description.substring(0, Jobb.TargetOffer.Description.indexOf("<script type"));
	    Del2 = Jobb.TargetOffer.Description.substring(Jobb.TargetOffer.Description.indexOf("</script>") + "</script>".length());
	    Jobb.TargetOffer.Description = Del1 + Del2;
	    //}
	}
	if (Jobb.TargetOffer.Description.equals("") == true) {
	    System.out.println(this.getClass().toString() + " FinnDescription ="
		    + Jobb.TargetOffer.Description.substring(0, Math.min(Jobb.TargetOffer.Description.length(), 100)));
	    ForkastURL(EditedBuffer, "no description");
	    return;
	}
	Date Slutt = new Date();
	int Tid = (int) (Slutt.getTime() - Start.getTime());
	if (Tid > 0) {
	    //System.out.println( this.getClass().toString()+" FinnDescription Arbeidstid="+Tid );
	}
    }

    @Override
    public void FinnKeywords(String Buffer) {
	Date Start = new Date();
	if (Buffer.indexOf("<meta name=\"description\" content=\"") > -1) {
	    Jobb.TargetOffer.Meta =
		    Buffer.substring(Buffer.indexOf("<meta name=\"description\" content=\"")
			    + "<meta name=\"description\" content=\"".length());
	    Jobb.TargetOffer.Meta = Jobb.TargetOffer.Meta.substring(0, 300);
	    if (Jobb.TargetOffer.Meta.indexOf("\" />") > -1) {
		Jobb.TargetOffer.Meta = Jobb.TargetOffer.Meta.substring(0, Jobb.TargetOffer.Meta.indexOf("\" />"));
		Jobb.TargetOffer.Meta = Jobb.TargetOffer.Meta.toLowerCase();
	    } else {
		//System.out.println( this.getClass().toString()+" FinnKeywords fant ikke keywords: "+Jobb.TargetOffer.Meta );
		//System.out.println( this.getClass().toString()+" FinnKeywords adresse="+Jobb.TargetOffer.Get_Adresse().Get_Adresse().toString() );
	    }
	}
	Date Slutt = new Date();
	int Tid = (int) (Slutt.getTime() - Start.getTime());
	if (Tid > 0) {
	    //System.out.println( this.getClass().toString()+" FinnKeywords Arbeidstid="+Tid );
	}
    }

    @Override
    public void FinnTittel(String Buffer) {
	Date Start = new Date();
	try {
	    Jobb.TargetOffer.Head = Buffer.substring(0, Buffer.indexOf("</head>"));
	    Jobb.TargetOffer.Head = Jobb.TargetOffer.Head.substring(Jobb.TargetOffer.Head.indexOf("<head>"));
	    Jobb.TargetOffer.Head = Jobb.TargetOffer.Head.substring(0, Jobb.TargetOffer.Head.indexOf("</title>"));
	    Jobb.TargetOffer.Head = Jobb.TargetOffer.Head.substring(Jobb.TargetOffer.Head.indexOf("<title>") + "<title>".length());
	    Jobb.TargetOffer.Head = Jobb.TargetOffer.Head.toLowerCase();
	} catch (Exception T) {
	    //System.out.println( this.getClass().toString()+" FinnTittel no </head>: "+Jobb.TargetOffer.Get_Adresse().Get_Adresse().toString() );
	}
	Date Slutt = new Date();
	int Tid = (int) (Slutt.getTime() - Start.getTime());
	if (Tid > 0) {
	    //System.out.println( this.getClass().toString()+" FinnTittel Arbeidstid="+Tid );
	}
    }

    @Override
    public void FinnItemType(String Buffer) throws Exception {
	Date Start = new Date();
	try {
	    //CRUMBS
	    if (Buffer.indexOf("aliGlobalCrumb".toLowerCase()) > -1) {
		Jobb.TargetOffer.Crumbs = Buffer.substring(Buffer.indexOf("aliGlobalCrumb".toLowerCase()) + "aliGlobalCrumb".length());
	    }
	    //module m-sop m-sop-crumb
	    if (Buffer.indexOf("module m-sop m-sop-crumb".toLowerCase()) > -1) {
		Jobb.TargetOffer.Crumbs =
			Buffer.substring(Buffer.indexOf("module m-sop m-sop-crumb".toLowerCase()) + "module m-sop m-sop-crumb".length());
	    } else if (Buffer.indexOf("http://www.aliexpress.com/\">Home".toLowerCase()) > -1) {
		Jobb.TargetOffer.Crumbs =
			Buffer.substring(Buffer.indexOf("http://www.aliexpress.com/\">Home".toLowerCase())
				+ "http://www.aliexpress.com/\">".length());
	    } else if (Buffer.indexOf("bread_crumb".toLowerCase()) > -1) {
		Jobb.TargetOffer.Crumbs = Buffer.substring(Buffer.indexOf("bread_crumb".toLowerCase()) + "bread_crumb".length());
	    } else if (Buffer.indexOf("crumb global".toLowerCase()) > -1) {
		Jobb.TargetOffer.Crumbs = Buffer.substring(Buffer.indexOf("crumb global".toLowerCase()) + "crumb global".length());
	    } else if (Buffer.indexOf("breadcrumb".toLowerCase()) > -1) {
		Jobb.TargetOffer.Crumbs = Buffer.substring(Buffer.indexOf("breadcrumb".toLowerCase()) + "breadcrumb".length());
	    } else if (Buffer.indexOf("ui-breadcrumb".toLowerCase()) > -1) {
		Jobb.TargetOffer.Crumbs = Buffer.substring(Buffer.indexOf("ui-breadcrumb".toLowerCase()) + "ui-breadcrumb".length());
	    } else {
		//System.out.println( "Forkaster URL pga ingen crumbs: "+Jobb.Get_Adresse().toString()+"->"+Buffer.indexOf( "http://www.aliexpress.com/\">Home".toLowerCase() ) );
		ForkastURL(Buffer, "No crumbs found");
		return;
	    }
	    //bearbeid crumbs
	    while (Jobb.TargetOffer.Crumbs.indexOf("	") > -1) {
		Jobb.TargetOffer.Crumbs = Jobb.TargetOffer.Crumbs.replaceAll("	", " ");
	    }
	    while (Jobb.TargetOffer.Crumbs.indexOf("  ") > -1) {
		Jobb.TargetOffer.Crumbs = Jobb.TargetOffer.Crumbs.replaceAll("  ", " ");
	    }
	    if (Jobb.TargetOffer.Crumbs.indexOf("</div>") > -1) {
		Jobb.TargetOffer.Crumbs = Jobb.TargetOffer.Crumbs.substring(0, Jobb.TargetOffer.Crumbs.indexOf("</div>"));
	    }
	    //System.out.println( this.getClass().toString()+" FinnItemType "+Jobb.Get_Adresse().toString()+" Crumbs A1: "+Jobb.TargetOffer.Crumbs );
	    if (Jobb.TargetOffer.Crumbs.toLowerCase().indexOf("home") > -1) {
		Jobb.TargetOffer.Crumbs = Jobb.TargetOffer.Crumbs.substring(Jobb.TargetOffer.Crumbs.toLowerCase().indexOf("home"));
	    }
	    if (Jobb.TargetOffer.Crumbs.indexOf("</h1>") > -1) {
		Jobb.TargetOffer.Crumbs = Jobb.TargetOffer.Crumbs.substring(0, Jobb.TargetOffer.Crumbs.indexOf("</h1>"));
	    }
	    if (Jobb.TargetOffer.Crumbs.indexOf("</h2>") > -1) {
		Jobb.TargetOffer.Crumbs = Jobb.TargetOffer.Crumbs.substring(0, Jobb.TargetOffer.Crumbs.indexOf("</h2>"));
	    }
	    if (Jobb.TargetOffer.Crumbs.lastIndexOf("</span>") > -1) {
		Jobb.TargetOffer.Crumbs = Jobb.TargetOffer.Crumbs.substring(0, Jobb.TargetOffer.Crumbs.lastIndexOf("</span>"));
	    }
	    if (Jobb.TargetOffer.Crumbs.lastIndexOf("</b>") > -1) {
		Jobb.TargetOffer.Crumbs = Jobb.TargetOffer.Crumbs.substring(0, Jobb.TargetOffer.Crumbs.lastIndexOf("</b>"));
	    }
	    //System.out.println( this.getClass().toString()+" FinnItemType "+Jobb.Get_Adresse().toString()+" Crumbs A2: "+Jobb.TargetOffer.Crumbs );
	    //CATEGORY
	    Jobb.TargetOffer.Category = Jobb.TargetOffer.Crumbs;
	    if (Jobb.TargetOffer.Category.lastIndexOf("<span>") > -1) {
		Jobb.TargetOffer.Category =
			Jobb.TargetOffer.Category.substring(Jobb.TargetOffer.Category.lastIndexOf("<span> ") + "<span> ".length());
	    }
	    if (Jobb.TargetOffer.Category.lastIndexOf("<b>") > -1) {
		Jobb.TargetOffer.Category =
			Jobb.TargetOffer.Category.substring(Jobb.TargetOffer.Category.lastIndexOf("<b>") + "<b>".length());
	    }
	    if (Jobb.TargetOffer.Category.lastIndexOf("<h2>") > -1) {
		Jobb.TargetOffer.Category =
			Jobb.TargetOffer.Category.substring(Jobb.TargetOffer.Category.lastIndexOf("<h2>") + "<h2>".length());
	    }
	    if (Jobb.TargetOffer.Category.lastIndexOf("\" >") > -1) {
		Jobb.TargetOffer.Category =
			Jobb.TargetOffer.Category.substring(Jobb.TargetOffer.Category.lastIndexOf("\" >") + "\" >".length());
	    }
	    if (Jobb.TargetOffer.Category.lastIndexOf("</a>") > -1) {
		Jobb.TargetOffer.Category = Jobb.TargetOffer.Category.substring(0, Jobb.TargetOffer.Category.lastIndexOf("</a>"));
	    }
	    //System.out.println( this.getClass().toString()+" FinnItemType Category A="+Jobb.Get_Adresse().toString()+" Category="+Jobb.TargetOffer.Category );
	    //PARENTCATEGORY
	    Jobb.TargetOffer.ParentCategory = Jobb.TargetOffer.Crumbs;
	    Jobb.TargetOffer.ParentCategory =
		    Jobb.TargetOffer.ParentCategory =
			    Jobb.TargetOffer.ParentCategory.substring(0,
				    Jobb.TargetOffer.ParentCategory.lastIndexOf(Jobb.TargetOffer.Category));
	    if (Jobb.TargetOffer.ParentCategory.lastIndexOf("<span>") > -1) {
		Jobb.TargetOffer.ParentCategory =
			Jobb.TargetOffer.ParentCategory.substring(0, Jobb.TargetOffer.ParentCategory.lastIndexOf("<span>"));
	    }
	    if (Jobb.TargetOffer.ParentCategory.lastIndexOf("<b>") > -1) {
		Jobb.TargetOffer.ParentCategory =
			Jobb.TargetOffer.ParentCategory.substring(0, Jobb.TargetOffer.ParentCategory.lastIndexOf("<b>"));
	    }
	    if (Jobb.TargetOffer.ParentCategory.lastIndexOf("</a>") > -1) {
		Jobb.TargetOffer.ParentCategory =
			Jobb.TargetOffer.ParentCategory.substring(0, Jobb.TargetOffer.ParentCategory.lastIndexOf("</a>"));
	    }
	    if (Jobb.TargetOffer.ParentCategory.lastIndexOf("\"> ") > -1) {
		Jobb.TargetOffer.ParentCategory =
			Jobb.TargetOffer.ParentCategory.substring(Jobb.TargetOffer.ParentCategory.lastIndexOf("\"> ") + "\"> ".length());
	    }
	    if (Jobb.TargetOffer.ParentCategory.lastIndexOf("\">") > -1) {
		Jobb.TargetOffer.ParentCategory =
			Jobb.TargetOffer.ParentCategory.substring(Jobb.TargetOffer.ParentCategory.lastIndexOf("\">") + "\">".length());
	    }
	    if (Jobb.TargetOffer.ParentCategory.lastIndexOf("html") > -1) {
		Jobb.TargetOffer.ParentCategory =
			Jobb.TargetOffer.ParentCategory.substring(Jobb.TargetOffer.ParentCategory.lastIndexOf("html") + "html".length());
	    }
	    //System.out.println( this.getClass().toString()+" FinnItemType ParentCategory A="+Jobb.Get_Adresse().toString()+" ParentCategory="+Jobb.TargetOffer.ParentCategory );
	    //FERDIG
	    /*System.out.println( this.getClass().toString()+" FinnItemType sjekker resultater: "+Jobb.Get_Adresse().toString() );
	    System.out.println( this.getClass().toString()+" FinnItemType 1 Crumbs="+Jobb.TargetOffer.Crumbs );
	    System.out.println( this.getClass().toString()+" FinnItemType 2 Category="+Jobb.TargetOffer.Category );
	    System.out.println( this.getClass().toString()+" FinnItemType 3 ParentCategory="+Jobb.TargetOffer.ParentCategory );*/
	    //System.out.println( "ItemType="+Jobb.TargetOffer.Category+" <-"+Jobb.Get_Adresse().toString() );
	    if (this.Class_Controller.Get_SelectedSearchtype(this.getClass().toString() + " FinnItemType").equals("Full crawl") == false) {
		Jobb.TargetOffer.Get_Adresse().Set_AcceptedCategory(
			Jobb.ItemTypeAccepted(Jobb.TargetOffer, Jobb.TargetOffer.Category, Jobb.TargetOffer.ParentCategory,
				Jobb.TargetOffer.Crumbs), "Matched versus category", Class_Controller, Jobb.TargetOffer.Category);
	    } else {
		Jobb.TargetOffer.Get_Adresse().Set_AcceptedCategory(true, "fits category", Class_Controller, Jobb.TargetOffer.Category);
	    }
	    //System.out.println( this.getClass().toString()+" FinnItemType SelectedSearchtype="+Class_Controller.Get_SelectedSearchtype() );
	    if (Jobb.TargetOffer.Get_Adresse().Get_AcceptedCategory() == false) {
		ForkastURL(Buffer, "unwanted item type2");
		return;
	    }
	} catch (Exception T) {
	    if (this.Class_Controller.Get_SelectedSearchtype(this.getClass().toString() + " FinnItemType").equals("Full crawl") == false) {
		Jobb.TargetOffer.Get_Adresse().Set_AcceptedCategory(false, "Category not found. ", Class_Controller,
			Jobb.TargetOffer.Category);
		//System.out.println( "Forkaster URL pga ItemType B: "+Jobb.Get_Adresse().toString()+"->"+Jobb.TargetOffer.Category );
		ForkastURL(Buffer, "unwanted item type2");
		return;
	    } else {
		Jobb.TargetOffer.Get_Adresse().Set_AcceptedCategory(true, "fits category", Class_Controller, Jobb.TargetOffer.Category);
	    }
	    this.Class_Controller.ReportError(T, this.getClass().toString() + " FinnItemType");
	}
	Date Slutt = new Date();
	int Tid = (int) (Slutt.getTime() - Start.getTime());
	if (Tid > 0) {
	    //System.out.println( this.getClass().toString()+" FinnItemType Arbeidstid="+Tid );
	}
    }

    @Override
    public void FinnPris(String Buffer) throws Exception {
	boolean MinOrder20 = false;
	if (Buffer.indexOf("min order 20".toLowerCase()) > -1) {
	    MinOrder20 = true;
	}
	if (Buffer.indexOf("min-order-20".toLowerCase()) > -1) {
	    MinOrder20 = true;
	}
	if (Buffer.indexOf("min. order 20".toLowerCase()) > -1) {
	    MinOrder20 = true;
	}
	if (Buffer.indexOf("min. order is 20".toLowerCase()) > -1) {
	    MinOrder20 = true;
	}
	if (Buffer.indexOf("min order $20".toLowerCase()) > -1) {
	    MinOrder20 = true;
	}
	if (Buffer.indexOf("min.order is $20".toLowerCase()) > -1) {
	    MinOrder20 = true;
	}
	if (Buffer.indexOf("moq 20 $".toLowerCase()) > -1) {
	    MinOrder20 = true;
	}
	if (Buffer.indexOf("min order is 20usd".toLowerCase()) > -1) {
	    MinOrder20 = true;
	}
	if (Buffer.indexOf("at least $20".toLowerCase()) > -1) {
	    MinOrder20 = true;
	}
	boolean MinOrder15 = false;
	if (Buffer.indexOf("min order 15".toLowerCase()) > -1) {
	    MinOrder15 = true;
	}
	if (Buffer.indexOf("min-order-15".toLowerCase()) > -1) {
	    MinOrder15 = true;
	}
	if (Buffer.indexOf("min. order 15".toLowerCase()) > -1) {
	    MinOrder15 = true;
	}
	if (Buffer.indexOf("min. order is 15".toLowerCase()) > -1) {
	    MinOrder15 = true;
	}
	if (Buffer.indexOf("min order $15".toLowerCase()) > -1) {
	    MinOrder15 = true;
	}
	if (Buffer.indexOf("min.order is $15".toLowerCase()) > -1) {
	    MinOrder15 = true;
	}
	if (Buffer.indexOf("moq 15 $".toLowerCase()) > -1) {
	    MinOrder15 = true;
	}
	if (Buffer.indexOf("min order is 15usd".toLowerCase()) > -1) {
	    MinOrder15 = true;
	}
	if (Buffer.indexOf("at least $15".toLowerCase()) > -1) {
	    MinOrder15 = true;
	}
	boolean MinOrder10 = false;
	if (Buffer.indexOf("min order 10".toLowerCase()) > -1) {
	    MinOrder10 = true;
	}
	if (Buffer.indexOf("min-order-10".toLowerCase()) > -1) {
	    MinOrder10 = true;
	}
	if (Buffer.indexOf("min. order 10".toLowerCase()) > -1) {
	    MinOrder10 = true;
	}
	if (Buffer.indexOf("min. order is 10".toLowerCase()) > -1) {
	    MinOrder10 = true;
	}
	if (Buffer.indexOf("min order $10".toLowerCase()) > -1) {
	    MinOrder10 = true;
	}
	if (Buffer.indexOf("min.order is $10".toLowerCase()) > -1) {
	    MinOrder10 = true;
	}
	if (Buffer.indexOf("moq 10 $".toLowerCase()) > -1) {
	    MinOrder10 = true;
	}
	if (Buffer.indexOf("min order is 10usd".toLowerCase()) > -1) {
	    MinOrder10 = true;
	}
	if (Buffer.indexOf("at least $10".toLowerCase()) > -1) {
	    MinOrder10 = true;
	}
	if (Buffer.indexOf("at least $8".toLowerCase()) > -1) {
	    MinOrder10 = true;
	}
	Date Start = new Date();
	String TotalCosts_String;
	double TotalCosts_doub;
	TotalCosts_String = Buffer;
	if (TotalCosts_String.indexOf("id=\"sku-price\" itemprop=\"price\">".toLowerCase()) > -1) {
	    TotalCosts_String =
		    TotalCosts_String
			    .substring((TotalCosts_String.indexOf("id=\"sku-price\" itemprop=\"price\">") + "id=\"sku-price\" itemprop=\"price\">"
				    .length()));
	}
	/*
	if ( TotalCosts_String.indexOf( "<span itemprop=\"highPrice\">".toLowerCase() ) > -1 ) {
		TotalCosts_String = TotalCosts_String.substring( (TotalCosts_String.indexOf( "<span itemprop=\"highPrice\">" ) + "<span itemprop=\"highPrice\">".length()) );
	}
	if ( TotalCosts_String.indexOf( "sku-price\">".toLowerCase() ) > -1 ) {
		TotalCosts_String = TotalCosts_String.substring( (TotalCosts_String.indexOf( "sku-price\">" ) + "sku-price\">".length()) );
	}
	if ( TotalCosts_String.indexOf( "sku-price\">".toLowerCase() ) > -1 ) {
		TotalCosts_String = TotalCosts_String.substring( (TotalCosts_String.indexOf( "sku-price\">" ) + "sku-price\">".length()) );
	}
	
	if ( TotalCosts_String.indexOf( "</span>".toLowerCase() ) > -1 ) {
		TotalCosts_String = TotalCosts_String.substring( (TotalCosts_String.indexOf( "</span>" ) + "</span>".length()) );
	}
	*/
	TotalCosts_String = TotalCosts_String.replaceAll(",", "");
	try {
	    TotalCosts_doub = Double.parseDouble(TotalCosts_String);
	    Jobb.TargetOffer.Price = TotalCosts_doub;
	} catch (Exception E) {
	    System.out.println(this.getClass().toString() + " FinnPris ="
		    + TotalCosts_String.substring(0, Math.min(TotalCosts_String.length(), 100)));
	    ForkastURL(Buffer, "no price");
	    return;
	}
	if (MinOrder10 == true) {
	    Jobb.TargetOffer.Price = Math.max(10, Jobb.TargetOffer.Price);
	}
	if (MinOrder15 == true) {
	    Jobb.TargetOffer.Price = Math.max(15, Jobb.TargetOffer.Price);
	}
	if (MinOrder20 == true) {
	    Jobb.TargetOffer.Price = Math.max(20, Jobb.TargetOffer.Price);
	}
	try {
	    Date Slutt = new Date();
	    int Tid = (int) (Slutt.getTime() - Start.getTime());
	    if (Tid > 0) {
		//System.out.println( this.getClass().toString()+" FinnPris Arbeidstid="+Tid );
	    }
	} catch (Exception t) {
	}
    }

    @Override
    public void FinnSelger(String Buffer) throws Exception {
	String Seller = "";
	//finn store number
	if (Buffer.indexOf("<div id=\"store-no\" class=\"number-title\">".toLowerCase()) > -1) {
	    Seller = Buffer;
	    Seller =
		    Seller.substring(Seller.indexOf("<div id=\"store-no\" class=\"number-title\">".toLowerCase())
			    + "<div id=\"store-no\" class=\"number-title\">".length());
	} else if (Buffer.indexOf("<span class=\"shop-number\">".toLowerCase()) > -1) {
	    //<span class="shop-number">Store No.917403</span>
	    Seller = Buffer;
	    Seller =
		    Seller.substring(Seller.indexOf("<span class=\"shop-number\">".toLowerCase()) + "<span class=\"shop-number\">".length());
	} else if (Buffer.indexOf("aliexpress.com/store/".toLowerCase()) > -1) {
	    //<a class="store-lnk" title="Guangzhou Vanko Industry Ltd" href="http://www.aliexpress.com/store/203226" target="_blank">Guangzhou Vanko Industry Ltd</a>
	    //<a class="store-lnk" title="Asia Best Perfect Shopping (HK) LTD" href="http://www.aliexpress.com/store/725013"
	    Seller = Buffer.substring(Buffer.indexOf("aliexpress.com/store/".toLowerCase()) + "aliexpress.com/store/".length());
	    //203226" target="_blank">Guangzhou Vanko Industry Ltd</a>
	    Seller = Seller.substring(0, Seller.indexOf("\"".toLowerCase()));
	    //203226
	} else {
	    //System.out.println( this.getClass().toString()+" FinnSelger Finner ikke selger. "+Jobb.Get_Adresse().toString() );
	}
	//bearbeid store number
	if (Seller.indexOf("</div>".toLowerCase()) > -1) {
	    Seller = Seller.substring(0, Seller.indexOf("</div>".toLowerCase()));
	}
	if (Seller.indexOf("</span>".toLowerCase()) > -1) {
	    Seller = Seller.substring(0, Seller.indexOf("</span>".toLowerCase()));
	}
	if (Seller.indexOf("feedback-score/".toLowerCase()) > -1) {
	    Seller = Seller.substring(Seller.indexOf("feedback-score/".toLowerCase()) + "feedback-score/".length());
	}
	if (Seller.indexOf(".html".toLowerCase()) > -1) {
	    Seller = Seller.substring(0, Seller.indexOf(".html".toLowerCase()));
	}
	if (Seller.indexOf("Store No.".toLowerCase()) > -1) {
	    Seller = Seller.substring(Seller.indexOf("Store No.".toLowerCase()) + "Store No.".length());
	}
	Jobb.TargetOffer.Seller = Seller;
	//System.out.println( this.getClass().toString()+" FinnSelger selger->"+Jobb.TargetOffer.Seller );
	if (Class_Controller.IsAcceptedSeller(Jobb.TargetOffer.Seller) == false) {
	    //System.out.println( "Forkaster URL pga selger: "+Jobb.Get_Adresse().toString()+"->"+Jobb.TargetOffer.Seller );
	    ForkastURL(Buffer, "unwanted seller");
	    return;
	}
    }

    @Override
    public void FinnOptions(String buffer) {
	if (buffer.indexOf("<dl class=\"sku-row\">".toLowerCase()) > -1) {
	    Jobb.TargetOffer.OptionsText = buffer.substring(buffer.indexOf("<dl class=\"sku-row\">".toLowerCase()));
	}
	if (Jobb.TargetOffer.OptionsText.indexOf("quantity:".toLowerCase()) > -1) {
	    Jobb.TargetOffer.OptionsText =
		    Jobb.TargetOffer.OptionsText.substring(0, Jobb.TargetOffer.OptionsText.indexOf("quantity:".toLowerCase()));
	    Jobb.TargetOffer.OptionsText = Jobb.TargetOffer.OptionsText.substring(0, Jobb.TargetOffer.OptionsText.lastIndexOf("<dl>"));
	}
    }

    @Override
    public void FinnAntall(String buffer) throws Exception {
	//<span class="unit-disc">10 pieces / lot , $<span
	if (buffer.indexOf("<span class=\"unit-disc\">".toLowerCase()) > -1) {
	    Jobb.TargetOffer.Set_Antall(
		    buffer.substring(buffer.indexOf("<span class=\"unit-disc\">".toLowerCase()) + "<span class=\"unit-disc\">".length()),
		    this.getClass().toString());
	    Jobb.TargetOffer.Set_Antall(Jobb.TargetOffer.Get_Antall().substring(0, 10), this.getClass().toString());
	    if (Jobb.TargetOffer.Get_Antall().indexOf("<".toLowerCase()) > 0) {
		Jobb.TargetOffer.Set_Antall(
			Jobb.TargetOffer.Get_Antall().substring(0, Jobb.TargetOffer.Get_Antall().indexOf("<".toLowerCase())), this
				.getClass().toString());
	    }
	    if (Jobb.TargetOffer.OptionsText.lastIndexOf(" pieces") > -1) {
		Jobb.TargetOffer.Set_Antall(Jobb.TargetOffer.OptionsText.substring(0, Jobb.TargetOffer.OptionsText.lastIndexOf(" pieces")),
			this.getClass().toString());
	    } else {
	    }
	    while (Jobb.TargetOffer.Get_Antall().indexOf("	") > -1) {
		Jobb.TargetOffer.Set_Antall(Jobb.TargetOffer.Get_Antall().replaceAll("	", ""), this.getClass().toString());
	    }
	    while (Jobb.TargetOffer.Get_Antall().indexOf("  ") > -1) {
		Jobb.TargetOffer.Set_Antall(Jobb.TargetOffer.Get_Antall().replaceAll("  ", ""), this.getClass().toString());
	    }
	    if (Jobb.TargetOffer.Get_Antall().equals("")) {
		Jobb.TargetOffer.Set_Antall("1", this.getClass().toString());
	    }
	    //System.out.println( this.getClass().toString()+" FinnAntall Antall="+Jobb.TargetOffer.Get_Antall()+" length="+Jobb.TargetOffer.Get_Antall().length() );
	}
	if (Jobb.TargetOffer.Get_Antall().equals("") == false) {
	    try {
		if (Integer.parseInt(Jobb.TargetOffer.Antall) > 2) {
		    //System.out.println( "Forkaster URL pga selger: "+Jobb.Get_Adresse().toString()+"->"+Jobb.TargetOffer.Seller );
		    ForkastURL(buffer, "too many products");
		    return;
		}
	    } catch (Exception E) {
		ForkastURL(buffer, "too many products");
		return;
	    }
	}
    }
}
