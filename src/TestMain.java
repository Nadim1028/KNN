import java.io.FileNotFoundException;

public class TestMain {
    public static void main(String[] args) throws FileNotFoundException {
       NearestNeighbour n= new NearestNeighbour();
       n.getInput();
       n.fiveFolding();
       n.crossValidation();
    }
}
