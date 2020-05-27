package nl.utwente.illuminatedfeedbackapp2;

import android.view.View;

public class GroupFeedbackDisplayer extends IlluminatedFeedbackDisplayer {

    public GroupFeedbackDisplayer(View feedbackView) {
        super(feedbackView);
    }

    @Override
    public int getColor(int bpm) {
        return 0;
    }
}
