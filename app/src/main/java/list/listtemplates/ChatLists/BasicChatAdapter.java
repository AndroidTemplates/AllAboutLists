package list.listtemplates.ChatLists;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import list.listtemplates.HeterogeneousAdapters.HeterogeneousType1Adapter;
import list.listtemplates.R;
import list.listtemplates.simpleListAdapters.SimpleListType1Adapter;
import list.listtemplates.simplelistTypes.SimpleDTOType1;
import list.listtemplates.simplelistTypes.SimpleGridDTO;

/**
 * Created by CHANDRASAIMOHAN on 12/17/2016.
 */

public class BasicChatAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private LayoutInflater inflator;
    List<ChatDTO> basicChatList = Collections.EMPTY_LIST;
    private final int LEFT = 0, RIGHT = 1;
    Context ctx;

    public  BasicChatAdapter(Context context){
        inflator = LayoutInflater.from(context);
        ctx = context;
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder = null;
        switch (viewType) {
            case LEFT:
                View v1 = inflator.inflate(R.layout.left_chat,parent,false);
                viewHolder = new BasicChatAdapter.BasicChatViewHolder(v1);
                break;
            case RIGHT:
                View view = inflator.inflate(R.layout.right_chat,parent,false);
                viewHolder = new BasicChatAdapter.BasicChatViewHolder(view);
                break;
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        switch (holder.getItemViewType()){
            case LEFT:
                BasicChatAdapter.BasicChatViewHolder vh1 = (BasicChatAdapter.BasicChatViewHolder)holder;
                configureViewHolder1(vh1,position);
                break;
            case RIGHT:
                BasicChatAdapter.BasicChatViewHolder vh2 = (BasicChatAdapter.BasicChatViewHolder)holder;
                configureViewHolder2(vh2,position);
                break;

        }
    }

    @Override
    public int getItemViewType(int position) {
        ChatDTO chatDTOItem = basicChatList.get(position);
        if(chatDTOItem.left){
         return  LEFT;
        }else{
            return  RIGHT;
        }
    }

    @Override
    public int getItemCount() {
        return basicChatList.size();
    }

    public void add(ChatDTO chatDTO){
        int size = basicChatList.size();
        if(size>0) {
            basicChatList.add(0,chatDTO);
        }else{
            basicChatList = new ArrayList<>();
            basicChatList.add(chatDTO);
        }
        int nextPosition   = 1;
        notifyItemInserted(nextPosition);
        //not
    }

    private void configureViewHolder1(BasicChatAdapter.BasicChatViewHolder holder, int position) {
        ChatDTO chatDTO =(ChatDTO) basicChatList.get(position);
        holder.title.setText(chatDTO.message);
    }

    private void configureViewHolder2(BasicChatAdapter.BasicChatViewHolder holder, int position) {
        ChatDTO chatDTO =(ChatDTO) basicChatList.get(position);
        holder.title.setText(chatDTO.message);
    }

    class BasicChatViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        ImageView title_icon;
        LinearLayout rootLayout;

        public BasicChatViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.msgr);
        }
    }
}
