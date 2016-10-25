Developing TicTacToe
====================

# Required environment

All development is done in Java 1.8 (or greater) so SDK must be installed.
[Java 8 SDK](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)

Git is used for source control. [Download Git](https://git-scm.com/downloads) - 
[Git instructions in Icelandic](https://github.com/gaui/git)

Gradle is used for build automation. [Download Gradle](https://gradle.org/gradle-download/) - 
[Quick intro to Gradle](https://github.com/joningis/hugb_hello_world)


# Setting up the local repository

Have a member of our team grant you access to our organization and clone the repository:

```
$ git clone https://github.com/hundarogborn/TicTacToe.git
```

# Building, testing and running the application

To build the application and run the test suite:
```shell
$ bin/build 
```

To run the application locally:
```
$ bin/run
```

# Submitting changes

We use feature branches.  You are never, ever, ever, ever(!!!!) to push directly to master.

The basic workflow is:
1. Create a new feature branch
   The naming convention for branches is:
   - feat/integrate-foo-to-quux - For feature branches, implementing new functionality or improvements.
   
   - fix/fix-broken-thing-bar - For bugfixes, fixing already existing functionality
   
   - doc/document-quux - For documentation improvements
   
   We're not super strict on naming.  If you're doing something that doesn't exactly fit the above things,
   do something else that feels correct.
   
2. Hack your good hack

   - Write tests
   
   - Write clean code
   
   - Document your APIs

3. Create a pull request

   We have a template that's automatically filled out.  Answer the questions on:
   
   - What you are doing; from 10k feet
   
   - Why are you doing it.  What's the business value of the change?
   
   Skim over the 'Reviewer checklist' section and assure yourself that the review will be successful.  Remind
   yourself that you will get the call if this breaks prod.
   
4. Find a member of our team and ask them to review.
   You can also assign the issue to them if you're not in a hurry.
   Don't be sad if you get criticism: it's what code reviews are for.
   
5. If all tests are green and the reviewer agrees to the change; merge the branch into master and then delete your branch.


# Preparing releases

To prepare a release, simply tag master and push the tag.
Travis-CI will automatically push the release to GitHub at https://github.com/hundarogborn/TicTacToe/releases,
where it'll be available for download

```
$ git checkout <commit you want to tag>
$ git tag -a v0.0.1 -m "A fantastic release"
$ git push --tags
```

Remember to choose a sane version number and provide a meaningful message


