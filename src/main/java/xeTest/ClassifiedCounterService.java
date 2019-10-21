package xeTest;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

@Service
public class ClassifiedCounterService {

	public Classified processClassified(Classified classified) {
		classified.setNumOfWords(count(classified.getText()));
		classified.setAmount(findPrice(classified.getText()));
		
		return classified;
	}

	private int count(String text) {
		List<String> wordList = Arrays.asList(text.split(" "));
		int count = 0;
		for (String word : wordList) {
			if (word.length() > 1) {
				count++;
			}
		}
		return count;
	}
	
	private String findPrice(String text) {
		Pattern p = Pattern.compile("(\\d{1,3}(.\\d{3})*(,\\d+)?)(\\p{Sc}| *ευρώ| *euro)");
		Matcher matcher = p.matcher(text);
		if (matcher.find()) {
			return matcher.group();
		}
		
		return "";
	}
}
