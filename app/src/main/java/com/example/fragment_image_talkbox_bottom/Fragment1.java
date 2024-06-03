package com.example.fragment_image_talkbox_bottom;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class Fragment1 extends Fragment {

    private TextView textView;
    private boolean isTextViewVisible = true;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment1, container, false);

        textView = view.findViewById(R.id.textView);
        Button buttonShowDialog = view.findViewById(R.id.button_show_dialog);
        Button buttonChangeText = view.findViewById(R.id.button_change_text);
        Button buttonShowToast = view.findViewById(R.id.button_show_toast);
        Button buttonResetFragment = view.findViewById(R.id.button_reset_fragment);
        Button buttonChangeBackground = view.findViewById(R.id.button_change_background);
        Button buttonToggleTextView = view.findViewById(R.id.button_toggle_text_view);
        ImageView imageView = view.findViewById(R.id.image);

        // 다이얼로그 버튼 클릭 리스너
        buttonShowDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(getActivity())
                        .setTitle("Dialog")
                        .setMessage("Do you want to switch to another fragment?")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // Fragment 전환 코드
                                Fragment2 fragment2 = new Fragment2();
                                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                                transaction.replace(R.id.fragment_container, fragment2);
                                transaction.addToBackStack(null);
                                transaction.commit();
                            }
                        })
                        .setNegativeButton("No", null)
                        .show();
            }
        });

        // 텍스트 변경 버튼 클릭 리스너
        buttonChangeText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText("Text changed!");
            }
        });

        // 토스트 메시지 버튼 클릭 리스너
        buttonShowToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "This is a toast message", Toast.LENGTH_SHORT).show();
            }
        });

        // 프래그먼트 초기화 버튼 클릭 리스너
        buttonResetFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.detach(Fragment1.this).attach(Fragment1.this).commit();
            }
        });

        // 배경색 변경 버튼 클릭 리스너
        buttonChangeBackground.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(getResources().getColor(android.R.color.holo_blue_light));
            }
        });

        // 텍스트뷰 숨기기/보이기 버튼 클릭 리스너
        buttonToggleTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isTextViewVisible) {
                    textView.setVisibility(View.GONE);
                } else {
                    textView.setVisibility(View.VISIBLE);
                }
                isTextViewVisible = !isTextViewVisible;
            }
        });

        // 이미지 클릭 리스너
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Image clicked", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}
