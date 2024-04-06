package med.voll.api.domain.consulta.validacoes;

import med.voll.api.domain.ValidacaoException;
import med.voll.api.domain.consulta.ConsultaRepository;
import med.voll.api.domain.consulta.DadosAgendamentoConsulta;
import org.springframework.beans.factory.annotation.Autowired;

public class ValidadorMedicoComOutraConsultaNoMesmoHorario implements ValidadorAgendamentoConsulta{

    @Autowired
    private ConsultaRepository repository;

    //existsByMedicoIdAndData padrao spring
    public void validar(DadosAgendamentoConsulta dados) {
        var medicoPossuiOutroConsultaNoMesmoHorairo = repository.existsByMedicoIdAndData(dados.idMedico(), dados.data());
        if(medicoPossuiOutroConsultaNoMesmoHorairo) {
            throw new ValidacaoException("Medico ja possui outra consulta agendada nesse mesmo horário");
        }
    }
}
