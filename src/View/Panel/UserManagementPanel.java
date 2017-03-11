package View.Panel;

import View.Device;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.Date;

/**
 * Created by 杨帆 on 2017/3/10.
 */

public class UserManagementPanel extends JPanel{
    private JPanel tableViewPanel;
    private JPanel detailViewPanel;
    private JTable jt;
    private JScrollPane jsp;
    private GridBagLayout gbl;
    private GridBagConstraints gbc;
    public UserManagementPanel(Dimension size){
        setSize(size);
        setLayout(new FlowLayout(FlowLayout.LEFT));
        //初始化
        tableViewPanel = new JPanel();
        detailViewPanel = new JPanel();
        _InitShow();
    }

    /**
     * 显示界面
     */
    private void _InitShow() {

        //列表显示部分
        _TableView();
        //详细显示部分
        _DetailView();
        //监视面板变化
        _SetResize();
    }

    /**
     * 员工列表显示部分
     *
     */
    private void _TableView() {

        DefaultTableModel dtf = new DefaultTableModel(new Object[][] {
                {"001" , "杨帆" , "yangfan" , "ubuntu" , 3 , new Date()} ,
                {"002" , "李一斐" , "liyifei" , "ubuntu" , 3 , new Date()},
                {"003" , "南继东" , "nanjidong" , "ubuntu" , 3 , new Date()},
                {"004" , "余帆" , "yufan" , "ubuntu" , 3 , new Date()},
                {"005" , "扈衍" , "huyan" , "ubuntu" , 3 , new Date()}} ,
                new String[] {"编号" , "姓名" , "账号" , "密码" , "等级" , "上次登录时间"}){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        jt = new JTable(dtf);
        //设置
        jt.getTableHeader().setFont(Device.contentFont);
        jt.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        jt.setFont(Device.contentFont);
        jt.setAutoCreateColumnsFromModel(true);
        jt.setAutoCreateRowSorter(false);
        //JScroll
        jsp = new JScrollPane(jt);
        tableViewPanel.add(jsp , BorderLayout.CENTER);
        add(tableViewPanel);
    }

    /**
     * 员工详细信息显示部分
     *
     */
    private void _DetailView() {
        gbl = new GridBagLayout();
        gbc = new GridBagConstraints();

        detailViewPanel.setSize(getWidth() - (int) (getWidth() * 0.7) - 5, getHeight());
        detailViewPanel.setLayout(gbl);
        //detailViewPanel.setBorder(BorderFactory.createMatteBorder(1 , 1 , 1, 1 , Color.DARK_GRAY));

        JPanel avatarPanel = new JPanel();
        ImageIcon avatarIcon = new ImageIcon("src\\Avatar\\yangfan.png");
        avatarIcon.setImage(avatarIcon.getImage().getScaledInstance(50 , 50 , 20));
        JLabel userAvatar = new JLabel(avatarIcon);
        avatarPanel.add(userAvatar , BorderLayout.CENTER);

        JPanel operatePanel = new JPanel();

        //
        detailViewPanel.add(avatarPanel);
        detailViewPanel.add(operatePanel);

        //布局
        gbc.gridwidth = 0;
        gbc.weightx = 0;
        gbc.weighty = 0;
        gbl.setConstraints(avatarPanel , gbc);

        gbc.gridwidth = 0;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbl.setConstraints(operatePanel , gbc);

        add(detailViewPanel);
    }

    /**
     * 当面板大小变化时
     */
    private void _SetResize(){
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                super.componentResized(e);
                int leftW = (int) (getWidth() * 0.7);
                int height = getHeight();
                jt.setSize(leftW , height);
                jt.setPreferredScrollableViewportSize(new Dimension(leftW , height));
                tableViewPanel.setSize(leftW + 5, height);
                jsp.setSize(leftW , height);
                //右边
                detailViewPanel.setSize(getWidth() - leftW - 5, height);
            }
        });
    }
}