package list.listtemplates.simpleListAdapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

import list.listtemplates.R;
import list.listtemplates.simplelistTypes.SimpleDTOType1;
import list.listtemplates.simplelistTypes.SimpleGridDTO;

/**
 * Created by CHANDRASAIMOHAN on 8/21/2016.
 */
public class SimpleGridListAdapter extends RecyclerView.Adapter <SimpleGridListAdapter.SimpleGridViewHolder>{

    private LayoutInflater inflator;
    List<SimpleGridDTO> simpleGridDTOList = Collections.emptyList();

    public  SimpleGridListAdapter(Context context, List<SimpleGridDTO>  data){
        inflator = LayoutInflater.from(context);
        simpleGridDTOList = data;
    }

    @Override
    public SimpleGridViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflator.inflate(R.layout.simple_grid_row,parent,false);
        SimpleGridViewHolder simpleGridViewHolder = new SimpleGridViewHolder(view);
        return simpleGridViewHolder;
    }

    @Override
    public void onBindViewHolder(SimpleGridViewHolder holder, int position) {
        SimpleGridDTO simpleGridDTO = simpleGridDTOList.get(position);
        holder.android_version_title.setText(simpleGridDTO.getAndroid_version());
        holder.android_version_icon.setImageResource(simpleGridDTO.getVersion_image_id());
    }

    
    @Override
    public int getItemCount() {
        return simpleGridDTOList.size();
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


         //   delete(getAdapterPosition());
        }
    }
}
