package tugas;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ignored) {
        }
        ImageIcon imageIcon = new ImageIcon("res/icon sort.jpg");
        JFrame jFrame = new JFrame("Program Sorting Angka");
        jFrame.setIconImage(imageIcon.getImage());
        jFrame.setContentPane(new form_sorting().getForm());
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setSize(500, 400);
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);
    }
}
