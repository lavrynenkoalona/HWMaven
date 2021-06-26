package apiModels;

import java.util.Objects;

public class PostRequestModel {
    private String name;
    private String salary;
    private String age;

    public PostRequestModel(String name, String salary, String age) {
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

    @Override
    public String toString() {
        return "{\"name\":\"" + name + "\",\"salary\":\"" + salary + "\",\"age\":\""+ age +"\"}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PostRequestModel)) return false;
        PostRequestModel that = (PostRequestModel) o;
        return Objects.equals(name, that.name) && Objects.equals(salary, that.salary) && Objects.equals(age, that.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, salary, age);
    }
}
