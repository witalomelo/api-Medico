package med.voll.api.domain.consulta.validacoes.agendamento;

import med.voll.api.domain.ValidacaoException;
import med.voll.api.domain.consulta.DadosAgendamentoConsulta;
import med.voll.api.domain.consulta.validacoes.agendamento.ValidadorAgendamentoConsulta;
import med.voll.api.domain.medico.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//medico deve estar ativo no sistema
@Component
public class ValidadorMedicoAtivo implements ValidadorAgendamentoConsulta {
    @Autowired
    private MedicoRepository repository;

    public void validar (DadosAgendamentoConsulta dados) {
        //escolha do medico é opcional
        if (dados.idMedico() == null) {
            return;
        }

        var medicoEstaAtivo = repository.findAtivoById(dados.idMedico());

        if(!medicoEstaAtivo) {
            throw new ValidacaoException("Consulta não pode ser agendada com medico inativo!");
        }
    }
}
