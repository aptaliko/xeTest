package xeTest;

import java.util.HashMap;
import java.util.Map;

import org.jsoup.Jsoup;

public class Util {

	public static final Map<String, Integer> classifiedToWords;
	static {
		classifiedToWords = new HashMap<>();
		classifiedToWords.put(
				"﻿Μεσιτικη εταιρεια στα πλαισια της διαρκους αναπτυξης της ζητει \"Assistant Manager\", προσφεροντας ενα ιδιαιτερα ελκυστικο πακετο αμοιβων, μεγαλες προοπτικες περαιτερω εξελιξης. Ο ιδανικος υποψηφιος/α, θα πρεπει να διαθετει: εμπειρια στον κλαδο των ακινητων ή της διαχειρισης ανθρωπινου δυναμικου, οργανωτικο πνευμα, και διαπραγματευτικες ικανοτητες Τηλ επικοινωνιας 6999999999(153) 400€\r\n",
				45);
		classifiedToWords.put(
				"ΖΗΤΟΥΝΤΑΙ υπάλληλοι σε καταστήματα πώλησης παραδοσιακών προϊόντων και καλλυντικών για την περίοδο Ιουνίου έως και Σεπτεμβρίου (4 Μήνες). Απαραίτητη γνώση της Αγγλικής γλώσσας, γνώση ρωσικής γλώσσας θα εκτιμηθεί. Διαμονή πληρωμένη σε διαμέρισμα κοντά στο χώρο εργασίας. Μισθός 800 ευρώ. email: info@here.gr\r\n",
				41);
		classifiedToWords.put(
				"ΚΥΨΕΛΗ διαμέρισμα 60 τ.μ., 1ου, προσόψεως, διαμπερές, 1 υ/δ, μπάνιο, ξεχωριστή κουζίνα, κλιματισμός, πόρτα ασφαλείας, ελεύθερο, ανακαινισμένο, εξαιρετικό πλήρως ανακαινισμένο διαμέρισμα σε ήσυχη περιοχή, αποτελείται από ένα φωτεινότατο σαλόνι, ξεχωριστή ανακαινισμένη κουζίνα, ανακαινισμένο μπάνιο. Διπλά τζάμια, ανακαινισμένη κουζίνα, μπάνιο, πατώματα. Ανακαινισμένα ηλεκτρικά και υδραυλικά. Η ανακαίνιση έγινε το 2019. Μόλις 4 λεπτά από τα δικαστήρια στην Ευελπίδων. Κατάλληλο και για επαγγελματική χρήση.\r\n",
				59);
		classifiedToWords.put(
				"﻿ΚΥΒΕΡΝΗΤΗΣ Γ' πιστοποιημένος ζητείται για ημερόπλοιο μοντέλου Πέραμα στη Μύκονο there@gmail.com\r\n",
				11);
		classifiedToWords.put(
				"ABARTH S4 595FL, 1.400 cc, μοντ. 6/'17, 160 hp, μαύρο μεταλλικό, 4.000 χλμ., 3θυρο, Τ-Jet Pista 1368, 10 φορολογίσιμοι ίπποι, τιμή 10.000€\r\n",
				22);
		classifiedToWords.put(
				"ΑΝΑΒΥΣΣΟΣ μεζονέτα 195 τ.μ., ισόγεια, 3 υ/δ, κατασκευή '12, 2 μπάνια, σε οικόπεδο 375 τ.μ., αυτόνομη θέρμανση, κλιματισμός, τζάκι, θέα θάλασσα, κλειστό πάρκιν, αποθήκη, κήπος, άριστη κατάσταση, 2 κυρίως επιπέδων, ευήλιο καθιστικό με θέα, υπόγειο φωτεινό που χρησιμοποιείται ως πλήρης ξενώνας, πισίνα με εξοπλισμένο περιβάλλοντα χώρο χαλάρωσης, walking distance από οργανωμένη παραλία, τιμή 570.000€\r\n",
				51);
	}
	
	public static String html2text(String html) {
	    return Jsoup.parse(html).text();
	}
}