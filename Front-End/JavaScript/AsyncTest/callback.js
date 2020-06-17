'use strict'

var ajax = (url, successFunc) => {
    axios.get('http://localhost:8080/' + url).then(successFunc);
}

function wakeUp(callback) {
    ajax('AsyncTest1', response => {
        console.log(response.data);
        callback && typeof callback == 'function' && callback();
    });
}

function goToWork(callback) {
    ajax('AsyncTest2', response => {
        console.log(response.data);
        callback && typeof callback == 'function' && callback();
    });
}

function goHome(callback) {
    ajax('AsyncTest3', response => {
        console.log(response.data);
        callback && typeof callback == 'function' && callback();
    });
}

function goToBed(callback) {
    ajax('AsyncTest4', response => {
        console.log(response.data);
        callback && typeof callback == 'function' && callback();
    });
}

// callback hell
function runCallback() {
    wakeUp(() => {
        goToWork(() => {
            goHome(goToBed);
        })
    })
}