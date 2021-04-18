package situacoes;

import objetos.Pessoa;

public class TomouPrimeiraDose extends Situacao{
    @Override
    public void mudaSituacao(Pessoa pessoa) {
        pessoa.setSituacao(new SegundaDose());
        System.out.print(pessoa.getNome() + " est� habilitada para tomar a segunda dose da vacina.\n\n");
    }

    @Override
    public void tomaVacina(Pessoa pessoa) {
        System.out.println(pessoa.getNome() + " n�o pode tomar a segunda dose da vacina agora.\n\n");    
    }

    @Override
    public String toString(){
        return "Tomou a primeira dose e est� na fase de espera para tomar a segunda dose da vacina.";
    }
}
