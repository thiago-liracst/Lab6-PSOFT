package situacoes;

import objetos.Pessoa;

public class Finalizada extends Situacao{

    @Override
    public void mudaSituacao(Pessoa pessoa) {
        System.out.println("A pessoa já finalizou seu processo de vacinação.\n\n");
        
    }

    @Override
    public void tomaVacina(Pessoa pessoa) {
        System.out.println("A pessoa já finalizou seu processo de vacinação.\n\n");
    }

    @Override
    public String toString(){
        return "Tomou as 2 doses da vacina e está imunizada";
    }
    
}
