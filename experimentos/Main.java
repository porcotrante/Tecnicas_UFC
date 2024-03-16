public class Main {
    public static void main(String []args){
        int arr[] = {3,14,22,37,81,40,78,10400,20000,100003800};
        
        Conjunto c1 = new Conjunto(arr);

        Conjunto c2 = new Conjunto();

        c2.inserir(100003800);

        c2.inserir(20000);

        c2.inserir(2);

        Conjunto c3 = Conjunto.intersec(c2,c1);

        for(int i = 0; i < c3.elementos.length; i++){
            System.out.println(c3.elementos[i]);
        }
    }
}