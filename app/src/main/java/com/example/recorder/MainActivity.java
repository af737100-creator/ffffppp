import android.telecom.TelecomManager;

// ضع هذا داخل دالة onCreate
if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
    RoleManager roleManager = (RoleManager) getSystemService(ROLE_SERVICE);
    Intent intent = roleManager.createRequestRoleIntent(RoleManager.ROLE_DIALER);
    startActivityForResult(intent, 200);
}
