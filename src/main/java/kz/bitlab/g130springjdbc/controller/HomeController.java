package kz.bitlab.g130springjdbc.controller;

import kz.bitlab.g130springjdbc.entity.Country;
import kz.bitlab.g130springjdbc.service.CountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final CountryService countryService;

    @GetMapping("/")
    public String home(Model model) {
        List<Country> countries = countryService.getAllCountries();
        model.addAttribute("countries", countries);
        return "home";
    }
}
