package POO;

public class Aplicacao {
    public static void main(String[] args){
        float resultado;
        float valor1 = 10.6f;
        float valor2 = 4.4f;
        Calculadora calculadora = new Calculadora();
        resultado = calculadora.soma(valor1,valor2);
        System.out.println("O resultado da soma de "+ valor1 + " + " + valor2 + " é " + resultado);
        resultado = calculadora.subtracao(valor1,valor2);
        System.out.println("O resultado da subtracao de "+ valor1 + " - " + valor2 + " é " + resultado);
        resultado = calculadora.multiplicacao(valor1,valor2);
        System.out.println("O resultado da multiplicacao de " + valor1 + " * " + valor2 + " é " + resultado);
        resultado = calculadora.divisao(valor1,valor2);
        System.out.println("O resultado da divisao de " + valor1 + " / " + valor2 + " é " + resultado);
    }
}
