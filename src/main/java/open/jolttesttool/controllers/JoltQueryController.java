package open.jolttesttool.controllers;

import open.jolttesttool.services.FileReader;
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
	public String start(Model model) { return "index"; }

	@PostMapping("/")
	public String runJoltTransform(@RequestParam String inputJson, @RequestParam String joltJson, Model model) {
		model.addAttribute("inputJson", inputJson);
		model.addAttribute("joltJson", joltJson);
		model.addAttribute("outputJson", joltTransformer.doJoltTransform(inputJson, joltJson));
		return "index";
	}

	@PostMapping(value="/upload", headers=("content-type=multipart/*"))
	public String uploadFile(
			@RequestParam MultipartFile file,
			@RequestParam String inputJson,
			@RequestParam String joltJson,
			@RequestParam String outputJson,
			@RequestParam String fieldName,
			Model model) {

		String content = (new FileReader()).doFileRead(file);
		//place it in the correct attribute based on the fieldName param
		if("inputJson".equals(fieldName)) {
			model.addAttribute("inputJson", content);
			  model.addAttribute("joltJson", joltJson);
			model.addAttribute("outputJson", outputJson);
		} else if ("joltJson".equals(fieldName)) {
			model.addAttribute("inputJson", inputJson);
			  model.addAttribute("joltJson", content);
			model.addAttribute("outputJson", outputJson);
		} else if ("outputJson".equals(fieldName)) {
			model.addAttribute("inputJson", inputJson);
			  model.addAttribute("joltJson", joltJson);
			model.addAttribute("outputJson", content);
		}

		return "index";
	}


	@PostMapping(value="/download", headers=("produces=multipart/*"))
	public void downloadFile(@RequestParam String outputJson) {
		//Not sure if any of this is right but I was working from here:
		//https://howtodoinjava.com/spring-mvc/spring-mvc-download-file-controller-example/
	}

}
