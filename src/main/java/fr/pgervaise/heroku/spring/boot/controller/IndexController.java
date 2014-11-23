package fr.pgervaise.heroku.spring.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 * @author pgervaise
 *
 */
@Controller
public class IndexController {

    @RequestMapping({"/", "/index"})
    public String viewInOdex(Model model) {
        return "index";
    }
}
