package com.example.appmotoguia.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class Db_Usuarios extends dbhelper {

    public Db_Usuarios(Context context) {
        super(context);
    }

    public long insertarUsuarios(String usuario, String telefono, String correo, String contraseña, String id_rol) {
        long id = -1;
        try (SQLiteDatabase db = getWritableDatabase()) {
            ContentValues values = new ContentValues();
            values.put("usuario", usuario);
            values.put("telefono", telefono);
            values.put("correo", correo);
            values.put("contraseña", contraseña);
            values.put("id_rol", id_rol);

            id = db.insert(TABLE_USUARIOS, null, values);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return id;
    }

    public boolean verificarUsuarioContraseña(String usuario, String contraseña) {
        boolean isValid = false;
        try (SQLiteDatabase db = getReadableDatabase();
             Cursor cursor = db.query(
                     TABLE_USUARIOS,
                     null,
                     "usuario = ? AND contraseña = ?",
                     new String[]{usuario, contraseña},
                     null,
                     null,
                     null
             )) {
            isValid = cursor.getCount() > 0;
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return isValid;
    }

    public int obtenerIdRol(String usuario) {
        int idRol = 0;
        SQLiteDatabase db = null;
        Cursor cursor = null;

        try {
            db = getReadableDatabase();

            String query = "SELECT id_rol FROM " + TABLE_USUARIOS + " WHERE usuario = ?";
            cursor = db.rawQuery(query, new String[]{usuario});

            if (cursor.moveToFirst()) {
                int columnIndex = cursor.getColumnIndex("id_rol");

                if (columnIndex != -1) {
                    idRol = cursor.getInt(columnIndex);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (cursor != null) {
                cursor.close();
            }
            if (db != null) {
                db.close();
            }
        }

        return idRol;
    }



}