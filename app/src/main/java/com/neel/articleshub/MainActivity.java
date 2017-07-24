package com.neel.articleshub;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.neel.articleshub.restapi.beans.ArticleDetail;
import com.neel.articleshub.restapi.request.*;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart(){
            super.onStart();
            RequestTask<ArticleDetail> rt=new RequestTask<ArticleDetail>(ArticleDetail.class, new Consumer<ArticleDetail>() {
                @Override
                public void accept(ArticleDetail article) {
                    try{
                        TextView titleText=(TextView) findViewById(R.id.titleText);
                        TextView dateText=(TextView) findViewById(R.id.publishdateText);
                        TextView authorText=(TextView) findViewById(R.id.authorText);
                        TextView contantText=(TextView) findViewById(R.id.contantText);
                        titleText.setText(article.getTitle());
                        authorText.setText(article.getAuthor());
                        dateText.setText(article.getDate());
                        StringBuilder contant=new StringBuilder();
                        for(String c:article.getContant())
                            contant.append(c).append("\n");
                        contantText.setText(contant.toString());
                    }catch(Exception ex){
                        ex.printStackTrace();
                    }
                }
            });
            rt.execute(getResources().getString(R.string.ser_base_url)+"/article/"+2);
    }
}
