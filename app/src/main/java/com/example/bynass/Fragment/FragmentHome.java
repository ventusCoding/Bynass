package com.example.bynass.Fragment;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import com.example.bynass.R;

public class FragmentHome extends Fragment {

    Button addAssurenceBtn, addFamilyMemberBtn;

    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public View onCreateView(@NonNull @org.jetbrains.annotations.NotNull LayoutInflater inflater, @Nullable @org.jetbrains.annotations.Nullable ViewGroup container, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home_main,container,false);

        addAssurenceBtn = view.findViewById(R.id.add_assurence_btn);
        addFamilyMemberBtn = view.findViewById(R.id.add_family_member_btn);

        addAssurenceBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog("Assurence",v);
            }
        });

        addFamilyMemberBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog("Family Member",v);
            }
        });

        return view;
    }
    void showDialog(String name,View v){
        final EditText email = new EditText(v.getContext());
        AlertDialog.Builder Dialog = new AlertDialog.Builder(v.getContext());
        Dialog.setTitle("Add "+ name);
        Dialog.setMessage("E-mail");
        Dialog.setView(email);

        Dialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                //ok
            }
        });
        Dialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                //close the dialog
            }
        });
        Dialog.create().show();
    }
}
