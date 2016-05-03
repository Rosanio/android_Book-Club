package com.example.guest.bookclub.ui;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

import com.example.guest.bookclub.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class AddCommentFragment extends DialogFragment implements TextView.OnEditorActionListener{
    @Bind(R.id.commentAuthorEditText) EditText mAuthorEditText;
    @Bind(R.id.commentContentEditText) EditText mContentEditText;

    public interface AddCommentDialogListener {
        void onFinishEditDialog(String authorText, String contentText);
    }


    public static AddCommentFragment newInstance(String title) {
       AddCommentFragment frag = new AddCommentFragment();
        Bundle args = new Bundle();
        args.putString("title", title);
        frag.setArguments(args);
        return frag;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_comment, container, false);

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        String title = getArguments().getString("title", "Leave a Comment");
        getDialog().setTitle(title);

        mContentEditText.setOnEditorActionListener(this);

        mAuthorEditText.requestFocus();
        getDialog().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
    }

    @Override
    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
        if(EditorInfo.IME_ACTION_DONE == actionId) {
            AddCommentDialogListener listener = (AddCommentDialogListener) getActivity();
            listener.onFinishEditDialog(mAuthorEditText.getText().toString(), mContentEditText.getText().toString());
            dismiss();
            return true;
        }
        return false;
    }

}
