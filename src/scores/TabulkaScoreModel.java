package scores;

import game.Level;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class TabulkaScoreModel extends AbstractTableModel {
    private List<NahraneScore> nahraneScore;
    private final String[] menoStlpca = {"MENO", "ÚROVEŇ", "ČAS", "POKUSY", "BODY"};
    private static TabulkaScoreModel tabulkaScoreModel;

    private TabulkaScoreModel() {
        citajScore();
    }

    public static TabulkaScoreModel getInstanciaOf() {
        if (tabulkaScoreModel == null)
            tabulkaScoreModel = new TabulkaScoreModel();

        return tabulkaScoreModel;
    }

    @Override
    public int getRowCount() {
        return nahraneScore.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public String getColumnName(int stlpec) {
        return menoStlpca[stlpec];
    }

    @Override
    public Class<?> getColumnClass(int stlpecIndex) {
        return String.class;
    }

    @Override
    public Object getValueAt(int riadokIndex, int stlpecIndex) {
        // Sortujeme podla najvyssich bodov
        Collections.sort(nahraneScore);

        NahraneScore score = nahraneScore.get(riadokIndex);

        switch (stlpecIndex) {
            case 0:
                return score.getPouzivatel();
            case 1:
                return score.getLevel();
            case 2:
                return score.getCas();
            case 3:
                return score.getPokusy();
            case 4:
                return score.getBody();
        }

        return null;
    }


    public void addScore(String nick, Level level, String cas, int pokusy, int body) {
        nahraneScore.add(new NahraneScore(nick, level, cas, pokusy, body));
        zapisSkore();
    }

    public void zapisSkore() {
        try {
            ObjectOutputStream vstupStream = new ObjectOutputStream(new FileOutputStream("scores.bin"));
            vstupStream.writeObject(nahraneScore);
            vstupStream.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), "Neočakávaná chyba :(",
                    "Chyba pridania použiavateľa", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void citajScore() {
        try {
            ObjectInputStream vstupStream = new ObjectInputStream(new FileInputStream("scores.bin"));
            nahraneScore = (ArrayList<NahraneScore>) vstupStream.readObject();
            vstupStream.close();

        } catch (Exception e) {
            nahraneScore = new ArrayList<>();

            JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), "Neočakávaná chyba :(", "Nacitava vysoké socore",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
