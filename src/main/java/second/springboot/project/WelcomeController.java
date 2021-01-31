package second.springboot.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {
	
	@Autowired
	private WelcomeService service;
	
	@RequestMapping("/welcome")
	public String welcome() {
		return service.retrieveWelcomeMessage();
	}
}

//Spring to mangae this bean and create an instance of this
@Component
class WelcomeService{
	public String retrieveWelcomeMessage() {
		return "Good Morning!";
	}
}