package my.ohrem.security;

import my.ohrem.model.UserEntity;
import my.ohrem.repository.UserEntityDaoImpl;
import my.ohrem.service.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("authService")
public class AuthenticationService implements UserDetailsService {

    @Autowired
    private AppUserService appUserService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        System.out.println("Call: loadUserByUsername");
        try {
            List<UserEntity> appUsers = appUserService.findUserByEmail(email);
            System.out.println("Found user: " + appUsers.size());
            if (appUsers.size() != 1) {
                throw new UsernameNotFoundException("User not found: " + email);
            }
            UserEntity appUser = appUsers.get(0);
            return new User(
                    appUser.getEmail(),
                    appUser.getPassword(),
                    true, true, true, true,
                    List.of(new SimpleGrantedAuthority("ROLE_" + appUser.getRole().name()))
            );

        } catch (Exception e) {
            e.printStackTrace();
            throw new UsernameNotFoundException("User not found: " + email, e);
        }
    }
}
