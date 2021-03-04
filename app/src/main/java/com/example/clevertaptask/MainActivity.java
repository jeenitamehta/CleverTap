package com.example.clevertaptask;

import androidx.appcompat.app.AppCompatActivity;

import android.app.NotificationManager;
import android.os.Bundle;

import com.clevertap.android.sdk.CleverTapAPI;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // each of the below mentioned fields are optional
        HashMap<String, Object> profileUpdate = new HashMap<String, Object>();
        profileUpdate.put("Name", "Jeenita");    // String
        profileUpdate.put("Identity", 96102603);      // String or number
        profileUpdate.put("Email", "jeenita@clevertap.com"); // Email address of the user
        profileUpdate.put("Phone", "+1479951234");   // Phone (with the country code, starting with +)
        profileUpdate.put("Gender", "F");             // Can be either M or F
        profileUpdate.put("DOB", new Date());         // Date of Birth. Set the Date object to the appropriate value first
// optional fields. controls whether the user will be sent email, push etc.
        profileUpdate.put("MSG-email", true);        // Disable email notifications
        profileUpdate.put("MSG-push", true);          // Enable push notifications
        profileUpdate.put("MSG-sms", true);          // Disable SMS notifications
        profileUpdate.put("MSG-whatsapp", true);      // Enable WhatsApp notifications
        //ArrayList<String> stuff = new ArrayList<String>();
        //stuff.add("bag");
        //stuff.add("shoes");
        //profileUpdate.put("MyStuff", stuff);                        //ArrayList of Strings
        //String[] otherStuff = {"Jeans","Perfume"};
        //profileUpdate.put("MyStuff", otherStuff);                   //String Array
        CleverTapAPI.getDefaultInstance(getApplicationContext()).onUserLogin(profileUpdate);
        CleverTapAPI cleverTapAPI = CleverTapAPI.getDefaultInstance(getApplicationContext());
        //CleverTapAPI cleverTapAPI = CleverTapAPI.getDefaultInstance(getApplicationContext());
        //code for push notifications
        cleverTapAPI.createNotificationChannel(getApplicationContext(),"TEST-RZ7-Z94-K95Z","Your Channel Name","Your Channel Description",NotificationManager.IMPORTANCE_MAX,true);
        //CleverTapAPI clevertapDefaultInstance = CleverTapAPI.getDefaultInstance(getApplicationContext());
        setContentView(R.layout.activity_main);
    }
}