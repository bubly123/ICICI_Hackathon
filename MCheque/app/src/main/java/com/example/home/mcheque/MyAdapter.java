package com.example.home.mcheque;

import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.home.mcheque.payeeList.Payee;
import com.example.home.mcheque.utility.StringUtility;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mayu on 15-04-2017.
 */

class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>  {

    private List<Payee> payeeList;
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView tvPayeeId,tvPayeeName,tvPayeeAccountNo,tvPayeeShorthandName;
        public ViewHolder(View v) {
            super(v);
            //tvPayeeId = (TextView)v.findViewById(R.id.payeeId);
            tvPayeeName = (TextView)v.findViewById(R.id.payeeName);
            tvPayeeAccountNo = (TextView)v.findViewById(R.id.payeeAccountNo);
            //tvPayeeShorthandName = (TextView)v.findViewById(R.id.payeeShortHandName);
        }
    }
    public MyAdapter(List<Payee> payeeList) {
        //payeeList = new ArrayList<Payee>();
        this.payeeList = payeeList;
    }
    // Create new views (invoked by the layout manager)
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        // create a new view
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.payee_item, parent, false);

        return new ViewHolder(itemView);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
//       holder.tvPayeeId.setText(TextUtils.concat(StringUtility.getColoredSpannedText("# Payee Id ","0x434343") ,
//               StringUtility.getColoredSpannedText(payeeList.get(position).getPayeeId(),"0x717171")));
        holder.tvPayeeName.setText(
                StringUtility.getColoredSpannedText(payeeList.get(position).getPayeeName(),"0xffa500"));
        holder.tvPayeeAccountNo.setText(TextUtils.concat(StringUtility.getColoredSpannedText("Acc/No ","0x434343") ,
                StringUtility.getColoredSpannedText(payeeList.get(position).getPayeeAccountNo(),"0x717171")));
//        holder.tvPayeeShorthandName.setText(TextUtils.concat(StringUtility.getColoredSpannedText("Shorthand Name ","0x434343") ,
//                StringUtility.getColoredSpannedText(payeeList.get(position).getPayeeShortName(),"0x717171")));
    }
    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return payeeList.size();
    }
}
