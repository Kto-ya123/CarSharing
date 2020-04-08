package org.example.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.example.config.ApiServiceConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.example.config.ApiProvider.*;

@Controller
@RequestMapping("/controller")
@RequiredArgsConstructor
public class BaseController {
    private final ApiServiceConfiguration configuration;

    @GetMapping("/")
    public String getBasicPage(Model model) {
        List<AuthorizeInfo> authorizeInfo = Stream.of(
                new AuthorizeInfo(FACEBOOK.name(), configuration.getFacebook().getAuthorizeQuery()),
                new AuthorizeInfo(GITHUB.name(), configuration.getGithub().getAuthorizeQuery()),
                new AuthorizeInfo(GOOGLE.name(), configuration.getGoogle().getAuthorizeQuery()))
                .collect(Collectors.toList());
        model.addAttribute("infoList", authorizeInfo);
        return "basic";
    }

    @Data
    @AllArgsConstructor
    private static class AuthorizeInfo {
        private String apiProviderName;
        private String url;
    }
}
