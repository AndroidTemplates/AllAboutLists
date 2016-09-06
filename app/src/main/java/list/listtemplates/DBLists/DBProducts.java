package list.listtemplates.DBLists;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import android.util.Log;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import list.listtemplates.WebServiceLists.VolleyDTO;

/**
 * Created by CHANDRASAIMOHAN on 8/29/2016.
 */
public class DBProducts {

    private DBHelper mHelper;
    private SQLiteDatabase mDatabase;

    public DBProducts(Context context) {
        mHelper = new DBHelper(context);
        mDatabase = mHelper.getWritableDatabase();
    }


    //Insert
    public void insertMovies(String table, List<VolleyDTO> listProds, boolean clearPrevious) {
        if (clearPrevious) {
            deleteMovies(table);
        }


        //create a sql prepared statement
        String sql = "INSERT INTO " + (table) + " VALUES (?,?,?);";
        //compile the statement and start a transaction
        SQLiteStatement statement = mDatabase.compileStatement(sql);
        mDatabase.beginTransaction();
        for (int i = 0; i < listProds.size(); i++) {
            VolleyDTO currentProd = listProds.get(i);
            statement.clearBindings();
            //for a given column index, simply bind the data to be put inside that index
            statement.bindString(2, currentProd.getVolleyLabel());
            statement.bindString(3, currentProd.getVolleyImg());

            statement.execute();
        }
        //set the transaction as successful and end the transaction
        Log.d("DBProducts","inserting entries " + listProds.size() + new Date(System.currentTimeMillis()));
        mDatabase.setTransactionSuccessful();
        mDatabase.endTransaction();
    }

    //End Insert


    //Query

    public List<VolleyDTO> readProducts(String table) {
       List<VolleyDTO> volleyList = new ArrayList<>();

        //get a list of columns to be retrieved, we need all of them
        String[] columns = {DBHelper.COLUMN_UID,
                DBHelper.COLUMN_PROD_TITLE,
                DBHelper.COLUMN_THUMBNAIL_URL,
        };
        Cursor cursor = mDatabase.query((table), columns, null, null, null, null, null);
        if (cursor != null && cursor.moveToFirst()) {
            Log.d("DBProducts","loading entries " + cursor.getCount() + new Date(System.currentTimeMillis()));
            do {

                //create a new movie object and retrieve the data from the cursor to be stored in this movie object
                VolleyDTO volleyDTO = new VolleyDTO();
                //each step is a 2 part process, find the index of the column first, find the data of that column using
                //that index and finally set our blank movie object to contain our data
                volleyDTO.setVolleyLabel(cursor.getString(cursor.getColumnIndex(DBHelper.COLUMN_PROD_TITLE)));
                volleyDTO.setVolleyImg(cursor.getString(cursor.getColumnIndex(DBHelper.COLUMN_THUMBNAIL_URL)));
                volleyList.add(volleyDTO);
            }
            while (cursor.moveToNext());
        }
        return volleyList;
    }

    public void deleteMovies(String table) {
        mDatabase.delete((table), null, null);
    }
    //End Query
    private static class DBHelper  extends SQLiteOpenHelper{

        private static final String DB_NAME = "prods_db";
        private static final int DB_VERSION = 1;
        private Context mContext;

        public static String TABLE_PRODUCTS = "products";
        public static final String COLUMN_UID = "_id";
        public static final String COLUMN_PROD_TITLE = "title";
        public static final String COLUMN_THUMBNAIL_URL = "url_thumbnail_image";

        private static final String CREATE_TABLE_PRODUCTS = "CREATE TABLE " + TABLE_PRODUCTS + " (" +
                COLUMN_UID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                COLUMN_PROD_TITLE + " TEXT," +
                COLUMN_THUMBNAIL_URL + " TEXT" +
                ");";

        public DBHelper(Context context) {
            super(context, DB_NAME, null, DB_VERSION);
            mContext = context;
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            try {
                db.execSQL(CREATE_TABLE_PRODUCTS);
                Log.d("DBHELPER","create table products executed");
            } catch (SQLiteException exception) {
                exception.printStackTrace();
            }
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            try {
                db.execSQL(" DROP TABLE " + TABLE_PRODUCTS + " IF EXISTS;");
                onCreate(db);
                Log.d("DBHELPER","upgrade table products executed");
            } catch (SQLiteException exception) {
                exception.printStackTrace();
            }
        }
    }
}
