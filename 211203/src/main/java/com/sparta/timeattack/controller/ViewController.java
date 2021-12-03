package com.sparta.timeattack.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

//@RequiredArgsConstructor
@Controller
public class ViewController {

//    private final BoardRepository boardRepository;

//    @GetMapping("/boards/{id}")
//    public String viewBoard(@PathVariable Long id) {
////        boardRepository.findById(id);
//        System.out.println("왔다");
//        return "view";
//    }

        @GetMapping("/")
        public String getPageIndex(){
            return "index";
        }

//        @GetMapping("/view")
//        public String getPageView(){
//            return "view";
//        }
    // 없어도 왜 되는거지?


//    @GetMapping("/boards/{id}")
//    public String view() {
//        return "view";
//    }

}
