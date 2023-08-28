package com.mysite.sbb.question;
// Controller -> Service -> Repository 구조로 데이터를 처리할 것이다.


import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;
//@RequestMapping으로 Mapping 시에 /question 생략 가능
@RequestMapping("/question")
@RequiredArgsConstructor
@Controller
public class QuestionController {

    private final QuestionService  questionService;

    //@GetMapping("/question/list")
    @GetMapping("/list")
    public String list(Model model) {
        List<Question> questionList = this.questionService.getList();
        model.addAttribute("questionList", questionList);
        return "question_list";
    }
    
    
    // @GetMapping(value = "/question/detail/{id}") 에서 사용한 id와 @PathVariable("id")의 매개변수 이름이 동일해야 한다.
    //@GetMapping(value = "/question/detail/{id}")
    @GetMapping(value = "/detail/{id}")
    public String detail(Model model, @PathVariable("id") Integer id) {
    	Question question = this.questionService.getQuestion(id);
    	model.addAttribute("question",question);
    	return "question_detail";
    }
}