'use strict'

var ajax = (url, successFunc) => {
    axios.get('http://localhost:8080/' + url).then(successFunc);
}

var sleep = function(time) {
    var startTime = new Date().getTime() + parseInt(time, 10);
    while(new Date().getTime() < startTime) {}
};

function wakeUp(callback) {
    return new Promise(resolve => {
        ajax('AsyncTest1', response => {
            resolve(response.data);
        });
    });
}

function goToWork(callback) {
    return new Promise(resolve => {
        ajax('AsyncTest2', response => {
            resolve(response.data);
        });
    });
}

function goHome(callback) {
    return new Promise(resolve => {
        setTimeout(() => {
            sleep(5000);
            ajax('AsyncTest3', response => {
                resolve(response.data);
            });
        }, 500);
    });
}

function goToBed(callback) {
    return new Promise(resolve => {
        ajax('AsyncTest4', response => {
            resolve(response.data);
        });
    });
}

function runCallback() {
    wakeUp(() => {
        goToWork(() => {
            goHome(goToBed);
        })
    })
}

function runPromise() {
    wakeUp().then(data => {
        console.log(data);
        return goToWork();
    }).then(data => {
        console.log(data);
        return goHome();
    }).then(data => {
        console.log(data);
        return goToBed();
    }).then(data => {
        console.log(data);
    });
}