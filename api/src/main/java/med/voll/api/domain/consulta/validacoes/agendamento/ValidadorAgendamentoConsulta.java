package med.voll.api.domain.consulta.validacoes.agendamento;

import med.voll.api.domain.consulta.DadosAgendamentoConsulta;

public interface ValidadorAgendamentoConsulta {

    //padronizando para que todos os validadores implemente a interface
    void validar(DadosAgendamentoConsulta dados);
}
