package com.example.demo.Controller;

import com.example.demo.Entity.User;
import com.example.demo.Repository.UserRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class collaboratorController {
    @Autowired
    UserRep userReppository;

    @GetMapping("addCollaborator")
    public String add(Model model)
    {
        model.addAttribute("collaborator",new User());
        return "addCollaborator";
    }

    @GetMapping("addedCollaborator")
    public String add1(Model model, @ModelAttribute User user)
    {
        if(user.getEmail()==""||user.getUserName()==""||user.getConfirm()==""||user.getPassword()==""||user.getStoreOwnerEmail()=="")
        {
            model.addAttribute("err","enter the information again");
            add(model);
            return "addCollaborator";
        }
        if(!user.getPassword().equals(user.getConfirm()))
        {
            model.addAttribute("err","enter the password and the confirmation again");
            add(model);
            return "addCollaborator";
        }
        if(userReppository.findOne(user.getEmail())==null)
        {
            user.setType("collaborator");
            userReppository.save(user);
            return "collaboratorHome";
        }
        return "addCollaborator";
    }
}
