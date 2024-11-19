#include "date.h"

Date::Date(int year, int month, int day)
    : _year(year), _month(month), _day(day) {}

std::ostream& operator<<(std::ostream& ost, const Date& date) {
    char old_fill = ost.fill();
    
    ost << date._year << "/"
        << std::setw(2) << std::setfill('0') << date._month << "/"
        << std::setw(2) << std::setfill('0') << date._day;

    ost.fill(old_fill);

    return ost;
}