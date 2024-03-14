class Casamento{

    public static void casar(Pessoa c1, Pessoa c2){
    if (!c1.equals(c2)){
            c1.conjuge = c2;
            c2.conjuge = c1;

            System.out.println(c1.nome + " e " + c2.nome + " casaram!");
        }
    }

    public static void divorcio(Pessoa c1, Pessoa c2){
        c1.conjuge = null;
        c2.conjuge = null;

        System.out.println("Divórcio de " + c1.nome + " e " + c2.nome + " realizado com sucesso!");
    }
}