package form;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomePage {
    private JPanel baseJPanel;
    private JPanel choose;
    private JButton QUERYButton;
    private JButton MANAGEButton;
    private JButton CHECKButton;
    private JButton BOOKButton;
    public HomePage() {
        BOOKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame bookFrame = new JFrame("BookPage");
                bookFrame.setContentPane(new BookPage().getPanel());
                bookFrame.pack();
                bookFrame.setVisible(true);
            }
        });

        QUERYButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 打开查询界面
                JFrame queryFrame = new JFrame("QueryPage");
                queryFrame.setContentPane(new QueryPage().getPanel());
                queryFrame.pack();
                queryFrame.setVisible(true);
            }
        });

        MANAGEButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 打开管理界面
                JFrame manageFrame = new JFrame("ManagePage");
                manageFrame.setContentPane(new ManagePage().getPanel());
                manageFrame.pack();
                manageFrame.setVisible(true);
            }
        });
        CHECKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 打开查询界面
                JFrame queryFrame = new JFrame("CheckPage");
                queryFrame.setContentPane(new CheckPage().getPanel());
                queryFrame.pack();
                queryFrame.setVisible(true);
            }
        });

    }
    public static void main(String[] args) {
        JFrame frame = new JFrame("form");
        frame.setContentPane(new HomePage().baseJPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
