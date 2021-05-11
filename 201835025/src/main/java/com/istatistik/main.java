/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.istatistik;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

public class main {

    private JFrame frame;
    private JPanel panel1;
    private JPanel panel2;
    private JPanel panel3;
    private JPanel panel4;
    private JLabel adLabel;
    private JLabel soyadLabel;
    private JLabel cinsiyetLabel;
    private JLabel yasLabel;
    private JTextField adField;
    private JTextField soyadField;
    private JComboBox cinsiyetField;
    private JTextField yasField;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private final Font font = new Font("SansSerif", Font.BOLD, 20);

    private model m = new model();

    public void main() {
    }

    public void panel1() {

        panel1 = new JPanel();
        panel1.setLayout(new BoxLayout(panel1, BoxLayout.PAGE_AXIS));
        panel1.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
        panel1.setBackground(Color.decode("#19232d"));

        adLabel = new JLabel("AD");
        adLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        adLabel.setForeground(Color.WHITE);
        adField = new JTextField();
        adField.setFont(font);

        adField.setAlignmentX(Component.CENTER_ALIGNMENT);
        adField.setMaximumSize(new Dimension(Integer.MAX_VALUE, adField.getPreferredSize().height));

        soyadLabel = new JLabel("SOYAD");
        soyadLabel.setForeground(Color.WHITE);
        soyadLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        soyadField = new JTextField();
        soyadField.setFont(font);
        soyadField.setMaximumSize(new Dimension(Integer.MAX_VALUE, adField.getPreferredSize().height));

        String[] cinsiyetStr = {"Erkek", "Kadın"};
        cinsiyetLabel = new JLabel("CİNSİYET");
        cinsiyetLabel.setForeground(Color.WHITE);
        cinsiyetLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        cinsiyetField = new JComboBox(cinsiyetStr);
        cinsiyetField.setMaximumSize(new Dimension(Integer.MAX_VALUE, adField.getPreferredSize().height));

        yasLabel = new JLabel("YAŞ");
        yasLabel.setForeground(Color.WHITE);
        yasLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        yasField = new JTextField();
        yasField.setFont(font);
        yasField.setMaximumSize(new Dimension(Integer.MAX_VALUE, adField.getPreferredSize().height));
        ((AbstractDocument) yasField.getDocument()).setDocumentFilter(new DocumentFilter() {
            Pattern regEx = Pattern.compile("\\d*");

            @Override
            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                Matcher matcher = regEx.matcher(text);
                if (!matcher.matches()) {
                    return;
                }
                super.replace(fb, offset, length, text, attrs);
            }
        });

