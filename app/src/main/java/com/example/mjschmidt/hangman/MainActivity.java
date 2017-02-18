package com.example.mjschmidt.hangman;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.DataInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    boolean status = false;
    String s = "";
    Answer ans = new Answer(s);
    int count = 0;

    public class Answer {
        private String Word;

        public Answer(String Word) {
            this.Word = Word;
        }

        public String getWord() {
            return Word;
        }

        public void setWord(String s) {
            this.Word = s;
        }
    }

    public void initialize(ArrayList a) {
        final TextView WordView = (TextView) findViewById(R.id.WordView);
        WordView.setText("----------------");
        String word = new String();
        int rnd = new Random().nextInt(a.size());
        word = a.get(rnd).toString();
        String viewer = new String();
        viewer = word.replaceAll(".", "-");
        WordView.setText(viewer);
        ans.setWord(word);
    }

    public boolean manageOnOff(boolean b) {
        if (b == true) {
            b = false;
        }
        else {
            b = true;
        }
        return b;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button Start = (Button) findViewById(R.id.StartButton);
        Start.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                final TextView win = (TextView) findViewById(R.id.win);
                final TextView counter = (TextView) findViewById(R.id.counter);
                final ImageView image = (ImageView) findViewById(R.id.imageView3);
                image.setImageResource(R.drawable.hangman);
                count = 0;
                win.setText("");

                status = manageOnOff(status);
                if (status == true) {
                    Start.setText("Stop Game");
                    counter.setText("Tries: " + count);
                    Start.setBackgroundColor(getResources().getColor(android.R.color.holo_red_dark));
                    ArrayList<String> textIncoming = new ArrayList();
                    textIncoming.add("ELEPHANT");
                    textIncoming.add("GIRAFFE");
                    textIncoming.add("KANGAROO");
                    textIncoming.add("MOOSE");
                    textIncoming.add("LION");
                    InputStream is = getResources().openRawResource(R.raw.words);
                    DataInputStream dis = new DataInputStream(is);
                    String line;
                    try {
                        while ((line = dis.readLine())!=null) {
                            textIncoming.add(line.toUpperCase());
                        }
                    }
                    catch (Exception E) {

                    }
                    initialize(textIncoming);
                }
                else {
                    Start.setText("Start Game");
                    counter.setText("");
                    Start.setBackgroundColor(getResources().getColor(android.R.color.holo_green_light));
                    final TextView WordView = (TextView) findViewById(R.id.WordView);
                    WordView.setText("XXXXXXXXXXXXXXXX");
                }


            }
        });

        final Button Abutton = (Button) findViewById(R.id.Abutton);
        final Button Bbutton = (Button) findViewById(R.id.Bbutton);
        final Button Cbutton = (Button) findViewById(R.id.Cbutton);
        final Button Dbutton = (Button) findViewById(R.id.Dbutton);
        final Button Ebutton = (Button) findViewById(R.id.Ebutton);
        final Button Fbutton = (Button) findViewById(R.id.Fbutton);
        final Button Gbutton = (Button) findViewById(R.id.Gbutton);
        final Button Hbutton = (Button) findViewById(R.id.Hbutton);
        final Button Ibutton = (Button) findViewById(R.id.Ibutton);
        final Button Jbutton = (Button) findViewById(R.id.Jbutton);
        final Button Kbutton = (Button) findViewById(R.id.Kbutton);
        final Button Lbutton = (Button) findViewById(R.id.Lbutton);
        final Button Mbutton = (Button) findViewById(R.id.Mbutton);
        final Button Nbutton = (Button) findViewById(R.id.Nbutton);
        final Button Obutton = (Button) findViewById(R.id.Obutton);
        final Button Pbutton = (Button) findViewById(R.id.Pbutton);
        final Button Qbutton = (Button) findViewById(R.id.Qbutton);
        final Button Rbutton = (Button) findViewById(R.id.Rbutton);
        final Button Sbutton = (Button) findViewById(R.id.Sbutton);
        final Button Tbutton = (Button) findViewById(R.id.Tbutton);
        final Button Ubutton = (Button) findViewById(R.id.Ubutton);
        final Button Vbutton = (Button) findViewById(R.id.Vbutton);
        final Button Wbutton = (Button) findViewById(R.id.Wbutton);
        final Button Xbutton = (Button) findViewById(R.id.Xbutton);
        final Button Ybutton = (Button) findViewById(R.id.Ybutton);
        final Button Zbutton = (Button) findViewById(R.id.Zbutton);

        Abutton.setOnClickListener(onClickListener);
        Bbutton.setOnClickListener(onClickListener);
        Cbutton.setOnClickListener(onClickListener);
        Dbutton.setOnClickListener(onClickListener);
        Ebutton.setOnClickListener(onClickListener);
        Fbutton.setOnClickListener(onClickListener);
        Gbutton.setOnClickListener(onClickListener);
        Hbutton.setOnClickListener(onClickListener);
        Ibutton.setOnClickListener(onClickListener);
        Jbutton.setOnClickListener(onClickListener);
        Kbutton.setOnClickListener(onClickListener);
        Lbutton.setOnClickListener(onClickListener);
        Mbutton.setOnClickListener(onClickListener);
        Nbutton.setOnClickListener(onClickListener);
        Obutton.setOnClickListener(onClickListener);
        Pbutton.setOnClickListener(onClickListener);
        Qbutton.setOnClickListener(onClickListener);
        Rbutton.setOnClickListener(onClickListener);
        Sbutton.setOnClickListener(onClickListener);
        Tbutton.setOnClickListener(onClickListener);
        Ubutton.setOnClickListener(onClickListener);
        Vbutton.setOnClickListener(onClickListener);
        Wbutton.setOnClickListener(onClickListener);
        Xbutton.setOnClickListener(onClickListener);
        Ybutton.setOnClickListener(onClickListener);
        Zbutton.setOnClickListener(onClickListener);
}
    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            final TextView WordView = (TextView) findViewById(R.id.WordView);
            final TextView win = (TextView) findViewById(R.id.win);
            String receivedAnswer = ans.getWord();
            char btnLtr = 'x';
            if (status == true) {
                switch(v.getId()){
                    case R.id.Abutton:
                        btnLtr = 'A';
                        break;
                    case R.id.Bbutton:
                        btnLtr = 'B';
                        break;
                    case R.id.Cbutton:
                        btnLtr = 'C';
                        break;
                    case R.id.Dbutton:
                        btnLtr = 'D';
                        break;
                    case R.id.Ebutton:
                        btnLtr = 'E';
                        break;
                    case R.id.Fbutton:
                        btnLtr = 'F';
                        break;
                    case R.id.Gbutton:
                        btnLtr = 'G';
                        break;
                    case R.id.Hbutton:
                        btnLtr = 'H';
                        break;
                    case R.id.Ibutton:
                        btnLtr = 'I';
                        break;
                    case R.id.Jbutton:
                        btnLtr = 'J';
                        break;
                    case R.id.Kbutton:
                        btnLtr = 'K';
                        break;
                    case R.id.Lbutton:
                        btnLtr = 'L';
                        break;
                    case R.id.Mbutton:
                        btnLtr = 'M';
                        break;
                    case R.id.Nbutton:
                        btnLtr = 'N';
                        break;
                    case R.id.Obutton:
                        btnLtr = 'O';
                        break;
                    case R.id.Pbutton:
                        btnLtr = 'P';
                        break;
                    case R.id.Qbutton:
                        btnLtr = 'Q';
                        break;
                    case R.id.Rbutton:
                        btnLtr = 'R';
                        break;
                    case R.id.Sbutton:
                        btnLtr = 'S';
                        break;
                    case R.id.Tbutton:
                        btnLtr = 'T';
                        break;
                    case R.id.Ubutton:
                        btnLtr = 'U';
                        break;
                    case R.id.Vbutton:
                        btnLtr = 'V';
                        break;
                    case R.id.Wbutton:
                        btnLtr = 'W';
                        break;
                    case R.id.Xbutton:
                        btnLtr = 'X';
                        break;
                    case R.id.Ybutton:
                        btnLtr = 'Y';
                        break;
                    case R.id.Zbutton:
                        btnLtr = 'Z';
                        break;
                }
                for (int i = 0; i < receivedAnswer.length(); i++) {
                    String cnvrsn = String.valueOf(btnLtr).toLowerCase();
                    char result = cnvrsn.charAt(0);
                    if (receivedAnswer.charAt(i) == btnLtr) {
                        StringBuilder str = new StringBuilder(WordView.getText().toString());
                        str.setCharAt(i,btnLtr);
                        WordView.setText(str);
                    }
                    else if (receivedAnswer.charAt(i) == result) {
                        StringBuilder str = new StringBuilder(WordView.getText().toString());
                        str.setCharAt(i,result);
                        WordView.setText(str);
                    }
                }
                final TextView counter = (TextView) findViewById(R.id.counter);
                if (!WordView.getText().toString().contains("-")) {
                    win.setText("You win!");
                    final ImageView image = (ImageView) findViewById(R.id.imageView3);
                    image.setImageResource(R.drawable.youwin);
                    counter.setText("Tries: " + (count + 1));
                }
                else {
                    count++;
                    counter.setText("Tries: " + count);
                }

            }
            else {}

        }
    };
}
