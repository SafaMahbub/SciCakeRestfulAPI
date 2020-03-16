package springrest.api.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.hamcrest.Matchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.WebApplicationContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@Test
@WebAppConfiguration
@ContextConfiguration(locations = { "classpath:springrest-servlet.xml",
    "classpath:applicationContext.xml" })
public class EventControllerTest   extends AbstractTransactionalTestNGSpringContextTests {
	
	@Autowired
	 private WebApplicationContext wac;

	 private MockMvc mockMvc;

	 @BeforeClass
	 void setup()
	 {
	     this.mockMvc = MockMvcBuilders.webAppContextSetup( wac ).build();
	 }
	 
	 @Test
	 @Rollback(false)
	 void addEvent() throws Exception{
	        this.mockMvc
            .perform( post( "/events/add" ).contentType( "application/json" )
                .content( 
                		"{\n" + 
                		"        \"organizer\": {" + 
                		"        	\"id\": 1," + 
                		"	        \"type\": \"ADMIN\",\n" + 
                		"	        \"firstname\": \"Safa\",\n" + 
                		"	        \"lastname\": \"Mahbub\",\n" + 
                		"	        \"position\": \"FACULTY\",\n" + 
                		"	        \"username\": \"admin\",\n" + 
                		"	        \"email\": \"safa@gmail.com\",\n" + 
                		"	        \"enabled\": true,\n" + 
                		"	        \"roles\": [],\n" + 
                		"	        \"title\": null,\n" + 
                		"	        \"programAffiliations\": [],\n" + 
                		"	        \"eventOrganier\": false,\n" + 
                		"	        \"rewardProvider\": false\n" + 
                		"        },\n" + 
                		"        \"admin\": {\n" + 
                		"        	\"id\": 1,\n" + 
                		"	        \"type\": \"ADMIN\",\n" + 
                		"	        \"firstname\": \"Safa\",\n" + 
                		"	        \"lastname\": \"Mahbub\",\n" + 
                		"	        \"position\": \"FACULTY\",\n" + 
                		"	        \"username\": \"admin\",\n" + 
                		"	        \"email\": \"safa@gmail.com\",\n" + 
                		"	        \"enabled\": true,\n" + 
                		"	        \"roles\": [],\n" + 
                		"	        \"title\": null,\n" + 
                		"	        \"programAffiliations\": [],\n" + 
                		"	        \"eventOrganier\": false,\n" + 
                		"	        \"rewardProvider\": false\n" + 
                		"        },\n" + 
                		"        \"approved\": false,\n" + 
                		"        \"name\": \"asasasas\",\n" + 
                		"        \"description\": \"asasasas\",\n" + 
                		"        \"location\": \"asasasas\",\n" + 
                		"        \"startTime\": 1540018800000,\n" + 
                		"        \"endTime\": 1540882800000,\n" + 
                		"        \"tags\": [],\n" + 
                		"        \"attendees\": []\n" + 
                		"    }" ) )
            .andExpect( status().is2xxSuccessful() );
	 } 
	 
	 @Test
	 void approve() throws Exception
	 {
		 this.mockMvc.perform(put("/events/2/AOR/2/true"))
		 	.andExpect(status().isOk())
		 	.andExpect(jsonPath( "approved" ).value( "true" ) );
	 }
	 
	 @Test
	 void reject() throws Exception
	 {
		 this.mockMvc.perform(put("/events/3/AOR/2/false"))
		 	.andExpect(status().isOk())
		 	.andExpect(jsonPath( "approved" ).value( "false" ) );
	 }
	 
	 @Test
	 void addAttendee() throws Exception
	 {
		 this.mockMvc.perform(put("/events/4/addAttendee/1"))
		 	.andExpect(status().isOk());
	 }
	 
	 @Test
	 void getAllAttendee() throws Exception
	 {
		 this.mockMvc.perform(get("/events/1/attendees"))
		 	.andExpect(status().isOk())
		 	.andExpect( jsonPath( "$[0].username" ).value( "admin" ) );;
	 }

}
