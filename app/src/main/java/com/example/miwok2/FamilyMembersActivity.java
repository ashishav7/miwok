package com.example.miwok2;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyMembersActivity extends AppCompatActivity {
    private MediaPlayer mMediaPlayer;
    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mMediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mMediaPlayer.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mMediaPlayer = null;
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_family_members);
        final ArrayList<Word> fm=new ArrayList<Word>();
        fm.add(new Word("father","әpә",R.drawable.family_father,R.raw.family_father));
        fm.add(new Word("mother","әṭa",R.drawable.family_mother,R.raw.family_mother));
        fm.add(new Word("son","angsi",R.drawable.family_son,R.raw.family_son));
        fm.add(new Word("daughter","tune",R.drawable.family_daughter,R.raw.family_daughter));
        fm.add(new Word("older brother","taachi",R.drawable.family_older_brother,R.raw.family_older_brother));
        fm.add(new Word("younger brother","chalitti",R.drawable.family_younger_brother,R.raw.family_younger_brother));
        fm.add(new Word("older sister","tete",R.drawable.family_older_sister,R.raw.family_older_sister));
        fm.add(new Word("younger sister","kolliti",R.drawable.family_younger_sister,R.raw.family_younger_sister));
        fm.add(new Word("grandmother","ama",R.drawable.family_grandmother,R.raw.family_grandmother));
        fm.add(new Word("grandfather","paapa",R.drawable.family_grandfather,R.raw.family_grandfather));
        WordAdapter members=new WordAdapter(this,fm,R.color.green);
        ListView name=(ListView)findViewById(R.id.fam);
        name.setAdapter(members);

        name.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Word word=fm.get(position);
                releaseMediaPlayer();
                mMediaPlayer=MediaPlayer.create(FamilyMembersActivity.this,word.getSoundId());
                mMediaPlayer.start();
                mMediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        releaseMediaPlayer();
                    }
                });
            }
        });
    }
}