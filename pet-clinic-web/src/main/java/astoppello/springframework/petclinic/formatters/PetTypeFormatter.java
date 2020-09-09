package astoppello.springframework.petclinic.formatters;

import astoppello.springframework.petclinic.model.PetType;
import astoppello.springframework.petclinic.services.PetTypeService;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;

/**
 * Created by @author stopp on 09/09/2020
 */
@Component
public class PetTypeFormatter implements Formatter<PetType> {

    private final PetTypeService petTypeService;

    public PetTypeFormatter(PetTypeService petTypeService) {
        this.petTypeService = petTypeService;
    }


    @Override
    public PetType parse(String s, Locale locale) throws ParseException {
        return petTypeService.findAll()
                             .stream()
                             .filter(petType -> s.equalsIgnoreCase(petType.getName()))
                             .findFirst()
                             .orElseThrow(() -> new ParseException("Type not found: " + s, 0));
    }

    @Override
    public String print(PetType petType, Locale locale) {
        return petType.getName();
    }
}
