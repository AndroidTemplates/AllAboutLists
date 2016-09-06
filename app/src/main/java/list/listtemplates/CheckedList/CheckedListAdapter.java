package list.listtemplates.CheckedList;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

import list.listtemplates.R;
import list.listtemplates.simplelistTypes.SimpleDTOType1;

/**
 * Created by CHANDRASAIMOHAN on 8/25/2016.
 */
public class CheckedListAdapter extends RecyclerView.Adapter <CheckedListAdapter.CheckedViewHolder>{
    private LayoutInflater inflator;
    List<CheckedListDTO> checkedListDTOList = Collections.EMPTY_LIST;

    public  CheckedListAdapter(Context context, List<CheckedListDTO>  data){
        inflator = LayoutInflater.from(context);
        checkedListDTOList = data;
    }

    @Override
    public CheckedViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflator.inflate(R.layout.checked_row_type,parent,false);
        CheckedViewHolder checkedViewHolder = new CheckedViewHolder(view);
        return checkedViewHolder;
    }

    @Override
    public void onBindViewHolder(CheckedViewHolder holder, int position) {
        CheckedListDTO checkedListDTO = checkedListDTOList.get(position);
        holder.title.setText(checkedListDTO.getTitle());
        holder.title_icon.setImageResource(checkedListDTO.getIconId());
        holder.isChecked.setChecked(checkedListDTO.isSelected());
        holder.isChecked.setTag(checkedListDTO);
    }

    @Override
    public int getItemCount() {
        return checkedListDTOList.size();
    }

    public List<CheckedListDTO> getCheckedListDTOList() {
        return checkedListDTOList;
    }

    class CheckedViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView title;
        ImageView title_icon;
         CheckBox isChecked;
        public CheckedViewHolder(View itemView ){
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.simple_type1_title);
            title_icon = (ImageView) itemView.findViewById(R.id.simple_type1_image);
            isChecked = (CheckBox) itemView.findViewById(R.id.chkSelected);
            //title.setOnClickListener(this);
            isChecked.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            CheckBox cBox = (CheckBox) v;
            CheckedListDTO checkedListDTO = (CheckedListDTO)cBox.getTag();
            checkedListDTO.setSelected(cBox.isChecked());
            checkedListDTOList.get(getAdapterPosition()).setSelected(cBox.isChecked());
            //delete(getAdapterPosition());
        }
    }
}
