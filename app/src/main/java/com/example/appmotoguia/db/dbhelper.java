package com.example.appmotoguia.db;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class dbhelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NOMBRE = "moto.db";
    public static final String TABLE_USUARIOS = "t_usuarios";
    public static final String TABLE_MOTOS = "t_MOTOS";
    public static final String TABLE_ROLES = "t_roles";
    public static final String TABLE_DOCUMENTOS = "t_roles";

    public dbhelper(@Nullable Context context) {
        super(context, DATABASE_NOMBRE, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        createTableIfNotExists(sqLiteDatabase, TABLE_USUARIOS,
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        "usuario TEXT NOT NULL, " +
                        "telefono TEXT NOT NULL, " +
                        "correo TEXT NOT NULL, " +
                        "contraseña TEXT NOT NULL, " +
                        "id_rol INTEGER NOT NULL");

        createTableIfNotExists(sqLiteDatabase, TABLE_MOTOS,
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        "modelo TEXT, " +
                        "marca TEXT, " +
                        "ano INTEGER, " +
                        "manual TEXT, " +
                        "creado TEXT, " +
                        "imagen BLOB");

        createTableIfNotExists(sqLiteDatabase, TABLE_ROLES,
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        "rol_nombre TEXT NOT NULL");

        createTableIfNotExists(sqLiteDatabase, TABLE_DOCUMENTOS,
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        "id_moto INTEGER NOT NULL, " +
                        "documento BLOB");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        // Implementa la lógica de actualización si es necesario
    }

    // Método para verificar si una tabla ya existe
    private boolean tableExists(SQLiteDatabase db, String tableName) {
        Cursor cursor = db.rawQuery(
                "SELECT COUNT(*) FROM sqlite_master WHERE type = ? AND name = ?",
                new String[]{"table", tableName}
        );
        if (cursor != null) {
            try {
                cursor.moveToFirst();
                int count = cursor.getInt(0);
                return count > 0;
            } finally {
                cursor.close();
            }
        }
        return false;
    }

    // Método para crear una tabla solo si no existe
    private void createTableIfNotExists(SQLiteDatabase db, String tableName, String tableDefinition) {
        if (!tableExists(db, tableName)) {
            db.execSQL("CREATE TABLE " + tableName + "(" + tableDefinition + ")");
        }
    }
}
