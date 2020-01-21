package edu.gxu.sdqrps.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * @author cz
 * @date 2020/1/6 11:34 上午
 */
@Controller
@RequestMapping("/sdqrps")
public class GoToController {

    @RequestMapping("/home")
    public String gotoHome(){
        return "home";
    }

    @RequestMapping(value = {""})
    public String gotoLogin(){
        return "index";
    }

    @GetMapping("/logout")
    @ResponseBody
    public String logOut(HttpSession httpSession){
        httpSession.removeAttribute("userDetail");
       return "success";
    }

}
