package cn.yc39stu.ycTool.copyClass;

import cn.yc39stu.ycTool.util.SwingUtil;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class CopyClassSwing {

    public static void main(String[] args) {
        JFrame frame = new JFrame("");
        frame.setSize(500, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.add(panel);
        myPanel(panel);

        SwingUtil.centerShowJFrame(frame);
        frame.setVisible(true);
    }

    private static String jarPath = "";
    private static String destPath = "";
    private static String verboseStr = "";

    public static void myPanel(JPanel panel) {

        panel.setLayout(null);

        JTextField jarPathTextField = new JTextField();
        jarPathTextField.setBounds(10, 10, 360, 30);
        jarPathTextField.setEnabled(false);
        panel.add(jarPathTextField);

        JButton selectJarButton = new JButton("选择jar包");
        selectJarButton.setBounds(380, 10, 100, 30);
        panel.add(selectJarButton);

        JButton runJarButton = new JButton("运行jar");
        runJarButton.setBounds(280, 60, 100, 30);
        panel.add(runJarButton);

        JTextField destPathTextField = new JTextField();
        destPathTextField.setBounds(10, 100, 280, 30);
        panel.add(destPathTextField);

        JButton selectDestPathButton = new JButton("选择class复制目标路径");
        selectDestPathButton.setBounds(300, 100, 180, 30);
        selectDestPathButton.setEnabled(false);
        panel.add(selectDestPathButton);

        JButton copyFileButton = new JButton("复制class文件");
        copyFileButton.setBounds(150, 150, 150, 30);
        panel.add(copyFileButton);


        selectJarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jarPath = SwingUtil.chooseDirectoryOrFile();
                jarPathTextField.setText(jarPath);
            }
        });
        runJarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                verboseStr = CopyClassUtil.cmdJar(jarPath);
                selectDestPathButton.setEnabled(true);
            }
        });
        selectDestPathButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                destPath = SwingUtil.chooseDirectoryOrFile();
                destPathTextField.setText(destPath);
            }
        });
        copyFileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<String> sourcePathList = CopyClassUtil.dealVerboseStrs(verboseStr);
                CopyClassUtil.copyFile(sourcePathList, destPath);
            }
        });

    }
}
