package com.xworkz.spring;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@RequestMapping("/")
public class LoginController {

	private Map<String, String> map;

	@PostConstruct
	public void initializeMap() {
		System.out.println("invoked postConstruct() method");
		map = new LinkedHashMap<>();
		map.put("Mysore", "Karnataka Express");
		map.put("Hubli", "JanaShatabdi Express");
		map.put("Belgaum", "Rani Chennamma SuperFast Express");
		map.put("Mumbai", "Hamsafar Express");
		map.put("Bagalkot", "GolGumbaz Express");
	}

	@RequestMapping("/submit.do")
	public String display(@RequestParam String name, @RequestParam String phone, @RequestParam String age,
			@RequestParam String source, @RequestParam String destination, @RequestParam String date, Model model) {
		try {
			System.out.println("Name is :" + name);
			System.out.println("Mobil number is :" + phone);
			System.out.println("Age is :" +age);
			System.out.println("Source and Destination is :" + source + " and " + destination);
			System.out.println("Date of journey is :" + date);

			model.addAttribute("name", "Name is " + name);
			model.addAttribute("mobile", "Mobile Number is " + phone);
			model.addAttribute("Age", "Age of Person is " + age);
			model.addAttribute("location", "Source and Destination enterd is : " + source + " and " + destination);
			model.addAttribute("date", "Date of Travelling is :" + date);
			System.out.println("directing to details.jsp");

			model.addAttribute("cityname", map.keySet());
			return "search";
//		throw new ClassCastException("Exception thrown to understand problems");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@RequestMapping("/search.do")
	public String searchTrains(@RequestParam String city, Model model) {
		try {

			System.out.println("City entered is " + city);
			if (city != null) {
				System.out.println("City field is not null");
				if (map.containsKey(city)) {
					model.addAttribute("city", "Result found :City name is " + city);
					model.addAttribute("TrainName", " Train available is :" + map.get(city));
				}
			} else {
				System.out.println("City field is null");
				model.addAttribute("result", "You have not selected, so result is not found");
			}

			return "success";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
