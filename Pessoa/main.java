class main{
    public static void main(String args[]){
        Pessoa joao;
        Pessoa maria;

        joao = new Pessoa();
        maria = new Pessoa();

        joao.nome = "João";
        maria.nome = "Maria";
        joao.cpf = "111.111.111-11";
        maria.cpf = "222.222.222-22";
        joao.idade = 19;
        maria.idade = 17;

        Casamento.casar(joao,maria);

        System.out.println(joao.conjuge.nome);
        System.out.println(maria.conjuge.nome);

        Casamento.divorcio(joao,maria);
    }
}