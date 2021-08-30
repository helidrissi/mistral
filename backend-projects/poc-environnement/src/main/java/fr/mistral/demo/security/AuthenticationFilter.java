package fr.mistral.demo.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.mistral.demo.SpringApplicationContext;
import fr.mistral.demo.domain.central.LoginUserRequest;
import fr.mistral.demo.domain.central.UserC;
import fr.mistral.demo.services.central.UserService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter {


    private final AuthenticationManager authenticationManager;

    public AuthenticationFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest req, HttpServletResponse res)
            throws AuthenticationException {
        try {

            LoginUserRequest creds = new ObjectMapper().readValue(req.getInputStream(), LoginUserRequest.class);
            String username = creds.getEmail();
            String group = creds.getEnv();
            username += "/" + group;
            return authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(username, creds.getPassword()));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
  /*  @Override
    protected String obtainUsername(HttpServletRequest request) {
        String username = super.obtainUsername(request);
        String group = request.getParameter("env");
        username += "/" + group;
        return username;
    }*/

    @Override
    protected void successfulAuthentication(HttpServletRequest req,
                                            HttpServletResponse res,
                                            FilterChain chain,
                                            Authentication auth) throws IOException, ServletException {

        String userName = ((User) auth.getPrincipal()).getUsername();
       // UserService userService = (UserService) SpringApplicationContext.getBean("userService");


        String token = Jwts.builder()
                .setSubject(userName)
                .setExpiration(new Date(System.currentTimeMillis() + SecurityConstants.EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS512, SecurityConstants.TOKEN_SECRET)
                .compact();


        res.addHeader(SecurityConstants.HEADER_STRING, SecurityConstants.TOKEN_PREFIX + token);

        res.getWriter().write("{\"token\": \"" + token);


    }
}
