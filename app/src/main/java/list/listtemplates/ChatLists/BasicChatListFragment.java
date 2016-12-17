package list.listtemplates.ChatLists;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

import list.listtemplates.DividerItemDecoration;
import list.listtemplates.R;
import list.listtemplates.Utils.ListUtils;
import list.listtemplates.simpleListAdapters.SimpleListType1Adapter;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BasicChatListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BasicChatListFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    RecyclerView basic_chat_view;
    private EditText chatText;
    private Button buttonSend;
    private boolean side = false;
    View chat_recycler_view;
    BasicChatAdapter basicChatAdapter;

    String[] reply = {
            "Hello", "good", "How is it going?", "Looks Good"
    };

    public BasicChatListFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BasicChatListFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BasicChatListFragment newInstance(String param1, String param2) {
        BasicChatListFragment fragment = new BasicChatListFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        chat_recycler_view = inflater.inflate(R.layout.fragment_basic_chat_list, container, false);
        initToolBar();
        initViews(chat_recycler_view);

        basicChatAdapter = new BasicChatAdapter(getActivity());
        basic_chat_view.setAdapter(basicChatAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setReverseLayout(true);
        //   linearLayoutManager.setStackFromEnd(true);
        basic_chat_view.setLayoutManager(linearLayoutManager);

        RecyclerView.ItemDecoration itemDecoration =
                new DividerItemDecoration(getActivity(), LinearLayoutManager.VERTICAL);
        basic_chat_view.addItemDecoration(itemDecoration);
        basic_chat_view.setItemAnimator(new DefaultItemAnimator());

        chatText.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if ((event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    return sendBasicChatMessage();
                }
                return false;
            }
        });
        buttonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                sendBasicChatMessage();
            }
        });

        basicChatAdapter.registerAdapterDataObserver(new RecyclerView.AdapterDataObserver() {
            @Override
            public void onChanged() {
                super.onChanged();
                basic_chat_view.scrollToPosition(basicChatAdapter.getItemCount() - 1);
            }
        });
        return chat_recycler_view;
    }

    private void initToolBar() {
        Toolbar mToolBar = (Toolbar) getActivity().findViewById(R.id.app_toolbar);
        TextView toolBarTitle = (TextView) mToolBar.findViewById(R.id.title);
        toolBarTitle.setText("BasicChatList");

    }

    private void initViews(View view) {
        basic_chat_view = (RecyclerView) view.findViewById(R.id.chat_recycler_view);
        buttonSend = (Button) view.findViewById(R.id.send);
        chatText = (EditText) view.findViewById(R.id.msg);
    }

    private boolean sendBasicChatMessage() {
        basicChatAdapter.add(new ChatDTO(side, chatText.getText().toString()));
        chatText.setText("");
        side = !side;

      //  sendReplyChatMessage();
        return true;
    }

    private boolean sendReplyChatMessage(){
    try
    {
        Thread.sleep(100);
        int randomNum = randInt(0, reply.length - 1);
        basicChatAdapter.add(new ChatDTO(side, reply[randomNum]));
        chatText.setText("");
        side = !side;
    }
    catch(InterruptedException e)
    {
        e.printStackTrace();
    }
    return true;

}

    public static int randInt(int min, int max) {

        // Usually this can be a field rather than a method variable
        Random rand = new Random();

        // nextInt is normally exclusive of the top value,
        // so add 1 to make it inclusive
        int randomNum = rand.nextInt((max - min) + 1) + min;

        return randomNum;
    }
}
