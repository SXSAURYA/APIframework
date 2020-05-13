package pojos;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

public class Place {

	@JsonInclude(JsonInclude.Include.NON_NULL)
	
	@JsonPropertyOrder({
	  "location",
	  "accuracy",
	  "name",
	  "phone_number",
	  "address",
	  "types",
	  "website",
	  "language"
	})
	
	@JsonProperty("location")
	private Location location;
	@JsonProperty("accuracy")
	private int accuracy;
	@JsonProperty("name")
	private String name;
	@JsonProperty("phone_number")
	private String phonenumber;
	@JsonProperty("address")
	private String address;
	@JsonProperty("types")
	private List<String> types;
	@JsonProperty("website")
	private String website;
	@JsonProperty("language")
	private String language;
	
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	public int getAccuracy() {
		return accuracy;
	}
	public void setAccuracy(int accuracy) {
		this.accuracy = accuracy;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone_number() {
		return phonenumber;
	}
	public void setPhone_number(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public List<String> getTypes() {
		return types;
	}
	public void setTypes(List<String> types) {
		this.types = types;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	
}
