package exercicio01;

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
        this.anoLancamento = anoLancamento;
        this.avaliacao = avaliacao;
        this.diretor = diretor;
    }

    public void reproduzirFilme(){
        System.out.println("Filme: " + this.nome);
        System.out.println("Descricao: " + this.descricao);
        System.out.println("Duracao: " + this.duracao);
        System.out.println("Diretor: " + diretor.getNome());
    }

}
