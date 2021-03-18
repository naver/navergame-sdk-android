package com.navercorp.nng.android.sample;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.navercorp.nng.android.sdk.NNGConfig;
import com.navercorp.nng.android.sdk.NNGLink;

/**
 * NAVER Game SDK Android
 * Copyright 2021-present NAVER Corp.
 *
 * Unauthorized use, modification and redistribution of this software are strongly prohibited.
 */
public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**
         * "네아로 개발자 센터"에서 받은 정보로 SDK를 초기화 합니다.
         * NNGLink의 다른 메소드를 호출하기 전에 반드시 초기화를 먼저해야 합니다.
         * 개발자 센터 주소: https://nid.naver.com/devcenter/main.nhn
         */
        String CLIEND_ID = "UKvNABLDsyEJusJGsXL2";
        String CLIENT_SECRET = "rK4suc_Qd0";
        String LOUNGE_ID = "naver_game_4developer";

        //sdk 초기화
        NNGLink.initModule(this,LOUNGE_ID, CLIEND_ID, CLIENT_SECRET);

        //sdk 배너 리스트
        findViewById(R.id.banner_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NNGLink.startHome(MainActivity.this);
            }
        });

        //sdk 점검용배너 리스트
        findViewById(R.id.sorry_banner_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NNGLink.startSorry(MainActivity.this);
            }
        });

        findViewById(R.id.orientation_button).setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
                    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
                } else {
                    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
                }
            }
        });
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }
}
