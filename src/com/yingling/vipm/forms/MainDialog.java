package com.yingling.vipm.forms;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainDialog extends BaseDialog {
    private JPanel contentPane;

    private JMenuBar menuBar ;

    //开始菜单
    private JMenu menu_star;
    private JMenuItem item_relog;
    private JMenuItem item_user;

    //会员管理菜单
    private JMenu menu_vip ;
    private JMenuItem item_register;

    public MainDialog(JFrame frame) {
        super(frame);
        initUI();
    }

    @Override
    protected void initUI() {


        item_relog = new JMenuItem("重新登陆");
        item_user = new JMenuItem("用户管理");

        menu_star = new JMenu("开始菜单");
        menu_star.add(item_relog);
        menu_star.add(item_user);

        menu_vip = new JMenu("会员管理");
        item_register = new JMenuItem("会员注册");
        menu_vip.add(item_register);

        menuBar = new JMenuBar();
        menuBar.add(menu_star);
        menuBar.add(menu_vip);

        getFrame().setJMenuBar(menuBar);

        //调大窗口，重新计算位置
        int windowWidth = 800; //获得窗口宽
        int windowHeight =600; //获得窗口高
        getFrame().setSize(windowWidth,windowHeight);
        Toolkit kit = Toolkit.getDefaultToolkit(); //定义工具包
        Dimension screenSize = kit.getScreenSize(); //获取屏幕的尺寸
        int screenWidth = screenSize.width; //获取屏幕的宽
        int screenHeight = screenSize.height; //获取屏幕的高
        getFrame().setLocation(screenWidth / 2 - windowWidth / 2, screenHeight / 2 - windowHeight / 2);

        //添加按钮监听
        item_relog.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                reLogin();
            }
        });
        //显示界面
        getFrame().setContentPane(contentPane);
        getFrame().repaint();
    }

    private void reLogin() {
        new LoginDialog(getFrame());
    }
}
