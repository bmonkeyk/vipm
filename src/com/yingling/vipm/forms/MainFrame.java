package com.yingling.vipm.forms;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    //��¼��½��
    private String user;
    private String dbPwd;
    private boolean isAdmin;

    public MainFrame(){

    }

    public static void main(String[] args) {
        JFrame frame = new MainFrame();
        new LoginDialog(frame);
        frame.setVisible(true);
    }
}
