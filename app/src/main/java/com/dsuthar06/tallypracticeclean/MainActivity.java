package com.dsuthar06.tallypracticeclean;

import android.app.Activity;
import android.os.Bundle;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.Gravity;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    private int dp(float value) {
        return (int) (value * getResources().getDisplayMetrics().density + 0.5f);
    }

    private TextView text(String value, float size, int color, boolean bold) {
        TextView tv = new TextView(this);
        tv.setText(value);
        tv.setTextSize(size);
        tv.setTextColor(color);
        tv.setGravity(Gravity.CENTER_VERTICAL);
        tv.setTypeface(
                Typeface.DEFAULT,
                bold ? Typeface.BOLD : Typeface.NORMAL
        );
        return tv;
    }

    private Button menuButton(String title) {
        Button button = new Button(this);
        button.setText(title);
        button.setTextSize(16);
        button.setAllCaps(false);

        LinearLayout.LayoutParams params =
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        dp(56)
                );

        params.setMargins(0, dp(8), 0, dp(8));
        button.setLayoutParams(params);

        return button;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout root = new LinearLayout(this);
        root.setOrientation(LinearLayout.VERTICAL);
        root.setPadding(
                dp(20),
                dp(20),
                dp(20),
                dp(20)
        );
        root.setBackgroundColor(Color.WHITE);

        TextView title = text(
                "Tally Practice",
                28,
                Color.rgb(21, 101, 192),
                true
        );

        title.setGravity(Gravity.CENTER);

        root.addView(
                title,
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        dp(70)
                )
        );

        TextView subtitle = text(
                "Practice Groups, Ledgers and Accounting Basics",
                16,
                Color.DKGRAY,
                false
        );

        subtitle.setGravity(Gravity.CENTER);

        root.addView(
                subtitle,
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        dp(55)
                )
        );

        Button groups = menuButton("Groups & Subgroups");

        groups.setOnClickListener(v ->
                Toast.makeText(
                        this,
                        "Groups & Subgroups section",
                        Toast.LENGTH_SHORT
                ).show()
        );

        root.addView(groups);

        Button ledgers = menuButton("Ledgers");

        ledgers.setOnClickListener(v ->
                Toast.makeText(
                        this,
                        "Ledgers section",
                        Toast.LENGTH_SHORT
                ).show()
        );

        root.addView(ledgers);

        Button mcq = menuButton("MCQ Practice");

        mcq.setOnClickListener(v ->
                Toast.makeText(
                        this,
                        "MCQ Practice section",
                        Toast.LENGTH_SHORT
                ).show()
        );

        root.addView(mcq);

        TextView status = text(
                "Version 1.0 • Clean build starter",
                13,
                Color.GRAY,
                false
        );

        status.setGravity(Gravity.CENTER);

        LinearLayout.LayoutParams statusParams =
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        dp(50)
                );

        statusParams.topMargin = dp(20);

        root.addView(status, statusParams);

        setContentView(root);
    }
}
