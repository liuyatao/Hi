package com.lyt.hi.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.lyt.hi.R;
import com.lyt.hi.model.HiUser;
import com.lyt.hi.view.ClearableEditText;

import butterknife.Bind;
import butterknife.ButterKnife;
import cn.bmob.v3.listener.SaveListener;

public class RegActivity extends AppCompatActivity {

    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.reg_user_edit)
    ClearableEditText regUserEdit;
    @Bind(R.id.reg_pwd_edit)
    ClearableEditText regPwdEdit;
    @Bind(R.id.reg_email_edit)
    ClearableEditText regEmailEdit;
    @Bind(R.id.reg_btn)
    Button regBtn;

    ProgressDialog loadProgressDialog;

    String userNameStr, pwdStr, emailStr;
    @Bind(R.id.coordinatorLayout)
    CoordinatorLayout coordinatorLayout;

    public static final int  REG_RESULTCODE=2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);
        ButterKnife.bind(this);
        initUI();
    }

    private void initUI() {
        regBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadProgressDialog = new ProgressDialog(RegActivity.this, R.style.AppTheme_Dialog);
                loadProgressDialog.setCancelable(false);
                loadProgressDialog.setMessage("正在加载...");
                loadProgressDialog.show();
                HiUser hiUser = new HiUser();
                hiUser.setUsername(regUserEdit.getText().toString());
                hiUser.setPassword(regPwdEdit.getText().toString());
                hiUser.setEmail(regEmailEdit.getText().toString());
                hiUser.signUp(RegActivity.this, new SaveListener() {
                    @Override
                    public void onSuccess() {
                        loadProgressDialog.dismiss();
                        Snackbar.make(coordinatorLayout,"注册成功！",Snackbar.LENGTH_LONG).show();
                        Intent intent=new Intent(RegActivity.this,LoginActivity.class);
                        setResult(REG_RESULTCODE,intent);
                        finish();
                    }

                    @Override
                    public void onFailure(int i, String s) {
                        loadProgressDialog.dismiss();
                        Snackbar.make(coordinatorLayout,"注册失败！",Snackbar.LENGTH_LONG).setAction(s, new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                            }
                        }).show();
                    }
                });
            }
        });
    }
}
