package com.codingdojo.daikichi.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DaikichiControllers {
	@RequestMapping("/daikichi")
	public String Daikichi() {
		return "Welcome!";
	}
	@RequestMapping("/daikichi/today")
	public String Today() {
		return "Today you will find luck in all your endeavors!";
	}
	@RequestMapping("/daikichi/tomorrow")
	public String Tomorrow() {
		return "Tomorrow, an opportunity will arise, so be sure to be open to new ideas!";
	}

	@RequestMapping("/daikichi/travel/m/{location}")
	public String Travel(@PathVariable("location") String location) {
		return "Congratulations! You will soon travel to " + location; 
	}

	@RequestMapping("/daikichi/lotto/m/{number}")
	public String Location(@PathVariable ("number") int number) {
		if ( number % 2 == 0) {
			return "You will take a grand journey in the near future, but be wary of tempting offers";
		}else if (number % 2 ==1) {
			return "You have enjoyed the fruits of your labor but now is a great time to spend time with family and friends";
		}else {
			return "unknown combination";
		}			
	}
	
}