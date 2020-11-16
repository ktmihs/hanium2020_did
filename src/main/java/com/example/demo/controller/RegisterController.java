package com.example.demo.controller;

import com.example.demo.model.Group;
import com.example.demo.model.GroupDetail;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/sign_up")
public class RegisterController {

    @Autowired
    private UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @ModelAttribute("accountForm")
    public AccountForm registData() {return new AccountForm(); }

    @RequestMapping(method = RequestMethod.GET)
    public String showForm() {
        return "/sign_up";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String onSubmit(
            HttpServletRequest request, HttpSession session,
            @ModelAttribute("accountForm") AccountForm accountForm,
            BindingResult result) throws Exception {
        if (userService.findByUserId(accountForm.getUserId()) != null)
            return "/sign_up";
        System.out.println(accountForm.getUserId());
        if (accountForm.getPassword().equals(accountForm.getCheckPassword())) {
            User user = new User();
            user.setUserId(accountForm.getUserId());
            user.setUserName(accountForm.getName());
            user.setUserPassword(accountForm.getPassword());
            user.setUserBirth(accountForm.getBirth());
            user.setUserGender(accountForm.getGender());
            user.setUserPhone(accountForm.getPhone());
            user.setUserAddress(accountForm.getAddress());
            user.setUserEmail(accountForm.getEmail());
            // save new Group
            if (accountForm.getGroup().equals("o")) {
                Group group = new Group();
                group.setgId("o");
                group.setgName("기관");
//                    userService.save(group);
                if (userService.findBygcId(accountForm.getUserId()) != null) // groupDetail 리스트에 해당 group이 있다면
                    return "/sign_up";
                else { // 없다면 hi
                    GroupDetail groupDetail = new GroupDetail();
                    groupDetail.setGroup(group);
                    groupDetail.setGcName(accountForm.getUserId());
                    userService.save(groupDetail);
                    user.setGroup(group);
                }
            } else {
                Group group = new Group();
                group.setgId("x");
                group.setgName("개인");
//                    userService.save(group);
                user.setGroup(group);
            }
            userService.save(user);
            return "/index";
        }
        else
            return "/sign_up";
    }
}