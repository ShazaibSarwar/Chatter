package com.shazaibsarwar.chatter.All_Activites;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;
import com.shazaibsarwar.chatter.databinding.ActivityEntringPhoneNumberBinding;

public class EntringPhoneNo_Activity extends AppCompatActivity {

    // to avoid the mess of find View By Id we Did this
    // 1. ActivityEntringPhoneNumberBinding binding;
    // 2. binding = ActivityEntringPhoneNumberBinding.inflate(getLayoutInflater());
    // 3. setContentView(binding.getRoot());

    ActivityEntringPhoneNumberBinding binding;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityEntringPhoneNumberBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.etOTPNumberYText.requestFocus();   // For auto keyboard open also chane in Manifest

        binding.countryCodePiker.registerCarrierNumberEditText(binding.etOTPNumberYText);

        getSupportActionBar().hide();


        auth = FirebaseAuth.getInstance();

        if(auth.getCurrentUser() != null) {            // Checking user exists or not
            Intent intent = new Intent(EntringPhoneNo_Activity.this, MainActivity.class);
            startActivity(intent);
            finish();
        }

        binding.BtnOtpContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(EntringPhoneNo_Activity.this, OTP_Activity.class);
                intent.putExtra("phoneNumber",binding.countryCodePiker.getFullNumberWithPlus());
                startActivity(intent);
            }
        });


    }
}