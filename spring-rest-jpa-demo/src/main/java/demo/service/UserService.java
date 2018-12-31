package demo.service;

import demo.entity.UserEntity;
import demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserService {

    @Autowired
    UserRepository repository;

    public void saveUser(UserEntity userEntity) {
        repository.save(userEntity);
    }
}
