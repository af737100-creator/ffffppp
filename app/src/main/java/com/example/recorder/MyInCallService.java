package com.example.recorder;

import android.telecom.Call;
import android.telecom.InCallService;

public class MyInCallService extends InCallService {
    @Override
    public void onCallAdded(Call call) {
        super.onCallAdded(call);
        // عند إضافة مكالمة جديدة، نبدأ الخدمة العائمة
        Intent serviceIntent = new Intent(this, FloatingService.class);
        startForegroundService(serviceIntent);
    }

    @Override
    public void onCallRemoved(Call call) {
        super.onCallRemoved(call);
        // عند انتهاء المكالمة، نوقف الخدمة
        stopService(new Intent(this, FloatingService.class));
    }
}
