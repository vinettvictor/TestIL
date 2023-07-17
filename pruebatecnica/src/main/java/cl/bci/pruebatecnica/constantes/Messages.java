package cl.bci.pruebatecnica.constantes;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
public class Messages {

    public Messages() {}

    public  String ERROR_PARAMETRO_ENTRADA = "Error en parametros de entrada";
    public  String ERROR_CORREO_EXISTE = "El correo ya está registrado";
    public  String ERROR_CORREO_INVALIDO = "El correo ingresado no es válido";
    public  String ERROR_PASSWORD = "La contraseña ingresada no cumple las caracteristicas";

}
