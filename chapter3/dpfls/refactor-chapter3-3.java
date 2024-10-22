public String getFirstName(String mobileNumber) {
    Person person;

    person = contactService.getPerson(mobileNumber);
    if (StringUtil.isBlank(person.firstName)) {
        return getFirstNameFromAddress(mobileNumber);
    }
    return person.firstName;
}

private String getFirstNameFromAddress(String mobileNumber) {
    Json address;
    Person personDetail;

    address = addressService.getAddress(mobileNumber);
    personDetail = address.getPersonDetails();
    return personDetail.firstName;
}