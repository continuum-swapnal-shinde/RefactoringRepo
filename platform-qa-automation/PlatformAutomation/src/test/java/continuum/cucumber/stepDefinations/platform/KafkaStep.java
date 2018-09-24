package continuum.cucumber.stepDefinations.platform;

import java.util.List;

import org.testng.Assert;

import continuum.cucumber.Page.CustomWait;
import continuum.cucumber.Page.GlobalVariables;
import continuum.cucumber.Page.JunoPageFactory;
import continuum.cucumber.PageKafkaConsumers.Consumer;
import continuum.cucumber.PageKafkaConsumers.EventLogTopicConsumer;
import continuum.cucumber.PageKafkaConsumers.MECTopicConsumer;
import continuum.cucumber.PageKafkaConsumers.ScriptExecutionTopicConsumer;
import continuum.cucumber.PageKafkaConsumers.WebrootTopicConsumer;
import continuum.cucumber.PageKafkaDataBin.AgentExecutionResultDataBin;
import continuum.cucumber.PageKafkaDataBin.EventLogDataBin;
import continuum.cucumber.PageKafkaDataBin.ScriptExecutionResultDataBin;
import continuum.cucumber.PageKafkaDataBin.WebrootDataBin;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class KafkaStep extends GlobalVariables {
	
	Consumer consumed;
	List<Object> allLoggedMessages;
	
	public KafkaStep(JunoPageFactory sshObj) {
		super(sshObj);
	}
	/**
	 * Managed-Endpoint-Changed Kafka Topic Methods
	 * @throws Throwable
	 */
	@When("^User Starts M_E_C Consumer Topic$")
      public void user_starts_mec_consumer_topic() throws Throwable {
		consumed = MECTopicConsumer.getKafkaManagedEndpointConsumer();
    }
	
	@And("^User Stops M_E_C Consumer Topic and Fetch Data$")
       public void user_stops_mec_consumer_topic_and_fetch_data() throws Throwable {
		pluginHelper.stopsM_E_CconsumerTopic();
    }
	
	 @Then("^User Validate the Data fetch from the kafka topic$")
	   public void i_validate_the_data_fetch_from_the_kafka_topic() throws Throwable {
		 pluginHelper.ValidateDataFetchFromKafkaTopic();
	  }
	 
	 /**
	  * Script Execution result Kafka Topic Methods
	  *  
	  */
	 
	 	@When("^User Starts Script Execution Result Consumer Topic$")
	    public void user_starts_script_execution_result_consumer_topic() throws Throwable {
	 		consumed = ScriptExecutionTopicConsumer.getKafkaScriptExecutionConsumer();
	    }

	    @When("^User Stops Script Execution Result Consumer Topic and Fetch Data$")
	    public void user_stops_script_execution_result_consumer_topic_and_fetch_data() throws Throwable {
	    	pluginHelper.stopsScriptExecutionResultConsumerTopic();
	    }
	 
	    @Then("^User Validate the Data fetch from the Script Execution Result kafka topic as \"([^\"]*)\"$")
	    public void i_validate_the_data_fetch_from_the_script_execution_result_kafka_topic(String expectedMessage) throws Throwable {
	    	pluginHelper.ValidateDataFetchFromScriptExecutionResultKafkaTopic(expectedMessage);
	    }
	    
	    /**
		  * Event Log Kafka Topic Methods
		  *  
		  */
	    
	    @When("^User Starts Event Log Consumer Topic$")
	    public void user_starts_event_log_consumer_topic() throws Throwable {
	    	consumed = EventLogTopicConsumer.getKafkaEventLogConsumer();
	    }

	    @When("^User Stops Event Log Consumer Topic and Fetch Data$")
	    public void user_stops_event_log_consumer_topic_and_fetch_data() throws Throwable {
	    	pluginHelper.stopsEventLogConsumerTopic();
	    }

	    @Then("^User Validate the Data fetch from the Event Log kafka topic as \"([^\"]*)\" and \"([^\"]*)\"$")
	    public void i_validate_the_data_fetch_from_the_event_log_kafka_topic_as_something_and_something(String eventid, String expectedmessage) throws Throwable {
	    	pluginHelper.ValidateDataFetchfromEventLogKafkaTopic(eventid, expectedmessage);
	    }

	    
	    /**
		  * Webroot Kafka Topic Methods
		  *  
		  */
		 
		 	@When("^User Starts Webroot Consumer Topic$")
		    public void user_starts_webroot_result_consumer_topic() throws Throwable {
		 		consumed = WebrootTopicConsumer.getKafkaWebrootConsumer();
		    }

		    @When("^User Stops Webroot Consumer Topic and Fetch Data$")
		    public void user_stops_webroot_consumer_topic_and_fetch_data() throws Throwable {
		    	CustomWait.sleep(60);
		    	WebrootTopicConsumer.stopKafkaWebrootConsumer(consumed);
		        allLoggedMessages = consumed.getConsumedMessages().get(0);
		    }
		 
		    @Then("^User Validate the Data fetch from the Webroot kafka topic as \"([^\"]*)\"$")
		    public void i_validate_the_data_fetch_from_the_webroot_kafka_topic(String expectedMessage) throws Throwable {
		    	WebrootDataBin executionResultDto = WebrootTopicConsumer.
		    			getWebrootDTO(allLoggedMessages, GlobalVariables.agentMachineID); 
				 Object actualMessage = executionResultDto.getMessage();
				 GlobalVariables.scenario.write("Webroot Kafka Topic "
				 		+ "Data for Agent Machine ID : "+GlobalVariables.agentMachineID+" ->"+actualMessage.toString());
				 Assert.assertTrue(actualMessage.toString().contains(GlobalVariables.agentMachineID), 
						 "Expected Message not present in the response");
		    }
	 
	

}
