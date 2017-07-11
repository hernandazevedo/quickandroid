import QtQuick 2.0
import QuickAndroid 0.1
import QuickAndroid.Styles 0.1
import "../theme"
import TestComponents 1.0


Page {

    actionBar: ActionBar {
        id: actionBar
        upEnabled: true
        title: qsTr("Suporte")
        showTitle: true

        onActionButtonClicked: back();
    }

    Component {
        id: delegate1
        ListItem {
            title: edit.name
            subtitle: edit.value
        }
    }

    VisualDataModel {
        id: visualDataModel
        delegate: ListItem {
            title: name
            subtitle: value
            onClicked: {
                //present(Qt.resolvedUrl(modelData.demo));
            }
        }

        model: suporteHandler.model;
    }

    ListView {
        anchors.fill: parent
        model: suporteHandler.model
        delegate: delegate1

    }

    Flow {
        id: row2
        anchors.bottom: parent.bottom
        anchors.left: parent.left
        anchors.right: parent.right
        Button {
            text: "Listar";
            onClicked: suporteHandler.listSupportData()
        }
    }

    Component.onCompleted:{
        suporteHandler.listSupportData()
    }


}
