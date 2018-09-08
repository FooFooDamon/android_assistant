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

public final class ResourceExports {
    /*
     * private static final Activity mAuxiliaryActivity = new Activity();
     *
     * private static final Resources mResources = mAuxiliaryActivity
     * .getResources();
     */

    private static Context mContext = null;

    public static void prepare(Context ctx) {
        if (null != ctx)
            mContext = ctx;
    }

    public static String[] getStringArray(int resId) {
        return mContext.getResources().getStringArray(resId);
    }

    public static String[] getStringArray(Context ctx, int resId) {
        return ctx.getResources().getStringArray(resId);
    }

    public static String getString(int stringArrayId) {
        return getString(stringArrayId, Language.getCurrent());
    }

    public static String getString(Context ctx, int stringArrayId) {
        return getString(ctx, stringArrayId, Language.getCurrent());
    }

    public static String getString(int stringArrayId, int language) {
        return getString(mContext, stringArrayId, language);
    }

    public static String getString(Context ctx, int stringArrayId, int language) {
        int backupCurrentLanguage = Language.getCurrent();
        String result = null;

        Language.setCurrent(language);
        result = ctx.getResources().getStringArray(stringArrayId)[Language.getCurrent()];
        Language.setCurrent(backupCurrentLanguage);

        return result;
    }

    public static final class array {

        public static final class string {

            public final static String[] CONFIRM = {
                "确定",
                "確定",
                "Confirm"
            };

            public final static String[] CANCEL = {
                "取消",
                "取消",
                "Cancel"
            };

            public final static String[] HELP = {
                "帮助",
                "幫助",
                "Help"
            };

            public final static String[] COMMA = {
                "，",
                "，",
                ","
            };

            public final static String[] FULL_STOP = {
                "。",
                "。",
                "."
            };

        } // .array.string

        // It seems that resources can not exported this way ...
        /*// public static String[] help =
        // mResources.getStringArray(R.array.help);

        public static String help() {
            return mContext.getString(R.array.help);
        }

        public static String help(Context ctx) {
            return getString(ctx, R.array.help);
        }

        // public static String[] confirm =
        // mResources.getStringArray(R.array.confirm);

        public static String confirm() {
            return mContext.getString(R.array.confirm);
        }

        public static String confirm(Context ctx) {
            return getString(ctx, R.array.confirm);
        }*/
    } // .array

    public static final class drawable {
        ;
    } // .drawable

    public static final class id {
        ;
    } // .id

    public static final class layout {
        ;
    } // .layout

    public static final class string {
        ;
    } // .string

    public static final class style {
        ;
    } // .style
}
