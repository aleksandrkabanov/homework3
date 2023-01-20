package ru.kabanov.homework3.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

import ru.kabanov.homework3.R;
import ru.kabanov.homework3.model.CalculatorImpl;
import ru.kabanov.homework3.model.Operator;

public class MainActivity extends AppCompatActivity implements CalculatorView {

    private TextView resultTxt;

    private CalculatorPresenter presenter;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultTxt = findViewById(R.id.result);

        presenter = new CalculatorPresenter(this, new CalculatorImpl());

        Map<Integer, Integer> digits = new HashMap<>();
        digits.put(R.id.key_1, 1);
        digits.put(R.id.key_2, 2);
        digits.put(R.id.key_3, 3);
        digits.put(R.id.key_4, 4);
        digits.put(R.id.key_5, 5);
        digits.put(R.id.key_6, 6);
        digits.put(R.id.key_7, 7);
        digits.put(R.id.key_8, 8);
        digits.put(R.id.key_9, 9);
        digits.put(R.id.key_0, 0);

        View.OnClickListener digitClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.onDigitPressed(digits.get(view.getId()));

            }
        };

        findViewById(R.id.key_1).setOnClickListener(digitClickListener);
        findViewById(R.id.key_2).setOnClickListener(digitClickListener);
        findViewById(R.id.key_3).setOnClickListener(digitClickListener);
        findViewById(R.id.key_4).setOnClickListener(digitClickListener);
        findViewById(R.id.key_5).setOnClickListener(digitClickListener);
        findViewById(R.id.key_6).setOnClickListener(digitClickListener);
        findViewById(R.id.key_7).setOnClickListener(digitClickListener);
        findViewById(R.id.key_8).setOnClickListener(digitClickListener);
        findViewById(R.id.key_9).setOnClickListener(digitClickListener);
        findViewById(R.id.key_0).setOnClickListener(digitClickListener);

        Map<Integer, Operator> operators = new HashMap<>();
        operators.put(R.id.key_plus, Operator.ADD);
        operators.put(R.id.key_minus, Operator.SUB);
        operators.put(R.id.key_div, Operator.DIV);
        operators.put(R.id.key_multi, Operator.MULT);

        View.OnClickListener operatorsClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.onOperatorPressed(operators.get(view.getId()));

            }
        };

        findViewById(R.id.key_plus).setOnClickListener(operatorsClickListener);
        findViewById(R.id.key_minus).setOnClickListener(operatorsClickListener);
        findViewById(R.id.key_multi).setOnClickListener(operatorsClickListener);
        findViewById(R.id.key_div).setOnClickListener(operatorsClickListener);

        findViewById(R.id.key_dot).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                presenter.onDotPressed();
            }
        });
    }
    @Override
    public void showResult(String result){

        resultTxt.setText(result);
    }
}