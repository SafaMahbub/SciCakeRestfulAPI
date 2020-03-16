package springrest.api.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.hamcrest.Matchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@Test
@WebAppConfiguration
@ContextConfiguration(locations = { "classpath:springrest-servlet.xml",
    "classpath:applicationContext.xml" })
class UserControllerTest extends AbstractTransactionalTestNGSpringContextTests {

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
    void addUserSucsess() throws Exception
    {
        this.mockMvc
            .perform( post( "/users/add" ).contentType( "application/json" )
                .content( 
                		"{" + 
                		"    \"type\": \"USER\"," + 
                		"    \"firstname\": \"Need To TestMVC2\"," + 
                		"    \"lastname\": \"TestAdd\"," + 
                		"    \"position\": \"STUDENT\"," + 
                		"    \"username\": \"TestAddSuccess\"," + 
                		"    \"password\": \"TestAdd\"," + 
                		"    \"email\": \"TestAdd@gmail.com\"," + 
                		"    \"enabled\": true," + 
                		"    \"roles\": []," + 
                		"    \"title\": null," + 
                		"    \"programAffiliations\": []," + 
                		"    \"eventOrganier\": true," + 
                		"    \"rewardProvider\": false" + 
                		"}" ) )
            .andExpect( status().is2xxSuccessful() );
    }
    
    @Test
    void addUserFail() throws Exception
    {
        this.mockMvc
            .perform( post( "/users/add" ).contentType( "application/json" )
                .content( "{\"username\":\"john\"}" ) )
            .andExpect( status().is4xxClientError() );
    }

}