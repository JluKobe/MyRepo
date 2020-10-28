package MyProject;

import static org.junit.Assert.assertTrue;

import org.apache.tomcat.jni.Local;
import org.junit.Test;

import java.util.Locale;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void myTest1() {
        Locale local = "zh".equalsIgnoreCase("zh") ? Locale.CHINESE : Locale.ENGLISH;

        System.out.println(local);

        System.out.println(Locale.CHINESE);
        System.out.println(Locale.ENGLISH);
    }

    @Test
    public void myTest2() {
        System.out.println(Math.sqrt(0.6248589994068701));
    }
}
