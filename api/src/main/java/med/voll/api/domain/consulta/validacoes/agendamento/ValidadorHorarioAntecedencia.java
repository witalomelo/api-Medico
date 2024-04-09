package med.voll.api.domain.consulta.validacoes.agendamento;

import med.voll.api.domain.ValidacaoException;
import med.voll.api.domain.consulta.DadosAgendamentoConsulta;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

@Component("ValidadorHorarioAntecedenciaAgendamento")
public class ValidadorHorarioAntecedencia implements ValidadorAgendamentoConsulta {

    public void validar(DadosAgendamentoConsulta dados) {
        var dataConsulta = dados.data();
        var agora = LocalDateTime.now();
        //diferenca em horas entre data da consulta e agora
        var diferencaEmMinutos = Duration.between(agora, dataConsulta).toMinutes();


        if (diferencaEmMinutos < 30) {
            throw new ValidacaoException("consulta dever ser agendada com antecedência minima de 30 minutos");
        }

    }
}
