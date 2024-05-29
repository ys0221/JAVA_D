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

    public SubmarineClientLoserGUI() {
        setTitle("Loser");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());
    }

    // 생성자
    public void getRank(ArrayList<String> playernames, ArrayList<Integer> playerpoints) {
        // 데이터 복사
        ArrayList<String> namesCopy = new ArrayList<>(playernames);
        ArrayList<Integer> pointsCopy = new ArrayList<>(playerpoints);

        int player1points = pointsCopy.get(0);
        int player2points = pointsCopy.get(1);
        int player3points = pointsCopy.get(2);
        pointsCopy.sort(Comparator.reverseOrder());

        // 1등 지정
        if (pointsCopy.get(0) == player1points) {
            First = namesCopy.get(0);
        } else if (pointsCopy.get(0) == player2points) {
            First = namesCopy.get(1);
        } else {
            First = namesCopy.get(2);
        }
        firstScore = pointsCopy.get(0);

        // 2등 지정
        if (pointsCopy.get(1) == player1points) {
            Second = namesCopy.get(0);
        } else if (pointsCopy.get(1) == player2points) {
            Second = namesCopy.get(1);
        } else {
            Second = namesCopy.get(2);
        }
        secondScore = pointsCopy.get(1);

        // 3등 지정
        if (pointsCopy.get(2) == player1points) {
            Third = namesCopy.get(0);
        } else if (pointsCopy.get(2) == player2points) {
            Third = namesCopy.get(1);
        } else {
            Third = namesCopy.get(2);
        }
        thirdScore = pointsCopy.get(2);
        // 메인 패널 설정
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
        JLabel titleLabel = new JLabel("LOSE!", JLabel.CENTER);
        titleLabel.setFont(new Font("Serif", Font.BOLD, 24));
        mainPanel.add(titleLabel, gbc);

        // 각 패널 설정
        gbc.gridwidth = 1;
        gbc.weighty = 1.0 / 3.0; // 균등한 세로 확장을 위해 각 패널의 weighty 설정
        gbc.gridy = 1;
        JPanel firstPanel = new JPanel(new GridBagLayout());
        mainPanel.add(firstPanel, gbc);
        firstPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        firstPanel.setBackground(Color.WHITE);

        gbc.gridy = 2;
        JPanel secondPanel = new JPanel(new GridBagLayout());
        mainPanel.add(secondPanel, gbc);
        secondPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        secondPanel.setBackground(Color.YELLOW);

        gbc.gridy = 3;
        JPanel thirdPanel = new JPanel(new GridBagLayout());
        mainPanel.add(thirdPanel, gbc);
        thirdPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
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
        firstField.setBackground(Color.WHITE);
        firstPanel.add(firstField, textGbc);

        JTextField secondField = new JTextField("2. " + Second, 20);
        secondField.setHorizontalAlignment(JTextField.CENTER);
        secondField.setBackground(Color.YELLOW);
        secondPanel.add(secondField, textGbc);

        JTextField thirdField = new JTextField("3. " + Third, 20);
        thirdField.setHorizontalAlignment(JTextField.CENTER);
        thirdField.setBackground(Color.WHITE);
        thirdPanel.add(thirdField, textGbc);


        // 확인 버튼
        gbc.gridy = 4;
        gbc.weighty = 0.1; // 적당한 세로 확장 비율 설정
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.CENTER;
        JButton submitButton = new JButton("확인");
        submitButton.setPreferredSize(new Dimension(100, 50));
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // SubmarineClientResult 객체 생성 및 결과 표시
                SubmarineClientResult resultGUI = new SubmarineClientResult();
                resultGUI.showResult(First, Second, Third, firstScore, secondScore, thirdScore);
                dispose();
            }
        });

        mainPanel.add(submitButton, gbc);
        add(mainPanel);

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