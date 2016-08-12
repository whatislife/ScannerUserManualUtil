package com.venustech.scanner.gui;
import java.awt.Container;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import com.venustech.scanner.TransferUtil;

public class ClientGUI implements ActionListener {
	String srcPath = "";
	String destPath = "";
	JFrame frame = new JFrame("手册转化");// 框架布局
	JPanel tabPane = new JPanel();// 选项卡布局
	Container con = new Container();//
	JLabel label1 = new JLabel("输入目录");
	JLabel label2 = new JLabel("输出目录");
	JTextField text1 = new JTextField();// TextField 目录的路径
	JTextField text2 = new JTextField();// 文件的路径
	JButton button1 = new JButton("...");// 选择
	JButton button2 = new JButton("...");// 选择
	JFileChooser jfc = new JFileChooser();// 文件选择器
	JButton button3 = new JButton("确定");//
	
	ClientGUI() {
		jfc.setCurrentDirectory(new File("c://"));// 文件选择器的初始目录定为d盘
		
		double lx = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		
		double ly = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		ImageIcon icon=new ImageIcon(ClientGUI.class.getClassLoader() .getResource("image2/scanner.png"));
		Image image=icon.getImage();
		frame.setLocation(new Point((int) (lx / 2) - 150, (int) (ly / 2) - 150));// 设定窗口出现位置
		frame.setSize(330, 160);// 设定窗口大小
		frame.setContentPane(tabPane);// 设置布局
		frame.setIconImage(image);
		label1.setBounds(10, 10, 70, 20);
		text1.setBounds(75, 10, 170, 20);
		text1.setEditable(false);
		button1.setBounds(255, 10, 50, 20);
		label2.setBounds(10, 40, 70, 20);
		text2.setBounds(75, 40, 170, 20);
		text2.setEditable(false);
		button2.setBounds(255, 40, 50, 20);
		button3.setBounds(180, 80, 60, 20);
		button1.addActionListener(this); // 添加事件处理
		button2.addActionListener(this); // 添加事件处理
		button3.addActionListener(this); // 添加事件处理
		con.add(label1);
		con.add(text1);
		con.add(button1);
		con.add(label2);
		con.add(text2);
		con.add(button2);
		con.add(button3);
		frame.setVisible(true);// 窗口可见
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 使能关闭窗口，结束程序
		tabPane.add("手册转化", con);// 添加布局1
		frame.setContentPane(con);
	}
	/**
	 * 时间监听的方法
	 */
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(button1)) {// 判断触发方法的按钮是哪个
			jfc.setFileSelectionMode(1);// 设定只能选择到文件夹
			int state = jfc.showOpenDialog(null);// 此句是打开文件选择器界面的触发语句
			if (state == 1) {
				return;
			} else {
				File f = jfc.getSelectedFile();// f为选择到的目录
				text1.setText(f.getAbsolutePath());
				srcPath = f.getAbsolutePath();
			}
		}
		// 绑定到选择文件，先择文件事件
		if (e.getSource().equals(button2)) {
			jfc.setFileSelectionMode(1);// 设定只能选择到文件
			int state = jfc.showOpenDialog(null);// 此句是打开文件选择器界面的触发语句
			if (state == 1) {
				return;// 撤销则返回
			} else {
				File f = jfc.getSelectedFile();// f为选择到的文件
				text2.setText(f.getAbsolutePath());
				destPath=f.getAbsolutePath();
			}
		}
		if (e.getSource().equals(button3)) {
			if(srcPath.equals("")||destPath.equals("")){
				JOptionPane.showMessageDialog(null, "目录为空重新选择！", "提示", 2);
			}else{
				JOptionPane.showMessageDialog(null, "欢迎使用手册转化工具-开始转化！", "提示", 2);
				String flag = TransferUtil.userManual(srcPath,destPath);
				JOptionPane.showMessageDialog(null, flag, "提示", 2);
			}
		}
	}
	public static void main(String[] args) {
		new ClientGUI();
	}
}


