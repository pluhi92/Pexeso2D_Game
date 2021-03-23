package game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VychodListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent event) {
        PouzivatelskyPanel.getCasovac().setCasBezi(false);
        HernyEngine.setHranie(false);

        VychodDialog vychodDialog = new VychodDialog("Exit");

        vychodDialog.setLocationRelativeTo(null);
        vychodDialog.setVisible(true);
    }
}
