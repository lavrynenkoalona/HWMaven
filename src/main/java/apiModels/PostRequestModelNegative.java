package apiModels;

import java.util.Objects;

public class PostRequestModelNegative {
    private String name;
    private String salary;


    public PostRequestModelNegative(String name, String salary) {
        this.name = name;
        this.salary = salary;

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


    @Override
    public String toString() {
        return "{\"name\":\"" + name + "\",\"salary\":\"" + salary + "\",\"age\":\""+ "\"}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PostRequestModelNegative)) return false;
        PostRequestModelNegative that = (PostRequestModelNegative) o;
        return Objects.equals(name, that.name) && Objects.equals(salary, that.salary);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, salary);
    }
}
