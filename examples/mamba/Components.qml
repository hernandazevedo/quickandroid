import QtQuick 2.2
import QtQuick.Window 2.1
import QuickAndroid 0.1
import QuickAndroid.Styles 0.1
import "./theme"

Page {
    objectName: "ComponentPage";

    property var pages: [
        {
            name: "Suporte",
            demo: "suporte/Suporte.qml",
            description: "Suporte"
        }
    ];

    actionBar: ActionBar {
        id : actionBar
        iconSource: A.drawable("ic_menu",Constants.black87)
        title: "Mamba"
        showIcon: false
        actionButtonEnabled: false
    }

    VisualDataModel {
        id: visualDataModel
        delegate: ListItem {
            title: modelData.name
            subtitle: modelData.description
            onClicked: {
                present(Qt.resolvedUrl(modelData.demo));
            }
        }

        model: pages;
    }

    ListView {
        anchors.fill: parent

        model : visualDataModel
    }

}
