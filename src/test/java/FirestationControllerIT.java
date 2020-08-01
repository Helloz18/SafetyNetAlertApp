import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@WebAppConfiguration
@ContextConfiguration("/applicationContext.xml")
class FirestationControllerIT {

	private MockMvc mockMvc;
	
	@Autowired
	private WebApplicationContext wac;

	
	@Before
	public void setup() throws Exception {
    this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
}
	
	@Test
	public void testSaveFirestation() throws Exception {
	    String firestation = "{ \"address\":\"newAddress\",\"station\":\"8\"}";
	    MockHttpServletRequestBuilder req = post(SERVICE_URI).contentType(MediaType.APPLICATION_JSON)
	            .accept(MediaType.APPLICATION_JSON_UTF8)
	            .content(firestation);
	    this.mockMvc.perform(req).andExpect(status().isOk());
	}
	
	@Test
	public void testPostFirestation() {
	    String firestation = "{ \"address\":\"newAddress\",\"station\":\"8\"}";
	    MvcResult result = mockMvc.perform(
				post("/fireStation").contentType(MediaType.APPLICATION_JSON).content(firestation).characterEncoding("utf-8"))
				.andExpect(status().isOk()).andDo(print()).andReturn();
	    
	}
	
}