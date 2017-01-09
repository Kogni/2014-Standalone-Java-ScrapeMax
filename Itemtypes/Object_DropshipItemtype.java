package Itemtypes;

import java.io.Serializable;

public class Object_DropshipItemtype implements Serializable {

	private static final long serialVersionUID = 1694981071016505185L;
	
	public String Dropship_Category;
	public String Dropship_ParentCategory;
	public String Dropship_HomePage;
	public String Norsk_Subject;
	boolean	Enabled = false;
	
	public Object_DropshipItemtype( String category, String ParentCategory, String HomePage, String Subject ) {
		this.Dropship_Category = category;
		this.Dropship_ParentCategory = ParentCategory;
		this.Dropship_HomePage = HomePage;
		this.Norsk_Subject = Subject;
	}
	
}
