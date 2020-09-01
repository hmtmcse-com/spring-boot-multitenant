package com.hmtmcse.multitenant.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class AuthenticationController {

    private boolean isLogged() {
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return null != authentication && !("anonymousUser").equals(authentication.getName());
    }

    @RequestMapping("/")
    public String login() {
        if (isLogged()){
            return "redirect:/create/";
        }
        return "authentication/login";
    }


    @RequestMapping("/logout")
    public String logout() {
        return "redirect:/";
    }
}
