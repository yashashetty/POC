package com.example.boardingpass.login;

public interface LoginView {
	    public void showProgress();

	    public void hideProgress();

	    public void setUsernameError();

	    public void setPasswordError();

	    public void navigateToHome();
}
