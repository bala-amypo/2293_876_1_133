// package com.example.demo.security;

// import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.security.core.userdetails.UserDetailsService;
// import org.springframework.security.core.userdetails.UsernameNotFoundException;
// import org.springframework.security.core.authority.SimpleGrantedAuthority;
// import org.springframework.stereotype.Service;

// import java.util.Collections;

// import com.example.demo.entity.UserAccount;
// import com.example.demo.repository.UserAccountRepository;

// @Service
// public class CustomUserDetailsService implements UserDetailsService {

//     private final UserAccountRepository repository;

//     public CustomUserDetailsService(UserAccountRepository repository) {
//         this.repository = repository;
//     }

//     @Override
//     public UserDetails loadUserByUsername(String username)
//             throws UsernameNotFoundException {

//         UserAccount user = repository.findByEmail(username)
//                 .orElseThrow(() ->
//                         new UsernameNotFoundException("User not found"));

//         return new org.springframework.security.core.userdetails.User(
//                 user.getEmail(),
//                 user.getPassword(),
//                 Collections.singleton(
//                         new SimpleGrantedAuthority(user.getRole()))
//         );
//     }
// }
