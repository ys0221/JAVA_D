import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SubmarineClientCancelGUI extends JFrame {
    // 경고창 frame 생성
    public SubmarineClientCancelGUI() {
        setTitle("Warning!");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());
        warning(); // 초기화
    }

    public void warning() {
        // 경고 패널 생성
        JPanel warningPanel = new JPanel(new GridBagLayout());
        warningPanel.setPreferredSize(new Dimension(300, 200));
        warningPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
        warningPanel.setBackground(Color.WHITE);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        // 경고 문구 라벨
        JLabel warningLabel = new JLabel("정말 게임을 끝내시겠습니까?");
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        warningPanel.add(warningLabel, gbc);

        // 버튼
        JButton submitButton = new JButton("네");
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.LINE_END;
        gbc.fill = GridBagConstraints.NONE;
        warningPanel.add(submitButton, gbc);

        JButton retryButton = new JButton("돌아가기");
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        warningPanel.add(retryButton, gbc);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SubmarineCancelGUI cancel = new SubmarineCancelGUI();
                cancel.cancel();
                cancel.setVisible(true);
            }
        });

        retryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        // 경고 패널을 중앙에 배치하는 코드
        GridBagConstraints frameGbc = new GridBagConstraints();
        frameGbc.gridx = 0;
        frameGbc.gridy = 0;
        frameGbc.anchor = GridBagConstraints.CENTER;
        add(warningPanel, frameGbc);

        setVisible(true);
    }

}
