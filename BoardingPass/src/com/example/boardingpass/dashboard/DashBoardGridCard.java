package com.example.boardingpass.dashboard;



import com.example.boardingpass.R;

import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;



import it.gmariotti.cardslib.library.internal.Card;
import it.gmariotti.cardslib.library.internal.CardHeader;
import it.gmariotti.cardslib.library.internal.CardThumbnail;
import it.gmariotti.cardslib.library.internal.Card.OnCardClickListener;
import it.gmariotti.cardslib.library.internal.base.BaseCard;

public class DashBoardGridCard extends Card {
	 protected TextView mTitle;
     protected TextView mSecondaryTitle;
     protected RatingBar mRatingBar;
     protected int resourceIdThumbnail = -1;
     protected int count;

     protected String headerTitle;
     protected String secondaryTitle;
     protected float rating;
    public DashBoardGridCard(Context context) {
        super(context, R.layout.carddemo_gplay_inner_content);
    }
    void init() {
        CardHeader header = new CardHeader(getContext());
        header.setButtonOverflowVisible(true);
        
        header.setTitle(headerTitle);
        
     
        setOnClickListener( new OnCardClickListener() {
			
			@Override
			public void onClick(Card card, View view) {
				int card_type = card.getType();
				 Toast.makeText(getContext(), "card_type " + card_type, Toast.LENGTH_SHORT).show();
			}
		});
       
        addCardHeader(header);

        CardThumbnail thumbnail = new CardThumbnail(getContext());
        if (resourceIdThumbnail > -1)
            thumbnail.setDrawableResource(resourceIdThumbnail);
        else
            thumbnail.setDrawableResource(R.drawable.ic_launcher);
        addCardThumbnail(thumbnail);

    
    }
	@Override
	public void setupInnerViewElements(ViewGroup parent, View view) {
		// TODO Auto-generated method stub
		 TextView subtitle = (TextView) view.findViewById(R.id.carddemo_gplay_main_inner_subtitle);
         subtitle.setText(secondaryTitle);
	}
}
