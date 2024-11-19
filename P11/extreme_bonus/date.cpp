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

std::istream& operator>>(std::istream& ist, Date& date) {
    char sep1, sep2;
    ist >> date._year >> sep1 >> date._month >> sep2 >> date._day;

    if (sep1 != '/' || sep2 != '/' || !ist) {
        ist.setstate(std::ios::failbit);
    }
    return ist;
}