package dev.everest.myapplication;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private LinearLayout layout1;
    private LinearLayout layout2;
    private Button mLater;
    private Button mNow;
    private int mVersionCode;
    private Context context;
    public  final String TAG=MainActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        mVersionCode=getVersionCode();
        if(mVersionCode>1){
            layout1.setVisibility(View.VISIBLE);
            layout2.setVisibility(View.GONE);
        }else {
            layout2.setVisibility(View.VISIBLE);
            layout1.setVisibility(View.GONE);
        }

    }
    public void init(){
        layout1=findViewById(R.id.layout1);
        layout2=findViewById(R.id.layout2);
        mLater=findViewById(R.id.btn_later);
        mNow=findViewById(R.id.btn_now);
        mLater.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e(TAG,"later");
            }
        });
    }

    /**
     * 获取版本信息
     * @return
     */
    private String getVersionName() {
        PackageManager packageManager = getPackageManager();
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(getPackageName(), 0);//获取包的信息
            int versionCode = packageInfo.versionCode;
            String versionName = packageInfo.versionName;
            return versionName;

        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return "";
    }
    /**
     * 获取版本号
     * @return
     */
    private int getVersionCode() {
        PackageManager packageManager = getPackageManager();
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(getPackageName(), 0);//获取包的信息
            int versionCode = packageInfo.versionCode;
            return versionCode;

        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return -1;
    }

}
