package com.codingdojo.ninjagoldgame.controller;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

@Controller
public class NinjaController {
 
		@GetMapping("/")
		public String First() {
		
		return "show.jsp";
		
		}
		
		@PostMapping("/post")
		public String Post(@RequestParam(value="farm", required=false) String farm, @RequestParam(value="cave", required=false) String cave, @RequestParam(value="house", required=false) String house, @RequestParam(value="quest", required=false) String quest, HttpSession session) {
			
			
			
			if(session.getAttribute("count")==null) {
				ArrayList<String> activities = new ArrayList<String>();
				session.setAttribute("activities", activities);
				session.setAttribute("count", 0);
				}
			if(farm != null) {
				ArrayList<String> currentActivities = (ArrayList<String>) session.getAttribute("activities");
				Integer gold = (Integer) session.getAttribute("count");
				int random_int = (int)Math.floor(Math.random() * (20 - 10 + 1) + 10);
				gold += random_int;
				session.setAttribute("count", gold);
				currentActivities.add("you entered a farm and earned " + gold + new Date());
				session.setAttribute("activities", currentActivities);

			}
			if(cave!=null) {
				ArrayList<String> currentActivities = (ArrayList<String>) session.getAttribute("activities");
				Integer gold = (Integer) session.getAttribute("count");
				int random_int = (int)Math.floor(Math.random() * (10 - 5 + 1) + 5);
				gold += random_int;
				session.setAttribute("count", gold);	
				currentActivities.add("you entered a cave and earned " + gold + new Date());
				session.setAttribute("activities", currentActivities);
			}
			if(house!=null) {
				ArrayList<String> currentActivities = (ArrayList<String>) session.getAttribute("activities");
				Integer gold = (Integer) session.getAttribute("count");
				int random_int = (int)Math.floor(Math.random() * (5 - 2 + 1) + 2);
				gold += random_int;
				session.setAttribute("count", gold);
				currentActivities.add("you entered a house and earned " + gold + new Date());
				session.setAttribute("activities", currentActivities);
			}
			if(quest!=null) {
				ArrayList<String> currentActivities = (ArrayList<String>) session.getAttribute("activities");
				Integer gold = (Integer) session.getAttribute("count");
				int random_int = (int)Math.floor(Math.random() * (50 - (-50) + 1) + -50);
				gold += random_int;						
				session.setAttribute("count", gold);
				currentActivities.add("you entered a quest and earned " + gold + new Date());
				session.setAttribute("activities", currentActivities);
			}	
			
			
			return"redirect:/";
		}
}
