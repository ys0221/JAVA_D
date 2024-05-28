import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Comparator;

public class SubmarineClientLoserGUI extends JFrame {
    private String First, Second, Third;
    private int firstScore, secondScore, thirdScore;
    private LineBorder line = new LineBorder(Color.black, 1, true);

    public SubmarineClientLoserGUI() {
        setTitle("Loser");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());
    }

    // 생성자
    public void getRank(ArrayList<String> playernames, ArrayList<Integer> playerpoints) {
        int player1points = playerpoints.get(0);
        int player2points = playerpoints.get(1);
        int player3points = playerpoints.get(2);
        playerpoints.sort(Comparator.reverseOrder());

        // 1등 지정
        if (playerpoints.get(0) == player1points) {
            First = playernames.get(0);
        } else if (playerpoints.get(0) == player2points) {
            First = playernames.get(1);
        } else {
            First = playernames.get(2);
        }
        firstScore = playerpoints.get(0);

        // 2등 지정
        if (playerpoints.get(1) == player1points) {
            Second = playernames.get(0);
        } else if (playerpoints.get(1) == player2points) {
            Second = playernames.get(1);
        } else {
            Second = playernames.get(2);
        }
        secondScore = playerpoints.get(1);

        // 3등 지정
        if (playerpoints.get(2) == player1points) {
            Third = playernames.get(0);
        } else if (playerpoints.get(2) == player2points) {
            Third = playernames.get(1);
        } else {
            Third = playernames.get(2);
        }
        thirdScore = playerpoints.get(2);

        JPanel firstPanel = new JPanel();
        JPanel secondPanel = new JPanel();
        JPanel thirdPanel = new JPanel();
        add(firstPanel);
        add(secondPanel);
        add(thirdPanel);

        JTextField firstField = new JTextField("1. " + First, 20);
        firstField.setBackground(Color.YELLOW);
        JTextField secondField = new JTextField("2. " + Second, 20);
        secondField.setBackground(Color.WHITE);
        JTextField thirdField = new JTextField("3. " + Third, 20);
        thirdField.setBackground(Color.WHITE);

        firstPanel.add(firstField);
        secondPanel.add(secondField);
        thirdPanel.add(thirdField);

        JButton submitButton = new JButton("확인");
        submitButton.setPreferredSize(new Dimension(100, 50));
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // SubmarineClientResult 객체 생성 및 결과 표시
                SubmarineClientResult resultGUI = new SubmarineClientResult();
                resultGUI.showResult(First, Second, Third, firstScore, secondScore, thirdScore);
            }
        });

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridy = 0;
        add(firstPanel, gbc);
        gbc.gridy = 1;
        add(secondPanel, gbc);
        gbc.gridy = 2;
        add(thirdPanel, gbc);
        gbc.gridy = 3;
        add(submitButton, gbc);

        revalidate();
        repaint();

        System.out.println("1등은 " + First);
        System.out.println("2등은 " + Second);
        System.out.println("3등은 " + Third);
    }

    public String getFirst() {
        return First;
    }

    public String getSecond() {
        return Second;
    }

    public String getThird() {
        return Third;
    }

    public int getFirstScore() {
        return firstScore;
    }

    public int getSecondScore() {
        return secondScore;
    }

    public int getThirdScore() {
        return thirdScore;
    }
}