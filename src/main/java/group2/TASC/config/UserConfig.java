//package group2.TASC.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.User.*;
//import org.springframework.web.servlet.view.InternalResourceViewResolver;
//
//@Configuration
//@EnableWebSecurity
//public class UserConfig extends WebSecurityConfigurerAdapter {
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        // add our users for in memory authentication
//        UserBuilder users = User.withDefaultPasswordEncoder();
//
//        auth.inMemoryAuthentication()
//                .withUser(users.username("Admin_TASC").password("adminTASC").roles("ADMIN"))
//                .withUser(users.username("Surya").password("Surya").roles("TA", "STUDENT"));
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.csrf().disable()
//                .authorizeRequests()
//                .antMatchers("/").hasAnyRole("ADMIN","TA","STUDENY")
//                .antMatchers("/seecourse","/seeschedule").hasAnyRole("TA","STUDENT")
//                .and().formLogin().loginPage("/login").loginProcessingUrl("/authenticateTheUser")
//                .failureUrl("/login-error").permitAll()
//                .and().logout().permitAll()
//                .and().exceptionHandling().accessDeniedPage("/access-denied");
//    }
//
//
//}
