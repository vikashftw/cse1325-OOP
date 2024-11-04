#include "timer.h"
#include "timer_expired.h"

void Timer::tic() {
    _seconds--;
    if (_seconds < 0) {
        _seconds = 59;
        _minutes--;
        if (_minutes < 0) {
            _minutes = 59;
            _hours--;
            if (_hours < 0) {
                _hours = 23;
            }
        }
    }
    if (_hours == 0 && _minutes == 0 && _seconds == 0) {
        throw Timer_expired("Timer expired");
    }
}
