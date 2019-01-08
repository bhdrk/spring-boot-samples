package demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Component
public class MyUserDetailService implements UserDetailsService {

    private Map<String, UserDetails> users;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostConstruct
    public void init() {
        String password = passwordEncoder.encode("1234");

        User user1 = new User("user1", password, Arrays.asList(new SimpleGrantedAuthority("USER"), new SimpleGrantedAuthority("CBS")));
        User user2 = new User("user2", password, Arrays.asList(new SimpleGrantedAuthority("USER"), new SimpleGrantedAuthority("BILGI_ISLEM")));
        User manager1 = new User("manager1", password, Arrays.asList(new SimpleGrantedAuthority("MANAGER")));

        users = new HashMap<>();
        users.put(user1.getUsername(), user1);
        users.put(user2.getUsername(), user2);
        users.put(manager1.getUsername(), manager1);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetails user = users.get(username);

        if (user == null) {
            throw new UsernameNotFoundException(username + " not found!");
        }

        return user;
    }
}