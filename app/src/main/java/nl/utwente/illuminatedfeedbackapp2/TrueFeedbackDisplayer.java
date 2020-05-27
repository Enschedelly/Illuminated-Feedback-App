package nl.utwente.illuminatedfeedbackapp2;

import android.graphics.Color;
import android.view.View;

public class TrueFeedbackDisplayer extends IlluminatedFeedbackDisplayer {

    public TrueFeedbackDisplayer(View feedbackView) {
        super(feedbackView);
    }

    @Override
    public int getColor(int bpm) {
        int color;
        if (bpm < 58) {
            // Set color to light blue
            color = Color.parseColor("#a6dbe3");
        } else if (bpm < 68) {
            // Set color to blue
            color = Color.parseColor("#71abdb");
        } else if (bpm < 78) {
            // Set color to pink
            color = Color.parseColor("#d190bf");
        } else if (bpm < 88) {
            // Set color to red
            color = Color.parseColor("#d190bf");
        } else {
            // Set color to yellow
            color = Color.parseColor("#fed181");
        }
        return color;
    }
}
