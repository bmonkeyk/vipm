package com.yingling.vipm.forms;

import com.yingling.vipm.forms.start.DBSetDialog;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginDialog extends BaseDialog {

    private JPanel contentPane;
    private JButton loginBtn;
    private JButton exitBtn;
    private JCheckBox isAdminCkb;
    private JTextField userText;
    private JPasswordField pwdText;
    private JMenuBar menuBar;
    private JMenu menuSet;
    private JMenuItem menuItem_dbset;

    public LoginDialog(JFrame frame) {
        super(frame);
        initUI();
    }

    protected void initUI() {
        menuSet = new JMenu("ϵͳ����");
        menuItem_dbset = new JMenuItem("���ݿ�����");
        menuBar = new JMenuBar();
        menuSet.add(menuItem_dbset);
        menuBar.add(menuSet);

        getFrame().setTitle("�ŵ����ϵͳ");
        getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        int windowWidth = 600; //��ô��ڿ�
        int windowHeight = 400; //��ô��ڸ�
        getFrame().setSize(windowWidth,windowHeight);
        Toolkit kit = Toolkit.getDefaultToolkit(); //���幤�߰�
        Dimension screenSize = kit.getScreenSize(); //��ȡ��Ļ�ĳߴ�
        int screenWidth = screenSize.width; //��ȡ��Ļ�Ŀ�
        int screenHeight = screenSize.height; //��ȡ��Ļ�ĸ�
        getFrame().setLocation(screenWidth / 2 - windowWidth / 2, screenHeight / 2 - windowHeight / 2);

        //��ť����
        loginBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                doLogin();
            }
        });
        exitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        menuItem_dbset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setDB();
            }
        });

        getFrame().setContentPane(contentPane);
        getFrame().setJMenuBar(menuBar);
    }

    /**
     * �������ݿ�
     */
    private void setDB() {
        new DBSetDialog(getFrame());
    }

    /**
     * ��½
     */
    private void doLogin() {
       dispose();
       new MainDialog(getFrame());

    }

    @Override
    public JPanel getContentPane() {
        return contentPane;
    }

    public void setContentPane(JPanel contentPane) {
        this.contentPane = contentPane;
    }
}
