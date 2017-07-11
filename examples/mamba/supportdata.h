#ifndef SUPPORTDATA_H
#define SUPPORTDATA_H

#include <QObject>
#include <QStringList>

/**
 * @brief The SupportData class
 * Esta classe representa os dados a serem tratados e transportados para a listview da tela de suporte.
 */
class SupportData : public QObject {

    Q_OBJECT

    Q_PROPERTY(QString name NOTIFY nameChanged MEMBER m_name)
    Q_PROPERTY(QString value NOTIFY valueChanged MEMBER m_value)

    QString m_name;
    QString m_value;

    static int m_itemNumber;

public:
    Q_INVOKABLE SupportData(QObject * parent = NULL);

    Q_INVOKABLE SupportData(QString name, QObject * parent = NULL);
    Q_INVOKABLE SupportData(QString name,QString value, QObject * parent = NULL);

    Q_SIGNAL void nameChanged(const QString &);
    Q_SIGNAL void valueChanged(const QString &);

    Q_INVOKABLE void setRandomName();
};

#endif // SUPPORTDATA_H
