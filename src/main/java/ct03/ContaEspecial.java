package ct03;

public class ContaEspecial extends Conta {
    private double limite = 1000;

    public boolean sacar(double valor){
        if(valor <= this.limite + this.saldo){
            this.saldo -= valor;
            return true;
        }else{
            return false;
        }
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }
}
