#!/bin/bash
echo Assembling App
./gradlew assembleDebug
echo Installing App
adb install -r ./build/outputs/apk/ChessVisionPlus-debug.apk
echo Good to go