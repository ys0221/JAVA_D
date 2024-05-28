import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Comparator;

public class SubmaineClientWinnerGUI extends JFrame {
    private String First, Second, Third;
    private int first_score, second_score, third_score;
    private LineBorder line = new LineBorder(Color.black, 1, true);

    public SubmaineClientWinnerGUI() {
        setTitle("WINNER");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());
    }

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
        first_score = playerpoints.get(0);

        // 2등 지정
        if (playerpoints.get(1) == player1points) {
            Second = playernames.get(0);
        } else if (playerpoints.get(1) == player2points) {
            Second = playernames.get(1);
        } else {
            Second = playernames.get(2);
        }
        second_score = playerpoints.get(1);

        // 3등 지정
        if (playerpoints.get(2) == player1points) {
            Third = playernames.get(0);
        } else if (playerpoints.get(2) == player2points) {
            Third = playernames.get(1);
        } else {
            Third = playernames.get(2);
        }
        third_score = playerpoints.get(2);

        // 메인 패널을 생성하여 그곳에 패널을 추가하여 GUI를 구현한다.
        JPanel mainPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(20, 20, 20, 20);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // 제목 라벨
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 3;
        gbc.weightx = 1.0; // 가로로 확장
        JLabel titleLabel = new JLabel("WIN!", JLabel.CENTER);
        titleLabel.setFont(new Font("Serif", Font.BOLD, 24));
        mainPanel.add(titleLabel, gbc);

        // 플레이어 패널
        gbc.gridwidth = 1;
        gbc.gridy = 1;
        gbc.weightx = 0.5; // 가로로 확장한다.
        JPanel firstPanel = new JPanel(new GridLayout(0,1,10,10));
        mainPanel.add(firstPanel, gbc);
        firstPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
        firstPanel.setBackground(Color.YELLOW);

        gbc.gridy = 2;
        JPanel secondPanel = new JPanel(new GridLayout(0,1,10,10));
        mainPanel.add(secondPanel, gbc);
        secondPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
        secondPanel.setBackground(Color.WHITE);

        gbc.gridy = 3;
        JPanel thirdPanel = new JPanel(new GridLayout(0,1, 10,10));
        mainPanel.add(thirdPanel, gbc);
        thirdPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
        thirdPanel.setBackground(Color.WHITE);


        // 플레이어 정보 라벨
        JLabel firstLabel = new JLabel("1. " + First, JLabel.CENTER);
        firstLabel.setFont(new Font("Serif", Font.BOLD, 24));
        JLabel secondLabel = new JLabel("2. " + Second, JLabel.CENTER);
        secondLabel.setFont(new Font("Serif", Font.BOLD, 24));
        JLabel thirdLabel = new JLabel("3. " + Third, JLabel.CENTER);
        thirdLabel.setFont(new Font("Serif", Font.BOLD, 24));

        firstPanel.add(firstLabel);
        secondPanel.add(secondLabel);
        thirdPanel.add(thirdLabel);

        // 확인 버튼
        JButton submitButton = new JButton("확인");
        submitButton.setPreferredSize(new Dimension(100, 50));
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // SubmarineClientResult 객체 생성 및 결과 표시
                SubmarineClientResult resultGUI = new SubmarineClientResult();
                resultGUI.showResult(First, Second, Third, first_score, second_score, third_score);
                dispose(); // 등수 표시 창 닫기
            }
        });

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 3;
        mainPanel.add(submitButton, gbc);
        add(mainPanel);

        revalidate();
        repaint();

    }
    // 1, 2, 3등 플레이어의 이름을 반환하는 함수들
    public String getFirst() {
        return First;
    }

    public String getSecond() {
        return Second;
    }

    public String getThird() {
        return Third;
    }

    // 1, 2, 3등 플레이어의 점수를 반환하는 함수들
    public int getFirstScore() {
        return first_score;
    }

    public int getSecondScore() {
        return second_score;
    }

    public int getThirdScore() {
        return third_score;
    }
}