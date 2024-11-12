#include "Purse.h"

const std::string Purse::pound_utf8 = "£";

Purse::Purse(int pounds, int shillings, int pence)
    : _pounds(pounds), _shillings(shillings), _pence(pence) {
    rationalize();
}

void Purse::rationalize() {
    if (_pence >= 12) {
        _shillings += _pence / 12;
        _pence %= 12;
    }
    if (_shillings >= 20) {
        _pounds += _shillings / 20;
        _shillings %= 20;
    }
    if (_pence < 0) {
        _shillings -= (_pence / -12) + 1;
        _pence = (_pence % 12 + 12) % 12;
    }
    if (_shillings < 0) {
        _pounds -= (_shillings / -20) + 1;
        _shillings = (_shillings % 20 + 20) % 20;
    }
}

std::ostream& operator<<(std::ostream& ost, const Purse& purse) {
    ost << Purse::pound_utf8 << purse._pounds << " " << purse._shillings << "s" << purse._pence << "d";
    return ost;
}


std::istream& operator>>(std::istream& ist, Purse& purse) {
    std::string symbol;
    char first = ist.get();
    if (first == static_cast<char>(0xC2)) {
        char second = ist.get();
        if (second == static_cast<char>(0xA3)) {
            symbol = Purse::pound_utf8;
        }
    } else {
        ist.putback(first);
        ist >> symbol;
    }

    int pounds, shillings, pence;
    char shillingSymbol, penceSymbol;

    ist >> pounds >> shillings >> shillingSymbol >> pence >> penceSymbol;

    if ((symbol == Purse::pound_utf8) && shillingSymbol == 's' && penceSymbol == 'd') {
        purse._pounds = pounds;
        purse._shillings = shillings;
        purse._pence = pence;
        purse.rationalize();
    }
    return ist;
}

Purse& Purse::operator++() {
    ++_pence;
    rationalize();
    return *this;
}

Purse Purse::operator++(int) {
    Purse temp = *this;
    ++(*this);
    return temp;
}

Purse Purse::operator+(const Purse& other) const {
    Purse result(_pounds + other._pounds, _shillings + other._shillings, _pence + other._pence);
    result.rationalize();
    return result;
}

Purse Purse::operator-(const Purse& other) const {
    Purse result(_pounds - other._pounds, _shillings - other._shillings, _pence - other._pence);
    result.rationalize();
    return result;
}

Purse& Purse::operator+=(const Purse& other) {
    _pounds += other._pounds;
    _shillings += other._shillings;
    _pence += other._pence;
    rationalize();
    return *this;
}

Purse& Purse::operator-=(const Purse& other) {
    _pounds -= other._pounds;
    _shillings -= other._shillings;
    _pence -= other._pence;
    rationalize();
    return *this;
}
