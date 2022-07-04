package springboot.student_management_system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import springboot.student_management_system.entity.Student;
import springboot.student_management_system.service.StudentService;

import javax.validation.Valid;

@Controller
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/students")
    public String getAllStudent(Model model ){
        model.addAttribute("students",studentService.getAllStudents());
        return "home";
    }

    @GetMapping("/students/new")
    public String createStudent(Model model){
        model.addAttribute("student", new Student());
        return "create_student";
    }

    @PostMapping("students")
    public String saveStudent(@Valid @ModelAttribute Student student, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            System.out.println(bindingResult);
            return "create_student";
        }
        studentService.saveStudent(student);
        return "redirect:/students";
    }

    @GetMapping("students/edit/{id}")
    public String editStudentForm(@PathVariable Long id, Model model){
        model.addAttribute("student", studentService.getStudentById(id));
        return "edit_student";
    }

    @PostMapping("students/{id}")
    public String updateStudent(@PathVariable Long id, @ModelAttribute Student student, Model model){
        Student existingStudent = studentService.getStudentById(id);
        existingStudent.setId(id);
        existingStudent.setFirstName(student.getFirstName());
        existingStudent.setLastName(student.getLastName());
        existingStudent.setEmail(student.getEmail());
        studentService.updateStudent(existingStudent);
        return "redirect:/students";
    }

    @GetMapping("/students/{id}")
    public String deleteStudent(@PathVariable Long id){
        studentService.deleteStudent(id);
        return "redirect:/students";
    }
}
