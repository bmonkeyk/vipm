package com.yingling.vipm.forms.start;

import com.yingling.vipm.forms.BaseDialog;
import com.yingling.vipm.util.PropertiesUtil;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class DBSetDialog extends BaseDialog {
    private JButton testBtn;
    private JButton saveBtn;
    private JTextField urlText;
    private JTextField portText;
    private JTextField userText;
    private JPasswordField pwdText;
    private JPanel contentPane;
    private JButton applyBtn;
    private JButton initBtn;

    public DBSetDialog(JFrame frame) {
        super(frame);
        initUI();
    }

    protected void initUI() {

        String url = PropertiesUtil.getInstance().getPropByKey("db.url");
        String port = PropertiesUtil.getInstance().getPropByKey("db.port");
        String user = PropertiesUtil.getInstance().getPropByKey("db.user");
        String pwd = PropertiesUtil.getInstance().getPropByKey("db.pwd");

        urlText.setText(url);
        portText.setText(port);
        userText.setText(user);
        pwdText.setText(pwd);

        testBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                testConnection();
            }
        });
        applyBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveDBSet(false);
            }
        });
        saveBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveDBSet(true);
            }
        });
        initBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                doInit();
            }
        });
        setContentPane(contentPane);
        setVisible(true);
    }

    private void doInit() {
        int choose =JOptionPane.showConfirmDialog(null,"ȷ�Ϻ����˵�����ݣ��Ƿ����?","��ʾ",JOptionPane.YES_NO_OPTION);
        if(choose == JOptionPane.YES_OPTION){
            //todo ϵͳ��ʼ��
            JOptionPane.showMessageDialog(null,"��ʼ���ɹ�","��ʾ",JOptionPane.WARNING_MESSAGE);
        }
    }

    /**
     * �������ݿ�����
     */
    private void saveDBSet(boolean saveFlag) {
        String url = urlText.getText();
        String port = portText.getText();
        String user = userText.getText();
        String pwd = new String( pwdText.getPassword());
        Map<String ,String> propMap = new HashMap<>();
        propMap.put("db.url", url);
        propMap.put("db.port", port);
        propMap.put("db.user", user);
        propMap.put("db.pwd", pwd);
        PropertiesUtil.getInstance().writeProperty(propMap);
        if(saveFlag){
            dispose();
        }
    }

    /**
     * ��������
     */
    private void testConnection() {
        String url = urlText.getText();
        String port = portText.getText();
        String user = userText.getText();
        String pwd = new String( pwdText.getPassword());
    }

}
