import java.util.ArrayList;
import java.util.Arrays;

public class DistanceCalculator extends ReadDataSet
{
    DistanceClass[] distanceObject= new DistanceClass[500];
    int dObjectCounter,checker=0,k=10;
    int[] folderOfAccuracyCounter=new int[125];


    public int distance(ArrayList<ArrayList<String>> folder, ArrayList<String>[] inputDataList, int folderNumber)
    {
        int sumOfFolderAccuracy=0;
        for(int i=0;i<500;i++)
        {
            distanceObject[i] = new DistanceClass();
            //System.out.println(inputDataList[i].get(0));
        }




        for(int j=0;j<folder.size();j++)
        {
            dObjectCounter=0;
           // System.out.println(folder.get(j));
            for(int i=0; i<inputDataList.length;i++)
            {


                if(i<previousIndexLimit[folderNumber] || i>=postIndexLimit[folderNumber])
                {
                    //System.out.println(inputDataList[i]);


                    if(this.inputDataList[i].get(0).equals("B"))
                    {
                        double d=distanceWithDataSet(this.inputDataList[i], folder.get(j));

                        distanceObject[dObjectCounter++].setValue("B",d);
                        //System.out.println(distanceObject[i].getType()+","+distanceObject[i].getDistance());
                    }

                    else if(this.inputDataList[i].get(0).equals("R"))
                    {
                        double d=distanceWithDataSet(this.inputDataList[i], folder.get(j));
                        distanceObject[dObjectCounter++].setValue("R",d);

                    }

                    else if(this.inputDataList[i].get(0).equals("L")){
                        double d=distanceWithDataSet(this.inputDataList[i],folder.get(j));
                        distanceObject[dObjectCounter++].setValue("L",d);
                    }
                }
            }
           // System.out.println(distanceObject[j].getType());
            for(int i=0;i<500;i++) {
                //System.out.println(distanceObject[i].getType()+","+distanceObject[i].getDistance());
            }
           // System.out.println(distanceObject[13].getType()+","+distanceObject[13].getDistance());
            folderOfAccuracyCounter[j]=nearestNeighbourFinder(distanceObject,folder.get(j));
            //System.out.println(folderOfAccuracyCounter[j]);
        }


        for(int i=0;i<125;i++) {
            if(folderOfAccuracyCounter[i]==1){
                sumOfFolderAccuracy++;
            }

        }

        return sumOfFolderAccuracy;

    }

    public double distanceWithDataSet(ArrayList<String> trainData, ArrayList<String> inputLine)
    {
        double d;
        for(int j=1;j<trainData.size();j++){
            squareValueArr[j-1] =  Double.parseDouble(trainData.get(j));
            inputArr[j-1] = Double.parseDouble(inputLine.get(j));
           // System.out.println(inputArr[j-1]);
          // System.out.println(squareValueArr[j-1]);
        }

        d=distanceCalculator(squareValueArr,inputArr);
        return d;
    }

    private double distanceCalculator(double[] squareValueArr, double[] inputArr)
    {
        double dist= Math.sqrt((squareValueArr[0]-inputArr[0])*(squareValueArr[0]-inputArr[0]) +
                (squareValueArr[1]-inputArr[1])*(squareValueArr[1]-inputArr[1]) +
                (squareValueArr[2]-inputArr[2])*(squareValueArr[2]-inputArr[2])+
                (squareValueArr[3]-inputArr[3])*(squareValueArr[3]-inputArr[3]));
       // System.out.println(dist);

        return dist;
    }


    public int nearestNeighbourFinder(DistanceClass[] distanceObject, ArrayList<String> strings)
    {
        double epsylon=0.001;
        int[] counter= new int[3];
        double[] weight= new double[3],finalWeight=new double[3];
        for(int i=0;i<counter.length;i++){
            counter[i]=0;
            weight[0]=0;
        }


        Arrays.sort(distanceObject);



        for(int i=0;i<500;i++) {
            // System.out.println(distanceObject[i].getType()+","+distanceObject[i].getDistance());
        }


        for(int i=0;i<k;i++)
        {
           // System.out.println(this.distanceObject[i].getType()+","+ this.distanceObject[i].getDistance());
            if(this.distanceObject[i].getType().equals("B")){
                counter[0]++;
                weight[0] +=(1 / (this.distanceObject[i].getDistance() + epsylon));
            }

            else if(this.distanceObject[i].getType().equals("R")){
                counter[1]++;
                weight[1] +=(1 / (this.distanceObject[i].getDistance() + epsylon));
            }
            else if(this.distanceObject[i].getType().equals("L")){
                counter[2]++;
                weight[2] +=(1 / (this.distanceObject[i].getDistance() + epsylon));
            }
        }

        String s="BRL";
        int resultIndex=0;
        double maxWeight=-1;

        for(int i=0;i<counter.length;i++)
        {
            finalWeight[i]=weight[i]/counter[i];
            if(finalWeight[i]>maxWeight)
            {
                maxWeight=finalWeight[i];
                resultIndex=i;
            }

            //System.out.println(finalWeight[i]);
        }

        //System.out.println("Max Weight = "+maxWeight);
        int trueResult=0;

        String string= String.valueOf(s.charAt(resultIndex));

        if(strings.get(0).equals(string)){
            System.out.println(strings.get(0)+","+string);
            trueResult=1;
        }

        return trueResult;
    }

}


