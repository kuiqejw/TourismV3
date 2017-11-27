package com.example.ongajong.tourismv3.Recycler;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ongajong.tourismv3.R;

import java.util.ArrayList;
import java.util.List;

public class AlbumAdaptor extends RecyclerView.Adapter<AlbumAdaptor.AlbumViewHolder> {

    public static class AlbumViewHolder extends RecyclerView.ViewHolder {

        CardView cv;
        TextView destinationname;
        ImageView destinationphoto;

        AlbumViewHolder(View itemView) {
            super(itemView);
            cv = itemView.findViewById(R.id.cv);
            destinationname = itemView.findViewById(R.id.destinationname);
            destinationphoto = itemView.findViewById(R.id.destinationphoto);
        }
    }

    List<Album> destinations;

    public AlbumAdaptor(ArrayList<Album> destinations){
        this.destinations = destinations;
    }


    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public AlbumViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_cardview, viewGroup, false);
        AlbumViewHolder pvh = new AlbumViewHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(AlbumViewHolder personViewHolder, final int i) {
        personViewHolder.destinationname.setText(destinations.get(i).name);
        personViewHolder.destinationphoto.setImageResource(destinations.get(i).photoId);
        /*personViewHolder.itemView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String dest = destinations.get(i).name;
                Intent browserIntent = new Intent(Intent.ACTION_VIEW);
                switch (dest){
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
            }
        });*/
    }

    @Override
    public int getItemCount() {
        //return 0;
        return destinations== null ? 0 : destinations.size();
    }
}
