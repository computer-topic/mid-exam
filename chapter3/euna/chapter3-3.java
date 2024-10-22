public String getName(String mobileNumber) {
  Person person = contactService.getPerson(mobileNumber);
  if (StringUtil.isBlank(person.firstName)) {
    Json address = addressService.getAddress(mobileNumber);
    Person personDetail = address.getPersonDetails();
    return personDetail.firstName;
  }
  return person.firstName;
}