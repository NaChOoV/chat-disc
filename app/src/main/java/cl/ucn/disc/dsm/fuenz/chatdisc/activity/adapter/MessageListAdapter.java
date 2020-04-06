/*
 * Copyright (c) 2020. This code is purely educational, the rights of use are
 *  reserved, the owner of the code is Ignacio Fuenzalida Veas
 *  contact ignacio.fuenzalida@alumnos.ucn.cl
 *  Do not use in production.
 */

package cl.ucn.disc.dsm.fuenz.chatdisc.activity.adapter;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import cl.ucn.disc.dsm.fuenz.chatdisc.R;
import cl.ucn.disc.dsm.fuenz.chatdisc.room.entity.Message;

public class MessageListAdapter extends RecyclerView
        .Adapter<MessageListAdapter.MessageViewHolder> {

    static class MessageViewHolder extends RecyclerView.ViewHolder {

        private final TextView timeTextView, messageTextView, locationTextView;
        private LinearLayout linearLayout;

        private MessageViewHolder(View messageView){
            super(messageView);
            timeTextView = messageView.findViewById(R.id.time_text);
            messageTextView = messageView.findViewById(R.id.message_text);
            locationTextView = messageView.findViewById(R.id.gps_text);
            linearLayout = messageView.findViewById(R.id.message_cardview);


        }
    }

    private final LayoutInflater messageInflater;
    private List<Message> messageList;

    private int userId;

    public MessageListAdapter(Context context, int userId){
        messageInflater = LayoutInflater.from(context);
        this.userId = userId;
    }

    @NotNull
    @Override
    public MessageViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int viewType){
        View itemView = messageInflater.inflate(R.layout.rv_message,parent,false);
        return new MessageViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(@NotNull MessageViewHolder holder, int position){
        if(messageList != null){
            Message current = messageList.get(position);
            holder.messageTextView.setText(current.getMessage());
            holder.timeTextView.setText(current.getTime());
            holder.locationTextView.setText("GPS");


            if(userId == current.getUserOne())
                holder.linearLayout.setGravity(Gravity.END);
            else
                holder.linearLayout.setGravity(Gravity.START);



            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT);

            if(userId == current.getUserOne())
                params.gravity = Gravity.END;
            else
                params.gravity = Gravity.START;

            holder.linearLayout.setLayoutParams(params);



        }else{
            holder.messageTextView.setText("No message)");
            holder.timeTextView.setText("No time");
            holder.locationTextView.setText("no GPS");

        }
    }

    public void setMessage(List<Message> messages){
        messageList = messages;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        if (messageList != null)
            return messageList.size();
        else return 0;
    }


}
