package cn.yc39stu.ycTool.swing;

import cn.yc39stu.ycTool.util.SwingUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

public class YCUtil {
    public static void main(String[] args) {
        JFrame frame = new JFrame("ycUtil");
        frame.setSize(900, 760);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.add(panel);
        myPanel(panel);

        SwingUtil.centerShowJFrame(frame);
        frame.setVisible(true);

    }


    private static void myPanel(JPanel panel){


        panel.setLayout(null);

        JLabel label0 = new JLabel("前");
        label0.setBounds(200, 20, 50, 28);
        panel.add(label0);

        JLabel label1 = new JLabel("后");
        label1.setBounds(200, 50, 50, 28);
        panel.add(label1);

        JTextField beforeTextField = new JTextField("sql.append(\" ");
        beforeTextField.setBounds(270, 20, 300, 28);
        panel.add(beforeTextField);

        JTextField afterTextField = new JTextField(" \");");
        afterTextField.setBounds(270, 50, 300, 28);
        panel.add(afterTextField);


        JCheckBox replaceValuesCheckBox = new JCheckBox("添加时更换值为\"?\"");
        replaceValuesCheckBox.setSelected(true);
        replaceValuesCheckBox.setBounds(600, 20, 150, 30);
        panel.add(replaceValuesCheckBox);

        JButton resetTextButton = new JButton("<-重置");
        resetTextButton.setBounds(600, 50, 100, 20);
        panel.add(resetTextButton);

        JButton lazyButton = new JButton("懒人按钮");
        lazyButton.setBounds(750, 30, 100, 50);
        panel.add(lazyButton);



        JTextArea textArea0 = new JTextArea();
        JScrollPane scrollPane0 = new JScrollPane(textArea0);
        scrollPane0.setBounds(20, 100, 350, 630);
        panel.add(scrollPane0);

        JTextArea textArea1 = new JTextArea();
        JScrollPane scrollPane1 = new JScrollPane(textArea1);
        scrollPane1.setBounds(500, 100, 350, 630);
        panel.add(scrollPane1);



        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(null);
        buttonPanel.setBounds(350, 100, 150, 600);
        panel.add(buttonPanel);

        JButton cleanTextArea0Button = new JButton("<清空");
        cleanTextArea0Button.setBounds(20, 40, 70, 25);
        buttonPanel.add(cleanTextArea0Button);

        JButton copyTextArea0Button = new JButton("<复制");
        copyTextArea0Button.setBounds(20, 80, 70, 25);
        buttonPanel.add(copyTextArea0Button);

        JButton pasteTextArea0Button = new JButton("<粘贴");
        pasteTextArea0Button.setBounds(20, 120, 70, 25);
        buttonPanel.add(pasteTextArea0Button);

        JButton cleanTextArea1Button = new JButton("清空>");
        cleanTextArea1Button.setBounds(80, 440, 70, 25);
        buttonPanel.add(cleanTextArea1Button);

        JButton copyTextArea1Button = new JButton("复制>");
        copyTextArea1Button.setBounds(80, 480, 70, 25);
        buttonPanel.add(copyTextArea1Button);

        JButton pasteTextArea1Button = new JButton("粘贴>");
        pasteTextArea1Button.setBounds(80, 520, 70, 25);
        buttonPanel.add(pasteTextArea1Button);

        JButton addTextButton = new JButton("添加>>");
        addTextButton.setBounds(50, 200, 80, 25);
        buttonPanel.add(addTextButton);

        JButton removeTextButton = new JButton("<<去除");
        removeTextButton.setBounds(50, 280, 80, 25);
        buttonPanel.add(removeTextButton);

        JButton removeTextButton2 = new JButton("<<去除(Tab)");
        removeTextButton2.setBounds(35, 320, 105, 25);
        buttonPanel.add(removeTextButton2);

        JButton updateSqlButton0 = new JButton("<<去除2");
        updateSqlButton0.setBounds(40, 360, 100, 25);
        buttonPanel.add(updateSqlButton0);




        Panel footPanel = new Panel();
        footPanel.setLayout(null);
        footPanel.setBounds(0, 700, 900, 60);
        panel.add(footPanel);

        JLabel timeLabel = new JLabel("最后修改时间：2017-05-26");
        timeLabel.setBounds(20, 0, 200, 25);
        footPanel.add(timeLabel);

        JLabel maderLabel = new JLabel("made by yc");
        maderLabel.setBounds(800, 0, 100, 25);
        footPanel.add(maderLabel);


        cleanTextArea0Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea0.setText("");
            }
        });

        cleanTextArea1Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea1.setText("");
            }
        });

        copyTextArea0Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                copyText(textArea0);
            }
        });

        copyTextArea1Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                copyText(textArea1);
            }
        });

        pasteTextArea0Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pasteText(textArea0);
            }
        });

        pasteTextArea1Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pasteText(textArea1);
            }
        });

        addTextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea0Append(textArea0, textArea1, beforeTextField, afterTextField, replaceValuesCheckBox);
            }
        });


        removeTextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea1Remove(textArea0, textArea1, beforeTextField, afterTextField);
            }
        });

        removeTextButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea1Remove2(textArea0, textArea1, beforeTextField, afterTextField);
            }
        });

        resetTextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetText(beforeTextField, afterTextField);
            }
        });

        lazyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lazy(textArea0, textArea1, beforeTextField, afterTextField, replaceValuesCheckBox);
            }
        });


        updateSqlButton0.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea1Remove3(textArea0, textArea1, beforeTextField, afterTextField);
            }
        });



        //随窗口大小调整控件
        panel.addComponentListener(new ComponentListener() {

            @Override
            public void componentShown(ComponentEvent e) {

            }

            @Override
            public void componentResized(ComponentEvent e) {
                int width = panel.getWidth();
                int height = panel.getHeight();
                scrollPane0.setBounds(20, 100, (width-200)/2, height-130);
                scrollPane1.setBounds((width-200)/2+150, 100, (width-200)/2, height-130);
                buttonPanel.setBounds((width-200)/2, 100, 150, height-160);

                footPanel.setBounds(0, (height-30), width, 30);
                timeLabel.setBounds(20, 0, 200, 25);
                maderLabel.setBounds((width-100), 0, 100, 25);
            }

            @Override
            public void componentMoved(ComponentEvent e) {

            }

            @Override
            public void componentHidden(ComponentEvent e) {

            }
        });
    }


    /**
     * 复制
     * @param textArea
     */
    public static void copyText(JTextArea textArea){
        StringBuffer resultStr = new StringBuffer();
        try {
            BufferedReader br = new BufferedReader(new StringReader(textArea.getText()));
            String temp = br.readLine();
            while(temp != null){
                if(temp.trim().length()!=0){
                    resultStr.append(temp);
                    resultStr.append("\n");
                }
                temp = br.readLine();
            }
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            StringSelection selection = new StringSelection(resultStr.toString());
            clipboard.setContents(selection, null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 粘贴
     * @param textArea
     */
    public static void pasteText(JTextArea textArea){
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        DataFlavor flavor = DataFlavor.stringFlavor;
        if(clipboard.isDataFlavorAvailable(flavor)){//是否符合剪贴板的数据类型
            try {
                String pasteStr = clipboard.getData(flavor).toString();
                textArea.setText(pasteStr);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * @param textArea0
     * @param textArea1
     * @param beforeTextField
     * @param afterTextField
     */
    public static void textArea0Append(JTextArea textArea0, JTextArea textArea1, JTextField beforeTextField, JTextField afterTextField, JCheckBox checkBox){
        boolean flag = checkBox.isSelected();

        StringBuffer resultStr = new StringBuffer();
        try {
            BufferedReader br = new BufferedReader(new StringReader(textArea0.getText()));
            String temp = br.readLine();
            String beforeText = beforeTextField.getText();
            String afterText = afterTextField.getText();
            while(temp != null){
                if(temp.trim().length()!=0){
                    if(flag){
                        temp = temp.replaceAll("''", "?");
                        String splitTemp[] = temp.split("'");
                        temp = "";
                        for(int i=0; i<splitTemp.length; i++){
                            if(i%2!=0)temp+="?";
                            else temp+=splitTemp[i];
                        }
                    }
                    resultStr.append(beforeText);
                    resultStr.append(temp);
                    resultStr.append(afterText);
                    resultStr.append("\n");
                }
                temp = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        textArea1.setText(resultStr.toString());
    }

    /**
     * @param textArea0
     * @param textArea1
     * @param beforeTextField
     * @param afterTextField
     */
    public static void textArea1Remove(JTextArea textArea0, JTextArea textArea1, JTextField beforeTextField, JTextField afterTextField){
        StringBuffer resultStr = new StringBuffer();
        try {
            BufferedReader br = new BufferedReader(new StringReader(textArea1.getText()));
            String temp = br.readLine();
            String beforeText = beforeTextField.getText();
            String afterText = afterTextField.getText();
            while(temp != null){
                temp = replaceFirst(temp, beforeText, "");
                temp = replaceLast(temp, afterText, "");
                resultStr.append(temp);
                resultStr.append("\n");
                temp = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        textArea0.setText(resultStr.toString());
    }

    public static void lazy(JTextArea textArea0, JTextArea textArea1, JTextField beforeTextField, JTextField afterTextField, JCheckBox checkBox){
        try {
            boolean flag = checkBox.isSelected();
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            DataFlavor flavor = DataFlavor.stringFlavor;
            if(clipboard.isDataFlavorAvailable(flavor)){//是否符合剪贴板的数据类型
                StringBuffer resultStr = new StringBuffer();
                String pasteStr = clipboard.getData(flavor).toString();
                textArea0.setText(pasteStr);

                String beforeText = beforeTextField.getText();
                String afterText = afterTextField.getText();

                String[] temps = pasteStr.split("\n");
                for(String temp : temps){
                    if(temp.trim().length()!=0){
                        if(flag){
                            temp = temp.replaceAll("''", "?");
                            String splitTemp[] = temp.split("'");
                            temp = "";
                            for(int i=0; i<splitTemp.length; i++){
                                if(i%2!=0)temp+="?";
                                else temp+=splitTemp[i];
                            }
                        }
                        resultStr.append(beforeText);
                        resultStr.append(temp);
                        resultStr.append(afterText);
                        resultStr.append("\n");
                    }

                }
                textArea1.setText(resultStr.toString());

                StringSelection selection = new StringSelection(resultStr.toString());
                clipboard.setContents(selection, null);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void textArea1Remove2(JTextArea textArea0, JTextArea textArea1, JTextField beforeTextField, JTextField afterTextField){
        StringBuffer resultStr = new StringBuffer();
        try {
            BufferedReader br = new BufferedReader(new StringReader(textArea1.getText()));
            String temp = br.readLine();
            String beforeText = beforeTextField.getText();
            String afterText = afterTextField.getText();
            while(temp != null){
                temp = replaceFirst(temp, beforeText, "");
                temp = replaceLast(temp, afterText, "");
                temp = temp.replaceAll("\t", "");
                resultStr.append(temp);
                resultStr.append("\n");
                temp = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        textArea0.setText(resultStr.toString());
    }


    public static void textArea1Remove3(JTextArea textArea0, JTextArea textArea1, JTextField beforeTextField, JTextField afterTextField){
        StringBuffer resultStr = new StringBuffer();
        try {
            BufferedReader br = new BufferedReader(new StringReader(textArea1.getText()));
            String beforeText = beforeTextField.getText();
            String afterText = afterTextField.getText();
            String temp = br.readLine();
            while(temp != null){
//				temp = temp.trim();
                if(temp.trim().length()!=0){
                    if(temp.indexOf("CheckUtil")==-1 && temp.indexOf("sqlClient")==-1 && temp.indexOf("}")==-1){
                        temp = replaceFirst(temp, beforeText, "");
                        temp = replaceLast(temp, afterText, "");
                        temp = temp.replaceAll("\t", "");
                        resultStr.append(temp);
                        resultStr.append("\n");
                    }
                }
                temp = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        textArea0.setText(resultStr.toString());
    }

    public static void resetText(JTextField beforeTextField, JTextField afterTextField){
        beforeTextField.setText("sql.append(\" ");
        afterTextField.setText(" \");");
    }

    public static String replaceLast(String str, String oldStr, String newStr){
        int index = str.lastIndexOf(oldStr);
        if(index == -1){
            return str;
        }else{
            String str0 = str.substring(0, index);
            String str1 = str.substring(index + oldStr.length());
            return str0 + newStr + str1;
        }
    }

    public static String replaceFirst(String str, String oldStr, String newStr){
        int index = str.indexOf(oldStr);
        if(index == -1){
            return str;
        }else{
            String str1 = str.substring(index+oldStr.length());
            String str0 = str.substring(0, index);
            return str0 + newStr + str1;
        }
    }

}
