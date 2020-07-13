package org.launchcode.javawebdevtechjobspersistent.controllers;

import org.launchcode.javawebdevtechjobspersistent.models.Employer;
import org.launchcode.javawebdevtechjobspersistent.models.data.EmployerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("employers")
public class EmployerController {

    @Autowired
    private EmployerRepository employerRepository;

    @GetMapping("add")
    public String displayAddEmployerForm(Model model) {
        model.addAttribute(new Employer());
        return "employers/add";
    }

    @PostMapping("add")
    public String processAddEmployerForm(@ModelAttribute @Valid Employer newEmployer,
                                    Errors errors, Model model) {
        if (errors.hasErrors()) {
            return "employers/add";
        }
            employerRepository.save(newEmployer);
        return "employers/index";
    }

    /*@GetMapping
    public String displayEmployersIndex(@RequestParam(required = false) Model model) {

        return "employers/index";
    }*/

    @GetMapping("index")
    public String displayEmployers(Model model) {

        model.addAttribute("title", "All Employers");
        model.addAttribute("events", employerRepository.findAll());

        return "employers/index";
    }

    @GetMapping("view/{employerId}")
    public String displayViewEmployer(Model model, @PathVariable(required = false) Integer employerId) {

        Optional optEmployer = employerRepository.findById(employerId);
        if (employerId == null) {
            model.addAttribute("title", "All Employers");
            model.addAttribute("employers", employerRepository.findAll());
        } else if (optEmployer.isPresent()) {
            Employer employer = (Employer) optEmployer.get();
            model.addAttribute("employer", employer);
            return "employers/view";
        } else {
            return "redirect:../";
        }

        return "employers/view";
    }
}
