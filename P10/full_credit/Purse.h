#ifndef __PURSE_H
#define __PURSE_H
#include <iostream>

class Purse {
    private:
        int _pounds;
        int _shillings;
        int _pence;
        void rationalize();
    
    public:
        Purse(int pounds, int shillings, int pence);
        friend std::ostream& operator<<(std::ostream& ost, const Purse& purse);
        auto operator<=>(const Purse& purse) const = default;
        Purse& operator++();    
        Purse operator++(int);  
        Purse operator+(const Purse& purse) const;
        Purse operator-(const Purse& purse) const;
        Purse& operator+=(const Purse& purse);
        Purse& operator-=(const Purse& purse);
};

#endif