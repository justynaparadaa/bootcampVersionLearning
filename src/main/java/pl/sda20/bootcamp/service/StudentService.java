package pl.sda20.bootcamp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sda20.bootcamp.model.Student;
import pl.sda20.bootcamp.repository.StudentRepository;

import java.util.List;

@Service
public class StudentService {

    @Autowired // wstrzykiwanie, nie rozumiem o co chodzi ale może jest na slajdach, żeby stworzyło juz obiekt i żeby wszędzei to wstrzykiwało
    private StudentRepository studentRepository;

    public void save(Student student){
        studentRepository.save(student);
    }


    public List<Student> getAll() {
        return studentRepository.findAll();
    }

    public void deleteById(Long id) {
        studentRepository.deleteById(id);
    }

    public Student getStudent(Long id) {
        return studentRepository.getOne(id);
    }
}
