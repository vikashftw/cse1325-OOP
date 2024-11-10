#include "Purse.h"
#include <map>
#include <string>
#include <iomanip>

int main() {
    std::cout << "Welcome to Ye Olde Bank of Merry England\n\n";

    std::map<std::string, Purse> vault;
    int accountCount;

    std::cout << "How many accounts? ";
    std::cin >> accountCount;
    std::cin.ignore();

    for (int i = 0; i < accountCount; ++i) {
        std::string accountName;
        Purse deposit;

        std::cout << "Name account " << i << ": ";
        std::getline(std::cin, accountName);

        std::cout << "Enter your initial deposit (#3 4s5d): ";
        std::cin >> deposit;
        std::cin.ignore();

        vault[accountName] = deposit;
        std::cout << "Account " << accountName << " created with " << vault[accountName] << "\n\n";
    }

    size_t maxWidth = 0;
    for (const auto& [name, _] : vault) {
        maxWidth = std::max(maxWidth, name.size());
    }

    std::cout << "\nAccount List\n============\n\n";
    Purse total(0, 0, 0);

    for (const auto& [name, purse] : vault) {
        std::cout << std::setw(maxWidth) << std::right << name << " with " << purse << "\n";
        total += purse;
    }

    std::cout << "\nTotal in bank is " << total << "\n";

    return 0;
}
