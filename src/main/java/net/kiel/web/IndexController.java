package net.kiel.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by kiel on 2016. 4. 26..
 */
@Controller
public class IndexController {
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("body", "Hello, World");
        return "index";
    }
}
