package list.listtemplates.ExpandableAdapters;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bignerdranch.expandablerecyclerview.ViewHolder.ChildViewHolder;

import list.listtemplates.R;
import list.listtemplates.simplelistTypes.SimpleDTOType1;

/**
 * Created by CHANDRASAIMOHAN on 8/25/2016.
 */
public class ExpandableChildViewHolder extends ChildViewHolder {

    TextView title;
    ImageView title_icon;
    public ExpandableChildViewHolder(View itemView ){
        super(itemView);
        title = (TextView) itemView.findViewById(R.id.simple_type1_title);
        title_icon = (ImageView) itemView.findViewById(R.id.simple_type1_image);
        //title.setOnClickListener(this);

    }

    public void bind(Object child) {
        if(child instanceof SimpleDTOType1){
            SimpleDTOType1 simpleDTOType1 =(SimpleDTOType1) child;
            title.setText(simpleDTOType1.title);
           title_icon.setImageResource(simpleDTOType1.iconId);
        }
    }
   /* @Override
    public void onClick(View v) {
        //delete(getAdapterPosition());
        Toast.makeText(ctx,"Clicked on Flags Row::at Position"+getAdapterPosition(),Toast.LENGTH_SHORT).show();
    }*/
}
