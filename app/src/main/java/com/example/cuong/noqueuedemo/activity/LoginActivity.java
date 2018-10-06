package com.example.cuong.noqueuedemo.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import com.example.cuong.noqueuedemo.R;
import com.example.cuong.noqueuedemo.utils.FacebookCallBackData;
import com.example.cuong.noqueuedemo.utils.FacebookHelper;
import com.facebook.accountkit.AccountKitLoginResult;
import com.facebook.accountkit.ui.AccountKitActivity;
import com.facebook.accountkit.ui.AccountKitConfiguration;
import com.facebook.accountkit.ui.LoginType;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class LoginActivity extends AppCompatActivity {
    private static final int REQUEST_CODE = 999;
    private LinearLayout mLnlLoginByPhone;
    private String TAG = "LoginActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mLnlLoginByPhone = findViewById(R.id.linear_layout_login_by_phone);
        mLnlLoginByPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginByPhone();
            }
        });
    }

    private void loginByPhone() {
        Intent intent = new Intent(LoginActivity.this, AccountKitActivity.class);
        AccountKitConfiguration.AccountKitConfigurationBuilder configurationBuilder =
                new AccountKitConfiguration.AccountKitConfigurationBuilder(LoginType.PHONE,
                        AccountKitActivity.ResponseType.TOKEN);
        intent.putExtra(AccountKitActivity.ACCOUNT_KIT_ACTIVITY_CONFIGURATION, configurationBuilder.build());
        startActivityForResult(intent, REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE) {
            final AccountKitLoginResult result = data.getParcelableExtra(AccountKitLoginResult.RESULT_KEY);
            if (result.getError() != null) {
                Log.e(TAG, result.getError().getErrorType().getMessage());
                return;
            } else if (result.wasCancelled()) {
            } else {
                FacebookHelper.handleAccountKitLogin(this, result.getAccessToken().getToken(), new FacebookCallBackData() {
                    @Override
                    public void onSuccess(boolean isLogged) {
                        if (isLogged) {
                            HomeActivity.intentToHomeActivity(LoginActivity.this);
                        }

                    }

                    @Override
                    public void onFail(String message) {
                        Log.e(TAG, message);
                    }
                });

            }


        }
    }

    public static void intentToLoginActivity(Activity activity) {
        Intent intent = new Intent(activity, LoginActivity.class);
        activity.startActivity(intent);
    }

    private void printKeyHash() {
        try {
            PackageInfo info = getPackageManager()
                    .getPackageInfo("com.passiocoffee.order.passiocoffee",
                            PackageManager.GET_SIGNATURES);
            for (Signature signature : info.signatures) {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                Log.d("KEYHASH", Base64.encodeToString(md.digest(), Base64.DEFAULT));
            }
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

}
