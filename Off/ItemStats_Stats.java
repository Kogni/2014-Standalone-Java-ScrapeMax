package Off;


public class ItemStats_Stats {
	
	Object_ItemStats_Stats[] Stats;
	
	public ItemStats_Stats() {
		
		Stats = new Object_ItemStats_Stats[100];
		InsertStater();
	}
	
	private void InsertStater() {
		InsertNewStat( "Tyskland", "Germany", "Tysk", "German" );
		InsertNewStat( "Korea", "Korea", "Koreansk", "Korean" );
		InsertNewStat( "&oslashsterrike", "Austria", "&oslashsterrisk", "Austrian" );
		InsertNewStat( "Karibien", "Caribbean", "Karibisk", "caribbean" );
		InsertNewStat( "Thailand", "Thailand", "Thai", "thai" );
		InsertNewStat( "Kina", "China", "Kinesisk", "chinese" );
		InsertNewStat( "Amerika", "America", "Amerikansk", "american" );
		InsertNewStat( "Japan", "Japan", "Japansk", "japanese" );
		InsertNewStat( "Russland", "Russia", "Russisk", "russian" );
		InsertNewStat( "Sovjet", "soviet", "Sovjetisk", "Soviet" );
		InsertNewStat( "Brittania", "Britain", "Britisk", "british" );
		InsertNewStat( "Italia", "Italy", "Italiensk", "italian" );
		InsertNewStat( "Frankrike", "france", "Fransk", "French" );

	}
	
	private void InsertNewStat( String Norsk, String Engelsk_1, String Engelsk_2 ) {
		for ( int X = 0 ; X <  Stats.length ; X++ ) {
			if ( Stats[X] == null ) {
				Stats[X] = new Object_ItemStats_Stats( Norsk, Engelsk_1, Engelsk_2 );
				return;
			}
		}
	}
	
	public Object_ItemStats_Stats[] HentStatListe_Objekter() {
		return Stats;
	}
}
