#include "suportehandler.h"
#include <QObject>


SuporteHandler::SuporteHandler(QObject *parent) :
    QObject(parent)
{
//    listSupportData();
}

QObjectListModel *SuporteHandler::model()
{
    return m_personlist.getModel();
}

void SuporteHandler::listSupportData()
{
    qDebug() << "Listing data";
    m_personlist.clear();
    m_personlist.append(new SupportData("Versao","1.2.3"));
    m_personlist.append(new SupportData("Stone Code","951919191"));
    m_personlist.append(new SupportData("Wifi","DCI1234"));
    m_personlist.append(new SupportData("Versao","1.2.3"));
    m_personlist.append(new SupportData("Versao","1.2.3"));
    m_personlist.append(new SupportData("Versao","1.2.3"));

    emit modelChanged(model());

}

