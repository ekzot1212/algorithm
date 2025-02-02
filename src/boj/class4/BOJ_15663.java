package boj.class4;
/*
Silver II
N개의 자연수와 자연수 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.

N개의 자연수 중에서 M개를 고른 수열
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_15663 {

    static int N,M;
    static int[] arr;
    static int[] tmp;
    static boolean[] check;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        check = new boolean[N];
        tmp = new int[M];
        st = new StringTokenizer(br.readLine());

        for(int i=0; i<N ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        find(0);
        System.out.println(sb);
    }

    static void find(int depth) {
        if(depth == M){
            for(int i : tmp){
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }
        for(int i=0 ; i<N ; i++){
            if (i > 0 && arr[i] == arr[i-1] && !check[i-1]) {
                continue;
            }
            if( !check[i]){
                check[i] = true;
                tmp[depth] = arr[i];
                find(depth+1);
                check[i] = false;
            }
        }
    }
}