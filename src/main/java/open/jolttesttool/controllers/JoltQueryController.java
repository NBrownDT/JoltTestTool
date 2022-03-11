package open.jolttesttool.controllers;

import open.jolttesttool.services.JoltTransformer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

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


	@GetMapping("/upload")
	public String uploadFile(
			@RequestParam MultipartFile file,
			@RequestParam String inputJson,
			@RequestParam String joltJson,
			@RequestParam String outputJson,
			@RequestParam String fieldName,
			Model model) {
		//Retrieve contents of file

		//place it in the correct attribute based on the fieldName param
		model.addAttribute("inputJson", inputJson);
		model.addAttribute("joltJson", joltJson);
		model.addAttribute("outputJson", "4444S");

		return "index";
	}

}
