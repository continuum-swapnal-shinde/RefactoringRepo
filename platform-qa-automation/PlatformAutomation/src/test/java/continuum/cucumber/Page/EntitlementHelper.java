package continuum.cucumber.Page;

import java.util.HashMap;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

import continuum.cucumber.PageDataBin.FeaturePackages;
import continuum.cucumber.PageObjectMapper.DtoConvert;

/**
 * Class to associate feature with packages list
 * 
 * **/
public class EntitlementHelper {

	private String delimiter="\\|";
	public FeaturePackages fp= new FeaturePackages();
	
	public String packageFeatureMapping(List<HashMap<String, String>> data, int index) {
		
		boolean emptyFieldInclusion = data.get(index).get("ConfigEmptyFieldInclusion").equalsIgnoreCase("NA");

		if(!(data.get(index).get("feature").equalsIgnoreCase("NA"))){
			String feature=data.get(index).get("feature");
			fp.setName(feature);
		}
		
		if(!(data.get(index).get("featurePackages").equalsIgnoreCase("NA"))){
			String[] pack = data.get(index).get("featurePackages").split(delimiter);
			fp.setFeaturePackages(pack);
		}
		
		return DtoConvert.dtoToJsonStringNonEmpty(fp,emptyFieldInclusion);
	}

	public static JSONObject newProductPostRequest(List<HashMap<String, String>> data, int index) {
		JSONObject mainJson   = new JSONObject();
		try {
			mainJson.put("name",data.get(index).get("productName"));   
			mainJson.put("description",data.get(index).get("productDescription")); 
			
		} catch (JSONException e) {
			e.printStackTrace();
		}

		return mainJson;
	}
	
	public static JSONObject newFeaturetPostRequest(List<HashMap<String, String>> data, int index) {
		JSONObject mainJson   = new JSONObject();
		try {
			mainJson.put("name",data.get(index).get("featureName"));   
			mainJson.put("description",data.get(index).get("featureDescription"));
			
		} catch (JSONException e) {
			e.printStackTrace();
		}

		return mainJson;
	}

}
