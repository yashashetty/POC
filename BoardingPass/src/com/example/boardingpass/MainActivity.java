package com.example.boardingpass;

import java.sql.SQLException;
import java.util.List;

import com.example.database.BoardingPass;
import com.example.database.DatabaseHelper;
import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.RuntimeExceptionDao;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {
	DatabaseHelper databaseHelper;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//insertToDB();
		retriveFromDB();
	}

	private void retriveFromDB() {
		Dao<BoardingPass, Integer> simpleDao;
		try {
			simpleDao = getHelper().getBoardingPassDao();
		
	//	List<BoardingPass> list = simpleDao.queryForAll();
		
		List<BoardingPass>passes = simpleDao.queryBuilder().where().eq(BoardingPass.ID, 1).query();
		Toast.makeText(getApplicationContext(), "The rwcods available"+passes.size(), Toast.LENGTH_SHORT).show();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void insertToDB() {
		RuntimeExceptionDao<BoardingPass, Integer> simpleDao = getHelper().getREBoardingPassDao();
		long millis = System.currentTimeMillis();
		BoardingPass boarding_pass = new BoardingPass(0, "BMTC1123", millis, millis);
		simpleDao.create(boarding_pass);
	}
	private DatabaseHelper getHelper() {
		if (databaseHelper == null) {
			databaseHelper = OpenHelperManager.getHelper(this, DatabaseHelper.class);
		}
		return databaseHelper;
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
