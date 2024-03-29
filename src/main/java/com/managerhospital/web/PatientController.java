package com.managerhospital.web;

import com.managerhospital.dao.PatientDAO;
import com.managerhospital.entities.Patient;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@Controller
@Validated
public class PatientController {

    @Autowired PatientDAO patientDAO;

    @GetMapping("/")
    public String home() {
        return "redirect:/index";
    }

    @GetMapping("/index")
    public String index(Model model,
                        @RequestParam(name = "page", defaultValue = "0") int page,
                        @RequestParam(name = "size", defaultValue = "4") int size,
                        @RequestParam(name = "word", defaultValue = "") String mc
                        ) {
        Page<Patient> pagePatient = patientDAO.findByNomContains(mc, PageRequest.of(page,size));
        model.addAttribute("listPatient", pagePatient.getContent());
        model.addAttribute("pages", new int[pagePatient.getTotalPages()]);
        model.addAttribute("current", page);
        model.addAttribute("word", mc);
        model.addAttribute("patient", new Patient());
        return "index";
    }

    @GetMapping("/delete")
    public String delete(Long id, String word, int page) {
        patientDAO.deleteById(id);
        return "redirect:/index?page=" +page+ "&word=" +word;
    }

    @GetMapping("/newPatient")
    public String newPatient(Model model) {
        model.addAttribute("patient", new Patient());
        return "index";
    }

    @PostMapping("/savePatient")
    public String savePatient(@Valid Patient patient, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "index";
        }
        patientDAO.save(patient);
        return "redirect:/index?word="+patient.getNom();
    }

    @GetMapping("/editPatient")
    public String editPatient(Model model, @RequestParam(name = "id") Long id) {
        Patient patient = patientDAO.findById(id).get();
        model.addAttribute("patient", patient);
        return "editPatient";
    }


}

