package savetxt.hxzdsb.bh.savetxt.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import savetxt.hxzdsb.bh.savetxt.R;

/**
 * Created by Administrator on 2018/1/10.
 */

public class NewFragment extends Fragment implements View.OnClickListener {
    private TextView tv_new_fragment;

    public NewFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_new, container, false);


        tv_new_fragment = (TextView) view.findViewById(R.id.tv_new_fragemnt);

        tv_new_fragment.setText("这是新闻");

        tv_new_fragment.setOnClickListener(this);
        return view;


    }


    @Override
    public void onClick(View v) {

    }
}
