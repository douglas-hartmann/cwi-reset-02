package POO;

import java.util.Scanner;

public class Aplicacao {
    public static void main(String[] args){
        float nota1;
        float nota2;
        String nomeAluno;
        boolean conceitoFinal;
        Scanner lerTeclado = new Scanner(System.in);
        System.out.println("Informe o nome do aluno ");
        nomeAluno = lerTeclado.nextLine();
        Aluno aluno = new Aluno(nomeAluno);
        System.out.println("Informe a nota 1 do aluno ");
        nota1=lerTeclado.nextFloat();
        System.out.println("Informe a nota 2 do aluno ");
        nota2=lerTeclado.nextFloat();
        aluno.calcularMedia(nota1,nota2);
        conceitoFinal=aluno.conceito();
        System.out.println("Aluno: " + aluno.getNomeAluno() + "\nNota final: " + aluno.getNotaFinal() +
                "\nAprovado: " + conceitoFinal);
        //System.out.println(String.format("\nNota do aluno: %.2f ", aluno.getNotaFinal()));

    }
}
