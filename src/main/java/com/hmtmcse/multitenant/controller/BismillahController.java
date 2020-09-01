package com.hmtmcse.multitenant.controller;


import com.hmtmcse.multitenant.model.Student;
import com.hmtmcse.multitenant.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BismillahController {

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping("/bismillah")
    @ResponseBody
    public String bismillah(){
        return "Bismillah";
    }

    @GetMapping("/create")
    @ResponseBody
    public String create(){
        for (int i = 1; i < 5; i++){
            studentRepository.save(new Student("Name " + i, i));
        }
        return "Bismillah";
    }

    @GetMapping("/create-thread")
    @ResponseBody
    public String createThread() {
        new Thread(){
            @Override
            public void run() {
                for (int i = 1; i < 5; i++) {
                    studentRepository.save(new Student("Name " + i, i));
                }
            }
        }.start();

        return "Bismillah";
    }

}
