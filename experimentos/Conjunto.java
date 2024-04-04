public class Conjunto {
    Object elementos[];

    Conjunto(Object elementos[]){
        this.elementos = elementos.clone();
    }

    Conjunto(){
        Object aux[] = {};

        this.elementos = aux.clone();

        aux = null;
    }

    public boolean pertence(Object n){
        for(int i = 0; i < this.elementos.length; i++){
            if (n.equals(this.elementos[i])) {
                return true;
            }
        }
        return false;
    }

    public void inserir(Object n){
        Object aux[] = new Object[this.elementos.length + 1];

        for(int i = 0; i < this.elementos.length; i++){
            aux[i] = this.elementos[i];
        }

        aux[aux.length - 1] = n;

        this.elementos = aux.clone();

        aux = null;
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

    public static Conjunto conjuntoPotencia(Conjunto c0, Conjunto c){
        boolean aux = true;

        if (c0.elementos.length == 0) {
            c0.inserir(c);
        }
        else{
            for (Object e : c0.elementos) {
                if (((Conjunto)e).subCon(c) && c.subCon((Conjunto)e)) {
                    aux = false;
                }
            }
            if (aux) {
                c0.inserir(c);
            }
        }

        for(int i = 0; i < c.elementos.length; i++){
            if (c.elementos.length > 0) {
                c0 = conjuntoPotencia(c0, Conjunto.dif(c, new Conjunto(new Object[]{c.elementos[i]})));
            }
        }

        return c0;
    }

    public static Conjunto cartesiano(Conjunto c1, Conjunto c2){
        Conjunto pc = new Conjunto();

        for (int i = 0; i < c1.elementos.length; i++){
            for(int j = 0; j < c2.elementos.length; j++){
                pc.inserir(Conjunto.uniao(
                                        new Conjunto(new Object[]{c1.elementos[i]}),
                                        new Conjunto(new Object[]{c2.elementos[j]})));
            }
        }

        return pc;
    }
}
