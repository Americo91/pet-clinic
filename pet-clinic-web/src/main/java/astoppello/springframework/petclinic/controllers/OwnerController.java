package astoppello.springframework.petclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by americo stoppello on 09/07/2020
 */
@RequestMapping("/owners")
@Controller
public class OwnerController {

    @RequestMapping({"", "/", "/index", "/index.html"})
    public String listOwners(){
        return "owners/index.html";
    }
}
