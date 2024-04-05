package med.voll.api.domain.consulta;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

//dto dos campos que chegam na API
public record DadosAgendamentoConsulta(

        Long idMedico,
        @NotNull
        Long idPaciente,
        @NotNull @Future
        LocalDateTime data
) {
}
