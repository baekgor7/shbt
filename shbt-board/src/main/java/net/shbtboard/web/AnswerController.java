package net.shbtboard.web;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import net.shbtboard.domain.Answer;
import net.shbtboard.domain.AnswerRepository;
import net.shbtboard.domain.Question;
import net.shbtboard.domain.QuestionRepository;
import net.shbtboard.domain.User;

@Controller
@RequestMapping("/questions/{questionId}/answers")
public class AnswerController {
	
	@Autowired
	private QuestionRepository questionRepository;

	@Autowired
	private AnswerRepository answerRepository;
	
	@PostMapping("")
	public String create(@PathVariable Long questionId, String contents, HttpSession session) {
		
		if(!HttpSessionUtils.isLoginUser(session)) {
			return "/users/loginForm";
		}
		
		User loginUser = HttpSessionUtils.getUserFromSession(session);
		Question question = questionRepository.findOne(questionId);
		Answer answer = new Answer(loginUser, question, contents); 
		System.out.println("answer.toString()==========="+answer.toString());
		answerRepository.save(answer);
		
		return String.format("redirect:/questions/%d", questionId);	//숫자일때는 %d, 문자일때는 %s
	}
}
