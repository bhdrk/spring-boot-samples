package demo.repository;

import demo.entity.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    // select * from User Where name LIKE('%')
    UserEntity findByEmail(String email);

    List<UserEntity> findAllByNameStartingWithAndEmailStartingWith
            (String nameSearchText, String emailSearchText);

    default List<UserEntity> findByText(String searchText) {
        return findAllByNameStartingWithAndEmailStartingWith(searchText, searchText);
    }

    UserEntity findByNameAndIdentityNumber(String name, String idn);

    Page<UserEntity> findAllByNameStartsWith(String name, Pageable pageable);
}
