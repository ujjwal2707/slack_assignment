
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

package com.slack.Test;

import static io.restassured.RestAssured.given;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.slack.businessHelper.Helper;
import com.slack.genericUtils.ConfigFileReader;
import com.slack.pojoModels.ArchivedStatus;
import com.slack.pojoModels.CreateChannel;
import com.slack.pojoModels.GetChannels;
import com.slack.pojoModels.JoinChannel;
import com.slack.pojoModels.RenameChannel;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class ChannelTest {

	String baseURI;
	String token;
	Long timestamp;
	String channel = "channel_";
	String channel_Name;
	String channel_Renamed;
	String Channel_ID;
	ConfigFileReader config;
	Helper helper;
	RequestSpecification requestSpec;
	ResponseSpecification responseSpec;
	String createRes;
	String joinRes;
	String renameRes;
	String getListRes;
	String archiveRes;

	@BeforeClass
	public void setup() {
		config = new ConfigFileReader();
		baseURI = config.getBaseURI();
		token = config.getToken();
		createRes = config.getCreateChannelResource();
		joinRes = config.getJoinChannelResource();
		renameRes = config.getRenameChannelResource();
		getListRes = config.getListChannelResource();
		archiveRes = config.getArchiveChannelResource();

		helper = new Helper();
		timestamp = helper.getCurrentTimeStamp();
		channel_Name = channel + timestamp;
		requestSpec = new RequestSpecBuilder().setBaseUri(baseURI).addParam("token", token)
				.setContentType("application/x-www-form-urlencoded").build();

	}

	@AfterClass
	public void tearDown() {
		config = null;
		helper = null;
		requestSpec = null;
	}

	@Test
	public void createChannel() {

		HashMap<String, String> map = new HashMap<String, String>();

		System.out.println("Creating the Channel " + channel_Name);

		try {
			RequestSpecification request_Create_Channel = given().spec(requestSpec).params("name", channel_Name);
			CreateChannel response_Create_Channel = request_Create_Channel.when().post(createRes)
					.as(CreateChannel.class);

			if (response_Create_Channel.getOk()) {
				map = helper.validateCreatedChannelResponse(response_Create_Channel);
				Assert.assertEquals(channel_Name, map.get("Name"));
				Assert.assertTrue(map.get("ID") != null);
				Channel_ID = map.get("ID");
				System.out.println(map.get("ID") + "  Channel Created Successfully");
				map = null;
			} else {
				System.out.println("Reason of failure  " + response_Create_Channel.getError());
				Assert.assertTrue(false, "Channel Creation Failed");
			}
		} catch (Exception e) {

			System.out.println("Test ended up with exception while Creating Channel");
			Assert.assertTrue(false, "createChannel Test Failed");

		}

	}

	@Test(dependsOnMethods = { "createChannel" })
	public void joinChannel() {
		System.out.println("Join the Channel " + channel_Name);
		HashMap<String, String> map = new HashMap<String, String>();

		try {
			RequestSpecification request_Join_Channel = given().spec(requestSpec).params("name", channel_Name);
			JoinChannel response_Join_Channel = request_Join_Channel.when().post(joinRes).as(JoinChannel.class);

			if (response_Join_Channel.getOk()) {

				map = helper.validateJoinChannelResponse(response_Join_Channel);
				Assert.assertEquals(channel_Name, map.get("Name"));
				// Assert.assertEquals(true, map.get("Already_in_channel"));
				Assert.assertEquals("true", map.get("Already_in_channel"));
				map = null;

			} else {
				System.out.println("Reason of failure  " + response_Join_Channel.getError());
				Assert.assertTrue(false, "Joining of Channel Failed");
			}
		} catch (Exception e) {

			System.out.println("Test ended up with exception while Joining Channel");
			Assert.assertTrue(false, "join_Channel Test Failed");
		}

	}

	@Test(dependsOnMethods = { "joinChannel" })
	public void renameChannel() {
		System.out.println("Rename the Channel " + channel_Name);
		channel_Renamed = channel_Name + "_renamed";
		HashMap<String, String> map = new HashMap<String, String>();

		try {
			RequestSpecification request_Rename_Channel = given().spec(requestSpec).params("channel", Channel_ID,
					"name", channel_Renamed);
			RenameChannel response_Rename_Channel = request_Rename_Channel.when().post(renameRes)
					.as(RenameChannel.class);

			if (response_Rename_Channel.getOk()) {

				map = helper.validateRenameChannelResponse(response_Rename_Channel);
				Assert.assertEquals(channel_Renamed, map.get("Name"));
				Assert.assertEquals(channel_Name, map.get("Previous_Name"));
				map = null;

			} else {
				System.out.println("Reason of failure  " + response_Rename_Channel.getError());
				Assert.assertTrue(false, "Renaming of Channel Failed");
			}
		} catch (Exception e) {

			System.out.println("Test ended up with exception while Renaming the Channel");
			Assert.assertTrue(false, "renameChannel Test Failed");
		}

	}

	@Test(dependsOnMethods = { "renameChannel" })
	public void getChannels() {
		System.out.println("Get all Channel and validate " + channel_Renamed);
		Boolean ispresent = false;

		try {
			RequestSpecification request_Get_Channels = given().spec(requestSpec);
			GetChannels response_Get_Channels = request_Get_Channels.when().get(getListRes).as(GetChannels.class);

			if (response_Get_Channels.getOk()) {

				ispresent = helper.isChannelPresent(response_Get_Channels, channel_Renamed);
				if (ispresent) {
					Assert.assertTrue(true, "The renamed Channel is present in the Channnel list");
				}

			} else {
				System.out.println("Reason of failure  " + response_Get_Channels.getError());
				Assert.assertTrue(false, "Get List of Channels Failed");
			}
		} catch (Exception e) {

			System.out.println("Test ended up with exception while fetching the Channel List");
			Assert.assertTrue(false, "getChannels Test Failed");
		}

	}

	@Test(dependsOnMethods = { "getChannels" })
	public void archiveChannel() {
		System.out.println("Archive Channel " + channel_Renamed);

		try {
			RequestSpecification request_Get_Channels = given().spec(requestSpec).params("channel", Channel_ID);
			ArchivedStatus response_Archive_Channel = request_Get_Channels.when().get(archiveRes)
					.as(ArchivedStatus.class);

			if (response_Archive_Channel.getOk()) {
				System.out.println("Channel Archived " + channel_Renamed);

			} else {
				System.out.println("Reason of failure  " + response_Archive_Channel.getError());
				Assert.assertTrue(false, "Archive Channel Failed");
			}
		} catch (Exception e) {

			System.out.println("Test ended up with an exception while Archiving Channel");
			Assert.assertTrue(false, "archiveChannel Test Failed");
		}

	}

}