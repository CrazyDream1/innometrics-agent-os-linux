import QuickFlux 1.1
import QtQuick.Dialogs 1.2

import QtQuick 2.0

import "../actions"
import "../stores"

Middleware {
    function dispatch(type, message) {
        if (type === ActionTypes.quit) {
            return Qt.quit();
        } else {
            return next(type, message);
        }
    }
}
