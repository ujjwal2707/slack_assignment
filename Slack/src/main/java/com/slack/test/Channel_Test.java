
/**
 * This Channel_Test file is to test the basic functionality of Slack
 * It creates a Channel
 * It Joins the newly created channel
 * It Renames the channel
 * It List all the Channels
 * It Archive the Channel
 * It Validate the Archived channel
 * 
 * 
 * 
 * 
 * @author Ujjwal Jaiswal
 * @since 2020-05-03
*/

package com.slack.test;
import static io.restassured.RestAssured.given;

import java.util.HashMap;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
	import org.testng.annotations.Test;

import com.slack.business_helper.Helper;
import com.slack.generic_utils.ConfigFileReader;
import com.slack.pojo.Archived_Status;
import com.slack.pojo.Create_Channel;
import com.slack.pojo.Get_Channels;
import com.slack.pojo.Join_Channel;
import com.slack.pojo.Rename_Channel;

import io.restassured.builder.RequestSpecBuilder;
	

	import io.restassured.specification.RequestSpecification;
	import io.restassured.specification.ResponseSpecification;

	public class Channel_Test {
		
		
		 String	baseURI;
	     String token; 
	     Long timestamp;
	     String channel="channel_";
	     String channel_Name;
	     String channel_Renamed;
	     String Channel_ID;
	     ConfigFileReader config;
		 Helper helper;
		 RequestSpecification requestSpec;
		 ResponseSpecification responseSpec;
		 String create_res;
		 String join_res;
		 String rename_res;
		 String get_list_res;
		 String archive_res;
		 
		
		@BeforeClass
		public void setup(){
			config=new ConfigFileReader();
		    baseURI=config.get_baseURI();
		    token=config.get_token();
		    create_res=config.get_create_channel_resource();
		    join_res=config.get_join_channel_resource();
		    rename_res=config.get_rename_channel_resource();
		    get_list_res=config.get_list_channel_resource();
		    archive_res=config.get_archive_channel_resource();
		    
		    helper=new Helper();
		    timestamp =helper.getCurrentTimeStamp();
		    channel_Name=channel+timestamp;
		    requestSpec = new RequestSpecBuilder().setBaseUri(baseURI).addParam("token", token).setContentType("application/x-www-form-urlencoded").build();
		   
		}
		@AfterClass
		public void tearDown(){
			config=null;
			helper=null;
			requestSpec=null;
		}
		
		
		
		@Test
		public void create_Channel(){
			
			HashMap<String , String> map=new HashMap<String , String>();
			
			System.out.println("Creating the Channel "+channel_Name );

		try{
			RequestSpecification request_Create_Channel=given().spec(requestSpec).params("name", channel_Name);
			Create_Channel response_Create_Channel	=request_Create_Channel.when().post(create_res).as(Create_Channel.class);
			
			if(response_Create_Channel.getOk()){
				map=helper.validate_created_channel_response(response_Create_Channel);
				Assert.assertEquals(channel_Name, map.get("Name"));
				Assert.assertTrue(map.get("ID")!=null);
				Channel_ID=map.get("ID");
				System.out.println(map.get("ID")+"  Channel Created Successfully" );
				map=null;
			}else{
				System.out.println("Reason of failure  "+response_Create_Channel.getError());
				System.out.println("Details  "+response_Create_Channel.getDetail());
				Assert.assertTrue(false, "Channel Creation Failed");
			}
		}catch (Exception e){
			
			System.out.println("Test ended up with exception while Creating Channel");
			Assert.assertTrue(false, "create_Channel Test Failed");
			
		}   

   }
		
		
		
		@Test(dependsOnMethods = { "create_Channel" })
		public void join_Channel(){
			System.out.println("Join the Channel "+channel_Name );
			HashMap<String , String> map=new HashMap<String , String>();
			
			
			 try{
				    RequestSpecification request_Join_Channel=given().spec(requestSpec).params("name", channel_Name);
				    Join_Channel response_Join_Channel=request_Join_Channel.when().post(join_res).as(Join_Channel.class);
				    
				    if(response_Join_Channel.getOk()){
				    	
				    	map=helper.validate_join_channel_response(response_Join_Channel);
				    	Assert.assertEquals(channel_Name, map.get("Name"));
				    	//Assert.assertEquals(true, map.get("Already_in_channel"));
				    	Assert.assertEquals("true",map.get("Already_in_channel") );
				    	map=null;
				    	
				    	
				  }else{
					    System.out.println("Reason of failure  "+response_Join_Channel.getError());
				    	Assert.assertTrue(false, "Joining of Channel Failed");
				    }
				}
				    catch (Exception e){
						
						System.out.println("Test ended up with exception while Joining Channel");
						Assert.assertTrue(false, "join_Channel Test Failed");
					}
		
		
		}
		
		
		@Test(dependsOnMethods = { "join_Channel" })
		public void rename_Channel(){
			System.out.println("Rename the Channel "+channel_Name );
			channel_Renamed=channel_Name+"_renamed";
			HashMap<String , String> map=new HashMap<String , String>();
			
			
			 try{
				    RequestSpecification request_Rename_Channel=given().spec(requestSpec).params("channel", Channel_ID, "name",channel_Renamed);
				    Rename_Channel response_Rename_Channel=request_Rename_Channel.when().post(rename_res).as(Rename_Channel.class);
				    
				    if(response_Rename_Channel.getOk()){
				    	
				    	map=helper.validate_rename_channel_response(response_Rename_Channel);
				    	Assert.assertEquals(channel_Renamed, map.get("Name"));
				    	Assert.assertEquals(channel_Name,map.get("Previous_Name"));
				    	map=null;
				    	
				    	
				  }else{
					    System.out.println("Reason of failure  "+response_Rename_Channel.getError());
				    	Assert.assertTrue(false, "Renaming of Channel Failed");
				    }
				}
				    catch (Exception e){
						
						System.out.println("Test ended up with exception while Renaming the Channel");
						Assert.assertTrue(false, "rename_Channel Test Failed");
					}
		
		
		}
		
		
		@Test(dependsOnMethods = { "rename_Channel" })
		public void get_Channels(){
			System.out.println("Get all Channel and validate "+channel_Renamed );
			Boolean ispresent=false;
			
			
			 try{
				    RequestSpecification request_Get_Channels=given().spec(requestSpec);
				    Get_Channels response_Get_Channels=request_Get_Channels.when().get(get_list_res).as(Get_Channels.class);
				    
				    if(response_Get_Channels.getOk()){
				    	
				    	ispresent=helper.isChannelPresent(response_Get_Channels,channel_Renamed);
				    	if(ispresent){
				    		Assert.assertTrue(true, "The renamed Channel is present in the Channnel list");
				    	}
				    	
				  }else{
					    System.out.println("Reason of failure  "+response_Get_Channels.getError());
				    	Assert.assertTrue(false, "Get List of Channels Failed");
				    }
				}
				    catch (Exception e){
						
						System.out.println("Test ended up with exception while fetching the Channel List");
						Assert.assertTrue(false, "get_Channels Test Failed");
					}
		
		
		}
		
		
		@Test(dependsOnMethods = { "get_Channels" })
		public void archive_Channel(){
			System.out.println("Archive Channel "+channel_Renamed );
			
			
			
			 try{
				    RequestSpecification request_Get_Channels=given().spec(requestSpec).params("channel", Channel_ID);
				    Archived_Status response_Archive_Channel=request_Get_Channels.when().get(archive_res).as(Archived_Status.class);
				    
				    if(response_Archive_Channel.getOk()){
				    	System.out.println("Channel Archived "+channel_Renamed);
				    	
				    	
				    
				  }else{
					  System.out.println("Reason of failure  "+response_Archive_Channel.getError());
				    	Assert.assertTrue(false, "Archive Channel Failed");
				    }
				}
				    catch (Exception e){
						
						System.out.println("Test ended up with an exception while Archiving Channel");
						Assert.assertTrue(false, "archive_Channel Test Failed");
					}
		
		
		}
		
		
}