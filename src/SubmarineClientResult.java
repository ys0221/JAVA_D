// 지뢰 개수와 승률 계산 필요
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SubmarineClientResult extends JFrame {
    private String First, Second, Third;
    private int first_score, second_score, third_score;
    private int first_winRate, second_winRate, third_winRate;


    public SubmarineClientResult() {
        setTitle("Result");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout()); // BorderLayout 설정
    }

    // 1, 2, 3등을 받는다.
    public void showResult(String First, String Second, String Third, int score1, int score2, int score3, int winRate1, int winRate2, int winRate3) {
        this.First = First;
        this.Second = Second;
        this.Third = Third;
        this.first_score = score1;
        this.second_score = score2;
        this.third_score = score3;
        this.first_winRate = winRate1;
        this.second_winRate = winRate2;
        this.third_winRate = winRate3;

        // 메인 패널 설정
        JPanel mainPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // 제목 라벨 설정
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 3;
        JLabel titleLabel = new JLabel("Result", JLabel.CENTER);
        titleLabel.setFont(new Font("Serif", Font.BOLD, 24));
        mainPanel.add(titleLabel, gbc);

        // 칼럼 제목 설정
        gbc.gridwidth = 1;
        gbc.gridy = 1;
        gbc.gridx = 0;
        mainPanel.add(new JLabel("Player", JLabel.CENTER), gbc);
        gbc.gridx = 1;
        mainPanel.add(new JLabel("찾은 지뢰", JLabel.CENTER), gbc);
        gbc.gridx = 2;
        mainPanel.add(new JLabel("승률", JLabel.CENTER), gbc);

        // 1등 플레이어 정보
        gbc.gridy = 2;
        gbc.gridx = 0;
        mainPanel.add(new JLabel(First, JLabel.CENTER), gbc);
        gbc.gridx = 1;
        mainPanel.add(new JLabel(String.valueOf(first_score), JLabel.CENTER), gbc); // 정수를 문자열로 변환한다.
        gbc.gridx = 2;
        mainPanel.add(new JLabel(String.valueOf(first_winRate) + "%", JLabel.CENTER), gbc);

        // 2등 플레이어 정보
        gbc.gridy = 3;
        gbc.gridx = 0;
        mainPanel.add(new JLabel(Second, JLabel.CENTER), gbc);
        gbc.gridx = 1;
        mainPanel.add(new JLabel(String.valueOf(second_score), JLabel.CENTER), gbc);
        gbc.gridx = 2;
        mainPanel.add(new JLabel(String.valueOf(second_winRate) + "%", JLabel.CENTER), gbc);

        // 3등 플레이어 정보
        gbc.gridy = 4;
        gbc.gridx = 0;
        mainPanel.add(new JLabel(Third, JLabel.CENTER), gbc);
        gbc.gridx = 1;
        mainPanel.add(new JLabel(String.valueOf(third_score), JLabel.CENTER), gbc);
        gbc.gridx = 2;
        mainPanel.add(new JLabel(String.valueOf(third_winRate) + "%", JLabel.CENTER), gbc);

        // 버튼 패널 설정
        JPanel buttonPanel = new JPanel(new FlowLayout());
        JButton retryButton = new JButton("다시하기");
        JButton closeButton = new JButton("닫기");

        // 버튼 액션 리스너 추가
        retryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 다시하기 버튼 클릭 시 동작
                dispose(); // 현재 창 닫기
                // 레디 창으로 돌아간다.
            }
        });

        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 닫기 버튼 클릭 시 동작
                SubmarineClientCancelGUI cancel = new SubmarineClientCancelGUI();
                cancel.warning();
                cancel.setVisible(true);
            }
        });

        buttonPanel.add(retryButton);
        buttonPanel.add(closeButton);

        // 버튼 패널 추가
        gbc.gridy = 5;
        gbc.gridx = 0;
        gbc.gridwidth = 3;
        mainPanel.add(buttonPanel, gbc);

        add(mainPanel, BorderLayout.CENTER); // BorderLayout.CENTER 위치에 추가
        setVisible(true);
    }
}