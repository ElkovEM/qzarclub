package ru.course.qzar;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.course.qzar.Controllers.AdminController;
import ru.course.qzar.Controllers.RentalController;
import ru.course.qzar.Controllers.QZarController;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class SmokeTest {
    @Autowired
    QZarController QZarController;
    @Autowired
    RentalController rentalController;
    @Autowired
    AdminController adminController;

    @Test
    void contextLoads() {
        assertThat(QZarController).isNotNull();
        assertThat(rentalController).isNotNull();
        assertThat(adminController).isNotNull();
    }
}
