package com.ttmsview.usermanagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

/**
 * Created by 杨帆 on 2017/3/3.
 */
public class VLogin {
    public static void VloginShow(){

        new VLoginForm();
    }
}

class VLoginForm extends JFrame{
    //private JPanel mainPanel = new JPanel();;
    public VLoginForm(){
        //设置窗口大小
        this.setSize(750 , 540);
        //设置拖动的最低大小
        this.setMinimumSize(new Dimension(750 , 450));
        //将面板添加进来
        //this.add(mainPanel);
        //设置初始出现位置
        this.setLocationRelativeTo(null);
        //初始化显示
        _InitShow();
        //关闭方法
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //设置可见性
        setVisible(true);
    }

    private void _InitShow(){
        //设置主面板布局
        this.setLayout(new GridLayout(1 , 2 , 5 ,5));

        //设置面板背景图片
        _SetBk();

        //未实现
        JPanel leftPanel = new JPanel();
        leftPanel.setOpaque(false);
        this.add(leftPanel);

        //字体
        Font textFont = new Font("微软雅黑" , Font.PLAIN, 20);
        Font headFont = new Font("幼圆" , Font.BOLD , 35);

        //右面板
        JPanel rightPanel = new JPanel();
        rightPanel.setOpaque(false);
        rightPanel.setLayout(new GridLayout(2 , 1 , 5 , 70));

        //图标面板
        JPanel tPanel = new JPanel();
        tPanel.setOpaque(false);
        tPanel.setLayout(new BorderLayout());
        JLabel lLabel = new JLabel("用户登录");
        lLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lLabel.setVerticalAlignment(SwingConstants.BOTTOM);
        lLabel.setFont(headFont);
        tPanel.add(lLabel , BorderLayout.CENTER);

        //登陆面板设置
        JPanel loginPanel = new JPanel();
        loginPanel.setOpaque(false);
        loginPanel.setLayout(new GridLayout(4 , 1 , 10 , 20));

        //设置账号面板
        JPanel accountPanel = new JPanel();
        accountPanel.setOpaque(false);
        accountPanel.setLayout(new FlowLayout());
        JLabel accText = new JLabel("账号:");
        accText.setFont(textFont);
        accountPanel.add(accText);
        JTextField accInput = new JTextField(10);
        accInput.setFont(textFont);
        accountPanel.add(accInput);

        //设置密码面板
        JPanel passwordPanel = new JPanel();
        passwordPanel.setOpaque(false);
        passwordPanel.setLayout(new FlowLayout());
        JLabel passText = new JLabel("密码:");
        passText.setFont(textFont);
        passwordPanel.add(passText);
        JPasswordField passInput = new JPasswordField(10);
        passInput.setFont(textFont);
        passwordPanel.add(passInput);

        //操作面板
        JPanel opPanel = new JPanel();
        opPanel.setOpaque(false);
        opPanel.setLayout(new FlowLayout(1 , 30 , 0));
        JButton loginButton = new JButton("登录");
        loginButton.setFont(textFont);
        loginButton.addActionListener(e -> {
            System.out.println("登陆成功");
        });
        JButton cancerButton = new JButton("取消");
        cancerButton.setFont(textFont);
        cancerButton.addActionListener(e -> {
            System.exit(0);
        });
        opPanel.add(loginButton);
        opPanel.add(cancerButton);

        //将账号密码面板及操作面板添加到登陆面板上
        loginPanel.add(accountPanel);
        loginPanel.add(passwordPanel);
        loginPanel.add(opPanel);

        //将面板添加到右面板上
        rightPanel.add(tPanel);
        rightPanel.add(loginPanel);

        //将右面版添加到主面板上
        this.add(rightPanel);
    }

    //背景设置
    private void _SetBk() {
        ImageIcon bkImage = new ImageIcon("src\\Asserts\\bk1.jpg");
        bkImage.setImage(bkImage.getImage().getScaledInstance(getWidth() , getHeight() , Image.SCALE_DEFAULT));
        JLabel bkLabel = new JLabel(bkImage);
        bkLabel.setBounds(0 , 0 , getWidth(), getHeight());
        JPanel imagePanel = (JPanel) this.getContentPane();
        imagePanel.setOpaque(false);
        getLayeredPane().add(bkLabel, new Integer(Integer.MIN_VALUE));
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                super.componentResized(e);
                bkImage.setImage(bkImage.getImage().getScaledInstance(getWidth() , getHeight() , Image.SCALE_DEFAULT));
                bkLabel.setBounds(0 , 0 , getWidth(), getHeight());
            }
        });
    }
}
