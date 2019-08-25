package com.example.databaseprj.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.databaseprj.R;
import com.example.databaseprj.model.Contact;
import com.example.databaseprj.util.Util;

public class DataBaseHandler extends SQLiteOpenHelper {
    private final Context context;

    public DataBaseHandler(Context context) {
        super(context, Util.KEY_NAME, null, Util.DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String CREATE_CONTACT_TABLE = "CREATE TABLE" + Util.TABLE_NAME + "("
                + Util.KEY_ID + "INTEGER PRIMARY KEY," + Util.KEY_NAME + "TEXT,"
                + Util.KEY_PHONE_NUM + "TEXT" + ")";

        sqLiteDatabase.execSQL(CREATE_CONTACT_TABLE);
        onCreate(sqLiteDatabase);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        String DROP_TABLE = String.valueOf(R.string.db_drop);
        sqLiteDatabase.execSQL(DROP_TABLE, new String[]{Util.DATABASE_NAME});

    }

    public void addContact(Contact contact) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put(Util.KEY_NAME, contact.getName());
        contentValues.put(Util.KEY_PHONE_NUM, contact.getPhoneNum());

        sqLiteDatabase.insert(Util.TABLE_NAME, null, contentValues);
        sqLiteDatabase.close();
    }

    //get a contact

    public Contact getContact(int id) {
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();

        Cursor cursor = sqLiteDatabase.query(Util.TABLE_NAME, new String[]{Util.KEY_ID, Util.KEY_NAME, Util.KEY_PHONE_NUM},
                Util.KEY_ID + "=?", new String[]{String.valueOf(id)},
                null, null,null);

        if (cursor != null){
            cursor.moveToFirst();
        }
        Contact contact = new Contact();
        contact.setId(Integer.parseInt(cursor.getString(0)));
        contact.setName(cursor.getString(1));
        contact.setPhoneNum(cursor.getString(2));

        return contact;
    }
}
