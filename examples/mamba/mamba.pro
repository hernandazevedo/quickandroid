TEMPLATE = app

QT += qml quick

SOURCES += main.cpp \
    automator.cpp \
    qobjectlistmodel.cpp \
    suportehandler.cpp \
    supportdata.cpp

RESOURCES += qml.qrc

# Additional import path used to resolve QML modules in Qt Creator's code model
# QML_IMPORT_PATH += ../..

android {
    QT += androidextras
    ANDROID_PACKAGE_SOURCE_DIR = $$PWD/android-sources
}

include(../../quickandroid.pri)

# Default rules for deployment.
include(deployment.pri)



#Bibliotecas do mamba



#INCLUDEPATH += $$PWD/include
#INCLUDEPATH += $$PWD/../../mambalibs/am/include
#INCLUDEPATH += $$PWD/../../mambalibs/am/lib
#INCLUDEPATH += $$PWD/../../mambalibs/br/inc
#INCLUDEPATH += $$PWD/../../mambalibs/mal/inc
#INCLUDEPATH += $$PWD/../../mambalibs/launcher/Mamba_Web/include
#INCLUDEPATH += $$PWD/../../mambalibs/sdk/linux/PAX/S920/sysroot/usr/include/freetype2
#INCLUDEPATH += $$PWD/../../mambalibs/sdk/linux/PAX/S920/sysroot/usr/lib/

#FIM bibliotecas do mamba

DISTFILES += \
    android-sources/AndroidManifest.xml \
    android-sources/src/quickandroid/example/ExampleService.java \
    README.md \
    android-sources/gradle/wrapper/gradle-wrapper.jar \
    android-sources/gradlew \
    android-sources/res/values/libs.xml \
    android-sources/build.gradle \
    android-sources/gradle/wrapper/gradle-wrapper.properties \
    android-sources/gradlew.bat \
    android-sources/settings.gradle \
    android-sources/gradle/wrapper/gradle-wrapper.properties \
    android-sources/src/quickandroid/example/MyMainActivity.java \
    android-sources/src/quickandroid/pax/GetObj.java \
    android-sources/src/quickandroid/pax/PrinterTester.java \
    android-sources/src/quickandroid/pax/TestLog.java

HEADERS += \
    automator.h \
    ../../README.md \
    qobjectlistmodel.h \
    qquicklist.h \
    suportehandler.h \
    supportdata.h
