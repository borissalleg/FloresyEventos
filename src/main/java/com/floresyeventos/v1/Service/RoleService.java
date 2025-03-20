package com.floresyeventos.v1.Service;



import com.floresyeventos.v1.model.Role;

import java.util.List;
import java.util.Optional;

/**
 * Interfaz que define los métodos del servicio para roles.
 */
public interface RoleService {

    /**
     * Guarda un nuevo rol o actualiza uno existente.
     * @param role El objeto Role a guardar.
     * @return El rol guardado.
     */
    Role saveRole(Role role);

    /**
     * Busca un rol por su identificador.
     * @param id El identificador del rol.
     * @return Un Optional que contiene el rol si se encuentra.
     */
    Optional<Role> findRoleById(Long id);

    /**
     * Encuentra un rol por su nombre.
     * @param name El nombre del rol.
     * @return Un Optional que contiene el rol si se encuentra.
     */
    Optional<Role> findRoleByName(String name);

    /**
     * Devuelve todos los roles registrados.
     * @return Una lista con todos los roles.
     */
    List<Role> findAllRoles();

    /**
     * Verifica si un rol ya está registrado por su nombre.
     * @param name El nombre del rol.
     * @return True si el rol existe, False en caso contrario.
     */
    boolean roleExists(String name);

    /**
     * Elimina un rol por su identificador.
     * @param id El identificador del rol.
     */
    void deleteRoleById(Long id);

    /**
     * Cuenta el número total de roles registrados.
     * @return El número total de roles.
     */
    long countRoles();
}
