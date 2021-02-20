package exercicio2;

public enum Genero {
    MASCULINO("Masculino"),
    FEMININO("Feminino"),
    NAO_BINARIO("Não Binário");

    private String genero;

    Genero (String genero){
        this.genero = genero;
    }

    public String getGenero() {
        return genero;
    }
}