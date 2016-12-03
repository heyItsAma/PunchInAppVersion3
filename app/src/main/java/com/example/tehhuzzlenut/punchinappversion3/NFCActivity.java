package com.example.tehhuzzlenut.punchinappversion3;

import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentFilter;
import android.nfc.NfcAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class NFCActivity extends AppCompatActivity {

    NfcAdapter nfcAdapter = NfcAdapter.getDefaultAdapter(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nfc);

        nfcAdapter = NfcAdapter.getDefaultAdapter(this);

        if(nfcAdapter != null && nfcAdapter.isEnabled()){
            Toast.makeText(this, "NFC available!", Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(this, "NFC not available! Enable in settings to use!", Toast.LENGTH_LONG);
        }

    }

    @Override
    protected void onResume() {
        super.onResume();

        enableForegroundDsipatchSystem();
    }

    @Override
    protected void onPause() {
        super.onPause();

        disableForegroundDsipatchSystem();
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);

        if(intent.hasExtra(nfcAdapter.EXTRA_TAG)){
            Toast.makeText(this, "NFC Intent!", Toast.LENGTH_SHORT).show();
        }
    }

    private void enableForegroundDsipatchSystem(){
        Intent intent = new Intent(this, LoginActivity.class).addFlags(Intent.FLAG_RECEIVER_REPLACE_PENDING);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);

        IntentFilter[] intentFilter = new IntentFilter[]{};

        nfcAdapter.enableForegroundDispatch(this, pendingIntent, intentFilter, null);
    }

    private void disableForegroundDsipatchSystem(){
        nfcAdapter.disableForegroundDispatch(this);
    }

}
