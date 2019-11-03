//package com.dating.server.security;
//
//import com.dating.server.Xmpp.DataJpa.XmppUser;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import java.util.Collection;
//
//public class UserPrincipal_v2 implements UserDetails {
//    private XmppUser user;
//
//    UserPrincipal_v2(XmppUser user) {
//        this.user = user;
//    }
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return null;
//    }
//
//    @Override
//    public String getPassword() {
//        return user.getPassword();
//    }
//
//    @Override
//    public String getUsername() {
//        return user.getUsername();
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return false;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return false;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return true;
//    }
//
//    public XmppUser getUser() {
//        return user;
//    }
//
//    public void setUser(XmppUser user) {
//        this.user = user;
//    }
//}
