package GestionUsuario.MSUsuario.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import GestionUsuario.MSUsuario.dto.AuthRequest;
import GestionUsuario.MSUsuario.dto.AuthResponse;
import GestionUsuario.MSUsuario.model.AccessModel;
import GestionUsuario.MSUsuario.repository.AuthRepository;

@Service
public class AuthService {

    @Autowired
    private AuthRepository authRepository;

    public AuthResponse authenticate(AuthRequest authRequest) {
        AccessModel user = authRepository.findByUsername(authRequest.getUsername());

        if (user != null && user.getPassword().equals(authRequest.getPassword())) {
            String token = "mock-jwt-token"; // Cambia esto por tu implementación de JWT si la tienes
            return new AuthResponse("Login exitoso", token);
        } else {
            return new AuthResponse("Credenciales incorrectas", null);
        }
    }

    public AuthResponse register(AuthRequest authRequest) {
        if (authRepository.findByUsername(authRequest.getUsername()) != null) {
            return new AuthResponse("El nombre de usuario ya está en uso", null);
        }

        AccessModel newUser = new AccessModel();
        newUser.setUsername(authRequest.getUsername());
        newUser.setPassword(authRequest.getPassword());
        authRepository.save(newUser);

        return new AuthResponse("Usuario creado con éxito", null);
    }
}
