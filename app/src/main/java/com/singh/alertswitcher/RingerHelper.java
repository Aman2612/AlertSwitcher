package com.singh.alertswitcher;

import android.media.AudioManager;

/**
 * Created by Aman on 01/08/16.
 */
public class RingerHelper {


    public RingerHelper() {}

    public static void performToggle(AudioManager audioManager)
    {
        audioManager.setRingerMode(
                isPhoneSilent(audioManager)
                ?AudioManager.RINGER_MODE_NORMAL
                        :AudioManager.RINGER_MODE_SILENT);
    }
       public static boolean isPhoneSilent(AudioManager audioManager)
       {
           return audioManager.getRingerMode()==AudioManager.RINGER_MODE_SILENT;
       }
}
