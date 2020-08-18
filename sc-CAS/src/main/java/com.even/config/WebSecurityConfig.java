package com.even.config;

import org.springframework.boot.actuate.autoconfigure.security.servlet.EndpointRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * @author 北方、
 * @title: WebSecurityConfig
 * @projectName sc
 * @description: TODO
 * @date 2020/8/8 18:54
 */
@Component
@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
//@Order(-1)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

/*    @Autowired
    UserServiceImpl UserServiceImpl;*/

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .requestMatchers(EndpointRequest.toAnyEndpoint()).permitAll()
                .antMatchers("/rsa/publicKey").permitAll()
                .anyRequest().authenticated().and().csrf().disable();
//        http.authorizeRequests().antMatchers("/oauth/token","/test").permitAll().and().cors().and().csrf().disable().formLogin().and().authorizeRequests().anyRequest().authenticated();
      /*  http.authorizeRequests()
//                .antMatchers(HttpMethod.OPTIONS, "/oauth/**").permitAll()
//                .antMatchers(HttpMethod.POST, "/oauth/**").permitAll()
//                .requestMatchers(EndpointRequest.toAnyEndpoint()).permitAll()
                .antMatchers("/rsa/publicKey","/","/token","/oauth/**","/login","/health", "/css/**").permitAll()
                .and()
                .cors().and()
                .csrf().disable()
                .formLogin().and()
                .authorizeRequests().anyRequest().authenticated();*/
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

   /* public static void main(String[] args) {
        String password = "123456";
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String encode = bCryptPasswordEncoder.encode(password);
        System.out.println(encode);
    }*/
}
