package com.bala.Crud.controller;

import com.bala.Crud.model.Student;
import com.bala.Crud.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/")
    public String viewHomepage(Model model){
        model.addAttribute("students",studentService.getAllStudents());
        return "index";
    }
    @GetMapping("/showNewStudentForm")
    public String showNewStudentForm(Model model){
        Student student=new Student();
        model.addAttribute("student",student);
        return "add";
    }
    @PostMapping("/saveStudent")
    public String saveStudent(@ModelAttribute("student")Student student){
        studentService.saveStudent(student);
        return "index";
    }
    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id")Long id,Model model){
        Student student=studentService.getStudentById(id).get();
        model.addAttribute("student",student);
        return "update";
    }
    @GetMapping("/deleteStudent/{id}")
    public String deleteStudent(@PathVariable(value="id")Long id){
        studentService.deleteStudent(id);
        return "redirect:/";
    }
}
