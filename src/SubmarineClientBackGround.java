import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class SubmarineClientBackGround extends JPanel {
    private Image backgroundImage;

    public SubmarineClientBackGround(String filePath) {
        try {
            // 파일 경로 확인
            File imageFile = new File(filePath);
            if (!imageFile.exists()) {
                throw new IOException("File not found: " + filePath);
            }

            // 이미지 읽기
            backgroundImage = ImageIO.read(imageFile);
        } catch (IOException e) {
            e.printStackTrace();
            // 오류 메시지 표시
            JOptionPane.showMessageDialog(this, "이미지를 읽을 수 없습니다: " + filePath, "오류", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(),this);
        }
    }
}
