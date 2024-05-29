import javax.print.attribute.HashPrintRequestAttributeSet;
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
    private int first_winRate, second_winRate, third_winRate;
    private LineBorder line = new LineBorder(Color.black, 1, true);

    public SubmaineClientWinnerGUI() {
        setTitle("WINNER");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());
    }

    public void getRank(ArrayList<String> playernames, ArrayList<Integer> playerpoints, ArrayList<Integer> playerWinRate) {
        // 원본 데이터의 영햐을 받지 않기 위해 데이터를 복사한다
        ArrayList<String> namesCopy = new ArrayList<>(playernames);
        ArrayList<Integer> pointsCopy = new ArrayList<>(playerpoints);
        ArrayList<Integer> ratesCopy = new ArrayList<>(playerWinRate);


        int player1points = pointsCopy.get(0);
        int player2points = pointsCopy.get(1);
        int player3points = pointsCopy.get(2);
        pointsCopy.sort(Comparator.reverseOrder());

        // 1등 지정
        if (pointsCopy.get(0) == player1points) {
            First = namesCopy.get(0);
            first_winRate = ratesCopy.get(0);
        } else if (pointsCopy.get(0) == player2points) {
            First = namesCopy.get(1);
            first_winRate = ratesCopy.get(1);
        } else {
            First = namesCopy.get(2);
            first_winRate = ratesCopy.get(2);
        }
        first_score = pointsCopy.get(0);

        // 2등 지정
        if (pointsCopy.get(1) == player1points) {
            Second = namesCopy.get(0);
            second_winRate = ratesCopy.get(0);
        } else if (pointsCopy.get(1) == player2points) {
            Second = namesCopy.get(1);
            second_winRate = ratesCopy.get(1);
        } else {
            Second = namesCopy.get(2);
            second_winRate = ratesCopy.get(2);
        }
        second_score = pointsCopy.get(1);

        // 3등 지정
        if (pointsCopy.get(2) == player1points) {
            Third = namesCopy.get(0);
            third_winRate = ratesCopy.get(0);
        } else if (pointsCopy.get(2) == player2points) {
            Third = namesCopy.get(1);
            third_winRate = ratesCopy.get(1);
        } else {
            Third = namesCopy.get(2);
            third_winRate = ratesCopy.get(2);
        }
        third_score = pointsCopy.get(2);

        // 메인 패널을 생성하여 그곳에 패널을 추가하여 GUI를 구현한다.
        JPanel mainPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.BOTH;

        // 제목 라벨
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 3;
        gbc.weightx = 1.0; // 가로로 확장
        gbc.weighty = 0.1; // 적당한 세로 확장 비율 설정
        JLabel titleLabel = new JLabel("WIN!", JLabel.CENTER);
        titleLabel.setFont(new Font("Serif", Font.BOLD, 24));
        mainPanel.add(titleLabel, gbc);

        // 플레이어 패널
        gbc.gridy = 1;
        gbc.weightx = 1.0; // 가로로 확장한다.
        gbc.fill = GridBagConstraints.BOTH; // 가로와 세로 모두 확장한다
        JPanel firstPanel = new JPanel(new GridLayout(1, 1));
        mainPanel.add(firstPanel, gbc);
        firstPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
        firstPanel.setBackground(Color.YELLOW);

        gbc.gridy = 2;
        JPanel secondPanel = new JPanel(new GridLayout(1, 1));
        mainPanel.add(secondPanel, gbc);
        secondPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
        secondPanel.setBackground(Color.WHITE);

        gbc.gridy = 3;
        JPanel thirdPanel = new JPanel(new GridLayout(1,1));
        mainPanel.add(thirdPanel, gbc);
        thirdPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
        thirdPanel.setBackground(Color.WHITE);

        /*
        // 플레이어 정보 라벨
        JLabel firstLabel = new JLabel("1. " + First, JLabel.CENTER);
        JLabel secondLabel = new JLabel("2. " + Second, JLabel.CENTER);
        JLabel thirdLabel = new JLabel("3. " + Third, JLabel.CENTER);

        firstPanel.add(firstLabel);
        secondPanel.add(secondLabel);
        thirdPanel.add(thirdLabel);

         */

        // 플레이어 정보 텍스트 필드
        GridBagConstraints textGbc = new GridBagConstraints();
        textGbc.gridx = 0;
        textGbc.gridy = 0;
        textGbc.weightx = 1.0;
        textGbc.fill = GridBagConstraints.HORIZONTAL;

        JTextField firstField = new JTextField("1. " + First, 20);
        firstField.setHorizontalAlignment(JTextField.CENTER);
        firstField.setBackground(Color.YELLOW);
        firstPanel.add(firstField, textGbc);

        JTextField secondField = new JTextField("2. " + Second, 20);
        secondField.setHorizontalAlignment(JTextField.CENTER);
        secondField.setBackground(Color.WHITE);
        secondPanel.add(secondField, textGbc);

        JTextField thirdField = new JTextField("3. " + Third, 20);
        thirdField.setHorizontalAlignment(JTextField.CENTER);
        thirdField.setBackground(Color.WHITE);
        thirdPanel.add(thirdField, textGbc);

        // 확인 버튼
        gbc.gridy = 4;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.CENTER;
        JButton submitButton = new JButton("확인");
        submitButton.setPreferredSize(new Dimension(100, 50));
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // SubmarineClientResult 객체 생성 및 결과 표시
                SubmarineClientResult resultGUI = new SubmarineClientResult();
                resultGUI.showResult(First, Second, Third, first_score, second_score, third_score, first_winRate, second_winRate, third_winRate);
                dispose(); // 등수 표시 창 닫기
            }
        });

        mainPanel.add(submitButton, gbc);
        add(mainPanel);

        revalidate();
        repaint();

        System.out.println(First);
        System.out.println(Second);
        System.out.println(Third);

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
    // 1, 2, 3등 플레이어의 승률을 반환하는 함수들
    public int getFirstWinRate() {
        return first_winRate;
    }

    public int getSecondWinRate() {
        return second_winRate;
    }

    public int getthirdWinRate() {
        return third_winRate;
    }
}