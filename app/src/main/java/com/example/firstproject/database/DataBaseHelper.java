package com.example.firstproject.database;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.firstproject.model.LessonFlIdTense;
import com.example.firstproject.model.LessonFlIdWord;
import com.example.firstproject.model.LessonFlLessonIdTense;
import com.example.firstproject.model.LessonFlLessonIdWord;
import com.example.firstproject.model.LessonThroughTense;
import com.example.firstproject.model.LessonThroughWord;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

public class DataBaseHelper extends SQLiteOpenHelper {
    private static String TAG = "DataBaseHelper"; // Tag just for the LogCat window
    //destination path (location) of our database on device
    private static String DB_PATH = "";
    private static String DB_NAME = "AppEnglish.db";// Database name
    private SQLiteDatabase mDataBase;
    private final Context mContext;

    private String TABLE1 = "LessionFLWord";
    private String  ID = "idword";
    private String NAME="name";
    private String DES="describle";
    private String TABLE2 = "LessionFLTense";
    private String  ID2 = "idtense";
    private String NAME2="name";
    private String DES2="describle";
    private String TABLE3 = "LessionFlIdword";
    private String  ID3 = "id";
    private String IDWORD="idword";
    private String NAME3="name";
    private String DES3="describle";
    private String TABLE4 = "LessionFlIdtense";
    private String  ID4 = "id";
    private String IDTense="idtense";
    private String NAME4="name";
    private String DES4="describle";
    private String TABLE5="LessonFlLessonIdWord";
    private String  ID5 = "id";
    private String  THISID = "thisid";
    private String  TITLE = "Title";
    private String  subTITLE1 = "Subtitle1";
    private String TABLE6="LessonFlLessonIdTense";
    private String  ID6 = "id";
    private String  THISID1 = "thisid";
    private String  TITLE1 = "Title";
    private String  subTITLE2 = "Subtitle1";
    private void copyDataBase() throws IOException {
        InputStream mInput = mContext.getAssets().open(DB_NAME);
        String outFileName = DB_PATH + DB_NAME;
        OutputStream mOutput = new FileOutputStream(outFileName);
        byte[] mBuffer = new byte[1024];
        int mLength;
        while ((mLength = mInput.read(mBuffer)) > 0) {
            mOutput.write(mBuffer, 0, mLength);
        }
        mOutput.flush();
        mOutput.close();
        mInput.close();
    }
    public void createDataBase() {
        //If the database does not exist, copy it from the assets.

        boolean mDataBaseExist = checkDataBase();
        if (!mDataBaseExist) {
            this.getReadableDatabase();
            this.close();
            try {
                //Copy the database from assests
                copyDataBase();
                Log.e(TAG, "createDatabase database created");
            } catch (IOException mIOException) {
                throw new Error("ErrorCopyingDataBase");
            }
        }
    }

