package pl.sda20.bootcamp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pl.sda20.bootcamp.model.Trener;
import pl.sda20.bootcamp.service.TrenerService;

@Controller
@RequestMapping("/trenerzy")
public class TrenerController {

    @Autowired
    private TrenerService trenerService;

    @RequestMapping(value = "/form-trener", method = RequestMethod.GET)
    public String createTrener(Model model){

        Trener trener = Trener.builder().build();
        model.addAttribute("trener", trener);
        return "trener/formularz-trener";



    }

    @RequestMapping(value = "/add-trener", method = RequestMethod.POST)
    public String addTrener(Trener trener,
                             Model model) {

        trenerService.save(trener);
        model.addAttribute("trener", trener);
        return "trener/add-trener";
    }


    @RequestMapping(value = "/trenerzy", method = RequestMethod.GET)
    public String trainerList(Model model){

        model.addAttribute("allTreners", trenerService.getAll());
        return "trener/lista-trenerow";
    }

    @RequestMapping(value = "/trenerzy-po-usunieciu", method = RequestMethod.GET)
    public String listaTrenerowPoUsunieciu(Model model,
                                          @RequestParam Long id){
        trenerService.deleteById(id);
        model.addAttribute("allTreners", trenerService.getAll());
        return "trener/lista-trenerow";
    }

    @RequestMapping(value = "/edit")
    public String edytowanieTrenera(Model model,
                                    @RequestParam Long id){

        model.addAttribute("trener", trenerService.getTrener(id));
        return "trener/edit-trener";
    }


}
