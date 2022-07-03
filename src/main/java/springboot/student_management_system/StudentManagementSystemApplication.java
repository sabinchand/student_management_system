package springboot.student_management_system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springboot.student_management_system.entity.Student;
import springboot.student_management_system.repository.StudentRepository;

@SpringBootApplication
public class StudentManagementSystemApplication implements CommandLineRunner {

    @Autowired
    StudentRepository studentRepository;

    public static void main(String[] args) {
        SpringApplication.run(StudentManagementSystemApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        Student student1 = new Student(1L, "sabin", "chand", "sabin@gmail.com");
//        studentRepository.save(student1);
//
//        Student student2 = new Student(2L, "aman", "kumar", "aman@gmail.com");
//        studentRepository.save(student2);
//
//        Student student3 = new Student(3L, "yogesh", "ghimire", "yogesh@gmail.com");
//        studentRepository.save(student3);
    }
}
