package com.mysite.sbb.question;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

// Repository란 엔티티에 의해 생성된 데이터베이스 테이블에 접근하는 메서드를을 사용하기 위한 인터페이스 CRUD를 어떻게 처리할지 정의하는 게층
//jparepository <> 값은  엔티티 값 question과  해당 엔티티의  pk의 속성 타입(Integer)을 지정
public interface QuestionRepository extends JpaRepository<Question, Integer> {
    Question findBySubject(String subject);
    Question findBySubjectAndContent(String subject, String content);
    List<Question> findBySubjectLike(String subject);
}