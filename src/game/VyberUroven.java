package game;

import menu.MenuScitok;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;

public class VyberUroven extends JPanel {
    private JPanel tlacidloPanel;
    private ButtonGroup skupina;
    private LevelPozadie vlastnik;
    private final Level DEFAULTNY_LEVEL = Level.Ľahká;

    public VyberUroven(LevelPozadie vlastnik) {
        this.vlastnik = vlastnik;
        vlastnik.setLevel(DEFAULTNY_LEVEL);
        setOpaque(false);

        MenuScitok oknoSpravy = new MenuScitok("Vyber si úroveň:", new Font("Arial", Font.BOLD | Font.ITALIC, 45), Color.orange);
        oknoSpravy.setBorder(new EmptyBorder(60, 20, 30, 20));
        add(oknoSpravy, BorderLayout.CENTER);

        tlacidloPanel = new JPanel();
        skupina = new ButtonGroup();

        addUrovenTlacidlo("Ľahká", Level.Ľahká);
        addUrovenTlacidlo("Stredná", Level.Stredná);
        addUrovenTlacidlo("Ťažká", Level.Ťažká);
        addUrovenTlacidlo("Expert", Level.Expert);

        tlacidloPanel.setOpaque(false);
        add(tlacidloPanel, BorderLayout.SOUTH);
    }

    public void addUrovenTlacidlo(String nazov, Level level) {
        boolean vybrane = level == DEFAULTNY_LEVEL;

        JRadioButton tlacidlo2 = new JRadioButton(nazov, vybrane);
        tlacidlo2.setFont(new Font(Font.MONOSPACED, Font.BOLD, 40));
        tlacidlo2.setForeground(Color.WHITE);
        tlacidlo2.setFocusPainted(false);
        tlacidlo2.setCursor(new Cursor(Cursor.HAND_CURSOR));

        tlacidlo2.setIcon(new ImageIcon(getClass().getResource("/resources/images/BielaBodka.png")));
        tlacidlo2.setSelectedIcon(new ImageIcon(getClass().getResource("/resources/images/ZelenaBodka.png")));
        tlacidlo2.setBorder(new EmptyBorder(0, 17, 0, 22));

        skupina.add(tlacidlo2);

        tlacidlo2.setOpaque(false);
        tlacidloPanel.add(tlacidlo2);

        ActionListener listener = event -> vlastnik.setLevel(level);
        tlacidlo2.addActionListener(listener);
    }
}
