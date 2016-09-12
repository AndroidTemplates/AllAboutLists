package list.listtemplates.DragDropList;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

/**
 * Created by CHANDRASAIMOHAN on 9/12/2016.
 */
public class DragDropTouchHelper  extends ItemTouchHelper.SimpleCallback {
    private DragDropAdapter dragDropAdapter;

    public  DragDropTouchHelper(DragDropAdapter dragDropAdapter){
        super(ItemTouchHelper.UP | ItemTouchHelper.DOWN, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT);
        this.dragDropAdapter = dragDropAdapter;
    }

    @Override
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
        dragDropAdapter.swap(viewHolder.getAdapterPosition(), target.getAdapterPosition());
        return true;
    }

    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
        dragDropAdapter.delete(viewHolder.getAdapterPosition());
    }
}
