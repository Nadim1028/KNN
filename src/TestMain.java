import java.io.FileNotFoundException;

public class TestMain {
    public static void main(String[] args) throws FileNotFoundException {
        ReadDataSet r = new ReadDataSet();
        r.getInput();
        r.distance();
        r.nearestNeighbourFinder();

    }
}
