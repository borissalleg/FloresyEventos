// package com.floristeria.v1.Repository;


// import com.floristeria.v1.model.User;
// import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.stereotype.Repository;

// import java.util.List;
// import java.util.Optional;

// /**
//  * Repositorio para gestionar las operaciones CRUD y consultas personalizadas para la entidad Usuario.
//  */
// @Repository
// public interface UserRepository extends JpaRepository<User, Long> {

//     Optional<User> findByUsername(String username);

//     boolean existsByUsername(String username);

// }
