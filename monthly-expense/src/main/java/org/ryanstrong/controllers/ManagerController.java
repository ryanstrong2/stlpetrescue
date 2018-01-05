package org.ryanstrong.controllers;

import org.ryanstrong.models.Employee;
import org.ryanstrong.models.Manager;
import org.ryanstrong.models.data.EmployeeDao;
import org.ryanstrong.models.data.ManagerDao;
import org.ryanstrong.models.forms.ChangeListForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class ManagerController {

    @Autowired
    private ManagerDao managerDao;

    @Autowired
    private EmployeeDao employeeDao;

    @RequestMapping(value = "")
    public String index(Model model) {
        model.addAttribute("title", "Home");
        model.addAttribute("managers", managerDao.findAll());
        return "index";
    }

    @RequestMapping(value = "new", method = RequestMethod.GET)
    public String newManager(Model model) {
        model.addAttribute("title", "New Manager");
        model.addAttribute(new Manager());
        return "manager/new";
    }

    @RequestMapping(value = "new", method = RequestMethod.POST)
    public String add(Model model, @ModelAttribute @Valid Manager newManager, Errors errors) {
        if (errors.hasErrors()) {
            return "manager/new";
        }
        managerDao.save(newManager);
        return "redirect:view/" + newManager.getId();
    }

    @RequestMapping(value = "add/{managerId}", method = RequestMethod.GET)
    public String add(Model model, @PathVariable Integer managerId) {
        model.addAttribute("title", "Add Employees");
        model.addAttribute("employees", employeeDao.findAll());

        Manager manager = managerDao.findOne(managerId);
        ChangeListForm form = new ChangeListForm(
                manager.getEmployees(), employeeDao.findAll(), manager);
        model.addAttribute("expense", manager.getExpense());

        model.addAttribute("form", form);
        return "manager/add";
    }

    @RequestMapping(value = "remove-time", method = RequestMethod.POST)
    public String removeTime(
            Model model, @ModelAttribute @Valid ChangeListForm form,
//            @RequestParam @Valid int timeToPlay,
            Errors errors) {
        if (errors.hasErrors()) {
            model.addAttribute("form", form);
            return "user/remove-time";
        }
        Manager theManager = managerDao.findOne(form.getManagerId());
//        Timer theTimer = timerDao.findOne(form.getTimerId());
        Employee pay = employeeDao.findOne(form.getEmployeePay());
        Integer thePay = (form.getEmployeePay());
        Integer theExpense = theManager.getExpense();
        Integer total = thePay + theExpense;
        theManager.setAllocation(total);

        managerDao.save(theManager);
        return "redirect:/view/" + theManager.getId();

    }
}