package Projeto;

public enum UnidadeFederativa {
    ACRE("Acre"),
    ALAGOAS("Alagoas"),
    AMAPA("Amapa"),
    AMAZONAS("Amazonas"),
    BAHIA("Bahia"),
    CEARA("Ceará"),
    DISTRITO("Distrito Federal"),
    ESPIRITOSANTO("Espirito Santo"),
    GOIAS("Goias"),
    MARANHAO("Maranhão"),
    MATOGROSSO("Mato Grosso"),
    MATOGROSSOSUL("Mato Grosso do Sul"),
    MINASGERAIS("Minas Gerais"),
    PARA("Pará"),
    PARAIBA("Paraíba"),
    PARANA("Paraná"),
    PERNAMBUCO("Pernambuco"),
    PIAUI("Piauí"),
    RIODEJANEIRO("Rio de Janeiro"),
    RIOGRANDEDONORTE("Rio Grande do Norte"),
    RIOGRANDEDOSUL("Rio Grande do Sul"),
    RONDONIA("Rondônia"),
    RORAIMA("Roraima"),
    SANTACATARINA("Santa Catarina"),
    SAOPAULO("São Paulo"),
    SERGIPE("Sergipe"),
    TOCANTINS("Tocantins");

    private String descricao;

    UnidadeFederativa(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
