package cn.com.timemachine.ui.fragment;


import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import cn.com.timemachine.R;
import cn.com.timemachine.common.ConstanceValue;
import cn.com.timemachine.ui.adapter.HomeAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {


    @BindView(R.id.recycler)
    RecyclerView recycler;
    @BindView(R.id.swipe)
    SwipeRefreshLayout swipe;
    Unbinder unbinder;
    private HomeAdapter mHomeAdapter;

    public HomeFragment() {
        // Required empty public constructor
    }

    public static HomeFragment newInstance(String code) {
        HomeFragment fragment = new HomeFragment();
        Bundle bundle = new Bundle();
        bundle.putString(ConstanceValue.DATA, code);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        unbinder = ButterKnife.bind(this, view);
        initAdapter();
        setListener();
        return view;
    }

    private void setListener() {

        swipe.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        //停止刷新动画
                        swipe.setRefreshing(false);
                    }
                }, 2000);
            }
        });
    }

    private void initAdapter() {
        List<String> list=new ArrayList<>();
        list.add("Aname");
        list.add("Bname");
        list.add("Cname");
        list.add("Dname");
        list.add("Ename");
        list.add("Fname");
        mHomeAdapter=new HomeAdapter(R.layout.home_item,null);
        recycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        recycler.setAdapter(mHomeAdapter);
        mHomeAdapter.addData(list);
        swipe.setColorSchemeResources(
                R.color.colorPrimaryDark,
                R.color.colorPrimary
                );
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
