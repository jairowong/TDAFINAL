package GestionEstudiantes.MSEstudiantes.service;

import java.util.List;
import GestionEstudiantes.MSEstudiantes.model.EstudianteModel;

public interface IEstudianteService {

    /**
     * Recupera todos los estudiantes.
     *
     * @return una lista de EstudianteModel
     */
    List<EstudianteModel> findAll();

    /**
     * Encuentra un estudiante por su ID.
     *
     * @param id el ID del estudiante
     * @return el EstudianteModel correspondiente o null si no se encuentra
     */
    EstudianteModel findById(Long id);

    /**
     * Agrega un nuevo estudiante.
     *
     * @param model el modelo del estudiante a agregar
     * @return el EstudianteModel agregado
     */
    EstudianteModel add(EstudianteModel model);

    /**
     * Actualiza un estudiante existente.
     *
     * @param id el ID del estudiante a actualizar
     * @param model el modelo con los datos actualizados
     * @return el EstudianteModel actualizado o null si no se encuentra
     */
    EstudianteModel update(Long id, EstudianteModel model);

    /**
     * Elimina un estudiante por su ID.
     *
     * @param id el ID del estudiante a eliminar
     * @return true si se eliminó exitosamente, false si no se encontró
     */
    Boolean delete(Long id);
}
