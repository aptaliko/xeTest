package classifiedcounter.util;

import org.jsoup.Jsoup;

public class Util {

	public static String html2text(String html) {
		return Jsoup.parse(html).text();
	}

	private Util() {
		throw new IllegalStateException("Utility class");
	}
}
