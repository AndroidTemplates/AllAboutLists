package list.listtemplates.simpleListAdapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;
import java.util.zip.Inflater;

import list.listtemplates.R;
import list.listtemplates.simplelistTypes.SimpleDTOType1;

/**
 * Created by CHANDRASAIMOHAN on 8/20/2016.
 */
public class SimpleListType1Adapter extends RecyclerView.Adapter <SimpleListType1Adapter.SimpleType1ViewHolder> {


    private  LayoutInflater inflator;
    List<SimpleDTOType1> simpleDTOTypeList = Collections.EMPTY_LIST;

    public  SimpleListType1Adapter(Context context,List<SimpleDTOType1>  data){
        inflator = LayoutInflater.from(context);
        simpleDTOTypeList = data;
    }

    @Override
    public SimpleType1ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       View view = inflator.inflate(R.layout.simple_row_type1,parent,false);
        SimpleType1ViewHolder simpleType1ViewHolder = new SimpleType1ViewHolder(view);
        return simpleType1ViewHolder;
    }

    @Override
    public void onBindViewHolder(SimpleType1ViewHolder  holder, int position) {
        SimpleDTOType1 simpleDTOType1 = simpleDTOTypeList.get(position);
        holder.title.setText(simpleDTOType1.title);
        holder.title_icon.setImageResource(simpleDTOType1.iconId);
    }


    private void delete(int position){
        simpleDTOTypeList.remove(position);
        notifyItemRemoved(position);
    }

    public void add(){
        int size = simpleDTOTypeList.size();

        int nextPosition   = 1;
        SimpleDTOType1 addItem = new SimpleDTOType1();
        addItem.iconId = R.drawable.ic_india_flag;
        addItem.title = "NewIndia"+(size+1);
        simpleDTOTypeList.add(1,addItem);
        notifyItemInserted(nextPosition);
        //not
    }
    @Override
    public int getItemCount() {
        return simpleDTOTypeList.size();
    }

    class SimpleType1ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView title;
        ImageView title_icon;
        LinearLayout rootLayout;
        public SimpleType1ViewHolder(View itemView ){
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.simple_type1_title);
            title_icon = (ImageView) itemView.findViewById(R.id.simple_type1_image);
            rootLayout = (LinearLayout)itemView.findViewById(R.id.root_layout);
           // rootLayout.setOnClickListener(this);
            title.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            rootLayout.setSelected(false);
            switch (v.getId()){
                case R.id.simple_type1_title:
                    delete(getAdapterPosition());
                    break;
                case  R.id.root_layout:
                     rootLayout.setSelected(true);
                    break;
            }


        }
    }
}
