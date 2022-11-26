package grids;
import java.util.ArrayList;
import java.util.function.Supplier;

public class Grid<T> {
    int szx=0;
    int szy=0;
    public ArrayList<T> data;
    public Grid(int x, int y, Supplier<T> sup){
       szx=x;
       szy=y;
        data=new ArrayList<>();
        for (int i = 0; i < x*y; i++) {
            data.add(sup.get());
        }
    }

    public int getSizeX(){
        return szx;
    }
    public int getSizeY(){
        return szy;
    }

    public T get(int x,int y){
        return data.get(y*szx+x);
    };
    public void set(int x,int y,T v){
        data.set(y*szx+x,v);
    }



}
