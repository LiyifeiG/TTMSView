package View;

import View.Panel.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

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
    private GridBagLayout gbl;
    private GridBagConstraints gbc;
    private UserManagementPanel userManagementPanel;
    private AuditoriumManagementPanel auditoriumManagementPanel;
    private RepertoireManagementPanel repertoireManagementPanel;
    private SeatManagementPanel seatManagementPanel;
    private SalesInformationPanel salesInformationPanel;
    private JTabbedPane jTabbedPane;
    public ManagementMainForm(){
        //设置窗口大小
        this.setSize((int) (Device.screenSize.width / 1.5) , (int) (Device.screenSize.height / 1.5));
        //设置拖动的最低大小
        this.setMinimumSize(new Dimension((int) (Device.screenSize.width / 1.5) , (int) (Device.screenSize.height / 1.5)));
        //设置初始出现位置
        this.setLocationRelativeTo(null);
        //初始化属性
        gbl = new GridBagLayout();
        gbc = new GridBagConstraints();
        userManagementPanel = new UserManagementPanel(this.getSize());
        auditoriumManagementPanel = new AuditoriumManagementPanel(this.getSize());
        repertoireManagementPanel = new RepertoireManagementPanel(this.getSize());
        seatManagementPanel = new SeatManagementPanel(this.getSize());
        salesInformationPanel = new SalesInformationPanel(this.getSize());
        jTabbedPane = new JTabbedPane(JTabbedPane.TOP,JTabbedPane.SCROLL_TAB_LAYOUT);
        //当要显示的超过大小
        gbc.fill = GridBagConstraints.BOTH;
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
        //监视大小变化
        _SetReSize();
    }

    /***
     * 显示顶部菜单栏
     */
    private void _MenuShow() {
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));

        //用户信息面板
        JPanel userInfo = new JPanel(new FlowLayout());
        ImageIcon adminIcon = new ImageIcon("src\\Asserts\\admin.png");
        adminIcon.setImage(adminIcon.getImage().getScaledInstance(15 , 15 , 20));
        JLabel adminLabelIcon = new JLabel(adminIcon);
        JLabel userLevel = new JLabel("系统管理员:");
        userLevel.setFont(Device.contentFont);

        //用户点击菜单
        JMenuBar adminBar = new JMenuBar();
        adminBar.setOpaque(false);
        adminBar.setBorderPainted(false);
        adminBar.setFont(Device.contentFont);
        adminBar.setBackground(getBackground());
        adminBar.setUI(null);
        adminBar.setMargin(new Insets(10 , 10 , 10 , 10));
        JMenu adminMenu = new JMenu("杨帆");
        adminMenu.setFont(Device.contentFont);
        JMenuItem data = new JMenuItem("资料");
        data.setFont(Device.contentFont);
        data.addActionListener( e -> {
            try {
                Desktop.getDesktop().browse(new URI("https://www.google.com/ncr"));
            } catch (IOException e1) {
                e1.printStackTrace();
            } catch (URISyntaxException e1) {
                e1.printStackTrace();
            }
        });
        JMenuItem signOut = new JMenuItem("注销");
        signOut.setFont(Device.contentFont);
        signOut.addActionListener(e -> {
            Login.LoginShow();
            dispose();
        });
        adminMenu.add(data);
        adminMenu.add(signOut);
        adminMenu.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                adminMenu.setForeground(Color.red);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                adminMenu.setForeground(Color.black);
            }
        });

        adminBar.add(adminMenu);

        userInfo.add(adminLabelIcon);
        userInfo.add(userLevel);
        userInfo.add(adminBar);
        
        topPanel.add(userInfo);
        add(topPanel);
        gbc.gridwidth = 0;
        gbc.weightx = 1;
        gbc.weighty = 0;
        gbl.setConstraints(topPanel , gbc);
    }


    //
    /***
     * 显示标签栏
     */
    private void _TabbedShow() {
        //标签面板设置
        jTabbedPane.setFont(Device.textFont);
        jTabbedPane.setBackground(Color.white);
        //添加标签页
        jTabbedPane.add(userManagementPanel , "员工管理");
        jTabbedPane.add(auditoriumManagementPanel , "映厅管理");
        jTabbedPane.add(repertoireManagementPanel , "剧目管理");
        jTabbedPane.add(seatManagementPanel , "座位管理");
        jTabbedPane.add(salesInformationPanel , "销售信息");
        //标签页图标
        ImageIcon userIcon = new ImageIcon("src\\Asserts\\user.png");
        userIcon.setImage(userIcon.getImage().getScaledInstance(20 , 20 , 20));
        ImageIcon auditorIcon = new ImageIcon("src\\Asserts\\auditor.png");
        auditorIcon.setImage(auditorIcon.getImage().getScaledInstance(20 , 20 , 20));
        ImageIcon moviesIcon = new ImageIcon("src\\Asserts\\movies.png");
        moviesIcon.setImage(moviesIcon.getImage().getScaledInstance(20 , 20 , 20));
        ImageIcon seatsIcon = new ImageIcon("src\\Asserts\\seat.png");
        seatsIcon.setImage(seatsIcon.getImage().getScaledInstance(20 , 20 , 20));
        ImageIcon salesIcon = new ImageIcon("src\\Asserts\\sales.png");
        salesIcon.setImage(salesIcon.getImage().getScaledInstance(20 , 20 , 20));
        jTabbedPane.setIconAt(0 ,userIcon);
        jTabbedPane.setIconAt(1 ,auditorIcon);
        jTabbedPane.setIconAt(2 , moviesIcon);
        jTabbedPane.setIconAt(3 , seatsIcon);
        jTabbedPane.setIconAt(4 , salesIcon);
        add(jTabbedPane);
        gbc.gridwidth = 0;
        gbc.weightx = 1;
        gbc.weighty = 1;
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


    /**
     * 当面板大小改变时触发
     */
    private void _SetReSize(){
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                super.componentResized(e);
                userManagementPanel.setSize(getSize());
                repertoireManagementPanel.setSize(getSize());
                auditoriumManagementPanel.setSize(getSize());
                seatManagementPanel.setSize(getSize());
                salesInformationPanel.setSize(getSize());
            }
        });
    }
}