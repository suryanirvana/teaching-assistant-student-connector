package group2.TASC.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import group2.TASC.model.TeachingAssistant;
import group2.TASC.model.User;
import group2.TASC.repository.UserRepo;
import group2.TASC.security.SecurityConfig;
import group2.TASC.security.UserDetailsServiceImpl;
import group2.TASC.service.StudentService;
import group2.TASC.service.TeachingAssistantService;
import group2.TASC.service.UserService;
import group2.TASC.service.UserServiceImpl;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.MockMvcAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.ui.Model;
import org.springframework.web.context.WebApplicationContext;

import java.util.Arrays;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

//@ContextConfiguration(classes = main.class)
@WebMvcTest(controllers = UserController.class)
@WebAppConfiguration
public class UserControllerTest {

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    UserService userService;

    @MockBean
    StudentService studentService;

    @MockBean
    TeachingAssistantService teachingAssistantService;

    @MockBean
    UserDetailsServiceImpl userDetailsService;

    @Mock
    Model model;

    @Mock
    Authentication authentication;

    @MockBean
    UserRepo userRepo;

    User user;

    @Autowired
    private WebApplicationContext wac ;

    @BeforeEach
    public void setUp() {
        this.mockMvc = webAppContextSetup(wac).build();
        System.out.println(Arrays.toString(wac.getBeanDefinitionNames()));

        user = new User();
        user.setId((long) 1);
        user.setName("Test");
        user.setStudent_id("1");
        user.setEmail("test@test.com");
        user.setUsername("test");
        user.setPassword("test");
        user.setRoles("USER");
    }

    @Test
    public void whenRequestUrlToSignUpPageItWillReturnSignUpHTML() throws Exception {
        this.mockMvc.perform(get("/signup"))
                .andExpect(status().isOk())
                .andExpect(view().name("sign-up"));
    }

    @Test
    public void whenRequestUrlToLoginPageItWillReturnLoginHTML() throws Exception {
        this.mockMvc.perform(get("/login"))
                .andExpect(status().isOk())
                .andExpect(view().name("login"));
    }

    @Test
    public void whenRegisterUserItWillRedirectedToHomepage() throws Exception{
        this.mockMvc.perform(post("/register")
                    .flashAttr("user", user)
                    .flashAttr("model", model))
                    .andExpect(view().name("redirect:/"));
    }
}
