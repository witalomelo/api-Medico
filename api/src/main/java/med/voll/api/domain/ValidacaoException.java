package med.voll.api.domain;

public class ValidacaoException extends RuntimeException {

    public ValidacaoException(String mensagem){
        super(mensagem); //chamando o construtor da classe mãe usando a palavra super e passando o parâmetro mensage
    }
}
