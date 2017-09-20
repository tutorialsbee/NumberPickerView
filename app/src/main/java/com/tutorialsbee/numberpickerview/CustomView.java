package com.tutorialsbee.numberpickerview;

import android.content.Context;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.TableLayout;

import java.lang.reflect.Field;

/**
 * Created by Star on 9/19/2017.
 */

public class CustomView extends TableLayout {

    NumberPicker np1;
    NumberPicker np2;
    NumberPicker np3;
    NumberPicker np4;

    public static String[] values;

    public static Integer DEFAULT_MIN = 0;
    public static Integer DEFAULT_MAX = 9;

    public CustomView(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.custom_view, this);

        np1 = (NumberPicker) view.findViewById(R.id.np_1);
        np2 = (NumberPicker) view.findViewById(R.id.np_2);
        np3 = (NumberPicker) view.findViewById(R.id.np_3);
        np4 = (NumberPicker) view.findViewById(R.id.np_4);
        np4.setEnabled(false);

        setDefaults();

        np1.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker numberPicker, int i, int i1) {

                setNp4();

            }
        });

        np2.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker numberPicker, int i, int i1) {
                setNp4();
            }
        });

        np3.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker numberPicker, int i, int i1) {
                setNp4();
            }
        });

        setNp4();

    }

    private void setNp4() {


        if (np1.getValue() > 0) {
            np4.setValue(0);
        } else if (np2.getValue() > 0) {
            np4.setValue(1);
        } else if (np3.getValue() > 0) {
            np4.setValue(2);
        } else {
            np4.setValue(3);
        }

    }

    private void setDefaults() {
        values = new String[]{"hours", "minutes", "seconds", "milliseconds"};
        np1.setMinValue(DEFAULT_MIN);
        np1.setMaxValue(DEFAULT_MAX);

        np2.setMinValue(DEFAULT_MIN);
        np2.setMaxValue(DEFAULT_MAX);

        np3.setMinValue(DEFAULT_MIN);
        np3.setMaxValue(DEFAULT_MAX);

        np4.setMinValue(DEFAULT_MIN);
        np4.setMaxValue(values.length - 1);

        np4.setDisplayedValues(values);

    }

    /*public void setRange(int index, int min, int max) {

        switch (index) {
            case 1:
                np1.setMinValue(min);
                np1.setMaxValue(max);
                break;
            case 2:
                np2.setMinValue(min);
                np2.setMaxValue(max);
                break;
            case 3:
                np3.setMinValue(min);
                np3.setMaxValue(max);
                break;
            case 4:
                np4.setMinValue(min);
                np4.setMaxValue(max);
                break;
        }
    }*/

    /*public NumberPicker getView(int index) {

        switch (index) {
            case 1:
                return np1;
            case 2:
                return np2;
            case 3:
                return np3;
            case 4:
                return np4;
            default:
                return null;
        }

    }*/

    public String[] getValue() {
        Integer val1 = np1.getValue();
        Integer val2 = np2.getValue();
        Integer val3 = np3.getValue();
        Integer val4 = np4.getValue();

        return new String[]{val1.toString(), val2.toString(), val3.toString(), val4.toString()};
    }

    public Integer getVal1() {
        return np1.getValue();
    }

    public Integer getVal2() {
        return np2.getValue();
    }

    public Integer getVal3() {
        return np3.getValue();
    }

    public Integer getVal4() {
        return np4.getValue();
    }

    /*public static boolean setNumberPickerTextColor(NumberPicker numberPicker, int color) {
        final int count = numberPicker.getChildCount();
        for (int i = 0; i < count; i++) {
            View child = numberPicker.getChildAt(i);
            if (child instanceof EditText) {
                if (String.valueOf(numberPicker.getValue()).equals(((EditText) child).getText().toString())) {
                    try {
                        Field selectorWheelPaintField = numberPicker.getClass()
                                .getDeclaredField("mSelectorWheelPaint");
                        selectorWheelPaintField.setAccessible(true);
                        ((Paint) selectorWheelPaintField.get(numberPicker)).setColor(color);
                        ((EditText) child).setTextColor(color);
                        numberPicker.invalidate();
                        return true;
                    } catch (NoSuchFieldException e) {
                    } catch (IllegalAccessException e) {
                    } catch (IllegalArgumentException e) {
                    }
                }
            }
        }
        return false;
    }*/

}
