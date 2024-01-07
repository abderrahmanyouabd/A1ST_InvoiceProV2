package com.a1st.invoicepro.dtomapper;

import com.a1st.invoicepro.domain.Role;
import com.a1st.invoicepro.domain.User;
import com.a1st.invoicepro.dto.UserDTO;
import org.springframework.beans.BeanUtils;

/**
 * @author: Abderrahman Youabd aka: A1ST
 * @version: 1.0
 */

public class UserDTOMapper {
    public static UserDTO fromUser(User user) {
        UserDTO userDTO = new UserDTO();
        BeanUtils.copyProperties(user, userDTO);
        return userDTO;
    }

    public static UserDTO fromUser(User user, Role role) {
        UserDTO userDTO = new UserDTO();
        BeanUtils.copyProperties(user, userDTO);
        userDTO.setRoleName(role.getName());
        userDTO.setPermissions(role.getPermission());
        return userDTO;
    }

    public static User toUser(UserDTO userDTO) {
        User user = new User();
        BeanUtils.copyProperties(userDTO, user);
        return user;
    }
}

















