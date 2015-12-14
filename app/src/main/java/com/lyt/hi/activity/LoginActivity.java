package com.lyt.hi.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.lyt.hi.R;
import com.lyt.hi.app.HiApplication;
import com.lyt.hi.model.HiUser;
import com.lyt.hi.view.ClearableEditText;

import butterknife.Bind;
import butterknife.ButterKnife;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.listener.SaveListener;

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
    public static final int REQUESTCODE = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        initUI();
        if (null!=BmobUser.getCurrentUser(this)){
            Intent intent=new Intent(this,MainActivity.class);
            startActivity(intent);
            finish();
        }
    }

    private void initUI() {
        loginRegTip.setOnClickListener(this);
        loginBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
           /* case R.id.login_reg_tip:
                Intent intent = new Intent(this, RegActivity.class);
                startActivityForResult(intent, REQUESTCODE);
                break;*/
            case R.id.login_btn:
                dologin();
                break;
            case R.id.login_forget:
                break;
        }
    }

    /**
     * 登陆
     */
    private void dologin() {
        final ProgressDialog progressDialog = new ProgressDialog(this, R.style.AppTheme_Dialog);
        progressDialog.show();
        HiUser hiUser = new HiUser();
        hiUser.setUsername(loginUserEdit.getText().toString());
        hiUser.setPassword(loginPwdEdit.getText().toString());
        HiApplication.getInstance().setHiUser(hiUser);


        hiUser.login(this, new SaveListener() {
            @Override
            public void onSuccess() {
                progressDialog.dismiss();
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
                LoginActivity.this.finish();
            }

            @Override
            public void onFailure(int i, String s) {
                progressDialog.dismiss();
                Toast.makeText(LoginActivity.this, s, Toast.LENGTH_LONG).show();
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //返回注册成功的结果
      /*  if (requestCode == REQUESTCODE && resultCode == RegActivity.REG_RESULTCODE) {
            loginUserEdit.setText(data.getStringExtra("userName"));;
            loginPwdEdit.setText(data.getStringExtra("pwd"));
            dologin();
        }*/
    }
}
