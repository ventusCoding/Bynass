package com.example.bynass.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bynass.Class.FamilyMember;
import com.example.bynass.R;

import java.util.ArrayList;

public class FamilyMemberAdapter extends RecyclerView.Adapter<FamilyMemberAdapter.FamilyMemberViewHolder> {

    Context context;
    ArrayList<FamilyMember> familyMemberArrayList;

    public FamilyMemberAdapter(Context c , ArrayList<FamilyMember> familyMembers)
    {
        context = c;
        familyMemberArrayList = familyMembers;
    }

    @NonNull
    @Override
    public FamilyMemberViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new FamilyMemberViewHolder(LayoutInflater.from(context).inflate(R.layout.family_member_card , parent , false));
    }

    @Override
    public void onBindViewHolder(@NonNull FamilyMemberViewHolder holder, int position) {

        holder.familyMemberEmail.setText(familyMemberArrayList.get(position).getEmail());

    }

    @Override
    public int getItemCount() {
        return familyMemberArrayList.size();
    }

    class FamilyMemberViewHolder extends  RecyclerView.ViewHolder{

        TextView familyMemberEmail;

        public FamilyMemberViewHolder(@NonNull View itemView) {
            super(itemView);

            familyMemberEmail = (TextView) itemView.findViewById(R.id.family_member_email_txt);

        }
    }

}


