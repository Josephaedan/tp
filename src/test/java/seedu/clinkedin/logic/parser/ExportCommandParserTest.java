package seedu.clinkedin.logic.parser;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static seedu.clinkedin.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.clinkedin.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.clinkedin.logic.parser.CommandParserTestUtil.assertParseSuccess;

import org.junit.jupiter.api.Test;

import seedu.clinkedin.logic.commands.ExportCommand;


public class ExportCommandParserTest {

    private final ExportCommandParser parser = new ExportCommandParser();

    @Test
    public void parse_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> parser.parse(null));
    }

    @Test
    public void emptyString_returnNewExportCommand() {
        assertParseSuccess(parser, "", new ExportCommand());
    }

    @Test
    public void parse_invalidArgs_throwsParseException() {
        // no filetype
        assertParseFailure(parser, "path//Desktop/",
                String.format(MESSAGE_INVALID_COMMAND_FORMAT, ExportCommand.MESSAGE_USAGE));

        // no prefix
        assertParseFailure(parser, "1 Test", String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                ExportCommand.MESSAGE_USAGE));

        // no file path
        assertParseFailure(parser, "path/", String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                ExportCommand.MESSAGE_USAGE));

        // file name begins with period
        assertParseFailure(parser, "path//Desktop/.", String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                ExportCommand.MESSAGE_USAGE));

    }


}
