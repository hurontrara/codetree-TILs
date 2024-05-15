import java.io.*;
import java.util.*;

class Node {

    int num;
    Node prev = null;
    Node next = null;

    Node(int num) {
        this.num = num;
    }

}

public class Main {

    static int nodeNum, qNum;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static HashMap<Integer, Node> hashMap = new HashMap<>();

    public static void main(String[] args) throws Exception {

        nodeNum = Integer.parseInt(br.readLine()); qNum = Integer.parseInt(br.readLine());

        Node leftNode = new Node(0); hashMap.put(0, leftNode);
        for (int i = 1; i <= nodeNum + 1; i++) {

            Node presentNode = new Node(i);
            hashMap.put(i, presentNode);

            leftNode.next = presentNode;
            presentNode.prev = leftNode;

            leftNode = presentNode;

        }

        int a, b, c, d;
        Node aNode, bNode, cNode, dNode, firstTotem, secondTotem;
        for (int i = 0; i < qNum; i++) {

            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken()); b = Integer.parseInt(st.nextToken()); c = Integer.parseInt(st.nextToken()); d = Integer.parseInt(st.nextToken());
            a = Math.min(a, c); b = Math.min(b, d); c = Math.max(a, c); d = Math.max(b, d);

            // a = 2 b = 3 c = 5 b = 6
            aNode = hashMap.get(a); bNode = hashMap.get(b); cNode = hashMap.get(c); dNode = hashMap.get(d);
            firstTotem = aNode.prev; secondTotem = dNode.next;

            // 첫번째 배열 삭제
            aNode.prev.next = bNode.next;
            bNode.next.prev = aNode.prev;
            aNode.prev = null; bNode.next = null;

            // 두번째 배열 삭제
            cNode.prev.next = dNode.next;
            dNode.next.prev = cNode.prev;
            cNode.prev = null; dNode.next = null;

            // 첫번째 배열 삽입
            cNode.prev = firstTotem; dNode.next = firstTotem.next;
            dNode.next.prev = dNode; cNode.prev.next = cNode;

            // 두번째 배열 삽입
            aNode.prev = secondTotem.prev; bNode.next = secondTotem;
            aNode.prev.next = aNode;
            bNode.next.prev = bNode;



        }

        Node node = hashMap.get(0);
        while (true) {

            Node rightnode = node.next;

            if (rightnode.num == nodeNum + 1)
                break;

            sb.append(rightnode.num).append(" ");
            node = rightnode;


        }


        System.out.print(sb);


    }



}