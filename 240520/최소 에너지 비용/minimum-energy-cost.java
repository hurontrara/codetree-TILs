import java.io.*;
import java.util.*;

class Place implements Comparable<Place> {

    long x;
    int cost;

    Place(long x, int cost) {
        this.x = x;
        this.cost = cost;
    }

    @Override
    public int compareTo(Place place) {
        
        if (this.cost == place.cost)
            return (this.x - place.x) >= 0 ? 1 : -1;

        return this.cost - place.cost;


    }

}


public class Main {

    static int n;

    static long[] distanceArray;
    static int[] placeArray;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static List<Place> placeList = new ArrayList<>();


    public static void main(String[] args) throws Exception {

        n = Integer.parseInt(br.readLine());

        distanceArray = new long[n - 1]; placeArray = new int[n];

        st = new StringTokenizer(br.readLine());
    

        long distance = 0;
        for (int i = 0; i < n - 1; i++) {
            // 누적합으로
            distance += Integer.parseInt(st.nextToken());
            distanceArray[i] = distance;
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            placeArray[i] = Integer.parseInt(st.nextToken());
        }
        placeArray[n - 1] = 10000000;


        placeList.add(new Place(0, placeArray[0]));
        for (int i = 1; i < n; i++) {
            placeList.add(new Place(distanceArray[i - 1], placeArray[i]));
        }
        Collections.sort(placeList);

        long cost = 0;
        long dest = distanceArray[n - 2];
        for (Place place : placeList) {

            // 무조건 앞에 있음을 보장
            if (place.x >= dest) {
                continue;
            }

            cost += (long) place.cost * (long) (dest - place.x);

            dest = place.x;


        }

        System.out.print(cost);




    }


}


// long 타입 사용