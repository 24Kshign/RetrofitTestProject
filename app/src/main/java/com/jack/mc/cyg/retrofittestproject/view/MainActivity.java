package com.jack.mc.cyg.retrofittestproject.view;

import android.app.Activity;
import android.os.Bundle;

import com.jack.mc.cyg.retrofittestproject.R;
import com.jack.mc.cyg.retrofittestproject.callback.ApiCallback;
import com.jack.mc.cyg.retrofittestproject.model.GitModel;
import com.jack.mc.cyg.retrofittestproject.model.login.LoginApi;
import com.jack.mc.cyg.retrofittestproject.util.CygLog;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        new LoginApi().execute(new ApiCallback<GitModel>() {
            @Override
            public void onSuccess(GitModel data) {
                CygLog.debug("successful====" + data.getData().size());
            }

            @Override
            public void onError(int status, String msg) {
                CygLog.debug("onError====" + status + "\n" + msg);
            }

            @Override
            public void onFailure() {
                CygLog.debug("onFailure");
            }
        });
    }
}
