package pl.sda20.bootcamp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sda20.bootcamp.model.Trener;
import pl.sda20.bootcamp.repository.TrenerRepository;

import java.util.List;

@Service
public class TrenerService {

    @Autowired
    private TrenerRepository trenerRepository;

    public void save(Trener trener){
        trenerRepository.save(trener);
    }

    public List<Trener> getAll() {
       return trenerRepository.findAll();
    }

    public void deleteById(Long id) {
        trenerRepository.deleteById(id);
    }

    public Trener getTrener(Long id) {
        return trenerRepository.getOne(id);
    }
}
