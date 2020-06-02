package group2.TASC;

import static org.assertj.core.api.Assertions.*;

import group2.TASC.controller.MainController;
import group2.TASC.security.UserDetailsImpl;
import group2.TASC.security.UserDetailsServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest
@ContextConfiguration(classes = {MainController.class, TascApplication.class})
class TascApplicationTests {

    @Autowired
    MainController mainController;

    @MockBean
    private UserDetailsImpl userDetails;

    @MockBean
    private UserDetailsServiceImpl userDetailsService;

//    @Test
//    void contextLoads() {
//
//    }
//
    @Test
    void testTASCApplication() {
//        TascApplication.main(new String[]{});
        assertThat(mainController).isNotNull();
    }

}
