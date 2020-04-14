package com.lewis.helloworld;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.telephony.TelephonyManager;

public class DevicesUtils {

    @SuppressLint("MissingPermission")
    public static String getDeivce(Context context) {

        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(Activity.TELEPHONY_SERVICE);

        String deviceId = "";
        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                deviceId = telephonyManager.getImei();
            } else {
                deviceId = telephonyManager.getDeviceId();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return deviceId;
    }

    @SuppressLint("MissingPermission")
    public static String getSlotImei(int slot, Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(Activity.TELEPHONY_SERVICE);
        String imei = "slot";
        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                imei = telephonyManager.getImei(slot);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return imei;

    }
}
