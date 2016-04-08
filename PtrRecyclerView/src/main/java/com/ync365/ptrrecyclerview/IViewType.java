package com.ync365.ptrrecyclerview;

/**
 * Created by bixinwei on 16/3/10.
 */
public interface IViewType {
    int getItemViewLayoutId(int viewType);
    int getItemViewType(int position, Object itemBean);
}
