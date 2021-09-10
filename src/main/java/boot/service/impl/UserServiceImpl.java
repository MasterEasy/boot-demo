package boot.service.impl;

import boot.service.User;
import boot.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public List<User> getUserInfo() {
        return User.getUserInfo();
    }
}
