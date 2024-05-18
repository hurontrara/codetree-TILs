import java.io.*;
import java.util.*;

class Node {

    int x;
    int y;

    Node prev = null;
    Node next = null;

    Node(int x, int y) {
        this.x = x;
        this.y = y;
    }


}


public class Main {

    static int n; // n개의 체크포인트

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static Node[] nodeArray;

    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {

        n = Integer.parseInt(br.readLine());
        nodeArray = new Node[n];

        Node leftNode = null;
        int totalCount = 0;
        for (int i = 0; i < n; i++) {

            st = new StringTokenizer(br.readLine());
            
            int x = Integer.parseInt(st.nextToken()); int y = Integer.parseInt(st.nextToken());

            Node presentNode = new Node(x, y);

            nodeArray[i] = presentNode;

            if (leftNode == null) {
                leftNode = presentNode;
                continue;
            }

            presentNode.prev = leftNode; leftNode.next = presentNode;

            totalCount += Math.abs(leftNode.x - presentNode.x) + Math.abs(leftNode.y - presentNode.y);

            leftNode = presentNode;

        }


        // logic
        for (int i = 1; i < n - 1; i++) {

            Node mid = nodeArray[i];
            Node left = mid.prev; Node right = mid.next;

            int left2mid = Math.abs(left.x - mid.x) + Math.abs(left.y - mid.y);
            int mid2right = Math.abs(mid.x - right.x) + Math.abs(mid.y - right.y);
            int left2right = Math.abs(left.x - right.x) + Math.abs(left.y - right.y);

            int localCount = totalCount - left2mid - mid2right + left2right;

            answer = Math.min(answer, localCount);


        }
        System.out.print(answer);




    }



}