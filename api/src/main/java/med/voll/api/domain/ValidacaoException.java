package med.voll.api.domain;

public class ValidacaoException extends RuntimeException {

    public ValidacaoException(String mensagem){
        super(mensagem); //chamndo a classe mae e passando mensagem como parametro
    }
}
