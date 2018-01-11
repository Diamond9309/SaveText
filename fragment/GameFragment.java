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

public class GameFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_game, container, false);
        TextView tv_game = (TextView) view.findViewById(R.id.tv_game_fragment);
        tv_game.setText("这是一个游戏");
        tv_game.setTextColor(getResources().getColor(R.color.blue));
        return view;
    }
}
