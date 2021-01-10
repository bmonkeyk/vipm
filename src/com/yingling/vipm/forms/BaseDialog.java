package com.yingling.vipm.forms;

import javax.swing.*;
import java.awt.*;

public abstract class BaseDialog extends JDialog {
    private JFrame frame ;
    public BaseDialog(JFrame frame){

        this.frame = frame;
        int windowWidth = 800; //��ô��ڿ�
        int windowHeight = 600; //��ô��ڸ�
        this.setSize(windowWidth,windowHeight);
        Toolkit kit = Toolkit.getDefaultToolkit(); //���幤�߰�
        Dimension screenSize = kit.getScreenSize(); //��ȡ��Ļ�ĳߴ�
        int screenWidth = screenSize.width; //��ȡ��Ļ�Ŀ�
        int screenHeight = screenSize.height; //��ȡ��Ļ�ĸ�
        this.setLocation(screenWidth / 2 - windowWidth / 2, screenHeight / 2 - windowHeight / 2);
        setModal(true);
    }

    protected abstract void initUI();

    public JFrame getFrame() {
        return frame;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }
}
