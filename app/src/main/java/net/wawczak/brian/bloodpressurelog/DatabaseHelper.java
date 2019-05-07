//package net.wawczak.brian.bloodpressurelog;
//
//import android.content.ContentValues;
//import android.content.Context;
////import android.database.Cursor;
//import android.database.Cursor;
//import android.database.sqlite.SQLiteDatabase;
//import android.database.sqlite.SQLiteOpenHelper;
//
//
//public class DatabaseHelper extends SQLiteOpenHelper {
//
//    //create tag and declare table and column names
//
//
//    private static final String NAME_OF_TABLE = "logs_table";
//    private static final String TIME_STAMP = "time";
//
//    DatabaseHelper(Context context){
//        super(context, NAME_OF_TABLE, null, 1);
//    }
//
//    @Override
//    public void onCreate(SQLiteDatabase db) {
//        //create table
//        String createTable =
//
//                "CREATE TABLE " + NAME_OF_TABLE + " (" +
//                "ID INTEGER PRIMARY KEY AUTOINCREMENT, " + TIME_STAMP + " TEXT)";
//
//
//        db.execSQL(createTable);
//
//    }
//
//    @Override
//    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
//        db.execSQL("DROP TABLE IF EXISTS " + NAME_OF_TABLE);
//        onCreate(db);
//
//    }
//
//    boolean addData(String item) {
//        SQLiteDatabase db = this.getWritableDatabase(); //declare SQLit3e database objects
//        ContentValues contentValues = new ContentValues();
//        contentValues.put(TIME_STAMP, item);
//        long result = db.insert(NAME_OF_TABLE, null, contentValues);
//
//        //if data is inserted incorrectly it will return -1
//        return result != -1;
//    }
//
//     //gets and returns the data from the database
//    Cursor getData() {
//        SQLiteDatabase db = this.getWritableDatabase();
//        String query = "SELECT * FROM " + NAME_OF_TABLE;
//        return db.rawQuery(query, null);
//
//    }
//
//}
//
//
//
//
//
//
//
//
//
