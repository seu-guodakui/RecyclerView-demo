package com.kevin.recyclerview_demo;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Administrator on 2016/10/20.
 */
public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ItemViewHolder>{

    private List<String> mDatas;
    private LayoutInflater mInflater;
    private OnItemClickListener onItemClickListener;


    public ListAdapter(Context context,List<String> mDatas){
        this.mDatas = mDatas;
        mInflater=LayoutInflater.from(context);
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemViewHolder holder = new ItemViewHolder(mInflater.inflate(R.layout.item_layout,parent,false));
        return holder;
    }

    @SuppressLint("NewApi")
    @Override
    public void onBindViewHolder(final ItemViewHolder holder, final int position) {
        holder.mtextview.setText(mDatas.get(position));
        if (onItemClickListener != null){
            if (!holder.itemView.hasOnClickListeners()){
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int pos = holder.getPosition();
                        onItemClickListener.OnItemClick(v,pos);
                    }
                });

                holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View v) {
                        int pos = holder.getPosition();
                        onItemClickListener.OnItemLongClick(v,pos);
                        return true;
                    }
                });
            }
        }

    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    public void add(int position,String value){
        if (position>mDatas.size()){
            position = mDatas.size();
        }
        if (position<0){
            position=0;
        }
        mDatas.add(position,value);

        notifyItemInserted(position);
    }


    public String remove(int position){
        if(position > mDatas.size()-1)
        {
            return null;
        }
        String value = mDatas.remove(position);
        notifyItemRemoved(position);
        return value;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener){
        this.onItemClickListener=onItemClickListener;
    }

    interface OnItemClickListener{
        public void OnItemClick(View view,int position);
        public void OnItemLongClick(View view,int position);
    }

    class ItemViewHolder extends RecyclerView.ViewHolder{
        private TextView mtextview;

        public ItemViewHolder(View itemView){
            super(itemView);
            mtextview = (TextView)itemView.findViewById(R.id.textview);
        }
    }
}
