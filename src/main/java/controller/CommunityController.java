package controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dao.InfosDAO;

@RestController
public class CommunityController {

	InfosDAO infosDAO = new InfosDAO();
	
	@GetMapping("/communityEmail")
	public List<String> getEmaisForAcity(@RequestParam(value="city", required=true) String city) {
		return infosDAO.emailsForAcity(city);		
		}
}
