package com.lyt.hi.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.lyt.hi.R;
import com.lyt.hi.view.ClearableEditText;

import butterknife.Bind;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.login_user_edit)
    ClearableEditText loginUserEdit;
    @Bind(R.id.login_pwd_edit)
    ClearableEditText loginPwdEdit;
    @Bind(R.id.login_reg_tip)
    TextView loginRegTip;
    @Bind(R.id.login_btn)
    Button loginBtn;
    @Bind(R.id.login_forget)
    TextView loginForget;
    public static final int REQUESTCODE=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        initUI();
    }

    private void initUI() {
        loginRegTip.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login_reg_tip:
                Intent intent=new Intent(this,RegActivity.class);
                startActivityForResult(intent,REQUESTCODE);
                break;
            case R.id.login_btn:
                break;
            case R.id.login_forget:
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //返回注册成功的结果
        if (requestCode==REQUESTCODE&&resultCode==RegActivity.REG_RESULTCODE){


        }
    }
}
