Narrative:
In order to prove that Servers can be created
As a tester
I want to create multiple servers then call their getters

Scenario: Server should return the identifier used in the constructor

Given a server is created with identifier <identifier> and status <status>
Then the server responds with <knownIdentifier>

Examples:
|identifier|status|knownIdentifier
|AAA|AVAILABLE|AAA|
|BBB|DOWN|BBB|

Scenario: Server should return the status used in the constructor

Given a server is created with identifier <identifier> and status <status>
Then the server responds with <knownStatus>

Examples:
|identifier|status|knownStatus|
|AAA|AVAILABLE|AVAILABLE|
|BBB|DOWN|DOWN|