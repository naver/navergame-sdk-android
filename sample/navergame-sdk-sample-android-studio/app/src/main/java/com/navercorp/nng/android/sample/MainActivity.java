package com.navercorp.nng.android.sample;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.navercorp.nng.android.sdk.NNGCallbackListener;
import com.navercorp.nng.android.sdk.NNGLink;

import org.jetbrains.annotations.NotNull;

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
        NNGLink.setSdkLoadListener(new NNGCallbackListener() {
            @Override
            public void onSdkDidLoaded() {

            }

            @Override
            public void onSdkDidUnloaded() {

            }

            @Override
            public void onCallInGameMenuCode(@NotNull String inGameMenuCode) {
                Toast.makeText(MainActivity.this,"onCallInGameMenuCode [" + inGameMenuCode + "]",Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNaverLoggedIn() {

            }

            @Override
            public void onNaverLoggedOut() {

            }
        });
        initListener();
    }

    private void initListener () {

        //sdk 배너 리스트
        findViewById(R.id.start_home_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NNGLink.startHome(MainActivity.this);
            }
        });

        //sdk 점검용배너 리스트
        findViewById(R.id.start_sorry_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NNGLink.startSorry(MainActivity.this);
            }
        });

        //sdk 글목록 리스트
        findViewById(R.id.start_board_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText boardIdEdit = findViewById(R.id.boardId_edit);
                try {
                    int boardId = Integer.parseInt(boardIdEdit.getText().toString());
                    NNGLink.startBoard(MainActivity.this, boardId);
                } catch (Exception e) {

                }
            }
        });

        //sdk 글상세
        findViewById(R.id.start_feed_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    EditText feedIdEdit = findViewById(R.id.feedId_edit);
                    long feedId = Integer.parseInt(feedIdEdit.getText().toString());
                    NNGLink.startFeed(MainActivity.this, feedId, false);
                } catch (Exception e) {

                }
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
