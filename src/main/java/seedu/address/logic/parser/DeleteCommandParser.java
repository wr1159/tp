package seedu.address.logic.parser;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.DeleteCommand;
import seedu.address.logic.commands.DeleteEventCommand;
import seedu.address.logic.commands.DeletePersonCommand;
import seedu.address.logic.parser.exceptions.ParseException;

/**
 * Parses input arguments and creates a new DeleteCommand object
 */
public class DeleteCommandParser implements Parser<DeleteCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the DeleteCommand
     * and returns a DeleteCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public DeleteCommand parse(String args) throws ParseException {
        try {
            Index index;
            String classSpecifierString, indexString;
            // Splits the argument into the class specifier (member/event) and index
            String[] argArray = args.split(" ");
            classSpecifierString = argArray[0];
            indexString = argArray[1];
            index = ParserUtil.parseIndex(indexString);

            if (classSpecifierString.equals("/person")) {
                return new DeletePersonCommand(index);
            } else if (classSpecifierString.equals("/event")) {
                return new DeleteEventCommand(index);
            } else {
                return null;
            }
        } catch (ParseException pe) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, DeleteCommand.MESSAGE_USAGE), pe);
        }
    }
}
