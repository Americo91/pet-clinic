package astoppello.springframework.petclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by americo stoppello on 09/07/2020
 */
@Controller
public class VetController {

    @RequestMapping({"/vets","/vets/index", "/vets/index.html"})
    public String listVets(){
        return "vets/index.html";
    }
}
