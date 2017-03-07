package View;

import javax.swing.*;
import java.awt.*;

/**
 * Created by 杨帆 on 2017/3/7.
 */
public class UserManagement {
    public static void UserManagementShow(){

    }
}

class UserManagementForm extends JFrame{
    public UserManagementForm(){
        //设置窗口大小
        this.setSize(750 , 500);
        //设置拖动的最低大小
        this.setMinimumSize(new Dimension(750 , 500));
        //设置初始出现位置
        this.setLocationRelativeTo(null);
        //初始化显示
        _InitShow();
        //关闭方法
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //设置可见性
        setVisible(true);
    }

    private void _InitShow() {

    }
}