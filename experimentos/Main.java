public class Main {
    public static void main(String []args){
        int arr[] = {1,2,3,4,5};
        
        Conjunto c1 = new Conjunto(arr);

        Conjunto c2 = new Conjunto();

        c2.inserir(2);

        c2.inserir(4);

        c2.inserir(6);

        Conjunto c3 = Conjunto.dif(c2,c1);

        for(int i = 0; i < c3.elementos.length; i++){
            System.out.println(c3.elementos[i]);
        }
    }
}