# skiutahregression
This is a personal portfolio project. The goal is to create a suite of regression tests for http://www.skiutah.com. Guice dependency injection is used throughout the suite to quickly and easily manage dependencies, such as the WebDriver instance and any page objects.

Readability and reliability are my biggest priorities to maintain in the continued development of this project. While I do not instantiate all page object web elements as class variables, all page object methods should be very simply comprehensible by non-experts.

[![Build Status](https://travis-ci.org/dturchenko91/skiutahregression.svg?branch=master)](https://travis-ci.org/dturchenko91/skiutahregression)
