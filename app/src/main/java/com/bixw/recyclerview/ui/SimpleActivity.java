package com.bixw.recyclerview.ui;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import com.bixw.recyclerview.R;
import com.ync365.ptrrecyclerview.BaseRecyclerAdapter;
import com.ync365.ptrrecyclerview.BaseRecyclerViewHolder;
import com.ync365.ptrrecyclerview.BaseSimpleRecyclerAdapter;
import com.ync365.ptrrecyclerview.PtrRecyclerView;

import java.util.ArrayList;

/**
 * 单一item布局的示例
 */
public class SimpleActivity extends AppCompatActivity implements BaseRecyclerAdapter.OnRecyclerViewItemClickListener{

    PtrRecyclerView mRecyclerView;
    ArrayList<String> mDatas;
    BaseSimpleRecyclerAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView= (PtrRecyclerView) findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mRecyclerView.setMode(PtrRecyclerView.RecyclerMode.BOTTOM);
        mAdapter=new BaseSimpleRecyclerAdapter() {
            @Override
            public int getItemViewLayoutId() {
                return R.layout.item;
            }

            @Override
            public void bindData(BaseRecyclerViewHolder holder, Object obj, int position) {
                holder.setText(R.id.textView,(String)obj);
            }
        };
        mAdapter.setOnItemClickListener(this);
        mRecyclerView.setAdapter(mAdapter);
        View headerView= LayoutInflater.from(this).inflate(R.layout.header,mRecyclerView,false);
        View footView= LayoutInflater.from(this).inflate(R.layout.foot,mRecyclerView,false);
        mRecyclerView.addHeaderView(headerView);
        mRecyclerView.addFooterView(footView);
        initData();
        mAdapter.append(mDatas);

        mRecyclerView.setOnLoadMoreListener(new PtrRecyclerView.OnLoadMoreListener() {
            @Override
            public void onloadMore() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        for (int i = 0; i < 6; i++) {
                            mAdapter.append("" + i);
                        }
                        mRecyclerView.loadMoreComplete();
                        mRecyclerView.noMoreData();
                    }
                }, 3000);

            }
        });
    }

    protected void initData()
    {
        mDatas = new ArrayList<>();
        for (int i = 0; i < 30; i++)
        {
            mDatas.add("" + i);
        }
    }


    @Override
    public void onItemClick(View itemView, Object itemBean, int position) {
        Toast.makeText(SimpleActivity.this,"data:"+itemBean+"    position:"+position,Toast.LENGTH_SHORT).show();
    }
}
