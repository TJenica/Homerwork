package chapter.android.aweme.ss.com.homework;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;


public class chatActivity extends AppCompatActivity {

    private TextView message;
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chatroom);

        Intent intent = getIntent();

        int id = intent.getIntExtra("click_id",0);

        System.out.println(id);

        message=(TextView)findViewById(R.id.tv_content_info);
        message.setText("你好呀！我是 "+id);

    }
}
