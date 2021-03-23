package game;

import menu.MenuTlacidlo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LevelPozadie extends Pozadie {
    private Level level;
    private boolean vybrany;

    public LevelPozadie() {
        super("Nová hra");

        getPanel().add(new VyberUroven(this), BorderLayout.CENTER);
        addNovaHraTlacidlo();

        pack();
    }

    public void addNovaHraTlacidlo() {
        MenuTlacidlo hrajHru = new MenuTlacidlo("Hraj hru", new Color(0x8D8A8D), 36, new Dimension(180, 65));

        hrajHru.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                vybrany = true;
                LevelPozadie.this.setVisible(false);
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(hrajHru);
        buttonPanel.setOpaque(false);

        getPanel().add(buttonPanel, BorderLayout.SOUTH);
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public boolean isVybrany() {
        return vybrany;
    }

    public void setVybrany(boolean vybrany) {
        this.vybrany = vybrany;
    }
}
