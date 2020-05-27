package nl.utwente.illuminatedfeedbackapp2;

import android.graphics.Color;
import android.view.View;

public class BlankFeedbackDisplayer extends IlluminatedFeedbackDisplayer {

    public BlankFeedbackDisplayer(View feedbackView) {
        super(feedbackView);
    }

    @Override
    public int getColor(int bpm) {
        return Color.parseColor("#ffe0a6");
    }
}
