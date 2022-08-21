package com.microservice.jwt.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtInMemoryUserDetailsService implements UserDetailsService {

  static List<JwtUserDetails> inMemoryUserList = new ArrayList<>();

  static {
    inMemoryUserList.add(new JwtUserDetails(3L, "Rose",
        "$2a$10$ipC7vwGx3XUgC.YbQsTFf.9GIe3cS0Iw2G.huBcxrkxcF1csv8ssS", "ROLE_USER_2"));
    inMemoryUserList.add(new JwtUserDetails(1L, "Arul",
         "$2a$10$7G4Mn1/waW3YbctdI5b5gu4jfHFgrz6y2Wbeo3r8XpKcIptpctfuu", "ROLE_USER_2"));
    inMemoryUserList.add(new JwtUserDetails(2L, "Lourdus",
         "$2a$10$7G9JUbiK/Os1ocuBqK/9qOlmSSHhrT7XAXnfAyHze7gnj.A.tzcAS", "ROLE_USER_2"));
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    Optional<JwtUserDetails> findFirst = inMemoryUserList.stream()
        .filter(user -> user.getUsername().equals(username)).findFirst();

    if (!findFirst.isPresent()) {
      throw new UsernameNotFoundException(String.format("USER_NOT_FOUND '%s'.", username));
    }

    return findFirst.get();
  }

}


