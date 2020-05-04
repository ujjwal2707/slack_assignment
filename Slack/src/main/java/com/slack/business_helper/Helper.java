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


package com.slack.business_helper;


import java.sql.Timestamp;
import java.util.HashMap;

import com.slack.pojo.Create_Channel;
import com.slack.pojo.Get_Channels;
import com.slack.pojo.Join_Channel;
import com.slack.pojo.Rename_Channel;


public class Helper {
	
	public Boolean isChannelPresent(Get_Channels res,String ChannelName){
		Boolean isPresent=false;
		
		int channel_count=res.getChannels().size();
        
            for(int i=0;i<channel_count;i++){
        	
        	if(res.getChannels().get(i).getName().equalsIgnoreCase(ChannelName)){
        		
        		isPresent=true;
        	}
        }
		
		return isPresent;
		
		
	}
	
	public Boolean channel_Archived_Status(Get_Channels res,String Channel_ID){
		Boolean archived_status = false;
		
		int channel_count=res.getChannels().size();
        for(int i=0;i<channel_count;i++){
        	
        	
        	if(res.getChannels().get(i).getId().equalsIgnoreCase(Channel_ID)){
        		archived_status=res.getChannels().get(i).getIs_archived();
        		
        	}
        	
        }
        return archived_status;
		
		
		
	}
	
	
	
	public Boolean isChannel_Renamed(Get_Channels res,String Channel_ID, String Channel_name){
		Boolean archived_status = false;
		
		int channel_count=res.getChannels().size();
        for(int i=0;i<channel_count;i++){
        	
        	
        	if(res.getChannels().get(i).getId().equalsIgnoreCase(Channel_ID)){
        		archived_status=res.getChannels().get(i).getIs_archived();
        		
        	}
        	
        }
        return archived_status;
		
		
		
	}
	
	public long getCurrentTimeStamp(){
		Timestamp timestamp1 = new Timestamp(System.currentTimeMillis());
		return timestamp1.getTime();
		
		
	}
	
	public HashMap<String, String> validate_created_channel_response(Create_Channel response){
		
		HashMap<String, String> channelMap=new HashMap<String, String>();
		channelMap.put("Name",response.getChannel().getName());
		channelMap.put("ID",response.getChannel().getId());
		
		
		return channelMap;
		
		
		
	}
	
public HashMap<String, String> validate_join_channel_response(Join_Channel response){
		
		HashMap<String, String> joinMap=new HashMap<String, String>();
		joinMap.put("Name",response.getChannel().getName());
		joinMap.put("ID",response.getChannel().getId());
		joinMap.put("Already_in_channel",response.getAlready_in_channel().toString());
		
		
		
		return joinMap;
		
		
	}
	
public HashMap<String, String> validate_rename_channel_response(Rename_Channel response){
	
	int previousName_size=response.getChannel().getPrevious_names().size();
	
	 for(int i=0;i<previousName_size;i++){
     	System.out.println(response.getChannel().getPrevious_names().get(i));
     	}
	
	
	HashMap<String, String> joinMap=new HashMap<String, String>();
	joinMap.put("Name",response.getChannel().getName());
	joinMap.put("ID",response.getChannel().getId());
	joinMap.put("Previous_Name",response.getChannel().getPrevious_names().get(0));
	
	return joinMap;
	
	
}

	
	

}
