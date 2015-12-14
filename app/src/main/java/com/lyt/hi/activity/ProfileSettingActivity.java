package com.lyt.hi.activity;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.lyt.hi.R;
import com.lyt.hi.view.ClearableEditText;

import java.util.Calendar;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ProfileSettingActivity extends AppCompatActivity implements View.OnClickListener {

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_setting);
        ButterKnife.bind(this);
        cardSettingAffair.setOnClickListener(this);
        cardSettingBriefIntro.setOnClickListener(this);
        cardSettingDate.setOnClickListener(this);
        cardSettingGendar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        builder=new AlertDialog.Builder(this,R.style.AppTheme_Dialog);
        switch (v.getId()){
            case R.id.card_setting_affair:
                final String[] strings=new String[]{"保密","单身", "恋爱中","已婚"};
                builder.setTitle("恋爱状况：").setSingleChoiceItems(strings, 0, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                }).setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        affairValue.setText(strings[which]);
                    }
                }).show();
                break;
            case R.id.card_setting_briefIntro:
                final ClearableEditText editText=new ClearableEditText(this);
                ViewGroup.LayoutParams layoutParams=new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                editText.setPadding(30,30,30,30);
                builder.setView(editText).setTitle("一句话介绍自己").setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        briefIntroValue.setText(editText.getText().toString());
                    }
                }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                }).show();

                break;
            case R.id.card_setting_date:
                Calendar calendar=Calendar.getInstance();
                DatePickerDialog pickerDialog=new DatePickerDialog(this, R.style.AppTheme_Dialog, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        dateValue.setText(year+"年"+monthOfYear+"月"+dayOfMonth+"日");                    }
                },calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH));
                pickerDialog.show();
                break;
            case R.id.card_setting_gendar:
                final String[] strings1=new String[]{"保密","男", "女",};

                builder.setTitle("您的性别：").setSingleChoiceItems(strings1, -1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        gendarValue.setText(strings1[which]);

                    }
                }).setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Log.e("which",which+"");
                    }
                }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                }).show();
                break;
        }

    }

}
