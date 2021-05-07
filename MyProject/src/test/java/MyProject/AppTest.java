package MyProject;

import static org.junit.Assert.assertTrue;

import com.myproject.jpa.bean.Player;
import org.apache.tomcat.jni.Local;
import org.junit.Test;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

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

    @Test
    public void test() {
        LocalDate date = LocalDate.now();
        System.out.println(date);

        Student s1 = new Student(123, "zhengzhao");
        Student s2 = new Student(123, "zhengzhao");
        System.out.println(s1.equals(s2));
        System.out.println(s1 == s2);

        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());

        String s = null;
    }

    @Test
    public void test1() {
        A a = new A("m");
        A b = new A("m");
        System.out.println(a.equals(b));

        Map<A, String> map = new HashMap<>();
        map.put(a, "abc");
        map.put(b, "abc");

        for(Map.Entry<A, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + "   " + entry.getValue());
        }
    }
}

class Student {
    int age;
    String name;
    Student(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Student) {
            Student s = (Student) obj;
            if(this.age == s.age && this.name.equals(s.name)) {
                return true;
            }

            else{
               return false;
            }
        }

        else {
            return false;
        }
    }
}

class A {
    public String bName;

    public A(String bName) {
        this.bName = bName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        A a = (A) o;
        return bName.equals(a.bName);
    }

    @Override
    public int hashCode() {
        return bName.hashCode();
    }
}