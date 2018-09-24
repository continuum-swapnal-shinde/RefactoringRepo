Feature: Entitlement Feature

	@platformSanity @PlatformRegression @Win7_64Bit 
  Scenario Outline: Validate manifest file filtering wrt Entitlements-C3849958
      Given SSH connection establishes with remote test machine from tag
      And User fetch EndPointID of the machine from tag
      When User send a POST request to create product as "<newProduct>"
      Then User should validate the "201" as in response
      And User should fetch id from response
      When User send a POST request to create feature as "<newFeature>"
      Then User should validate the "201" as in response
      And User should fetch featureId from response
      When User send a POST request to map product with feature
      Then User should validate the "201" as in response
      When User send a Post request for package mapping API as "<Endpoint>"
      Then User should validate the "201" as in response
      When User send a POST request to map endpoint with product
      Then User should validate the "201" as in response
      And User should fetch response for API
      When User send a Post request for Manifest API endpoint as "<JenkinsPOSTEndpoint>"
   	  Then User should validate the "201" as in response
      When User send a Post request for Manifest API endpoint as "<RRTPOSTEndpoint>"
      Then User should validate the "200" as in response
      When User fetch AgentCore EndPointID from agentCore config file from tag
      Then User send a Get request for API endpoint as "<GetManifestFile>"
      And User should validate the status code as "200"OK
      And User should fetch response for API
      And User validate operation flag in manifest file for feature packages
      And User should delete endpoint product mapping
 
    Examples: 
      | RowIndex | newProduct 					  				|   newFeature       								|  Endpoint           | GetManifestFile			 |RRTPOSTEndpoint|JenkinsPOSTEndpoint|
      |        1 | /entitlement/v1/mgmt/products  |		 /entitlement/v1/mgmt/features	| /agent/v1/features/ | /agent/v1/endpoint/EndPointID/manifest            |		/agent/v1/manifest/gman/partnerManifest			|/agent/v1/manifest|
      
    
    