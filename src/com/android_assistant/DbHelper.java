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

import java.io.File;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class DbHelper {
    private Context mContext = null;
    private String mDbName = null;
    private String mDbDir = android.os.Environment.getDataDirectory().getAbsolutePath();
    private SQLiteDatabase mDb = null;

    public DbHelper(Context context, String dbName) {
        if (null == context || null == dbName)
            throw new NullPointerException();

        mContext = context;
        mDbName = dbName;
    }

    public DbHelper(Context context, String dbName, String dbDirectory) {
        if (null == context || null == dbName || null == dbDirectory)
            throw new NullPointerException();

        mContext = context;
        mDbName = dbName;

        File dir = new File(dbDirectory);

        if (!dir.exists())
            dir.mkdirs();

        mDbDir = dbDirectory;
    }

    public static SQLiteDatabase openOrCreate(String dbDir, String dbName) {
        return SQLiteDatabase.openOrCreateDatabase(dbDir + "/" + dbName, null);
    }

    public static void close(SQLiteDatabase db) {
        if (null != db)
            db.close();
    }

    public String getDatabaseName() {
        return mDbName;
    }

    public String getDatabaseDirectory() {
        return mDbDir;
    }

    public void openOrCreate() {
        mDb = openOrCreate(mDbDir, mDbName);
    }

    public SQLiteDatabase getDatabase() {
        return mDb;
    }

    public void close() {
        close(mDb);
    }
}
