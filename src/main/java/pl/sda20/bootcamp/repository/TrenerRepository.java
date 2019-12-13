package pl.sda20.bootcamp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.sda20.bootcamp.model.Trener;

@Repository
public interface TrenerRepository extends JpaRepository<Trener, Long> {
}
