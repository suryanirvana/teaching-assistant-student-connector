package group2.TASC;

import static org.assertj.core.api.Assertions.*;

import group2.TASC.controller.MainController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TascApplicationTests {

    @Autowired
    MainController mainController;

    @Test
    void contextLoads() {
//        TascApplication.main(new String[]{});
//        assertThat(mainController).isNotNull();
    }

}
