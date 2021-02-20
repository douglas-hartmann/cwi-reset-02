package exercicio2;

import java.util.List;

public class Filme {
    private String nome;
    private String descricao;
    private int duracao;
    private int anoLancamento;
    private int avaliacao;
    private Diretor diretor;
    private List <Pessoa> elenco;

    public Filme(String nome, String descricao, int duracao, int anoLancamento, int avaliacao, Diretor diretor, List <Pessoa> elenco) {
        this.nome = nome;
        this.descricao = descricao;
        this.duracao = duracao;
        this.avaliacao = avaliacao;
        this.anoLancamento = anoLancamento;
        this.diretor = diretor;
        this.elenco=elenco;

    }

    public void exibirCreditos (){

        for(Pessoa elenco  : elenco){
            elenco.imprimirInformacoes();

        }
    }

}
