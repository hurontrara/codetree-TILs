import java.io.*;
import java.util.*;

class Person {

    int num;
    Person prev = null;
    Person next = null;

    Person(int num) {
        this.num = num;
    }

}



public class Main {

    static int n, m, q; // 학생의 수 n, 처음 원 수 m, 동작 횟수 q

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static HashMap<Integer, Person> hashMap = new HashMap<>();

    public static void main(String[] args) throws Exception {

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); m = Integer.parseInt(st.nextToken()); q = Integer.parseInt(st.nextToken());

        for (int i = 0; i < m; i++) {

            st = new StringTokenizer(br.readLine());
            int personNum = Integer.parseInt(st.nextToken());

            Person firstPerson = new Person(Integer.parseInt(st.nextToken()));
            hashMap.put(firstPerson.num, firstPerson);


            Person leftPerson = firstPerson;
            for (int j = 1; j < personNum; j++) {

                Person presentPerson = new Person(Integer.parseInt(st.nextToken()));

                presentPerson.prev = leftPerson; leftPerson.next = presentPerson;

                hashMap.put(presentPerson.num, presentPerson);

                leftPerson = presentPerson;

            }
            firstPerson.prev = leftPerson; leftPerson.next = firstPerson;

        }

        for (int i = 0; i < q; i++) {

            st = new StringTokenizer(br.readLine());
            int order = Integer.parseInt(st.nextToken());

            if (order == 1) {
                int a = Integer.parseInt(st.nextToken()); int b = Integer.parseInt(st.nextToken());

                Person aPerson = hashMap.get(a); Person bPerson = hashMap.get(b);
                Person cPerson = aPerson.next; Person dPerson = bPerson.prev;

                aPerson.next = bPerson; bPerson.prev = aPerson;
                cPerson.prev = dPerson; dPerson.next = cPerson;


            }
            else if (order == 2) {

                int a = Integer.parseInt(st.nextToken()); int b = Integer.parseInt(st.nextToken());

                Person aPerson = hashMap.get(a); Person bPerson = hashMap.get(b).prev;
                Person cPerson = aPerson.prev; Person dPerson = bPerson.next;

                cPerson.next = dPerson; dPerson.prev = cPerson;
                aPerson.prev = bPerson; bPerson.next = aPerson;


            }
            else {

                int a = Integer.parseInt(st.nextToken());
                Person aPerson = hashMap.get(a);

                Person nextPerson = aPerson;
                int cnt = aPerson.num;
                while (true) {

                    nextPerson = nextPerson.next;

                    if (nextPerson == aPerson)
                        break;
                    
                    cnt = Math.min(cnt, nextPerson.num);

                }

                Person printPerson = hashMap.get(cnt);
                while (true) {

                    sb.append(printPerson.num).append(" ");

                    printPerson = printPerson.prev;

                    if (printPerson.num == cnt)
                        break;

                }



            }


        }

        System.out.print(sb);



    }




}