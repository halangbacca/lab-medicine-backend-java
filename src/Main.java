// Correção da IndexOutOfBoundsException na tela de atendimento médico e na tela de alterar status do paciente

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void telaInicial() {
        int opcao = 0;

        System.out.println(
                "=========================\n" +
                        "Bem vindo ao LABMedicine!\n" +
                        "=========================\n" +
                        "\nSelecione uma das opções abaixo:\n\n" +
                        "1. Cadastro de Paciente\n" +
                        "2. Cadastro de Enfermeiro\n" +
                        "3. Cadastro de Médico\n" +
                        "4. Realização de Atendimento Médico\n" +
                        "5. Atualização do Status de Atendimento do Paciente\n" +
                        "6. Relatórios\n" +
                        "7. Sair\n");

        do {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.print("Opção selecionada: ");
                opcao = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Opção incorreta, tente novamente!\n");
            }
        } while (opcao < 1 || opcao > 7);

        switch (opcao) {
            case 1:
                cadastroDePaciente();
                break;

            case 2:
                cadastroDeEnfermeiro();
                break;

            case 3:
                cadastroDeMedico();
                break;

            case 4:
                atendimentoMedico();
                break;

            case 5:
                alterarStatusPaciente();
                break;

            case 6:
                relatorios();
                break;

            case 7:
                System.exit(0);
        }
    }

    public static void cadastroDePaciente() {
        System.out.println("\n====================\nCadastro de Paciente\n====================\n");

        System.out.println("Itens marcados com * são de preenchimento obrigatório!\n");

        Paciente paciente = new Paciente();

        Scanner scannerPaciente = new Scanner(System.in);

        do {
            System.out.print("*Insira o nome completo do(a) paciente: ");
            paciente.setNomeCompleto(scannerPaciente.nextLine());
        } while (paciente.getNomeCompleto().isEmpty());

        do {
            System.out.print("*Insira o gênero do(a) paciente: ");
            paciente.setGenero(validaGenero(scannerPaciente.nextLine()));
        } while (paciente.getGenero() == null);

        do {
            System.out.print("*Insira a data de nascimento do(a) paciente (dia/mês/ano): ");
            paciente.setDataDeNascimento(validaData(scannerPaciente.nextLine().replace("-", "/")));
        } while (paciente.getDataDeNascimento() == null);

        do {
            System.out.print("*Insira o CPF do(a) paciente: ");
            paciente.setCpf(scannerPaciente.nextLine());
        } while (paciente.getCpf().isEmpty());

        do {
            System.out.print("*Insira o telefone do(a) paciente: ");
            paciente.setTelefone(scannerPaciente.nextLine());
        } while (paciente.getTelefone().isEmpty());

        do {
            System.out.print("*Insira o contato de emergência do(a) paciente: ");
            paciente.setContatoDeEmergencia(scannerPaciente.nextLine());
        } while (paciente.getContatoDeEmergencia().isEmpty());

        System.out.print("Insira o convênio do(a) paciente: ");
        paciente.setConvenio(scannerPaciente.nextLine());

        if (!paciente.getConvenio().isEmpty()) {
            do {
                System.out.print("*Insira o número do convênio do(a) paciente: ");
                paciente.setNumeroDoConvenio(scannerPaciente.nextLine());
            } while (paciente.getNumeroDoConvenio().isEmpty());

            do {
                System.out.print("*Insira a data de validade do convênio do(a) paciente (dia/mês/ano): ");
                paciente.setValidadeDoConvenio(validaData(scannerPaciente.nextLine().replace("-", "/")));
            } while (paciente.getValidadeDoConvenio() == null);
        }

        System.out.print("Insira alergias do(a) paciente: ");
        paciente.setListaDeAlergias(scannerPaciente.nextLine());

        System.out.print("Insira cuidados específicos do(a) paciente: ");
        paciente.setListaDeCuidadosEspecificos(scannerPaciente.nextLine());

        Paciente.adicionarPaciente(paciente);

        System.out.println("\nPaciente cadastrado(a) com sucesso!");

        reiniciaExecucao();
    }

    public static void cadastroDeEnfermeiro() {
        System.out.println("\n======================\nCadastro de Enfermeiro\n======================\n");

        System.out.println("Itens marcados com * são de preenchimento obrigatório!\n");

        Enfermeiro enfermeiro = new Enfermeiro();

        Scanner scannerEnfermeiro = new Scanner(System.in);

        do {
            System.out.print("*Insira o nome completo do(a) enfermeiro(a): ");
            enfermeiro.setNomeCompleto(scannerEnfermeiro.nextLine());
        } while (enfermeiro.getNomeCompleto().isEmpty());

        do {
            System.out.print("*Insira o gênero do(a) enfermeiro(a): ");
            enfermeiro.setGenero(validaGenero(scannerEnfermeiro.nextLine()));
        } while (enfermeiro.getGenero() == null);

        do {
            System.out.print("*Insira a data de nascimento do(a) enfermeiro(a) (dia/mês/ano): ");
            enfermeiro.setDataDeNascimento(validaData(scannerEnfermeiro.nextLine().replace("-", "/")));
        } while (enfermeiro.getDataDeNascimento() == null);

        do {
            System.out.print("*Insira o CPF do(a) enfermeiro(a): ");
            enfermeiro.setCpf(scannerEnfermeiro.nextLine());
        } while (enfermeiro.getCpf().isEmpty());

        do {
            System.out.print("*Insira o telefone do(a) enfermeiro(a): ");
            enfermeiro.setTelefone(scannerEnfermeiro.nextLine());
        } while (enfermeiro.getTelefone().isEmpty());

        do {
            System.out.print("*Insira a instituição de formação do(a) enfermeiro(a): ");
            enfermeiro.setInstituicaoDeEnsinoDaFormacao(scannerEnfermeiro.nextLine());
        } while (enfermeiro.getInstituicaoDeEnsinoDaFormacao().isEmpty());

        do {
            System.out.print("*Insira o COREN/UF do(a) enfermeiro(a): ");
            enfermeiro.setCoren(scannerEnfermeiro.nextLine());
        } while (enfermeiro.getCoren().isEmpty());

        Enfermeiro.adicionarEnfermeiro(enfermeiro);

        System.out.println("\nEnfermeiro(a) cadastrado(a) com sucesso!");

        reiniciaExecucao();

    }

    public static void cadastroDeMedico() {
        System.out.println("\n==================\nCadastro de Médico\n==================\n");

        System.out.println("Itens marcados com * são de preenchimento obrigatório!\n");

        Medico medico = new Medico();

        Scanner scannerMedico = new Scanner(System.in);

        do {
            System.out.print("*Insira o nome completo do(a) médico(a): ");
            medico.setNomeCompleto(scannerMedico.nextLine());
        } while (medico.getNomeCompleto().isEmpty());

        do {
            System.out.print("*Insira o gênero do(a) médico(a): ");
            medico.setGenero(validaGenero(scannerMedico.nextLine()));
        } while (medico.getGenero() == null);

        do {
            System.out.print("*Insira a data de nascimento do(a) médico(a) (dia/mês/ano): ");
            medico.setDataDeNascimento(validaData(scannerMedico.nextLine().replace("-", "/")));
        } while (medico.getDataDeNascimento() == null);

        do {
            System.out.print("*Insira o CPF do(a) médico(a): ");
            medico.setCpf(scannerMedico.nextLine());
        } while (medico.getCpf().isEmpty());

        do {
            System.out.print("*Insira o telefone do(a) médico(a): ");
            medico.setTelefone(scannerMedico.nextLine());
        } while (medico.getTelefone().isEmpty());

        do {
            System.out.print("*Insira a instituição de formação do(a) médico(a): ");
            medico.setInstituicaoDeEnsinoDaFormacao(scannerMedico.nextLine());
        } while (medico.getInstituicaoDeEnsinoDaFormacao().isEmpty());

        do {
            System.out.print("*Insira o CRM/UF do(a) médico(a): ");
            medico.setCrm(scannerMedico.nextLine());
        } while (medico.getCrm().isEmpty());


        System.out.println("\n*Insira a especialidade do(a) médico(a): ");
        System.out.println("\n1.Clínico Geral\n2.Anestesiologia\n3.Dermatologia\n4.Ginecologia\n5.Neurologia\n6.Pediatria\n7.Psiquiatria\n8.Ortopedia");

        do {
            System.out.print("\nEspecialidade: ");
            medico.setEspecialidade(scannerMedico.nextLine());
        } while (medico.getEspecialidade() == null);

        medico.setStatusNoSistema(true);

        Medico.adicionarMedico(medico);

        System.out.println("\nMédico(a) cadastrado(a) com sucesso!");

        reiniciaExecucao();

    }

    public static void atendimentoMedico() {
        System.out.println("\n================================\nRealização de atendimento médico\n================================");

        System.out.println("\nSelecione um(a) médico(a) pelo seu identificador: ");
        Medico.getListaDeMedicos();

        System.out.print("\nIdentificador do(a) médico(a): ");
        Scanner scannerSelecionarMedicoPaciente = new Scanner(System.in);
        int medicoSelecionado = scannerSelecionarMedicoPaciente.nextInt();

        Medico.selecionarMedico(medicoSelecionado);

        System.out.println("\nSelecione um(a) paciente pelo seu identificador: ");
        Paciente.getListaDePacientes();

        System.out.print("\nIdentificador do(a) paciente: ");
        int pacienteSelecionado = scannerSelecionarMedicoPaciente.nextInt();

        Paciente.selecionarPaciente(pacienteSelecionado);

        System.out.println("\nAtendimento realizado com sucesso!");

        reiniciaExecucao();

    }

    public static void alterarStatusPaciente() {
        System.out.println("\n================================================\nAtualização do status de atendimento do paciente\n================================================");

        System.out.println("\nSelecione um(a) paciente pelo seu identificador: ");
        Paciente.getListaDePacientes();

        System.out.print("\nIdentificador do(a) paciente: ");
        Scanner scannerIndicePaciente = new Scanner(System.in);
        int indicePaciente = scannerIndicePaciente.nextInt();
        int statusPaciente = 0;

        System.out.println("\nSelecione o status de atendimento:\n\n" +
                "1. Aguardando atendimento\n" +
                "2. Em atendimento\n" +
                "3. Atendido\n" +
                "4. Não atendido\n");

        do {
            try {
                System.out.print("Status de atendimento: ");
                statusPaciente = scannerIndicePaciente.nextInt();

            } catch (InputMismatchException e) {
                System.out.println("Opção incorreta, tente novamente!");
            }
        } while (statusPaciente < 1 || statusPaciente > 4);

        Paciente.atualizarStatusPaciente(indicePaciente, statusPaciente);

        System.out.println("\nStatus do(a) paciente alterado com sucesso!");

        reiniciaExecucao();

    }

    public static void relatorios() {
        int opcao = 0;

        System.out.println("\n==========\nRelatórios\n==========");

        System.out.println("\nSelecione uma das opções abaixo:\n\n" +
                "1. Relatório de pacientes\n" +
                "2. Relatório de enfermeiros\n" +
                "3. Relatório de médicos\n" +
                "4. Relatório geral\n" +
                "5. Voltar\n");

        do {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.print("Tipo de relatório: ");
                opcao = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Opção incorreta, tente novamente!\n");
            }
        } while (opcao < 1 || opcao > 5);

        switch (opcao) {
            case 1:
                int status = 0;
                System.out.println("\nSelecione o status de atendimento:\n\n" +
                        "1. Aguardando atendimento\n" +
                        "2. Em atendimento\n" +
                        "3. Atendido\n" +
                        "4. Não atendido\n" +
                        "5. Todos\n" +
                        "6. Voltar uma tela\n" +
                        "7. Voltar a tela inicial\n");

                do {
                    try {
                        Scanner scannerStatusPaciente = new Scanner(System.in);
                        System.out.print("Status de atendimento: ");
                        status = scannerStatusPaciente.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.println("Opção incorreta, tente novamente!\n");
                    }
                } while (status < 1 || status > 7);

                Pessoa.relatorioPacientes(status);

                reiniciaExecucao();

                break;

            case 2:
                Enfermeiro.getListaDeEnfermeiros();
                reiniciaExecucao();
                break;

            case 3:
                int especialidade = 0;
                System.out.println("\nSelecione uma especialidade:\n\n" +
                        "1. Clínico geral\n" +
                        "2. Anestesiologia\n" +
                        "3. Dermatologia\n" +
                        "4. Ginecologia\n" +
                        "5. Neurologia\n" +
                        "6. Pediatria\n" +
                        "7. Psiquiatria\n" +
                        "8. Ortopedia\n" +
                        "9. Todos\n" +
                        "10. Voltar uma tela\n" +
                        "11. Voltar a tela inicial\n");

                do {
                    try {
                        Scanner scannerEspecialidadeMedico = new Scanner(System.in);
                        System.out.print("Especialidade: ");
                        especialidade = scannerEspecialidadeMedico.nextInt();

                    } catch (InputMismatchException e) {
                        System.out.println("Opção incorreta, tente novamente!\n");
                    }
                } while (especialidade < 1 || especialidade > 11);

                Pessoa.relatorioMedico(especialidade);

                reiniciaExecucao();

                break;

            case 4:
                Pessoa.relatorioGeral();
                reiniciaExecucao();
                break;

            case 5:
                telaInicial();
                break;
        }
    }

    public static String validaGenero(String inputGenero) {
        if (inputGenero.equalsIgnoreCase("masculino") || inputGenero.equalsIgnoreCase("feminino") || inputGenero.equalsIgnoreCase("outro")) {
            return inputGenero;
        } else {
            return null;
        }
    }

    public static String validaData(String inputData) {
        Date data = null;
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

        try {
            format.setLenient(false);
            data = format.parse(inputData);
            return inputData;
        } catch (ParseException e) {
            System.out.println("Data inválida, tente novamente!\n");
        }
        return null;
    }

    public static void reiniciaExecucao() {
        System.out.print("\nPressione qualquer tecla para continuar... ");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();

        System.out.println("\n");
        telaInicial();
    }

    public static void main(String[] args) {
        telaInicial();
    }
}