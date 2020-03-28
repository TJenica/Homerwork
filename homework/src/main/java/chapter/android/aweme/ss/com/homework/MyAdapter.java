package chapter.android.aweme.ss.com.homework;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.graphics.ColorUtils;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.nio.DoubleBuffer;
import java.util.List;

import chapter.android.aweme.ss.com.homework.R;
import chapter.android.aweme.ss.com.homework.model.Message;
import chapter.android.aweme.ss.com.homework.widget.CircleImageView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.NumberViewHolder> {

    private static final String TAG = "MyAdapter";

    private int mNumberItems;

    private final ListItemClickListener mOnClickListener;

    private static int viewHolderCount;

    private List<Message> mymessage;

    public MyAdapter(int numListItems, List<Message> messages, ListItemClickListener listener) {
        mNumberItems = numListItems;
        mOnClickListener = listener;
        viewHolderCount = 0;
        mymessage = messages;
    }

    @NonNull
    @Override
    public NumberViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        Context context = viewGroup.getContext();
        int layoutIdForListItem = R.layout.im_list_item;
        LayoutInflater inflater = LayoutInflater.from(context);
        boolean shouldAttachToParentImmediately = false;

        View view = inflater.inflate(layoutIdForListItem, viewGroup, shouldAttachToParentImmediately);
        NumberViewHolder viewHolder = new NumberViewHolder(view);

        Log.d(TAG, "onCreateViewHolder: number of ViewHolders created: " + viewHolderCount);
        viewHolderCount++;
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull NumberViewHolder numberViewHolder, int i) {
        Log.d(TAG, "onBindViewHolder: #" + i);
        numberViewHolder.bind(i);

    }


    @Override
    public int getItemCount() {
        return mNumberItems;
    }

    public interface ListItemClickListener {
        void onListItemClick(int clickedItemIndex);
    }


    public class NumberViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private final TextView title_view;
        private final TextView description_view;
        private final TextView time_view;
        private final CircleImageView icon_view;
        private final ImageView robot_notice;


        public NumberViewHolder(@NonNull View itemView) {

            super(itemView);
            title_view = (TextView) itemView.findViewById(R.id.tv_title);
            description_view = (TextView) itemView.findViewById(R.id.tv_description);
            time_view = (TextView) itemView.findViewById(R.id.tv_time);
            icon_view = (CircleImageView) itemView.findViewById(R.id.iv_avatar);
            robot_notice = (ImageView) itemView.findViewById(R.id.robot_notice);


            itemView.setOnClickListener(this);
            itemView.setVisibility(View.VISIBLE);
        }

        public void bind(int position) {

            Message tempmessage = mymessage.get(position);
            title_view.setText(tempmessage.getTitle());
            description_view.setText(tempmessage.getDescription());
            time_view.setText(tempmessage.getTime());
            String icon_type = tempmessage.getIcon();
            int icon_id = 0;
            switch (icon_type) {
                case "TYPE_ROBOT":
                    icon_id = R.drawable.session_robot;
                    break;
                case "TYPE_GAME":
                    icon_id = R.drawable.icon_micro_game_comment;
                    break;
                case "TYPE_SYSTEM":
                    icon_id = R.drawable.session_system_notice;
                    break;
                case "TYPE_STRANGER":
                    icon_id = R.drawable.session_stranger;
                    break;
                case "TYPE_USER":
                    icon_id = R.drawable.icon_girl;
                    break;

            }
            icon_view.setImageResource(icon_id);
            if(tempmessage.isOfficial()){
                int icon = R.drawable.im_icon_notice_official;

                robot_notice.setImageResource(icon);

                robot_notice.setVisibility(View.VISIBLE);
            }

        }

        @Override
        public void onClick(View view) {
            int clickedPosition = getAdapterPosition();
            System.out.println(clickedPosition);
            if (mOnClickListener != null) {
                System.out.println("mOnClickListener不为空");
                mOnClickListener.onListItemClick(clickedPosition);
            }
        }
    }
}


