package db.view;

import db.model.DB2024Team13_loginManager;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 로그인 창을 표시하는 클래스입니다.
 * <p>이 클래스는 사용자가 로그인할 수 있는 창을 생성하고 표시하는 기능을 제공합니다. 
 * 로그인 성공 시 메인 윈도우로 전환됩니다.</p>
 */
public class DB2024Team13_loginWindow {
    private static final int WINDOW_WIDTH = 900;
    private static final int WINDOW_HEIGHT = 700;
    
    /**
     * 로그인 창을 표시하는 메소드입니다.
     */
    public static void displayLoginWindow() {
        // 로그인 프레임 생성
        JFrame loginFrame = new JFrame("Login");
        loginFrame.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginFrame.setLocationRelativeTo(null);

        // 로그인 패널 생성
        JPanel loginPanel = new JPanel(new GridBagLayout());
        loginFrame.add(loginPanel);
        placeComponents(loginPanel, loginFrame);

        // 프레임을 보이게 설정
        loginFrame.setVisible(true);
    }

    /**
     * 로그인 패널에 컴포넌트를 배치하는 메소드입니다.
     *
     * @param loginPanel 로그인 패널
     * @param loginFrame 로그인 프레임
     */
    private static void placeComponents(JPanel loginPanel, JFrame loginFrame) {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(10, 10, 10, 10);
        constraints.fill = GridBagConstraints.HORIZONTAL;

        // 타이틀 레이블 생성
        JLabel titleLabel = new JLabel("EwhaRibbon");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 2;
        constraints.anchor = GridBagConstraints.CENTER;
        loginPanel.add(titleLabel, constraints);

        // 학번 레이블 생성
        JLabel studentIdLabel = new JLabel("학번:");
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        constraints.anchor = GridBagConstraints.WEST;
        loginPanel.add(studentIdLabel, constraints);

        // 학번 입력 필드 생성
        JTextField studentIdTextField = new JTextField(20);
        constraints.gridx = 1;
        constraints.gridy = 1;
        loginPanel.add(studentIdTextField, constraints);

        // 비밀번호 레이블 생성
        JLabel passwordLabel = new JLabel("비밀번호:");
        constraints.gridx = 0;
        constraints.gridy = 2;
        loginPanel.add(passwordLabel, constraints);

        // 비밀번호 입력 필드 생성
        JPasswordField passwordField = new JPasswordField(20);
        constraints.gridx = 1;
        constraints.gridy = 2;
        loginPanel.add(passwordField, constraints);

        // 로그인 버튼 생성
        JButton loginBtn = new JButton("로그인");
        loginBtn.setBackground(new Color(0, 80, 0));
        loginBtn.setForeground(Color.WHITE);
        loginBtn.setOpaque(true);
        loginBtn.setBorderPainted(false);
        constraints.gridx = 0;
        constraints.gridy = 3;
        constraints.gridwidth = 2;
        constraints.anchor = GridBagConstraints.CENTER;
        loginPanel.add(loginBtn, constraints);

        // 로그인 버튼에 액션 리스너 추가
        loginBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String user = studentIdTextField.getText();
                String password = new String(passwordField.getPassword());

                if (DB2024Team13_loginManager.validateLogin(user, password)) {
                    JOptionPane.showMessageDialog(loginPanel, "로그인 성공!");
                    // 로그인 성공 시 메인위도우 표시
                    showMainWindow(loginFrame);
                } else {
                    JOptionPane.showMessageDialog(loginPanel, "잘못된 학번 또는 비밀번호");
                }
            }
        });
    }

    /**
     * 메인 윈도우를 표시하는 메소드입니다.
     *
     * @param loginFrame 로그인 프레임
     */
    private static void showMainWindow(JFrame loginFrame) {
        // 로그인 프레임의 모든 컴포넌트 제거
        loginFrame.getContentPane().removeAll();
        loginFrame.repaint();
        loginFrame.setTitle("EwhaRibbon");

        // 메인 윈도우 컴포넌트 생성
        DB2024Team13_mainWindow mainWindow = new DB2024Team13_mainWindow();
        loginFrame.setLayout(new BorderLayout());
        loginFrame.add(mainWindow.createTitleBar(), BorderLayout.NORTH);
        loginFrame.add(mainWindow.createSidebar(), BorderLayout.WEST);
        loginFrame.add(mainWindow.getMainPanel(), BorderLayout.CENTER);

        // 프레임 갱신
        loginFrame.revalidate();
        loginFrame.repaint();
    }
}
