package com.astontech.oauth2.api.filters;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class CustomFilter extends OncePerRequestFilter{

//    SUCH HEADERS WOW
//    https://www.tutorialspoint.com/http/http_header_fields.htm

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        response.addHeader("Company", "Aston");
        response.addHeader("Business-Unit", "Dev");

        filterChain.doFilter(request, response);
    }
}
