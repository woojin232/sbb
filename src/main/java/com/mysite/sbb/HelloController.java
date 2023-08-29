package com.mysite.sbb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @GetMapping("/hello")
    // @ResponseBody 애너테이션은 hello 메서드의 응답 결과가 문자열 그 자체임을 나타낸다. return 값을 그대로 페이지에 출력
    @ResponseBody
    public String hello() {
        return "Hello Spring Boot Board";
    }
}