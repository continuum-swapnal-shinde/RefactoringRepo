package continuum.cucumber.stepDefinations.platform;

import org.json.JSONObject;
import org.testng.Assert;

import continuum.cucumber.Utilities;
import continuum.cucumber.Page.EntitlementHelper;
import continuum.cucumber.Page.GlobalVariables;
import continuum.cucumber.Page.HTTPUtility;
import continuum.cucumber.Page.JunoPageFactory;
import continuum.cucumber.reporting.ErrorReporter;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import sun.net.www.protocol.http.HttpURLConnection;

public class EntitlementStep extends GlobalVariables {

	public EntitlementStep(JunoPageFactory sshObj) {
		super(sshObj);
	}

	@When("^User send a POST request to create product as \"([^\"]*)\"$")
	public void i_send_a_Post_request_for_createProduct_API(String endpoint) throws Throwable {
		try {
			pluginHelper.POSTrequestToCreateProduct(endpoint);
		} catch (Exception e) {
			ErrorReporter.reportError(e);
		}
	}
	
	@Then("^User should fetch id from response$")
	public void i_should_fetch_response() throws Throwable {
		try {
			GlobalVariables.response = performanceAPI.getResponseOfWebService(GlobalVariables.conn);
			JSONObject obj = new JSONObject(GlobalVariables.response);
			GlobalVariables.scenario.write("\n\nResponse is :" + GlobalVariables.response);
			GlobalVariables.id=obj.getString("id");
			System.out.println(id);
		} catch (Exception e) {
			ErrorReporter.reportError(e);
		}
	}
	
	@When("^User send a POST request to create feature as \"([^\"]*)\"$")
	public void i_send_a_Post_request_for_createFeature_API(String endpoint) throws Throwable {
		try {
			pluginHelper.POSTrequestToCreateFeature(endpoint);
		} catch (Exception e) {
			ErrorReporter.reportError(e);
		}
	}
	
	@When("^User send a POST request to map product with feature$")
	public void i_send_a_Post_request_for_mapping_feature_with_product() throws Throwable {
		try {
			pluginHelper.POSTrequestToMapProductWithFeature();
		} catch (Exception e) {
			ErrorReporter.reportError(e);
		}
	}
	
	@When("^User send a POST request to map endpoint with product$")
	public void i_send_a_Post_request_for_mapping_endpoint_with_product() throws Throwable {
		try {
			pluginHelper.POSTrequestToMapEndpointWithProduct();
		} catch (Exception e) {
			ErrorReporter.reportError(e);
		}
	}
	
	
	@Then("^User should fetch featureId from response$")
	public void i_should_fetch_responses() throws Throwable {
		try {
			GlobalVariables.response = performanceAPI.getResponseOfWebService(GlobalVariables.conn);
			JSONObject obj = new JSONObject(GlobalVariables.response);
			GlobalVariables.scenario.write("\n\nResponse is :" + GlobalVariables.response);
			GlobalVariables.featureId=obj.getString("id");
			System.out.println(featureId);
		} catch (Exception e) {
			ErrorReporter.reportError(e);
		}
	}
	
	@And("^User should delete endpoint product mapping$")
	public void i_should_delete_responses() throws Throwable {
		try {
			pluginHelper.deleteEndpointProductMapping();
		} catch (Exception e) {
			ErrorReporter.reportError(e);
		}
	}
	
	
}
