package objetos;

import java.util.*;

import situacoes.*;

public class VacinaJa {
    private Map<String, Pessoa> pessoasCadastradas;

    private Set<String> comorbidades;

    private Set<String> profissoes;

    private int idadeMinima;

    public VacinaJa(){
        this.pessoasCadastradas = new HashMap<String, Pessoa>();
        this.comorbidades = new TreeSet<String>();
        this.profissoes = new TreeSet<String>();
        this.idadeMinima = 90;
    }

    public void adicionarPessoa(String nome, String cpf, int idade,String endereco,
    String cartaoSUS, String email, String telefone, String profissao, String comorbidades){
        if(pessoasCadastradas.containsKey(cpf)){
            System.out.println("Pessoa com o cpf " + cpf + " ja está cadastrada no sistema.\n\n");
        }
        else{
            
            Pessoa pessoa = new Pessoa(nome, cpf, idade, endereco, cartaoSUS,  email,  telefone,  profissao, comorbidades);
            atualizaSituacao(pessoa);
            pessoasCadastradas.put(cpf, pessoa);
        }
    }

    public void adicionaComorbidadeHabilitada(String comorbidade){
        this.comorbidades.add(comorbidade);
        atualizaSituacoes();
    }
    
    public void adicionaProfissaoHabilitada(String profissao){
        this.profissoes.add(profissao);
        atualizaSituacoes();
    }
    
    public void setIdadeMinimaHabilitada(int idade){
        this.idadeMinima = idade;
        atualizaSituacoes();
    }

    public void setPessoaComorbidades(String cpf, String comorbidades){
        this.pessoasCadastradas.get(cpf).setComorbidades(comorbidades);
    }

    public void setProfissaoPessoa(String cpf, String profissao){
        this.pessoasCadastradas.get(cpf).setProfissao(profissao);
    }
    
    public void avancarEtapa(String cpf){
        if(!this.pessoasCadastradas.containsKey(cpf)){
            System.out.println("Pessoa com cpf: " + cpf +" nao está cadastrada no sistema.");
        }else if(verificaHabilitado(this.pessoasCadastradas.get(cpf))){
            this.pessoasCadastradas.get(cpf).avancarEtapa();
        }else{
            System.out.println("A pessoa não se encontra habilitada para tomar a vacina.");
        }
    }
    
    public void tomarVacina(String cpf){
        if(!this.pessoasCadastradas.containsKey(cpf)){
            System.out.println("Pessoa com cpf: " + cpf +" nao está cadastrada no sistema.");
        }else{
            this.pessoasCadastradas.get(cpf).tomarVacina();
        }
    }

    public void listarPessoasHabilitadasDose1(){
        String retorno = "";
        for(Pessoa pessoa : pessoasCadastradas.values()){
            if(pessoa.getSituacao() instanceof PrimeiraDose)retorno += pessoa.toString();
        }
        System.out.print(retorno);
    }

    public void listarPessoasHabilitadasDose2(){
        String retorno = "";
        for(Pessoa pessoa : pessoasCadastradas.values()){
            if(pessoa.getSituacao() instanceof SegundaDose)retorno += pessoa.toString();
        }
        System.out.print(retorno);
    }

    public void listarPessoasNaoHabilitadas(){
        String retorno = "";
        for(Pessoa pessoa : pessoasCadastradas.values()){
            if(pessoa.getSituacao() instanceof NaoHabilitado)retorno += pessoa.toString();
        }
        System.out.print(retorno);
    }
    
    public void listarPessoasTomaramDose1(){
        String retorno = "";
        for(Pessoa pessoa : pessoasCadastradas.values()){
            if(pessoa.getSituacao() instanceof TomouPrimeiraDose)retorno += pessoa.toString();
        }
        System.out.print(retorno);
    }
    
    public void listarPessoasImunizadas(){
        String retorno = "";
        for(Pessoa pessoa : pessoasCadastradas.values()){
            if(pessoa.getSituacao() instanceof Finalizada)retorno += pessoa.toString();
        }
        System.out.print(retorno);
    }

    public void pegarSituacaoPessoa(String cpf) {
        if(!this.pessoasCadastradas.containsKey(cpf)){
            System.out.println("Pessoa não cadastrada no sistema.\n\n");
        }else{
            System.out.println(this.pessoasCadastradas.get(cpf).toString() + " \n\n");
        }
    }

    public void listarComorbidadesHabiltiadas(){
        String retorno = "Lista de comorbidades que possibilitam o recebimento da vacina: \n";
        for(String comorbidade : this.comorbidades){
            retorno += comorbidade + "\n";
        }
        System.out.print(retorno);
    }

    public void listarProfissoesHabiltiadas(){
        String retorno = "Lista de profissões que podem receber a vacina: \n";
        for(String profissao : this.profissoes){
            retorno += profissao + "\n";
        }
        System.out.print(retorno);
    }

    public void getIdadeMinimaVacinacao(){
        System.out.println("A idade miníma para vacinação é " + this.idadeMinima + " anos de idade.");
    }

    public void getDetalhes(){
        listarComorbidadesHabiltiadas();
        listarProfissoesHabiltiadas();
        getIdadeMinimaVacinacao();
    }

    private void atualizaSituacoes() {
        for (Pessoa pessoa : this.pessoasCadastradas.values()){
            atualizaSituacao(pessoa);
        }
    }
    
    private void atualizaSituacao(Pessoa pessoa) {
        if (pessoa.getSituacao() instanceof NaoHabilitado && verificaHabilitado(pessoa)){
            pessoa.getSituacao().mudaSituacao(pessoa);
        }
    }
    
    private boolean verificaHabilitado(Pessoa pessoa) {
        if (pessoa.getIdade() >= idadeMinima) return true;
        if ( this.profissoes.contains(pessoa.getProfissao()))return true;
        for(String comorbidade : pessoa.getComorbidades()){
            if(comorbidades.contains(comorbidade))return true;
        }
        return false;
        
    }
    
    public Map<String, Pessoa> getPessoasCadastradas() {
        return this.pessoasCadastradas;
    }

    public void setPessoasCadastradas(Map<String, Pessoa> pessoasCadastradas) {
        this.pessoasCadastradas = pessoasCadastradas;
    }

    public Set<String> getComorbidades() {
        return this.comorbidades;
    }

    public void setComorbidades(Set<String> comorbidades) {
        this.comorbidades = comorbidades;
    }

    public Set<String> getProfissoes() {
        return this.profissoes;
    }

    public void setProfissoes(Set<String> profissoes) {
        this.profissoes = profissoes;
    }

    public int getIdadeMinima() {
        return this.idadeMinima;
    }
}
