package xeTest;

import static org.junit.Assert.assertTrue;

import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=ClassifiedCounterService.class)
public class ClassifiedCounterServiceTest {

	@Autowired
	ClassifiedCounterService classifiedCounterService;
	
	@Test
	public void testCounter () {
 		for (Map.Entry<String,Integer> set: Util.classifiedToWords.entrySet()) {
			Classified classified = new Classified();
			classified.setText(set.getKey());
			classified = classifiedCounterService.processClassified(classified);
			
			assertTrue(classified.getNumOfWords() == set.getValue());
		}
	}
}