#include "timer_expired.h"

Timer_expired::Timer_expired(const std::string& msg) : std::runtime_error(msg) {}