package NoiseGenerators;

import RandomNumbers.RandomVectorGenerator;
import grids.Grid;
import vectors.Vector2Df;
import java.util.Random;

public class MyPerlinNoise {
    private Grid<Vector2Df> gradients;
    private double gridSizeX;
    private double gridSizeY;
    private Random rand;

    public MyPerlinNoise(){
        gradients=new Grid<>(0,0,()-> new Vector2Df(0,0));
        gridSizeX=gridSizeY=0;
        rand=new Random();

    }
    public MyPerlinNoise setGradientGridSize(int width,int height){
        gradients=new Grid<Vector2Df>(width,height,()-> new Vector2Df(0,0));
        return this;
    }
    public MyPerlinNoise setSeed(long seed){
        rand=new Random(seed);
        for (int i = 0; i < gradients.getSizeY(); i++) {
            for (int j = 0; j < gradients.getSizeX(); j++) {
                Vector2Df a=RandomVectorGenerator.getRandomVector(rand);
                System.out.println(a);
                gradients.set(j,i,a);
            }
        }
        return this;
    }
    public MyPerlinNoise setGridScale(double width,double height){
        gridSizeX=width;
        gridSizeY=height;
        return this;
    }
    private double fading(double t){
        return t*t*t*(6*t*t-15*t+10);

    }
    public double getNoiseInPoint(double x,double y){
        x/=gridSizeX;
        y/=gridSizeY;
        int topLeftX=(int)Math.floor((x*gradients.getSizeX())% gradients.getSizeX());
        int topLeftY=(int)Math.floor((y*gradients.getSizeY())% gradients.getSizeY());

        double localX=x*gradients.getSizeX()-(double)topLeftX;
        double localY=y*gradients.getSizeY() -(double)topLeftY;

        Vector2Df topLeftGradient=gradients.get(topLeftX,topLeftY);
        Vector2Df topLeftVectorToPoint=new Vector2Df(localX,localY);
        double topLeftDot=Vector2Df.dot(topLeftVectorToPoint,topLeftGradient);

        Vector2Df topRightGradient=gradients.get((topLeftX+1)%gradients.getSizeX(),topLeftY);
        Vector2Df topRightVectorToPoint=new Vector2Df(1-localX,localY);
        double topRightDot=Vector2Df.dot(topRightGradient,topRightVectorToPoint);

        Vector2Df downLeftGradient=gradients.get(topLeftX,(topLeftY+1)%gradients.getSizeY() );
        Vector2Df downLeftVectorToPoint=new Vector2Df(localX,1-localY);
        double downLeftDot=Vector2Df.dot(downLeftGradient,downLeftVectorToPoint);

        Vector2Df downRightGradient=gradients.get((topLeftX+1)%gradients.getSizeX(),(topLeftY+1)%gradients.getSizeY());
        Vector2Df downRightVectorToPoint=new Vector2Df(1-localX,1-localY);
        double downRightDot=Vector2Df.dot(downRightGradient,downRightVectorToPoint);
        //System.out.println(String.format("%d:%d",gridX,gridY));




        double lerpedTop=lerp(topLeftDot,topRightDot,localX);
        double lerpedDown=lerp(downLeftDot,downRightDot,localX);
        return lerp(lerpedTop,lerpedDown,localY);
    }
    private double lerp(double start,double end,double t){
        return start*(1-fading(t))+end*fading(t);
    }




}
