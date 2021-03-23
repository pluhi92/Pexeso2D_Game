package game;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PanelKariet extends JPanel {
    private List<Karta> karty;
    private Level level;
    private int kolkoKariet;

    public PanelKariet(Level level) {
        karty = new ArrayList<>();
        this.level = level;
        kolkoKariet = level.getKolkoKariet();

        vytvoritNastenku();
        vytvorKarty();
        addKarty();
    }

    public void vytvoritNastenku() {
        switch (level) {
            case Ľahká:
                setLayout(new GridLayout(4, 4, 20, 20));
                setBorder(new EmptyBorder(20, 205, 10, 205));
                break;
            case Stredná:
                setLayout(new GridLayout(6, 6, 13, 13));
                setBorder(new EmptyBorder(15, 205, 10, 205));
                break;
            case Ťažká:
                setLayout(new GridLayout(8, 8, 8, 8));
                setBorder(new EmptyBorder(15, 210, 10, 210));
                break;
            case Expert:
                setLayout(new GridLayout(10, 10, 5, 5));
                setBorder(new EmptyBorder(15, 210, 10, 210));
                break;
        }
    }

    public void vytvorKarty() {
        for (int i = 0; i < kolkoKariet; i++) {
            Karta card = new Karta(kolkoKariet);
            karty.add(card);
        }

        // Farba karty
        int indexFarby = 0;


        for (int i = 0; i < kolkoKariet; i += 2) {
            karty.get(i).setFarba(FarbaKarty.getFarbaKarty(indexFarby));
            karty.get(i + 1).setFarba(FarbaKarty.getFarbaKarty(indexFarby));
            indexFarby++;
        }
    }

    /**
     * Vytvara random karty
     */
    public void addKarty() {
        int pocitadlo = 0;
        Random random = new Random();
        int i;

        while (pocitadlo < kolkoKariet) {
            i = random.nextInt(kolkoKariet);

            if (!karty.get(i).isAddNaTabulu()) {
                add(karty.get(i));
                karty.get(i).setAddNaTabulu(true);
                pocitadlo++;
            }
        }
    }

    public List<Karta> getKarty() {
        return karty;
    }
}
