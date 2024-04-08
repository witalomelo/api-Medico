package med.voll.api.domain.consulta;


import med.voll.api.domain.consulta.validacoes.ValidadorAgendamentoConsulta;
import med.voll.api.domain.medico.Medico;
import med.voll.api.domain.medico.MedicoRepository;
import med.voll.api.domain.paciente.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import med.voll.api.domain.ValidacaoException;

import java.util.List;

@Service
public class AgendaDeConsultas {

    @Autowired
    private ConsultaRepository consultaRepository;
    @Autowired
    private MedicoRepository medicoRepository;
    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private List<ValidadorAgendamentoConsulta> validadores; //injeção de validadores utilizando o list


    public DadosDetalhamentoConsulta agendar(DadosAgendamentoConsulta dados) {

        //verificando se o id paciente é diferente de nulo
        if (!pacienteRepository.existsById(dados.idPaciente())) {
            throw new ValidacaoException("Id do paciente informado não existe!");
        }

        //devido as regras de negocio a escolha do medico é opcional e caso ocorra o medico escolhido é aleatório
        if (dados.idMedico() != null && !medicoRepository.existsById(dados.idMedico())) {
            throw new ValidacaoException("Id do medico informado não existe!");
        }

        //validações
        validadores.forEach(v -> v.validar(dados));

        var paciente = pacienteRepository.getReferenceById(dados.idPaciente());
        var medico = escolherMedico(dados); //chamando o metodo para as validacoes necessarias

        //verifica se existe medico disponivel na data
        if (medico == null) {
            throw new ValidacaoException("Não existe medico disponivel nessa data");
        }

        var consulta = new Consulta(null, medico, paciente, dados.data());
        consultaRepository.save(consulta);

       return new DadosDetalhamentoConsulta(consulta);
    }

    //implementando o metodo para selecionar medico aleatorio
    private Medico escolherMedico(DadosAgendamentoConsulta dados) {
        //verifica se o id recebido é diferente de null
        if (dados.idMedico() != null) {
            return medicoRepository.getReferenceById(dados.idMedico());
        }

        //caso idMedico seja null se faz necessario a verificação do especialidade
        if (dados.especialidade() == null) {
            throw new ValidacaoException("Especialidade é obrigatória quando médico não for escolhido!");
        }

        //criando metodo para escolha do medico aleatorio em medicoRepository
        return medicoRepository.escolherMedicoAleatorioLivreNaData(dados.especialidade(), dados.data());

    }

}
