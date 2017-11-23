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

import java.util.List;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.widget.Toast;

public class App {
	private static String mAppName = null;
	private static String mPackageName = null;
	private final static int INVALID_VERSION_NUM = -1;
	private static int mVersionNumber = INVALID_VERSION_NUM;
	private static String mVersionString = null;
	private static Context mContext = null;

	public static void prepare(Context ctx) {
		if (null != mContext)
			return;

		if (null == ctx)
			throw new NullPointerException("Null Context");

		PackageInfo packageInfo = getPackageInfo(ctx);

		mPackageName = ctx.getPackageName();
		mAppName = packageInfo.applicationInfo.loadLabel(
				ctx.getPackageManager()).toString();
		mVersionNumber = packageInfo.versionCode;
		mVersionString = packageInfo.versionName;

		mContext = ctx;
	}

	public static boolean isPrepared() {
		return (null != mContext);
	}

	public static String getAppName() {
		return mAppName;
	}

	public static String getAppName(Context ctx) {
		return getPackageInfo(ctx).applicationInfo.loadLabel(
				ctx.getPackageManager()).toString();
	}

	public static String getPackageName() {
		return mPackageName;
	}

	public static String getPackageName(Context ctx) {
		return ctx.getPackageName();
	}

	public static int getAppVersionNumber() {
		return mVersionNumber;
	}

	public static int getAppVersionNumber(Context ctx) {
		return getPackageInfo(ctx).versionCode;
	}

	public static String getAppVersionString() {
		return mVersionString;
	}

	public static String getAppVersionString(Context ctx) {
		return getPackageInfo(ctx).versionName;
	}

	public static void showHelpText(String helpContents) {
		showHelpText(mContext, helpContents);
	}

	public static void showHelpText(Context ctx, String helpContents) {
		final int CUR_LANG = Language.getCurrent();
		// final String HELP_TITLE = HELP_TITLES[CUR_LANG];//
		// = ResourceExports.array.help(ctx);
		// = ResourceExports.array.help[CUR_LANG];
		// final String CONFIRM_STRING = CONFIRM_STRINGS[CUR_LANG]; //
		// = ResourceExports.array.confirm(ctx);
		// = ResourceExports.array.confirm[CUR_LANG];
		
		Hint.alert(ctx, ResourceExports.array.string.HELP[CUR_LANG], helpContents);
	}

	public static void exit(final Activity activity) {
		final int CUR_LANG = Language.getCurrent();
		final String[] TITLES = {
			"程序即将退出",
			"程式即將退出",
			"Application is about to exit"
		};
		final String[] POSITIVE_HINTS = {
			"确认退出请点击",
			"確認退出請點擊",
			"If you are sure to exit, please click "
		};
		final String[] NEGATIVE_HINTS = {
			"否则请点击",
			"否則請點擊",
			" otherwise click "
		};
		final String CONTENTS = POSITIVE_HINTS[CUR_LANG]
			+ ResourceExports.array.string.CONFIRM[CUR_LANG]
			+ ResourceExports.array.string.COMMA[CUR_LANG]
			+ NEGATIVE_HINTS[CUR_LANG]
			+ ResourceExports.array.string.CANCEL[CUR_LANG]
			+ ResourceExports.array.string.FULL_STOP[CUR_LANG];
		OnClickListener listener = new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog,
					int which) {
				activity.finish();
				System.exit(0);
			}
		};
		
		Hint.alert(activity, TITLES[CUR_LANG], CONTENTS, listener, null);
	}

	public static void moveTaskToBack(Activity activity, String appName,
			boolean taskIsRoot, int appIcon) {
		final int CUR_LANG = Language.getCurrent();
		final String[] STR_ARRAY_MOVED_TO_BACKGROUND = {
			"已进入后台运行",
			"已進入後臺運行",
			" has run in background"
		};
		final String[] STR_ARRAY_RUNNING_IN_BACKGROUND = {
			"后台运行中",
			"後臺運行中",//
			" is running in background"
		};
		final String[] STR_ARRAY_CLICK_TO_RESTORE = {
			"点击可恢复",
			"點擊可恢複",
			"Click to restore"
		};

		Toast.makeText(activity,
				appName + STR_ARRAY_MOVED_TO_BACKGROUND[CUR_LANG],
				Toast.LENGTH_SHORT).show();

		displayNotification(activity, appName, STR_ARRAY_CLICK_TO_RESTORE[CUR_LANG],
			appName + STR_ARRAY_RUNNING_IN_BACKGROUND[CUR_LANG], appIcon);

		activity.moveTaskToBack(!taskIsRoot);
	}
	
	public static boolean isInBackground(Context context) {
		ActivityManager manager = (ActivityManager)context.getSystemService(Context.ACTIVITY_SERVICE);
		List<RunningAppProcessInfo> processes = manager.getRunningAppProcesses();
		
		for (RunningAppProcessInfo app : processes) {
			if (app.processName.equals(context.getPackageName())) {
				if (app.importance == RunningAppProcessInfo.IMPORTANCE_BACKGROUND)
					return true;
				else
					return false;
			}
		}
		
		return false;
	}
	
	public static void displayNotification(Activity activity, String title,
		String content, String tickerText, int appIcon) {
		Intent intent = new Intent(activity, activity.getClass());
		PendingIntent pendingIntent = PendingIntent.getActivity(activity, 0,
			intent, PendingIntent.FLAG_UPDATE_CURRENT);
		Notification notification = new Notification.Builder(activity)
			.setContentTitle(title)
			.setContentText(content)
			.setSmallIcon(appIcon)
			.setTicker(tickerText)
			.setAutoCancel(true).setWhen(System.currentTimeMillis())
			.setContentIntent(pendingIntent).build();
		NotificationManager manager = (NotificationManager) activity
			.getSystemService(Context.NOTIFICATION_SERVICE);

		notification.flags |= Notification.FLAG_ONGOING_EVENT;
		notification.flags |= Notification.FLAG_NO_CLEAR;
		notification.flags |= Notification.FLAG_SHOW_LIGHTS;
		notification.defaults = Notification.DEFAULT_LIGHTS;
		notification.ledARGB = android.graphics.Color.BLUE;
		notification.ledOnMS = 5000;
		
		manager.notify(0, notification);
	}
	
	public static void cancelNotification(Activity activity) {
		if (null == activity)
			return;
		
		NotificationManager notificationManager = (NotificationManager) activity.getSystemService(
			android.content.Context.NOTIFICATION_SERVICE);
		
		notificationManager.cancel(0);
	}

	private static PackageInfo getPackageInfo(Context ctx) {
		PackageInfo packageInfo = null;

		try {
			PackageManager packageManager = ctx.getPackageManager();

			packageInfo = packageManager
					.getPackageInfo(ctx.getPackageName(), 0);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Android Exception");
		}

		return packageInfo;
	}
}
