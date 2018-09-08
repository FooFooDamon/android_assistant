/*
 * Copyright (c) 2017-2018, Wen Xiongchang <udc577 at 126 dot com>
 * All rights reserved.
 *
 * This software is provided 'as-is', without any express or implied
 * warranty. In no event will the authors be held liable for any
 * damages arising from the use of this software.
 *
 * Permission is granted to anyone to use this software for any
 * purpose, including commercial applications, and to alter it and
 * redistribute it freely, subject to the following restrictions:
 *
 * 1. The origin of this software must not be misrepresented; you must
 * not claim that you wrote the original software. If you use this
 * software in a product, an acknowledgment in the product documentation
 * would be appreciated but is not required.
 *
 * 2. Altered source versions must be plainly marked as such, and
 * must not be misrepresented as being the original software.
 *
 * 3. This notice may not be removed or altered from any source
 * distribution.
 */

// NOTE: The original author also uses (short/code) names listed below,
//       for convenience or for a certain purpose, at different places:
//       wenxiongchang, wxc, Damon Wen, udc577

package com.android_assistant;

import android.content.Context;
import android.preference.PreferenceManager;

public class SharedPreferences {
    public static enum ValueTypeEnum {
        BOOL, INT, LONG, FLOAT, STRING, STRING_SET
    };

    public static Object getValue(Context context, String key,
            ValueTypeEnum valueType, Object defaultValue) {

        android.content.SharedPreferences pref = PreferenceManager
                .getDefaultSharedPreferences(context);

        // TODO: Is try{}catch(){} necessary??
        if (ValueTypeEnum.BOOL == valueType)
            return pref.getBoolean(key, (boolean)defaultValue);
        else if (ValueTypeEnum.INT == valueType)
            return pref.getInt(key, (int)defaultValue);
        else if (ValueTypeEnum.LONG == valueType)
            return pref.getLong(key, (long)defaultValue);
        else if (ValueTypeEnum.FLOAT == valueType)
            return pref.getFloat(key, (float)defaultValue);
        else if (ValueTypeEnum.STRING == valueType)
            return pref.getString(key, (String)defaultValue);
        // TODO: finish it later
        /*
         * else if (ValueTypeEnum.STRING_SET == valueType)
         * pref.getStringSet(key, null);
         */
        else
            return null;
    }

    public static int setValue(Context context, String key, Object value) {

        android.content.SharedPreferences.Editor editor = PreferenceManager
                .getDefaultSharedPreferences(context).edit();
        // Set<String> varToGetClassType = new HashSet();
        boolean isValidType = true;

        // TODO: add try{}catch(){}
        if (value.getClass() == boolean.class
                || value.getClass() == java.lang.Boolean.class)
            editor.putBoolean(key, (Boolean) value).commit();
        else if (value.getClass() == int.class
                || value.getClass() == java.lang.Integer.class)
            editor.putInt(key, (java.lang.Integer) value ).commit();
        else if (value.getClass() == long.class
                || value.getClass() == java.lang.Long.class)
            editor.putLong(key, (Long) value).commit();
        else if (value.getClass() == float.class
                || value.getClass() == java.lang.Float.class)
            editor.putFloat(key, (Float) value).commit();
        else if (value.getClass() == String.class
                || value.getClass() == java.lang.String.class)
            editor.putString(key, (String) value).commit();
        // TODO: finish it later
        /*
         * else if (value.getClass() == varToGetClassType.getClass())
         * editor.putStringSet(null, null);
         */
        else
            isValidType = false;

        if (!isValidType)
            return ReturnCodes.FAILED;

        return ReturnCodes.OK;
    }
}
