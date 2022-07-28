package ct02;

public abstract class Conta {
        private int numero;
        private Cliente titular;
        protected double saldo;

        public abstract boolean sacar(double valor);

}
