package com.example.calculator;


import android.graphics.Color;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.app.Activity;

import java.text.NumberFormat;


public class MainActivity extends Activity implements View.OnClickListener, View.OnTouchListener{



    EditText enter, answer;
    Button one, two, three, four, five, six, seven, eight, nine, zero;
    Button point, clear, bracket1, bracket2;
    Button sin, asin, cos, acos, tan, atan;
    Button sqrt, yX;
    Button plus, equal, minus, split, multiply, split_rev;
    Button bin,oct,hex;
    Button pi, ln, factorial, e;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Window window = getWindow();
        window.setStatusBarColor(Color.rgb(0,0,0));

        enter = (EditText) findViewById(R.id.enter);
        answer = (EditText) findViewById(R.id.answer);

        one = (Button) findViewById(R.id.one);
        two = (Button) findViewById(R.id.two);
        three = (Button) findViewById(R.id.three);
        four = (Button) findViewById(R.id.four);
        five = (Button) findViewById(R.id.five);
        six = (Button) findViewById(R.id.six);
        seven = (Button) findViewById(R.id.seven);
        eight = (Button) findViewById(R.id.eight);
        nine = (Button) findViewById(R.id.nine);
        zero = (Button) findViewById(R.id.zero);
        point = (Button) findViewById(R.id.point);
        clear = (Button) findViewById(R.id.clear);
        bracket1 = (Button) findViewById(R.id.bracket1);
        bracket2 = (Button) findViewById(R.id.bracket2);

        plus = (Button) findViewById(R.id.plus);
        minus = (Button) findViewById(R.id.minus);
        equal = (Button) findViewById(R.id.equal);
        split = (Button) findViewById(R.id.split);
        split_rev = (Button) findViewById(R.id.split_revision);
        multiply = (Button) findViewById(R.id.multiply);
        pi = (Button) findViewById(R.id.pi);
        String s = new String(Character.toChars(120529));
        pi.setTextSize(20);
        pi.setText(s);
        ln = (Button) findViewById(R.id.ln);
        factorial = (Button) findViewById(R.id.factorial);
        e = (Button) findViewById(R.id.exp);


        sqrt = (Button) findViewById(R.id.sqrt);
        yX = (Button) findViewById(R.id.yX);

        sin = (Button) findViewById(R.id.sin);
        asin = (Button) findViewById(R.id.asin);
        cos = (Button) findViewById(R.id.cos);
        acos = (Button) findViewById(R.id.acos);
        tan = (Button) findViewById(R.id.tan);
        atan = (Button) findViewById(R.id.atan);

        bin = (Button) findViewById(R.id.bin);
        oct = (Button) findViewById(R.id.oct);
        hex = (Button) findViewById(R.id.hex);

        one.setOnClickListener(this);
        two.setOnClickListener(this);
        three.setOnClickListener(this);
        four.setOnClickListener(this);
        five.setOnClickListener(this);
        six.setOnClickListener(this);
        seven.setOnClickListener(this);
        eight.setOnClickListener(this);
        nine.setOnClickListener(this);
        zero.setOnClickListener(this);
        point.setOnClickListener(this);

        clear.setOnTouchListener(this);
        bracket1.setOnClickListener(this);
        bracket2.setOnClickListener(this);

        plus.setOnClickListener(this);
        minus.setOnClickListener(this);
        equal.setOnClickListener(this);
        split.setOnClickListener(this);
        split_rev.setOnClickListener(this);
        multiply.setOnClickListener(this);
        pi.setOnClickListener(this);
        factorial.setOnClickListener(this);
        e.setOnClickListener(this);

        sqrt.setOnClickListener(this);
        yX.setOnClickListener(this);
        ln.setOnClickListener(this);

        sin.setOnClickListener(this);
        asin.setOnClickListener(this);
        cos.setOnClickListener(this);
        acos.setOnClickListener(this);
        tan.setOnClickListener(this);
        atan.setOnClickListener(this);

