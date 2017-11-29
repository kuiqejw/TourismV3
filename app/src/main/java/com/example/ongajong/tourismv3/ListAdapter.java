package com.example.ongajong.tourismv3;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by ongajong on 28/11/2017.
 */

public class ListAdapter extends RecyclerView.Adapter{
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,parent,false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((ListViewHolder) holder).bindView(position);

    }

    @Override
    public int getItemCount() {
        return OurData.title.length;
    }
    private class ListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView mItemText;
        private ImageView mItemImage;
        public ListViewHolder(View itemView){
            super(itemView);
            mItemText = itemView.findViewById(R.id.itemText);
            mItemImage= itemView.findViewById(R.id.itemImage);
            itemView.setOnClickListener(this);
        }

        public void bindView(int position){

            mItemText.setText(OurData.title[position]);
            mItemImage.setImageResource(OurData.picturePath[position]);
        }
        @Override
        public void onClick(View view) {
            Log.d("Laura", "On Click " + getAdapterPosition()+mItemText.getText().toString());
            String dest = mItemText.getText().toString();
            Intent browserIntent = new Intent(Intent.ACTION_VIEW);
            switch (dest) {
                case "Botanic Gardens":
                    browserIntent.setData(Uri.parse("https://www.sbg.org.sg/index.php?option=com_k2&view=item&layout=item&id=688&Itemid=21"));
                    break;
                case "Gardens By the bay":
                    browserIntent.setData(Uri.parse("http://www.gardensbythebay.com.sg/en/plan-your-visit/hours-admission.html"));
                    break;
                case "Marina Bay Sands":
                    browserIntent.setData(Uri.parse("https://www.marinabaysands.com/#OcJbedwMQd5bEPTl.97"));
                    break;
                case "National Orchid Garden":
                    browserIntent.setData(Uri.parse("https://www.sbg.org.sg/index.php?option=com_k2&view=item&layout=item&id=34&Itemid=58"));
                    break;
                case "Universal Studios Singapore":
                    browserIntent.setData(Uri.parse("https://www.rwsentosa.com/language/en-US/Homepage/Attractions/UniversalStudiosSingapore#0"));
                    break;
                case "Singapore Flyer":
                    browserIntent.setData(Uri.parse("http://www.singaporeflyer.com/"));
                    break;
                case "Singapore Zoo":
                    browserIntent.setData(Uri.parse("http://www.zoo.com.sg/visitor-info/opening-hours.html"));
                    break;
                case "Buddha Tooth Relic Temple":
                    browserIntent.setData(Uri.parse("http://www.btrts.org.sg/"));
                    break;

            }
            view.getContext().startActivity(browserIntent);
        }


    }
}
