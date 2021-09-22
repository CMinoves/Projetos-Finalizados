/****************************************************************************
** Meta object code from reading C++ file 'Hole.h'
**
** Created by: The Qt Meta Object Compiler version 67 (Qt 5.12.9)
**
** WARNING! All changes made in this file will be lost!
*****************************************************************************/

#include "../NineHoles/Hole.h"
#include <QtCore/qbytearray.h>
#include <QtCore/qmetatype.h>
#if !defined(Q_MOC_OUTPUT_REVISION)
#error "The header file 'Hole.h' doesn't include <QObject>."
#elif Q_MOC_OUTPUT_REVISION != 67
#error "This file was generated using the moc from 5.12.9. It"
#error "cannot be used with the include files from this version of Qt."
#error "(The moc has changed too much.)"
#endif

QT_BEGIN_MOC_NAMESPACE
QT_WARNING_PUSH
QT_WARNING_DISABLE_DEPRECATED
struct qt_meta_stringdata_Hole_t {
    QByteArrayData data[15];
    char stringdata0[108];
};
#define QT_MOC_LITERAL(idx, ofs, len) \
    Q_STATIC_BYTE_ARRAY_DATA_HEADER_INITIALIZER_WITH_OFFSET(len, \
    qptrdiff(offsetof(qt_meta_stringdata_Hole_t, stringdata0) + ofs \
        - idx * sizeof(QByteArrayData)) \
    )
static const qt_meta_stringdata_Hole_t qt_meta_stringdata_Hole = {
    {
QT_MOC_LITERAL(0, 0, 4), // "Hole"
QT_MOC_LITERAL(1, 5, 12), // "stateChanged"
QT_MOC_LITERAL(2, 18, 0), // ""
QT_MOC_LITERAL(3, 19, 11), // "Hole::State"
QT_MOC_LITERAL(4, 31, 9), // "old_state"
QT_MOC_LITERAL(5, 41, 9), // "new_state"
QT_MOC_LITERAL(6, 51, 10), // "updateHole"
QT_MOC_LITERAL(7, 62, 3), // "row"
QT_MOC_LITERAL(8, 66, 3), // "col"
QT_MOC_LITERAL(9, 70, 5), // "state"
QT_MOC_LITERAL(10, 76, 5), // "State"
QT_MOC_LITERAL(11, 82, 3), // "Red"
QT_MOC_LITERAL(12, 86, 4), // "Blue"
QT_MOC_LITERAL(13, 91, 5), // "Empty"
QT_MOC_LITERAL(14, 97, 10) // "Selectable"

    },
    "Hole\0stateChanged\0\0Hole::State\0old_state\0"
    "new_state\0updateHole\0row\0col\0state\0"
    "State\0Red\0Blue\0Empty\0Selectable"
};
#undef QT_MOC_LITERAL

static const uint qt_meta_data_Hole[] = {

 // content:
       8,       // revision
       0,       // classname
       0,    0, // classinfo
       2,   14, // methods
       3,   34, // properties
       1,   46, // enums/sets
       0,    0, // constructors
       0,       // flags
       1,       // signalCount

 // signals: name, argc, parameters, tag, flags
       1,    2,   24,    2, 0x06 /* Public */,

 // slots: name, argc, parameters, tag, flags
       6,    2,   29,    2, 0x08 /* Private */,

 // signals: parameters
    QMetaType::Void, 0x80000000 | 3, 0x80000000 | 3,    4,    5,

 // slots: parameters
    QMetaType::Void, 0x80000000 | 3, 0x80000000 | 3,    4,    5,

 // properties: name, type, flags
       7, QMetaType::Int, 0x00095103,
       8, QMetaType::Int, 0x00095103,
       9, 0x80000000 | 3, 0x0049510b,

 // properties: notify_signal_id
       0,
       0,
       0,

 // enums: name, alias, flags, count, data
      10,   10, 0x0,    4,   51,

 // enum data: key, value
      11, uint(Hole::Red),
      12, uint(Hole::Blue),
      13, uint(Hole::Empty),
      14, uint(Hole::Selectable),

       0        // eod
};

