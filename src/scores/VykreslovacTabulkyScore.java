package scores;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

public class VykreslovacTabulkyScore extends JLabel implements TableCellRenderer {
    @Override
    public Component getTableCellRendererComponent(JTable table, Object hodnota, boolean isVybrany, boolean maZameranie,
                                                   int riadok, int stlpec) {
        String s = hodnota.toString();

        this.setText(s);
        this.setForeground(Color.WHITE);
        this.setOpaque(false);
        this.setFont(new Font(Font.DIALOG, Font.ITALIC, 30));
        this.setAlignmentX(CENTER);

        return this;
    }
}
