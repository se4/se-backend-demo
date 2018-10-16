package nju.se4.demo.security;

//import cn.edu.nju.tagmakers.countsnju.CountsnjuApplication;
//import cn.edu.nju.tagmakers.countsnju.entity.user.RoleWorker;
//import cn.edu.nju.tagmakers.countsnju.logic.service.WorkerDistributionService;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class JWTLoginFilter extends UsernamePasswordAuthenticationFilter {

    private final String NOOP = "{noop}";
    private AuthenticationManager authenticationManager;

    public JWTLoginFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }
    @Override
    public Authentication attemptAuthentication(HttpServletRequest req,
                                                HttpServletResponse res) throws AuthenticationException {
        try {
            SecurityUser securityUser = new ObjectMapper()
                    .readValue(req.getInputStream(), SecurityUser.class);
            //这里的security user是从前端的包生成的，所以密码里不含noop，因此要在这里手动加上
            //不！！！Spring security在解析密码的时候会自动去掉noop，所以登录不用加noop
            securityUser.setSecurityPassword(securityUser.getPassword());
            return authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            securityUser.getUsername(),
                            securityUser.getPassword(),
                            new ArrayList<>())
            );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    protected void successfulAuthentication(HttpServletRequest req,
                                            HttpServletResponse res,
                                            FilterChain chain,
                                            Authentication auth) {

        String token = Jwts.builder()
                .setSubject(((SecurityUser) auth.getPrincipal()).getUsername())
                .setExpiration(new Date(System.currentTimeMillis() + 60 * 60 * 24 * 1000))
                .signWith(SignatureAlgorithm.HS512, "ymymym")
                .compact();
        res.addHeader("Authorization", "Bearer " + token);
        res.addHeader("Roles", "STUDENT");

    }


}