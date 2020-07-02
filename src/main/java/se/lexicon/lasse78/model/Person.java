package se.lexicon.lasse78.model;

public class Person {
    //Fields
    private final int personId;
    private String firstName;
    private String lastName;

    //Very picky constructor
    public Person(int personId, String firstName, String lastName) {
        this.personId = personId;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    //Generic setters and getters (personId can't have a setter)
    public int getPersonId() {  return personId; }
    public void setFirstName(String firstName) {  this.firstName = firstName; }
    public String getFirstName() { return firstName; }
    public void setLastName (String lastName){  this.lastName = lastName; }
    public String getLastName() { return lastName; }

}
