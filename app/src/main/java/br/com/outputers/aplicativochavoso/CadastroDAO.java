package br.com.outputers.aplicativochavoso;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.View;

/**
 * Created by Youssef on 26/11/2017.
 */

public class CadastroDAO extends SQLiteOpenHelper {

    public Cursor cursor = null;

    public static final String DATABASE_NAME = "Cadastro.db";
    public static final String TABLE_NAME = "Cadastro_table";
    public static final String COL_CADASTROU = "cadastrou";
    public static final String COL_TIPO_ROSTO = "tipo_rosto";
    public static final String COL_TIPO_CABELO = "tipo_cabelo";
    public static final String COL_TAM_CABELO = "tamanho_cabelo";
    public static final int VERSION_DATABASE = 1;

    public static final String CREATE_TABLE = "CREATE TABLE " +TABLE_NAME+" ("+COL_CADASTROU+" TEXT, "+COL_TIPO_ROSTO+" TEXT, "+COL_TIPO_CABELO+" TEXT, "+COL_TAM_CABELO+" TEXT)";

    ContentValues contentValues = new ContentValues();

    public CadastroDAO(Context context) {
        super(context, DATABASE_NAME, null, VERSION_DATABASE);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME);
        onCreate(sqLiteDatabase);
    }


    public void insertTipoRosto(String tipo_rosto){

        SQLiteDatabase db = this.getWritableDatabase();

        contentValues.put(COL_TIPO_ROSTO, tipo_rosto);
        db.insert(TABLE_NAME, null, contentValues);

    }

    public void insertTipoCabelo(String tipo_cabelo){

        SQLiteDatabase db = this.getWritableDatabase();

        contentValues.put(COL_TIPO_CABELO, tipo_cabelo);
        db.insert(TABLE_NAME, null, contentValues);
    }

    public void insertTamanhoCabelo(String tamanho_cabelo){

        SQLiteDatabase db = this.getWritableDatabase();

        contentValues.put(COL_TAM_CABELO, tamanho_cabelo);
        db.insert(TABLE_NAME, null, contentValues);
    }

    public void insertCadastrou(){

        SQLiteDatabase db = this.getWritableDatabase();

        contentValues.put(COL_CADASTROU, "sim");
        db.insert(TABLE_NAME, null, contentValues);
    }



    public String getDataTipoRosto(){

        SQLiteDatabase db = this.getReadableDatabase();

        String query = "SELECT tipo_rosto FROM "+TABLE_NAME+" WHERE tipo_rosto = tipo_rosto";
        cursor = db.rawQuery(query,null);

        if(cursor.moveToFirst()){
            String retTipoRosto = cursor.getString(cursor.getColumnIndex(COL_TIPO_ROSTO));
            cursor.close();
            return retTipoRosto;
        }else{
            return "nao";
        }
    }

    public String getDataTipoCabelo(){


        SQLiteDatabase db = this.getReadableDatabase();

        String query = "SELECT tipo_cabelo FROM "+TABLE_NAME+" WHERE tipo_cabelo = tipo_cabelo";
        cursor = db.rawQuery(query,null);

        if(cursor.moveToFirst()){
            String retTipoCabelo = cursor.getString(cursor.getColumnIndex(COL_TIPO_CABELO));
            cursor.close();
            return retTipoCabelo;
        }else{
            //cursor.close();
            return "nao";
        }
    }

    public String getDataTamanhoCabelo(){

        SQLiteDatabase db = this.getReadableDatabase();

        String query = "SELECT tamanho_cabelo FROM "+TABLE_NAME+" WHERE tamanho_cabelo = tamanho_cabelo";
        cursor = db.rawQuery(query,null);

        if(cursor.moveToFirst()){
            String retTamCabelo = cursor.getString(cursor.getColumnIndex(COL_TAM_CABELO));
            cursor.close();
            return retTamCabelo;
        }else{

            return "nao";
        }
    }

    public String getDataCadastrou(){

        SQLiteDatabase db = this.getReadableDatabase();

        String query = "SELECT cadastrou FROM "+TABLE_NAME+" WHERE cadastrou = cadastrou";
        cursor = db.rawQuery(query,null);

        if(cursor.moveToFirst()){
            String retCadastrou = cursor.getString(cursor.getColumnIndex(COL_CADASTROU));
            cursor.close();
            return retCadastrou;
        }else{
            return "nao";
        }
    }
}
