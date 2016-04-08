# PtrRecyclerView
封装可添加头部和尾部的RecyclerView，封装的BaseRecyclerViewAdapter,支持多布局item，下拉刷新，上拉加载更多。
调用方式简单，具体看MainActivity.java类的使用。

###
        BaseRecyclerAdapter adapter=new BaseRecyclerAdapter() {
            @Override
            public int getItemViewLayoutId() {
                return R.layout.item;
            }

            @Override
            public void bindData(BaseRecyclerViewHolder holder, Object obj, int position) {
                    holder.setText(R.id.textView,(String)obj);
            }
        };
        adapter.setOnItemClickListener(this);
        mRecyclerView.setAdapter(adapter);
###


# 添加头布局和尾布局
###
        mRecyclerView.setAdapter(adapter);
        View headerView= LayoutInflater.from(this).inflate(R.layout.header,null);
        View footView= LayoutInflater.from(this).inflate(R.layout.foot,null);
        mRecyclerView.addHeaderView(headerView);
        mRecyclerView.addFootView(footView);
###

# 监听Item点击事件
###
    @Override
    public void onItemClick(View itemView, Object itemBean, int position) {
        Toast.makeText(MainActivity.this,"data:"+itemBean+"    position:"+position,Toast.LENGTH_SHORT).show();
    }
###

# 联系作者  email:bixw@ync365.com
