package astoppello.springframework.petclinic.controllers;

import astoppello.springframework.petclinic.model.Owner;
import astoppello.springframework.petclinic.model.Pet;
import astoppello.springframework.petclinic.services.OwnerService;
import astoppello.springframework.petclinic.services.PetService;
import astoppello.springframework.petclinic.services.VisitService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class VisitControllerTest {

    public static final String VIEW_PETS_CREATE_OR_UPDATE_VISITOR_FORM = "pets/createOrUpdateVisitorForm";

    @Mock
    PetService petService;
    @Mock
    VisitService visitService;
    @Mock
    OwnerService ownerService;

    @InjectMocks
    VisitController visitController;

    Pet pet;

    MockMvc mockMvc;
    Owner owner;

    @BeforeEach
    void setUp() {
        pet = Pet.builder()
                 .id(1l)
                 .build();
        owner = Owner.builder()
                     .id(1l)
                     .build();
        mockMvc = MockMvcBuilders.standaloneSetup(visitController)
                                 .build();
    }

    @Test
    void initNewVisitForm() throws Exception {
        when(petService.findById(anyLong())).thenReturn(pet);
        when(ownerService.findById(anyLong())).thenReturn(owner);
        mockMvc.perform(get("/owners/1/pets/1/visits/new"))
               .andExpect(status().isOk())
               .andExpect(model().attributeExists("visit"))
               .andExpect(view().name(VIEW_PETS_CREATE_OR_UPDATE_VISITOR_FORM));
        verifyNoInteractions(visitService);
    }

    @Test
    void processNewVisitForm() throws Exception {
        when(petService.findById(anyLong())).thenReturn(pet);
        when(ownerService.findById(anyLong())).thenReturn(owner);
        mockMvc.perform(post("/owners/1/pets/1/visits/new")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("date", "2018-11-11")
                .param("description", "description"))
               .andExpect(status().is3xxRedirection())
               .andExpect(view().name("redirect:/owners/1"));
        verify(visitService).save(any());
    }
}