package com.felix.huafei.commonadapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by zhy on 16/4/9.
 */
public class MultiItemTypeAdapter<T> extends RecyclerView.Adapter<CommonViewHolder>
{
    protected Context mContext;
    protected List<T> mDataList;

    protected ItemViewDelegateManager mItemViewDelegateManager;
    protected OnItemClickListener     mOnItemClickListener;


    public MultiItemTypeAdapter(Context context, List<T> mDataList)
    {
        this.mContext = context;
        this.mDataList = mDataList;
        mItemViewDelegateManager = new ItemViewDelegateManager();
    }

    @Override
    public int getItemViewType(int position)
    {
        if(!useItemViewDelegateManager())
        {
            return super.getItemViewType(position);
        }
        return mItemViewDelegateManager.getItemViewType(mDataList.get(position), position);
    }


    @Override
    public CommonViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        ItemViewDelegate itemViewDelegate = mItemViewDelegateManager.getItemViewDelegate(viewType);

        int layoutId = itemViewDelegate.getItemViewLayoutId();

        CommonViewHolder holder = CommonViewHolder.createViewHolder(mContext, parent, layoutId);
        onViewHolderCreated(holder, holder.getConvertView());
        setListener(parent, holder, viewType);
        return holder;
    }


    @Override
    public void onBindViewHolder(CommonViewHolder holder, int position)
    {
        convert(holder, mDataList.get(position));
    }

    @Override
    public int getItemCount()
    {
        return mDataList.size();
    }

    public void onViewHolderCreated(CommonViewHolder holder, View itemView)
    {

    }

    public void convert(CommonViewHolder holder, T t)
    {
        mItemViewDelegateManager.convert(holder, t, holder.getAdapterPosition());
    }

    protected boolean isEnabled(int viewType)
    {
        return true;
    }


    protected void setListener(final ViewGroup parent, final CommonViewHolder commonViewHolder, int viewType)
    {
        if(!isEnabled(viewType))
        {
            return;
        }
        commonViewHolder.getConvertView().setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if(mOnItemClickListener != null)
                {
                    int position = commonViewHolder.getAdapterPosition();
                    mOnItemClickListener.onItemClick(v, commonViewHolder, position);
                }
            }
        });

        commonViewHolder.getConvertView().setOnLongClickListener(new View.OnLongClickListener()
        {
            @Override
            public boolean onLongClick(View v)
            {
                if(mOnItemClickListener != null)
                {
                    int position = commonViewHolder.getAdapterPosition();
                    return mOnItemClickListener.onItemLongClick(v, commonViewHolder, position);
                }
                return false;
            }
        });
    }


    public List<T> getDataList()
    {
        return mDataList;
    }

    public void setDataList(List<T> mDataList)
    {
        this.mDataList = mDataList;
    }

    public void addAll(List<T> mDataList)
    {
        mDataList.addAll(mDataList);
    }

    public MultiItemTypeAdapter addItemViewDelegate(ItemViewDelegate<T> itemViewDelegate)
    {
        mItemViewDelegateManager.addDelegate(itemViewDelegate);
        return this;
    }

    public MultiItemTypeAdapter addItemViewDelegate(int viewType, ItemViewDelegate<T> itemViewDelegate)
    {
        mItemViewDelegateManager.addDelegate(viewType, itemViewDelegate);
        return this;
    }

    protected boolean useItemViewDelegateManager()
    {
        return mItemViewDelegateManager.getItemViewDelegateCount() > 0;
    }

    public interface OnItemClickListener
    {
        void onItemClick(View view, RecyclerView.ViewHolder holder, int position);

        boolean onItemLongClick(View view, RecyclerView.ViewHolder holder, int position);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener)
    {
        this.mOnItemClickListener = onItemClickListener;
    }
}
