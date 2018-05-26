package CaixaEletronico;

public class Endereco {

    private String logradouro;
    private int numeroRua;
    private String cidade;
    private String estado;

    Endereco(String logradouro,int numeroRua, String cidade,String estado){
        this.logradouro = logradouro;
        this.numeroRua = numeroRua;
        this.cidade = cidade;
        this.estado = estado;
    }

    public String getLogradouro(){
        return this.logradouro;
    }
}

