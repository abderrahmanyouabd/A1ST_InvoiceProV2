package com.a1st.invoicepro.service.implementation;

import com.a1st.invoicepro.domain.Role;
import com.a1st.invoicepro.domain.User;
import com.a1st.invoicepro.dtomapper.UserDTOMapper;
import com.a1st.invoicepro.repository.RoleRepository;
import com.a1st.invoicepro.repository.UserRepository;
import com.a1st.invoicepro.service.UserService;
import com.a1st.invoicepro.dto.UserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.a1st.invoicepro.dtomapper.UserDTOMapper.fromUser;

/**
 * @author: Abderrahman Youabd aka: A1ST
 * @version: 1.0
 */

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository<User> userRepository;
    private final RoleRepository<Role> roleRoleRepository;

    @Override
    public UserDTO createUser(User user) {
        return mapToUserDTO(userRepository.create(user));
    }

    @Override
    public UserDTO getUserByEmail(String email) {
        return mapToUserDTO(userRepository.getUserByEmail(email));
    }

    @Override
    public void sendVerificationCode(UserDTO user) {
        userRepository.sendVerificationCode(user);
    }

    @Override
    public UserDTO verifyCode(String email, String code) {
        return mapToUserDTO(userRepository.verifyCode(email, code));
    }

    private UserDTO mapToUserDTO(User user) {
        return UserDTOMapper.fromUser(user, roleRoleRepository.getRoleByUserId(user.getId()));
    }
}
















