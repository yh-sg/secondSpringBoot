package second.springboot.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import second.springboot.project.model.Question;
import second.springboot.project.service.SurveyService;

// SurveyController
//	SurveyService - AutoWired


@RestController
public class SurveyController {
	
	@Autowired
	private SurveyService surveyService;
	
	//GET method
	@GetMapping("surveys/{surveyId}/questions")
	public List<Question> reteriveQuestionsForSurvey(@PathVariable String surveyId){
		return surveyService.retrieveQuestions(surveyId);
	}
}
