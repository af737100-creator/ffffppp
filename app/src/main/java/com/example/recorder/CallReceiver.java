public class CallReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getStringExtra(TelephonyManager.EXTRA_STATE).equals(TelephonyManager.EXTRA_STATE_OFFHOOK)) {
            // بدأت المكالمة، نقوم بتشغيل الخدمة العائمة
            Intent serviceIntent = new Intent(context, FloatingService.class);
            context.startForegroundService(serviceIntent);
        }
    }
}
