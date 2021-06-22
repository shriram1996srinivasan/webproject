@geonet
Feature: demo

Background:
Given go to "https://www.google.com"
@test1
Scenario Outline: <Test Name>
Then search "<Params>" 

Examples:
|Test Name|Params|
|demo1|comm|
|demo2|unde0rdell|
@test
Scenario: demo4
Given go to
|https://www.yahoo.com| https://www.google.com|
