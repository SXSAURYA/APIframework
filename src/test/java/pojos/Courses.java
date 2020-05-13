package pojos;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Courses {
	@JsonProperty("webAutomation") private List<WebAutomation> webAutomation;
	@JsonProperty("api") private List<API> api;
	@JsonProperty("mobile") private List<Mobile> mobile;

	public List<WebAutomation> getWebautomation() {
		return webAutomation;
	}

	public void setWebautomation(List<WebAutomation> webautomation) {
		this.webAutomation = webautomation;
	}

	public List<API> getApi() {
		return api;
	}

	public void setApi(List<API> api) {
		this.api = api;
	}

	public List<Mobile> getMobile() {
		return mobile;
	}

	public void setMobile(List<Mobile> mobile) {
		this.mobile = mobile;
	}

}
