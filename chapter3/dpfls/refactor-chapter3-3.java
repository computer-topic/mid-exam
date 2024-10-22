public String getName(String mobileNumber) {
    Person person = contactService.getPerson(mobileNumber);

    if (StringUtil.isBlank(person.firstName)) {
        return getFirstNameFromAddress();
    }
    return person.firstName;
}

private String getFirstNameFromAddress() {
    Json address = addressService.getAddress(mobileNumber);
    Person personDetail = address.getPersonDetails();
    return personDetail.firstName;
}