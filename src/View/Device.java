package View;

import java.awt.*;

/**
 * Created by 杨帆 on 2017/3/7.
 */
public class Device {
    //大小
    public static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    public static int fontSize = screenSize.height / 200;
    public static int baseSize = screenSize.height / 700;

    //字体
    public static Font textFont = new Font("微软雅黑" , Font.PLAIN, Device.fontSize * 4);
    public static Font headFont = new Font("幼圆" , Font.BOLD , Device.fontSize * 8);
    public static Font linkFont = new Font("微软雅黑" , Font.PLAIN , Device.fontSize * 3);
}
