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

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.widget.Toast;

public class Hint {
    public static void alert(Context context, CharSequence title, CharSequence contents) {
        new AlertDialog.Builder(context)
            .setTitle(title)
            .setMessage(contents)
            .setPositiveButton(
                ResourceExports.array.string.CONFIRM[Language.getCurrent()],null)
            .show();
    }

    public static void alert(Context context, int titleResId, int contentsResId) {
        alert(context, context.getResources().getString(titleResId),
            context.getResources().getString(contentsResId));
    }

    public static void alert(Context context, int titleResId, CharSequence contents) {
        alert(context, context.getResources().getString(titleResId),
            contents);
    }

    public static void alert(Context context, CharSequence title, int contentsResId) {
        alert(context, title,
            context.getResources().getString(contentsResId));
    }

    public static void alert(Context context, CharSequence title, CharSequence contents,
        OnClickListener positiveListener) {
        new AlertDialog.Builder(context)
            .setTitle(title)
            .setMessage(contents)
            .setPositiveButton(
                ResourceExports.array.string.CONFIRM[Language.getCurrent()], positiveListener)
            .show();
    }

    public static void alert(Context context, int titleResId, int contentsResId,
        OnClickListener positiveListener) {
        alert(context, context.getResources().getString(titleResId),
            context.getResources().getString(contentsResId), positiveListener);
    }

    public static void alert(Context context, int titleResId, CharSequence contents,
        OnClickListener positiveListener) {
        alert(context, context.getResources().getString(titleResId),
            contents, positiveListener);
    }

    public static void alert(Context context, CharSequence title, int contentsResId,
        OnClickListener positiveListener) {
        alert(context, title,
            context.getResources().getString(contentsResId), positiveListener);
    }

    public static void alert(Context context, CharSequence title, CharSequence contents,
        OnClickListener positiveListener, OnClickListener negativeListener) {
        new AlertDialog.Builder(context)
            .setTitle(title)
            .setMessage(contents)
            .setPositiveButton(
                ResourceExports.array.string.CONFIRM[Language.getCurrent()], positiveListener)
            .setNegativeButton(ResourceExports.array.string.CANCEL[Language.getCurrent()], negativeListener)
            .show();
    }

    public static void alert(Context context, int titleResId, int contentsResId,
        OnClickListener positiveListener, OnClickListener negativeListener) {
        alert(context, context.getResources().getString(titleResId),
            context.getResources().getString(contentsResId), positiveListener, negativeListener);
    }

    public static void alert(Context context, int titleResId, CharSequence contents,
        OnClickListener positiveListener, OnClickListener negativeListener) {
        alert(context, context.getResources().getString(titleResId),
            contents, positiveListener, negativeListener);
    }

    public static void alert(Context context, CharSequence title, int contentsResId,
        OnClickListener positiveListener, OnClickListener negativeListener) {
        alert(context, title,
            context.getResources().getString(contentsResId), positiveListener, negativeListener);
    }

    public static void shortToast(Context context, CharSequence text) {
        Toast.makeText(context, text, Toast.LENGTH_SHORT).show();
    }

    public static void shortToast(Context context, int resId) {
        Toast.makeText(context, resId, Toast.LENGTH_SHORT).show();
    }

    public static void longToast(Context context, CharSequence text) {
        Toast.makeText(context, text, Toast.LENGTH_LONG).show();
    }

    public static void longToast(Context context, int resId) {
        Toast.makeText(context, resId, Toast.LENGTH_LONG).show();
    }
}
