# Instructor Notes

We are going to cover the basics of unit testing.  This includes creating a program to 
simulate dice rolling.  If time permits, we'll also create a program that simulates various 
operations, like reading from a database and parsing some data.  These notes are to help keep me on track, 
and to give you something you can refer to when following along in class.

## IntelliJ Shortcuts

Ctrl Shift T - Switches between test and production code

Ctrl Shift E - Recent files

Alt Shift Ins - Column Mode

## Rolling a Die

What's the first thing we can do when rolling a die?  The most simplest?

Looking at which pip (the dots on the die) is shown when sitting still on a table.  The default pip.

We can check to see if the default is 1.  Most simplest case.

```
public void testDefaultIs1 () {
    // Create new die
    // Assert that pip is 1
    assertThat(die.getPip()).isEqualTo(1);
}
```

Now that we can see that the default is 4, what should be our next steps?
	Dependency Injection

```
public void testSimpleRollOf4() {
    //Stub
    Random random = new Random () {
	    public int nextInt(int bound) {
            return 4;
        }
    }
    
    // Die die = new DieImpl(random);
    // Die rolledDie = die.roll();
    assertThat(die.roll().getPip()).isEqualTo(4);
}
```

Cool.  Now, we rolled the die.  What should we do next?

Check to see if we can roll another 4.

```
public void testSimpleRollOf4Twice() {
    assertThat(die.roll().getPip()).isEqualTo(4)
}
```

We should geta red bar.  What's the problem?

Problem: NPE

Solution: Fix constructor

```
Die(Random random , int pips)
```

At this point in time, it should be a great time to refactor!!

What do you think we can refactor?

1) Make constructor private
2) Make instance fields final

Need to write tests to check

```
public void testSimpleRollOf4WithoutARandom() {
    Die die = new Die();
    assertThat(die.roll().getPips()).isEqualTo(4)
}
```

This produces a NPE.  In the default constructor, what does random do?  What is it?

Remove default constructor to solve problem.  In addition, remove all associated tests.

Integration Tests - End to end testing

Does the thing that I'm testing actually fully work.

```
public void testIntegrationRoll {
    Die die = new Die(new Random());
    
    for (int i = 0; i < 1000000; i++) {
        assertThat(die.roll().getPips()).isGreaterThan(0).isLessThan(7);
    }
}
```

We get a red bar.  We'll never write 100% perfect code.

We can write a new test for this "bug".

```
// Unit Test Tied to JIRA #
public void testBUG1004() {
    // Create mock
    Random random = createMock(Random.class);
    
    // Reherse
    //expect(random.nextInt(anyInt())).andReturn(4);
    expect(random.nextInt(6)).andReturn(4);
    
    // Rewind (EasyMock, not with mockito) - Should probably do this with EasyMock
    replay(random);
    
    // Run test
    Die die = new DieImpl(random); //Subject under test
    // assertThat(die.getPips()).isEqualTo(????) Just temp code
    assertThat(die.roll().getPips()).isGreaterThan(0).isLessThan(7);
    
    // Verify
    verify(random);
}
```

Red bar.  The problem was identified.  Probability of that bug will reoccur is slim.

```
public void testBUG1004With0 {
    // Change bound from 7 to nextInt(7) + 1
}
```

What happens if Random is NULL?

```
public void testRandomShouldNotBeNull() {
    try {
        new Die(null);
    } catch (NullPointerException ex) {
        assertThat(ex).hasMessage("should not be null")
    }
}
```

This produces a Green Bar. It shouldn't create a Green Bar

Correction: 

```
public void testRandomShouldNotBeNull() {
    try {
        new Die(null);
        fail("This should not be here")
    } catch (NullPointerException ex) {  // IllegalArgumentException
        assertThat(ex).hasMessage("should not be null")
    }
}
```

To fix the test, in the public constructor:

If random is null -> throw new IAE with appropriate message

Another option is to use requireNotNull method instead of null check.

```
Objects.requireNonNull(random,"Random cannot be null");
```

Refactor Time!!

1) Chain constructor

```
public Die(Random random) {
    this (random, 1);
}
```
2) Make error message a constant

Everything is still green.

Can also use Lambdas

```
LambdaDie die = new LambdaDie(() -> 4)
assertThat(die.roll().getPip()).isEqualTo(4)
```

## Library Example

First example was pretty simple.  What happens when the problem is way bigger?

Break big problems into small problems.  If it's easy to solve, it's easy to test.

