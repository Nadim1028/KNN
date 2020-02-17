import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class ReadDataSet{
    String s;
    int index = 0;
    String[] arrOfString = new String[625 * 5];
    ArrayList<String>[] inputDataList = new ArrayList[625];
    ArrayList<Double>[] distance = new ArrayList[625];
    String[] arrOfStr;
    Scanner sc = new Scanner(System.in);
    double[] inputArr = new double[4],squareValueArr= new double[4],distanceForSort= new double[625];
    DistanceClass[] distanceObject= new DistanceClass[625];


    public void getInput() throws FileNotFoundException
    {
        for (int i = 0; i < 625; i++) {
            inputDataList[i] = new ArrayList<String>();
            distance[i]= new ArrayList<Double>();
        }

        File f = new File("data/balance-scale.data");
        Scanner input = new Scanner(f);
        while (input.hasNextLine()) {
            // System.out.println(input.nextLine());
            s = input.nextLine();

            arrOfStr = s.split(",", 5);

            for (String a : arrOfStr) {
                inputDataList[index].add(a);
                //System.out.println(a);
            }

            index++;
        }
    }

    public void distance()
    {


        for(int i=0;i<625;i++) {
            distanceObject[i] = new DistanceClass();
        }

        System.out.println("Enter four integer value.");
        for (int i = 0; i < 4; i++) {
            inputArr[i] = sc.nextInt();
        }


        for (int i = 0; i < inputDataList.length; i++)
        {
            if(inputDataList[i].get(0).equals("B")){
                double d=distanceWithDataSet(inputDataList[i],inputArr);
                distanceObject[i].setValue("B",d);
            }

            else if(inputDataList[i].get(0).equals("R")){
                double d=distanceWithDataSet(inputDataList[i],inputArr);
                distanceObject[i].setValue("R",d);
            }

            else if(inputDataList[i].get(0).equals("L")){
                double d=distanceWithDataSet(inputDataList[i],inputArr);
                distanceObject[i].setValue("L",d);
            }

        }

        for(int i=0;i<555;i++) {
        //    System.out.println(distanceObject[i].getType()+","+distanceObject[i].getDistance());
        }
    }

    public double distanceWithDataSet(ArrayList<String> inputDataList, double[] inputArr){

        //= Math.sqrt(squareOfValue(inputDataList, inputArr));
        double d;
        for(int j=1;j<inputDataList.size();j++){
            squareValueArr[j-1] =  Double.parseDouble(inputDataList.get(j));
        }

        d=distanceCalculator(squareValueArr,inputArr);
        return d;
    }

    private double distanceCalculator(double[] squareValueArr, double[] inputArr) {
        double dist= Math.sqrt((squareValueArr[0]-inputArr[0])*(squareValueArr[0]-inputArr[0]) +
                                    (squareValueArr[1]-inputArr[1])*(squareValueArr[1]-inputArr[1]) +
                                    (squareValueArr[2]-inputArr[2])*(squareValueArr[2]-inputArr[2])+
                                     (squareValueArr[3]-inputArr[3])*(squareValueArr[3]-inputArr[3]));

        return dist;
    }

    public void nearestNeighbourFinder()
    {
        Arrays.sort(distanceObject);
        double epsylon=0.00001;
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

        for(int i=0;i<counter.length;i++){
           finalWeight[i]=weight[i]/counter[i];
           if(finalWeight[i]>maxWeight)
           {
               maxWeight=finalWeight[i];
               resultIndex=i;
           }

            System.out.println(counter[i]+","+finalWeight[i]);
        }

        System.out.println("Max Weight = "+maxWeight);
        System.out.println("The nearest neighbour of input is = "+s.charAt(resultIndex));

    }

}