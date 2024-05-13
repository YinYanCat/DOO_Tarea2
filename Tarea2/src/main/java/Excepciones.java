class AsistenteNoEnListaException extends Exception{
    public AsistenteNoEnListaException(String errorMessage){
        super(errorMessage);
    }
}
class AsistenciaDespuesDeFinalizarException extends Exception{
    public AsistenciaDespuesDeFinalizarException(String errorMessage){
        super(errorMessage);
    }
}
class EmpleadoYaInvitadoException extends Exception{
    public EmpleadoYaInvitadoException(String errorMessage){
        super(errorMessage);
    }
}
class HoraYaEstablecidaException extends Exception{
    public HoraYaEstablecidaException(String errorMessage){
        super(errorMessage);
    }
}