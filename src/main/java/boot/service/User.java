package boot.service;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class User {
    private String name;
    private String age;

    public static List<User> getUserInfo(){
        List<User> userList = new ArrayList<>();
        userList.add(new User("aa","18"));
        userList.add(new User("bb","18"));
        userList.add(new User("cc","18"));
        return userList;
    }
}
