package com.eaccid.txttranslator.presenter;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.eaccid.txttranslator.R;
import com.eaccid.txttranslator.provider.fromtext.WordFromText;
import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements BaseView, OnWordFromTextViewTouchListener.OnWordFromTextClickListener {

    MainPresenter mPresenter;
    @BindView(R.id.text_to_translate)
    TextView text_to_translate;
    @BindView(R.id.button_translate)
    Button button_translate;
    @BindView(R.id.fab)
    FloatingActionButton fab;
    @BindView(R.id.word_to_translate)
    EditText word_to_translate;
    @BindView(R.id.translated_text)
    TextView translated_text;
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Override
    public MainPresenter getPresenter() {
        return mPresenter;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        if (mPresenter == null)
            mPresenter = new MainPresenter();
        mPresenter.attachView(this);
        setSupportActionBar(toolbar);
        text_to_translate.setOnTouchListener(new OnWordFromTextViewTouchListener());
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.detachView();
    }

    @OnClick(R.id.fab)
    public void onFabClick() {
        mPresenter.onFabClicked();
    }

    @OnClick(R.id.button_translate)
    public void onButtonTranslateClick() {
        mPresenter.onButtonTranslateClick(word_to_translate.getText().toString());
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
    public void showTextTranslation(List<String> text) {
        translated_text.setText(text.toString());
    }

}
