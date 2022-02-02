package com.example.miwok2;

import android.app.Activity;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

    public class WordAdapter extends ArrayAdapter<Word> {
        private int colId;
        public WordAdapter(Activity context, ArrayList<Word> words, int id) {
            // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
            // the second argument is used when the ArrayAdapter is populating a single TextView.
            // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
            // going to use this second argument, so it can be any value. Here, we used 0.
            super(context, 0, words);
            colId=id;
        }

        /**
         * Provides a view for an AdapterView (ListView, GridView, etc.)
         *
         * @param position The position in the list of data that should be displayed in the
         *                 list item view.
         * @param convertView The recycled view to populate.
         * @param parent The parent ViewGroup that is used for inflation.
         * @return The View for the position in the AdapterView.
         */
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            // Check if the existing view is being reused, otherwise inflate the view
            View listItemView = convertView;
            if(listItemView == null) {
                listItemView = LayoutInflater.from(getContext()).inflate(
                        R.layout.list_view, parent, false);
            }

            // Get the {@link AndroidFlavor} object located at this position in the list
            Word currentword = getItem(position);

            // Find the TextView in the list_item.xml layout with the ID version_name
            TextView miwokTextView = (TextView) listItemView.findViewById(R.id.miwok);
            // Get the version name from the current AndroidFlavor object and
            // set this text on the name TextView
            miwokTextView.setText(currentword.getmMiwokTranslation());

            // Find the TextView in the list_item.xml layout with the ID version_number
            TextView defaultTextView = (TextView) listItemView.findViewById(R.id.english);
            // Get the version number from the current AndroidFlavor object and
            // set this text on the number TextView
            defaultTextView.setText(currentword.getmDefaultTranslation());
            ImageView setimg = (ImageView) listItemView.findViewById(R.id.img);
            if(currentword.hasImage()==true) {

                setimg.setImageResource(currentword.getImgResourceId());
            }
            else {
                setimg.setVisibility(View.GONE);
            }
            //view selection
            View textContainer=listItemView.findViewById(R.id.textContainer);
            //converting color id to color
            int color= ContextCompat.getColor(getContext(),colId);
            //setting up the color
            textContainer.setBackgroundColor(color);


            // Return the whole list item layout (containing 2 TextViews and an ImageView)
            // so that it can be shown in the ListView
            return listItemView;
        }
    }

