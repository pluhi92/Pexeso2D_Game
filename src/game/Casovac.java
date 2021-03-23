package game;

public class Casovac extends Thread {
    private int cas;
    private String stringCas;
    private boolean casBezi;
    private PouzivatelskyPanel pouzivatelskyPanel;

    public Casovac(PouzivatelskyPanel pouzivatelskyPanel) {
        this.pouzivatelskyPanel = pouzivatelskyPanel;
        cas = 0;
        casBezi = true;
    }

    @Override
    public void run() {   //Runnable interface()
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }

            if (casBezi) {
                setStringCas(++cas);
                pouzivatelskyPanel.setCasLabelText(stringCas);
            }
        }
    }

    public void setStringCas(int allSekundy) {
        // int hodiny  = allSeconds / 3600;
        int minuty = (allSekundy % 3600) / 60;
        int sekundy = allSekundy % 60;

        stringCas = String.format("%02d:%02d", minuty, sekundy);
    }

    public String getStringCas() {
        return stringCas;
    }

    public int getCas() {
        return cas;
    }

    public void setCasBezi(boolean casBezi) {
        this.casBezi = casBezi;
    }
}
