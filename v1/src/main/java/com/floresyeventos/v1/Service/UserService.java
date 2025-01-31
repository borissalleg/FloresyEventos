// package com.floresyeventos.v1.Service;

// import com.floresyeventos.v1.model.User;


// import java.util.List;
// import java.util.Optional;


// /**
//  * Servicio que contiene la lógica de negocio para usuarios.
//  */

// public interface UserService {

    

//  /**
//      * Guarda un nuevo usuario o actualiza uno existente.
//      * @param user El objeto User a guardar.
//      * @return El usuario guardado.
//      */
//     User saveUser(User user);

//     /**
//      * Encuentra un usuario por su identificador.
//      * @param id El identificador del usuario.
//      * @return Un Optional que contiene el usuario si se encuentra.
//      */
//     Optional<User> findUserById(Long id);

//     /**
//      * Encuentra todos los usuarios registrados.
//      * @return Una lista con todos los usuarios.
//      */
//     List<User> findAllUsers();

//     /**
//      * Encuentra un usuario por su nombre de usuario.
//      * @param username El nombre del usuario.
//      * @return Un Optional que contiene el usuario si se encuentra.
//      */
//     Optional<User> findUserByUsername(String username);

//     /**
//      * Verifica si existe un usuario con un nombre de usuario dado.
//      * @param username El nombre de usuario.
//      * @return True si existe, False en caso contrario.
//      */
//     boolean usernameExists(String username);

//     /**
//      * Elimina un usuario por su identificador.
//      * @param id El identificador del usuario.
//      */
//     void deleteUserById(Long id);

//     /**
//      * Cuenta el número total de usuarios registrados.
//      * @return El número total de usuarios.
//      */
//     long countUsers();
// }