package com.example.boardingpass.login;

import com.example.boardingpass.R;
import com.example.boardingpass.dashboard.DashBoardActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

public class LoginActivity extends Activity implements LoginView, OnClickListener{
    
	Button btnLogin;
	EditText etUsername,etPassword;
	ProgressBar progress;
	LoginPresenter presenter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		
		etUsername = (EditText)findViewById(R.id.et_username);
		etPassword = (EditText)findViewById(R.id.et_password);
		btnLogin   = (Button)findViewById(R.id.btn_login);
		progress   = (ProgressBar)findViewById(R.id.progress);
		btnLogin.setOnClickListener(this);
		presenter = new LoginPresenterImpl(this);
	}
	@Override
	public void showProgress() {
		progress.setVisibility(View.VISIBLE);
		
	}
	@Override
	public void hideProgress() {
		progress.setVisibility(View.GONE);
		
	}
	@Override
	public void setUsernameError() {
		etUsername.setError(getString(R.string.username_error));
		
	}
	@Override
	public void setPasswordError() {
		etPassword.setError(getString(R.string.password_error));
		
	}
	@Override
	public void navigateToHome() {
		Intent dashboardIntent = new Intent(LoginActivity.this, DashBoardActivity.class);
		startActivity(dashboardIntent);
		
	}
	@Override
	public void onClick(View v) {
		presenter.validateCredentials(etUsername.getText().toString(), etPassword.getText().toString());
		
	}

}
