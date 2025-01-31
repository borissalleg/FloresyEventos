// package com.floristeria.v1.Repository;


// import com.floristeria.v1.model.Role;
// import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.stereotype.Repository;

// import java.util.Optional;

// /**
//  * Repositorio para gestionar las operaciones CRUD y consultas personalizadas para la entidad Role.
//  */
// @Repository
// public interface RoleRepository extends JpaRepository<Role, Long> {

//     /**
//      * Encuentra un rol por su nombre.
//      * @param name El nombre del rol.
//      * @return Un Optional que contiene el rol si se encuentra.
//      */
//     Optional<Role> findByName(String name);

//     /**
//      * Verifica si un rol existe por su nombre.
//      * @param name El nombre del rol.
//      * @return True si existe, False en caso contrario.
//      */
//     boolean existsByName(String name);
// }
