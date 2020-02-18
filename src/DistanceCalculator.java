import java.util.ArrayList;

public class DistanceCalculator extends ReadDataSet {
    DistanceClass[] distanceObject= new DistanceClass[625];

    public void distance()
    {
        for(int i=0;i<625;i++)
        {
            distanceObject[i] = new DistanceClass();
            //System.out.println(inputDataList[i].get(0));
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

    public double distanceWithDataSet(ArrayList<String> inputDataList, double[] inputArr)
    {
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
}
