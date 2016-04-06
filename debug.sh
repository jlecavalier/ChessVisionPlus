#!/bin/bash
echo Assembling App
./gradlew --info assembleDebug
echo Installing App
adb install -r ./build/outputs/apk/ChessVisionPlus-debug.apk
echo Launching Debugger
adb logcat *:D