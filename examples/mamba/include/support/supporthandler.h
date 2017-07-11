#ifndef SUPORTEHANDLER_H
#define SUPORTEHANDLER_H

#include "qquicklist.h"
#include "supportdata.h"



class SupportHandler: public QObject
{
    Q_OBJECT

    Q_PROPERTY(QObjectListModel * model READ model NOTIFY modelChanged)

    //Q_PROPERTY(QQmlListProperty<SupportData> listProperty READ listProperty NOTIFY modelChanged)

public:
    explicit SupportHandler(QObject *parent = NULL);

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
