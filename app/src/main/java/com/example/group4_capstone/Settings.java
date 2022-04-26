package com.example.group4_capstone;

import android.os.Bundle;

import androidx.preference.PreferenceFragmentCompat;

public class Settings extends PreferenceFragmentCompat {

    public void Settings() {
        //suck my ass
    }

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        setPreferencesFromResource(R.xml.root_preferences, rootKey);
    }
}