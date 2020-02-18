import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class ReadDataSet
{
    String s;
    int index = 0,n=5,counter=0;
    int folderUnitSize=125,preLimit=0,postLimit=0;
    String[] arrOfString = new String[625 * 5];
    ArrayList<String>[] inputDataList = new ArrayList[625];
    ArrayList<Double>[] distance = new ArrayList[625];
    //ArrayList<ArrayList<String>> folder= new ArrayList<ArrayList<String>>(5);
    ArrayList<String>[] folder= new ArrayList[n];//= new ArrayList<ArrayList<String>>(5);
    ArrayList<ArrayList<String>> largeFolder= new ArrayList<ArrayList<String> >(n);
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
/*
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
        }*/

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

        for (int i = 0; i < n; i++) {
            folder[i] = new ArrayList<String>();
        }


        while(counter <=n)
        {
            postLimit = folderUnitSize * counter;
            for(int k=preLimit;k<postLimit;k++)
            {
                folder[counter].add(String.valueOf(inputDataList[k]));
            }

            preLimit =postLimit;
            counter++;
        }

        System.out.println(folder[0].size());
       /* System.out.println(folder.get(0).size());

        largeFolder.add(folder.get(0));

        int check=0;

        for(int i=0;i<largeFolder.size();i++)
        {
            for(int j=0;j<largeFolder.get(i).size();j++)
            {
                System.out.println(largeFolder.get(i).get(j));
                check++;
            }
            System.out.println();
        }

        System.out.println(check);*/
    }
}