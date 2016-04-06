#!/bin/bash
echo Assembling App
./gradlew assembleDebug
echo Installing App
adb install -r ./build/outputs/apk/ChessVisionPlus-debug.apk
echo Launching Debugger
adb logcat *:D > log/debug.log