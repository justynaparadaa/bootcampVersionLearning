package pl.sda20.bootcamp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.sda20.bootcamp.model.Student;
import pl.sda20.bootcamp.service.StudentService;

@Controller
@RequestMapping(value = "/student")
public class StudentController {

    Logger logger = LoggerFactory.getLogger(StudentController.class);

    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "/form-student", method = RequestMethod.GET)
    public String dodajNowegoKursanta(Model model) {
        Student student = Student.builder().build();
        model.addAttribute("student", student);
        return "student/formularz-student";
    }

    @RequestMapping(value = "/add-student", method = RequestMethod.POST)
    public String addStudentByObject(Student student, // nie podajemu juz RequestParam bo mamy tutaj object caly dodany
                                     Model model) {

//        model.addAttribute("firstName", student.getFirstName());
//        model.addAttribute("lastName", student.getLastName());
//        model.addAttribute("email", student.getEmail());
//        model.addAttribute("phone", student.getPhone());
//        model.addAttribute("course", student.getCourse());
//        model.addAttribute("mode", student.getMode());

        studentService.save(student);
        model.addAttribute("student", student);
        logger.info("Pokaż parametry: " + student);
        return "student/add-student";
    }

    @RequestMapping(value = "/kursanci", method = RequestMethod.GET)
    public String listaKursantow(Model model) {

        model.addAttribute("allStudents", studentService.getAll());
        return "student/lista-kursantow";
    }

    @RequestMapping(value = "/kursanci-po-usunieciu", method = RequestMethod.GET)
    public String listaKursantowPoUsunieciu(Model model,
                                            @RequestParam Long id) {

        studentService.deleteById(id);
        model.addAttribute("allStudents", studentService.getAll());

        return "student/lista-kursantow";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String edytowanieStudenta(@RequestParam Long id, Model model) {

        model.addAttribute("student", studentService.getStudent(id));
        return "student/edit-student";
    }

    //    @RequestMapping(value = "/add-student", method = RequestMethod.POST)
//    public String addStudent(@RequestParam String firstName,
//                             @RequestParam String lastName,
//                             @RequestParam String email,
//                             @RequestParam String phone,
//                             @RequestParam String course,
//                             @RequestParam String mode,
//                             Model model) {
//
//        model.addAttribute("firstName", firstName);
//        model.addAttribute("lastName", lastName);
//        model.addAttribute("email", email);
//        model.addAttribute("phone", phone);
//        model.addAttribute("course", course);
//        model.addAttribute("mode", mode);
//
//        return "add-student"; // zwracamy tutaj naszą stronę główną, dlatego wpisujemy tutaj home który jest w templates!
//    }
}
