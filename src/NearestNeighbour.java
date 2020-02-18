import java.util.Arrays;

public class NearestNeighbour extends DistanceCalculator
{
    int[] accuracy=new int[5];
    int finalAccuracy=0;

    public void crossValidation()
    {
        for(int i=0;i<n;i++){
            accuracy[i]=distance(folder[i],inputDataList,i);
            finalAccuracy +=accuracy[i];
        }

        finalAccuracy=finalAccuracy*100/625;

        System.out.println("Final accuracy = "+finalAccuracy+"%");

    }


}
