package continuum.cucumber.stepDefinations.platform;



import java.net.HttpURLConnection;

import org.json.JSONObject;
import org.testng.Assert;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;

import continuum.cucumber.Utilities;
import continuum.cucumber.Page.CustomWait;
import continuum.cucumber.Page.GlobalVariables;
import continuum.cucumber.Page.HTTPUtility;
import continuum.cucumber.Page.JunoPageFactory;
import continuum.cucumber.Page.RandomCodeGenerator;
import continuum.cucumber.Page.Ssh;
import continuum.cucumber.Page.UploadObjectSingleOperation;
import continuum.cucumber.PageObjectMapper.DtoConvert;
import continuum.cucumber.reporting.Artifactory;
import continuum.cucumber.reporting.ErrorReporter;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AgentAutoUpdateStep extends GlobalVariables {
	
	static String psName = "C:\\Juno-Agent\\";
	
	public AgentAutoUpdateStep(JunoPageFactory sshObj) {
		super(sshObj);
		// TODO Auto-generated constructor stub
	}

	@When("^User send a Get request for API endpoint as \"([^\"]*)\"$")
	public void i_send_a_Get_request_for_Versioning_of_Agent_Microservice_API(String endpoint) throws Throwable {
		try {
			pluginHelper.getRequestForApi(endpoint);
		} catch (Exception e) {
			ErrorReporter.reportError(e);
		}
	}

	@When("^User send a Get request for feature API endpoint as \"([^\"]*)\"$")
	public void i_send_a_Get_request_for_feature_of_Agent_Microservice_API(String endpoint) throws Throwable {
		try {
			pluginHelper.getRequestForFeatureApi(endpoint);
		} catch (Exception e) {
			ErrorReporter.reportError(e);
		}
	}
	
	@When("^ICE User send a Get request for API endpoint as \"([^\"]*)\"$")
	public void i_send_a_Get_request_for_Versioning_of_Agent_Microservice_API_ICE(String endpoint) throws Throwable {
		try {
			pluginHelper.ICEuserGetRequestForAPI(endpoint);
		} catch (Exception e) {
			ErrorReporter.reportError(e);
		}
	}

	@When("^User send a Get request for Asset API endpoint as \"([^\"]*)\"$")
	public void i_send_a_Get_request_for_Asset_API(String endpoint) throws Throwable {
		try {
			pluginHelper.getRequestForAssetAPI(endpoint);
		} catch (Exception e) {
			ErrorReporter.reportError(e);
		}
	}

	@Then("^User should validate the structure of Global Manifest file$")
	public void i_should_validate_the_structure_global_manifest_file() throws Throwable {
		try {
			CommonSteps.fetchTestData();
			agentMicroServiceAPI.dummyGlobalManifestFile(GlobalVariables.response, GlobalVariables.data,
					GlobalVariables.index);
		} catch (Exception e) {
			ErrorReporter.reportError(e);
		}
	}

	@When("^User send a Post request for Manifest API endpoint as \"([^\"]*)\"$")
	public void i_send_a_Post_request_for_Manifest_API(String endpoint) throws Throwable {
		try {
			pluginHelper.postRequestForManifestAPI(endpoint);
		} catch (Exception e) {
			ErrorReporter.reportError(e);
		}
	}

	@When("^User send a Post request for InstallStatus API endpoint as \"([^\"]*)\"$")
	public void i_send_a_Post_request_for_InstallStatus_API(String endpoint) throws Throwable {
		try {
			pluginHelper.postRequestForInstallStatusAPI(endpoint);
		} catch (Exception e) {
			ErrorReporter.reportError(e);
		}
	}

	@And("^I Validate the enabled partner manifest details$")
	public void i_validate_the_enabled_partner_manifest_details() throws Throwable {
		String[] partnerID = data.get(index).get("partnerID").split(GlobalVariables.delimiter);
		String[] manifestVersion = data.get(index).get("ManifestVersion").split(GlobalVariables.delimiter);
		JSONObject json = new JSONObject(response);
		Assert.assertEquals(json.get("partnerId"), partnerID[0]);
		Assert.assertEquals(json.get("manifestVersion"), manifestVersion[0]);
	}

	@When("^User send a Get request and validate enabled PartnerManifest \"([^\"]*)\"$")
	public void i_send_a_Get_request_for_enabled_partner_Manifest(String endpoint) throws Throwable {
		try {
			String url,endpointId ="";
			String[] partnerID = data.get(index).get("pVersion").split(delimiter);
			String[] manifestVersion = data.get(index).get("mVersion").split(GlobalVariables.delimiter);
			for(int i=0;i<partnerID.length;i++){
				if (endpoint.contains("PartnerID")) {
					endpointId = endpoint.replace("PartnerID", partnerID[i]);
				}
				url = Utilities.getMavenProperties("Agent-Service-ELB") + endpointId;
				GlobalVariables.scenario.write("\n\nI send a Get request for URL " + url);
				CustomWait.sleep(10);
				GlobalVariables.conn = HTTPUtility.sendGetRequest(url);
				String status = GlobalVariables.conn.getResponseMessage();
				if (status.contains("200")) {
					Assert.assertEquals(HttpURLConnection.HTTP_OK, Integer.parseInt(status));
					Assert.assertEquals(status, "OK");
				}
				GlobalVariables.response = performanceAPI.getResponseOfWebService(GlobalVariables.conn);
				GlobalVariables.scenario.write("\n\nResponse is :" + GlobalVariables.response);
				JSONObject json = new JSONObject(response);
				Assert.assertEquals(json.get("partnerId"), partnerID[i]);
				Assert.assertEquals(json.get("manifestVersion"), manifestVersion[i]);
			}
		} catch (Exception e) {
			ErrorReporter.reportError(e);
		}
	}

	@When("^User downloads packages from artifactory for creating zip files$")
	public void user_downloads_packages_from_artifactory() throws Throwable {
		pluginHelper.downloadsPackagesFromArtifactoryForCreatingZipFiles(sshObj);
	}

	@When("^User creates package manifest and zip files for S3 Upload$")
	public void User_create_package_manifest() throws Throwable {
		try {	
			pluginHelper.createPackageManifestAndZipFilesForS3Upload(sshObj);
			MSIHelper.zipFileForRemoteMachine(sshObj, data, index);
		}
		catch (Exception e) {
			ErrorReporter.reportError(e);
		}
		
	}

	@And("^User upload zip file into S3 Bucket$")
	public void user_upload_zip_file_into_s3_bucket() throws Throwable {
		try {
			pluginHelper.uploadZipFileIntoS3Bucket();
		}
		catch (Exception e) {
			ErrorReporter.reportError(e);
		}
		//s3Client.deletefile(credentials, "AutomationS3Bucket.zip");
	}



}
