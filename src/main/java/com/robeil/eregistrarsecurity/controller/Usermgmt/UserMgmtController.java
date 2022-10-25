package com.robeil.eregistrarsecurity.controller.Usermgmt;

import com.robeil.eregistrarsecurity.model.User;
import com.robeil.eregistrarsecurity.service.RoleService;
import com.robeil.eregistrarsecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping
public class UserMgmtController {

    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;

    /**
     * Displaying all user list
     */
    @GetMapping(value = {"/secured/services/admin/userManagement/list","/eRegistrar/secured/services/admin/userManagement/list"})
    public ModelAndView displayUsersList(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("users",userService.getAllUsers());
        modelAndView.setViewName("secured/services/admin/userManagement/list");
        return modelAndView;
    }

    /**
     *  display user new form
     * @return
     */
    @GetMapping(value = {"/secured/services/admin/userManagement/user/new","/eRegistrar/secured/services/admin/userManagement/user/new"})
    public ModelAndView displayNewUserForm(){
        ModelAndView modelAndView = new ModelAndView();
        User user = new User();
        modelAndView.addObject("user",user);
        modelAndView.setViewName("secured/services/admin/userManagement/new");
        return modelAndView;
    }

    /**
     * adding new user
     * @return
     */
    @PostMapping(value = {"/secured/services/admin/userManagement/user/new","/eRegistrar/secured/services/admin/userManagement/user/new"})
    public String addNewUser(@Valid @ModelAttribute("user") User user, Model model, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            model.addAttribute("errors",bindingResult.getAllErrors());
            return "redirect:/eRegistrar/secured/services/admin/userManagement/list";
        }
        userService.saveUser(user);
        return "redirect:/eRegistrar/services/admin/userManagement/list";
    }

    /**
     * edit user info
     * @return
     */
    @GetMapping(value = {"/secured/services/admin/userManagement/user/edit/{userId}","/eRegistrar/secured/services/admin/userManagement/user/edit/{userId}"})
    public String editUser(@PathVariable Integer userId, Model model){
        User user = userService.getUserById(userId);
        if(user != null){
            user.setPassword("");
            model.addAttribute("user",user);
            model.addAttribute("roles",roleService.getAllRoles());
            return "secured/services/admin/userManagement/list";
        }
        return "secured/services/admin/userManagement/list";
    }

    /**
     * updaet user
     * @return
     */
    @PostMapping(value = {"/secured/services/admin/userManagement/user/edit","/eRegistrar/secured/services/admin/userManagement/user/edit"})
    public String updateUser(@Valid @ModelAttribute("user") User user, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("errors",bindingResult.getAllErrors());
            return "secured/services/admin/userManagement/edit";
        }
        userService.saveUser(user);
        return "redirect:/eRegistrar/secured/services/admin/userManagement/list";
    }
}
