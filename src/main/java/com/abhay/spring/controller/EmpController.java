package com.abhay.spring.controller;

import com.abhay.spring.model.Emp;
import com.abhay.spring.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class EmpController {

    @Autowired
    private EmpService empService;

    @RequestMapping(value = "/empform")
    public String showForm(Model model) {
        model.addAttribute("command", new Emp());
        return "empForm";
    }
    @RequestMapping(value = "/")
    public String homePage(){
        return "index";
    }


    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public String save(@ModelAttribute("emp") Emp emp){
        empService.saveEmp(emp);
       return "redirect:/viewemp";
    }

    @RequestMapping(value = "/viewemp")
    public String viewEmp(Model model){
        List<Emp> list = empService.getAllEmployees();
        model.addAttribute("list",list);
        return "viewEmp";
    }

    @RequestMapping("/editemp/{id}")
    public String editForm(@PathVariable int id, Model m){
        Emp emp = empService.getEmpById(id);
        m.addAttribute("command",emp);
        return "empEditForm";
    }

    @RequestMapping(value = "/editsave", method = RequestMethod.POST)
    public String editSave(@ModelAttribute("emp") Emp emp){
        empService.updateEmpDetails(emp);
        return "redirect:/viewemp";
    }

    @RequestMapping(value = "/deleteemp/{id}",method = RequestMethod.GET)
    public String deleteEmp(@PathVariable int id){
        empService.deleteEmp(id);
        return "redirect:/viewemp";
    }
}