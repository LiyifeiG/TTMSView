package com.ttmsview.usermanagement;

import javax.swing.*;
import java.awt.*;

/**
 * Created by 杨帆 on 2017/3/3.
 */
public class VLogin {
    public static void vloginShow(){
        new VLoginForm();
    }
}

class VLoginForm extends JDialog{
    private JPanel mainPanel;
    public VLoginForm(){
        //初始化JPanel
        mainPanel = new JPanel();
        //设置窗口大小
        this.setSize(700 , 540);
        //设置拖动的最低大小
        this.setMinimumSize(new Dimension(700 , 450));
        //将面板添加进来
        this.add(mainPanel);
        //初始化显示
        _InitShow();
        //设置可见性
        setVisible(true);
    }

    private void _InitShow(){
        //设置主面板布局
        mainPanel.setLayout(new GridLayout(2 , 2 , 5 ,5));
        mainPanel.add(new JPanel());
        mainPanel.add(new JPanel());
        mainPanel.add(new JPanel());



        //字体
        Font mf = new Font("微软雅黑" , Font.BOLD , 20);

        //登陆面板设置
        JPanel loginPanel = new JPanel();
        loginPanel.setLayout(new GridLayout(4 , 1));

        //设置账号面板
        JPanel accountPanel = new JPanel();
        accountPanel.setLayout(new FlowLayout());
        JLabel accText = new JLabel("账号:");
        accText.setFont(mf);
        accountPanel.add(accText);
        JTextField accInput = new JTextField(12);
        accInput.setFont(mf);
        accountPanel.add(accInput);

        //设置密码面板
        JPanel passwordPanel = new JPanel();
        passwordPanel.setLayout(new FlowLayout());
        JLabel passText = new JLabel("密码:");
        passText.setFont(mf);
        passwordPanel.add(passText);
        JPasswordField passInput = new JPasswordField(12);
        passInput.setFont(mf);
        passwordPanel.add(passInput);

        //操作面板
        JPanel opPanel = new JPanel();
        opPanel.setLayout(new FlowLayout());
        JButton loginButton = new JButton("登录");
        loginButton.setFont(mf);
        JButton cancerButton = new JButton("取消");
        cancerButton.setFont(mf);
        opPanel.add(loginButton);
        opPanel.add(cancerButton);

        //将账号密码面板及操作面板添加到登陆面板上
        loginPanel.add(accountPanel);
        loginPanel.add(passwordPanel);
        loginPanel.add(opPanel);

        //将登陆面板添加到主面板上
        mainPanel.add(loginPanel);
    }

}
