package com.quiz.lesson01;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller // spring bean 등록
@RequestMapping("/lesson01/quiz01")
public class Lesson01Quiz01Controller {

   @ResponseBody // html
   @RequestMapping("/1")
   public String quiz01_1() {
      return "<h1>테스트 프로젝트 완성</h1><h3>해당 프로젝트를 통해서 문제 풀이를 진행합니다.</h3>";
   }
   
   @RequestMapping("/2")
   @ResponseBody
   public Map<String, Integer> quiz01_2() {
      Map<String, Integer> scores = new HashMap<>();
      scores.put("국어", 80);
      scores.put("수학", 90);
      scores.put("영어", 85);
      return scores; // map -> json String
   }
}
