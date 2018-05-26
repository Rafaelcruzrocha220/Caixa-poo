package CaixaEletronico;
import java.util.Random;
import java.util.ArrayList;
import java.util.List;
import java.lang.StringBuilder;

public class Caixa extends Endereco {

    private String codigo;
    private Bandeja nota100;
    private Bandeja nota50;
    private Bandeja nota20;
    private Bandeja nota10;

    Caixa(String logradouro,int numeroRua,String cidade,String estado,Bandeja nota100,Bandeja nota50,Bandeja nota20,Bandeja nota10){
        super(logradouro,numeroRua,cidade,estado);
        this.nota100 = nota100;
        this.nota50 = nota50;
        this.nota20 = nota20;
        this.nota10 = nota10;
        this.codigo = CodigoLetrasNum();
    }

    public String CodigoLetrasNum(){
        Random rn = new Random();
        char[] alphabet = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        
        int randomNum;
        String codigoGerado = "";
        String codigoFinal = "";


            for (int i = 0; i < 5; i++) {
                if(i <= 1) {
                    randomNum = rn.nextInt(10);
                    codigoGerado = Character.toString(alphabet[randomNum]);
                    codigoFinal = codigoFinal.concat(codigoGerado);
                }
                if (i >= 2) {
                     randomNum = rn.nextInt(10);
                     codigoGerado = String.valueOf(randomNum);
                     codigoFinal = codigoFinal.concat(codigoGerado);
                }
            }
            return codigoFinal;      
    }

    public String getCodigo(){
        return this.codigo;
    }

    public void setCodigo(String novoCodigo){
        this.codigo = CodigoLetrasNum(novoCodigo);
    }

    public double saldo(){
        double Soma100 = this.nota100.quantidadeCedulas * 100;
        double Soma50 = this.nota50.quantidadeCedulas * 50;
        double Soma20 = this.nota20.quantidadeCedulas * 20;
        double Soma10 = this.nota10.quantidadeCedulas * 10;
        return Soma100 + Soma50 + Soma20 + Soma10;
    }

    public double saldoB100(){
        return this.nota100.quantidadeCedulas * 100;
    }

    public double saldoB50(){
        return this.nota50.quantidadeCedulas * 50;
    }

    public double saldoB20(){
        return this.nota20.quantidadeCedulas * 20;
    }

    public double saldoB10(){
        return this.nota10.quantidadeCedulas * 10;
    }

    public String sacar(double valor){
        int notas100 = 0;
        int notas50 = 0;
        int notas20 = 0;
        int notas10 = 0;


        if (valor < saldo() && valor % 10 == 0) {

            if(valor >= 100){
                while (valor >= 100 && this.nota100.quantidadeCedulas >= 1) {
                    valor = valor - 100;
                    notas100++;
                    this.nota100.quantidadeCedulas--;
                }
            }

            if(valor >= 50){
                while (valor >= 50 && this.nota50.quantidadeCedulas >= 1) {
                    valor = valor - 50;
                    notas50++;
                    this.nota50.quantidadeCedulas--;
                }
            }

            if(valor >= 20){
                while (valor >= 20 && this.nota20.quantidadeCedulas >= 1) {
                    valor = valor - 20;
                    notas20++;
                    this.nota20.quantidadeCedulas--;
                }
            }

            if(valor >= 10){
                while (valor >= 10 && this.nota10.quantidadeCedulas >= 1) {
                    valor = valor - 10;
                    notas10++;
                    this.nota10.quantidadeCedulas--;
                }
            }
            String resultado = "\nTotal de notas de 100 = " + notas100 + "\nTotal de notas de 50 = " + notas50 + "\nTotal de notas de 20 = " + notas20 + "\nTotal de notas de 50 =" + notas10;
            return resultado;
        }else return "\nO valor é inválido!!!";
    }

}