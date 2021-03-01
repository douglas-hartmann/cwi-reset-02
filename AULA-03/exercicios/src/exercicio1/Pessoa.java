package exercicio1;

   public abstract class Pessoa {

        private String nome;
        private int idade;
        private Genero genero;

        public Pessoa(String nome, int idade, Genero genero) {
            this.nome = nome;
            this.idade = idade;
            this.genero = genero;
        }

        public void imprimirInformacoes() {
            System.out.println("Nome: " + getNome());
            System.out.println("Idade: " + getIdade());
            System.out.println("Genero: " + getGenero().getGenero());
        }

        public String getNome() {
            return nome;
        }

       public Genero getGenero() {
           return genero;
       }

       public int getIdade() {
           return idade;
       }
   }
