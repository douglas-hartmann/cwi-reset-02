package exercicios;

import java.util.List;

public class Filme {
    private String nome;
    private String descricao;
    private int duracao;
    private int anoLancamento;
    private int avaliacao;
    private Diretor diretor;

    public Filme(String nome, String descricao, int duracao, int anoLancamento, int avaliacao, Diretor diretor) {
        this.nome = nome;
        this.descricao = descricao;
        this.duracao = duracao;
        this.avaliacao = avaliacao;
        verificaRange();
        this.anoLancamento = anoLancamento;
        this.diretor = diretor;

    }

    public void verificaRange(){
        if (this.avaliacao<1 || this.avaliacao>5){
            System.out.println("Avaliçao fora do range.");
            this.avaliacao=3;
        }
        if(this.nome=="Clube da Luta"){
            this.avaliacao=5;
        }else if(this.nome=="Batman vs Superman"){
            this.avaliacao=1;
        }

    }

    public void reproduzirFilme(){
        System.out.println("Filme: " + this.nome);
        System.out.println("Descricao: " + this.descricao);
        System.out.println("Duracao: " + this.duracao);
        System.out.println("Avaliacao: " + this.avaliacao);
        System.out.println("Diretor: " + this.diretor.getNome());
    }

}
