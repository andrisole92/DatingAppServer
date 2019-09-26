package com.dating.server.Authentication;

import com.dating.server.Xmpp.DataJpa.XmppUser;
import com.dating.server.Xmpp.DataJpa.XmppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private XmppUserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {
        XmppUser user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        return new MyUserPrincipal(user);
    }
}
