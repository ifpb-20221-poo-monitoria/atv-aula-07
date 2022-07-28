package ct01;

public abstract class Conta {
        private int numero;
        private String nomeTitular;
        protected double saldo;

        public abstract boolean sacar(double valor);

        public int getNumero() {
                return numero;
        }

        public void setNumero(int numero) {
                this.numero = numero;
        }

        public String getNomeTitular() {
                return nomeTitular;
        }

        public void setNomeTitular(String nomeTitular) {
                this.nomeTitular = nomeTitular;
        }

        public double getSaldo() {
                return saldo;
        }
}
