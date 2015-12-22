package com.lyt.hi.activity;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import com.amap.api.location.AMapLocation;
import com.bmob.BmobProFile;
import com.bmob.btp.callback.UploadListener;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.github.siyamed.shapeimageview.BubbleImageView;
import com.github.siyamed.shapeimageview.CircularImageView;
import com.lyt.hi.R;
import com.lyt.hi.app.HiApplication;
import com.lyt.hi.model.HeadImage;
import com.lyt.hi.model.HiUser;
import com.lyt.hi.view.ClearableEditText;
import com.orhanobut.logger.Logger;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import butterknife.Bind;
import butterknife.ButterKnife;
import cn.bmob.v3.datatype.BmobDate;
import cn.bmob.v3.datatype.BmobFile;
import cn.bmob.v3.datatype.BmobGeoPoint;
import cn.bmob.v3.listener.SaveListener;
import me.iwf.photopicker.PhotoPickerActivity;
import me.iwf.photopicker.utils.PhotoPickerIntent;

public class ProfileSettingActivity extends AppCompatActivity implements View.OnClickListener {

    private static final int REQUESTCODE = 0;
    @Bind(R.id.toolbar)
    Toolbar toolbar;

    @Bind(R.id.gendar_value)
    TextView gendarValue;
    @Bind(R.id.card_setting_gendar)
    CardView cardSettingGendar;
    @Bind(R.id.date_value)
    TextView dateValue;
    @Bind(R.id.card_setting_date)
    CardView cardSettingDate;
    @Bind(R.id.affair_value)
    TextView affairValue;
    @Bind(R.id.card_setting_affair)
    CardView cardSettingAffair;
    @Bind(R.id.briefIntro_value)
    TextView briefIntroValue;
    @Bind(R.id.card_setting_briefIntro)
    CardView cardSettingBriefIntro;
    @Bind(R.id.setting_save)
    Button settingSave;
    AlertDialog.Builder builder;
    @Bind(R.id.headImage)
    CircularImageView headImage;

    private int sexSelected = 0;
    private int affairSelected = 0;
    private Calendar daySelected = Calendar.getInstance();

    private String affair;
    private String brirfIntro;
    private String sex;
    private BmobDate birthday;
    private String headImageLocalPath;

    private String[] affairArray;
    private String[] sexArray;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_setting);
        ButterKnife.bind(this);
        cardSettingAffair.setOnClickListener(this);
        cardSettingBriefIntro.setOnClickListener(this);
        cardSettingDate.setOnClickListener(this);
        cardSettingGendar.setOnClickListener(this);
        headImage.setOnClickListener(this);
        settingSave.setOnClickListener(this);

        affairArray = getResources().getStringArray(R.array.affairArray);
        sexArray = getResources().getStringArray(R.array.sexArray);
    }

    @Override
    public void onClick(View v) {
        builder = new AlertDialog.Builder(this, R.style.AppTheme_Dialog);
        switch (v.getId()) {
            case R.id.card_setting_affair:
                builder.setTitle("恋爱状况：").setSingleChoiceItems(affairArray, affairSelected, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        affairSelected = which;
                        affairValue.setText(affairArray[which]);
                        affair = affairArray[which];
                    }
                }).setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                }).show();
                break;
            case R.id.card_setting_briefIntro:
                final ClearableEditText editText = new ClearableEditText(this);
                ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                editText.setPadding(30, 30, 30, 30);
                builder.setView(editText).setTitle("一句话介绍自己").setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        briefIntroValue.setText(editText.getText().toString());
                        brirfIntro = editText.getText().toString();
                    }
                }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                }).show();

                break;
            case R.id.card_setting_date:
                DatePickerDialog pickerDialog = new DatePickerDialog(this, R.style.AppTheme_Dialog, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        dateValue.setText(year + "年" + monthOfYear + "月" + dayOfMonth + "日");
                        daySelected.set(year, monthOfYear, dayOfMonth);
                        birthday = new BmobDate(new Date(year, monthOfYear, dayOfMonth));
                    }
                }, daySelected.get(Calendar.YEAR), daySelected.get(Calendar.MONTH), daySelected.get(Calendar.DAY_OF_MONTH));
                pickerDialog.show();
                break;
            case R.id.card_setting_gendar:

                builder.setTitle("您的性别：").setSingleChoiceItems(sexArray, sexSelected, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        sexSelected = which;
                        gendarValue.setText(sexArray[which]);
                        sex = sexArray[which];
                    }
                }).setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                }).show();
                break;
            case R.id.headImage:
                PhotoPickerIntent photoPickerIntent = new PhotoPickerIntent(this);
                photoPickerIntent.setPhotoCount(1);
                startActivityForResult(photoPickerIntent, REQUESTCODE);
                break;
            case R.id.setting_save:
                progressDialog = new ProgressDialog(this, R.style.AppTheme_Dialog);
                progressDialog.setCancelable(false);
                progressDialog.show();
                save();

                break;
        }

    }

    private void save() {
        BmobProFile.getInstance(this).upload(headImageLocalPath, new UploadListener() {
            @Override
            public void onSuccess(String s, String s1, BmobFile bmobFile) {
                Logger.e("文件名称", s);
                Logger.e("可访问地址", s1);
                //图片实体
                final HeadImage headImage = new HeadImage();
                headImage.setFileName(s);
                headImage.setUrl(s1);
                headImage.save(ProfileSettingActivity.this, new SaveListener() {
                    @Override
                    public void onSuccess() {
                        HiApplication hiApplication= (HiApplication) getApplicationContext();
                        HiUser hiUser = hiApplication.getHiUser();
                        hiUser.setHeadImage(headImage);
                        AMapLocation aMapLocation=hiApplication.getaMapLocation();
                        hiUser.setLocation(new BmobGeoPoint(aMapLocation.getLongitude(),aMapLocation.getLatitude()));
                        hiUser.save(ProfileSettingActivity.this, new SaveListener() {
                            @Override
                            public void onSuccess() {
                                Logger.e("保存成功","保存成功");
                                progressDialog.dismiss();

                            }
                            @Override
                            public void onFailure(int i, String s) {
                                Logger.e("msg",s);

                            }
                        });
                    }

                    @Override
                    public void onFailure(int i, String s) {

                    }
                });
            }

            @Override
            public void onProgress(int i) {

            }

            @Override
            public void onError(int i, String s) {

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUESTCODE && resultCode == RESULT_OK) {
            if (data != null) {
                ArrayList<String> photos = data.getStringArrayListExtra(PhotoPickerActivity.KEY_SELECTED_PHOTOS);
                headImageLocalPath = photos.get(0);
                Glide.with(this).load(headImageLocalPath).asBitmap().centerCrop().into(new BitmapImageViewTarget(headImage) {
                    @Override
                    protected void setResource(Bitmap resource) {
                        RoundedBitmapDrawable circularBitmapDrawable = RoundedBitmapDrawableFactory.create(getResources(), resource);
                        circularBitmapDrawable.setCircular(true);
                        headImage.setImageDrawable(circularBitmapDrawable);
                    }
                });
            }
        }
    }
}
