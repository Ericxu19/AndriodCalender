package com.example.phase2calendar;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.phase2calendar.logic.Message;

import java.util.ArrayList;

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.MessageViewHolder> {

    private ArrayList<Message> messages;

    public static class MessageViewHolder extends RecyclerView.ViewHolder{
        public TextView senderView;
        public TextView contentView;
        public Button viewEventButton;
        public Button replyButton;
        public Button deleteMessageButton;

        public MessageViewHolder(@NonNull View itemView) {
            super(itemView);
            this.senderView = itemView.findViewById(R.id.senderView);
            this.contentView = itemView.findViewById(R.id.contentView);
            this.viewEventButton = itemView.findViewById(R.id.viewEventButton);
            this.replyButton = itemView.findViewById(R.id.replyButton);
            this.deleteMessageButton = itemView.findViewById(R.id.deleteMessageButton);
        }
    }

    public MessageAdapter(ArrayList<Message> messages) { this.messages = messages; }

    @NonNull
    @Override
    public MessageViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.message_item, viewGroup, false);
        MessageViewHolder messageViewHolder = new MessageViewHolder(v);
        return messageViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MessageViewHolder messageViewHolder, int i) {
        Message currentMessage = messages.get(i);

        messageViewHolder.senderView.setText(currentMessage.getSender().getUsername());
        messageViewHolder.contentView.setText(currentMessage.getText());
        if(!currentMessage.hasEvent()){
            messageViewHolder.viewEventButton.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    public int getItemCount() {
        return messages.size();
    }
}
