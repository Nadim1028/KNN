import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class ReadDataSet
{
    String s;
    int index = 0,n=5,counter=1;
    int folderUnitSize=125,preLimit=0,postLimit=0;
    int[] previousIndexLimit= new int[5],postIndexLimit= new int[5];
    String[] arrOfString = new String[625 * 5];
    ArrayList<String>[] inputDataList = new ArrayList[625];
    ArrayList<Double>[] distance = new ArrayList[625];
    ArrayList<ArrayList<String>>[] folder= new ArrayList[n];
    ArrayList<String>[] largeFolder= new ArrayList[n];

    String[] arrOfStr;
    Scanner sc = new Scanner(System.in);
    double[] inputArr = new double[4],squareValueArr= new double[4],distanceForSort= new double[625];

    RandomClass[] randomObject=new RandomClass[625];


    public void getInput() throws FileNotFoundException
    {
        for (int i = 0; i < 625; i++)
        {
            inputDataList[i] = new ArrayList<String>();
            distance[i]= new ArrayList<Double>();
            randomObject[i]=new RandomClass();
        }

        File f = new File("data/balance-scale.data");
        Scanner input = new Scanner(f);
        while (input.hasNextLine())
        {
            s = input.nextLine();
            arrOfStr = s.split(",", 5);
            for (String a : arrOfStr) {
                inputDataList[index].add(a);
                //System.out.println(a);
            }

            randomObject[index].setValueArray(inputDataList[index]);

            index++;
        }

        Random rand = new Random();

        for (int i = 0; i < randomObject.length; i++)
        {
            int randomIndexToSwap = rand.nextInt(randomObject.length);
            RandomClass temp = randomObject[randomIndexToSwap];
            randomObject[randomIndexToSwap] = randomObject[i];
            randomObject[i] = temp;
        }

        for(int i=0;i<625;i++)
        {
            inputDataList[i]=randomObject[i].getValueArray();
        }

        for(int i=0;i<625;i++)
        {
           /* for(int j=0;j<5;j++){
                System.out.println(inputDataList[i].get(j));
            }*/
            //System.out.println(inputDataList[i].get(0));
        }

    }

    public void fiveFolding()
    {
        for(int i=0;i<n;i++){
            previousIndexLimit[i]=0;
            postIndexLimit[i]=0;
        }

        for (int i = 0; i < n; i++) {
            folder[i] = new ArrayList<>();
        }


        while(counter <=n)
        {
            postLimit = folderUnitSize * counter;
            for(int k=preLimit;k<postLimit;k++)
            {
                folder[counter-1].add(inputDataList[k]);
            }

            previousIndexLimit[counter-1]=preLimit;
            postIndexLimit[counter -1]=postLimit;
            preLimit =postLimit;
            counter++;
        }

    }
}