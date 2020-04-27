package cassandra;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeRepository employeeRepository;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	  public String greetingForm(Model model) {
	    model.addAttribute("employee", new Employee());
	    return "index";
	  }

	@RequestMapping(value = "/postEmployee", method = RequestMethod.POST)
	  public String greetingSubmit(@ModelAttribute Employee employee) {
		List<Employee> employeeList=employeeRepository.findAll();
		if(employeeList.isEmpty())
			employee.setId(1);
		else
			employee.setId(employeeList.size()+1);	
		employeeRepository.save(employee);
	    return "result";
	  }

	
	
}
