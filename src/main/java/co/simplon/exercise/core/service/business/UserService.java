package co.simplon.exercise.core.service.business;

import co.simplon.exercise.core.model.User;
import co.simplon.exercise.core.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    @Qualifier("passwordEncoder")
    private PasswordEncoder passwordEncoder;

    @Transactional
    public void addOrUpdateUserAndRoles(String username, String password, boolean enabled, User.Role role) {
        userRepository.save(new User(username, passwordEncoder.encode(password), role, enabled));
    }

    @Transactional(readOnly = true)
    public List<User> getAll() {
        return userRepository.findAll();
    }

    public void deleteUser(String username) {
        userRepository.delete(username);
    }
}
