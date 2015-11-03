package com.example.welcome;

import java.util.HashMap;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

public class Welcome extends Activity {

	boolean isFirstIn;
	public static String sMallId = "";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.welcome);

		// 获取SharedPreferences对象
		SharedPreferences sp = Welcome.this.getSharedPreferences("SP", MODE_PRIVATE);
		isFirstIn = sp.getBoolean("isFirstIn", true);
		if (isFirstIn) {
			new Handler().postDelayed(new Runnable() {
				@Override
				public void run() {
					goGuide();
				}
			}, 2000);
			Editor editor = sp.edit();
			editor.putBoolean("isFirstIn", false);
			editor.commit();
		} else {
			new Handler().postDelayed(new Runnable() {
				@Override
				public void run() {
					goHome();
				}
			}, 2000);
		}
	}

	


	private void goHome() {
		Intent intent = new Intent(Welcome.this, MainActivity.class);
		Welcome.this.startActivity(intent);
		Welcome.this.finish();
	}

	private void goGuide() {
		Intent intent = new Intent(Welcome.this, GuideViewPager.class);
		Welcome.this.startActivity(intent);
		Welcome.this.finish();
	}
}
