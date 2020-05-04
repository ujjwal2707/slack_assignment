/**
 * This Helper file is to get the response from test file and return the required values in a Map
 * 
 * 
 * 
 * 
 * 
 * @author Ujjwal Jaiswal
 * @since 2020-05-03
*/

package com.slack.businessHelper;

import java.sql.Timestamp;
import java.util.HashMap;

import com.slack.pojoModels.CreateChannel;
import com.slack.pojoModels.GetChannels;
import com.slack.pojoModels.JoinChannel;
import com.slack.pojoModels.RenameChannel;

public class Helper {

	public Boolean isChannelPresent(GetChannels res, String ChannelName) {
		Boolean isPresent = false;

		int channelCount = res.getChannels().size();

		for (int i = 0; i < channelCount; i++) {

			if (res.getChannels().get(i).getName().equalsIgnoreCase(ChannelName)) {

				isPresent = true;
			}
		}
		return isPresent;
	}

	public Boolean channelArchivedStatus(GetChannels res, String ChannelID) {
		Boolean archivedStatus = false;

		int channelCount = res.getChannels().size();
		for (int i = 0; i < channelCount; i++) {

			if (res.getChannels().get(i).getId().equalsIgnoreCase(ChannelID)) {
				archivedStatus = res.getChannels().get(i).getIs_archived();
			}
		}
		return archivedStatus;
	}

	public Boolean isChannelRenamed(GetChannels res, String Channel_ID, String ChannelName) {
		Boolean archivedStatus = false;

		int channelCount = res.getChannels().size();
		for (int i = 0; i < channelCount; i++) {

			if (res.getChannels().get(i).getId().equalsIgnoreCase(Channel_ID)) {
				archivedStatus = res.getChannels().get(i).getIs_archived();
			}
		}
		return archivedStatus;
	}

	public long getCurrentTimeStamp() {
		Timestamp timestamp1 = new Timestamp(System.currentTimeMillis());
		return timestamp1.getTime();

	}

	public HashMap<String, String> validateCreatedChannelResponse(CreateChannel response) {

		HashMap<String, String> channelMap = new HashMap<String, String>();
		channelMap.put("Name", response.getChannel().getName());
		channelMap.put("ID", response.getChannel().getId());
		return channelMap;
	}

	public HashMap<String, String> validateJoinChannelResponse(JoinChannel response) {

		HashMap<String, String> joinMap = new HashMap<String, String>();
		joinMap.put("Name", response.getChannel().getName());
		joinMap.put("ID", response.getChannel().getId());
		joinMap.put("Already_in_channel", response.getAlready_in_channel().toString());
		return joinMap;
	}

	public HashMap<String, String> validateRenameChannelResponse(RenameChannel response) {

		int previousNameSize = response.getChannel().getPrevious_names().size();
		for (int i = 0; i < previousNameSize; i++) {
			System.out.println(response.getChannel().getPrevious_names().get(i));
		}

		HashMap<String, String> renameMap = new HashMap<String, String>();
		renameMap.put("Name", response.getChannel().getName());
		renameMap.put("ID", response.getChannel().getId());
		renameMap.put("Previous_Name", response.getChannel().getPrevious_names().get(0));

		return renameMap;
	}

}
