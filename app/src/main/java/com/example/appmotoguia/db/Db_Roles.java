package com.example.appmotoguia.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

public class Db_Roles extends dbhelper{
    public Db_Roles(Context context) {
        super(context);
    }
    public long insertarRoles(String rol_nombre) {
        long id = -1;
        try (SQLiteDatabase db = getWritableDatabase()) {
            ContentValues values = new ContentValues();
            values.put("rol_nombre", rol_nombre);

            id = db.insert(TABLE_ROLES, null, values);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return id;
    }
}