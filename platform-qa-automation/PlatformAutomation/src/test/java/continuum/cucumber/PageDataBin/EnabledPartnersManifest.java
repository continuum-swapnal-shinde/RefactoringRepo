package continuum.cucumber.PageDataBin;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EnabledPartnersManifest {
	
	@JsonProperty(value = "partners", access = JsonProperty.Access.READ_WRITE)
    private String[] partners;
	
	public String[] getPartnerId() {
		return partners;
	}

	public EnabledPartnersManifest setPartnerId(String []partners) {
		this.partners = partners;	
		return this;
	}

}
