import java.util.Arrays;

public class NearestNeighbour extends DistanceCalculator{


    public void nearestNeighbourFinder()
    {
        Arrays.sort(distanceObject);
        double epsylon=0.1;
        int[] counter= new int[3];
        double[] weight= new double[3],finalWeight=new double[3];
        for(int i=0;i<counter.length;i++){
            counter[i]=0;
            weight[0]=0;
        }

        for(int i=0;i<555;i++) {
            // System.out.println(distanceObject[i].getType()+","+distanceObject[i].getDistance());
        }

        System.out.println("Enter the value of k.");
        int k=sc.nextInt();

        for(int i=0;i<k;i++){
            System.out.println(distanceObject[i].getType()+","+distanceObject[i].getDistance());
            if(distanceObject[i].getType().equals("B")){
                counter[0]++;
                weight[0] +=(1 / (distanceObject[i].getDistance() + epsylon));
            }

            else if(distanceObject[i].getType().equals("R")){
                counter[1]++;
                weight[1] +=(1 / (distanceObject[i].getDistance() + epsylon));
            }
            else if(distanceObject[i].getType().equals("L")){
                counter[2]++;
                weight[2] +=(1 / (distanceObject[i].getDistance() + epsylon));
            }
        }

        String s="BRL";
        int resultIndex=0;
        double maxWeight=-1;

        System.out.println("Weight of the groups:-");
        for(int i=0;i<counter.length;i++)
        {
            finalWeight[i]=weight[i]/counter[i];
            if(finalWeight[i]>maxWeight)
            {
                maxWeight=finalWeight[i];
                resultIndex=i;
            }

            System.out.println(finalWeight[i]);
        }

        System.out.println("Max Weight = "+maxWeight);
        System.out.println("The nearest neighbour of input is = "+s.charAt(resultIndex));
    }

}
