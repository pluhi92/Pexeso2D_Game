package game;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class Karta extends JButton {
    private ImageIcon obrazokIcony;
    private Color farba;
    private boolean addNaTabulu;
    private boolean kliknuty;
    private boolean ninjaMode;

    public Karta(int velkostRam) {
        addNaTabulu = false;
        ninjaMode = false;
        obrazokIcony = new ImageIcon(getClass().getResource("/resources/images/Mozog" + velkostRam + ".png"));

        setPrvaKarta();

        Border prednyRam = BorderFactory.createRaisedBevelBorder();
        Border zadnyRam = BorderFactory.createLoweredBevelBorder();
        setBorder(BorderFactory.createCompoundBorder(prednyRam, zadnyRam));

        setCursor(new Cursor(Cursor.HAND_CURSOR));

        addActionListener((e) -> {
            setIcon(null);
            setBackground(farba);
            setEnabled(false);
            kliknuty = true;
        });
    }

    public void setPrvaKarta() {
        setIcon(obrazokIcony);
        setDisabledIcon(obrazokIcony);

        if (!ninjaMode)
            setBackground(Color.WHITE);
        kliknuty = false;
        setEnabled(true);

    }

    public boolean bolKliknuty() {
        return kliknuty;
    }

    public void setFarba(Color farba) {
        this.farba = farba;
    }

    public Color getFarba() {
        return farba;
    }

    public boolean isAddNaTabulu() {
        return addNaTabulu;
    }

    public void setAddNaTabulu(boolean addNaTabulu) {
        this.addNaTabulu = addNaTabulu;
    }

    public void setNinjaMode() {
        ninjaMode = !ninjaMode;
    }
}
