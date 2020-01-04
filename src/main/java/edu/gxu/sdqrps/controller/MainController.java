package edu.gxu.sdqrps.controller;

import edu.gxu.sdqrps.model.vo.Result;
import edu.gxu.sdqrps.model.vo.UserDetail;
import edu.gxu.sdqrps.service.DetailService;
import edu.gxu.sdqrps.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * @author cz
 * @date 2019/12/28 9:10 下午
 */
@Controller
@RequestMapping("/sdqrps")
public class MainController {
    private UserService userService;
    private DetailService detailService;

    @Autowired
    public MainController(UserService userService, DetailService detailService) {
        this.userService = userService;
        this.detailService = detailService;
    }

    @PostMapping(value = "/login")
    @ResponseBody
    public Result login(@RequestParam("userName") String userName,
                        @RequestParam("password") String password,
                        HttpSession httpSession){
        Result result = userService.checkUser(userName, password);
        if(result.getCode() == 100)
            httpSession.setAttribute("userDetail", result.getInfo());

        return result;
    }

    @GetMapping(value = "/details/{contentId}")
    @ResponseBody
    public Result showDetails(@SessionAttribute(value = "userDetail", required = false)UserDetail userDetail ,
                              @PathVariable("contentId") int contentId){
        return detailService.getAllWithUserIdAndContentId(userDetail.getUserId(), contentId);
    }
}
