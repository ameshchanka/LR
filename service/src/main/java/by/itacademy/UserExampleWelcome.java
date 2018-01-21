package by.itacademy;

/**
 * Created by User on 21.01.2018.
 */
public class UserExampleWelcome {

    private UserExample userExample = new UserExample("Aleh", "Meshchanka");

    public String say() {
        return userExample.getName()
                + " " + userExample.getLastName()
                + " sayed: - Hello world!";
    }
}
