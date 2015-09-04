package logic;

import java.util.List;

import javax.swing.JOptionPane;

import dao.DaoException;
import dao.mysql.DaoFactoryImpl;

public class Main {

    public static void main(String[] args) {

        DaoFactoryImpl factory = DaoFactoryImpl.getInstance();

        // add new word

        Word word = null;
        String str = new String("fuck");
        try {
            word = factory.getWordDao().getByEng(str);
            factory.getWordDao().delete(word);
        } catch (DaoException e1) {
            JOptionPane.showMessageDialog(null, "Delete word error", "Ошибка I/O", JOptionPane.OK_OPTION);
        }
        List<Word> words = null;
        try {
            words = factory.getWordDao().getAll();
        } catch (DaoException e) {
            System.out.println("Get all error: " + e);
        }

        if (words != null && words.size() != 0) {
            for (Word w : words) {
                System.out.println(w.getId() + " - " + w.getEng());
            }
        } else {
            System.out.println("List is null");
        }
    }
}
