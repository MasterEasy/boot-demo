package boot.test;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

public class Test1 {

    public static void main(String[] args) {

        List<User> list = User.getUserInfo();

        List<User> userList = new ArrayList<>();
        list.forEach(user -> {
            user.setName(User.getName(user.getName()));
            userList.add(user);
        });
        System.out.println(userList);
    }




}

@Data
@NoArgsConstructor
@AllArgsConstructor
class User{
    private String name;
    private String age;

    public static List<User> getUserInfo(){
        List<User> list = new ArrayList<>();
        list.add(new User("张三","18"));
        list.add(new User("李四丫丫","18"));
        list.add(new User("呼和浩特--灿烂","18"));
        return list;
    }

    public static String getName(String name){

        if(name.isEmpty()){
            return null;
        }
        StringBuilder stringBuilder =new StringBuilder();
        for (int i = 0; i < name.length() - 1; i++) {
            stringBuilder.append("*");
        }
        return name.replace(name.substring(1),stringBuilder.toString());
    }
}