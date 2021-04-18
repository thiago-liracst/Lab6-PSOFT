package main;

import java.util.Scanner;

import objetos.VacinaJa;


public class Main {
    

    public static void main(String[] args){
        VacinaJa sistema = new VacinaJa();
        String menu =  "\n\nBem vindo ao VacinaJa\n\n" +
        "Seleciona a opcao deseja digitando o numero correspondente: \n" + 
        "1 - Cadastrar pessoa \n" +
        "2 - Vacinar pessoa \n" +
        "3 - Passar pessoa para proxima etapa de vacinacao\n" + 
        "4 - Alterar comorbidades de uma pessoa \n" + 
        "5 - Alterar profissao de uma pessoa \n" + 
        "6 - Ver situacao de uma pessoa \n" + 
        "7 - Listar pessoas que que nao estao habilitadas\n" +
        "8 - Listar pessoas habilitadas a tomar a dose 1\n" +
        "9 - Listar pessoas habilitadas a tomar a dose 2 \n" + 
        "10 - Listar pessoas que tomaram a dose 1 \n" + 
        "11 - Listar pessoas que foram imunizadas \n" + 
        "12 - Detalhes da Vacinacao \n" + 
        "13 - Adicionar comorbidade habiltiada para vacinacao\n" +
        "14 - Adicionar profissao habilitada para vacinacao\n" +
        "15 - Atualizar idade minima para vacinação\n" + 
        "0 - Sair";
        
        
        Scanner sc = new Scanner(System.in);
        int opcao;
        
        while(true){
            System.out.println(menu);
            System.out.println("Digite sua opcao: ");
            opcao = sc.nextInt();
            sc.nextLine();
            String cpf;
            String comorbidades;
            String profissao;
            switch(opcao){
                case(1):
                    cadastrarPessoa(sc, sistema);
                    break;
                case(2):
                    System.out.println("Informe o cpf da pessoa");
                    cpf = sc.nextLine();
                    sistema.tomarVacina(cpf);
                    break;
                case(3):
                    System.out.println("Informe o cpf da pessoa");
                    cpf = sc.nextLine();
                    sistema.avancarEtapa(cpf);
                    break;
                case(4):
                    System.out.println("Informe o cpf da pessoa");
                    cpf = sc.nextLine();
                    System.out.println("Informe as comorbidades da pessoa (separadas por espaço)");
                    comorbidades = sc.nextLine();
                    sistema.setPessoaComorbidades(cpf, comorbidades);
                    break;
                case(5):
                    System.out.println("Informe o cpf da pessoa");
                    cpf = sc.nextLine();
                    System.out.println("Informe a profissão da pessoa");
                    profissao = sc.nextLine();
                    sistema.setProfissaoPessoa(cpf, profissao);
                    break;
                case(6):
                    System.out.println("Informe o cpf da pessoa");
                    cpf = sc.nextLine();
                    sistema.pegarSituacaoPessoa(cpf);
                    break;
                case(7):
                    sistema.listarPessoasNaoHabilitadas();
                    break;
                case(8):
                    sistema.listarPessoasHabilitadasDose1();
                    break;
                case(9):
                    sistema.listarPessoasHabilitadasDose2();
                    break;
                case(10):
                    sistema.listarPessoasTomaramDose1();
                    break;
                case(11):
                    sistema.listarPessoasHabilitadasDose2();
                    break;
                case(12):
                    sistema.getDetalhes();
                    break;
                case(13):
                    System.out.println("Informe a comorbidade que será habilitada");
                    comorbidades = sc.nextLine();
                    sistema.adicionaComorbidadeHabilitada(comorbidades);
                    break;
                case(14):
                    System.out.println("Informea a profissão que será habilitada");
                    profissao = sc.nextLine();
                    sistema.adicionaProfissaoHabilitada(profissao);
                    break;
                case(15):
                    System.out.println("Informe a nova idade minima para vacinação");
                    int idade = sc.nextInt();
                    sc.nextLine();
                    sistema.setIdadeMinimaHabilitada(idade);
                    break;
                case(0):
                    break;
                default: 
                    System.out.println("Opção inválida\n\n");
            }
        
            if (opcao == 0){
                System.out.println("Tchau!");
                break;
            }
        }

   
    
    
    }
    public static void cadastrarPessoa(Scanner sc, VacinaJa sistema){
        
        String nome;
        String cpf;
        int idade;
        String endereco;
        String cartaoSUS;
        String email;
        String telefone;
        String profissao;
        String comorbidades;

        System.out.println("Informe o nome da pessoa");
        nome = sc.nextLine();

        System.out.println("Informe o cpf da pessoa");
        cpf = sc.nextLine();

        System.out.println("Informe a idade");
        idade = sc.nextInt();
        sc.nextLine();

        System.out.println("Informe o endereço");
        endereco = sc.nextLine();

        System.out.println("Informe o numero do cartao do SUS");
        cartaoSUS = sc.nextLine();

        System.out.println("Informe o email da pessoa");
        email = sc.nextLine();

        System.out.println("Informe o telefone da pessoa");
        telefone = sc.nextLine();

        System.out.println("Informe a profissão da pessoa");
        profissao = sc.nextLine();

        System.out.println("Informe as comorbidades da pessoa (separadas por espaço)");
        comorbidades = sc.nextLine();

        sistema.adicionarPessoa(nome, cpf, idade, endereco, cartaoSUS, email, telefone, profissao, comorbidades);

    }
}
