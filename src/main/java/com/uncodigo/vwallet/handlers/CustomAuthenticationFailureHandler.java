package com.uncodigo.vwallet.handlers;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import java.io.IOException;

public class CustomAuthenticationFailureHandler implements AuthenticationFailureHandler{

    // Logger
    private static final Logger logger = LogManager.getLogger(CustomAuthenticationFailureHandler.class);

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException {
        logger.error("Error authenticating user onAuthenticationFailure", exception);
        request.getSession().setAttribute("loginError", "Credenciales inválidas. Intente de nuevo.");
        response.sendRedirect("/auth/login");
    }
}