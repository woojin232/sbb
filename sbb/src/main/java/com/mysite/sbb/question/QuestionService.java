package com.mysite.sbb.question;

import java.util.List;
import java.util.Optional;
import com.mysite.sbb.DataNotFoundException;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class QuestionService {
	private final QuestionRepository questionRepository;
	
	public List<Question> getList(){
		return this.questionRepository.findAll();
	}
	
	//id 값으로 Question 데이터를 조회하는 getQuestion 메서드
	//리포지터리로 얻은 Question 객체는 Optional 객체이기 때문에 위와 같이 isPresent 메서드로 해당 데이터가 존재하는지 검사하는 로직이 필요
	public Question getQuestion(Integer id) {
		Optional<Question> question = this.questionRepository.findById(id);
		if(question.isPresent()) {
			return question.get();
		}else {
			throw new DataNotFoundException("question not found");
		}
	}
}
