package springrest.api.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
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
public class ProgramControllerTest  extends AbstractTransactionalTestNGSpringContextTests {

	 @Autowired
	 private WebApplicationContext wac;

	 private MockMvc mockMvc;

	 @BeforeClass
	 void setup()
	 {
	     this.mockMvc = MockMvcBuilders.webAppContextSetup( wac ).build();
	 }
	 
	 @Test
	 void getPrograms() throws Exception
	 {
		 
	     this.mockMvc.perform(get("/programs"))
	     	.andExpect(status().isOk())
		 	.andExpect(jsonPath( "$[0].name" ).value( "ECST" ) )
		 	.andExpect(jsonPath( "$[0].fullName" ).value( "Engineering, Computer Sciecne, and Technology" ) )
		 	.andExpect(jsonPath( "$[0].description" ).value( "CS college" ) );
	 }
	 
	 @Test
	 void getProgram() throws Exception
	 {
		 this.mockMvc.perform(get("/programs/1"))
		 	.andExpect(status().isOk())
		 	.andExpect(jsonPath( "name" ).value( "ECST" ) )
		 	.andExpect(jsonPath( "fullName" ).value( "Engineering, Computer Sciecne, and Technology" ) )
		 	.andExpect(jsonPath( "description" ).value( "CS college" ) );
	 }
	 
	    @Test
	    @Rollback(false)
	    void addProgram() throws Exception
	    {
	        this.mockMvc
	            .perform( post( "/programs/add" ).contentType( "application/json" )
	                .content( 
	                		"{" + 
	                		"    \"name\": \"TestAdd\"," + 
	                		"    \"fullName\": \"TestingAdd MVC\"," + 
	                		"    \"description\": \"Seeing if Add MockMvc Works\"" + 
	                		"}" ) )
	            .andExpect( status().is2xxSuccessful() );
	    }
	 
	 @Test
	 @Rollback(false)
	 void editProgram() throws Exception 
	 {
	        this.mockMvc
            .perform( post( "/programs/edit/2" ).contentType( "application/json" )
                .content( 
                		"{" + 
                		"    \"name\": \"Test Editing 2\"," + 
                		"    \"fullName\": \"Testing MVC Editing 2\"," + 
                		"    \"description\": \"Seeing if MockMvc Editing Works 2\"" + 
                		"}" ) )
            .andExpect( status().is2xxSuccessful() );
	 }
	 
	 @Test
	 void deleteProgram() throws Exception 
	 {
		 this.mockMvc.perform(get("/programs/delete/4"))
		 		.andExpect(status().isOk());;
	 }
}
