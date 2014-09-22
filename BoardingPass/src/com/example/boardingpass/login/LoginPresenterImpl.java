package com.example.boardingpass.login;



public class LoginPresenterImpl implements LoginPresenter,onLoginFinishedListner{
	 private LoginView loginView;
	 private LoginInteractor loginInteractor;
	 
	 
	public LoginPresenterImpl(LoginView loginView) {
		this.loginView = loginView;
		loginInteractor = new LoginInteractorImpl();
	}

	@Override
	public void validateCredentials(String username, String password) {
	  loginView.showProgress();
	  loginInteractor.login(username, password, this);
		
	}

	@Override
	public void onUsernameError() {
		loginView.setUsernameError();
		loginView.hideProgress();
		
	}

	@Override
	public void onPasswordError() {
       loginView.setPasswordError();
       loginView.hideProgress();
		
	}

	@Override
	public void onSuccess() {
		loginView.navigateToHome();
		
	}

}
