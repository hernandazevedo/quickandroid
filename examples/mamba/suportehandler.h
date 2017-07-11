#ifndef SUPORTEHANDLER_H
#define SUPORTEHANDLER_H

#include "qquicklist.h"
#include "supportdata.h"



class SuporteHandler: public QObject
{
    Q_OBJECT

    Q_PROPERTY(QObjectListModel * model READ model NOTIFY modelChanged)

    //Q_PROPERTY(QQmlListProperty<SupportData> listProperty READ listProperty NOTIFY modelChanged)

public:
    explicit SuporteHandler(QObject *parent = NULL);

    QObjectListModel * model();
    Q_INVOKABLE void listSupportData();
    //SuporteHandler();


signals:

    void modelChanged(QObjectListModel *);

public slots:


private:
    QQuickList<SupportData> m_personlist;

};



#endif // SUPORTEHANDLER_H
