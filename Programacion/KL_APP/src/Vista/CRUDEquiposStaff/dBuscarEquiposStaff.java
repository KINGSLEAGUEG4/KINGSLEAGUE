package Vista.CRUDEquiposStaff;

import Controlador.Main;

import javax.swing.*;
import java.awt.event.*;

public class dBuscarEquiposStaff extends JDialog {
    private JPanel contentPane;
    private JButton consultar;
    private JButton buttonCancel;
    private JButton consultarTodosButton;
    private JPanel pTodos;
    private JTextArea taTodos;
    private JPanel pTitulo;
    private JButton bConsultar;
    private JTextArea taCJT;

    public dBuscarEquiposStaff() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(consultar);
        inicializar();

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
        bConsultar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String datos = Main.buscarTodosStaffEquipos();
                    taTodos.setText(datos);
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        consultarTodosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onOK();
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
        dBuscarEquiposStaff dialog = new dBuscarEquiposStaff();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }

    public void inicializar() {

        taTodos.setEditable(false);

        pTodos.add(new JScrollPane(taTodos));
        taTodos.setRows(20);
        taTodos.setColumns(40);
        taTodos.setLineWrap(true);
    }
}
