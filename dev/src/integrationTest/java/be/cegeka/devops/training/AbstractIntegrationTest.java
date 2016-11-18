package be.cegeka.devops.training;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@ContextConfiguration(classes = {IntegrationTestConfiguration.class, DevopsTrainingApplication.class})
public abstract class AbstractIntegrationTest {
}
