#!/bin/bash

SOURCE_DIR=$1
TARGET_BRANCH=deployreport
REPO=`git@github.com:AndroidInvasion/SecretBook.git`

git clone $REPO pages && cd pages
git checkout $TARGET_BRANCH

git config user.name "Travis CI"
git config user.email "$COMMIT_AUTHOR_EMAIL"

BUILDFOLDER=build_$TRAVIS_BUILD_NUMBER
cp ${SOURCE_DIR}/* ./$BUILDFOLDER/

rm index.html
tree -a -I '.git' -H baseHREF >> index.html

