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

public class MusicFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_music, container, false);
        TextView tv_music = (TextView) view.findViewById(R.id.tv_music_fragment);
        tv_music.setText("这是音乐");
        tv_music.setTextColor(getResources().getColor(R.color.blue));
        return view;
    }
}
