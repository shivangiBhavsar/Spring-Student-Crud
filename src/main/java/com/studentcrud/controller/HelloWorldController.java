package com.studentcrud.controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class HelloWorldController 
{
@RequestMapping("/")
public String hello() 
{
return "Hello javaTpoint";
}

@GetMapping("/addBook")
public String addBookView(Model model) {
   // model.addAttribute("book", new Book());
    return "add-book";
}
}
