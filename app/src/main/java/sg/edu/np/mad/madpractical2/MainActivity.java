package sg.edu.np.mad.madpractical2;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.EventListener;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Initialise a new User object
        User user = new User("John Doe", "MAD Developer", 1, false);

        // Get the TextViews and Button from the layout
        TextView tvName = findViewById(R.id.tvName);
        TextView tvDescription = findViewById(R.id.tvDescription);
        Button btnFollow = findViewById(R.id.btnFollow);
        btnFollow.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                user.followed = !user.followed;

                Button btn = (Button)v;
                if (user.followed) {
                    btn.setText("Unfollow");
                } else btn.setText("Follow");



            }

        });

        // Set the TextViews with the User's name, description and default button message
        tvName.setText(user.name);
        tvDescription.setText(user.description);
        btnFollow.setText("Follow");


    }

//    class btnFollowHandler implements Button.OnClickListener {
//        public void onClick(View v) {
//            Button btn = (Button)v;
//            if (btn.getText() == "Follow") {
//                btn.setText("Unfollow");
//            } else btn.setText("Follow");
//
//        }
//    }
}