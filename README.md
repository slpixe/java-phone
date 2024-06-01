# PhoneClass
The PhoneClass is a Java class that provides functionality related to phone numbers. It reads phone numbers from a file, validates them, and performs various operations.

## Javadocs

To read the Javadocs please visit [https://slpixe.github.io/java-phone/](https://slpixe.github.io/java-phone/)

## Usage
1. Reading Phone Numbers from a File The readAllLinesAndStoreInField() method reads phone numbers from a file named fileTest.txt located in the src/main/resources directory. The phone numbers are stored in the lines field.
2. Removing Comments The removeComments() method removes any lines starting with a hash (#) character. If any comments are removed, it returns true; otherwise, it returns false.
3. Removing Empty Lines The removeEmptyLines() method removes empty lines from the list of phone numbers. If any empty lines are removed, it returns true; otherwise, it returns false.
4. Number of Lines The numberOfLines() method returns the total number of phone numbers read from the file.
5. Validating Phone Numbers The isNumberValid(String number) method checks if a given phone number matches the specified regex pattern. It returns true if the number is valid; otherwise, it returns false.
6. Number of Valid and Invalid Phone Numbers
7. The numberOfValidNumbers() method returns the count of valid phone numbers. 
8. The numberOfInvalidNumbers() method returns the count of invalid phone numbers. 
9. List of Valid Phone Numbers The listOfValidNumbers() method returns a list of valid phone numbers.

## Regex Pattern for Valid Phone Numbers
The regex pattern used for valid phone numbers is as follows:

- `(\\(\\d{3}\\)\\s{1}\\d{3}-{1}\\d{4})` (e.g., (123) 456-7890)
- `(\\d{3}\\s{1}\\d{3}\\s{1}\\d{4})` (e.g., 123 456 7890)
- `(\\d{3}-{1}\\d{3}-\\d{4})` (e.g., 123-456-7890)

These were tested on regex101 [Regex101 - java phone number validation](https://regex101.com/r/rC9rKO/2)

## Example Usage

```java
public static void main(String[] args) {
PhoneClass phoneClass = new PhoneClass();
phoneClass.readAllLinesAndStoreInField();

    System.out.println("Total number of lines: " + phoneClass.numberOfLines());
    System.out.println("Number of valid phone numbers: " + phoneClass.numberOfValidNumbers());
    System.out.println("Number of invalid phone numbers: " + phoneClass.numberOfInvalidNumbers());

    List<String> validNumbers = phoneClass.listOfValidNumbers();
    System.out.println("Valid phone numbers:");
    validNumbers.forEach(System.out::println);
}
```

## To generate javadoc documentation

1. Make sure to have maven installed e.g. `sdkman install maven`
2. Either run `mvn javadoc:javadoc` 
3. or in Intellij select `Maven` -> `Lifecycle` -> `clean` (run) -> `compile` (run)
