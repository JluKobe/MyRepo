package spring;

import static org.junit.Assert.assertTrue;

import com.spring.main.Person;
import org.junit.Test;

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

    public static void main(String[] args) {
        Person person = new Person("zz", 20);

        Person p = person;
        System.out.println(person);
        System.out.println(p);

        System.out.println();

        System.out.println(person.hashCode());
        System.out.println(p.hashCode());
    }
}
