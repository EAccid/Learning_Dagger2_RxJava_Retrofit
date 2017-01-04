package com.eaccid.txttranslator.presenter;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.eaccid.txttranslator.R;
import com.eaccid.txttranslator.provider.fromtext.WordFromText;
import com.eaccid.txttranslator.model.translator.ytranslator_impl.TextTranslation;

public class MainActivity extends AppCompatActivity implements BaseView, OnWordFromTextViewTouchListener.OnWordFromTextClickListener {

    MainPresenter mPresenter;

    @Override
    public MainPresenter getPresenter() {
        return mPresenter;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (mPresenter == null) mPresenter = new MainPresenter();
        mPresenter.attachView(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPresenter.onFabClicked();
            }
        });
        TextView tv = (TextView) findViewById(R.id.text_to_translate);
        tv.setOnTouchListener(new OnWordFromTextViewTouchListener());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.detachView();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onWordClicked(WordFromText wordFromText) {
        mPresenter.onWordClicked(wordFromText);
    }

    public void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showTextTranslation(TextTranslation text) {

    }

}
