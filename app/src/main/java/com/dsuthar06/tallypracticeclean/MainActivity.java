package com.dsuthar06.tallypracticeclean;

import android.app.Activity;
import android.os.Bundle;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    LinearLayout root;
    int blue = Color.rgb(30, 90, 180);
    int dark = Color.rgb(35, 35, 35);
    int lightGray = Color.rgb(235, 235, 235);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        showHome();
    }

    private TextView title(String text, int size) {
        TextView tv = new TextView(this);
        tv.setText(text);
        tv.setTextSize(size);
        tv.setTextColor(dark);
        tv.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        tv.setGravity(Gravity.CENTER);
        tv.setPadding(20, 20, 20, 20);
        return tv;
    }

    private Button menuButton(String text) {
        Button b = new Button(this);
        b.setText(text);
        b.setTextSize(18);
        b.setAllCaps(false);
        b.setTextColor(dark);
        b.setBackgroundColor(lightGray);

        LinearLayout.LayoutParams p =
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        70
                );

        p.setMargins(25, 12, 25, 12);
        b.setLayoutParams(p);

        return b;
    }

    private void setupRoot() {
        root = new LinearLayout(this);
        root.setOrientation(LinearLayout.VERTICAL);
        root.setBackgroundColor(Color.WHITE);
        root.setPadding(20, 20, 20, 20);

        setContentView(root);
    }

    // ----------------------------------------------------
    // HOME
    // ----------------------------------------------------

    private void showHome() {

        setupRoot();

        TextView heading = title("Tally Practice", 32);
        heading.setTextColor(blue);
        root.addView(heading);

        TextView subtitle =
                title("Practice Groups, Ledgers and\nAccounting Basics", 20);

        root.addView(subtitle);

        Button groups = menuButton("Groups & Subgroups");
        Button ledgers = menuButton("Ledgers");
        Button mcq = menuButton("MCQ Practice");

        root.addView(groups);
        root.addView(ledgers);
        root.addView(mcq);

        TextView version =
                title("\nVersion 1.0 • Tally Practice", 16);

        version.setTextColor(Color.GRAY);
        root.addView(version);

        groups.setOnClickListener(v -> showGroups());
        ledgers.setOnClickListener(v -> showLedgers());
        mcq.setOnClickListener(v -> showMCQ());
    }

    // ----------------------------------------------------
    // GROUPS & SUBGROUPS
    // ----------------------------------------------------

    private void showGroups() {

        setupRoot();

        Button back = menuButton("← Back");
        root.addView(back);

        TextView heading = title("Groups & Subgroups", 27);
        heading.setTextColor(blue);
        root.addView(heading);

        addText("PRIMARY GROUPS", 22, true);

        addText("Capital Account", 18, true);
        addText("• Reserves & Surplus", 16, false);

        addText("Loans (Liability)", 18, true);
        addText("• Secured Loans", 16, false);
        addText("• Unsecured Loans", 16, false);
        addText("• Loans & Advances", 16, false);

        addText("Current Liabilities", 18, true);
        addText("• Sundry Creditors", 16, false);
        addText("• Duties & Taxes", 16, false);
        addText("• Provisions", 16, false);

        addText("Fixed Assets", 18, true);
        addText("• Land & Buildings", 16, false);
        addText("• Plant & Machinery", 16, false);
        addText("• Furniture & Fixtures", 16, false);

        addText("Current Assets", 18, true);
        addText("• Bank Accounts", 16, false);
        addText("• Cash-in-Hand", 16, false);
        addText("• Sundry Debtors", 16, false);
        addText("• Stock-in-Hand", 16, false);

        addText("Direct Expenses", 18, true);
        addText("• Purchases", 16, false);
        addText("• Manufacturing Expenses", 16, false);

        addText("Indirect Expenses", 18, true);
        addText("• Office Expenses", 16, false);
        addText("• Administrative Expenses", 16, false);
        addText("• Selling & Distribution Expenses", 16, false);

        addText("Direct Incomes", 18, true);
        addText("• Sales", 16, false);

        addText("Indirect Incomes", 18, true);
        addText("• Commission Received", 16, false);
        addText("• Interest Received", 16, false);

        addText("Investments", 18, true);
        addText("Loans & Advances (Asset)", 18, true);

        back.setOnClickListener(v -> showHome());
    }

    // ----------------------------------------------------
    // LEDGERS
    // ----------------------------------------------------

    private void showLedgers() {

        setupRoot();

        Button back = menuButton("← Back");
        root.addView(back);

        TextView heading = title("Ledgers", 28);
        heading.setTextColor(blue);
        root.addView(heading);

        addText(
                "A Ledger is an account created under an appropriate group.",
                17,
                false
        );

        addText("Examples", 22, true);

        addText("Cash A/c", 18, true);
        addText("Group: Cash-in-Hand", 16, false);

        addText("SBI Bank A/c", 18, true);
        addText("Group: Bank Accounts", 16, false);

        addText("Rahul Traders", 18, true);
        addText("Group: Sundry Creditors", 16, false);

        addText("ABC Customer", 18, true);
        addText("Group: Sundry Debtors", 16, false);

        addText("Furniture A/c", 18, true);
        addText("Group: Furniture & Fixtures", 16, false);

        addText("Salary A/c", 18, true);
        addText("Group: Indirect Expenses", 16, false);

        addText("Sales A/c", 18, true);
        addText("Group: Sales Accounts", 16, false);

        addText("Purchase A/c", 18, true);
        addText("Group: Purchase Accounts", 16, false);

        back.setOnClickListener(v -> showHome());
    }

    // ----------------------------------------------------
    // MCQ
    // ----------------------------------------------------

    private int questionNumber = 0;
    private int score = 0;

    private String[] questions = {
            "Cash A/c belongs to which group?",
            "Sundry Debtors are classified under which group?",
            "Salary A/c normally belongs to which group?",
            "Furniture A/c belongs to which group?",
            "SBI Bank A/c belongs to which group?"
    };

    private String[][] options = {
            {"Cash-in-Hand", "Capital Account", "Sales", "Loans"},
            {"Current Assets", "Current Liabilities", "Capital Account", "Direct Income"},
            {"Indirect Expenses", "Fixed Assets", "Loans", "Sales"},
            {"Fixed Assets", "Current Liabilities", "Direct Income", "Capital"},
            {"Bank Accounts", "Cash-in-Hand", "Sundry Creditors", "Sales"}
    };

    private int[] answers = {0, 0, 0, 0, 0};

    private void showMCQ() {

        setupRoot();

        questionNumber = 0;
        score = 0;

        showQuestion();
    }

    private void showQuestion() {

        root.removeAllViews();

        Button back = menuButton("← Back");
        root.addView(back);

        TextView heading = title("MCQ Practice", 28);
        heading.setTextColor(blue);
        root.addView(heading);

        if (questionNumber >= questions.length) {
            showResult();
            return;
        }

        TextView counter =
                title(
                        "Question " +
                                (questionNumber + 1) +
                                " / " +
                                questions.length,
                        18
                );

        root.addView(counter);

        TextView question =
                title(questions[questionNumber], 21);

        question.setGravity(Gravity.LEFT);
        question.setPadding(15, 30, 15, 30);

        root.addView(question);

        for (int i = 0; i < 4; i++) {

            final int selected = i;

            Button option =
                    menuButton(
                            (char) ('A' + i) +
                                    ". " +
                                    options[questionNumber][i]
                    );

            root.addView(option);

            option.setOnClickListener(v -> {

                if (selected == answers[questionNumber]) {
                    score++;

                    Toast.makeText(
                            this,
                            "Correct!",
                            Toast.LENGTH_SHORT
                    ).show();

                } else {

                    Toast.makeText(
                            this,
                            "Wrong answer",
                            Toast.LENGTH_SHORT
                    ).show();
                }

                questionNumber++;
                showQuestion();
            });
        }

        back.setOnClickListener(v -> showHome());
    }

    private void showResult() {

        root.removeAllViews();

        TextView heading =
                title("MCQ Result", 30);

        heading.setTextColor(blue);
        root.addView(heading);

        TextView result =
                title(
                        "Your Score\n\n" +
                                score +
                                " / " +
                                questions.length,
                        25
                );

        root.addView(result);

        Button again =
                menuButton("Practice Again");

        Button home =
                menuButton("← Home");

        root.addView(again);
        root.addView(home);

        again.setOnClickListener(v -> showMCQ());
        home.setOnClickListener(v -> showHome());
    }

    // ----------------------------------------------------
    // TEXT HELPER
    // ----------------------------------------------------

    private void addText(
            String text,
            int size,
            boolean bold
    ) {

        TextView tv = new TextView(this);

        tv.setText(text);
        tv.setTextSize(size);
        tv.setTextColor(dark);
        tv.setPadding(15, 8, 15, 8);

        if (bold) {
            tv.setTypeface(
                    Typeface.DEFAULT,
                    Typeface.BOLD
            );
        }

        root.addView(tv);
    }

    @Override
    public void onBackPressed() {

        showHome();
    }
}
