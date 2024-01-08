package com.a1st.invoicepro.service;

import com.a1st.invoicepro.domain.User;
import com.a1st.invoicepro.dto.UserDTO;

/**
 * @author: Abderrahman Youabd aka: A1ST
 * @version: 1.0
 */
public interface UserService {
    UserDTO createUser(User user);
    UserDTO getUserByEmail(String email);
    void sendVerificationCode(UserDTO user);
    UserDTO verifyCode(String email, String code);

    void resetPassword(String email);

    UserDTO verifyPasswordKey(String key);

    void renewPassword(String key, String newPassword, String confirmPassword);

    UserDTO verifyAccountKey(String key);
}
