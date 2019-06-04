package com.example.mywechatui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class TabFragment extends Fragment {

    private static final String KEY_TITLE = "key_title";
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_tab, container, false);
        Bundle arguments = getArguments();
        if (arguments != null){
            String title = arguments.getString(KEY_TITLE);
            TextView tv_title = inflate.findViewById(R.id.tv_title);
            tv_title.setText(title);
        }
        return inflate;
    }

    public static TabFragment newInstance(String title){
        TabFragment tabFragment = new TabFragment();
        Bundle bundle = new Bundle();
        bundle.putString(KEY_TITLE, title);
        tabFragment.setArguments(bundle);
        return tabFragment;
    }
}
