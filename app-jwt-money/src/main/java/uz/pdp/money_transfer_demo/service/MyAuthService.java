package uz.pdp.money_transfer_demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class MyAuthService implements UserDetailsService {

    @Autowired
    PasswordEncoder passwordEncoder;



    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<User> userList=new ArrayList<>(
                Arrays.asList(
                        new User("pdp", passwordEncoder.encode( "5547"),new ArrayList<>()),
                        new User("ecma", passwordEncoder.encode( "ecmauz"),new ArrayList<>()),
                        new User("aif", passwordEncoder.encode( "uzfia"),new ArrayList<>()),
                        new User("auf", passwordEncoder.encode( "fuazu"),new ArrayList<>())
                )
        );


        for (User user : userList) {
            if (user.getUsername().equals(username)){
                return user;
            }
        }
        throw new UsernameNotFoundException("User not found");
    }

}
