package co.simplon.exercise.core.service;

import java.util.ArrayList;
import java.util.List;

import co.simplon.exercise.core.model.security.User;
import co.simplon.exercise.core.model.security.UserRole;
import co.simplon.exercise.core.repository.UserRepository;
import co.simplon.exercise.core.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomUserDetailsService implements UserDetailsService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserRoleRepository userRoleRepository;

    @Transactional(readOnly=true)
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        User user = userRepository.findOne(username);
        System.out.println("User : "+user);
        if(user==null){
            System.out.println("User not found");
            throw new UsernameNotFoundException("Username not found");
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
                user.isEnabled(), true, true, true, getGrantedAuthorities(user));
    }


    private List<GrantedAuthority> getGrantedAuthorities(User user){
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

        List<UserRole> userRoles = userRoleRepository.findAll(Example.of(new UserRole(user, null)));

        for(UserRole userRole : userRoles){
            System.out.println("UserRole : "+ userRole);
            authorities.add(new SimpleGrantedAuthority(userRole.getRole()));
        }
        System.out.print("authorities :"+authorities);
        return authorities;
    }

    @Transactional
    public void addOrUpdateUserAndRoles(String username, String password, boolean enabled, String... roles) {
        User user = userRepository.save(new User(username, password, enabled));
        for (String role : roles) {
            userRoleRepository.save(new UserRole(user, role));
        }
    }

}