void Hole::qt_static_metacall(QObject *_o, QMetaObject::Call _c, int _id, void **_a)
{
    if (_c == QMetaObject::InvokeMetaMethod) {
        auto *_t = static_cast<Hole *>(_o);
        Q_UNUSED(_t)
        switch (_id) {
        case 0: _t->stateChanged((*reinterpret_cast< Hole::State(*)>(_a[1])),(*reinterpret_cast< Hole::State(*)>(_a[2]))); break;
        case 1: _t->updateHole((*reinterpret_cast< Hole::State(*)>(_a[1])),(*reinterpret_cast< Hole::State(*)>(_a[2]))); break;
        default: ;
        }
    } else if (_c == QMetaObject::IndexOfMethod) {
        int *result = reinterpret_cast<int *>(_a[0]);
        {
            using _t = void (Hole::*)(Hole::State , Hole::State );
            if (*reinterpret_cast<_t *>(_a[1]) == static_cast<_t>(&Hole::stateChanged)) {
                *result = 0;
                return;
            }
        }
    }
#ifndef QT_NO_PROPERTIES
    else if (_c == QMetaObject::ReadProperty) {
        auto *_t = static_cast<Hole *>(_o);
        Q_UNUSED(_t)
        void *_v = _a[0];
        switch (_id) {
        case 0: *reinterpret_cast< int*>(_v) = _t->row(); break;
        case 1: *reinterpret_cast< int*>(_v) = _t->col(); break;
        case 2: *reinterpret_cast< Hole::State*>(_v) = _t->state(); break;
        default: break;
        }
    } else if (_c == QMetaObject::WriteProperty) {
        auto *_t = static_cast<Hole *>(_o);
        Q_UNUSED(_t)
        void *_v = _a[0];
        switch (_id) {
        case 0: _t->setRow(*reinterpret_cast< int*>(_v)); break;
        case 1: _t->setCol(*reinterpret_cast< int*>(_v)); break;
        case 2: _t->setState(*reinterpret_cast< Hole::State*>(_v)); break;
        default: break;
        }
    } else if (_c == QMetaObject::ResetProperty) {
    }
#endif // QT_NO_PROPERTIES
}

QT_INIT_METAOBJECT const QMetaObject Hole::staticMetaObject = { {
    &QPushButton::staticMetaObject,
    qt_meta_stringdata_Hole.data,
    qt_meta_data_Hole,
    qt_static_metacall,
    nullptr,
    nullptr
} };


const QMetaObject *Hole::metaObject() const
{
    return QObject::d_ptr->metaObject ? QObject::d_ptr->dynamicMetaObject() : &staticMetaObject;
}

void *Hole::qt_metacast(const char *_clname)
{
    if (!_clname) return nullptr;
    if (!strcmp(_clname, qt_meta_stringdata_Hole.stringdata0))
        return static_cast<void*>(this);
    return QPushButton::qt_metacast(_clname);
}

int Hole::qt_metacall(QMetaObject::Call _c, int _id, void **_a)
{
    _id = QPushButton::qt_metacall(_c, _id, _a);
    if (_id < 0)
        return _id;
    if (_c == QMetaObject::InvokeMetaMethod) {
        if (_id < 2)
            qt_static_metacall(this, _c, _id, _a);
        _id -= 2;
    } else if (_c == QMetaObject::RegisterMethodArgumentMetaType) {
        if (_id < 2)
            *reinterpret_cast<int*>(_a[0]) = -1;
        _id -= 2;
    }
#ifndef QT_NO_PROPERTIES
    else if (_c == QMetaObject::ReadProperty || _c == QMetaObject::WriteProperty
            || _c == QMetaObject::ResetProperty || _c == QMetaObject::RegisterPropertyMetaType) {
        qt_static_metacall(this, _c, _id, _a);
        _id -= 3;
    } else if (_c == QMetaObject::QueryPropertyDesignable) {
        _id -= 3;
    } else if (_c == QMetaObject::QueryPropertyScriptable) {
        _id -= 3;
    } else if (_c == QMetaObject::QueryPropertyStored) {
        _id -= 3;
    } else if (_c == QMetaObject::QueryPropertyEditable) {
        _id -= 3;
    } else if (_c == QMetaObject::QueryPropertyUser) {
        _id -= 3;
    }
#endif // QT_NO_PROPERTIES
    return _id;
}

// SIGNAL 0
void Hole::stateChanged(Hole::State _t1, Hole::State _t2)
{
    void *_a[] = { nullptr, const_cast<void*>(reinterpret_cast<const void*>(&_t1)), const_cast<void*>(reinterpret_cast<const void*>(&_t2)) };
    QMetaObject::activate(this, &staticMetaObject, 0, _a);
}
QT_WARNING_POP
QT_END_MOC_NAMESPACE
