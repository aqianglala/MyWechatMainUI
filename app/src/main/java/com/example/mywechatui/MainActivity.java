package com.example.mywechatui;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TabFragment sessionFragment;
    private TabFragment contactFragment;
    private TabFragment selfInfoFragment;
    private TextView sessionBtn, contactBtn, mySelfBtn;
    private TextView lastButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sessionBtn = findViewById(R.id.session);
        contactBtn = findViewById(R.id.contact);
        mySelfBtn = findViewById(R.id.mine);

        sessionBtn.setOnClickListener(this);
        contactBtn.setOnClickListener(this);
        mySelfBtn.setOnClickListener(this);

        sessionFragment = TabFragment.newInstance("消息");
        getSupportFragmentManager().beginTransaction().replace(R.id.empty_view, sessionFragment).commitAllowingStateLoss();
    }

    @Override
    public void onClick(View v) {
        Fragment current = null;
        changeMenuState();
        switch (v.getId()) {
            case R.id.session:
                if (sessionFragment == null)
                    sessionFragment = TabFragment.newInstance("消息");
                current = sessionFragment;
                sessionBtn.setCompoundDrawablesWithIntrinsicBounds(null, getResources().getDrawable(R.mipmap.session_selected), null, null);
                lastButton = sessionBtn;
                break;
            case R.id.contact:
                if (contactFragment == null)
                    contactFragment = TabFragment.newInstance("联系人");
                current = contactFragment;
                contactBtn.setCompoundDrawablesWithIntrinsicBounds(null, getResources().getDrawable(R.mipmap.contact_selected), null, null);
                lastButton = contactBtn;
                break;
            case R.id.mine:
                if (selfInfoFragment == null)
                    selfInfoFragment = TabFragment.newInstance("我");
                current = selfInfoFragment;
                mySelfBtn.setCompoundDrawablesWithIntrinsicBounds(null, getResources().getDrawable(R.mipmap.myself_selected), null, null);
                lastButton = mySelfBtn;
                break;
        }
        if (current != null)
            getSupportFragmentManager().beginTransaction().replace(R.id.empty_view, current).commitAllowingStateLoss();
    }

    private void changeMenuState() {
        if (lastButton == null)
            return;
        switch (lastButton.getId()) {
            case R.id.session:
                sessionBtn.setCompoundDrawablesWithIntrinsicBounds(null, getResources().getDrawable(R.mipmap.session_normal), null, null);
                break;
            case R.id.contact:
                contactBtn.setCompoundDrawablesWithIntrinsicBounds(null, getResources().getDrawable(R.mipmap.contact_normal), null, null);
                break;
            case R.id.mine:
                mySelfBtn.setCompoundDrawablesWithIntrinsicBounds(null, getResources().getDrawable(R.mipmap.myself_normal), null, null);
                break;
        }
    }
}
