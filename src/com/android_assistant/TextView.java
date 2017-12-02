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

public class TextView {
    public static final float DEFAULT_SHADOW_RADIUS = 5F;
    public static final float DEFAULT_SHADOW_DX = 5F;
    public static final float DEFAULT_SHADOW_DY = 5F;

    public static void setDefaultTextShadow(android.widget.TextView view) {
        final float RADIUS = DEFAULT_SHADOW_RADIUS;
        final float DX = DEFAULT_SHADOW_DX;
        final float DY = DEFAULT_SHADOW_DY;
        final int COLOR = Color.DEFAULT_TEXT_SHADOW;

        view.setShadowLayer(RADIUS, DX, DY, COLOR);
    }

}
