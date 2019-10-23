package xeTest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("classified")
public class ClassifiedCounterController {

	private ClassifiedCounterService classifiedcounterService;

	public ClassifiedCounterController(ClassifiedCounterService classifiedcounterService) {
		this.classifiedcounterService = classifiedcounterService;
	}

	@PostMapping(value = "/count", produces = { "application/json" }, consumes = { "application/json" })
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Classified> processClassified(@RequestBody Classified classified) {
		classifiedcounterService.processClassified(classified);

		return new ResponseEntity<>(classified, HttpStatus.OK);
	}

	@PostMapping(value = "/countHtml", produces = { "application/json" }, consumes = { "application/json" })
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Classified> processClassifiedHtml(@RequestBody Classified classified) {
		classified.setText(Util.html2text(classified.getText()));
		classifiedcounterService.processClassified(classified);

		return new ResponseEntity<>(classified, HttpStatus.OK);
	}
}