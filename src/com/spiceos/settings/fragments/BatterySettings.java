/*
 * Copyright (C) 2018 AospExtended ROM Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.spiceos.settings.fragments;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.UserHandle;
import android.provider.Settings;

import androidx.preference.ListPreference;
import androidx.preference.Preference;
import androidx.preference.Preference.OnPreferenceChangeListener;
import androidx.preference.PreferenceScreen;
import androidx.preference.SwitchPreference;

import com.android.internal.logging.nano.MetricsProto;

import com.android.settings.R;
import com.android.settings.SettingsPreferenceFragment;

import com.spiceos.support.preferences.SecureSettingListPreference;
import com.spiceos.support.preferences.SystemSettingListPreference;

import java.util.ArrayList;
import java.util.List;

public class BatterySettings extends SettingsPreferenceFragment
            implements Preference.OnPreferenceChangeListener  {

    private static final String KEY_STATUS_BAR_BATTERY_STYLE = "status_bar_battery_style";
    private static final String KEY_STATUS_BAR_SHOW_BATTERY_PERCENT = "status_bar_show_battery_percent";

    private SecureSettingListPreference mBatteryStyle;
    private SystemSettingListPreference mShowPercentage;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        addPreferencesFromResource(R.xml.battery_settings);

        PreferenceScreen prefSet = getPreferenceScreen();
        ContentResolver resolver = getActivity().getContentResolver();

        mBatteryStyle = findPreference(KEY_STATUS_BAR_BATTERY_STYLE);
        mShowPercentage = findPreference(KEY_STATUS_BAR_SHOW_BATTERY_PERCENT);

        mBatteryStyle.setOnPreferenceChangeListener(this);
    }

    @Override
    public void onResume() {
        super.onResume();
        updateStates();
    }

    @Override
    public boolean onPreferenceChange(Preference preference, Object newValue) {
        ((ListPreference)preference).setValue((String)newValue);
        updateStates();
        return false;
    }

    private void updateStates() {
        if ("2".equals(mBatteryStyle.getValue()))
            mShowPercentage.setEnabled(false);
        else
            mShowPercentage.setEnabled(true);
    }
    
    @Override
    public int getMetricsCategory() {
        return MetricsProto.MetricsEvent.SPICEOS_SETTINGS;
    }
}
