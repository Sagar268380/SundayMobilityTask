package com.elysino.sundaymobilitytask.ui.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.elysino.sundaymobilitytask.R;
import com.elysino.sundaymobilitytask.model.DummyParentDataItem;

import java.util.ArrayList;

public class RecyclerDataAdapter extends RecyclerView.Adapter<RecyclerDataAdapter.MyViewHolder> {
    private ArrayList<DummyParentDataItem> dummyParentDataItems = new ArrayList<>();
    Context context;

    public RecyclerDataAdapter(Context context) {
        this.context = context;
    }

    public void addItems(ArrayList<DummyParentDataItem> dummyParentDataItems) {
        this.dummyParentDataItems = dummyParentDataItems;
    }

    @Override
    public RecyclerDataAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.item_parent_child_listing, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(RecyclerDataAdapter.MyViewHolder holder, int position) {
        DummyParentDataItem dummyParentDataItem = dummyParentDataItems.get(position);
        holder.textView_parentName.setText(dummyParentDataItem.getParentName());
        holder.tv_number.setText(dummyParentDataItem.getNumber());
        //
        int noOfChildTextViews = holder.linearLayout_childItems.getChildCount();
        for (int index = 0; index < noOfChildTextViews; index++) {
            TextView currentTextView = (TextView) holder.linearLayout_childItems.getChildAt(index);
            currentTextView.setVisibility(View.VISIBLE);
        }

        int noOfChild = dummyParentDataItem.getChildDataItems().size();
        if (noOfChild < noOfChildTextViews) {
            for (int index = noOfChild; index < noOfChildTextViews; index++) {
                TextView currentTextView = (TextView) holder.linearLayout_childItems.getChildAt(index);
                currentTextView.setVisibility(View.GONE);
            }
        }
        for (int textViewIndex = 0; textViewIndex < noOfChild; textViewIndex++) {
            TextView currentTextView = (TextView) holder.linearLayout_childItems.getChildAt(textViewIndex);
            currentTextView.setText(dummyParentDataItem.getChildDataItems().get(textViewIndex).getChildName());
        }
    }

    @Override
    public int getItemCount() {
        return dummyParentDataItems.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private Context context;
        private TextView textView_parentName, tv_number;
        private LinearLayout linearLayout_childItems;
        private ImageView imgDropDown;

        MyViewHolder(View itemView) {
            super(itemView);
            context = itemView.getContext();
            textView_parentName = itemView.findViewById(R.id.tv_parentName);
            linearLayout_childItems = itemView.findViewById(R.id.ll_child_items);
            imgDropDown = itemView.findViewById(R.id.img_dropDown);
            tv_number = itemView.findViewById(R.id.tv_number);
            linearLayout_childItems.setVisibility(View.GONE);
            int intMaxNoOfChild = 0;
            for (int index = 0; index < dummyParentDataItems.size(); index++) {
                int intMaxSizeTemp = dummyParentDataItems.get(index).getChildDataItems().size();
                if (intMaxSizeTemp > intMaxNoOfChild) intMaxNoOfChild = intMaxSizeTemp;
            }
            for (int indexView = 0; indexView < intMaxNoOfChild; indexView++) {
                TextView textView = new TextView(context);
                textView.setId(indexView);
                textView.setPadding(0, 20, 0, 20);
                textView.setBackground(ContextCompat.getDrawable(context, R.drawable.background_sub_module_text));
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                //textView.setOnClickListener(this);
                layoutParams.rightMargin = 65;
                layoutParams.leftMargin = 65;
                layoutParams.gravity = LinearLayout.HORIZONTAL;
                linearLayout_childItems.addView(textView, layoutParams);
            }
            imgDropDown.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (view.getId() == R.id.img_dropDown) {
                if (linearLayout_childItems.getVisibility() == View.VISIBLE) {
                    linearLayout_childItems.setVisibility(View.GONE);
                } else {
                    linearLayout_childItems.setVisibility(View.VISIBLE);
                }
            } else {
                TextView textViewClicked = (TextView) view;
                Toast.makeText(context, "" + textViewClicked.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        }
    }
}