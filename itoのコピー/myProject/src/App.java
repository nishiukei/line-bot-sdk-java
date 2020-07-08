import java.util.Scanner;
import java.util.Random;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
public class App {
    public static int number_players(String players[], int n){
        while( n != 6 ){
            System.out.print("参加者の名前を入力してください。("+ n +"人目。) > ");
            String scan = new Scanner(System.in).nextLine();
            if (scan.equals("end")){
                break;
            }else{
                int num = n - 1;
                players[num] = scan;
                n++;
                System.out.println(players[num]);
            }
        }
        System.out.println("このメンバーで始めます");
        for(int i = 0; i < n - 1; i++) {
            System.out.println(players[i]);
        }
        return n;
    }
    public static void set_answer(List<List<Integer>> answer, List<Integer> number, List<Integer> order, int n) {
        Collections.shuffle(number);
        for(int i = 0; i < n; i++) {
            if(i == 0) {
                List<Integer> answer0 = new ArrayList<>();
                answer0.add(number.get(0));
                answer.add(answer0);
                order.add(number.get(0));
            }else if(i == 1) {
                List<Integer> answer1 = new ArrayList<>();
                answer1.add(number.get(1));
                answer.add(answer1);
                order.add(number.get(1));

            }else if(i == 2) {
                List<Integer> answer2 = new ArrayList<>();
                answer2.add(number.get(2));
                answer.add(answer2);
                order.add(number.get(2));

            }else if(i == 3) {
                List<Integer> answer3 = new ArrayList<>();
                answer3.add(number.get(3));
                answer.add(answer3);
                order.add(number.get(3));

            }else if(i == 4) {
                List<Integer> answer4 = new ArrayList<>();
                answer4.add(number.get(4));
                answer.add(answer4);
                order.add(number.get(4));

            }
        }

    }
    
    public static void main(String[] args) {
    //初期値設定
        List<Integer> number = new ArrayList<>();
        for(int i = 1; i <= 99; i++) {
            number.add(i);
        }
        String[] players = new String[5];
        List<List<Integer>> answer = new ArrayList<>();
        List<Integer> order = new ArrayList<>();
        int miss = 0;
        int n = 1;
    //人数入力、配列に挿入
        System.out.println("注意：最大5人まで.打ち込んだら「end」で終了");
    //nは人数にプラス２した値になる
        n =  number_players(players, n) - 1;
    //数字割当
        set_answer(answer, number, order, n);
    //正解入力
        Collections.sort(order);
        System.out.println("数字の小さい順に数字を並べてください。");
        for(int i = 0; i < n; i++) {
            System.out.println(i +" : " + players[i]);
        }
        for(int i = 0; i < n; i++) {
            System.out.print(i+1 + "番小さい人 : ");
            Integer scan = new Scanner(System.in).nextInt();
            if(answer.get(scan).get(0) == order.get(i)) {
                miss++;
            }
        }
        System.out.println(miss + "回間違えました！");



        



    }

}

