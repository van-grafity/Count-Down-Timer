package com.ivan.countdowntimer;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.tv_otp_count)
    TextView tvCountDown;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        onResend();
    }

    private CountDownTimer countDownTimer = new CountDownTimer(25000, 1000) {
        @Override
        public void onTick(long millisUntilFinished) {
            tvCountDown.setEnabled(false);
            String countDowrnText = "(" + millisUntilFinished / 1000 + ")";
            tvCountDown.setText(countDowrnText);
        }

        @Override
        public void onFinish() {
            tvCountDown.setText("");
            tvCountDown.setEnabled(true);
            tvCountDown.setText(getString(R.string.resend_code));
        }
    };

    @OnClick(R.id.tv_otp_count)
    void onResend() {
        tvCountDown.setText(getText(R.string.resend_code));
        countDownTimer.start();
    }


}
