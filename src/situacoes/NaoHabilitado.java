package situacoes;

import objetos.Pessoa;

public class NaoHabilitado extends Situacao{
    @Override
    public void mudaSituacao(Pessoa pessoa) {
        pessoa.setSituacao(new PrimeiraDose());
        System.out.println(pessoa.getNome() + " est� habilitada para tomar a primeira dose da vacina. \n\n");
    }

    @Override
    public void tomaVacina(Pessoa pessoa) {
        System.out.println(pessoa.getNome()+ " ainda n�o est� habilitada para tomar a primeira dose da vacina.\n\n");
        
    }
    @Override
    public String toString() {
        return "N�o habilitada para a primeira dose da vacina";
    }
}
