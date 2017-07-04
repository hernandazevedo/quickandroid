import QtQuick 2.2
import QtQuick.Window 2.1
import QuickAndroid 0.1
import QuickAndroid.Styles 0.1
import "../theme"

Page {

    actionBar: ActionBar {
        id : actionBar
        title: "PaxPrinterDemo"
        z: 10
        upEnabled: true
        onActionButtonClicked: back();
    }

    Text {
        id: label
        text : "Press print"
        anchors.fill: parent
        verticalAlignment: Text.AlignVCenter
        horizontalAlignment: Text.AlignHCenter
        type: Constants.largeText
    }

    MouseArea {
        anchors.fill: parent
        onClicked: {
            SystemDispatcher.dispatch("Notifier.paxPrint",{
                title: "Hello Pax",
                message: "Hello!"
            });
        }
    }

}
