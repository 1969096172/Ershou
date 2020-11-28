package com.li.ersou.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;
import com.li.ersou.R;
import com.li.ersou.fragment.MainFragment;
import com.li.ersou.fragment.MineFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    TextView mTabHome,mTabMine;
    private DrawerLayout drawerLayout;
    private ViewPager viewPager;
    private ActionBarDrawerToggle mToggle;
    private TabLayout tabLayout;
    private Fragment mhomeFragment,mmineFragment;
    //标记两个Fragment
    private  int mFragmentId=0;
    public static final int FRAGMENT_HOME = 0;
    public static final int FRAGMENT_MINE = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTabHome = findViewById(R.id.tv_home);
        mTabMine = findViewById(R.id.tv_mine);
        setFragment(mFragmentId);
        mTabHome.setOnClickListener(this);
        mTabMine.setOnClickListener(this);
    }



    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        //获取Fragment管理器
        FragmentManager mFragmentManager = getSupportFragmentManager();
        //通过FragmentManager获取保存在FragmentTransaction中的Fragment实例
        mhomeFragment = mFragmentManager.findFragmentByTag("home_fragment");
        mmineFragment = mFragmentManager.findFragmentByTag("mine_fragment");
        //恢复销毁前显示的Fragment
        setFragment(savedInstanceState.getInt("fragment_id"));
    }
    private void hideFragments(FragmentTransaction transaction){
        if (mhomeFragment != null){
            //隐藏Fragment
            transaction.hide(mhomeFragment);
            //将对应菜单栏设置为默认状态
            mTabHome.setTextColor(getResources().getColor(R.color.colorBlack));
            mTabHome.setCompoundDrawablesWithIntrinsicBounds(0,
                    R.mipmap.ic_home_normal,0,0);
        }
        if (mmineFragment != null){
            transaction.hide(mmineFragment);
            mTabMine.setTextColor(getResources().getColor(R.color.colorBlack));
            mTabMine.setCompoundDrawablesWithIntrinsicBounds(0,
                    R.mipmap.ic_mine_normal,0,0);
        }
    }
    private void setFragment(int fragment_id) {
        //获取Fragment管理器
        FragmentManager mFragmentManager = getSupportFragmentManager();
        //开启事务
        FragmentTransaction mTransaction = mFragmentManager.beginTransaction();
        //隐藏所有Fragment
        hideFragments(mTransaction);

        switch (fragment_id){
            default:
                break;
            case FRAGMENT_HOME:
                System.out.println("main");
                mFragmentId = FRAGMENT_HOME;
                //设置菜单栏为选中状态（修改文字和图片颜色）
                mTabHome.setTextColor(getResources().getColor(R.color.colorBlack));
                mTabHome.setCompoundDrawablesWithIntrinsicBounds(0,
                        R.mipmap.ic_home_selected,0,0);
                //显示对应Fragment
                if(mhomeFragment == null){
                    mhomeFragment = new MainFragment();//userid
                    mTransaction.add(R.id.container, mhomeFragment, "home_fragment");
                }else {
                    mTransaction.show(mhomeFragment);
                }
                break;
            case FRAGMENT_MINE:
                System.out.println("mine");
                mFragmentId = FRAGMENT_MINE;
                mTabMine.setTextColor(getResources().getColor(R.color.colorBlack));
                mTabMine.setCompoundDrawablesWithIntrinsicBounds(0,
                        R.mipmap.ic_mine_selected,0,0);
                if(mmineFragment == null){
                    mmineFragment = new MineFragment();
                    mTransaction.add(R.id.container, mmineFragment, "mine_fragment");
                }else {
                    mTransaction.show(mmineFragment);
                }
                break;
        }
        //提交事务
        mTransaction.commit();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.tv_home:
                setFragment(FRAGMENT_HOME);
                break;
            case R.id.tv_mine:
                setFragment(FRAGMENT_MINE);
                break;
        }
    }
}