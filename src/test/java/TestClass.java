import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author  mGabellini
 */

    @RunWith(SpringRunner.class)
    @SpringBootTest({"myCustomArgs.customArg1=testValue"})
    public class TestClass {

        @Test
        public void contextLoads() {
        }
    }