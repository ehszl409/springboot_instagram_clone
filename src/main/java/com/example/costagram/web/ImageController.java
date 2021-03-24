package com.example.costagram.web;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.costagram.config.auth.PrincipalDetails;
import com.example.costagram.service.ImageService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class ImageController {
	
	private final ImageService imageService;

	// 컨트롤러에서는 JsonIgnore가 필요없다. 잭슨이 발동을 안하기 때문이다.???
	@GetMapping({"/","/image/feed"})
	public String feed(Model model, @AuthenticationPrincipal PrincipalDetails principalDetails) {
		
		// 누구를 팔로우 했는지부터 알아야한다.
		// 그리고 팔로우한 유저의 id를 찾아서 뿌려야한다.
		model.addAttribute("images", imageService.피드이미지(principalDetails.getUser().getId()));
		
		return "image/feed";
	}
	
	@GetMapping("/image/explore")
	public String explore() {
		return "image/explore";
	}
	
	@GetMapping("/image/upload")
	public String upload() {
		return "image/upload";
	}
	
}
