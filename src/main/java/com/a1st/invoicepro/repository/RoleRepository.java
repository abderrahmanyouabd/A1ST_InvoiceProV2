package com.a1st.invoicepro.repository;

import com.a1st.invoicepro.domain.Role;

import java.util.Collection;

/**
 * @author: Abderrahman Youabd aka: A1ST
 * @version: 1.0
 */
public interface RoleRepository<T extends Role> {
    /* Basic CRUD Operations */
    T create(T data);
    Collection<T> list(int page, int pageSize);
    T get(Long id);
    T update(T data);
    Boolean delete(Long id);

    /* More Complex Operations */
    void addRoleToUser(Long userId, String roleName);
    Role getRoleByUserId(Long userId);
    Role getRoleByUserEmail(String email);
    void updateUserRole(Long userId, String roleName);
}
