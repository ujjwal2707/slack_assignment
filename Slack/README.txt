//////////////////////////////////////////////
Name of the Maven project
"Slack"
//////////////////////////////////////////////

///////////////////////////////////////////////////////////////////////////
Description
"This project is to test the basic functionality of Slack channels module.
link --->https://app.slack.com/client/T0130JWJ8A0
//////////////////////////////////////////////////////////////////////////

//////////////////////////////////////////////
Required Maven Dependencies
Rest assured,json-path,testng,java-hamcrest

#Only opensourced dependencies were used
//////////////////////////////////////////////

//////////////////////////////////////////////
Support
 * It creates a Channel
 * It Joins the newly created channel
 * It Renames the channel
 * It List all the Channels
 * It Archive the Channel
 * It Validate the Archived channel

//////////////////////////////////////////////

//////////////////////////////////////////////
Flow of the Framework

*From before methods its read the Configurations file(Constant value)
*Build the RequestSpecification
*Performs the Functionality
*Deserialize the Json into Java object using POJO
*Call the helper class for validation
*Helper class returns the Response data into HashMap
*Validate the response and mark the test as pass/fail
*Tell the reason of the failure in case of Failure
//////////////////////////////////////////////

//////////////////////////////////////////////
How can we run the framework

1) From TestNG.xml file as a suite
2) From ChannelTest file as TestNg test
//////////////////////////////////////////////
