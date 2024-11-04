#ifndef CLOCK_H
#define CLOCK_H

#include <iostream>
#include <iomanip>
#include <stdexcept>
#include <string>

class Clock {
protected:
    int _hours;
    int _minutes;
    int _seconds;

public:
    Clock(int hours, int minutes, int seconds);
    virtual ~Clock() {}
    virtual void tic();
    void print() const;
};

#endif