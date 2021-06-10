package tugas;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class form_sorting {
    private JTextField input;
    private JButton buttonCek;
    private JTable sorting;
    private JPanel form;
    private JTextField output;
    private DefaultTableModel tableModel;
    private boolean added = false;

    public form_sorting() {
        this.initComponents();
        buttonCek.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                DefaultTableModel model = (DefaultTableModel) sorting.getModel();
                String angka = input.getText();
                int jumlah = Integer.parseInt(output.getText());
                String[] tanda = angka.split(",");
                if (input.getText().length()>3){
                    JOptionPane.showMessageDialog(form,
                            "Data Terlalu Banyak\nMax Input : 999",
                            "Warning",
                            JOptionPane.WARNING_MESSAGE);
                    return;
                }
                if (tanda.length > jumlah || tanda.length < jumlah){
                    JOptionPane.showMessageDialog(form,
                            "Jumlah Angka Tidak Sesuai Limit yang DiInput",
                            "Warning",
                            JOptionPane.WARNING_MESSAGE);
                    return;
                }
                if (!added) {
                    for (int i = 0; i < jumlah; i++) {
                        model.addRow(new Object[]{});
                    }
                    added = true;
                }
                int a = 0;
                for (int i : sorting.getA(input, jumlah)){
                    model.setValueAt(i, a, 0);
                    a++;
                }
                int b = 0;
                for (int i : sorting.getdes(input, jumlah)){
                    model.setValueAt(i, b, 1);
                    b++;
                }
            }
        });
    }

    public JPanel getForm() {
        return form;
    }

    public form_sorting(JTextField input) {
        this.input = input;
    }

    private void initComponents() {
        Object[] tablecolom = {
                "ascending",
                "descending"
        };
        Object[][] initdata = {};
        tableModel = new DefaultTableModel(initdata, tablecolom);
        sorting.setModel(tableModel);
        sorting.setAutoCreateRowSorter(true);
        sorting.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

    }
}
