package com.example.wan_android.component;

import android.content.Context;
import android.content.pm.LauncherApps;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.core.content.res.ResourcesCompat;

import com.example.wan_android.R;
import com.example.wan_android.databinding.SettingCustomWordBinding;

public class Setting_Custom_Word extends LinearLayout {

//          <attr name="txt_size" format="dimension"/>
//        <attr name="txt_big_string" format="string"/>
//        <attr name="txt_small_string" format="string"/>
//        <attr name="txt_big_color" format="color"/>
//        <attr name="txt_small_color" format="color"/>

    private Float txt_big_size = (float) getResources().getDimensionPixelSize(R.dimen.default_txtsize);
    private Float txt_small_size = txt_big_size*3/4;
    private String txt_big_string = "";
    private String txt_small_string = "";
    private int txt_big_color = ResourcesCompat.getColor(getResources(), R.color.defult_txt_big_color, null);
    private int txt_small_color = getResources().getColor(R.color.gray, null);
//            ResourcesCompat.getColor(getResources(), R.color.defult_txt_small_color, null);

    private SettingCustomWordBinding binding;

    public Setting_Custom_Word(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.Setting_Custom_Word);
        getValue(typedArray);
        initViews(context);
    }

    public Setting_Custom_Word(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.Setting_Custom_Word);
        getValue(typedArray);
        initViews(context);
    }

    private void getValue(TypedArray typedArray){
        txt_big_string = typedArray.getString(R.styleable.Setting_Custom_Word_txt_big_string);
        txt_big_size = typedArray.getDimension(R.styleable.Setting_Custom_Word_txt_size, getResources().getDimension(R.dimen.default_txtsize));
        txt_big_color = typedArray.getColor(R.styleable.Setting_Custom_Word_txt_big_color, ResourcesCompat.getColor(getResources(), R.color.defult_txt_big_color, null));

        txt_small_string = typedArray.getString(R.styleable.Setting_Custom_Word_txt_small_string);
        txt_small_size = txt_big_size * 3 / 4;
        txt_small_color = typedArray.getColor(R.styleable.Setting_Custom_Word_txt_small_color, ResourcesCompat.getColor(getResources(), R.color.gray, null));
        typedArray.recycle();
    }

    private void initViews(Context context){
        View view = inflate(context, R.layout.setting_custom_word, this);
        TextView txtBig = view.findViewById(R.id.txt_big);
        TextView txtSmall = view.findViewById(R.id.txt_small);
        View view1 = view.findViewById(R.id.cut_line);
        setOrientation(VERTICAL);
//        binding.getRoot().setBackgroundColor(getResources().getColor(R.color.amaranth_pink, null));
        LayoutParams txt_big_layoutparam = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        txt_big_layoutparam.setMargins(5,5,5,5);
        txtBig.setTextSize(TypedValue.COMPLEX_UNIT_PX, txt_big_size);
        txtBig.setTextColor(txt_big_color);
        txtBig.setLayoutParams(txt_big_layoutparam);
        txtBig.setText(txt_big_string);

        LayoutParams txt_small_layoutparam = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        txt_small_layoutparam.setMargins(5,5,5,5);
        txtSmall.setTextSize(TypedValue.COMPLEX_UNIT_PX, txt_small_size);
        txtSmall.setTextColor(txt_small_color);
        txtSmall.setLayoutParams(txt_small_layoutparam);
        txtSmall.setText(txt_small_string);

        LayoutParams cut_line_layoutparam = new LayoutParams(LayoutParams.MATCH_PARENT, 5);
        cut_line_layoutparam.setMargins(0, 8, 0, 0);
        view1.setLayoutParams(cut_line_layoutparam);



    }
}
