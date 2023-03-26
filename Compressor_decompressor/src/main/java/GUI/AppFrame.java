package GUI;

import comp_decomp.compressor;
import comp_decomp.decompressor;

import javax.imageio.IIOException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class AppFrame extends JFrame implements ActionListener {
    JButton compressButton;
    JButton decompressButton;

    AppFrame() {
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Compressor and Decompressor");
        this.setResizable(false);
        this.setLocation(490,200);
        JLabel heading = new JLabel("Hello User, ");
        JLabel heading2 = new JLabel("Select the file to Compress/Decompress.");
        heading.setBounds(230,50,300,30);
        heading2.setBounds(100,90,500,30);
        heading.setFont(new Font("Arial",Font.BOLD,20));
        heading2.setFont(new Font("Arial",Font.BOLD,20));
        this.add(heading);
        this.add(heading2);
        compressButton = new JButton("Compress");
        compressButton.setBounds(60, 180, 200, 30);
        compressButton.addActionListener(this);
        decompressButton = new JButton("Decompress");
        decompressButton.setBounds(320, 180, 200, 30);
        decompressButton.addActionListener(this);
        this.add(compressButton);
        this.add(decompressButton);
        this.setSize(600, 400);
        this.getContentPane().setBackground(Color.gray);

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == compressButton) {
            JFileChooser fileChooser = new JFileChooser();
            int response = fileChooser.showSaveDialog(null);
            if (response == JFileChooser.APPROVE_OPTION) {
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                System.out.print(file);
                try {
                    compressor.method(file);
                } catch (Exception ee) {
                    JOptionPane.showMessageDialog(null, ee.toString());
                }
            }

        }
        if (e.getSource() == decompressButton) {
            JFileChooser fileChooser = new JFileChooser();
            int response = fileChooser.showSaveDialog(null);
            if (response == JFileChooser.APPROVE_OPTION) {
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                System.out.print(file);
                try {
                    decompressor.method(file);
                } catch (Exception ee) {
                    JOptionPane.showMessageDialog(null, ee.toString());
                }
            }
        }
    }
}
