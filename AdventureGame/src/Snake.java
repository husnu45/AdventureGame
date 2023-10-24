import java.util.Random;

public class Snake extends Obstacle {


    public Snake() {
        super(4, "Snake", new Random().nextInt(3, 7), 12,0);


    }


}
