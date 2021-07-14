package com.example.bynass.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bynass.Adapter.FamilyMemberAdapter;
import com.example.bynass.Class.FamilyMember;
import com.example.bynass.R;

import java.util.ArrayList;

public class FragmentProfil extends Fragment {

    ArrayList<FamilyMember> familyMembers = new ArrayList();
    FamilyMemberAdapter familyMemberAdapter;
    RecyclerView familyMemberRecyclerView;

    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public View onCreateView(@NonNull @org.jetbrains.annotations.NotNull LayoutInflater inflater, @Nullable @org.jetbrains.annotations.Nullable ViewGroup container, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profil,container,false);

        familyMemberRecyclerView = view.findViewById(R.id.family_member_recyclerview);

        familyMemberRecyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));

        familyMembers.add(new FamilyMember("example1@gmail.com"));
        familyMembers.add(new FamilyMember("example2@gmail.com"));
        familyMembers.add(new FamilyMember("example3@gmail.com"));
        familyMembers.add(new FamilyMember("example4@gmail.com"));
        familyMembers.add(new FamilyMember("example5@gmail.com"));
        familyMembers.add(new FamilyMember("example6@gmail.com"));
        familyMembers.add(new FamilyMember("example7@gmail.com"));
        familyMembers.add(new FamilyMember("example8@gmail.com"));
        familyMembers.add(new FamilyMember("example9@gmail.com"));
        familyMembers.add(new FamilyMember("example10@gmail.com"));



        familyMemberAdapter = new FamilyMemberAdapter(view.getContext(), familyMembers);
        familyMemberRecyclerView.setAdapter(familyMemberAdapter);

        return view;
    }
}
