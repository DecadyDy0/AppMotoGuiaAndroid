package com.example.appmotoguia.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.Cursor;

import androidx.annotation.Nullable;

public class Db_Motos extends dbhelper {

        Context context;
        public Db_Motos(@Nullable Context context) {
                super(context);
                this.context = context;
        }

        public long insertarMotos(String modelo, String marca, String ano, String manual, String creado, byte[] imagen) {
                long id = -1;
                SQLiteDatabase db = null;

                try {
                        db = getWritableDatabase();
                        ContentValues values = new ContentValues();
                        values.put("modelo", modelo);
                        values.put("marca", marca);
                        values.put("ano", ano);
                        values.put("manual", manual);
                        values.put("creado", creado);
                        values.put("imagen", imagen);

                        id = db.insert(TABLE_MOTOS, null, values);
                } catch (Exception ex) {
                        ex.printStackTrace();
                } finally {
                        if (db != null) {
                                db.close();
                        }
                }

                return id;
        }


        public int actualizarMoto(int id, String modelo, String marca, int ano, String manual, String creado, byte[] imagen) {
                int filasAfectadas = 0;
                SQLiteDatabase db = null;

                try {
                        db = getWritableDatabase();
                        ContentValues values = new ContentValues();
                        values.put("modelo", modelo);
                        values.put("marca", marca);
                        values.put("ano", ano);
                        values.put("manual", manual);
                        values.put("creado", creado);
                        values.put("imagen", imagen);

                        filasAfectadas = db.update(TABLE_MOTOS, values, "id=?", new String[]{String.valueOf(id)});
                } catch (Exception ex) {
                        ex.printStackTrace();
                } finally {
                        if (db != null) {
                                db.close();
                        }
                }

                return filasAfectadas;
        }

        public int eliminarMoto(int id) {
                int filasAfectadas = 0;
                SQLiteDatabase db = null;

                try {
                        db = getWritableDatabase();
                        filasAfectadas = db.delete(TABLE_MOTOS, "id=?", new String[]{String.valueOf(id)});
                } catch (Exception ex) {
                        ex.printStackTrace();
                } finally {
                        if (db != null) {
                                db.close();
                        }
                }

                return filasAfectadas;
        }



        public Cursor getdata() {
                SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
                Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM " + TABLE_MOTOS, null);
                return cursor;
        }

}