package org.alcha.algalon.util;

import android.content.res.Resources;

import org.alcha.algalon.R;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Alcha on 8/1/2017.
 */

public class APIKeys {
    public static String getBlizzardKey(Resources res) {
        try {
            InputStream inputStream = res.openRawResource(R.raw.blizzard_key);
            byte[] bytes = new byte[inputStream.available()];

            System.out.println("Added " + inputStream.read(bytes) + " characters to bytes.");
            return new String(bytes);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return "";
    }

    public static String getBlizzardSecret(Resources res) {
        try {
            InputStream inputStream = res.openRawResource(R.raw.blizzard_secret);
            byte[] bytes = new byte[inputStream.available()];
            System.out.println("Added " + inputStream.read(bytes) + " characters to bytes.");
            return new String(bytes);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return "";
    }
}
