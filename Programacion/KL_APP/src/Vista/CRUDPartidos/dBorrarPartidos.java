package Vista.CRUDPartidos;

import Controlador.Main;

import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

public class dBorrarPartidos extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JButton bBorrar;
    private JComboBox cbID;

    public dBorrarPartidos() {
        try {
            ArrayList<String> idCBox = Main.crearIdEquipos();
            idCBox.forEach(id -> cbID.addItem(id));
        } catch (Exception exc) {
            System.out.println("problemas");
        }

        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);


        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);

        bBorrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Main.deletePartido(Integer.parseInt(cbID.getSelectedItem().toString()));
                    JOptionPane.showMessageDialog(null, "El Partido con ID " + cbID.getSelectedItem().toString() + " ha sido eliminado");
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }

    private void onOK() {
        // add your code here
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        dBorrarPartidos dialog = new dBorrarPartidos();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
