package savetxt.hxzdsb.bh.savetxt.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import savetxt.hxzdsb.bh.savetxt.MyTestActivity;
import savetxt.hxzdsb.bh.savetxt.fragment.GameFragment;
import savetxt.hxzdsb.bh.savetxt.fragment.MovieFragment;
import savetxt.hxzdsb.bh.savetxt.fragment.MusicFragment;
import savetxt.hxzdsb.bh.savetxt.fragment.NewFragment;

/**
 * Created by Administrator on 2018/1/10.
 */

public class MyFragmentAdapter extends FragmentPagerAdapter {
    private final int FRAGMENT_COUNT = 4;
    private GameFragment gameFragment = null;
    private MovieFragment movieFragment = null;
    private NewFragment newFragment = null;
    private MusicFragment musicFragment = null;

    public MyFragmentAdapter(FragmentManager fm) {
        super(fm);
        gameFragment = new GameFragment();
        movieFragment = new MovieFragment();
        newFragment = new NewFragment();
        musicFragment = new MusicFragment();
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position) {

            case MyTestActivity.New_fragment:
                fragment = newFragment;

                break;
            case MyTestActivity.Movie_fragment:
                fragment = movieFragment;
                break;
            case MyTestActivity.Music_fragment:
                fragment = musicFragment;
                break;
            case MyTestActivity.Game_fragment:
                fragment = gameFragment;
                break;


        }


        return fragment;
    }

    @Override
    public int getCount() {
        return FRAGMENT_COUNT;
    }
}
