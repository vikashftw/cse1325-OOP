#ifndef TIMER_EXPIRED_H
#define TIMER_EXPIRED_H

#include <stdexcept>

class Timer_expired : public std::runtime_error {
public:
    Timer_expired(const std::string& msg) : std::runtime_error(msg) {}
};

#endif