        bin.setOnClickListener(this);
        oct.setOnClickListener(this);
        hex.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {

        Integer buf;
        try
        {
            switch(v.getId())
            {
                case R.id.one:
                    enter.setText(enter.getText()+"1");
                    enter.setSelection(enter.getText().length());
                    break;
                case R.id.two:
                    enter.setText(enter.getText()+"2");
                    enter.setSelection(enter.getText().length());
                    break;
                case R.id.three:
                    enter.setText(enter.getText()+"3");
                    enter.setSelection(enter.getText().length());
                    break;
                case R.id.four:
                    enter.setText(enter.getText()+"4");
                    enter.setSelection(enter.getText().length());
                    break;
                case R.id.five:
                    enter.setText(enter.getText()+"5");
                    enter.setSelection(enter.getText().length());
                    break;
                case R.id.six:
                    enter.setText(enter.getText()+"6");
                    enter.setSelection(enter.getText().length());
                    break;
                case R.id.seven:
                    enter.setText(enter.getText()+"7");
                    enter.setSelection(enter.getText().length());
                    break;
                case R.id.eight:
                    enter.setText(enter.getText()+"8");
                    enter.setSelection(enter.getText().length());
                    break;
                case R.id.nine:
                    enter.setText(enter.getText()+"9");
                    enter.setSelection(enter.getText().length());
                    break;
                case R.id.zero:
                    enter.setText(enter.getText()+"0");
                    enter.setSelection(enter.getText().length());
                    break;
                case R.id.point:
                    enter.setText(enter.getText()+".");
                    enter.setSelection(enter.getText().length());
                    break;
                case  R.id.bracket1:
                    enter.setText(enter.getText()+"(");
                    enter.setSelection(enter.getText().length());
                    break;
                case R.id.bracket2:
                    enter.setText(enter.getText()+")");
                    enter.setSelection(enter.getText().length());
                    break;
                case R.id.plus:
                    enter.setText(enter.getText()+"+");
                    enter.setSelection(enter.getText().length());
                    break;
                case R.id.sin:
                    enter.setText(enter.getText() + "sin(");
                    enter.setSelection(enter.getText().length());
                    break;
                case R.id.asin:
                    enter.setText(enter.getText() + "asin(");
                    enter.setSelection(enter.getText().length());
                    break;
                case R.id.cos:
                    enter.setText(enter.getText() + "cos(");
                    enter.setSelection(enter.getText().length());
                    break;
                case R.id.acos:
                    enter.setText(enter.getText() + "acos(");
                    enter.setSelection(enter.getText().length());
                    break;
                case R.id.tan:
                    enter.setText(enter.getText() + "tan(");
                    enter.setSelection(enter.getText().length());
                    break;
                case R.id.atan:
                    enter.setText(enter.getText() + "atan(");
                    enter.setSelection(enter.getText().length());
                    break;
                case R.id.sqrt:
                    enter.setText(enter.getText() + "sqrt(");
                    enter.setSelection(enter.getText().length());
                    break;
                case R.id.yX:
                    enter.setText(enter.getText() + "^");
                    enter.setSelection(enter.getText().length());
                    break;
                case R.id.minus:
                    enter.setText(enter.getText()+"-");
                    enter.setSelection(enter.getText().length());
                    break;
                case R.id.split:
                    enter.setText(enter.getText()+"/");
                    enter.setSelection(enter.getText().length());
                    break;
                case R.id.split_revision:
                    enter.setText(enter.getText()+"%");
                    enter.setSelection(enter.getText().length());
                    break;
                case R.id.multiply:
                    enter.setText(enter.getText()+"*");
                    enter.setSelection(enter.getText().length());
                    break;
                case R.id.equal:
                    answer.setText(Double.toString(eval(enter.getText().toString())));
                    break;
                case R.id.bin:
                    buf = Integer.parseInt(enter.getText().toString());
                    answer.setText(Integer.toBinaryString(buf));
                    break;
                case R.id.oct:
                    buf = Integer.parseInt(enter.getText().toString());
                    answer.setText(Integer.toOctalString(buf));

                    break;
                case R.id.hex:
                    buf = Integer.parseInt(enter.getText().toString());
                    answer.setText(Integer.toHexString(buf));
                    break;
                case R.id.pi:
                    enter.setText(enter.getText()+"3.141592653589");
                    enter.setSelection(enter.getText().length());
                    break;
                case R.id.ln:
                    enter.setText(enter.getText() + "ln(");
                    enter.setSelection(enter.getText().length());
                    break;
                case R.id.factorial:
                    enter.setText(enter.getText() + "!");
                    enter.setSelection(enter.getText().length());

                    Integer a = factorial(enter.getText().toString());
                    answer.setText(a.toString());
                    break;
                case R.id.exp:
                    enter.setText(enter.getText() + "2.718281828459");
                    enter.setSelection(enter.getText().length());
                    break;

            }
        } catch (Exception e)
        {
            answer.setText("Error");
        }

    }

