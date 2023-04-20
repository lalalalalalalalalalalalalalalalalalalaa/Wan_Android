package com.example.wan_android.setting;

import android.content.Context;
import android.content.Intent;

import androidx.lifecycle.ViewModel;

public class SettingViewModel extends ViewModel {

    public void sentEmail(Context context){
        final String emailUrl = "qazse753753@gmail.com";
        final String emailSubject = "Wan Android Advices";
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/html");
        intent.putExtra(Intent.EXTRA_EMAIL, emailUrl);
        intent.putExtra(Intent.EXTRA_SUBJECT, emailSubject);
        context.startActivity(intent);
    }
}