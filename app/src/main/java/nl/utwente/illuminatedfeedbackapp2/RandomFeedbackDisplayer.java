package nl.utwente.illuminatedfeedbackapp2;

import android.view.View;

public class RandomFeedbackDisplayer extends IlluminatedFeedbackDisplayer {

    public RandomFeedbackDisplayer(View feedbackView) {
        super(feedbackView);
    }

    @Override
    public int getColor(int bpm) {
        return 0;
    }
}
