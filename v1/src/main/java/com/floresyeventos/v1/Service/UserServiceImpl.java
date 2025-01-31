// package com.floristeria.v1.Service;


// import com.floristeria.v1.model.User;
// import com.floristeria.v1.Repository.UserRepository;
// import org.springframework.beans.factory.annotation.Autowired;
// // import org.springframework.security.core.userdetails.UserDetails;
// // import org.springframework.security.core.userdetails.UserDetailsService;
// // import org.springframework.security.core.userdetails.UsernameNotFoundException;
// // import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// import org.springframework.stereotype.Service;
// import org.springframework.transaction.annotation.Transactional;

// import java.util.List;
// import java.util.Optional;
// import java.util.stream.Collectors;

// /**
//  * Implementación de la lógica de negocio para usuarios.
//  */
// @Service
// @Transactional
// public class UserServiceImpl implements UserService { 
// // UserDetailsService{

//     private final UserRepository userRepository;

//     /**
//      * Constructor para inyectar el repositorio de usuarios.
//      * @param userRepository Repositorio de usuarios.
//      */
//     @Autowired
//     public UserServiceImpl(UserRepository userRepository) {
//         this.userRepository = userRepository;
//     }

//     @Override
//     public User saveUser(User user) {
//      if (usernameExists(user.getUsername())) {
//         throw new IllegalArgumentException("El nombre de usuario ya está en uso.");
//     }
//     // Encripta la contraseña antes de guardar.
//     // user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
//     return userRepository.save(user);
//     }

//     @Override
//     public Optional<User> findUserById(Long id) {
//         return userRepository.findById(id);
//     }

//     @Override
//     public List<User> findAllUsers() {
//         return userRepository.findAll();
//     }

//     @Override
//     public Optional<User> findUserByUsername(String username) {
//         return userRepository.findByUsername(username);
//     }

//     @Override
//     public boolean usernameExists(String username) {
//         return userRepository.existsByUsername(username);
//     }

//     @Override
//     public void deleteUserById(Long id) {
//         if (!userRepository.existsById(id)) {
//             throw new IllegalArgumentException("El usuario con ID " + id + " no existe.");
//         }
//         userRepository.deleteById(id);
//     }

//     @Override
//     public long countUsers() {
//         return userRepository.count();
//     }

//     @Override
// public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//     User user = userRepository.findByUsername(username)
//         .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado: " + username));

//     return new org.springframework.security.core.userdetails.User(
//         user.getUsername(),
//         user.getPassword(),
//         user.getRoles().stream()
//             .map(role -> new org.springframework.security.core.authority.SimpleGrantedAuthority(role.getName()))
//             .collect(Collectors.toList())
//     );
// }

// }
