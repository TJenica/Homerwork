package chapter.android.aweme.ss.com.homework;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

/**
 * 作业2：一个抖音笔试题：统计页面所有view的个数
 * Tips：ViewGroup有两个API
 * {@link android.view.ViewGroup #getChildAt(int) #getChildCount()}
 * 用一个TextView展示出来
 */
public class Exercises2 extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exercise2);
        TextView count=(TextView)findViewById(R.id.textView3);
        //View view = getWindow().getDecorView().findViewById(android.R.id.content);
        View view=findViewById(R.id.root_view);
        int num=getAllChildViewCount((ViewGroup) view);
        System.out.println(num);
        count.setText(""+num);

    }

    public int getAllChildViewCount(ViewGroup view) {
        //todo
        int viewcount = 0;

        for(int i=0;i<view.getChildCount();i++){
            View tempview= view.getChildAt(i);
            System.out.println("i="+i);
            if(tempview instanceof ViewGroup){
                viewcount += getAllChildViewCount((ViewGroup)tempview);
                System.out.println("viewcount="+viewcount);
            }
            else {
                viewcount ++;
                System.out.println("viewcount="+viewcount);
            }
        }

        return viewcount ;
//        int count=view.getChildCount();
//        System.out.println(count);
//        for(int i=0;i<count;i++){
//            System.out.println(1);
//            ViewGroup child= (ViewGroup) view.getChildAt(i);
//            System.out.println(i);
//            if(child instanceof ViewGroup){
//                System.out.println("yes");
//                int childcount= getAllChildViewCount(child);
//                count+=childcount;
//                System.out.println(count);
//            }
//            else
//                count++;
//        }
//        return count;



    }
}
