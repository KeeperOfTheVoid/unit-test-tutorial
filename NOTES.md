# Instructor Notes

We are going to cover mocking/stubbing techniques of unit testing.  Also, we will be unit testing something more relatable than a dice generator.  These notes are to help keep me on track, and to give you something you can refer to when following along in class.

## IntelliJ Shortcuts

Ctrl Shift T - Switches between test and production code

Ctrl Shift E - Recent files

Alt Shift Ins - Column Mode

## Writing a Parser

What's the first thing that comes to mind when you hear, Parser?  What should it do?

Given a library checkout system, when would parsing become useful? Most notable example: CSV lists

Book: Author, Title, and Due Date

What are our next steps?  Design.

```
@Test
public void testEmptyStream() {
    Stream<String> stream = Stream.empty();
    Parser parser = new Parser("~");
    List<CheckoutRecord> pojos = parser.getCheckoutRecords(stream);
    assertThat(pojos).isEmpty();
}
```

What do we need to make the test pass?

We need to return an empty list!! Simplicity first.

```
public List<CheckoutRecord> getCheckoutRecords(Stream<String> stream) {
    return new ArrayList<>();
}
```

Yay! We have a green bar!!!

What's the next thing we can test?

```
@Test
public void testSingleItemList() {
    Stream<String> stream = Stream.of("Chris Reinke~Sojourn~1849-10-12");
    Parser parser = new Parser("~");
    List<CheckoutRecord> pojos = parser.getCheckoutRecords(stream);
    assertThat(pojos).hasSize(1);
    assertThat(pojos.get(0).getAuthor()).isEqualTo("Chris Reinke");
    assertThat(pojos.get(0).getTitle()).isEqualTo("Sojourn");
    assertThat(pojos.get(0).getDate()).isEqualTo(LocalDate.of(1849, 10, 12));
}
```

Why do we get a Red Bar?

We're returning a empty list.  Let's try and send it something meaningful.

```
public List<CheckoutRecord> getCheckoutRecords(Stream<String> stream) {
    return stream.map(this::convertStringToRecord).collect(Collectors.toList());
}

private CheckoutRecord convertStringToRecord(String record) {
    String[] items = record.split(delimeter);
    return new CheckoutRecord(items[0], items[1], LocalDate.parse(items[2]));
}
```

Cool! Now, we have two meaningful test.  What next?

Let's try multiple things!!

```
// NoRedBar
@Test
public void testCommasDelimitedTwoItems() {
    Stream<String> stream = Stream.of("Chris Reinke,Sojourn,1849-10-12",
            "Phi Tran,Harry Potter and the Sorcerer's Stone,2015-03-04");
    Parser parser = new Parser(",");
    List<CheckoutRecord> pojos = parser.getCheckoutRecords(stream);
    assertThat(pojos).hasSize(2);
    assertThat(pojos.get(1).getAuthor()).isEqualTo("Phi Tran");
    assertThat(pojos.get(1).getTitle()).isEqualTo("Harry Potter and the Sorcerer's Stone");
    assertThat(pojos.get(1).getDate()).isEqualTo(LocalDate.of(2015, 3, 4));
}
```

This test should just pass because it was made to account for different delimeters.

Now, that we have some tests under our belt.  Let's refactor!!

Normally, you could convert all of your member variable to private, etc.  This was already done.  Let's move on...

What happens if there's an extra comma?

```
@Rule
public ExpectedException thrown = ExpectedException.none();

@Test
public void testCommasDelimitedExtraComma() {
    thrown.expect(IllegalArgumentException.class);
    thrown.expectMessage("Invalid data could not split on: ,");
    Stream<String> stream = Stream.of("Chris Reinke,Sojourn,1849-10-12",
            "Phi Tran,Harry Potter, and the Sorcerer's Stone,2015-03-04");
    Parser parser = new Parser(",");
    parser.getCheckoutRecords(stream);
}
```

Why do we have a Red Bar?

Problem: Not error handling for arguments.

Fix: Let's do some error handling!

NOTE: LET'S TRY AND MAKE MESSAGE GENERIC.  THEN, ADD DETAILS (commas, apostrophes, etc.)

```
private CheckoutRecord convertStringToRecord(String record) {
    String[] items = record.split(delimeter);
    if (items.length != 3)
        throw new IllegalArgumentException(
                String.format("Invalid data could not split on delimeter"));
    return new CheckoutRecord(items[0], items[1], LocalDate.parse(items[2]));
}
```

Sweet! Back to that Green Bar!!

What about an apostrophe?

```
@Test
    public void testCommasDelimitedAnApostrophe() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Invalid data could not split on: \'");
        Stream<String> stream = Stream.of("Chris Reinke\'Sojourn\'1849-10-12",
                "Phi Tran\'Harry Potter and the Sorcerer's Stone\'2015-03-04");
        Parser parser = new Parser("'");
        parser.getCheckoutRecords(stream);
    }
```

Cool.  Green Bar!!

But what happens when we run all of our tests?  Let's improve our error messege.

What about an edge case?  What happens if we throw in an 'H' as a delimeter?

```
@Test
public void testCommasDelimitedAnH() {
    thrown.expect(IllegalArgumentException.class);
    thrown.expectMessage("Invalid data could not split on: H");
    Stream<String> stream = Stream.of("Chris ReinkeHSojournH1849-10-12",
            "Phi TranHHarry Potter and the Sorcerer's StoneH2015-03-04");
    Parser parser = new Parser("H");
    parser.getCheckoutRecords(stream);
}
```

Awesome!  Green bar!!!

Is this a good time to refactor???  

No. Nothing really changed, but this is a good time to assess what we wrote.

Now, let's write some Integration Tests.

```
@Test
public void testWithRealFile() {
    InputStream is = getClass().getResourceAsStream("/library.txt");
    InputStreamReader reader = new InputStreamReader(is);
    BufferedReader buff = new BufferedReader(reader);
    Parser parser = new Parser("~");
    List<CheckoutRecord> records = parser.getCheckoutRecords(buff.lines());
    assertThat(records).hasSize(16);
}
```

NOTE: If you're getting a NPE, mark resource folder as Resource Root.

Cool.  Now, we have a green bar.  Let's refactor a bit!

```
@Category(value = UnitTest.class)
@Category(value = IntegrationTest.class)
```

We can use categories to better organize our tests.  

For small applications, you can store your Integration tests with your Unit Tests.

For larger applications, it's better to create a new project and store them.  

Also, you can write your Gradle script in such a way that it'll only run Unit Tests or Integration Tests.

So, we know that our we can grab a list of records from a file.  What else can we test?

If we have a web service, we can test that as well.  You would just create a URL object and pass that into the InputStream.

Can we test anything else???

Missed a pretty important one.  What happens if the date is incorrect?

```
@Test
@Category(value = UnitTest.class)
public void testCommasDelimitedTwoItemsInvalidDateOnOne() {
    thrown.expect(DateTimeParseException.class);
    Stream<String> stream = Stream.of("Chris Reinke,Sojourn,1849-10-12",
            "Phi Tran,Harry Potter and the Sorcerer's Stone,2015403-04");
    TheParsenator theParsenator = new TheParsenator(",");
    theParsenator.getCheckoutRecords(stream);
}
```

So, this throws a DateTimeParseException.  What other exception could we throw?  i.e. IllegalArgumentException