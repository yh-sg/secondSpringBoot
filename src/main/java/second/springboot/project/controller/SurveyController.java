package second.springboot.project.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import second.springboot.project.model.Question;
import second.springboot.project.model.Survey;
import second.springboot.project.service.SurveyService;

// SurveyController
//	SurveyService - AutoWired


@RestController
public class SurveyController {
	
	@Autowired
	private SurveyService surveyService;
	
	@GetMapping("/surveys")
	public List<Survey> retreiveAllSuvey() {
		return surveyService.retrieveAllSurveys();
	}
	
	
	//GET method for Survey
	@GetMapping("surveys/{surveyId}/questions")
	public List<Question> reteriveQuestionsForSurvey(@PathVariable String surveyId){
		return surveyService.retrieveQuestions(surveyId);
	}
	
	@PostMapping("surveys/{surveyId}/questions")
	public ResponseEntity<Void> addQuestionsForSurvey(@PathVariable String surveyId, @RequestBody Question newQuestion){
		//What should be structure of the request body?
//		{
//
//		    "id": "Question",
//		    "description": "desc",
//		    "correctAnswer": "ans",
//		    "options": [
//		      "1",
//		      "2",
//		      "3",
//		      "4"
//		    ]
//		}
			
		//How will it be mapped to Question object?
			//Use RequestBody
			
		//What should be returned?
			
		//What should be response status?
		
		Question question = surveyService.addQuestion(surveyId, newQuestion);
		
		if(question==null) {
			return ResponseEntity.noContent().build();
		}
		//Success - URI of the new resource in res header
		//Status - created
		//URI -> /surveys/{surveyID}/questions/{questionID}  question.getQuestionID()
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
		.path("/{id}").buildAndExpand(question.getId()).toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	
	//GET for specific question from a survey
	@GetMapping("surveys/{surveyId}/questions/{questionID}")
	public Question reteriveDetailsQuestions(@PathVariable String surveyId, @PathVariable String questionID){
		return surveyService.retrieveQuestion(surveyId, questionID);
	}
}
