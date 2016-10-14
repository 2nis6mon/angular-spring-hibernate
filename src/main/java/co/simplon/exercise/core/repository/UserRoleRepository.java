package co.simplon.exercise.core.repository;

import co.simplon.exercise.core.model.security.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleRepository extends JpaRepository<UserRole, Integer> {
}
