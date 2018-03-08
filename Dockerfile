FROM ubuntu:16.04

RUN dpkg --add-architecture i386 && \
    apt-get update -yqq && \
    apt-get install -yqq libncurses5:i386 libc6:i386 libstdc++6:i386 lib32gcc1 lib32ncurses5 lib32z1 zlib1g:i386 && \
    apt-get install -yqq --no-install-recommends openjdk-8-jdk && \
    apt-get install -yqq git wget zip curl

ENV SDK_URL="https://dl.google.com/android/repository/sdk-tools-linux-3859397.zip" \
    ANDROID_HOME="/usr/local/android-sdk" \
    ANDROID_VERSION=26 \
    ANDROID_BUILD_TOOLS_VERSION=26.0.2

# Download Android SDK
RUN mkdir "$ANDROID_HOME" .android \
    && cd "$ANDROID_HOME" \
    && curl -o sdk.zip $SDK_URL \
    && unzip -qq sdk.zip \
    && rm sdk.zip \
    && yes | $ANDROID_HOME/tools/bin/sdkmanager --licenses

ENV GRADLE_VERSION 4.1
RUN cd /opt && \
    wget -q https://services.gradle.org/distributions/gradle-${GRADLE_VERSION}-bin.zip && \
    unzip -qq gradle*.zip && \
    ls -d */ | sed 's/\/*$//g' | xargs -I{} mv {} gradle && \
    rm gradle*.zip

ENV GRADLE_HOME /opt/gradle
ENV PATH ${PATH}:${GRADLE_HOME}/bin:${ANDROID_HOME}/emulator:${ANDROID_HOME}/tools:${ANDROID_HOME}/platform-tools:${ANDROID_HOME}/tools/bin

ENV WORK /application
RUN mkdir $WORK
WORKDIR WORK

ADD app $WORK/app
ADD deploy $WORK/deploy
ADD build.gradle $WORK/build.gradle
ADD gradle.properties $WORK/gradle.properties
ADD settings.gradle $WORK/settings.gradle
CMD cd $WORK && gradle uploadReleaseToHockeyApp