package com.example.calculator;


import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.app.Activity;



public class MainActivity extends Activity implements View.OnClickListener, View.OnTouchListener{



    EditText enter, answer;
    Button one, two, three, four, five, six, seven, eight, nine, zero;
    Button point, clear, bracket1, bracket2;
    Button sin, asin, cos, acos, tan, atan;
    Button sqrt, yX;
    Button plus, equal, minus, split, multiply, split_rev;
    Button bin,oct,hex;
    Button pi, ln, factorial, e;
    Button history_b;

    DBHelper dbHelper;
    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Window window = getWindow();
        window.setStatusBarColor(Color.rgb(0,0,0));

        dbHelper = new DBHelper(this);
        db = dbHelper.getWritableDatabase();

        enter =  findViewById(R.id.enter);
        answer = findViewById(R.id.answer);

        one =    findViewById(R.id.one);
        two =    findViewById(R.id.two);
        three =  findViewById(R.id.three);
        four =   findViewById(R.id.four);
        five =   findViewById(R.id.five);
        six =    findViewById(R.id.six);
        seven =  findViewById(R.id.seven);
        eight =  findViewById(R.id.eight);
        nine =   findViewById(R.id.nine);
        zero =   findViewById(R.id.zero);
        point =  findViewById(R.id.point);
        clear =  findViewById(R.id.clear);
        bracket1 = findViewById(R.id.bracket1);
        bracket2 = findViewById(R.id.bracket2);

        plus =   findViewById(R.id.plus);
        minus =  findViewById(R.id.minus);
        equal =  findViewById(R.id.equal);
        split =  findViewById(R.id.split);
        pi =     findViewById(R.id.pi);
        split_rev = findViewById(R.id.split_revision);
        multiply =  findViewById(R.id.multiply);
        String s = new String(Character.toChars(120529));
        pi.setTextSize(20);
        pi.setText(s);
        history_b = findViewById(R.id.history_b);
        factorial = findViewById(R.id.factorial);
        ln =     findViewById(R.id.ln);
        e =      findViewById(R.id.exp);


        sqrt =   findViewById(R.id.sqrt);
        yX =     findViewById(R.id.yX);

        sin =    findViewById(R.id.sin);
        asin =   findViewById(R.id.asin);
        cos =    findViewById(R.id.cos);
        acos =   findViewById(R.id.acos);
        tan =    findViewById(R.id.tan);
        atan =   findViewById(R.id.atan);

        bin =    findViewById(R.id.bin);
        oct =    findViewById(R.id.oct);
        hex =    findViewById(R.id.hex);

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
        history_b.setOnClickListener(this);
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

        switch(v.getId())
        {
            case R.id.one:
                set_text("1");
                break;
            case R.id.two:
                set_text("2");
                break;
            case R.id.three:
                set_text("3");
                break;
            case R.id.four:
                set_text("4");
                break;
            case R.id.five:
                set_text("5");
                break;
            case R.id.six:
                set_text("6");
                break;
            case R.id.seven:
                set_text("7");
                break;
            case R.id.eight:
                set_text("8");
                break;
            case R.id.nine:
                set_text("9");
                break;
            case R.id.zero:
                set_text("0");
                break;
            case R.id.point:
                set_text(".");
                break;
            case  R.id.bracket1:
                set_text("(");
                break;
            case R.id.bracket2:
                set_text(")");
                break;
            case R.id.plus:
                set_text("+");
                break;
            case R.id.sin:
                set_text("sin(");
                break;
            case R.id.asin:
                set_text("asin(");
                break;
            case R.id.cos:
                set_text("cos(");
                break;
            case R.id.acos:
                set_text("acos(");
                break;
            case R.id.tan:
                set_text("tan(");
                break;
            case R.id.atan:
                set_text("atan(");
                break;
            case R.id.sqrt:
                set_text("sqrt(");
                break;
            case R.id.yX:
                set_text("^");
                break;
            case R.id.minus:
                set_text("-");
                break;
            case R.id.split:
                set_text("/");
                break;
            case R.id.split_revision:
                set_text("%");
                break;
            case R.id.multiply:
                set_text("*");
                break;
            case R.id.equal:
                try{
                    Double answ = eval(enter.getText().toString());
                    answer.setText(Double.toString(answ));
                    save_history(answ);

                }catch (Exception e)
                {
                    answer.setText("Error");
                }
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
                set_text("3.141592653589");
                break;
            case R.id.ln:
                set_text("ln(");
                break;
            case R.id.factorial:
                enter.setText(enter.getText() + "!");
                enter.setSelection(enter.getText().length());

                Integer a = factorial(enter.getText().toString());
                answer.setText(a.toString());
                break;
            case R.id.exp:
                set_text("2.718281828459");
                break;
            case R.id.history_b:
                load_history();
                break;

        }

    }
    private void load_history()
    {
        Cursor cursor = db.query(DBHelper.TABLE_NAME, null, null, null, null, null, null);
        int i = 0;
        if(cursor.moveToFirst())
        {
            int id_index = cursor.getColumnIndex(DBHelper.KEY_ID);
            int number_index = cursor.getColumnIndex(DBHelper.KEY_NUMBER);

            do{
                i++;
                Log.d("Debug","ID = " + cursor.getInt(id_index) + " Number = " + cursor.getDouble(number_index) + "   " + i);
                if(i > 10)
                {
                    //If rows > 10  (do it)
                    //db.delete(DBHelper.TABLE_NAME,DBHelper.KEY_ID + "=" + cursor.getInt(id_index),null);
                    db.delete(DBHelper.TABLE_NAME,null,null);
                }
            }while (cursor.moveToNext());
        }
        else {Log.d("Debug","Error");}
        cursor.close();
    }

    private void save_history(Double d)
    {
        String answer = Double.toString(d);
        ContentValues contentValues = new ContentValues();
        contentValues.put(DBHelper.KEY_NUMBER,answer);
        db.insert(DBHelper.TABLE_NAME,null, contentValues);

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

    public void set_text(String s)
    {
        int selection_pos = enter.getSelectionStart();
        StringBuffer buf = new StringBuffer(enter.getText().toString());
        buf.insert(enter.getSelectionStart(),s);
        enter.setText(buf.toString());
        enter.setSelection(selection_pos + s.length());
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