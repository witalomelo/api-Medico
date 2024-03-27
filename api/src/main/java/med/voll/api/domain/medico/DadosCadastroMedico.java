package med.voll.api.domain.medico;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.domain.endereco.DadosEndereco;

public record DadosCadastroMedico(

        @NotBlank(message = "Nome é obrigatorio")
        String nome,
        @NotBlank(message = "Email é obrigatório")
        @Email(message = "Formato de email é inválido")
        String email,
        @NotBlank(message = "Telefone é obrigatorio")
        String telefone,
        @NotBlank(message = "CRM é obrigatorio")
        @Pattern(regexp = "\\d{4,6}", message = "Formato de CRM inválido")
        String crm,
        @NotNull(message = "Especialidade é obrigatorio")
        Especialidade especialidade,
        @NotNull(message = "Dados do endereço são obrigatorios")
        @Valid
        DadosEndereco endereco) {
}
