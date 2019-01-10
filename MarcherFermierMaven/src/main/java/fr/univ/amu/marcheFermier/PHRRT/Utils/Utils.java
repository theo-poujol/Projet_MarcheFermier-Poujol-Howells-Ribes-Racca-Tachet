package fr.univ.amu.marcheFermier.PHRRT.Utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Dorianosaure on 02/01/2019.
 */
public class Utils {

    /**
     *
     * @return entry.readLine()
     */
    public static String getKeyboardEntry() {

        BufferedReader entry = new BufferedReader(new InputStreamReader(System.in));

        try {
            return entry.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
}
