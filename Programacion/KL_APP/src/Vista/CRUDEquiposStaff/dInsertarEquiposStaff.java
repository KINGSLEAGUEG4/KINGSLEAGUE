package Vista.CRUDEquiposStaff;

import Controlador.Main;

import javax.swing.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class dInsertarEquiposStaff extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField tfSueldo;
    private JTextField tfFechaInicio;
    private JComboBox cbEquipo;
    private JComboBox cbStaff;
    private JTextField tfFechaFin;

    public dInsertarEquiposStaff() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        inicializar();

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

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
        buttonOK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    Main.insertarStaffEquipos(cbEquipo.getSelectedItem().toString(),cbStaff.getSelectedItem().toString(),tfFechaInicio.getText(),tfFechaFin.getText(),tfSueldo.getText());
                    JOptionPane.showMessageDialog(null,"Se ha insertado correctamente");
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
        dInsertarEquiposStaff dialog = new dInsertarEquiposStaff();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }

    public void inicializar() {
        try {
            ArrayList<String> idCBox = Main.crearStaffEquipoID();
            idCBox.forEach(id ->cbEquipo.addItem(id));
        } catch (Exception exc) {
            System.out.println("problemas");
        }
        try {
            ArrayList<String> idCBox = Main.crearStaffEquipoID2();
            idCBox.forEach(id ->cbStaff.addItem(id));
        } catch (Exception exc) {
            System.out.println("problemas");
        }
    }
}
