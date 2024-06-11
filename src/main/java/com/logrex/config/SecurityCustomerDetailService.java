package com.logrex.config;

import com.logrex.entity.Customer;
import com.logrex.helper.AppConstants;
import com.logrex.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SecurityCustomerDetailService implements UserDetailsService {

    @Autowired
    CustomerRepository customerRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("This is user name"+username);
   List<Customer> customer = customerRepository.findByEmail(username);
       String userName=null ,password=null;
       userName=customer.get(0).getEmail();
       password=customer.get(0).getPassword();
       List<GrantedAuthority> authorities=new ArrayList<GrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority(AppConstants.ROLE_CUSTOMER));
        return new User( userName,password,authorities);
    }
}
