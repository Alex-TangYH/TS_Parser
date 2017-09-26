package com.alex.ts_parser.bean.descriptor;

import java.util.HashMap;
import java.util.Map;

public class ContentNibbleLevelMap {
	public static Map<Integer, String> contentNibbleLevel1Map = new HashMap<Integer, String>();
	public static Map<Integer, String> contentNibbleLevel2Map = new HashMap<Integer, String>();

	static {
		contentNibbleLevel1Map.put(0x1, "Movie/Drama");
		contentNibbleLevel1Map.put(0x2, "News/Current affairs");
		contentNibbleLevel1Map.put(0x3, "Show/Game show");
		contentNibbleLevel1Map.put(0x4, "Sports");
		contentNibbleLevel1Map.put(0x5, "Children's/Youth programmes");
		contentNibbleLevel1Map.put(0x6, "Music/Ballet/Dance");
		contentNibbleLevel1Map.put(0x7, "Arts/Culture");
		contentNibbleLevel1Map.put(0x8, "Social/Political issues/Economics");
		contentNibbleLevel1Map.put(0x9, "Education/Science/Factual topics");
		contentNibbleLevel1Map.put(0xa, "Leisure hobbies");
		contentNibbleLevel1Map.put(0xb, "Special characteristics");
	}
	
	static {
		// Movie/Drama
		contentNibbleLevel2Map.put(0x10, "movie/drama (general)");
		contentNibbleLevel2Map.put(0x11, "detective/thriller");
		contentNibbleLevel2Map.put(0x12, "adventure/western/war");
		contentNibbleLevel2Map.put(0x13, "science fiction/fantasy/horror");
		contentNibbleLevel2Map.put(0x14, "comedy");
		contentNibbleLevel2Map.put(0x15, "soap/melodrama/folkloric");
		contentNibbleLevel2Map.put(0x16, "romance");
		contentNibbleLevel2Map.put(0x17, "serious/classical/religious/historical movie/drama");
		contentNibbleLevel2Map.put(0x18, "adult movie/drama");
		
		// News/Current affairs
		contentNibbleLevel2Map.put(0x20, "news/current affairs (general)");
		contentNibbleLevel2Map.put(0x21, "news/weather report");
		contentNibbleLevel2Map.put(0x22, "news magazine");
		contentNibbleLevel2Map.put(0x23, "documentary");
		contentNibbleLevel2Map.put(0x24, "discussion/interview/debate");
		
		// Show/Game show
		contentNibbleLevel2Map.put(0x30, "show/game show (general)");
		contentNibbleLevel2Map.put(0x31, "game show/quiz/contest");
		contentNibbleLevel2Map.put(0x32, "variety show");
		contentNibbleLevel2Map.put(0x33, "talk show");
		
		// Sports
		contentNibbleLevel2Map.put(0x40, "sports (general)");
		contentNibbleLevel2Map.put(0x41, "special events (Olympic Games,World Cup, etc)");
		contentNibbleLevel2Map.put(0x42, "sports agazines");
		contentNibbleLevel2Map.put(0x43, "football/soccer");
		contentNibbleLevel2Map.put(0x44, "tennis/squash");
		contentNibbleLevel2Map.put(0x45, "team sports (excluding football)");
		contentNibbleLevel2Map.put(0x46, "athletics");
		contentNibbleLevel2Map.put(0x47, "motor sport");
		contentNibbleLevel2Map.put(0x48, "watrer sport");
		contentNibbleLevel2Map.put(0x49, "winter sport");
		contentNibbleLevel2Map.put(0x4a, "equestrian");
		contentNibbleLevel2Map.put(0x4b, "martial sports");
		
		// Children's/Youth programmes
		contentNibbleLevel2Map.put(0x50, "children's/youth programmes (general)");
		contentNibbleLevel2Map.put(0x51, "pre-school children's programmes");
		contentNibbleLevel2Map.put(0x52, "entertainment programmes for 6 to 14");
		contentNibbleLevel2Map.put(0x53, "entertainment programmes for 10 to 16");
		contentNibbleLevel2Map.put(0x54, "informational/educational/school programmes");
		contentNibbleLevel2Map.put(0x55, "catoons/puppets");
		
		// Music/Ballet/Dance
		contentNibbleLevel2Map.put(0x60, "music/ballet/Dance (general)");
		contentNibbleLevel2Map.put(0x61, "rock/pop");
		contentNibbleLevel2Map.put(0x62, "serious music/classical music");
		contentNibbleLevel2Map.put(0x63, "folk/traditional music");
		contentNibbleLevel2Map.put(0x64, "jazz");
		contentNibbleLevel2Map.put(0x65, "musical/opera");
		contentNibbleLevel2Map.put(0x66, "ballet");
		
		// Arts/Culture
		contentNibbleLevel2Map.put(0x70, "arts/culture (without music, general)");
		contentNibbleLevel2Map.put(0x71, "performing arts");
		contentNibbleLevel2Map.put(0x72, "fine arts");
		contentNibbleLevel2Map.put(0x73, "religion");
		contentNibbleLevel2Map.put(0x74, "popular culture/traditional arts");
		contentNibbleLevel2Map.put(0x75, "literature");
		contentNibbleLevel2Map.put(0x76, "film/cinema");
		contentNibbleLevel2Map.put(0x77, "experimental film/video");
		contentNibbleLevel2Map.put(0x78, "broadcasting/press");
		contentNibbleLevel2Map.put(0x79, "new media");
		contentNibbleLevel2Map.put(0x7a, "arts/culture magazines");
		contentNibbleLevel2Map.put(0x7b, "fashion");
		
		// Social/Political issues/Economics
		contentNibbleLevel2Map.put(0x80, "social/political issues/economics (general)");
		contentNibbleLevel2Map.put(0x81, "magazines/reports/documentary");
		contentNibbleLevel2Map.put(0x82, "economics/social advisory");
		contentNibbleLevel2Map.put(0x83, "remarkable people");
		
		// Education/Science/Factual topics
		contentNibbleLevel2Map.put(0x90, "education/science/factual topics (general)");
		contentNibbleLevel2Map.put(0x91, "nature/animals/environment");
		contentNibbleLevel2Map.put(0x92, "technology/natural sciences");
		contentNibbleLevel2Map.put(0x93, "medicine/physiology/psychology");
		contentNibbleLevel2Map.put(0x94, "foreign countries/expeditions");
		contentNibbleLevel2Map.put(0x95, "social/spiritual sciences");
		contentNibbleLevel2Map.put(0x96, "further education");
		contentNibbleLevel2Map.put(0x97, "languages");
		
		// Leisure hobbies
		contentNibbleLevel2Map.put(0xa0, "leisure hobbies (general)");
		contentNibbleLevel2Map.put(0xa1, "tourism/travel");
		contentNibbleLevel2Map.put(0xa2, "handicraft");
		contentNibbleLevel2Map.put(0xa3, "motoring");
		contentNibbleLevel2Map.put(0xa4, "fitness and health");
		contentNibbleLevel2Map.put(0xa5, "cooking");
		contentNibbleLevel2Map.put(0xa6, "advertisement/shopping");
		contentNibbleLevel2Map.put(0xa7, "gardening");
		
		// Special characteristics
		contentNibbleLevel2Map.put(0xa0, "original language");
		contentNibbleLevel2Map.put(0xa1, "black and white");
		contentNibbleLevel2Map.put(0xa2, "unpublished");
		contentNibbleLevel2Map.put(0xa3, "live broadcast");
	}
}
