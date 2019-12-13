package pl.sda20.bootcamp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    @RequestMapping(value = "/strona-glowna-requestParam", method = RequestMethod.GET)
    public String homePage(@RequestParam(name = "imie") String firstName,
                           @RequestParam(name = "nazwisko") String lastName,
                           @RequestParam(name = "wiek") int age,
                           Model model) {

        model.addAttribute("firstN", firstName);
        model.addAttribute("lastN", lastName);
        model.addAttribute("age", age);
        return "home";
    }

    @RequestMapping(value = "/strona-glowna", method = RequestMethod.GET)
    public String homePage(Model model) {
        return "home";
    }

    @RequestMapping(value = "/strona-glowna-przekierowanie", method = RequestMethod.GET)
    public String homePagePrzekierowanie() {
        return "redirect:przekierwowanie";
    }

    @RequestMapping(value = "/strona-glowna-forward", method = RequestMethod.GET)
    public String homePageForward() {
        return "forward:forward-page";
    }

    @RequestMapping(value = "/kursy", method = RequestMethod.GET)
    public String listaKursow() {
        return "lista-kursow";
    }

    @RequestMapping(value = "/trenerzy", method = RequestMethod.GET)
    public String listaTrenerow() {
        return "lista-trenerow";
    }

    @RequestMapping(value = "/przekierwowanie", method = RequestMethod.GET)
    public String redirectPage() {
        return "redirect";
    }

    @RequestMapping(value = "/forward-page", method = RequestMethod.GET)
    public String forwardPage() {
        return "forward";
    }


}
