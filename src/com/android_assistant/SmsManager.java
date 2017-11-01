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

import android.util.Log;

public class SmsManager {
	public final static String CLASS_NAME = Common.PACKAGE_NAME + "SmsManager";

	private static int MAX_SINGLE_SMS_LENGTH_FOR_ENGLISH = 160;
	private static int MAX_SINGLE_SMS_LENGTH_FOR_CHINESE = 70;

	public static int sendSmsMessage(String recipientPhone, String contents,
			boolean containsChinese) {
		final int MAX_SINGLE_SMS_LENGTH = containsChinese ? MAX_SINGLE_SMS_LENGTH_FOR_CHINESE
				: MAX_SINGLE_SMS_LENGTH_FOR_ENGLISH;
		int contentLength = contents.length();

		if (contentLength > MAX_SINGLE_SMS_LENGTH) {
			Log.e(CLASS_NAME, "SMS message too long: " + contents.length()
					+ ", will be truncated!");
			// return ReturnValue.FAILED;
		}

		android.telephony.SmsManager smsManager = android.telephony.SmsManager
				.getDefault();
		String actualContent = (contentLength > MAX_SINGLE_SMS_LENGTH) ? contents
				.substring(0, MAX_SINGLE_SMS_LENGTH - 1) : contents;

		try {
			smsManager.sendTextMessage(recipientPhone, null, actualContent,
					null, null);
			Log.w(CLASS_NAME, "Sent " + actualContent.length()
					+ " bytes/characters of short message: " + actualContent);
		} catch (IllegalArgumentException e) {
			Log.w(CLASS_NAME, e.getMessage());
		}

		return ReturnCodes.OK;
	}
}
