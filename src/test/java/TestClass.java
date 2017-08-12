import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by Martina on 29/07/2017.
 */

    @RunWith(SpringRunner.class)
    @SpringBootTest({"myCustomArgs.customArg1=testValue"})
    public class TestClass {

        @Test
        public void contextLoads() {
        }
    }

