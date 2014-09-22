package com.example.boardingpass.dashboard;

public interface DashBoardView {
	 
	
	    public void showProgress();

	    public void hideProgress();

	    public void showMonthlyPass();

	    public void enableMonthlyPass();

	    public void enableDayPass();

	    public void disableMonthlyPass();

	    public void disableDayPass();

	    public void navigateToHome();
}
