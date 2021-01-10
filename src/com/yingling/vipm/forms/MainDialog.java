package com.yingling.vipm.forms;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainDialog extends BaseDialog {
    private JPanel contentPane;

    private JMenuBar menuBar ;

    //��ʼ�˵�
    private JMenu menu_star;
    private JMenuItem item_relog;
    private JMenuItem item_user;

    //��Ա����˵�
    private JMenu menu_vip ;
    private JMenuItem item_register;

    public MainDialog(JFrame frame) {
        super(frame);
        initUI();
    }

    @Override
    protected void initUI() {


        item_relog = new JMenuItem("���µ�½");
        item_user = new JMenuItem("�û�����");

        menu_star = new JMenu("��ʼ�˵�");
        menu_star.add(item_relog);
        menu_star.add(item_user);

        menu_vip = new JMenu("��Ա����");
        item_register = new JMenuItem("��Աע��");
        menu_vip.add(item_register);

        menuBar = new JMenuBar();
        menuBar.add(menu_star);
        menuBar.add(menu_vip);

        getFrame().setJMenuBar(menuBar);

        //���󴰿ڣ����¼���λ��
        int windowWidth = 800; //��ô��ڿ�
        int windowHeight =600; //��ô��ڸ�
        getFrame().setSize(windowWidth,windowHeight);
        Toolkit kit = Toolkit.getDefaultToolkit(); //���幤�߰�
        Dimension screenSize = kit.getScreenSize(); //��ȡ��Ļ�ĳߴ�
        int screenWidth = screenSize.width; //��ȡ��Ļ�Ŀ�
        int screenHeight = screenSize.height; //��ȡ��Ļ�ĸ�
        getFrame().setLocation(screenWidth / 2 - windowWidth / 2, screenHeight / 2 - windowHeight / 2);

        //��Ӱ�ť����
        item_relog.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                reLogin();
            }
        });
        //��ʾ����
        getFrame().setContentPane(contentPane);
        getFrame().repaint();
    }

    private void reLogin() {
        new LoginDialog(getFrame());
    }
}
