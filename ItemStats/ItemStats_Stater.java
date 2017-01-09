package ItemStats;

public class ItemStats_Stater {

	Object_ItemStats_Stat[] Stater;
	
	public ItemStats_Stater() {
		
		Stater = new Object_ItemStats_Stat[100];
		InsertStater();
	}
	
	private void InsertStater() {
		InsertNewStat( "Tyskland", "germany", "tysk", "German" );
		InsertNewStat( "Korea", "korea", "koreansk", "Korean" );
		InsertNewStat( "&oslashsterrike", "austria", "&oslashsterrisk", "Austrian" );
		InsertNewStat( "Karibien", "Caribbean", "karibisk", "caribbean" );
		InsertNewStat( "Thailand", "Thailand", "thai", "thai" );
		InsertNewStat( "Kina", "China", "kinesisk", "chinese" );
		InsertNewStat( "Amerika", "America", "amerikansk", "american" );
		InsertNewStat( "Japan", "japan", "japansk", "japanese" );
		InsertNewStat( "Russland", "Russia", "russisk", "russian" );
		InsertNewStat( "Sovjet", "soviet", "sovjetisk", "Soviet" );
		InsertNewStat( "Brittania", "Britain", "britisk", "british" );
		InsertNewStat( "Italia", "Italy", "italiensk", "italian" );
		InsertNewStat( "Frankrike", "france", "fransk", "French" );
		InsertNewStat( "Irak", "iraq", "irakisk", "iraqian" );
		InsertNewStat( "Spania", "spain", "spansk", "spanish" );
		InsertNewStat( "Nederland", "netherlands", "nederlandsk", "dutch" );
		InsertNewStat( "Holland", "holland", "hollandsk", "dutch" );
		InsertNewStat( "Danmark", "denmark", "dansk", "danish" );
		InsertNewStat( "Sverige", "Sweden", "svensk", "swedish" );

	}
	
	private void InsertNewStat( String Egennavn_Norsk, String Egennavn_Engelsk, String Adjektiv_Norsk, String Adjektiv_Engelsk ) {
		for ( int X = 0 ; X <  Stater.length ; X++ ) {
			if ( Stater[X] == null ) {
				Stater[X] = new Object_ItemStats_Stat( Egennavn_Norsk, Egennavn_Engelsk, Adjektiv_Norsk, Adjektiv_Engelsk );
				return;
			}
		}
	}
	
	public Object_ItemStats_Stat[] HentStatListe_Objekter() {
		return Stater;
	}
}
