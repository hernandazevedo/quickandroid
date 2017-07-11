#include "supportdata.h"


int SupportData::m_itemNumber = 0;

SupportData::SupportData(QObject * parent) : QObject(parent) {
    setRandomName();
}

SupportData::SupportData(QString name, QObject * parent) :
    QObject(parent), m_name(name) {

}


SupportData::SupportData(QString name,QString
                         value, QObject * parent) :
    QObject(parent), m_name(name),m_value(value) {

}

void SupportData::setRandomName() {
    static const QString names = "Badger,Shopkeeper,Pepperpots,Gumbys,Colonel";
    static const QStringList nameList = names.split(',');
    QString newName = QString::number(m_itemNumber) +" - "+ nameList.at(qrand() % nameList.length());
    if (newName != m_name) {
        m_name = newName;
        emit nameChanged(m_name);
    }
    m_itemNumber++;
}