        button1 = new JButton("İleri");
        button1.setAlignmentX(Component.CENTER_ALIGNMENT);
        button1.setForeground(Color.WHITE);
        button1.setFont(font);
//        button1.setOpaque(true);
//        button1.setBackground(Color.decode("#008287"));       
        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                m.setAd(adField.getText());
                m.setSoyad(soyadField.getText());
                m.setCinsiyet(cinsiyetStr[cinsiyetField.getSelectedIndex()]);
                m.setYas(Integer.parseInt(yasField.getText()));
                panel2();
            }
        });
        panel1.add(adLabel);
        panel1.add(adField);
        panel1.add(Box.createRigidArea(new Dimension(0, 5)));
        panel1.add(soyadLabel);
        panel1.add(soyadField);
        panel1.add(Box.createRigidArea(new Dimension(0, 5)));
        panel1.add(cinsiyetLabel);
        panel1.add(cinsiyetField);
        panel1.add(Box.createRigidArea(new Dimension(0, 5)));
        panel1.add(yasLabel);
        panel1.add(yasField);
        panel1.add(Box.createRigidArea(new Dimension(0, 5)));
        panel1.add(button1);

        frame.getContentPane().add(panel1);
        frame.pack();
        frame.setVisible(true);
    }

    public void panel2() {
        frame.getContentPane().removeAll();

        panel2 = new JPanel();
        panel2.setLayout(new BoxLayout(panel2, BoxLayout.PAGE_AXIS));
        panel2.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
        panel2.setBackground(Color.decode("#19232d"));

        JRadioButton cikolatali = new JRadioButton("Çikolatalı");
        JRadioButton muzlu = new JRadioButton("Muzlu");
        JRadioButton cilekli = new JRadioButton("Çilekli");
        JRadioButton portakalli = new JRadioButton("Portakallı");
        JRadioButton frambuazli = new JRadioButton("Frambuazlı");

        JRadioButton puan1 = new JRadioButton("1");
        JRadioButton puan2 = new JRadioButton("2");
        JRadioButton puan3 = new JRadioButton("3");
        JRadioButton puan4 = new JRadioButton("4");
        JRadioButton puan5 = new JRadioButton("5");

        puan1.setFont(font);
        puan2.setFont(font);
        puan3.setFont(font);
        puan4.setFont(font);
        puan5.setFont(font);

        puan1.setForeground(Color.WHITE);
        puan2.setForeground(Color.WHITE);
        puan3.setForeground(Color.WHITE);
        puan4.setForeground(Color.WHITE);
        puan5.setForeground(Color.WHITE);

        Box group = Box.createHorizontalBox();

        group.add(puan1);
        group.add(puan2);
        group.add(puan3);
        group.add(puan4);
        group.add(puan5);

        button2 = new JButton("İleri");
        button2.setFont(font);
        button2.setAlignmentX(Component.CENTER_ALIGNMENT);
        button2.setForeground(Color.WHITE);
        button2.addActionListener((ActionEvent e) -> {
            if (cikolatali.isSelected()) {
                m.setPasta(cikolatali.getText());
            } else if (muzlu.isSelected()) {
                m.setPasta(muzlu.getText());
            } else if (cilekli.isSelected()) {
                m.setPasta(cilekli.getText());
            } else if (portakalli.isSelected()) {
                m.setPasta(portakalli.getText());
            } else if (frambuazli.isSelected()) {
                m.setPasta(frambuazli.getText());
            }

            if (puan1.isSelected()) {
                m.setPastaPuan(1);
            } else if (puan2.isSelected()) {
                m.setPastaPuan(2);
            } else if (puan3.isSelected()) {
                m.setPastaPuan(3);
            } else if (puan4.isSelected()) {
                m.setPastaPuan(4);
            } else if (puan5.isSelected()) {
                m.setPastaPuan(5);
            }
            panel3();
        });

        cikolatali.setFont(font);
        muzlu.setFont(font);
        cilekli.setFont(font);
        portakalli.setFont(font);
        frambuazli.setFont(font);

        cikolatali.setAlignmentX(Component.CENTER_ALIGNMENT);
        muzlu.setAlignmentX(Component.CENTER_ALIGNMENT);
        cilekli.setAlignmentX(Component.CENTER_ALIGNMENT);
        portakalli.setAlignmentX(Component.CENTER_ALIGNMENT);
        frambuazli.setAlignmentX(Component.CENTER_ALIGNMENT);

        cikolatali.setForeground(Color.WHITE);
        muzlu.setForeground(Color.WHITE);
        cilekli.setForeground(Color.WHITE);
        portakalli.setForeground(Color.WHITE);
        frambuazli.setForeground(Color.WHITE);

        panel2.add(cikolatali);
        panel2.add(Box.createRigidArea(new Dimension(5, 20)));
        panel2.add(muzlu);
        panel2.add(Box.createRigidArea(new Dimension(5, 20)));
        panel2.add(cilekli);
        panel2.add(Box.createRigidArea(new Dimension(5, 20)));
        panel2.add(portakalli);
        panel2.add(Box.createRigidArea(new Dimension(5, 20)));
        panel2.add(frambuazli);
        panel2.add(Box.createRigidArea(new Dimension(5, 50)));
        panel2.add(group);
        panel2.add(Box.createRigidArea(new Dimension(5, 20)));
        panel2.add(button2);

        frame.getContentPane().add(panel2);
        frame.revalidate();
        frame.repaint();

    }

    public void panel3() {
        frame.getContentPane().removeAll();

        panel3 = new JPanel();
        panel3.setLayout(new BoxLayout(panel3, BoxLayout.PAGE_AXIS));
        panel3.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
        panel3.setBackground(Color.decode("#19232d"));

        JRadioButton kola = new JRadioButton("Kola");
        JRadioButton limonata = new JRadioButton("Limonata");
        JRadioButton su = new JRadioButton("Kahve");

        Box group = Box.createHorizontalBox();

        JRadioButton puan1 = new JRadioButton("1");
        JRadioButton puan2 = new JRadioButton("2");
        JRadioButton puan3 = new JRadioButton("3");
        JRadioButton puan4 = new JRadioButton("4");
        JRadioButton puan5 = new JRadioButton("5");

        puan1.setFont(font);
        puan2.setFont(font);
        puan3.setFont(font);
        puan4.setFont(font);
        puan5.setFont(font);

        puan1.setForeground(Color.WHITE);
        puan2.setForeground(Color.WHITE);
        puan3.setForeground(Color.WHITE);
        puan4.setForeground(Color.WHITE);
        puan5.setForeground(Color.WHITE);

        group.add(puan1);
        group.add(puan2);
        group.add(puan3);
        group.add(puan4);
        group.add(puan5);

        button3 = new JButton("Kaydet");
        button3.setFont(font);
        button3.setForeground(Color.WHITE);
        button3.addActionListener((ActionEvent e) -> {
            if (kola.isSelected()) {
                m.setIcecek(kola.getText());
            } else if (limonata.isSelected()) {
                m.setIcecek(limonata.getText());
            } else if (su.isSelected()) {
                m.setIcecek(su.getText());
            }

            if (puan1.isSelected()) {
                m.setIcecekPuan(1);
            } else if (puan2.isSelected()) {
                m.setIcecekPuan(2);
            } else if (puan3.isSelected()) {
                m.setIcecekPuan(3);
            } else if (puan4.isSelected()) {
                m.setIcecekPuan(4);
            } else if (puan5.isSelected()) {
                m.setIcecekPuan(5);
            }
            database.kaydet(m);
            panel4();
        });

        kola.setFont(font);
        limonata.setFont(font);
        su.setFont(font);

        button3.setAlignmentX(Component.CENTER_ALIGNMENT);
        kola.setAlignmentX(Component.CENTER_ALIGNMENT);
        limonata.setAlignmentX(Component.CENTER_ALIGNMENT);
        su.setAlignmentX(Component.CENTER_ALIGNMENT);

        kola.setForeground(Color.WHITE);
        limonata.setForeground(Color.WHITE);
        su.setForeground(Color.WHITE);

        panel3.add(kola);
        panel3.add(Box.createRigidArea(new Dimension(5, 20)));
        panel3.add(limonata);
        panel3.add(Box.createRigidArea(new Dimension(5, 20)));
        panel3.add(su);
        panel3.add(Box.createRigidArea(new Dimension(5, 50)));
        panel3.add(group);
        panel3.add(Box.createRigidArea(new Dimension(5, 20)));
        panel3.add(button3);

        frame.getContentPane().add(panel3);
        frame.revalidate();
        frame.repaint();
    }

    public void panel4() {
        frame.getContentPane().removeAll();

        panel4 = new JPanel();
        panel4.setLayout(new BoxLayout(panel4, BoxLayout.PAGE_AXIS));
        panel4.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
        panel4.setBackground(Color.decode("#19232d"));

        button4 = new JButton("Yeni Kayıt");
        button4.setFont(font);
        button4.setForeground(Color.WHITE);
        button4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                m = new model();
                panel1();
                frame.revalidate();
                frame.repaint();
            }
        });

        JLabel ad = new JLabel("AD: " + m.getAd());
        JLabel soyad = new JLabel("SOYAD: " + m.getSoyad());
        JLabel cinsiyet = new JLabel("CINSIYET: " + m.getCinsiyet());
        JLabel yas = new JLabel("YAS: " + m.getYas());
        JLabel pasta = new JLabel("PASTA: " + m.getPasta());
        JLabel icecek = new JLabel("ICECEK: " + m.getIcecek());
        JLabel pastaPuan = new JLabel("PASTA PUANI: " + m.getPastaPuan());
        JLabel icecekPuan = new JLabel("İÇEÇEK PUANI: " + m.getIcecekPuan());

        ad.setFont(font);
        soyad.setFont(font);
        cinsiyet.setFont(font);
        yas.setFont(font);
        pasta.setFont(font);
        icecek.setFont(font);
        pastaPuan.setFont(font);
        icecekPuan.setFont(font);

        ad.setForeground(Color.WHITE);
        soyad.setForeground(Color.WHITE);
        cinsiyet.setForeground(Color.WHITE);
        yas.setForeground(Color.WHITE);
        pasta.setForeground(Color.WHITE);
        icecek.setForeground(Color.WHITE);
        pastaPuan.setForeground(Color.WHITE);
        icecekPuan.setForeground(Color.WHITE);

        panel4.add(ad);
        panel4.add(Box.createRigidArea(new Dimension(5, 20)));
        panel4.add(soyad);
        panel4.add(Box.createRigidArea(new Dimension(5, 20)));
        panel4.add(cinsiyet);
        panel4.add(Box.createRigidArea(new Dimension(5, 20)));
        panel4.add(yas);
        panel4.add(Box.createRigidArea(new Dimension(5, 20)));
        panel4.add(pasta);
        panel4.add(Box.createRigidArea(new Dimension(5, 20)));
        panel4.add(icecek);
        panel4.add(Box.createRigidArea(new Dimension(5, 20)));
        panel4.add(pastaPuan);
        panel4.add(Box.createRigidArea(new Dimension(5, 20)));
        panel4.add(icecekPuan);
        panel4.add(Box.createRigidArea(new Dimension(5, 20)));
        panel4.add(button4);

        frame.getContentPane().add(panel4);
        frame.revalidate();
        frame.repaint();

    }

    public void initialize() {
        frame = new JFrame("LaCharlie Coffee House");
        frame.setPreferredSize(new Dimension(800, 600));
        frame.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String args[]) {

        main main = new main();
        main.initialize();
        main.panel1();
    }

}
