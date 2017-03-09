package View;

import javax.swing.*;
import java.awt.*;

/**
 * Created by 杨帆 on 2017/3/7.
 */
public class UserManagement {
    private static UserManagementForm umf;
    public static void UserManagementShow(){
       umf = new UserManagementForm();
    }
}

class UserManagementForm extends JFrame{
    public UserManagementForm(){
        //设置窗口大小
        this.setSize((int) (Device.screenSize.width / 1.5) , (int) (Device.screenSize.height / 1.5));
        //设置拖动的最低大小
        this.setMinimumSize(new Dimension((int) (Device.screenSize.width / 1.5) , (int) (Device.screenSize.height / 1.5)));
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

        this.setLayout(new GridLayout(2 , 1 , 10 , 10));

        //图标设置
        _SetIcon();
        //Menu菜单栏
        _MenuShow();
        //标签栏
        _TabbedShow();
        //主界面
    }


    /***
     * 显示顶部菜单栏
     */
    private void _MenuShow() {
        JPanel topPanel = new JPanel();
        this.add(topPanel);
    }

    /***
     * 显示标签栏
     */
    private void _TabbedShow() {
        JTabbedPane jTabbedPane = new JTabbedPane(JTabbedPane.LEFT);
        jTabbedPane.setFont(Device.textFont);
        jTabbedPane.add(new Label("Hello") , "人员管理");
        jTabbedPane.add(new Label("World"));
        this.add(jTabbedPane);
    }


    /***
     * 图标设置
     */
    private void _SetIcon(){
        Toolkit tl = Toolkit.getDefaultToolkit();
        setIconImage(tl.createImage("src\\Asserts\\ICON.jpg"));
        setTitle("剧院管理系统");
    }
}