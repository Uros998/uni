package com.milicevic.smsdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final int MY_PERMISSIONS_REQUEST_SEND_SMS = 1;

    String SENT = "SMS_SENT";
    String DELIVERED = "SMS_DELIVERED";
    PendingIntent sentPI, deliveredPI;
    BroadcastReceiver smsSentReceiver, smsDeliveredReceiver;
    IntentFilter intentFilter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        sentPI = PendingIntent.getBroadcast(this, 0,
                new Intent(SENT), PendingIntent.FLAG_IMMUTABLE);

        deliveredPI = PendingIntent.getBroadcast(this, 0,
                new Intent(DELIVERED), PendingIntent.FLAG_IMMUTABLE);

    }

    @Override
    public void onResume() {
        super.onResume();
      //---kreira BroadcastReceiver kada je SMS poslat---
        smsSentReceiver = new BroadcastReceiver(){
            @Override
            public void onReceive(Context arg0, Intent arg1) {
                switch (getResultCode())
                {
                    case AppCompatActivity.RESULT_OK:
                        Toast.makeText(getBaseContext(), "SMS prosleđen",
                                Toast.LENGTH_SHORT).show();
                        break;
                    case SmsManager.RESULT_ERROR_GENERIC_FAILURE:
                        Toast.makeText(getBaseContext(), "Generička greška",
                                Toast.LENGTH_SHORT).show();
                        break;
                    case SmsManager.RESULT_ERROR_NO_SERVICE:
                        Toast.makeText(getBaseContext(), "Nema usluge",
                                Toast.LENGTH_SHORT).show();
                        break;
                    case SmsManager.RESULT_ERROR_NULL_PDU:
                        Toast.makeText(getBaseContext(), "Null PDU",
                                Toast.LENGTH_SHORT).show();
                        break;
                    case SmsManager.RESULT_ERROR_RADIO_OFF:
                        Toast.makeText(getBaseContext(), "Radio isključen",
                                Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        };


        //---kreira BroadcastReceiver kada SMS dostavljen---
        smsDeliveredReceiver = new BroadcastReceiver(){
            @Override
            public void onReceive(Context arg0, Intent arg1) {
                switch (getResultCode())
                {
                    case AppCompatActivity.RESULT_OK:
                        Toast.makeText(getBaseContext(), "SMS dostavljen",
                                Toast.LENGTH_SHORT).show();
                        break;
                    case AppCompatActivity.RESULT_CANCELED:
                        Toast.makeText(getBaseContext(), "SMS nije dostavljen",
                                Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        };

        //---registruje dva BroadcastReceiver - a---
        registerReceiver(smsDeliveredReceiver, new IntentFilter(DELIVERED));
        registerReceiver(smsSentReceiver, new IntentFilter(SENT));
    }

    @Override
    public void onPause() {
        super.onPause();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //---odjavljuje dva BroadcastReceiver-a---
        unregisterReceiver(smsSentReceiver);
        unregisterReceiver(smsDeliveredReceiver);

    }

    public void on (View v) {
        //Kod koji je radio do Android 11
      /*  Intent i = new
                Intent(Intent.ACTION_SEND);
        i.putExtra("address", "0612057472; 0616613231;");

        i.putExtra("sms_body", "Pozdravni SMS - primer!");
        i.setType("vnd.android-dir/mms-sms");
        startActivity(i);*/

        EditText et = (EditText)findViewById(R.id.editText1);
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("smsto:" + "0654747847"));  // Osigurava odziv SMS aplikacije
        intent.putExtra("sms_body",et.getText().toString());

            try{
                startActivity(intent);
            } catch (Exception ex) {
                Log.d("Greška", "SMS aplikacija nije pronađena");
                ex.printStackTrace();
            }



    }
    public void onClick(View v) {
        sendSMS("0654747847", "Pozdravni SMS - primer!");
    }

    private void sendSMS(String phoneNumber, String message){
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.SEND_SMS)
                != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.SEND_SMS)) {
            } else {
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.SEND_SMS},
                        MY_PERMISSIONS_REQUEST_SEND_SMS);
            }
        }else{         //dozvola je već odobrena
            SmsManager sms = SmsManager.getDefault();
            sms.sendTextMessage(phoneNumber, null, message,
                    sentPI, deliveredPI);
            Toast.makeText(getApplicationContext(), "SMS sent.",
                    Toast.LENGTH_LONG).show();

        }
    }

    //priložene adrese, prilikom testiranja, zameniti pravim
    public void onClick1(View v) {
        String[] to =
                {"bogijanko01@gmail.com"};
        String[] cc = {"vladam.kg@outlook.com"};
        sendEmail(to, cc, "CS330", "Pozdrav društvo!!!");
    }
    //-slanje e-mail poruke na drugi uređaj”-
    private void sendEmail(String[] emailAddresses, String[] carbonCopies,
                           String subject, String message)
    {
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setData(Uri.parse("mailto:"));
        String[] to = emailAddresses;
        String[] cc = carbonCopies;
        emailIntent.putExtra(Intent.EXTRA_EMAIL, to);
        emailIntent.putExtra(Intent.EXTRA_CC, cc);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, subject);
        emailIntent.putExtra(Intent.EXTRA_TEXT, message);
        emailIntent.setType("message/rfc822");
        startActivity(Intent.createChooser(emailIntent, "Email"));
    }
}