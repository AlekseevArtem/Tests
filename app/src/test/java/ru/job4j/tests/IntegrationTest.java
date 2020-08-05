package ru.job4j.tests;

import android.os.Build;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(RobolectricTestRunner.class)
public class IntegrationTest {
    private MainActivity activity;
    @Before
    public void before() {
        activity = Robolectric.buildActivity(MainActivity.class).setup().get();
    }

    @Test
    @Config(sdk = {Build.VERSION_CODES.P})
    public void checkButtonCantBeEnabled() {
        Button check = activity.findViewById(R.id.check);
        check.setEnabled(false);
        check.performClick();
        TextView label = activity.findViewById(R.id.status);
        String status = label.getText().toString();
        assertThat(status).isEqualTo(activity.getResources().getString(R.string.validation_error));
    }

    @Test
    @Config(sdk = {Build.VERSION_CODES.P})
    public void checkStatus() {
        TextView label = activity.findViewById(R.id.status);
        String status = label.getText().toString();
        assertThat(status).isEqualTo("...");
    }

    @Test
    @Config(sdk = {Build.VERSION_CODES.P})
    public void checkStatusError() {
        activity.findViewById(R.id.check).performClick();
        TextView label = activity.findViewById(R.id.status);
        String status = label.getText().toString();
        assertThat(status).isEqualTo(activity.getResources().getString(R.string.validation_error));
    }

    @Test
    @Config(sdk = {Build.VERSION_CODES.P})
    public void checkStatusSuccess() {
        EditText email = activity.findViewById(R.id.email);
        email.setText("test@test.com");
        activity.findViewById(R.id.check).performClick();
        TextView label = activity.findViewById(R.id.status);
        String status = label.getText().toString();
        assertThat(status).isEqualTo(activity.getResources().getString(R.string.success));
    }
}
