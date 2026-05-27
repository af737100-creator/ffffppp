package com.example.recorder;

import android.app.Service;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.os.IBinder;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.media.MediaRecorder;

public class FloatingService extends Service {
    private WindowManager windowManager;
    private View floatingView;
    private MediaRecorder recorder;
    private boolean isRecording = false;

    @Override
    public void onCreate() {
        super.onCreate();
        
        // إعداد نافذة الزر العائم
        windowManager = (WindowManager) getSystemService(WINDOW_SERVICE);
        floatingView = LayoutInflater.from(this).inflate(R.layout.floating_layout, null);

        final WindowManager.LayoutParams params = new WindowManager.LayoutParams(
                WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY,
                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
                PixelFormat.TRANSLUCENT);

        params.gravity = Gravity.TOP | Gravity.LEFT;
        windowManager.addView(floatingView, params);

        // التحكم في الزر (الميكروفون)
        ImageView micButton = floatingView.findViewById(R.id.mic_button);
        micButton.setOnClickListener(v -> {
            if (isRecording) {
                stopRecording();
                micButton.setImageResource(R.drawable.ic_mic_off); // أيقونة إيقاف
            } else {
                startRecording();
                micButton.setImageResource(R.drawable.ic_mic_on); // أيقونة تسجيل
            }
        });
    }

    private void startRecording() {
        recorder = new MediaRecorder();
        recorder.setAudioSource(MediaRecorder.AudioSource.VOICE_CALL);
        recorder.setOutputFormat(MediaRecorder.OutputFormat.MPEG_4);
        recorder.setAudioEncoder(MediaRecorder.AudioEncoder.AAC);
        recorder.setOutputFile(getExternalCacheDir().getAbsolutePath() + "/call_record.mp3");
        try {
            recorder.prepare();
            recorder.start();
            isRecording = true;
        } catch (Exception e) { e.printStackTrace(); }
    }

    private void stopRecording() {
        if (recorder != null) {
            recorder.stop();
            recorder.release();
            recorder = null;
            isRecording = false;
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (floatingView != null) windowManager.removeView(floatingView);
    }

    @Override
    public IBinder onBind(Intent intent) { return null; }
}
