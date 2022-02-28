package open.jolttesttool.controllers;

import open.jolttesttool.services.JoltTransformer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class JoltQueryController {

	private final JoltTransformer joltTransformer;

	public JoltQueryController(JoltTransformer joltTransformer){
		this.joltTransformer = joltTransformer;
	}

	@GetMapping("/")
	public String start(Model model) {
		return "index";
	}

	@PostMapping("/")
	public String runJoltTransform(@RequestParam String inputJson, @RequestParam String joltJson, Model model) {
		model.addAttribute("inputJson", inputJson);
		model.addAttribute("joltJson", joltJson);
		model.addAttribute("outputJson", joltTransformer.doJoltTransform(inputJson, joltJson));

		return "index";
	}

}
