package com.farmerskorner.adminapp;
import android.content.Context;
import android.os.Build;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.List;
public class SuggestionAdapter extends RecyclerView.Adapter<SuggestionAdapter.SuggestionViewHolder> {
    private Context mCtx;
    //we are storing all the products in a list
    private List<Suggestion> suggestionList;
    public SuggestionAdapter(Context mCtx, List<Suggestion> suggestionList) {
        this.mCtx = mCtx;
        this.suggestionList = suggestionList;
    }
    @Override
    public SuggestionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflating and returning our view holder
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.suggestion_card, null);
        return new SuggestionViewHolder(view);
    }
    @Override
    public void onBindViewHolder(SuggestionViewHolder holder, int position) {
        //getting the product of the specified position
        Suggestion product = suggestionList.get(position);
        holder.imageText.setText(product.getImageText());
        holder.name.setText(product.getName());
        holder.comment.setText(product.getComment());
        holder.ratingBar.setRating(product.getRating());
    }
    @Override
    public int getItemCount() {
        return suggestionList.size();
    }
    class SuggestionViewHolder extends RecyclerView.ViewHolder {
        TextView imageText,name,comment;
        RatingBar ratingBar;
        public SuggestionViewHolder(View itemView) {
            super(itemView);
            name =itemView.findViewById(R.id.name);
            imageText = itemView.findViewById(R.id.imageText);
            comment = itemView.findViewById(R.id.comment);
            ratingBar=itemView.findViewById(R.id.ratingBar);
        }
    }
}
