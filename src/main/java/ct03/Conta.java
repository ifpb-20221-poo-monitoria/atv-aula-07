package ct03;

public abstract class Conta {
        private int numero;
        private Cliente titular;
        protected double saldo;

        public abstract boolean sacar(double valor);

        public void depositar(double valor){
                this.saldo += valor;
        }

        public int getNumero() {
                return numero;
        }

        public void setNumero(int numero) {
                this.numero = numero;
        }

        public Cliente getTitular() {
                return titular;
        }

        public void setTitular(Cliente titular) {
                this.titular = titular;
        }

        public double getSaldo() {
                return saldo;
        }
}
