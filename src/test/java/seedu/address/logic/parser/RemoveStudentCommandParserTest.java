package seedu.address.logic.parser;


import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.commands.StudentTestUtil.ID_DESC_AARON;
import static seedu.address.logic.commands.StudentTestUtil.VALID_STUDENT_ID_AARON;
import static seedu.address.logic.commands.StudentTestUtil.VALID_TUTORIAL_NAME_AARON_DESC;
import static seedu.address.logic.commands.TutorialTestUtil.VALID_TUTORIAL_NAME_TG1;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseSuccess;

import org.junit.jupiter.api.Test;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.RemoveStudentCommand;
import seedu.address.model.person.NusNetId;
import seedu.address.model.tutorial.TutorialName;

public class RemoveStudentCommandParserTest {

    private RemoveStudentCommandParser parser = new RemoveStudentCommandParser();

    @Test
    public void parse_allFieldsPresent_success() {
        NusNetId id = new NusNetId(VALID_STUDENT_ID_AARON);
        TutorialName tutorialName = new TutorialName(VALID_TUTORIAL_NAME_TG1);
        Index index = Index.fromOneBased(1);

        assertParseSuccess(parser, ID_DESC_AARON + VALID_TUTORIAL_NAME_AARON_DESC,
                new RemoveStudentCommand(id, tutorialName));

        assertParseSuccess(parser, " 1" + VALID_TUTORIAL_NAME_AARON_DESC,
                new RemoveStudentCommand(index, tutorialName));
    }

    @Test
    public void parse_compulsoryFieldMissing_failure() {
        assertParseFailure(parser, ID_DESC_AARON, String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                RemoveStudentCommand.MESSAGE_USAGE));

        assertParseFailure(parser, VALID_TUTORIAL_NAME_AARON_DESC, String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                RemoveStudentCommand.MESSAGE_USAGE));

        assertParseFailure(parser, " 1" , String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                RemoveStudentCommand.MESSAGE_USAGE));

    }

    @Test
    public void parse_nonEmptyPreamble_failure() {
        assertParseFailure(parser, " 1" + ID_DESC_AARON, String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                RemoveStudentCommand.MESSAGE_USAGE));
    }


}
