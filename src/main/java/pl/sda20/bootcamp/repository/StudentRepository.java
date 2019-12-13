package pl.sda20.bootcamp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.sda20.bootcamp.model.Student;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> getByCourse(String course);
    List<Student> getFirst10ByCourseAndMode(String cource, String mode);


}
