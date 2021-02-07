package POO;

public class Aplicacao {
    public static void main(String[] args){
        float nota1=8.7f;
        float nota2=9.8f;
        boolean conceitoFinal;
        Aluno aluno = new Aluno("Douglas");
        aluno.calcularMedia(nota1,nota2);
        conceitoFinal=aluno.conceito();
        System.out.println("Aluno: " + aluno.getNomeAluno() + "\nNota final: " + aluno.getNotaFinal() +
                "\nAprovado: " + conceitoFinal);
    }
}
