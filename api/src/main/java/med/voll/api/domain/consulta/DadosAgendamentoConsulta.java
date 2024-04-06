package med.voll.api.domain.consulta;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import med.voll.api.domain.medico.Especialidade;

import java.time.LocalDateTime;

//dto dos campos que chegam na API
public record DadosAgendamentoConsulta(

        Long idMedico,
        @NotNull
        Long idPaciente,
        @NotNull @Future
        LocalDateTime data,

        Especialidade especialidade //campo opcional só necessária quando não informar o id do medico
) {
}
