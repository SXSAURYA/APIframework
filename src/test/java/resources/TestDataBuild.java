package resources;

import java.util.ArrayList;
import java.util.Arrays;

import pojos.Location;
import pojos.Place;

public class TestDataBuild {

	
	public Place addPlacePayload(String name, String lng, String add) {
		Place p = new Place();
		Location l = new Location();
		l.setLat(-38.383494);
		l.setLng(33.427362);
		p.setLocation(l);
		p.setAccuracy(50);
		p.setName(name);
		p.setPhone_number("(+91) 983 893 3937");
		p.setAddress(lng);
		p.setTypes(new ArrayList<String>(Arrays.asList("shoe park", "shop")));
		p.setWebsite("http://google.com");
		p.setLanguage(add);
		return p;
	}
	
	public String deletePlacePayload(String place_id) {
		return "{\r\n" + 
				"    \"place_id\":\""+place_id+"\" \r\n" + 
				"}";
	}
}
