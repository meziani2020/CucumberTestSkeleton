Feature:  Home Page TEST

  Background:
    Given  user run chrome browser

    Given user open application home page



  @Assignment0
  Scenario: test application  Home page Display
     # Given user open application home page
    Then  the Home page sould be displayed

  @Assignment1
  Scenario: Verify that there are only 4 structure values present
    #Given user open application home page
    Then  user cont the structure values of the Table
    And   the number of defferent  values need to be fore


  @Assignment2
  Scenario: Read All the Values from the table row-wise and print them all
    #Given user open application home page
    Then  user print tabel data


   @Assignment3
   Scenario Outline: Assignment 3: Verify  structures height
    Then  verify that Structure "<StructureName>" has "<height>" as height

    Examples:
      |StructureName|height|
      |Burj Khalifa|822m|
      |Clock Tower Hotel|601m|
      |Taipei 101|509m|
      |Financial Center|492m|


  @Assignment4
  Scenario: Assignment 4: Verify that 6th row (Last Row) has only two columns.
    #Given user open application home page
    Then  Verify that sixth row has two col

