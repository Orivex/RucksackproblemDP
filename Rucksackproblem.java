package Facharbeit;

import java.util.Scanner;

public class Rucksackproblem {
    public static void main(String[] args) {

        Rucksackproblem rucksackproblem = new Rucksackproblem();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Anzahl Gegenstaende angeben:");
        int anzahl = scanner.nextInt();

        int[] gewichte = new int[anzahl];
        for (int i = 0; i < anzahl; i++) {
            System.out.println("Gewicht von Gegenstand " + (i+1) +":");
            gewichte[i] = scanner.nextInt();
        }

        int[] werte = new int[anzahl];
        for (int i = 0; i < anzahl; i++) {
            System.out.println("Wert von Gegenstand " + (i+1) +":");
            werte[i] = scanner.nextInt();
        }

        System.out.println("Tragkraft des Rucksacks angeben:");
        int tragkraft = scanner.nextInt();

        int ergebnis = rucksackproblem.rucksackproblem_dp(anzahl, gewichte, werte, tragkraft);

        System.out.println("Maximaler Profit: " + ergebnis);
    }

    int rucksackproblem_dp(int anzahl, int[] gewichte, int[] werte, int tragkraft) {
        int[][] dp = new int[anzahl][tragkraft+1];

        for (int i = 0; i < tragkraft+1; i++) {
            if(i >= gewichte[0])
                dp[0][i] = werte[0];
        }

        for (int i = 1; i < anzahl; i++) {
            for (int j = 0; j < tragkraft+1; j++) {

                if(j-gewichte[i] >= 0)
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-gewichte[i]]+werte[i]);
                else
                    dp[i][j] = dp[i-1][j];
            }
        }
        
        return dp[anzahl-1][tragkraft];
    }
}
