package open.jolttesttool.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class JoltQueryController {

	@PostMapping("/")
	public String runJoltTransform(@RequestParam String inputJson, @RequestParam String joltJson, Model model) {
		model.addAttribute("inputJson", inputJson);
		model.addAttribute("joltJson", joltJson);
		model.addAttribute("outputJson", "{}");

		return "index";
	}

}
