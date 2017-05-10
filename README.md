# CiCdDemo

[![Build Status](https://travis-ci.org/anukrishnank/CiCdDemo.svg?branch=master)](https://travis-ci.org/anukrishnank/CiCdDemo)  [![Coverage Status](https://coveralls.io/repos/github/anukrishnank/CiCdDemo/badge.svg?branch=master)](https://coveralls.io/github/anukrishnank/CiCdDemo?branch=master)  

## Demo project for CI/CD 

This is simple Demo project to demonstrate setting up of Continous Intgeration(CI), Continous Deployment(CD) in a scala project. Here I use travis-ci and coverall to set up the CI part and docker for CD.

## Setting Up Travis CI

Travis is a continous intgeration service and set up is easy with github account. Login to [Travis](https://travis-ci.org/) using github account and Then you need to sync your repositories in Travis and select the projects you want to enable.

Create ```.travis.yml``` file in the root of project and provide the below entries

```
language: scala
scala:
    - 2.11.7
```

## Setting up coverall

Coveralls is a service to visualize code coverage reports. Sign up in [Coveralls](https://coveralls.io) using github account and sync the repositories and select the ones to enable for Coveralls. Inlcudethe sbt plugin for coveralls in ```plugins.sbt``` file in your project. 
```
addSbtPlugin("org.scoverage" % "sbt-scoverage" % "1.3.5")

addSbtPlugin("org.scoverage" % "sbt-coveralls" % "1.0.3")

```
update the ```.travis.yml``` file in your project to execute the coverage analysis

```
language: scala
scala:
    - 2.11.7
script:
    - sbt clean coverage test
after_success:
    - sbt coveralls
```

Continous Deployment using docker is not yet done for this repo . Its work is in progress
