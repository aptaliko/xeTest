package xeTest;

import static org.junit.Assert.assertEquals;

import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

import xeTest.Util.Util;
import xeTest.services.Classified;
import xeTest.services.ClassifiedCounterService;

@RunWith(SpringRunner.class)
@ComponentScan("xeTest.services")
@SpringBootTest
public class ClassifiedCounterServiceTest {

	@Autowired
	ClassifiedCounterService classifiedCounterService;
	
	@Test
	public void testCounter () {
 		for (Map.Entry<String, Integer> set: Util.classifiedToWords.entrySet()) {
			Classified classified = new Classified();
			classified.setText(set.getKey());
			classified = classifiedCounterService.processClassified(classified);

			assertEquals(classified.getNumOfWords(), (int) set.getValue());
		}
	}
}