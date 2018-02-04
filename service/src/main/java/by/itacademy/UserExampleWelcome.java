package by.itacademy;

import by.itacademy.entity.User;

/**
 * Created by User on 21.01.2018.
 */
public class UserExampleWelcome {

    public String say() {
        User userExample = new UserExample().getFirstUser();

        return userExample.getName() + (userExample) + " sayed: - Hello world!";
    }
}
