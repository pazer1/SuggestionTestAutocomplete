package com.dipdoo.suggestiontestautocomplete;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatAutoCompleteTextView;
import com.dipdoo.suggestiontestautocomplete.PlaceAutocomplete.AutoSuggestAdapter;
import com.dipdoo.suggestiontestautocomplete.PlaceAutocomplete.AutocompleteViewClass;



public class MainActivity extends AppCompatActivity {
    private static final int TRIGGER_AUTO_COMPLETE = 100;
    private static final long AUTO_COMPLETE_DELAY = 300;
    private Handler handler;
    private AutoSuggestAdapter autoSuggestAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AppCompatAutoCompleteTextView autoCompleteTextView = findViewById(R.id.auto_complete_edit_text);
        AutocompleteViewClass autocompleteViewClass = new AutocompleteViewClass(this,autoCompleteTextView);
    }
}
