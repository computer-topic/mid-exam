public String getFirstName(String mobileNumber) {
  Person person = contactService.getPerson(mobileNumber);
  boolean isFirstNameBlank = StringUtil.isBlank(person.firstName);
  
  if(isFirstNameBlank) {
    String personFirstName = getPersonFirstNameFromAddress(mobileNumber);
    return personFirstName;
  }
  return person.firstName;
}

private String getPersonFirstNameFromAddress(String mobileNumber) {
  Json address = addressService.getAddress(mobileNumber);
  Person personDetail = address.getPersonDetails();
  return personDetail.firstName;
}