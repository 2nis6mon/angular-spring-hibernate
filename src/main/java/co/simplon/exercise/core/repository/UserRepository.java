package co.simplon.exercise.core.repository;

import co.simplon.exercise.core.model.security.User;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.annotation.Resource;

@Resource
public interface UserRepository extends JpaRepository<User, String> {
}
