package com.example.miwok2;

public class Word {
    private String mDefaultTranslation;
    private String mMiwokTranslation;
    private int mImgResourceId=NO_IMAGE_PROVIDED;
    private int mSoundId;
    private static final int NO_IMAGE_PROVIDED=-1 ;
    public Word(String defaultTranslation,String miwokTranslation,int soundId) {
        mDefaultTranslation=defaultTranslation;
        mMiwokTranslation=miwokTranslation;
        mSoundId=soundId;
    }
    public Word(String defaultTranslation,String miwokTranslation,int ImgResourceId,int soundId) {
        mDefaultTranslation=defaultTranslation;
        mMiwokTranslation=miwokTranslation;
        mImgResourceId=ImgResourceId;
        mSoundId=soundId;
    }
    public String getmDefaultTranslation() {

        return mDefaultTranslation;
    }

    public String getmMiwokTranslation() {

        return mMiwokTranslation;
    }
    public int getImgResourceId(){
        return mImgResourceId;
    }
    public boolean hasImage(){

        return mImgResourceId!=NO_IMAGE_PROVIDED;
    }
    public int getSoundId(){
        return mSoundId;
    }

}
