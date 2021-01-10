package com.yingling.vipm.forms;

import javax.swing.*;
import java.awt.*;

public abstract class BaseDialog extends JDialog {
    private JFrame frame ;
    public BaseDialog(JFrame frame){

        this.frame = frame;
        int windowWidth = 800; //获得窗口宽
        int windowHeight = 600; //获得窗口高
        this.setSize(windowWidth,windowHeight);
        Toolkit kit = Toolkit.getDefaultToolkit(); //定义工具包
        Dimension screenSize = kit.getScreenSize(); //获取屏幕的尺寸
        int screenWidth = screenSize.width; //获取屏幕的宽
        int screenHeight = screenSize.height; //获取屏幕的高
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
