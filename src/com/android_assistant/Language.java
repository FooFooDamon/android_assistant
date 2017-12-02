/*
 * Copyright (c) 2017, Wen Xiongchang <udc577 at 126 dot com>
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

public class Language {
    private enum LangKindEnum {
        /*
         * NOTE: The trailing slashes are meaningless, just for preventing the
         * IDE formatting source code automatically but ugly sometimes.
         */

        CHINESE_SIMPLIFIED, //
        CHINESE_TRADITIONAL, //
        ENGLISH, //

        // New kinds must be added before this MAX_KIND !!!
        MAX_KINDS
    };

    public static final int CHINESE_SIMPLIFIED = LangKindEnum.CHINESE_SIMPLIFIED
            .ordinal();
    public static final int CHINESE_TRADITIONAL = LangKindEnum.CHINESE_TRADITIONAL
            .ordinal();
    public static final int ENGLISH = LangKindEnum.ENGLISH.ordinal();

    private static int mDefaultLanguage = CHINESE_SIMPLIFIED;

    private static int mCurrentLanguage = mDefaultLanguage;

    public static int getDefault() {
        return mDefaultLanguage;
    }

    public static void setDefault(int language) {
        if (language >= 0 && language < LangKindEnum.MAX_KINDS.ordinal())
            mDefaultLanguage = language;
    }

    public static int getCurrent() {
        return mCurrentLanguage;
    }

    public static void setCurrent(int language) {
        if (language >= 0 && language < LangKindEnum.MAX_KINDS.ordinal())
            mCurrentLanguage = language;
    }
}