    private boolean checkDataBase() {
        File dbFile = new File(DB_PATH + DB_NAME);
        //Log.v("dbFile", dbFile + "   "+ dbFile.exists());
        return dbFile.exists();
    }
    public boolean openDataBase() throws SQLException {
        String mPath = DB_PATH + DB_NAME;
        //Log.v("mPath", mPath);
        mDataBase = SQLiteDatabase.openDatabase(mPath, null, SQLiteDatabase.CREATE_IF_NECESSARY);
        //mDataBase = SQLiteDatabase.openDatabase(mPath, null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
        return mDataBase != null;
    }
    @Override
    public synchronized void close() {
        if (mDataBase != null)
            mDataBase.close();
        super.close();
    }
    public DataBaseHelper(Context context) {
        super(context, DB_NAME, null, 1);// 1? Its database Version
        if (android.os.Build.VERSION.SDK_INT >= 17) {
            DB_PATH = context.getApplicationInfo().dataDir + "/databases/";
        } else {
            DB_PATH = "/data/data/" + context.getPackageName() + "/databases/";
        }
        this.mContext = context;
    }
    public ArrayList<LessonThroughWord> getAllLessionByWord(){
        ArrayList<LessonThroughWord> words=new ArrayList<>();
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        String SQL = "SELECT * FROM " + TABLE1 ;

        Cursor cursor = sqLiteDatabase.rawQuery(SQL, null);
        Log.e("sdasda",cursor.getCount()+"");
        if (cursor != null) {
            if (cursor.getCount() > 0) {

                cursor.moveToFirst();

                while (!cursor.isAfterLast()) {

                    LessonThroughWord word = new LessonThroughWord() ;

                    word.id=cursor.getInt(cursor.getColumnIndex(ID));
                    word.title=cursor.getString(cursor.getColumnIndex(NAME));
                    word.des=cursor.getString(cursor.getColumnIndex(DES));
                    words.add(word);
                    cursor.moveToNext();

                }
                cursor.close();
            }
        }
        return words;
    }
    public ArrayList<LessonThroughTense> getAllLessionByTense(){
        ArrayList<LessonThroughTense> tenses=new ArrayList<>();
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        String SQL = "SELECT * FROM " + TABLE2 ;

        Cursor cursor = sqLiteDatabase.rawQuery(SQL, null);
        Log.e("sdasda",cursor.getCount()+"");
        if (cursor != null) {
            if (cursor.getCount() > 0) {

                cursor.moveToFirst();

                while (!cursor.isAfterLast()) {

                    LessonThroughTense tense = new LessonThroughTense() ;

                    tense.Id=cursor.getInt(cursor.getColumnIndex(ID2));
                    tense.title=cursor.getString(cursor.getColumnIndex(NAME2));
                    tense.Des=cursor.getString(cursor.getColumnIndex(DES2));
                    tenses.add(tense);
                    cursor.moveToNext();

                }
                cursor.close();
            }
        }
        return tenses;
    }
    public ArrayList<LessonFlIdWord> getAllLessonFlIdWord(String wordid){
        ArrayList<LessonFlIdWord> idWords=new ArrayList<>();
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        String selectQuery = "select * from " + TABLE3 + " where idword='" + wordid + "'";
        Cursor cursor=sqLiteDatabase.rawQuery(selectQuery,null);
        if (cursor != null) {
            if (cursor.getCount() > 0) {

                cursor.moveToFirst();

                while (!cursor.isAfterLast()) {

                    LessonFlIdWord idWord = new LessonFlIdWord() ;

                    idWord.id=cursor.getInt(cursor.getColumnIndex(ID3));
                    idWord.idword=cursor.getInt(cursor.getColumnIndex(IDWORD));
                    idWord.name=cursor.getString(cursor.getColumnIndex(NAME3));
                    idWord.des=cursor.getString(cursor.getColumnIndex(DES3));
                    idWords.add(idWord);
                    cursor.moveToNext();

                }
                cursor.close();
            }
        }
        return idWords;
    }
    public ArrayList<LessonFlIdTense> getAllLessonFlIdtense(String tenseid){
        ArrayList<LessonFlIdTense> idTenses=new ArrayList<>();
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        String selectQuery = "select * from " + TABLE4 + " where idtense='" + tenseid + "'";
        Cursor cursor=sqLiteDatabase.rawQuery(selectQuery,null);
        if (cursor != null) {
            if (cursor.getCount() > 0) {

                cursor.moveToFirst();

                while (!cursor.isAfterLast()) {

                    LessonFlIdTense idTense = new LessonFlIdTense() ;

                    idTense.id=cursor.getInt(cursor.getColumnIndex(ID4));
                    idTense.idtense=cursor.getInt(cursor.getColumnIndex(IDTense));
                    idTense.name=cursor.getString(cursor.getColumnIndex(NAME4));
                    idTense.des=cursor.getString(cursor.getColumnIndex(DES4));
                    idTenses.add(idTense);
                    cursor.moveToNext();

                }
                cursor.close();
            }
        }
        return idTenses;
    }
    public ArrayList<LessonFlLessonIdWord> getAllLessonFlLessonIdWord(String id){
        ArrayList<LessonFlLessonIdWord> lessonFlLessonIdWords=new ArrayList<>();
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        String selectQuery = "select * from " + TABLE5 + " where id='" + id + "'";
        Cursor cursor=sqLiteDatabase.rawQuery(selectQuery,null);
        if (cursor != null) {
            if (cursor.getCount() > 0) {

                cursor.moveToFirst();

                while (!cursor.isAfterLast()) {

                    LessonFlLessonIdWord lessonFlLessonIdWord = new LessonFlLessonIdWord() ;

                    lessonFlLessonIdWord.id=cursor.getInt(cursor.getColumnIndex(ID5));
                    lessonFlLessonIdWord.thisid=cursor.getInt(cursor.getColumnIndex(THISID));
                    lessonFlLessonIdWord.title=cursor.getString(cursor.getColumnIndex(TITLE));
                    lessonFlLessonIdWord.subtitle1=cursor.getString(cursor.getColumnIndex(subTITLE1));

                    lessonFlLessonIdWords.add(lessonFlLessonIdWord);
                    cursor.moveToNext();

                }
                cursor.close();
            }
        }
        return lessonFlLessonIdWords;
    }
    public ArrayList<LessonFlLessonIdTense> getAllLessonFlLessonIdtense(String id){
        ArrayList<LessonFlLessonIdTense> lessonFlLessonIdTenses=new ArrayList<>();
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        String selectQuery = "select * from " + TABLE6 + " where id='" + id + "'";
        Cursor cursor=sqLiteDatabase.rawQuery(selectQuery,null);
        if (cursor != null) {
            if (cursor.getCount() > 0) {

                cursor.moveToFirst();

                while (!cursor.isAfterLast()) {

                    LessonFlLessonIdTense lessonFlLessonIdTense=new LessonFlLessonIdTense();
                    lessonFlLessonIdTense.id=cursor.getInt(cursor.getColumnIndex(ID6));
                    lessonFlLessonIdTense.thisid=cursor.getInt(cursor.getColumnIndex(THISID1));
                    lessonFlLessonIdTense.title=cursor.getString(cursor.getColumnIndex(TITLE1));
                    lessonFlLessonIdTense.subtitle1=cursor.getString(cursor.getColumnIndex(subTITLE2));

                    lessonFlLessonIdTenses.add(lessonFlLessonIdTense);
                    cursor.moveToNext();

                }
                cursor.close();
            }
        }
        return lessonFlLessonIdTenses;
    }
    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
