import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class SubmarineClientPractice {
    // player1, 2, 3의 스코어를 비교한다 -> if 문 사용 X
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        ArrayList<String> playernames = new ArrayList<>();
        ArrayList<Integer> playerpoints = new ArrayList<>();
        ArrayList<Integer> playerWinRate = new ArrayList<>();

        System.out.println("플레이어 3명 이름 입력");
        for (int i = 0; i < 3; i++) {
            String player = scan.nextLine();
            playernames.add(player);
        }

        System.out.println("플레이어 3명 점수 입력");
        for (int i = 0; i < 3; i++) {
            Integer points = scan.nextInt();
            playerpoints.add(points);
        }

        System.out.println("플레이어 3명 승률 입력");
        for (int i = 0; i < 3; i++) {
            Integer winRate = scan.nextInt();
            playerWinRate.add(winRate);
        }


        SubmaineClientWinnerGUI submaineClientWinnerGUI = new SubmaineClientWinnerGUI();
        submaineClientWinnerGUI.setVisible(true);

        SubmarineClientLoserGUI submarineClientLoserGUI = new SubmarineClientLoserGUI();
        submarineClientLoserGUI.setVisible(true);

        submaineClientWinnerGUI.getRank(playernames,playerpoints,playerWinRate);
        submaineClientWinnerGUI.setVisible(true);

        submarineClientLoserGUI.getRank(playernames,playerpoints,playerWinRate);
        submarineClientLoserGUI.setVisible(true);


        String firstName = submaineClientWinnerGUI.getFirst();
        String secondName = submaineClientWinnerGUI.getSecond();
        String thirdName = submaineClientWinnerGUI.getThird();

        int firstScore = submaineClientWinnerGUI.getFirstScore();
        int secondScore = submaineClientWinnerGUI.getSecondScore();
        int thirdScore = submaineClientWinnerGUI.getThirdScore();

        int firstWinRate = submaineClientWinnerGUI.getFirstScore();
        int secondWinRate = submaineClientWinnerGUI.getSecondScore();
        int thirdWinRate = submaineClientWinnerGUI.getThirdScore();

    }
}


