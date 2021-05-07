package ioc.bean.di.byname;

public class StudentByName2 {
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student name : " + name;
    }
}
