package edu.gxu.sdqrps.controller;

import edu.gxu.sdqrps.model.vo.InfoResult;
import edu.gxu.sdqrps.model.vo.UserDetail;
import edu.gxu.sdqrps.service.DetailService;
import edu.gxu.sdqrps.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @author cz
 * @date 2020/2/5 4:27 下午
 */
@RestController
@RequestMapping("/sdqrps")
public class AdminController {
    private UserService userService;
    private DetailService detailService;

    @Autowired
    public AdminController(UserService userService, DetailService detailService) {
        this.userService = userService;
        this.detailService = detailService;
    }

    @GetMapping("/getMenus")
    public InfoResult getUsers(HttpSession httpSession) {
        if (((UserDetail) httpSession.getAttribute("userDetail")).getLevel() == 1)
            return userService.getAllUserDes();
        else
            return new InfoResult<String>(701, "没有权限");
    }

    @GetMapping("/getSchoolStatistics/{userId}")
    public InfoResult getSchoolStatistics(HttpSession httpSession,
                                          @PathVariable("userId") int userId) {
        UserDetail userDetail = (UserDetail) httpSession.getAttribute("userDetail");
        if (userDetail.getUserId() == userId || userDetail.getLevel() == 1)
            return detailService.getSchoolStatistics(userId);
        else
            return new InfoResult<String>(801, "权限不足");
    }

}
