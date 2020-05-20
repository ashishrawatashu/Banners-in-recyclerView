package com.example.cynoteck;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class BannerAdapter extends RecyclerView.Adapter {

    List<RecyclerViewItems> recyclerViewItems;
    private static final int HEADER_ITEM = 0;
    private static final int LIST_ITEM = 2;
    Context mContext;

    public BannerAdapter(List<RecyclerViewItems> recyclerViewItems, Context mContext) {
        this.recyclerViewItems = recyclerViewItems;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View row;
        if (viewType == HEADER_ITEM) {
            row = inflater.inflate(R.layout.banner, parent, false);
            return new HeaderHolder(row);
        } else if (viewType == LIST_ITEM) {
            row = inflater.inflate(R.layout.list_layout, parent, false);
            return new ItemHolder(row);

        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        RecyclerViewItems recyclerViewItem = recyclerViewItems.get(position);
        if (holder instanceof HeaderHolder) {
            HeaderHolder headerHolder = (HeaderHolder) holder;
            Header header = (Header) recyclerViewItem;
            headerHolder.banner.setText(header.getHeaderText());
        }
            else if (holder instanceof ItemHolder) {

            ItemHolder itemHolder = (ItemHolder) holder;
            ListItems item = (ListItems) recyclerViewItem;
            itemHolder.empName.setText(item.getName());
            itemHolder.empId.setText(item.getId());
            if (position>2)
            itemHolder.empDes.setText("");
            if (position<=2)
            {
                itemHolder.empDes.setText(item.getDes());

            }

            RequestOptions options = new RequestOptions()
                    .format(DecodeFormat.PREFER_ARGB_8888)
                    .centerCrop()
                    .placeholder(R.drawable.ic_launcher_background)
                    .diskCacheStrategy(DiskCacheStrategy.RESOURCE);

            Glide.with(mContext)
                    .load(item.getImage())
                    .apply(options)
                    .thumbnail(0.5f)
                    .into(itemHolder.empIV);

            }
    }

    @Override
    public int getItemViewType(int position) {
        RecyclerViewItems recyclerViewItem = recyclerViewItems.get(position);
        if (recyclerViewItem instanceof Header)
            return HEADER_ITEM;
        else if (recyclerViewItem instanceof ListItems)
            return LIST_ITEM;
        else
            return super.getItemViewType(position);    }

    @Override
    public int getItemCount() {
        return recyclerViewItems.size();

    }

    private class ItemHolder extends RecyclerView.ViewHolder {
        CircleImageView empIV;
        TextView empId, empName, empDes;
        ItemHolder(View itemView) {
            super(itemView);
            empDes = itemView.findViewById(R.id.empDes);
            empName = itemView.findViewById(R.id.empName);
            empId = itemView.findViewById(R.id.empId);
            empIV = itemView.findViewById(R.id.imageView);
        }
    }

    private class HeaderHolder extends RecyclerView.ViewHolder {
        TextView banner;
        HeaderHolder(View itemView) {
            super(itemView);
            banner = itemView.findViewById(R.id.banner);

        }
    }
}
