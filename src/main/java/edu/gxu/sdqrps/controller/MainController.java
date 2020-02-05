package edu.gxu.sdqrps.controller;

import edu.gxu.sdqrps.model.vo.InfoResult;
import edu.gxu.sdqrps.model.vo.UserDetail;
import edu.gxu.sdqrps.service.DetailService;
import edu.gxu.sdqrps.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.stream.Stream;

/**
 * @author cz
 * @date 2019/12/28 9:10 下午
 */
@RestController
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
    public InfoResult login(@RequestParam("userName") String userName,
                            @RequestParam("password") String password,
                            HttpSession httpSession) {
        InfoResult infoResult = userService.checkUser(userName, password);
        if (infoResult.getCode() == 100)
            httpSession.setAttribute("userDetail", infoResult.getInfo());
        return infoResult;
    }

    @GetMapping(value = {"/details/t/{contentId}", "/details/t/{contentId}/{indexId}"})
    public InfoResult showDetails(@SessionAttribute(value = "userDetail", required = false) UserDetail userDetail,
                                  @PathVariable("contentId") int contentId,
                                  @PathVariable(value = "indexId", required = false) Integer indexId) {
        return detailService.getAllWithUserIdAndContentId(userDetail.getUserId(), contentId, indexId);
    }

    @GetMapping("/getUserDes")
    public InfoResult getUserDes(HttpSession httpSession) {
        UserDetail userDetail = (UserDetail) httpSession.getAttribute("userDetail");
        if (userDetail != null)
            return new InfoResult<String>(300, userDetail.getDescription());
        else
            return new InfoResult<String>(301, "无");
    }

    @PostMapping("/edit")
    public InfoResult edit(@RequestParam("contentId") int contentId,
                           @SessionAttribute("userDetail") UserDetail userDetail,
                           @RequestParam("indexId") int indexId,
                           @RequestParam("qualityControlId") int qualityControlId,
                           @RequestParam("newValue") int newValue,
                           @RequestParam("type") String type) {
        if (type.equals("target"))
            return detailService.updateTargetValue(contentId, userDetail.getUserId(), indexId, qualityControlId, newValue);
        else if (type.equals("standard"))
            return detailService.updateStandardValue(contentId, userDetail.getUserId(), indexId, qualityControlId, newValue);
        else if (type.equals("preWarningValue"))
            return detailService.updatePreWarningValue(contentId, userDetail.getUserId(), indexId, qualityControlId, newValue);
        else
            return new InfoResult<String>(401, "编辑有误");
    }


    @GetMapping("/showProject/{qualityControlId}")
    public InfoResult showProject(@PathVariable("qualityControlId") int qualityControlId) {
        return detailService.getProjectWithQualityControlId(qualityControlId);
    }

    @GetMapping(value = {"/details/c/{contentId}", "/details/c/{contentId}/{indexId}"})
    public InfoResult getRatioData(@SessionAttribute(value = "userDetail", required = false) UserDetail userDetail,
                                   @PathVariable("contentId") int contentId,
                                   @PathVariable(value = "indexId", required = false) Integer indexId){
        return detailService.getRatioNum(userDetail.getUserId(),contentId,indexId);
    }


}
