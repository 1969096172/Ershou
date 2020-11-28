package com.li.ersou.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;
import com.li.ersou.R;
import com.li.ersou.utils.GlideImageLoader;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerListener;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MainFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MainFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    TabLayout mTableLayout;
    private ViewPager mViewPager;
    private MyAdapter adapter;
    private List<String> mTitle;
    private List<Fragment> mFragment;
    Banner banner;//banner组件
    List mlist;//图片资源
    List<String> mlist1;//轮播标题
    public MainFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MainFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MainFragment newInstance(String param1, String param2) {
        MainFragment fragment = new MainFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        System.out.println("main");
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_main, null);
        mlist = new ArrayList<>();
        mlist.add(R.mipmap.lunbo1);
        mlist.add(R.mipmap.lunbo2);
        mlist.add(R.mipmap.lunbo3);
        mlist1 = new ArrayList<>();
        mlist1.add("特色快速业务");
        mlist1.add("送货到家服务");
        mlist1.add("一键查询服务");
        banner = view.findViewById(R.id.main_banner);
        banner.setImageLoader(new GlideImageLoader());   //设置图片加载器
        banner.setImages(mlist);//设置图片源
        banner.setBannerTitles(mlist1);//设置标题源
        banner.setDelayTime(2000);//设置轮播事件，单位毫秒
        banner.setBannerAnimation(Transformer.Stack);
        banner.setOnBannerListener(new OnBannerListener() {
            public void OnBannerClick(int position) {
                Toast.makeText(getActivity(), "点击了轮播第"+position+"个图片" + position, Toast.LENGTH_SHORT).show();
            }
        });
        banner.setIndicatorGravity(BannerConfig.CENTER);//设置指示器的位置
        banner.start();//开始轮播，一定要调用此方法。

        mTableLayout=view.findViewById(R.id.discover_tab);
        mViewPager=view.findViewById(R.id.discover_pager);
        //标题栏数组
        mTitle = new ArrayList<>();
        mTitle.add("首页");
        mTitle.add("中心");
        //fragment集合
        mFragment = new ArrayList<>();
        mFragment.add(new UserOneFragment());
        mFragment.add(new UserTwoFragment());
        //在activity中使用 getSupportFragmentManager(),这里是Fragment中使用如下方法
        adapter = new MyAdapter(getFragmentManager());
        mViewPager.setAdapter(adapter);
        //将TabLayout和ViewPager绑定在一起，一个动另一个也会跟着动
        mTableLayout.setupWithViewPager(mViewPager);
        //返回视图
        return view;
    }
    //创建Fragment的适配器
    class MyAdapter extends FragmentPagerAdapter {

        public MyAdapter(FragmentManager fm) {
            super(fm);
        }
        //获得每个页面的下标
        @Override
        public Fragment getItem(int position) {
            return mFragment.get(position);
        }
        //获得List的大小
        @Override
        public int getCount() {
            return mFragment.size();
        }
        //获取title的下标
        @Override
        public CharSequence getPageTitle(int position) {
            return mTitle.get(position);
        }
    }
    @Override
    public void onPause() {
        super.onPause();
    }
}