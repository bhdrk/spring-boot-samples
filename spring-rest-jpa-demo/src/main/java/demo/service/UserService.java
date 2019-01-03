package demo.service;

import demo.dto.UserDto;
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

    public UserDto findUserById(Long id) {
        return repository.findById(id)
                .map(userEntity -> {
                    UserDto dto = new UserDto();
                    dto.setEmail(userEntity.getEmail());
                    dto.setName(userEntity.getName());
                    return dto;
                })
                .orElse(null);
    }
}
