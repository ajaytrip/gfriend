package com.gfriend.dynamo;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;
import com.gfriend.account.beans.*;
import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.model.AttributeDefinition;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.CreateTableRequest;
import com.amazonaws.services.dynamodbv2.model.DescribeTableRequest;
import com.amazonaws.services.dynamodbv2.model.KeySchemaElement;
import com.amazonaws.services.dynamodbv2.model.KeyType;
import com.amazonaws.services.dynamodbv2.model.ProvisionedThroughput;
import com.amazonaws.services.dynamodbv2.model.PutItemRequest;
import com.amazonaws.services.dynamodbv2.model.PutItemResult;
import com.amazonaws.services.dynamodbv2.model.ScalarAttributeType;
import com.amazonaws.services.dynamodbv2.model.TableDescription;
import com.amazonaws.services.dynamodbv2.util.TableUtils;




@Component
public class Dynamo {
	
	public Dynamo(){
		System.out.println("Dynamo: Constructor");
	}
	
	//static AmazonDynamoDB dynamoDB; 
	static AmazonDynamoDBClient dynamoDB;
	//@SuppressWarnings("deprecation")
	static{
		AWSCredentials credentials = null;
        try {
            credentials = new ProfileCredentialsProvider().getCredentials();
        } catch (Exception e) {
            throw new AmazonClientException(
                    "Cannot load the credentials from the credential profiles file. " +
                    "Please make sure that your credentials file is at the correct " +
                    "location (~/.aws/credentials), and is in valid format.",
                    e);
        }
        dynamoDB = new AmazonDynamoDBClient(credentials);
        Region usWest2 = Region.getRegion(Regions.US_WEST_2);
        dynamoDB.setRegion(usWest2);
            		

	}
	public void saveToDB(CustomerRegistration crObj) throws InterruptedException{
		//init();
		try {
			System.out.println("Dynamo:saveToDB "+ crObj);
            String tableName = "gf_user";//move it to configuration
            
            // Create a table with a primary hash key named 'name', which holds a string
            CreateTableRequest createTableRequest = new CreateTableRequest().withTableName(tableName)
                .withKeySchema(new KeySchemaElement().withAttributeName("userId").withKeyType(KeyType.HASH))
                .withAttributeDefinitions(new AttributeDefinition().withAttributeName("userId").withAttributeType(ScalarAttributeType.S))
                .withProvisionedThroughput(new ProvisionedThroughput().withReadCapacityUnits(1L).withWriteCapacityUnits(1L));
            
            //System.out.println("Dynamo:saveToDB after CreateTableRequest");
            // Create table if it does not exist yet
            TableUtils.createTableIfNotExists(dynamoDB, createTableRequest);
            TableUtils.waitUntilActive(dynamoDB, tableName);
            //System.out.println("table should be created");
            
            // Describe our new table
            DescribeTableRequest describeTableRequest = new DescribeTableRequest().withTableName(tableName);
            TableDescription tableDescription = dynamoDB.describeTable(describeTableRequest).getTable();
            System.out.println("Table Description: " + tableDescription);
            
            // Add an item //TBD add salt and improve authentication
            Map<String, AttributeValue> item = newItem(crObj.getUserId(), crObj.getFirstName(), crObj.getLastName(), crObj.getPassword());
            PutItemRequest putItemRequest = new PutItemRequest(tableName, item);
            PutItemResult putItemResult = dynamoDB.putItem(putItemRequest);
            System.out.println("Result: " + putItemResult);
            
		}catch (AmazonServiceException ase) {
			System.out.println("amazon service exception" );
			ase.printStackTrace();
			
		}catch (AmazonClientException ace) {
			System.out.println("amazon client exception");
		}
		
		
		
	}
    private static Map<String, AttributeValue> newItem(String userId, String firstName, String lastName, String Password) {
        Map<String, AttributeValue> item = new HashMap<String, AttributeValue>();
        item.put("userId", new AttributeValue(userId));
        item.put("FirstName", new AttributeValue(firstName));
        item.put("LastName", new AttributeValue(lastName));
        item.put("Password", new AttributeValue(Password));

        return item;
    }
}

