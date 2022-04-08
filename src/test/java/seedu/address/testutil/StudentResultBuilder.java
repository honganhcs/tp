package seedu.address.testutil;

import seedu.address.model.assessment.FullMark;
import seedu.address.model.assessment.Score;
import seedu.address.model.assessment.StudentResult;
import seedu.address.model.person.NusNetId;

public class StudentResultBuilder {
    public static final String DEFAULT_NUSNETID = "e0123456";
    public static final String DEFAULT_SCORE = "9";

    private FullMark fullMark = new FullMark("1000");
    private NusNetId nusNetId;
    private Score score;

    /**
     * Creates a {@code StudentResultBuilder} with the default details.
     */
    public StudentResultBuilder() {
        nusNetId = new NusNetId(DEFAULT_NUSNETID);
        score = new Score(DEFAULT_SCORE, fullMark);
    }

    /**
     * Initializes the StudentResultBuilder with the data of {@code studentResultToCopy}.
     */
    public StudentResultBuilder(StudentResult studentResultToCopy) {
        nusNetId = studentResultToCopy.getStudentId();
        score = studentResultToCopy.getScore();
    }

    /**
     * Sets the {@code NusNetId} of the {@code StudentResult} that we are building.
     */
    public StudentResultBuilder withNusNetId(String nusNetId) {
        this.nusNetId = new NusNetId(nusNetId);
        return this;
    }

    /**
     * Sets the {@code Score} of the {@code StudentResult} that we are building.
     */
    public StudentResultBuilder withScore(String score) {
        this.score = new Score(score, fullMark);
        return this;
    }

    public StudentResult build() {
        return new StudentResult(nusNetId, score);
    }
}
