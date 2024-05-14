
/** Esta excepción es resultante de la inexistencia del empleado en la lista de invitación */
class AsistenteNoEnListaException extends Exception {
    public AsistenteNoEnListaException(String errorMessage){
        super(errorMessage);
    }
}

/** Esta excepción es resultante de la llegada de un empelado a una reunión luego de su finalización */
class AsistenciaDespuesDeFinalizarException extends Exception {
    public AsistenciaDespuesDeFinalizarException(String errorMessage){
        super(errorMessage);
    }
}

/** Esta excepción es resultante de invitar un empleado a una reunión en la que ya se encuentra invitado */
class EmpleadoYaInvitadoException extends Exception {
    public EmpleadoYaInvitadoException(String errorMessage){
        super(errorMessage);
    }
}

/** Esta excepción es resultante de establecer una hora de inicio o finalización luego de ya ser establecida */
class HoraYaEstablecidaException extends Exception {
    public HoraYaEstablecidaException(String errorMessage){
        super(errorMessage);
    }
}