package com.example.demo.login.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.login.vo.UserVo;

@Controller
public class LoginController {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	/**로그인 성공 후 메인으로
	 * @return
	 */
	@GetMapping("/loginPage.lo")
	public String loginPage() {
		logger.debug("안녕하세요~");
		
		return "user/userMainPage";
	}
	
	/**로그인 폼으로 이동
	 * @return
	 */
	@GetMapping("/loginForm.lo")
	public String loginForm() {
		return "login/loginPage";
	}
	
	/**회원가입 폼으로 이동
	 * @return
	 */
	@RequestMapping("/registerForm.lo")
	public String registerForm() {
		return "login/registerForm";
	}
	
	/**테스트 페이지
	 * @return
	 */
	@RequestMapping("/test.lo")
	public String test() {
		return "login/text";
	}
	
	
	/**회원가입
	 * @param uservo
	 * @return
	 */
	@RequestMapping("/register-process.lo")
	public String insertUser(UserVo uservo) {
		logger.debug("회원가입하러 왔어요{}", uservo);
		
		return "redirect:/loginForm.lo";
	}
	
}
