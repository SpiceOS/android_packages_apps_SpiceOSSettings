/*
 * Copyright © 2018 Superior OS Project
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

package com.spiceos.settings;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import androidx.preference.Preference;
import androidx.preference.PreferenceCategory;
import androidx.preference.PreferenceScreen;
import androidx.preference.PreferenceFragmentCompat;

import com.android.settings.R;
import com.android.settings.SettingsPreferenceFragment;
import com.android.settings.Utils;

import com.android.internal.logging.nano.MetricsProto;

public class SpiceOSSettings extends SettingsPreferenceFragment {

     @Override
     public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        addPreferencesFromResource(R.xml.spiceos_settings);
        final PreferenceScreen screen = getPreferenceScreen();
        if (screen == null) {
            return;
        }

        final int tintColor = Utils.getHomepageIconColor(getContext());
        final int count = screen.getPreferenceCount();
        for (int i = 0; i < count; i++) {
            final Preference preference = screen.getPreference(i);
            if (preference == null) {
                break;
            }
            final Drawable icon = preference.getIcon();
            if (icon != null) {
                icon.setTint(tintColor);
            }
        }
        onSetPrefCard();
    }

    @Override
    public int getMetricsCategory() {
        return MetricsProto.MetricsEvent.SPICEOS_SETTINGS;
    }

        private void onSetPrefCard() {
    	final PreferenceScreen screen = getPreferenceScreen();
        final int count = screen.getPreferenceCount();
        for (int i = 0; i < count; i++) {
            final Preference preference = screen.getPreference(i);
            if (screen == null) {
                return;
            }
 	    String key = preference.getKey();

        if (key.equals("card_top")){
	        preference.setLayoutResource(R.layout.custom_level_preference_top);
	    }
        if (key.equals("card_middle")){
	        preference.setLayoutResource(R.layout.card_view_pref_middle);
	    }
        if (key.equals("card_bottom")){
	        preference.setLayoutResource(R.layout.card_view_pref_bottom);
	    }

     	}
    }

}
