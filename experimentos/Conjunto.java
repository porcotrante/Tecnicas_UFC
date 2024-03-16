public class Conjunto {
    int elementos[];

    Conjunto(int elementos[]){
        this.elementos = elementos.clone();
    }

    Conjunto(){
        int aux[] = {};

        this.elementos = aux.clone();
    }

    public void inserir(int n){
        int aux[] = new int[this.elementos.length + 1];

        for(int i = 0; i < this.elementos.length; i++){
            aux[i] = this.elementos[i];
        }

        aux[aux.length - 1] = n;

        this.elementos = aux.clone();
    }

    public boolean pertence(int n){
        for(int i = 0; i < this.elementos.length; i++){
            if (n == this.elementos[i]) {
                return true;
            }
        }
        return false;
    }

    public boolean subCon(Conjunto c){
        if (this.elementos.length < c.elementos.length) {
            return false;
        }

        for(int i = 0; i < c.elementos.length; i++){
            if (!this.pertence(c.elementos[i])) {
                return false;
            }
        }
        return true;
    }

    public static Conjunto uniao(Conjunto c1, Conjunto c2){
        if (c1.elementos.length > c2.elementos.length) {
            Conjunto uc = new Conjunto(c1.elementos);

            for(int i = 0; i < c2.elementos.length; i++){
                if (!uc.pertence(c2.elementos[i])) {
                    uc.inserir(c2.elementos[i]);
                }
            }
            return uc;
        }

        Conjunto uc = new Conjunto(c2.elementos);
        for(int i = 0; i < c1.elementos.length; i++){
            if (!uc.pertence(c1.elementos[i])) {
                uc.inserir(c1.elementos[i]);
            }
        }
        return uc;
    }

    public static Conjunto intersec(Conjunto c1, Conjunto c2){
        Conjunto ic = new Conjunto();

        for(int i = 0; i < c1.elementos.length; i++){
            if (c2.pertence(c1.elementos[i])) {
                ic.inserir(c1.elementos[i]);
            }
        }

        return ic;
    }

    public static Conjunto dif(Conjunto c1, Conjunto c2){
        Conjunto dc = new Conjunto();

        for(int i = 0; i < c1.elementos.length; i++){
            if (!c2.pertence(c1.elementos[i])) {
                dc.inserir(c1.elementos[i]);
            }
        }

        return dc;
    }
}
