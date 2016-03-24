/**
 *
 */
package com.mellon.platform.core.controller;

import com.mellon.platform.privilege.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 */
@Controller
public class BaseController {

    @Autowired
    Environment env;

    public UserVO getCurrentAuth(HttpServletRequest request) {
        if (env != null && env.acceptsProfiles("local")) {
            UserVO userVO = new UserVO();
            userVO.setId(3L);
            userVO.setAccountName("admin");
            userVO.setOrgId(4);
            userVO.setName("罗斯");
            userVO.setSuperiorId(1);
            return userVO;
        } else {
            HttpSession session = request.getSession();
            return (UserVO) session.getAttribute("currentUser");
        }
    }
    
    public Long getUserId(HttpServletRequest request) {
        return Long.valueOf(this.getCurrentAuth(request).getId());
    }
}
