public String getName(String mobileNumber) {
  Person person = contactService.getPerson(mobileNumber);

  if (StringUtil.isBlank(person.firstName)) {
    getFirstNameInAddressService(mobileNumber);
  }
  
  return person.firstName;
}

private String getFirstNameInAddressService(mobileNumber) {
  Json address = addressService.getAddress(mobileNumber);
  Person personDetail = address.getPersonDetails();
  return personDetail.firstName;
}