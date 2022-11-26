package RandomNumbers;

import vectors.Vector2Df;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class RandomVectorGenerator {
    private static final ArrayList<Vector2Df> samples=new ArrayList<>(Arrays.asList(
            new Vector2Df(1,1),
            new Vector2Df(1,-1),
            new Vector2Df(-1,1),
            new Vector2Df(-1,-1),
            new Vector2Df(0,Math.sqrt(2)),
            new Vector2Df(Math.sqrt(2),0),
            new Vector2Df(0,-Math.sqrt(2)),
            new Vector2Df(-Math.sqrt(2),0)));
    public static Vector2Df getRandomVector(Random r){
        return samples.get(r.nextInt(samples.size()));
    }

}
