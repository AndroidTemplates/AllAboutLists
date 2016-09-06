package list.listtemplates.SectionedAdapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Collections;
import java.util.List;

import list.listtemplates.R;
import list.listtemplates.simplelistTypes.SimpleDTOType1;
import list.listtemplates.simplelistTypes.SimpleGridDTO;

/**
 * Created by CHANDRASAIMOHAN on 8/24/2016.
 */
public class SectionedHeterogenousAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{


    // The items to display in your RecyclerView
    private List<Object> items =   Collections.EMPTY_LIST;;
    private LayoutInflater inflator;

    private final int SIMPLE = 0,GRID=2, HEADER = 1;
    Context ctx;


    public SectionedHeterogenousAdapter(Context context, List<Object>  data){
        inflator = LayoutInflater.from(context);
        items = data;
        ctx = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder = null;
        switch (viewType) {
            case SIMPLE:
                View v1 = inflator.inflate(R.layout.simple_row_type1,parent,false);
                viewHolder = new SimpleType1ViewHolder(v1);
                break;
            case HEADER:
                View view = inflator.inflate(R.layout.header_row,parent,false);
                viewHolder = new HeaderViewHolder(view);
                break;
            case GRID:
                View gridView = inflator.inflate(R.layout.simple_grid_row,parent,false);
                viewHolder = new SimpleGridViewHolder(gridView);
                break;
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        switch (holder.getItemViewType()){
            case SIMPLE:
                SimpleType1ViewHolder vh1 = (SimpleType1ViewHolder)holder;
                configureViewHolder1(vh1,position);
                break;
            case HEADER:
                HeaderViewHolder vh2 = (HeaderViewHolder)holder;
                configureViewHolder2(vh2,position);
                break;
            case GRID:
                SimpleGridViewHolder vh3 = (SimpleGridViewHolder)holder;
                configureViewHolder3(vh3,position);
                break;

        }
    }

    @Override
    public int getItemViewType(int position) {
        if (items.get(position) instanceof SimpleDTOType1) {
            return SIMPLE;
        } else if (items.get(position) instanceof String) {
            return HEADER;
        }else if (items.get(position) instanceof SimpleGridDTO) {
            return GRID;
        }
        return -1;
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    private void configureViewHolder1(SimpleType1ViewHolder holder, int position) {
        SimpleDTOType1 simpleDTOType1 =(SimpleDTOType1) items.get(position);
        holder.title.setText(simpleDTOType1.title);
        holder.title_icon.setImageResource(simpleDTOType1.iconId);
    }

    private void configureViewHolder2(HeaderViewHolder holder, int position) {
        String headerName = (String)items.get(position);
        holder.title.setText(headerName);
    }

    private void configureViewHolder3(SimpleGridViewHolder holder, int position) {
        SimpleGridDTO simpleGridDTO = (SimpleGridDTO)items.get(position);
        holder.android_version_title.setText(simpleGridDTO.getAndroid_version());
        holder.android_version_icon.setImageResource(simpleGridDTO.getVersion_image_id());
    }

    class SimpleType1ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView title;
        ImageView title_icon;
        public SimpleType1ViewHolder(View itemView ){
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.simple_type1_title);
            title_icon = (ImageView) itemView.findViewById(R.id.simple_type1_image);
            title.setOnClickListener(this);
            title_icon.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            //delete(getAdapterPosition());
            Toast.makeText(ctx,"Clicked on Flags Row::at Position"+getAdapterPosition(),Toast.LENGTH_SHORT).show();
        }
    }


    class HeaderViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        public HeaderViewHolder(View itemView ){
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.header_label);


        }

    }


    class SimpleGridViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView android_version_title;
        ImageView android_version_icon;
        public SimpleGridViewHolder(View itemView ){
            super(itemView);
            android_version_title = (TextView) itemView.findViewById(R.id.tv_android);
            android_version_icon = (ImageView) itemView.findViewById(R.id.img_android);
            android_version_title.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {

            Toast.makeText(ctx,"Clicked on Image Row::at Position"+getAdapterPosition(),Toast.LENGTH_SHORT).show();
            //   delete(getAdapterPosition());
        }
    }
}
