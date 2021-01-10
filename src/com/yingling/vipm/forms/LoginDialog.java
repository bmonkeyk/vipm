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
        menuSet = new JMenu("系统设置");
        menuItem_dbset = new JMenuItem("数据库设置");
        menuBar = new JMenuBar();
        menuSet.add(menuItem_dbset);
        menuBar.add(menuSet);

        getFrame().setTitle("门店管理系统");
        getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        int windowWidth = 600; //获得窗口宽
        int windowHeight = 400; //获得窗口高
        getFrame().setSize(windowWidth,windowHeight);
        Toolkit kit = Toolkit.getDefaultToolkit(); //定义工具包
        Dimension screenSize = kit.getScreenSize(); //获取屏幕的尺寸
        int screenWidth = screenSize.width; //获取屏幕的宽
        int screenHeight = screenSize.height; //获取屏幕的高
        getFrame().setLocation(screenWidth / 2 - windowWidth / 2, screenHeight / 2 - windowHeight / 2);

        //按钮监听
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
     * 设置数据库
     */
    private void setDB() {
        new DBSetDialog(getFrame());
    }

    /**
     * 登陆
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
