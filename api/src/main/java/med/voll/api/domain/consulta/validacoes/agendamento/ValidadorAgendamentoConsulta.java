package med.voll.api.domain.consulta.validacoes.agendamento;

import med.voll.api.domain.consulta.DadosAgendamentoConsulta;

public interface ValidadorAgendamentoConsulta {

    //padronizando para que todos os validadores implemente a interface para ganhar polimorfismo
    void validar(DadosAgendamentoConsulta dados);
}
