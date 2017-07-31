package common.util.search.ui;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import common.util.search.FileSearchResult;
import common.util.search.LineSearchResult;
import common.util.search.SearchUtil;

public class SearchUI {

    public static void main(String[] args) {
        // 创建 JFrame 实例
        JFrame frame = new JFrame("搜索");
        // Setting the width and height of frame
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setSize(screenSize.width / 2, screenSize.height / 2);
        frame.setLocation(screenSize.width / 4, screenSize.height / 4);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /*
         * 创建面板，这个类似于 HTML 的 div 标签 我们可以创建多个面板并在 JFrame 中指定位置 面板中我们可以添加文本字段，按钮及其他组件。
         */
        JPanel panel = new JPanel();
        // 添加面板
        frame.add(panel);
        /*
         * 调用用户定义的方法并添加组件到面板
         */
        placeComponents(panel);

        // 设置界面可见
        frame.setVisible(true);
    }

    private static void placeComponents(JPanel panel) {

        panel.setLayout(null);

        panel.add(generateJLabel("绝对路径", 10, 20, 80, 25));
        JTextField dirText = addJTextField(panel, 80, 20, 200, 25);
        panel.add(generateJLabel("关键词", 10, 50, 80, 25));
        JTextField keywordText = addJTextField(panel, 80, 50, 200, 25);
        panel.add(generateJLabel("扩展名", 310, 20, 80, 25));
        JTextField suffixText = addJTextField(panel, 360, 20, 200, 25);
        JTextArea textArea = new JTextArea();
        textArea.setBounds(10, 120, 650, 300);
        JScrollPane scroll = new JScrollPane(textArea);
        scroll.setBounds(10, 120, 650, 220);
        panel.add(scroll);

        JCheckBox recursionCheckBox = new JCheckBox("子目录");
        recursionCheckBox.setBounds(310, 50, 100, 25);
        panel.add(recursionCheckBox);

        JCheckBox caseCheckBox = new JCheckBox("区分大小写");
        caseCheckBox.setBounds(410, 50, 100, 25);
        panel.add(caseCheckBox);

        // JOptionPane.showConfirmDialog(null, "123");
        // 创建登录按钮
        JButton searchButton = new JButton("search");
        searchButton.setBounds(10, 80, 80, 25);
        addListener(searchButton, dirText, keywordText, suffixText, textArea, recursionCheckBox, caseCheckBox);
        panel.add(searchButton);
    }

    private static JLabel generateJLabel(String name, int x, int y, int width, int height) {
        JLabel label = new JLabel(name);
        label.setBounds(x, y, width, height);
        return label;
    }

    private static JTextField addJTextField(JPanel panel, int x, int y, int width, int height) {
        JTextField text = new JTextField(20);
        text.setBounds(x, y, width, height);
        panel.add(text);
        return text;
    }

    private static void addListener(JButton searchButton, final JTextField dirText, final JTextField keywordText,
            final JTextField suffixText, final JTextArea resultText, final JCheckBox recursionCheckBox,
            final JCheckBox caseCheckBox) {
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //先清空之前的记录
                resultText.setText("");
                String dir = dirText.getText();
                dir = dir.replace('\\', '/');
                String key = keywordText.getText();
                String suffix = suffixText.getText();
                List<FileSearchResult> result =
                        SearchUtil.search(dir, key, suffix, recursionCheckBox.isSelected(), null,
                                caseCheckBox.isSelected());
                resultText.append(formatResult(result));
            }
        });
    }

    private static final String LINE_SEP = "\n";

    private static String formatResult(List<FileSearchResult> result) {
        StringBuilder sb = new StringBuilder();
        for (FileSearchResult fsr : result) {
            sb.append("----------------------" + LINE_SEP);
            sb.append("文件名称:" + fsr.getFileName() + LINE_SEP);
            for (LineSearchResult lsr : fsr.getMatchLines()) {
                sb.append(lsr.getLineNumber() + " " + lsr.getContent() + LINE_SEP);
            }
        }
        return sb.toString();
    }
}
