package com.canakkoca.andzu.utils;

import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by can.akkoca on 4/14/2017.
 */

public class Util {

    private static final String TAG = Util.class.getCanonicalName();
    private static final String processId = Integer.toString(android.os.Process
            .myPid());

    public static StringBuilder readLogs() {
        StringBuilder builder = new StringBuilder();

        try {
            String[] command = new String[] { "logcat", "-d", "-v", "threadtime" };

            Process process = Runtime.getRuntime().exec(command);

            BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader(process.getInputStream()));

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                if (line.contains(processId)) {
                    builder.append(line);
                    //Code here
                }
            }
        } catch (IOException ex) {
            Log.e(TAG, "getLog failed", ex);
        }

        return builder;
    }
}
