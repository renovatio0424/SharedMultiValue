package com.example.renov.sharedmultivaluetest;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.save_button)
    Button saveButton;

    @BindView(R.id.save_data_text)
    TextView saveDataText;

    @BindView(R.id.edit_id)
    EditText editId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        String UserIdStringList = SharedPrefHelper.getInstance(this).getNoticeCheckUserId();

        if(UserIdStringList != null | !"".equals(UserIdStringList)){
            saveDataText.setText(UserIdStringList);
        }
    }

    @OnClick(R.id.save_button)
    public void onClickSaveButton(){
        String id = editId.getText().toString();

        if(id == null | id.equals("")){
            Toast.makeText(this, "아이디 값을 입력해주세요", Toast.LENGTH_SHORT).show();
            return;
        }

        SharedPrefHelper.getInstance(this).setNoticeCheckUserId(id);
    }
}
