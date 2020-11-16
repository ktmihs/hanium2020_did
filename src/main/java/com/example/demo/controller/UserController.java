package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@SessionAttributes("userSession")
public class UserController {

    @Autowired
    UserService userService;

    //User user;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }


    @ModelAttribute("currentLogin")
    public CurrentLogin loginData(){return new CurrentLogin(); }

    @RequestMapping("/login")
    public String handleRequest(HttpServletRequest request,
                                @ModelAttribute("CurrentLogin") CurrentLogin loginData, Model uiModel ) {
        User user = userService.findByUserIdAndUserPassword(loginData.getUserId(), loginData.getPassword());
        if (user == null)       //로그인 창에 아무것도 안 썼을 때
            return "/login";
        if (loginData.getPassword().equals(user.getUserPassword())) {       //회원가입 한 아이디와 비밀번호로 로그인 시
            UserSession userSession = new UserSession(user, loginData().getUserId());
            uiModel.addAttribute("userSession", userSession);
            return "/index_login";
        }
        else                    //로그인 시도한 user정보가 db와 다를 경우
            return "/login";
    }

    @RequestMapping("/loginout")
    public String logout(HttpSession session, SessionStatus sessionStatus){
        session.removeAttribute("userSession");
        sessionStatus.setComplete();
        return "/index";
    }

    @RequestMapping(method = RequestMethod.GET)
    public String showForm() {
        return "/sign_up";
    }


    @RequestMapping("/profile")
    public String viewProfilePage(Model uiModel, HttpServletRequest httpServlet) {
        UserSession userSession = (UserSession) WebUtils.getSessionAttribute(httpServlet, "userSession");
        User user = userSession.getUser();

        uiModel.addAttribute("userInfo", user);

        return "profile";
    }

    @RequestMapping("/profile_edit")
    public String viewProfileEditPage(Model uiModel, HttpServletRequest httpServlet) {
        UserSession userSession = (UserSession) WebUtils.getSessionAttribute(httpServlet, "userSession");
        String userId =userSession.getUser().getUserId();
        User user = userSession.getUser();

        uiModel.addAttribute("userInfo", user);

        return "profile_edit";
    }

    @RequestMapping("/profile_edit_")
    public String updateProfile(Model uiModel, HttpServletRequest httpServlet, @RequestParam("updateNewPassword1") String updateNewPassword1, @RequestParam("updateNewPassword2") String updateNewPassword2, @RequestParam("updateUserEmail") String updateUserEmail, @RequestParam("updateUserAddress") String updateUserAddress, @RequestParam("updateUserPhone") String updateUserPhone){
        UserSession userSession = (UserSession) WebUtils.getSessionAttribute(httpServlet, "userSession");
        String userId =userSession.getUser().getUserId();

        //비밀번호를 수정하거나 주소, 이메일등을 수정할 시에 데이터베이스 업데이트
        if((updateNewPassword1 == updateNewPassword2) || (updateNewPassword1==null && updateNewPassword2 ==null)){
            User user = userService.findByUserId(userId);
            User e;
            user.setUserAddress(updateUserAddress);
            user.setGroup(user.getGroup());
            user.setUserBirth(user.getUserBirth());
            user.setUserEmail(updateUserEmail);
            user.setUserPhone(updateUserPhone);
            user.setUserGender(user.getUserGender());
            user.setUserInputdate(user.getUserInputdate());
            user.setUserName(user.getUserName());
            user.setUserPassword(updateNewPassword1);
            userService.save(user);

            uiModel.addAttribute("address", user.getUserAddress());
            uiModel.addAttribute("phone", user.getUserPhone());
            uiModel.addAttribute("email", user.getUserEmail());
        }
        return "profile";
    }


}
