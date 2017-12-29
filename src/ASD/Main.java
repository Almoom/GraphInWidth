package ASD;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

    private int n;
    private int m;
    private ArrayList adj[];
    private boolean used[];

    private BufferedReader cin;
    private PrintWriter cout;
    private StringTokenizer tokenizer;


    private void dfs(int v) {

        if (used[v]) {
            return;
        }
        used[v] = true;
        cout.print((v + 1) + " ");

        for (int i = 0; i < adj[v].size(); ++i) {
            int w = adj[v].get(i);
            dfs(w);
        }
    }

    private void readData() throws IOException {
        cin = new BufferedReader(new InputStreamReader(System.in));
        cout = new PrintWriter(System.out);
        tokenizer = new StringTokenizer(cin.readLine());
        n = Integer.parseInt(tokenizer.nextToken());
        m = Integer.parseInt(tokenizer.nextToken());
        adj = new ArrayList[n];
        for (int i = 0; i < n; ++i) {
            adj[i] = new ArrayList();
        }

        for (int i = 0; i < m; ++i) {
            tokenizer = new StringTokenizer(cin.readLine());
            int v = Integer.parseInt(tokenizer.nextToken());
            int w = Integer.parseInt(tokenizer.nextToken());
            v--;
            w--;
            adj[v].add(w);
            adj[w].add(v);
        }

        used = new boolean[n];
        Arrays.fill(used, false);
    }

    private void run() throws IOException {
        readData();
        for (int v = 0; v < n; ++v) {
            dfs(v);
        }
        cin.close();
        cout.close();
    }

    public static void main(String[] args) throws IOException {
        Solution solution = new Solution();
        solution.run();
    }
}




