package pl.cinema.cinema_project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.cinema.cinema_project.services.NewsService;

import java.awt.print.Pageable;

@Controller
public class main_controller {
    @Autowired
    NewsService newsService;

    @RequestMapping(value = "/", method = {RequestMethod.GET, RequestMethod.POST})
    public String showIndex(Model model, Pageable pageable) {
        model.addAttribute("newsListPage", newsService.getALLNews((org.springframework.data.domain.Pageable) pageable));
        return "index";
    }

    @GetMapping(value = "/kontakt")
    public String showContact(Model model) {
        model.addAttribute("contact", "coś tam");
        return "contact";
    }

    @GetMapping(value = "/cennik")
    public String showOffers(Model model) {
        model.addAttribute("offers", "Jakaś oferta");
        return "offers";
    }

    @GetMapping(value = "/repertuar")
    public String showNews(Model model) {
        model.addAttribute("news", "jakieś newsy");
        return "repertoire";
    }

    @GetMapping(value = "panel_administratora")
    public String logInAdminPane(Model model) {
        return "login";
    }

    @PostMapping(name = "login")
    public void loginData(Model model) {


    }
}
