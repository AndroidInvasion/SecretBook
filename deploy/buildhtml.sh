#!/bin/bash

SOURCE_DIR=$1
TARGET_BRANCH=gh-pages
REPO=git@github.com:AndroidInvasion/SecretBook.git

git clone $REPO pages && cd pages
git checkout $TARGET_BRANCH

git config user.name "Travis CI"
git config user.email "$COMMIT_AUTHOR_EMAIL"

BUILDFOLDER=build_$TRAVIS_BUILD_NUMBER
mkdir ./$BUILDFOLDER
cp -r ${SOURCE_DIR}/* ./$BUILDFOLDER/

rm index.html
tree -a -I '.git' -H ./ >> index.html

git add .
git commit -m "Report deploy: ${TRAVIS_BUILD_NUMBER}"
git push origin $TARGET_BRANCH

