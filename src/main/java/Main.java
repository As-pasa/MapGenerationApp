import NoiseGenerators.MyPerlinNoise;


import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    static public char DtoChar(double value){
        ArrayList<Character> gr= new ArrayList<>(Arrays.asList('.', '/', '*', '#', '@'));
        value=(value+1)/2;
        int z=(int)(Math.floor(value*gr.size()));
        if(z==gr.size()){
            z-=1;
        }
        return gr.get(z);
    }



    private void Gen(){

    }
    public static void main(String[] args) {
        ArrayList<Double> map=new ArrayList<>();
        int msize=50;
        for (int i = 0; i < msize*msize; i++) {
            map.add(0d);
        }
        int gradSize=4;
        MyPerlinNoise noise=new MyPerlinNoise()
                .setGradientGridSize(gradSize,gradSize)
                .setSeed(21)
                .setGridScale(50,50);


        for (int oct = 1; oct < 5; oct++) {
            for(int i =0;i<50;i++) {
                for(int j =0;j<50;j++) {
                    double a=noise.getNoiseInPoint(j,i);
                    map.set(j*msize+i,a/oct);
                }

            }
            gradSize/=2;
            noise.setGradientGridSize(gradSize,gradSize);
        }








    }
}
