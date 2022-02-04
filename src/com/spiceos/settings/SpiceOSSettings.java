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

import android.os.Bundle;
import java.util.Calendar;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.preference.Preference;
import androidx.preference.PreferenceCategory;
import androidx.preference.PreferenceScreen;

import com.android.settings.R;
import com.android.settings.SettingsPreferenceFragment;

import com.android.internal.logging.nano.MetricsProto;

public class SpiceOSSettings extends SettingsPreferenceFragment {

    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        addPreferencesFromResource(R.xml.spiceos_settings);
        goodVibesPlease();
    }

    @Override
    public int getMetricsCategory() {
        return MetricsProto.MetricsEvent.SPICEOS_SETTINGS;
    }

    @Override
    public void onResume() {
        super.onResume();
        goodVibesPlease();
    }

    private void goodVibesPlease(){

         Calendar c = Calendar.getInstance();
         int hours = c.get(Calendar.HOUR_OF_DAY);
         // ImageView root = (ImageView) getView().findViewById(R.id.spiceos_vibes);
         ImageView TopGreetings = (ImageView) getView().findViewById(R.id.spiceos_vibes);
         // View root =(ImageView) findViewById(R.id.spiceos_settings.xml);
         View root = findViewById((R.xml.spiceos_settings));

         if(hours>=5 && hours<=11){

               // root.setBackground(getResources().getDrawable(R.drawable.morning));
               TopGreetings.setImageResource(R.drawable.morning);

         } else if(hours>=12 && hours<=15){

             // root.setBackground(getResources().getDrawable(R.drawable.afternoon));
             TopGreetings.setImageResource(R.drawable.afternoon);

         } else if(hours>=16 && hours<=20){

             // root.setBackground(getResources().getDrawable(R.drawable.evening));
             TopGreetings.setImageResource(R.drawable.evening);

         } else if(hours>=21 && hours<=23){

             // root.setBackground(getResources().getDrawable(R.drawable.night));
             TopGreetings.setImageResource(R.drawable.night);

         } else if(hours>=0 && hours<=4){

             // root.setBackground(getResources().getDrawable(R.drawable.night));
             TopGreetings.setImageResource(R.drawable.sleep);

         }
     }


}
