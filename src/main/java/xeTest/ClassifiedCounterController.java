package xeTest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/classified")
public class ClassifiedCounterController {

	@Autowired
	private ClassifiedCounterService classifiedcounterService;

	public ClassifiedCounterController(ClassifiedCounterService classifiedcounterService) {
		super();
		this.classifiedcounterService = classifiedcounterService;
	}

	@PostMapping(value = "/count")
	public ResponseEntity<Classified> processClassified(@RequestBody Classified classified) {
		classifiedcounterService.processClassified(classified);

		return new ResponseEntity<Classified>(classified, HttpStatus.OK);
	}

	@PostMapping(value = "/countHtml")
	public ResponseEntity<Classified> processClassifiedHtml(@RequestBody Classified classified) {
		classified.setText(Util.html2text(classified.getText()));
		classifiedcounterService.processClassified(classified);

		return new ResponseEntity<Classified>(classified, HttpStatus.OK);
	}
}
