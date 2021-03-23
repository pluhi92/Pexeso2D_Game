package scores;

import javax.swing.*;
import java.awt.*;

public class TabulkaScore extends JTable {
    private final TabulkaScoreModel tabulkaScoreModel;

    public TabulkaScore() {
        tabulkaScoreModel = TabulkaScoreModel.getInstanciaOf();
        setModel(tabulkaScoreModel);

        setDefaultRenderer(String.class, new VykreslovacTabulkyScore());

        setOpaque(false);
        setRowHeight(42);


        getTableHeader().setFont(new Font(Font.DIALOG, Font.BOLD, 32));
        getTableHeader().setForeground(Color.WHITE);
        getTableHeader().setBackground(new Color(138, 200, 114));
    }
}
