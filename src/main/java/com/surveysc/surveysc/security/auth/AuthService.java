// package com.surveysc.surveysc.security.auth;

// import java.util.HashSet;
// import java.util.List;
// import java.util.Set;

// import org.springframework.security.authentication.AuthenticationManager;
// import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
// import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.stereotype.Service;

// import com.surveysc.surveysc.domain.entities.Rol;
// import com.surveysc.surveysc.domain.entities.User;
// import com.surveysc.surveysc.security.auth.user.RolRepository;
// import com.surveysc.surveysc.security.auth.user.UserRepository;

// import lombok.RequiredArgsConstructor;

// @Service
// @RequiredArgsConstructor
// public class AuthService {

//     private final UserRepository userRepository; 
//     private final JwtService jwtService;
//     private final PasswordEncoder passwordEncoder;
//     private final AuthenticationManager authenticationManager;
//     private final RolRepository rolRepository;

//     public AuthResponse login(LoginRequest request) {

//         String username = request.getUsername();
//         String password = request.getPassword();       
//         authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
//         User user = userRepository.findByUsername(username).orElseThrow(() -> new RuntimeException("User not found"));

//         String token = jwtService.getToken(user);

//         String role = user.getRoles().stream()
//                           .findFirst()
//                           .map(Rol::getName)
//                           .orElse("UNKNOW_ROLE");

//         System.out.println("Token generated for user " + username + " " + role);

//         return AuthResponse.builder()
//             .token(token)
//             .role(role)
//             .build();
//     }

//     public AuthResponse register(LoginRequest request) {

//         System.out.println("Received registration request: " + request);

//         if (request.getPassword() == null || request.getPassword().isEmpty()){
//             throw new IllegalArgumentException("Password cannot be null or empty");
//         }

//         String encodePassword = passwordEncoder.encode(request.getPassword());

//         Set<Rol> userRols = new HashSet<>();
//         for (String rolname : request.getRoles()){
//             Rol role = rolRepository.findByName(rolname)
//                 .orElseThrow(() -> new RuntimeException("ROl Not Found: " + rolname));
//             userRols.add(role);
//         }

//         List<Rol> rolesList = List.copyOf(userRols);

//         User user = User.builder()
//             .username(request.getUsername())
//             .password(encodePassword)
//             .roles(rolesList)
//             .enabled(true)
//             .build();

//             userRepository.save(user);

//             return AuthResponse.builder()
//                 .token(jwtService.getToken(user))
//                 .build();
//     }

// }
