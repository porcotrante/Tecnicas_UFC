class main{
    public static void main(String args[]){
        Pessoa joao;
        Pessoa maria;

        joao = new Pessoa("joão", "123");
        maria = new Pessoa("maria", "321");

        System.out.println(joao.nome + " " + joao.cpf);
    }
}