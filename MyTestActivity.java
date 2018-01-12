package savetxt.hxzdsb.bh.savetxt;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import savetxt.hxzdsb.bh.savetxt.adapter.MyFragmentAdapter;

/**
 * Created by Administrator on 2018/1/11.
 */

public class MyTestActivity extends AppCompatActivity implements View.OnClickListener, ViewPager.OnPageChangeListener {
    private TextView tv_news, tv_movie, tv_game, tv_music;
    private ViewPager viewPager;
    private MyFragmentAdapter fragmentAdapter;

    public static final int Game_fragment = 3;
    public static final int Movie_fragment = 1;
    public static final int Music_fragment = 2;
    public static final int New_fragment = 0;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_test);

        List<Fragment> fragmentList = new ArrayList<>();

        initView();
        setClick();
        fragmentAdapter = new MyFragmentAdapter(getSupportFragmentManager());

    }


    private void initView() {
        tv_news = (TextView) findViewById(R.id.tv_news);
        tv_music = (TextView) findViewById(R.id.tv_music);
        tv_movie = (TextView) findViewById(R.id.tv_movie);
        tv_game = (TextView) findViewById(R.id.tv_game);

        viewPager = (ViewPager) findViewById(R.id.main_viewpager);
        viewPager.setAdapter(fragmentAdapter);
        viewPager.setCurrentItem(0);
        viewPager.addOnPageChangeListener(this);


    }

    private void setClick() {
        tv_news.setOnClickListener(this);
        tv_movie.setOnClickListener(this);
        tv_music.setOnClickListener(this);
        tv_game.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.tv_news:
                viewPager.setCurrentItem(New_fragment);
                break;
            case R.id.tv_movie:
                viewPager.setCurrentItem(Movie_fragment);
                break;
            case R.id.tv_music:
                viewPager.setCurrentItem(Music_fragment);
                break;
            case R.id.tv_game:
                viewPager.setCurrentItem(Game_fragment);
                break;


        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
