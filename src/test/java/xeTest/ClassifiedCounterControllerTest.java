package xeTest;

import static org.junit.Assert.assertTrue;

import java.util.Map;

import javax.ws.rs.core.MediaType;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.fasterxml.jackson.databind.ObjectMapper;

import xeTest.Classified;
import xeTest.ClassifiedCounterService;
import xeTest.Util;

@RunWith(SpringJUnit4ClassRunner.class)
@AutoConfigureMockMvc
@WebMvcTest(controllers = ClassifiedCounterController.class)
public class ClassifiedCounterControllerTest {

	@Autowired
	private MockMvc restMvc;

	@MockBean
	private ClassifiedCounterService classifiedCounterService;
	
	@Test
	public void testCounter() throws Exception {
		for (Map.Entry<String, Integer> set : Util.classifiedToWords.entrySet()) {
			StringBuilder builder = new StringBuilder();
			builder.append("{\"Text\" : \"" + set.getKey() + "\"}");

			MvcResult result = restMvc
					.perform(post("/classified/count").characterEncoding("utf-8").contentType(MediaType.APPLICATION_JSON).content(builder.toString()))
					.andExpect(status().isOk())
					.andReturn();
			MockHttpServletResponse response = result.getResponse();
			String json = response.getContentAsString();
			Classified classified = new ObjectMapper().readValue(json, Classified.class);
			assertTrue(classified.getNumOfWords() == set.getValue());
		}
	}
}