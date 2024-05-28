import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SubmarineCancelGUI extends JFrame {
    public SubmarineCancelGUI() {
        setTitle("CANCLE");
        setSize(500,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());
        cancel();
    }
    public void cancel() {
        // 게임 취소 패널 생성
        JPanel cancelPanel = new JPanel(new GridBagLayout());
        cancelPanel.setPreferredSize(new Dimension(300, 200));
        cancelPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
        cancelPanel.setBackground(Color.WHITE);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        // 게임 취소 문구 라벨
        JLabel cancelLabel = new JLabel("게임이 취소되었습니다.");
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        cancelPanel.add(cancelLabel, gbc);

        // 확인 버튼
        JButton submitButton = new JButton("네");
        gbc.gridx = 0;
        gbc.gridy = 1;
        cancelPanel.add(submitButton, gbc);

        // 확인 버튼이 눌렸을 때 실행되는 리스너
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0); // '네'를 누르면 프로그램 종료
            }
        });

        GridBagConstraints frameGbc = new GridBagConstraints();
        frameGbc.gridx = 0;
        frameGbc.gridy = 0;
        frameGbc.anchor = GridBagConstraints.CENTER;
        add(cancelPanel, frameGbc);
        cancelPanel.setVisible(true);

    }
}
