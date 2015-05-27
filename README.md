# Continuous Refactoring

Code for the continuous refactoring CodingDojo.

Inspired by the book Refactoring to Patterns by Joshua Kerievsky.

## Clean and test the project

	mvn

## Help for Eclipse users

### Configure project for eclipse

	mvn eclipse:eclipse

### Static imports

	Window > Preferences > Java > Editor > Content Assist > Favorites

I have the following entries (Use "New Type" and omit the .*)

	org.hamcrest.Matchers.*
	org.hamcrest.CoreMatchers.*
	org.junit.*
	org.junit.Assert.*
	org.junit.Assume.*
	org.junit.matchers.JUnitMatchers.*
