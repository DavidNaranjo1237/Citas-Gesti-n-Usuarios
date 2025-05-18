/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.config;

import jakarta.servlet.Filter;

public class JwtTokenFilter implements Filter {

    public JwtTokenFilter() {
    }

    @Override
    public void doFilter(jakarta.servlet.ServletRequest request, jakarta.servlet.ServletResponse response,
            jakarta.servlet.FilterChain chain)
            throws java.io.IOException, jakarta.servlet.ServletException {

        chain.doFilter(request, response);
    }

    @Override
    public void init(jakarta.servlet.FilterConfig filterConfig) throws jakarta.servlet.ServletException {
        // Optional: initialization logic
    }

    @Override
    public void destroy() {
        // Optional: cleanup logic
    }
}
