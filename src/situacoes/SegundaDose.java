package situacoes;

import objetos.Pessoa; 

public class SegundaDose extends Situacao{

    @Override
    public void mudaSituacao(Pessoa pessoa) {
        System.out.println(pessoa.getNome() + " n�o pode passar para a pr�xima fase sem ter tomado a segunda dose da vacina.\n\n");
        
    }

    @Override
    public void tomaVacina(Pessoa pessoa) {
        pessoa.setSituacao(new Finalizada());
        System.out.println(pessoa.getNome() + " tomou a segunda dose da vacina e est� imunizada.\n\n");
        
    }

    @Override
    public String toString(){
        return "Habilitada para a dose 2 da vacina";
    }
    
}
