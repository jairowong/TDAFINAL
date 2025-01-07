package GestionPago.MSPago.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class UtilsProperties {

    @Value("${prop.MS_MNT_GUARDAR}")
    public String MS_EXITO_GUARDAR;

    @Value("${prop.MS_MNT_PROCESO}")
    public String MS_EROR_PROCESAR;

    @Value("${prop.MS_NO_ENCONTRO}")
    public String MS_NO_ENCONTRO;

    @Value("${prop.MS_ERROR_REGISTRO}") 
    public String MS_ERROR_RECUPERAR;
    
}
