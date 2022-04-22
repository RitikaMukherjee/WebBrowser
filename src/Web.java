package src;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.io.*;
public class Web {
    private JFrame frame;
    private JPanel paneltop;
    private JEditorPane editor;
    private JScrollPane scroll;
    private JTextField field;
    private JButton button;
    private URL url;
    public Web(String title){
        initComponents();
        frame.setTitle(title);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(100,100,400,400);
        frame.add(BorderLayout.NORTH,paneltop);
        paneltop.add(field);
        paneltop.add(button);
        frame.add(BorderLayout.CENTER,scroll);
        frame.setVisible(true);
    }
    private void initComponents(){
        frame=new JFrame();
        paneltop=new JPanel();
        try {
            url=new URL("https://www.google.com/");
        } catch (MalformedURLException e) {
            //TODO: handle exception
            JOptionPane.showMessageDialog(null,e);
        }
        try {
            editor=new JEditorPane(url);
            editor.setEditable(false);
        } catch (IOException g) {
            //TODO: handle exception
            JOptionPane.showMessageDialog(null,g);
        }
        scroll=new JScrollPane(editor,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        field=new JTextField();
        SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                field.setText(url.toString());
            }
        });
        button=new JButton("GO");
        button.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                try {
                    editor.setPage(field.getText());
                } catch (IOException f) {
                    //TODO: handle exception
                    JOptionPane.showMessageDialog(null,f);
                }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                new Web("Simple Web Browser");
            }
        });
    }
}
