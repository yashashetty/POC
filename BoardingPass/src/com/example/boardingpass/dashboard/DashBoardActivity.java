package com.example.boardingpass.dashboard;


import it.gmariotti.cardslib.library.internal.Card;
import it.gmariotti.cardslib.library.internal.CardGridArrayAdapter;
import it.gmariotti.cardslib.library.view.CardGridView;

import java.util.ArrayList;

import com.example.boardingpass.R;


import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;

public class DashBoardActivity extends Activity implements DashBoardView{
	ArrayList<Card>	displaycards;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dashboard);
		init();
	}

	private void init() {
		displaycards = setGridcards();
		CardGridArrayAdapter mCardArrayAdapter = new CardGridArrayAdapter(this, displaycards);
      // mCardArrayAdapter.getCardGridView().setGravity(Gravity.CENTER);
        CardGridView listView = (CardGridView) this.findViewById(R.id.carddemo_grid_base1);
        if (listView != null) {
            listView.setAdapter(mCardArrayAdapter);
        }
		
	}

	private ArrayList<Card> setGridcards() {
		ArrayList<Card> cards = new ArrayList<Card>();
		   DashBoardGridCard card = new DashBoardGridCard(this);
		   card.headerTitle = getString(R.string.intl_flight);
		   card.setId("1");
		   card.setTitle(getString(R.string.intl_flight_subtitle));
		   card.setType(BoardingTypeConstants.INTERNATIONAL_FLIGHT);
        card.secondaryTitle = getString(R.string.intl_flight_subtitle);
        card.resourceIdThumbnail = R.drawable.ic_intll_flight;
        
        card.init();
        cards.add(card);
        
      //office
        
        card = new DashBoardGridCard(this);
		   card.headerTitle = getString(R.string.domestic_flight);
		   card.setId("2");
		   card.setTitle(getString(R.string.domestic_flight));
		   card.setType(BoardingTypeConstants.DOMESTIC_FLIGHT);
        card.secondaryTitle = getString(R.string.domestic_flight_subtitle);
        card.resourceIdThumbnail = R.drawable.ic_domestic_flight;
        
        card.init();
        cards.add(card);
        
       //Driving 
        card = new DashBoardGridCard(this);
		   card.headerTitle = getString(R.string.bus);
        card.secondaryTitle = getString(R.string.bus_subtitle);
        card.setId("3");
        card.setType(BoardingTypeConstants.BUS);
        card.setTitle(getString(R.string.bus_subtitle));
        card.resourceIdThumbnail = R.drawable.ic_bus;
        card.init();
        cards.add(card);
    
		   return cards;
		
	}

	private void showDashBoard() {
		
		
	}

	@Override
	public void showProgress() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hideProgress() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onCardClick(int type) {
		// TODO Auto-generated method stub
		
	}

	

}
