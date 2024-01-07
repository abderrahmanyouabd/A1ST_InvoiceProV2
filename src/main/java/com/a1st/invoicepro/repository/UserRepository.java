package com.a1st.invoicepro.repository;

import com.a1st.invoicepro.domain.User;
import com.a1st.invoicepro.dto.UserDTO;

import java.util.Collection;

/**
 * @author: Abderrahman Youabd aka: A1ST
 * @version: 1.0
 */
public interface UserRepository<T extends User> {
    /* Basic CRUD Operations */
    T create(T data);
    Collection<T> list(int page, int pageSize);
    T get(Long id);
    T update(T data);
    Boolean delete(Long id);

    /* More Complex Operations */
    User getUserByEmail(String email);
    void sendVerificationCode(UserDTO user);
    User verifyCode(String email, String code);
}