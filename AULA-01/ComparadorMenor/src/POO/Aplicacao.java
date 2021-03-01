package POO;

public class Aplicacao {
    public static void main(String[] args){
        int valor1=9;
        int valor2=10;
        Comparador comparador = new Comparador();
        boolean resultado = comparador.menorQue(valor1,valor2);
        System.out.println(valor1 + " < " + valor2 + " ? "+resultado);
    }
}
