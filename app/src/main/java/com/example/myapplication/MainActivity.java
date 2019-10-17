package com.example.myapplication;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements ItemAdapter.OnNumberClickListener {
    @Override
    protected void onCreate(@NonNull Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListFragment listFragment = (ListFragment) getSupportFragmentManager().findFragmentByTag(ListFragment.TAG);
        if (listFragment == null) {
            listFragment = new ListFragment();
        }

        if (getSupportFragmentManager().findFragmentByTag(ListFragment.TAG) != null) {
            return;
        }

        getSupportFragmentManager().beginTransaction().add(R.id.container, listFragment, ListFragment.TAG).commit();
    }

    @Override
    public void onNumberClick(int number, int color) {
        ItemFragment itemFragment;
        itemFragment = (ItemFragment) getSupportFragmentManager().findFragmentByTag(ItemFragment.TAG);

        if (itemFragment == null) {
            itemFragment = new ItemFragment();
        }

        final Bundle bundle = new Bundle();
        bundle.putInt(ItemFragment.key_number, number);
        bundle.putInt(ItemFragment.key_color, color);
        itemFragment.setArguments(bundle);


        if (getSupportFragmentManager().findFragmentByTag(ItemFragment.TAG) != null) {
            return;
        }

        getSupportFragmentManager().beginTransaction().replace(R.id.container, itemFragment, ItemFragment.TAG).addToBackStack(ItemFragment.TAG).commit();
    }
}