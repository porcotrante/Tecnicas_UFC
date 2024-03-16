class Ponto {
    private int x,y,z;

    public void setXY(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }

    public void setXYZ(int x, int y, int z){
        this.setXY(x,y);
        this.z = z;
    }

    public int getZ(){
        return this.z;
    }

    Ponto(int x, int y){
        this.setX(x);
        this.setY(y);
    }

    Ponto(int x, int y, int z){
        this(x,y);
        setZ(z);
    }
}