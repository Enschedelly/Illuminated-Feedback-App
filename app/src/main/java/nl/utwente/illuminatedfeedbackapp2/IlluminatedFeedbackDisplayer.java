package nl.utwente.illuminatedfeedbackapp2;

import android.view.View;

public abstract class IlluminatedFeedbackDisplayer {

    private View feedbackView;

    public IlluminatedFeedbackDisplayer(View feedbackView) {
        this.feedbackView = feedbackView;
    }

    public void display(int bpm) {
        int color = getColor(bpm);
        feedbackView.setBackgroundColor(color);
    }

    public abstract int getColor(int bpm);
}
