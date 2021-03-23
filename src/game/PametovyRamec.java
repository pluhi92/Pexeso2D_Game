package game;

import menu.MenuKomponenty;

import javax.swing.*;
import java.awt.*;

public class PametovyRamec extends JFrame {
    private static PametovyRamec ramec;

    public static final int DEFAULTNA_SIRKA = 1280;
    public static final int DEFAULTNA_VYSKA = 1024;

    private PametovyRamec() {
        setTitle("Pexeso");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);
        setIconImage(new ImageIcon(getClass().getResource("/resources/images/Mozog.png")).getImage());

        add(new MenuKomponenty());
        // pack();

        setSize(new Dimension(DEFAULTNA_SIRKA, DEFAULTNA_VYSKA));
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static PametovyRamec getInstanceOf() {
        if (ramec == null)
            ramec = new PametovyRamec();

        return ramec;
    }
}
