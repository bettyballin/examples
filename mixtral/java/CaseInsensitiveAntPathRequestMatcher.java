package com.example.security;

import javax.servlet.http.HttpServletRequest;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.util.Assert;

public class CaseInsensitiveAntPathRequestMatcher implements RequestMatcher {

    private final AntPathRequestMatcher antPattern;

    public CaseInsensitiveAntPathRequestMatcher(String pattern) {
        Assert.hasText(pattern, "Pattern cannot be null or empty");
        this.antPattern = new AntPathRequestMatcher(pattern, null, false);
    }

    @Override
    public boolean matches(HttpServletRequest request) {
        return this.antPattern.matches(request);
    }
}