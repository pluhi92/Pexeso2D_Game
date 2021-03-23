package game;

import menu.MenuKomponenty;
import menu.MenuScitok;
import menu.MenuTlacidlo;

import javax.swing.*;
import java.awt.*;

public class VychodDialog extends Pozadie {
    private MenuScitok menuScitok;
    private MenuTlacidlo tlacidloPokracuj;
    private MenuTlacidlo tlacidloDoMenu;
    private MenuTlacidlo tlacidloVychod;
    private final Dimension TLACIDLO_VELKOST = new Dimension(300, 60);

    public VychodDialog(String titulok) {
        super(titulok);

        setUndecorated(false);

        String spravaCoUrobit = "Čo si želáte urobiť?";
        menuScitok = new MenuScitok(spravaCoUrobit, new Font(Font.SANS_SERIF, Font.BOLD, 45), Color.orange);

        super.getPanel().add(menuScitok, BorderLayout.CENTER);
        addButtonPanel();

        pack();
    }

    public void addButtonPanel() {
        tlacidloPokracuj = new MenuTlacidlo("Pokračovať", new Color(138, 200, 114, 255), 35, TLACIDLO_VELKOST);
        tlacidloDoMenu = new MenuTlacidlo("Navrat do menu", new Color(132, 197, 200), 35, TLACIDLO_VELKOST);
        tlacidloVychod = new MenuTlacidlo("Opustiť hru", new Color(200, 100, 100), 35, TLACIDLO_VELKOST);


        tlacidloPokracuj.addActionListener((event) -> {
            setVisible(false);
            if (!PouzivatelskyPanel.isPauza()) {
                HernyEngine.setHranie(true);
                PouzivatelskyPanel.getCasovac().setCasBezi(true);
            }
        });

        tlacidloDoMenu.addActionListener((event) -> {
            setVisible(false);
            PametovyRamec pametovyR = PametovyRamec.getInstanceOf();
            pametovyR.getContentPane().removeAll();
            pametovyR.add(new MenuKomponenty());
            pametovyR.revalidate();
            pametovyR.repaint();
        });

        tlacidloVychod.addActionListener(event -> System.exit(0));

        JPanel tlacidloPanel = new JPanel();
        tlacidloPanel.add(tlacidloPokracuj);
        tlacidloPanel.add(tlacidloDoMenu);
        tlacidloPanel.add(tlacidloVychod);
        tlacidloPanel.setOpaque(false);
        super.getPanel().add(tlacidloPanel, BorderLayout.SOUTH);
    }
}
