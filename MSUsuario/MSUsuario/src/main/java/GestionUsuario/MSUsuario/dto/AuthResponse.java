package GestionUsuario.MSUsuario.dto;

import java.io.Serializable;

public class AuthResponse implements Serializable {
    private static final long serialVersionUID = 1L;

    private String message;
    private String token;

    public AuthResponse() {}

    public AuthResponse(String message, String token) {
        this.message = message;
        this.token = token;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
