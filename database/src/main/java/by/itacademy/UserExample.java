package by.itacademy;

/**
 * Created by a.meshchenko on 21.01.2018.
 */
public class UserExample {

    private String name;
    private String lastName;

    public UserExample() {}

    public UserExample(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "UserExample{"
                + "name='" + name + '\''
                + ", lastName='" + lastName + '\''
                + '}';
    }
}
