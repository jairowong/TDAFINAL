package GestionEstudiantes.MSEstudiantes.exception;

/**
 * Excepción personalizada para manejar casos donde un recurso no es encontrado.
 */
public class ResourceNotFoundException extends RuntimeException {
    
    /**
     * Constructor que acepta un mensaje de error.
     * @param message Detalle del error.
     */
    public ResourceNotFoundException(String message) {
        super(message);
    }
    
    /**
     * Constructor que acepta un mensaje de error y una causa.
     * @param message Detalle del error.
     * @param cause Causa raíz del error.
     */
    public ResourceNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
