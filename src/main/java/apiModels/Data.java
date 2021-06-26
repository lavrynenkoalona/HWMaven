package apiModels;

import java.util.Objects;

public class Data {
    private String name;
    private String salary;
    private String age;
    private Integer id;

    public Data() {
    }

    public Data(String name, String salary, String age) {
        this.name = name;
        this.salary = salary;
        this.age = age;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Data{" +
                "name='" + name + '\'' +
                ", salary='" + salary + '\'' +
                ", age='" + age + '\'' +
                ", id=" + id +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Data)) return false;
        Data data = (Data) o;
        return Objects.equals(name, data.name) && Objects.equals(salary, data.salary) && Objects.equals(age, data.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, salary, age);
    }
}
