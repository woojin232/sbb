package com.mysite.sbb.answer;


import com.mysite.sbb.question.Question;
import com.mysite.sbb.question.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RequestMapping("/answer")
@RequiredArgsConstructor
@Controller
public class AnswerController {

	    private final QuestionService  questionService;
	    private final AnswerService answerService;

	    //@GetMapping("/question/list")
	    @PostMapping("/create/{id}")
	    //@RequestParam String content은 템플릿에서 답변으로 입력한 내용(content)을 얻기 위해 추가 
	    //textarea의 name 속성명이 content이기 때문에 여기서도 변수명을 content로 사용해야 한다 
	    public String createAnswer(Model model, @PathVariable("id") Integer id, @RequestParam String content) {
	    	Question question = this.questionService.getQuestion(id);
	    	this.answerService.create(question, content);
	    	return String.format("redirect:/question/detail/%s", id);
	    }
}
