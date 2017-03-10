package View;

import View.Panel.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by 杨帆 on 2017/3/7.
 */
public class Management {
    private static ManagementMainForm umf;
    public static void UserManagementShow(){
       umf = new ManagementMainForm();
    }
}

class ManagementMainForm extends JFrame{
    private GridBagLayout gbl = new GridBagLayout();
    private GridBagConstraints gbc = new GridBagConstraints();
    private UserManagementPanel userManagementPanel = new UserManagementPanel();
    private AuditoriumManagementPanel auditoriumManagementPanel = new AuditoriumManagementPanel();
    private RepertoireManagementPanel repertoireManagementPanel = new RepertoireManagementPanel();
    private SeatManagementPanel seatManagementPanel = new SeatManagementPanel();
    private SalesInformationPanel salesInformationPanel = new SalesInformationPanel();
    public ManagementMainForm(){
        //当要显示的超过大小
        gbc.fill = GridBagConstraints.BOTH;
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
        this.setLayout(gbl);

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
        topPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));

        //用户信息面板
        JPanel userInfo = new JPanel(new FlowLayout());
        JLabel userLevel = new JLabel("系统管理员:");
        userLevel.setFont(Device.contentFont);
        JLabel userName = new JLabel("杨帆");
        userName.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

            }
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                userName.setForeground(Color.red);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                userName.setForeground(Color.black);
            }
        });
        userName.setFont(Device.contentFont);
        userInfo.add(userLevel);
        userInfo.add(userName);
        topPanel.add(userInfo);
        add(topPanel);
        gbc.gridwidth = 0;
        gbc.weightx = 0;
        gbc.weighty = 0;
        gbl.setConstraints(topPanel , gbc);
    }


    //
    /***
     * 显示标签栏
     */
    private void _TabbedShow() {
        JTabbedPane jTabbedPane = new JTabbedPane(JTabbedPane.LEFT,JTabbedPane.SCROLL_TAB_LAYOUT);
        jTabbedPane.setFont(Device.textFont);
        jTabbedPane.setBackground(Color.white);
        jTabbedPane.add(userManagementPanel , "员工管理");
        jTabbedPane.add(auditoriumManagementPanel , "映厅管理");
        jTabbedPane.add(repertoireManagementPanel , "剧目管理");
        jTabbedPane.add(seatManagementPanel , "座位管理");
        jTabbedPane.add(salesInformationPanel , "销售信息");
        add(jTabbedPane);
        gbc.gridwidth = 0;
        gbc.weightx = 10;
        gbc.weighty = 10;
        gbl.setConstraints(jTabbedPane , gbc);
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