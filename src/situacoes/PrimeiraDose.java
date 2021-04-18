package situacoes;

import objetos.Pessoa;

public class PrimeiraDose extends Situacao{

    @Override
    public void mudaSituacao(Pessoa pessoa) {
        System.out.println(pessoa.getNome() + " n�o pode passar para a pr�xima fase sem ter tomado a primeira dose da vacina.\n\n");
        
    }

    @Override
    public void tomaVacina(Pessoa pessoa) {
        pessoa.setSituacao(new TomouPrimeiraDose());
        System.out.println(pessoa.getNome() + " tomou a primeira dose da vacina e est� em fase de espera para a segunda dose.\n\n");
        
    }

    @Override
    public String toString(){
        return "Habilitada para a primiera dose da vacina;";
    }
    
}
