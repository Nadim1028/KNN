import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class ReadDataSet {
    String s;
    int index = 0;
    String[] arrOfString = new String[625 * 5];
    ArrayList<String>[] inputDataList = new ArrayList[625];
    ArrayList<Double>[] distance = new ArrayList[625];
    String[] arrOfStr;
    Scanner sc = new Scanner(System.in);
    double[] inputArr = new double[4],squareValueArr= new double[4],distanceForSort= new double[625];
    static Map<Double, Double> map = new HashMap<>();

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
        System.out.println("Enter four integer value.");
        for (int i = 0; i < 4; i++) {
            inputArr[i] = sc.nextInt();
        }

        for (int i = 0; i < inputDataList.length; i++) {
            if(inputDataList[i].get(0).equals("B"))
                distance[i].add((double) 1);

            else if(inputDataList[i].get(0).equals("R"))
                distance[i].add((double) 2);
            else if(inputDataList[i].get(0).equals("L"))
                distance[i].add((double) 3);

            distance[i].add(distanceWithDataSet(inputDataList[i],inputArr));
            distanceForSort[i]=distance[i].get(1);

           /* System.out.println(distance[i].get(0));
            System.out.println(distance[i].get(1));*/
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

    public void nearestNeighbourFinder(){
       Arrays.sort(distanceForSort);

        for(int i=0;i<distanceForSort.length;i++){
           System.out.println(distanceForSort[i]);
            System.out.println(distance[i]);
           distance[i].set(1,distanceForSort[i]);
           distance[i].set(0,distance[i].get(0));
        }

        System.out.println("New Sorted Array............................................................");

        for(int i=0;i<625;i++){
            System.out.println(distance[i]);
            //map.put(distance[i].get(0),distance[i].get(1));
        }




       /* System.out.println("Enter the value of k.");
        int k=sc.nextInt();
        for(int i=0;i<k;i++){
            System.out.println(distance[i]);
        }*/

        /*
        System.out.println(map);

        Map<Double, Double> hashMap = sortByValue((HashMap<Double, Double>) map);
        //HashMap<Double, Double> h1= sortByValue(map);
        for (Map.Entry<Double, Double> en : hashMap.entrySet()) {
            System.out.println("Key = " + en.getKey() +
                    ", Value = " + en.getValue());
        }*/



    }

    public static HashMap<Double, Double> sortByValue(HashMap<Double, Double> hm)
    {
        // Create a list from elements of HashMap
        List<Map.Entry<Double, Double> > list =
                new LinkedList<Map.Entry<Double, Double> >(hm.entrySet());

        // Sort the list
        Collections.sort(list, new Comparator<Map.Entry<Double, Double> >() {
            public int compare(Map.Entry<Double, Double> o1,
                               Map.Entry<Double, Double> o2)
            {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });

        // put data from sorted list to hashmap
        HashMap<Double, Double> temp = new LinkedHashMap<Double, Double>();
        for (Map.Entry<Double, Double> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
    }

}