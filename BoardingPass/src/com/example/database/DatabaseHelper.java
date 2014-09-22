package com.example.database;

import java.sql.SQLException;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

public class DatabaseHelper extends OrmLiteSqliteOpenHelper{
	private static final String DATABASE_NAME = "helloAndroid.db";
	private static final int DATABASE_VERSION = 1;
	private Dao<BoardingPass, Integer> boardingPassDao = null;
	private RuntimeExceptionDao<BoardingPass, Integer> BoardingPassRuntimeDao = null;
	public DatabaseHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
		
	}
	@Override
	public void onCreate(SQLiteDatabase arg0, ConnectionSource connection_source) {
		try {
			Log.i(DatabaseHelper.class.getName(), "onCreate");
			TableUtils.createTable(connection_source, BoardingPass.class);
		} catch (SQLException e) {
			Log.e(DatabaseHelper.class.getName(), "Can't create database", e);
			throw new RuntimeException(e);
		}
		
	}
	@Override
	public void onUpgrade(SQLiteDatabase db, ConnectionSource connection_src, int arg2,int arg3) {
		try {
			Log.i(DatabaseHelper.class.getName(), "onUpgrade");
			TableUtils.dropTable(connection_src, BoardingPass.class, true);
			// after we drop the old databases, we create the new ones
			onCreate(db, connectionSource);
		} catch (SQLException e) {
			Log.e(DatabaseHelper.class.getName(), "Can't drop databases", e);
			throw new RuntimeException(e);
		}
	}
	
	public Dao<BoardingPass, Integer> getBoardingPassDao() throws SQLException {
		if (boardingPassDao== null) {
			boardingPassDao = getDao(BoardingPass.class);
		}
		return boardingPassDao;
	}
	
	
	public RuntimeExceptionDao<BoardingPass, Integer> getREBoardingPassDao() {
		if (BoardingPassRuntimeDao == null) {
			BoardingPassRuntimeDao = getRuntimeExceptionDao(BoardingPass.class);
		}
		return BoardingPassRuntimeDao;
	}
	@Override
	public void close() {
		super.close();
		BoardingPassRuntimeDao = null;
		boardingPassDao= null;
	}
	
	

}
