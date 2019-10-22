package xeTest;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.nio.charset.Charset;
import java.util.Map;

import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ClassifiedCounterControllerTest {

	private MockMvc restMvc;

	@Autowired
	private ClassifiedCounterService classifiedCounterService;

	/**
	 * MediaType for JSON UTF8
	 */
	private static final org.springframework.http.MediaType APPLICATION_JSON_UTF8 = new org.springframework.http.MediaType(
			org.springframework.http.MediaType.APPLICATION_JSON.getType(),
			org.springframework.http.MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);

		final ClassifiedCounterController classifiedCounterController = new ClassifiedCounterController(
				classifiedCounterService);

		// standard mockMvc
		this.restMvc = MockMvcBuilders.standaloneSetup(classifiedCounterController).build();
	}

	@Test
	public void testCounter() throws Exception {
		for (Map.Entry<String, Integer> set : Util.classifiedToWords.entrySet()) {
			JSONObject jo = new JSONObject();
			jo.put("Text", set.getKey());
	
			MvcResult result = restMvc.perform(post("/classified/count").contentType(APPLICATION_JSON_UTF8).content(jo.toString()))
					.andExpect(status().isOk()).andReturn();
	
			MockHttpServletResponse response = result.getResponse();
			String json = response.getContentAsString();
			Classified classified = new ObjectMapper().readValue(json, Classified.class);
			assertEquals(classified.getNumOfWords(), (int)set.getValue());
		}
	 }
}