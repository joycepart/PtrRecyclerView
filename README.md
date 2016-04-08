# PtrRecyclerView

封装可添加头部和尾部的RecyclerView，封装的BaseRecyclerViewAdapter,支持多布局item，下拉刷新，上拉加载更多。
下拉刷新使用[android-Ultra-Pull-To-Refresh](https://github.com/liaohuqiu/android-Ultra-Pull-To-Refresh "android-Ultra-Pull-To-Refresh") 开源框架



多布局item使用BaseRecyclerAdapter，具体看MainActivity.java示例。


为了简化单布局的情况，所以针对单个item类型的布局能够更简单的使用适配器，


可以使用BaseSimpleRecyclerAdapter,具体看SimpleActivity.java示例  


TestActivity.java使用自定义头部刷新视图实现，云农场项目的下拉刷新动画。



使用注意事项：


1，setMode方法用于设置是否支持下拉刷新和上拉加载更多。


如果需要你的RecyclerView支持下拉刷新，必须调用setMode（该方法必须被调用）之前必须先调用setPullRefreshHeaderView方法设置头部刷新视图。
否则抛异常。


2，addHeaderView方法和addFooterView方法只能在setAdapter()之后使用，否则抛异常。


3，加载头部或尾部视图，inflate请使用三个参数的方法。指定parent，第三个参数设为false.具体看示例代码。



### 监听上拉刷新回调接口
```
        mRecyclerView.setOnPullRefreshListener(new PtrRecyclerView.OnPullRefreshListener() {
            @Override
            public void onPullRefresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mAdapter.append("new");
                        mRecyclerView.pullRefreshComplete(); //下拉刷新数据加载完成
                    }
                }, 3000);
            }
        });
   ```   
### 监听上拉加载更多回调接口
  ```     
       mRecyclerView.setOnLoadMoreListener(new PtrRecyclerView.OnLoadMoreListener() {
            @Override
            public void onloadMore() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        for (int i = 0; i < 6; i++) {
                            mAdapter.append("" + i);
                        }
                        mRecyclerView.loadMoreComplete(); //上拉加载更多数据加载完成
                        mRecyclerView.noMoreData(); //该方法 指示没有更多数据了
                    }
                }, 3000);
            }
        });
```

## 联系作者  email:bixw@ync365.com
