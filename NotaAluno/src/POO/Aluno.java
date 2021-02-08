package POO;

public class Aluno {

    private String nomeAluno;
    private float notaFinal;

    //construtor
    public Aluno(String nomeAluno) {

        this.nomeAluno = nomeAluno;
    }

    public void calcularMedia(float nota1, float nota2) {

        this.notaFinal = (nota1 + nota2)/2;
    }

    public boolean conceito(){

        return this.notaFinal>=7;
    }

    //metodo getter para acessar o nomeAluno e nota final

    public String getNomeAluno() {
        return nomeAluno;
    }

    public float getNotaFinal() {
        return notaFinal;
    }
}
