package classifiedcounter;

import static org.junit.Assert.assertEquals;

import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

import classifiedcounter.services.Classified;
import classifiedcounter.services.ClassifiedCounterService;

@RunWith(SpringRunner.class)
@ComponentScan("classifiedcounter.services")
@SpringBootTest
public class ClassifiedCounterServiceTest {

	@Autowired
	ClassifiedCounterService classifiedCounterService;

	@Test
	public void testCounter () {
		for (Map.Entry<String, Integer> set: TestData.classifiedToWords.entrySet()) {
			Classified classified = new Classified();
			classified.setText(set.getKey());
			classified = classifiedCounterService.processClassified(classified);

			assertEquals(classified.getNumOfWords(), (int) set.getValue());
		}
	}
}