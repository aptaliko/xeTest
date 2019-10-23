package xeTest.services;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

public interface ClassifiedCounterService {

	public Classified processClassified(Classified classified);

}
