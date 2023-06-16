Feature: Calculator functionality
@add
Scenario Outline: Addition of two numbers
Given a as <A> and b as <B>
When i add a and b
Then result should be <res>

Examples:
|A|B|res|
|50|50|100|
|40|40|80|
|20|20|40|