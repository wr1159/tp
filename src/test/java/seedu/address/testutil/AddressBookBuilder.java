package seedu.address.testutil;

import seedu.address.model.AddressBook;
import seedu.address.model.event.Event;
import seedu.address.model.member.Member;

/**
 * A utility class to help with building Addressbook objects.
 * Example usage: <br>
 *     {@code AddressBook ab = new AddressBookBuilder().withMember("John", "Doe").build();}
 */
public class AddressBookBuilder {

    private AddressBook addressBook;

    public AddressBookBuilder() {
        addressBook = new AddressBook();
    }

    public AddressBookBuilder(AddressBook addressBook) {
        this.addressBook = addressBook;
    }

    /**
     * Adds a new {@code Member} to the {@code AddressBook} that we are building.
     */
    public AddressBookBuilder withMember(Member member) {
        addressBook.createMember(member);
        return this;
    }

    /**
     * Adds a new {@code Event} to the {@code AddressBook} that we are building.
     */
    public AddressBookBuilder withEvent(Event event) {
        addressBook.createEvent(event);
        return this;
    }

    public AddressBook build() {
        return addressBook;
    }
}
