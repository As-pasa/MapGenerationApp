package vectors;

public class Vector2Df {
    public double x;
    public double y;
    public Vector2Df(double x,double y){
        this.x=x;
        this.y=y;
    }
    public Vector2Df(int x,int y){
        this.x=(double)x;
        this.y=(double)y;
    }
    public static Vector2Df addSt(Vector2Df v1,Vector2Df v2){
        return new Vector2Df(v1.x+v2.x,v1.y+v2.y);
    }
    public static Vector2Df subSt(Vector2Df v1,Vector2Df v2){
        return new Vector2Df(v1.x-v2.x,v1.y-v2.y);
    }
    public static double dot(Vector2Df v1,Vector2Df v2){
        return v1.x*v2.x+v1.y*v2.y;
    }
    public void normalize(){
        double fr=magnitude();
        this.x=x/fr;
        this.y=y/fr;
    }
    public String toString(){
        return String.format("x %f | y %f",x,y);
    }
    public double magnitude(){
        return Math.sqrt(this.x*this.x+this.y*this.y);
    }
}