    private int factorial(String number)
    {
        String result = null;
        if ((number != null) && (number.length() > 0))
        {
            result = number.substring(0, number.length() - 1);
        }
        Integer f = Integer.parseInt(result);
        int answer = 1;
        for(int i=1;i<f;f--)
        {
            answer *= f;
        }
        return answer;
    }

    @Override
    public boolean onTouch(View v, MotionEvent event)
    {
        switch (event.getAction())
        {

            case MotionEvent.CLASSIFICATION_DEEP_PRESS:

                if(enter.getText().length() != 0)
                {
                    enter.setText(enter.getText().delete(enter.getText().length()-1,enter.getText().length()));
                    enter.setSelection(enter.getText().length());
                }

                break;
        }
        return false;
    }

    @Override
    public boolean onKeyLongPress(int keyCode, KeyEvent event) {
        return super.onKeyLongPress(keyCode, event);
    }

    //I took this method from the: https://stackoverflow.com/questions/3422673/how-to-evaluate-a-math-expression-given-in-string-form
    public static double eval(final String str)
    {

        return new Object() {
            int pos = -1, ch;

            void nextChar()
            {
                ch = (++pos < str.length()) ? str.charAt(pos) : -1;
            }

            boolean eat(int charToEat) {
                while (ch == ' ')
                    nextChar();
                if (ch == charToEat)
                {
                    nextChar();
                    return true;
                }
                return false;
            }

            double parse() {
                nextChar();
                double x = parseExpression();

                if (pos < str.length()) throw new RuntimeException("Unexpected: " + (char)ch);
                return x;
            }

            // Grammar:
            // expression = term | expression `+` term | expression `-` term
            // term = factor | term `*` factor | term `/` factor
            // factor = `+` factor | `-` factor | `(` expression `)`
            //        | number | functionName factor | factor `^` factor

            double parseExpression() {
                double x = parseTerm();
                for (;;) {
                    if      (eat('+'))
                        x += parseTerm(); // addition
                    else if (eat('-'))
                        x -= parseTerm(); // subtraction
                    else return x;
                }
            }

            double parseTerm() {
                double x = parseFactor();
                for (;;)
                {
                    if      (eat('*')) x *= parseFactor(); // multiplication
                    else if (eat('/')) x /= parseFactor(); // division
                    else if (eat('%')) x %= parseFactor();
                    else return x;
                }
            }

            double parseFactor() {
                if (eat('+'))
                    return parseFactor(); // unary plus
                if (eat('-'))
                    return -parseFactor(); // unary minus

                double x;
                int startPos = this.pos;
                if (eat('(')) { // parentheses
                    x = parseExpression();
                    eat(')');
                } else if ((ch >= '0' && ch <= '9') || ch == '.')
                { // numbers
                    while ((ch >= '0' && ch <= '9') || ch == '.')
                        nextChar();
                    x = Double.parseDouble(str.substring(startPos, this.pos));
                }
                else if (ch >= 'a' && ch <= 'z')
                { // functions
                    while (ch >= 'a' && ch <= 'z') nextChar();
                    String func = str.substring(startPos, this.pos);
                    x = parseFactor();
                    if (func.equals("sqrt"))
                        x = Math.sqrt(x);
                    else if (func.equals("sin"))
                        x = Math.sin(x);
                    else if(func.equals("asin"))
                        x = Math.asin(x);
                    else if (func.equals("cos"))
                        x = Math.cos(x);
                    else if (func.equals("acos"))
                        x = Math.acos(x);
                    else if (func.equals("tan"))
                        x = Math.tan(x);
                    else if (func.equals("atan"))
                        x = Math.atan(x);
                    else if (func.equals("ln"))
                        x = Math.log(x);
                    else throw new RuntimeException("Unknown function: " + func);
                } else {
                    throw new RuntimeException("Unexpected: " + (char)ch);
                }

                if (eat('^'))
                    x = Math.pow(x, parseFactor()); // exponentiation

                return x;
            }
        }.parse();
    }

}