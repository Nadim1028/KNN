public class DistanceClass implements Comparable<DistanceClass>
{
    String type;
    double distance;
    public void setValue(String a,double d){
        type=a;
        distance=d;
    }

    public String getType() {
        return type;
    }

    public double getDistance() {
        return distance;
    }

    @Override
    public int compareTo(DistanceClass distanceClass) {
        return (distanceClass.getDistance() - this.getDistance()) > 0 ? -1:1;
    }
}
