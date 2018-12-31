package demo.repository;

import demo.entity.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {

    UserEntity findByEmail(String email);

    UserEntity findByNameAndTckn(String name, String tckn);

    Page<UserEntity> findAllByNameStartsWith(String name, Pageable pageable);
}
