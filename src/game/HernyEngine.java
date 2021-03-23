package game;

import java.util.List;

public class HernyEngine extends Thread {
    private static boolean hranie;
    private static int pokusy;
    private int zhody;
    private PouzivatelskyPanel pouzivatelskyPanel;

    public HernyEngine(PouzivatelskyPanel pouzivatelskyPanel) {
        this.pouzivatelskyPanel = pouzivatelskyPanel;
        pokusy = 0;
        zhody = 0;
        hranie = true;
    }

    public void run() {           //Runnable() interface
        List<Karta> karty = pouzivatelskyPanel.getKarty();

        while (true) {
            int prva = -1;
            int druha = -1;
            int kliknuty = 0;

            //PREVRATENIE KARIET --> jedno kolo 2x kliknutie
            for (int i = 0; i < karty.size() && kliknuty < 2; i++) {
                if (karty.get(i).bolKliknuty()) {
                    if (prva == -1)
                        prva = i;
                    else
                        druha = i;

                    kliknuty++;
                }
            }

            if (kliknuty == 2) {

                for (Karta karta : karty)
                    karta.setEnabled(false);

                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                if (karty.get(prva).getFarba().equals(karty.get(druha).getFarba())) {
                    zhody++;   //je zhoda
                    karty.get(prva).setVisible(false);
                    karty.get(druha).setVisible(false);
                }

                if (hranie) {
                    pokusy++;
                    pouzivatelskyPanel.setPokusyLabelText(String.format("%03d", pokusy));

                    for (Karta karta : karty)
                        karta.setPrvaKarta();
                }
            }

            if (zhody == Komponenty.getLevel().getKolkoKariet() / 2) {
                PouzivatelskyPanel.getCasovac().setCasBezi(false);
                hranie = false;
                vyhra();
                zhody = 0;
            }
        }
    }

    public static void setHranie(boolean hranie) {
        HernyEngine.hranie = hranie;
    }

    public static int getPokusy() {
        return pokusy;
    }

    public void vyhra() {
        DialogVyhry dialogVyhry = new DialogVyhry();
        dialogVyhry.setLocationRelativeTo(null);
        dialogVyhry.setVisible(true);
    }
}
